/***************************************************************
Création des tables,séquences,vues,index, procédures , triggers
MAJ: XH
Oracle9i Release 9.2.0.1.0 - Production
JServer Release 9.2.0.1.0 - Production
***************************************************************/


/*==============================================================*/
/* Table : E_CONTINENT                                          */
/*==============================================================*/


create table E_CONTINENT  (
   continent_no       NUMBER(7)                        not null,
   nom                VARCHAR2(50),
   constraint PK_E_CONTINENT primary key (continent_no)
);

comment on column E_CONTINENT.continent_no is
'Numéro du continent';

comment on column E_CONTINENT.nom is
'Nom du continent';

/*==============================================================*/
/* Table : E_IMAGE                                              */
/*==============================================================*/


create table E_IMAGE  (
   image_no           NUMBER(7)                        not null,
   format             VARCHAR2(25),
   validite           VARCHAR2(1),
   nm_fichier         VARCHAR2(255),
   image              LONG RAW,
   constraint PK_E_IMAGE primary key (image_no)
);

/*==============================================================*/
/* Table : E_RESULTAT                                           */
/*==============================================================*/


create table E_RESULTAT  (
   code                 VARCHAR2(6)                        not null,
   lb_resultat        VARCHAR2(250),
   vl_resultat        NUMBER(9,2)
);

/*==============================================================*/
/* Table : E_SERVICE                                            */
/*==============================================================*/


create table E_SERVICE  (
   service_no         NUMBER(7)                        not null,
   continent_no       NUMBER(7),
   nom                VARCHAR2(25),
   constraint PK_E_SERVICE primary key (service_no),
   constraint FK_E_SERVIC_EST_IMPLA_E_CONTIN foreign key (continent_no)
         references E_CONTINENT (continent_no)
);

comment on table E_SERVICE is
'Service de la société';

comment on column E_SERVICE.continent_no is
'Numéro du continent';

comment on column E_SERVICE.nom is
'Nom du service';

/*==============================================================*/
/* Table : E_TEXTE                                              */
/*==============================================================*/


create table E_TEXTE  (
   texte_no           NUMBER(7)                        not null,
   validite           VARCHAR2(1),
   nm_fichier         VARCHAR2(255),
   texte              VARCHAR2(2000),
   constraint PK_E_TEXTE primary key (texte_no)
);

/*==============================================================*/
/* Table : E_TITRE                                              */
/*==============================================================*/


create table E_TITRE  (
   titre              VARCHAR2(25)                     not null,
   constraint PK_E_TITRE primary key (titre)
);

comment on table E_TITRE is
'Titres des employés';

comment on column E_TITRE.titre is
'Titre de l''employé';

/*==============================================================*/
/* Table : E_PRODUIT                                            */
/*==============================================================*/


create table E_PRODUIT  (
   produit_no         NUMBER(7)                        not null,
   image_no           NUMBER(7),
   texte_no           NUMBER(7),
   nom                VARCHAR2(50),
   description        VARCHAR2(255),
   prix_conseille     NUMBER(11,2),
   constraint PK_E_PRODUIT primary key (produit_no),
   constraint FK_E_PRODUI_CONCERNE__E_IMAGE foreign key (image_no)
         references E_IMAGE (image_no),
   constraint FK_E_PRODUI_CONCERNE__E_TEXTE foreign key (texte_no)
         references E_TEXTE (texte_no)
);

/*==============================================================*/
/* Table : E_EMP                                                */
/*==============================================================*/


create table E_EMP  (
   emp_no             NUMBER(7)                        not null,
   superieur_no         NUMBER(7),
   service_no         NUMBER(7),
   titre              VARCHAR2(25),
   nom                VARCHAR2(25),
   prenom             VARCHAR2(25),
   utilisateur        VARCHAR2(8),
   dt_entree          DATE,
   commentaires       VARCHAR2(255),
   salaire            NUMBER(11,2),
   pct_commission     NUMBER(4,2)                      
         constraint CKC_PCT_COMMISSION_E_EMP 
         check (pct_commission is null or pct_commission in ( 0, 10, 12.5, 15, 17.5, 20) ),
   constraint PK_E_EMP primary key (emp_no),
   constraint FK_E_EMP_QUALIFIE_E_TITRE foreign key (titre)
         references E_TITRE (titre),
   constraint FK_E_EMP_APPARTIEN_E_SERVIC foreign key (service_no)
         references E_SERVICE (service_no),
   constraint FK_E_EMP_ENCADRE_E_EMP foreign key (superieur_no)
         references E_EMP (emp_no)
);

comment on table E_EMP is
'Employés de l''entreprise';

comment on column E_EMP.emp_no is
'Numéro de l''employé';

comment on column E_EMP.superieur_no is
'Numéro de l''employé';

comment on column E_EMP.titre is
'Titre de l''employé';

comment on column E_EMP.nom is
'Nom de l''employé';

comment on column E_EMP.prenom is
'Prénom de l''employé';

comment on column E_EMP.dt_entree is
'Date d''embauche de l''employé';

comment on column E_EMP.pct_commission is
'Commission du vendeur sur la commande (en %)';

/*==============================================================*/
/* Table : E_ENTREPOT                                           */
/*==============================================================*/


