--==============================================================
--Nom de la base :  xxxxxxxx                                     
--Fichier          : xxxxxxx.sql                    
--==============================================================
/*==============================================================*/
/* Table : Utilisateur                                        */
/*==============================================================*/
create table Utilisateur 
(
   noPersonne         INTEGER              not null,
   nom                VARCHAR2(30),
   prenom             VARCHAR2(30),
   employe            SMALLINT,
   constraint PK_UTILISATEUR primary key (noPersonne)
);

comment on table Utilisateur is
'Cette classe conceptualise un utilisateur de la bibliotheque';

/*==============================================================*/
/* Table : Adherent                                           */
/*==============================================================*/
create table Adherent 
(
   noPersonne         INTEGER              not null,
   noTelAdherent      VARCHAR2(15),
   pin                VARCHAR2(15),
   constraint PK_ADHERENT primary key (noPersonne),
   constraint FK_ADHERENT_GENERALIS_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne)
);

/*==============================================================*/
/* Table : Auteur                                             */
/*==============================================================*/
create table Auteur 
(
   noAuteur           INTEGER              not null,
   nomCompletAuteur   VARCHAR2(63),
   constraint PK_AUTEUR primary key (noAuteur)
);

/*==============================================================*/
/* Table : Bibliotheque                                       */
/*==============================================================*/
create table Bibliotheque 
(
   noBibliotheque     INTEGER              not null,
   adresse            VARCHAR2(254),
   constraint PK_BIBLIOTHEQUE primary key (noBibliotheque)
);

/*==============================================================*/
/* Table : Dette                                              */
/*==============================================================*/
create table Dette 
(
   noDette            INTEGER              not null,
   noPersonne         INTEGER              not null,
   montantDette       FLOAT               
      constraint CKC_MONTANTDETTE_DETTE check (montantDette is null or (montantDette >= 0)),
   motifDette         VARCHAR2(254),
   dateDette          DATE,
   constraint PK_DETTE primary key (noDette),
   constraint FK_DETTE_PUNIR_ADHERENT foreign key (noPersonne)
         references Adherent (noPersonne)
);

comment on table Dette is
'Cette classe conceptualise les dettes (amendes).';

/*==============================================================*/
/* Table : Theme                                              */
/*==============================================================*/
create table Theme 
(
   noTheme            VARCHAR2(15)         not null,
   intituleTheme      VARCHAR2(150),
   noThemeParent      VARCHAR2(15),
   constraint PK_THEME primary key (noTheme),
   constraint FK_THEMEPARENT_CONTIENT_THEME foreign key (noThemeParent) REFERENCES THEME (noTheme)
);

/*==============================================================*/
/* Table : Emplacement                                        */
/*==============================================================*/
create table Emplacement 
(
   noEmplacement      INTEGER              not null,
   noBibliotheque     INTEGER              not null,
   noTheme            VARCHAR2(15)         not null,
   constraint PK_EMPLACEMENT primary key (noEmplacement),
   constraint FK_EMPLACEM_LOCALISER_BIBLIOTH foreign key (noBibliotheque)
         references Bibliotheque (noBibliotheque),
   constraint FK_EMPLACEM_TRIER_THEME foreign key (noTheme)
         references Theme (noTheme)
);

/*==============================================================*/
/* Table : Employe                                            */
/*==============================================================*/
create table Employe 
(
   noPersonne         INTEGER              not null,
   noBibliotheque     INTEGER              not null,
   gradeEmploye       VARCHAR2(15),
   constraint PK_EMPLOYE primary key (noPersonne),
   constraint FK_EMPLOYE_TRAVAILLE_BIBLIOTH foreign key (noBibliotheque)
         references Bibliotheque (noBibliotheque),
   constraint FK_EMPLOYE_GENERALIS_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne)
);

/*==============================================================*/
/* Table : Livre                                              */
/*==============================================================*/
create table Livre 
(
   iSBNLivre          INTEGER              not null,
   noTheme            VARCHAR2(15)         not null,
   noAuteur           INTEGER              not null,
   titreLivre         VARCHAR2(150),
   constraint PK_LIVRE primary key (iSBNLivre),
   constraint FK_LIVRE_CORRESPON_THEME foreign key (noTheme)
         references Theme (noTheme),
   constraint FK_LIVRE_ECRIRE_AUTEUR foreign key (noAuteur)
         references Auteur (noAuteur)
);

/*==============================================================*/
/* Table : Exemplaire                                         */
/*==============================================================*/
create table Exemplaire 
(
   iSBNLivre          INTEGER              not null,
   codeExemplaire     SMALLINT             not null,
   noEmplacement      INTEGER,
   commentaireExemplaire VARCHAR2(150),
   constraint PK_EXEMPLAIRE primary key (iSBNLivre, codeExemplaire),
   constraint FK_EXEMPLAI_MATERIALI_LIVRE foreign key (iSBNLivre)
         references Livre (iSBNLivre),
   constraint FK_EXEMPLAI_RANGER_EMPLACEM foreign key (noEmplacement)
         references Emplacement (noEmplacement)
);

comment on table Exemplaire is
'Cette classe conceptualise l''exemplaire d''un livre.';

/*==============================================================*/
/* Table : Pret                                               */
/*==============================================================*/
create table Pret 
(
   noPret             INTEGER              not null,
   dateEmprunt        DATE                 not null,
   codeExemplaire     SMALLINT             not null,
   iSBNLivre          INTEGER              not null,
   noPersonne         INTEGER              not null,
   dureePret          INTEGER,
   constraint PK_PRET primary key (noPret),
   constraint FK_PRET_ATTRIBUER_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne),
   constraint FK_PRET_CONCERNER_EXEMPLAI foreign key (iSBNLivre, codeExemplaire)
         references Exemplaire (iSBNLivre, codeExemplaire)
);

comment on table Pret is
'Cette classe conceptualise les prêts d''exemplaires.';

/*==============================================================*/
/* Table : HistoPret                                          */
/*==============================================================*/
create table HistoPret 
(
   noHisto            INTEGER              not null,
   noPret             INTEGER              not null,
   dateRemise         DATE,
   constraint PK_HISTOPRET primary key (noHisto),
   constraint FK_HISTOPRE_STOCKER_PRET foreign key (noPret)
         references Pret (noPret)
);

comment on table HistoPret is
'Cette classe conceptualise la fin d''un prêt';


/*==============================================================*/
/* Table : Paiement                                           */
/*==============================================================*/
create table Paiement 
(
   noPaiement         INTEGER              not null,
   noDette            INTEGER,
   montantPaiement    FLOAT               
      constraint CKC_MONTANTPAIEMENT_PAIEMENT check (montantPaiement is null or (montantPaiement >= 0)),
   datePaiement       DATE,
   typePaiement       VARCHAR2(5)         
      constraint CKC_TYPEPAIEMENT_PAIEMENT check (typePaiement is null or (typePaiement in ('DETTE','COTIS'))),
   constraint PK_PAIEMENT primary key (noPaiement),
   constraint FK_PAIEMENT_PAYER_DETTE foreign key (noDette)
         references Dette (noDette)
);

comment on table Paiement is
'Cette classe conceptualise les paiements de cotisations ainsi que les amendes.';


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
