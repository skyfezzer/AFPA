/*==============================================================*/
/* Nom de SGBD :  ORACLE Version 11g                            */
/* Date de cr?ation :  24/02/2022 15:06:01                      */
/*==============================================================*/


alter table GAGNER
   drop constraint FK_GAGNER_GAGNER_CHIEN;

alter table GAGNER
   drop constraint FK_GAGNER_GAGNER_CONCOURS;

alter table "participer"
   drop constraint FK_PARTICIP_PARTICIPE_CHIEN;

alter table "participer"
   drop constraint FK_PARTICIP_PARTICIPE_CONCOURS;

drop table "Chien" cascade constraints;

drop table "Concours" cascade constraints;

drop table GAGNER cascade constraints;

drop table "Proprietaire" cascade constraints;

drop table "Race" cascade constraints;

drop table "TypeConcours" cascade constraints;

drop table "Ville" cascade constraints;

drop table "participer" cascade constraints;

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
   "nbPoints"           INTEGER             
      constraint CKC_NBPOINTS_GAGNER check ("nbPoints" is null or ("nbPoints" in (1,2,3,4,5))),
   "libelle"            VARCHAR2(20),
   constraint PK_GAGNER primary key ("noTatouage", "noConcours"),
   constraint FK_GAGNER_GAGNER_CHIEN foreign key ("noTatouage")
         references "Chien" ("noTatouage"),
   constraint FK_GAGNER_GAGNER_CONCOURS foreign key ("noConcours")
         references "Concours" ("noConcours")
);

comment on table GAGNER is
'Un chien peut gagner plusieurs concours.
Un concours poss?de un ? plusieurs gagnants.';

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
'Un chien peut participer ? plusieurs concours.
Un concours accueille un ? plusieurs chiens.';

