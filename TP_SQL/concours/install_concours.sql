--/***************************************************************
--Script install_concours.sql
--***************************************************************/

-- Comportement recherch�: sortir en cas d'erreur SQL
WHENEVER SQLERROR exit rollback
/*==============================================================*/
/* Table : "Race"                                               */
/*==============================================================*/
create table "Race" 
(
   "noRace"             INTEGER              not null,
   "nomRace"            VARCHAR2(50),
   constraint PK_RACE primary key ("noRace")
);
/*==============================================================*/
/* Table : "Proprietaire"                                       */
/*==============================================================*/
create table "Proprietaire" 
(
   "noProprietaire"     INTEGER              not null,
   "nomProprietaire"    VARCHAR2(50),
   "prenomProprietaire" VARCHAR2(50),
   "adresseProprietaire" VARCHAR2(254),
   constraint PK_PROPRIETAIRE primary key ("noProprietaire")
);
/*==============================================================*/
/* Table : "Chien"                                              */
/*==============================================================*/
create table "Chien" 
(
   "noTatouage"         INTEGER              not null,
   "noRace"             INTEGER              not null,
   "noProprietaire"     INTEGER              not null,
   "nomChien"           VARCHAR2(50),
   "dateNaissance"      DATE,
   constraint PK_CHIEN primary key ("noTatouage"),
   constraint FK_CHIEN_APPARTENI_RACE foreign key ("noRace")
         references "Race" ("noRace"),
   constraint FK_CHIEN_ELEVER_PROPRIET foreign key ("noProprietaire")
         references "Proprietaire" ("noProprietaire")
);
/*==============================================================*/
/* Table : "Ville"                                              */
/*==============================================================*/
create table "Ville" 
(
   "noVille"            INTEGER              not null,
   "nomVille"           VARCHAR2(50),
   constraint PK_VILLE primary key ("noVille")
);
/*==============================================================*/
/* Table : "TypeConcours"                                       */
/*==============================================================*/
create table "TypeConcours" 
(
   "noTypeConcours"     INTEGER              not null,
   "nomTypeConcours"    VARCHAR2(8),
   constraint PK_TYPECONCOURS primary key ("noTypeConcours")
);
/*==============================================================*/
/* Table : "Concours"                                           */
/*==============================================================*/
create table "Concours" 
(
   "noConcours"         INTEGER              not null,
   "noVille"            INTEGER              not null,
   "noTypeConcours"     INTEGER              not null,
   "dateConcours"       DATE                 not null,
   constraint PK_CONCOURS primary key ("noConcours"),
   constraint FK_CONCOURS_DEROULERD_VILLE foreign key ("noVille")
         references "Ville" ("noVille"),
   constraint FK_CONCOURS_CATEGORIS_TYPECONC foreign key ("noTypeConcours")
         references "TypeConcours" ("noTypeConcours")
);
/*==============================================================*/
/* Table : GAGNER                                               */
/*==============================================================*/
create table GAGNER 
(
   "noTatouage"         INTEGER              not null,
   "noConcours"         INTEGER              not null,
   "nbPoints"              INTEGER             
      constraint CKC_SCORE_GAGNER check ("nbPoints" is null or ("nbPoints" in (1,2,3,4,5))),
   "libelle"            VARCHAR2(20),
   constraint PK_GAGNER primary key ("noTatouage", "noConcours"),
   constraint FK_GAGNER_GAGNER_CHIEN foreign key ("noTatouage")
         references "Chien" ("noTatouage"),
   constraint FK_GAGNER_GAGNER_CONCOURS foreign key ("noConcours")
         references "Concours" ("noConcours")
);
comment on table GAGNER is
'Un chien peut gagner plusieurs concours.
Un concours poss�de un � plusieurs gagnants.';
/*==============================================================*/
/* Table : "participer"                                         */
/*==============================================================*/
create table "participer" 
(
   "noTatouage"         INTEGER              not null,
   "noConcours"         INTEGER              not null,
   constraint PK_PARTICIPER primary key ("noTatouage", "noConcours"),
   constraint FK_PARTICIP_PARTICIPE_CHIEN foreign key ("noTatouage")
         references "Chien" ("noTatouage"),
   constraint FK_PARTICIP_PARTICIPE_CONCOURS foreign key ("noConcours")
         references "Concours" ("noConcours")
);
comment on table "participer" is
'Un chien peut participer � plusieurs concours.
Un concours accueille un � plusieurs chiens.';

--*******************************************
--
--  Divers requ�tes d'interrogation du dictionnaire
--
--*******************************************
SELECT TABLE_NAME 
FROM USER_TABLES;

--Select username from user_users;--equivalent �: select user from dual;
--Select username from dba_users;

prompt
prompt
prompt
Prompt ******************************
prompt INTERROGATION DU DICTIONNAIRE
prompt Recapitulatif des Objets cr��s
Prompt ******************************
select * from user_catalog;
prompt
prompt
prompt
prompt ************************************
prompt    INTERROGATION DU DICTIONNAIRE
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