create table E_ENTREPOT  (
   entrepot_no        NUMBER(7)                        not null,
   superieur_no             NUMBER(7),
   continent_no       NUMBER(7)                        not null,
   adresse            LONG,
   ville              VARCHAR2(30),
   departement        VARCHAR2(20),
   pays               VARCHAR2(30),
   cp_postal          VARCHAR2(75),
   telephone          VARCHAR2(25),
   constraint PK_E_ENTREPOT primary key (entrepot_no),
   constraint FK_E_ENTREP_SE_SITUE_E_CONTIN foreign key (continent_no)
         references E_CONTINENT (continent_no),
   constraint FK_E_ENTREP_RESPONSAB_E_EMP foreign key (superieur_no)
         references E_EMP (emp_no)
);

comment on column E_ENTREPOT.superieur_no is
'Numéro du responsable';

comment on column E_ENTREPOT.continent_no is
'Numéro du continent';

/*==============================================================*/
/* Table : E_STOCK                                              */
/*==============================================================*/


create table E_STOCK  (
   produit_no         NUMBER(7)                        not null,
   entrepot_no        NUMBER(7)                        not null,
   qte_stockee        NUMBER(9),
   stock_securite     NUMBER(9),
   max_stocke         NUMBER(9),
   detail_sortie      VARCHAR2(255),
   dt_stocke          DATE,
   constraint PK_E_STOCK primary key (produit_no, entrepot_no),
   constraint FK_E_STOCK_PRODUITS_E_PRODUI foreign key (produit_no)
         references E_PRODUIT (produit_no),
   constraint FK_E_STOCK_ENTREPOTS_E_ENTREP foreign key (entrepot_no)
         references E_ENTREPOT (entrepot_no)
);

comment on column E_STOCK.qte_stockee is
'Quantité en stock';

comment on column E_STOCK.detail_sortie is
'Détail explicatif de la dernière sortie';

comment on column E_STOCK.dt_stocke is
'Date du dernier approvisionnement du stock';

/*==============================================================*/
/* Table : E_CLIENT                                             */
/*==============================================================*/


create table E_CLIENT  (
   client_no          NUMBER(7)                        not null,
   continent_no       NUMBER(7),
   emp_no             NUMBER(7),
   nom                VARCHAR2(50),
   telephone          VARCHAR2(25),
   adresse            VARCHAR2(400),
   ville              VARCHAR2(30),
   departement        VARCHAR2(20),
   pays               VARCHAR2(30),
   cp_postal          VARCHAR2(75),
   solvabilite        VARCHAR2(9),
   commentaires       VARCHAR2(255),
   constraint PK_E_CLIENT primary key (client_no),
   constraint FK_E_CLIENT_HABITE_E_CONTIN foreign key (continent_no)
         references E_CONTINENT (continent_no),
   constraint FK_E_CLIENT_SUIT_E_EMP foreign key (emp_no)
         references E_EMP (emp_no)
);

comment on table E_CLIENT is
'Clients de l''entreprise';

comment on column E_CLIENT.client_no is
'Numéro du client';

comment on column E_CLIENT.continent_no is
'Numéro du continent';

comment on column E_CLIENT.emp_no is
'Numéro de l''employé';

/*==============================================================*/
/* Table : E_COMMANDE                                           */
/*==============================================================*/


create table E_COMMANDE  (
   commande_no        NUMBER(7)                        not null,
   client_no          NUMBER(7)                        not null,
   emp_no             NUMBER(7),
   dt_commande        DATE,
   dt_livraison       DATE,
   total              NUMBER(11,2),
   nt_paiement        VARCHAR2(8),
   validite           VARCHAR2(1),
   constraint PK_E_COMMANDE primary key (commande_no),
   constraint FK_E_COMMAN_PASSE_E_CLIENT foreign key (client_no)
         references E_CLIENT (client_no),
   constraint FK_E_COMMAN_ENREGISTR_E_EMP foreign key (emp_no)
         references E_EMP (emp_no)
);

comment on column E_COMMANDE.client_no is
'Numéro du client';

comment on column E_COMMANDE.emp_no is
'Numéro de l''employé';

comment on column E_COMMANDE.nt_paiement is
'Notification de paiement';

/*==============================================================*/
/* Table : E_ARTICLE                                            */
/*==============================================================*/


create table E_ARTICLE  (
   commande_no        NUMBER(7)                        not null,
   article_no         NUMBER(7)                        not null,
   produit_no         NUMBER(7)                        not null,
   prix               NUMBER(11,2),
   quantite           NUMBER(9),
   qte_livree         NUMBER(9),
   constraint PK_E_ARTICLE primary key (commande_no, article_no),
   constraint FK_E_ARTICL_COMPOSE_E_COMMAN foreign key (commande_no)
         references E_COMMANDE (commande_no),
   constraint FK_E_ARTICL_CONTIENT_E_PRODUI foreign key (produit_no)
         references E_PRODUIT (produit_no)
);


prompt
prompt
prompt
Prompt ******************************
prompt INTERROGATION DU DICTIONNAIRE
prompt Recapitulatif des Objets créés
Prompt ******************************
select * from user_catalog;
prompt
prompt
prompt
prompt ************************************
prompt    INTERROGATION DU DICTIONNAIRE
prompt Recapitulatif des contraintes posées
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

