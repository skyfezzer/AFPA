--==============================================================
--Nom de la base :  xxxxxxxx                                      
--Fichier          :  install_data_livraison.sql               
--==============================================================

-- On n'interprete pas les &  comme variable de substitution
set define off

-- affichage des substitutions de variable
SET VERIFY ON

--Script de suppression des données
delete from DetailLivraison;
delete from LigneCommande;
delete from Commande;
delete from Article;
delete from Livraison;
delete from Client;
commit;


ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';

--INSERT INTO Commande VALUES(1,'01/06/2000 01:11:11',10)/

INSERT INTO Article
 	VALUES(10,'Cédre en boule',10.99,10);
INSERT INTO Article
 	VALUES(20,'Sapin',12.99,10);
INSERT INTO Article
 	VALUES(40,'épinette bleue',25.99,10);
INSERT INTO Article
 	VALUES(50,'Chéne',22.99,10);
INSERT INTO Article
 	VALUES(60,'érable argenté',15.99,10);
INSERT INTO Article
 	VALUES(70,'Herbe à puce',10.99,10);
INSERT INTO Article
 	VALUES(80,'Poirier',26.99,10);
INSERT INTO Article
 	VALUES(81,'Catalpa',25.99,10);
INSERT INTO Article
 	VALUES(90,'Pommier',25.99,10);
INSERT INTO Article
 	VALUES(95,'Génévrier',15.99,10);


INSERT INTO Livraison
 	VALUES(seq_livraison.nextval,'03/06/2000');
INSERT INTO Livraison
 	VALUES(seq_livraison.nextval,'04/06/2000');
INSERT INTO Livraison
 	VALUES(seq_livraison.nextval,'04/06/2000');
INSERT INTO Livraison
 	VALUES(seq_livraison.nextval,'05/06/2000');
INSERT INTO Livraison
 	VALUES(seq_livraison.nextval,'07/07/2000');
INSERT INTO Livraison
 	VALUES(seq_livraison.nextval,'09/07/2000');


INSERT INTO Client
 	VALUES(10,'Luc Sansom','(999)999-9999');
INSERT INTO Client
 	VALUES(20,'Dollard Tremblay','(888)888-8888');
INSERT INTO Client
 	VALUES(30,'Lin Bé','(777)777-7777');
INSERT INTO Client
 	VALUES(40,'Jean Leconte','(666)666-6666');
INSERT INTO Client
 	VALUES(50,'Hafed Alaoui','(555)555-5555');
INSERT INTO Client
 	VALUES(60,'Marie Leconte','(666)666-6666');
INSERT INTO Client
 	VALUES(70,'Simon Lecoq','(444)444-4419');
INSERT INTO Client
 	VALUES(80,'Dollard Tremblay','(333)333-3333');


INSERT INTO Commande VALUES( 1, TO_DATE('01/06/2000 01:11:11', 'DD/MM/YYYY HH24:MI:SS'), 10 );
INSERT INTO Commande VALUES(2,TO_DATE('02/06/2000 02:22:22', 'DD/MM/YYYY HH24:MI:SS'),20);
INSERT INTO Commande 
 	VALUES(3,TO_DATE('02/06/2000 03:33:33', 'DD/MM/YYYY HH24:MI:SS'),10);
INSERT INTO Commande 
 	VALUES(4,TO_DATE('05/07/2000 04:44:44', 'DD/MM/YYYY HH24:MI:SS'),10);
INSERT INTO Commande 
 	VALUES(5,TO_DATE('09/07/2000 05:55:55', 'DD/MM/YYYY HH24:MI:SS'),30);
INSERT INTO Commande 
 	VALUES(6,TO_DATE('09/07/2000 06:06:06', 'DD/MM/YYYY HH24:MI:SS'),20);
INSERT INTO Commande 
 	VALUES(7,TO_DATE('15/07/2000 07:07:07', 'DD/MM/YYYY HH24:MI:SS'),40);
INSERT INTO Commande 
 	VALUES(8,TO_DATE('15/07/2000 08:08:08', 'DD/MM/YYYY HH24:MI:SS'),40);


INSERT INTO LigneCommande 
 	VALUES(1,10,10);
INSERT INTO LigneCommande 
 	VALUES(1,70,5);
INSERT INTO LigneCommande 
 	VALUES(1,90,1);
INSERT INTO LigneCommande 
 	VALUES(2,40,2);
INSERT INTO LigneCommande 
 	VALUES(2,95,3);
INSERT INTO LigneCommande 
 	VALUES(3,20,1);
INSERT INTO LigneCommande 
 	VALUES(4,40,1);
INSERT INTO LigneCommande 
 	VALUES(4,50,1);
INSERT INTO LigneCommande 
 	VALUES(5,70,3);
INSERT INTO LigneCommande 
 	VALUES(5,10,5);
INSERT INTO LigneCommande 
 	VALUES(5,20,5);
INSERT INTO LigneCommande 
 	VALUES(6,10,5);
INSERT INTO LigneCommande 
 	VALUES(6,40,1);
INSERT INTO LigneCommande 
 	VALUES(7,50,1);
INSERT INTO LigneCommande
 	VALUES(8,20,3);


INSERT INTO DetailLivraison
 	VALUES(100,1,10,7);
INSERT INTO DetailLivraison
 	VALUES(100,1,70,5);
INSERT INTO DetailLivraison
 	VALUES(101,1,10,3);
INSERT INTO DetailLivraison
 	VALUES(102,2,40,2);
INSERT INTO DetailLivraison
 	VALUES(102,2,95,1);
INSERT INTO DetailLivraison
 	VALUES(100,3,20,1);
INSERT INTO DetailLivraison
 	VALUES(103,1,90,1);
INSERT INTO DetailLivraison
 	VALUES(104,4,40,1);
INSERT INTO DetailLivraison
 	VALUES(105,5,70,2);
	 
	
COMMIT;

-- On interprete  les &  comme variable de substitution
set define on
