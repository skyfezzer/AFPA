--==============================================================
--Nom de la base :  xxxxxxxx                                     
--Fichier          : xxxxxxx.sql                    
--==============================================================
CREATE TABLE Article
(noArticle 		INTEGER NOT NULL,
 description 	VARCHAR(20),
 prixUnitaire 	DECIMAL(10,2) NOT NULL CHECK (prixUnitaire >= 0),
 quantiteEnStock	INTEGER		DEFAULT 0 NOT NULL CHECK (quantiteEnStock >= 0),
 CONSTRAINT PK_ARTICLE PRIMARY KEY (noArticle)
);
CREATE TABLE Client
(noClient 		INTEGER NOT NULL,
 nomClient 		VARCHAR(20) NOT NULL,
 noTelephone 	VARCHAR(15) NOT NULL,
 CONSTRAINT PK_CLIENT PRIMARY KEY (noClient)
);
CREATE SEQUENCE seq_livraison MINVALUE 100;
CREATE TABLE Livraison
(noLivraison 	INTEGER NOT NULL,
 dateLivraison	DATE NOT NULL,
 CONSTRAINT PK_LIVRAISON PRIMARY KEY (noLivraison)
);
CREATE TABLE Commande
(noCommande 	INTEGER NOT NULL,
 dateCommande	DATE NOT NULL,
 noClient		INTEGER NOT NULL,
 CONSTRAINT PK_COMMANDE PRIMARY KEY (noCommande),
 CONSTRAINT FK_COMMANDE_CLIENT FOREIGN KEY (noClient) REFERENCES CLIENT (noClient)
);
CREATE TABLE LigneCommande
(noCommande 	INTEGER NOT NULL,
 noArticle 		INTEGER NOT NULL,
 quantite 		INTEGER NOT NULL CHECK (quantite >= 0),
 CONSTRAINT PK_LIGNECOMMANDE PRIMARY KEY (noCommande,noArticle),
 CONSTRAINT FK_LIGNECOMMANDE_COMMANDE FOREIGN KEY (noCommande) REFERENCES COMMANDE (noCommande),
 CONSTRAINT FK_LIGNECOMMANDE_ARTICLE FOREIGN KEY (noArticle) REFERENCES ARTICLE (noArticle)
);
CREATE TABLE DetailLivraison
(noLivraison 	INTEGER NOT NULL,
 noCommande 	INTEGER NOT NULL,
 noArticle 		INTEGER NOT NULL,
 quantiteLivree	INTEGER NOT NULL CHECK (quantiteLivree >= 0),
 CONSTRAINT PK_DETAILLIVRAISON PRIMARY KEY (noLivraison,noCommande,noArticle),
 CONSTRAINT FK_DETAILLIVRAISON_LIGNECOMMANDE FOREIGN KEY (noCommande,noArticle) REFERENCES LigneCommande (noCommande,noArticle),
 CONSTRAINT FK_DETAILLIVRAISON_LIVRAISON FOREIGN KEY (noLivraison) REFERENCES Livraison (noLivraison)
);





prompt
prompt
prompt
Prompt ******************************
prompt Recapitulatif des Objets cr��s
Prompt ******************************
select * from user_catalog;
prompt
prompt
prompt
prompt ************************************
prompt Recapitulatif des contraintes pos�es
prompt ************************************

column constraint_name format A20
column type format A3
column table_name format A15
column SEARCH_CONDITION format A30

break on type skip 
compute count of constraint_name on type report
select  constraint_name, Constraint_type as type,
        table_name , SEARCH_CONDITION, DELETE_RULE, STATUS
from user_constraints
order by type, table_name;


clear columns
clear breaks
clear computes
