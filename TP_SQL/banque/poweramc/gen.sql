/*==============================================================*/
/* Nom de SGBD :  ORACLE Version 11g                            */
/* Date de création :  24/02/2022 10:54:08                      */
/*==============================================================*/


alter table "Chien"
   drop constraint FK_CHIEN_APPARTENI_RACE;

alter table "Chien"
   drop constraint FK_CHIEN_ELEVER_PROPRIET;

alter table "Concours"
   drop constraint FK_CONCOURS_CATEGORIS_TYPECONC;

alter table "Concours"
   drop constraint FK_CONCOURS_DEROULERD_VILLE;

alter table GAGNER
   drop constraint FK_GAGNER_GAGNER_CHIEN;

alter table GAGNER
   drop constraint FK_GAGNER_GAGNER_CONCOURS;

alter table "participer"
   drop constraint FK_PARTICIP_PARTICIPE_CHIEN;

alter table "participer"
   drop constraint FK_PARTICIP_PARTICIPE_CONCOURS;

drop index ELEVER_FK;

drop index APPARTENIR_FK;

drop table "Chien" cascade constraints;

drop index CATEGORISER_FK;

drop index DEROULERDANS_FK;

drop table "Concours" cascade constraints;

drop index GAGNER_FK2;

drop index GAGNER_FK;

drop table GAGNER cascade constraints;

drop table "Proprietaire" cascade constraints;

drop table "Race" cascade constraints;

drop table "TypeConcours" cascade constraints;

drop table "Ville" cascade constraints;

drop index PARTICIPER_FK2;

drop index PARTICIPER_FK;

drop table "participer" cascade constraints;

/*==============================================================*/
/* Table : "Chien"                                              */
/*==============================================================*/
create table "Chien" 
(
   "noTatouage"         INTEGER              not null,
   "noProprietaire"     INTEGER              not null,
   "noRace"             INTEGER              not null,
   "nomChien"           VARCHAR2(50),
   "dateNaissance"      DATE,
   constraint PK_CHIEN primary key ("noTatouage")
);

/*==============================================================*/
/* Index : APPARTENIR_FK                                        */
/*==============================================================*/
create index APPARTENIR_FK on "Chien" (
   "noRace" ASC
);

/*==============================================================*/
/* Index : ELEVER_FK                                            */
/*==============================================================*/
create index ELEVER_FK on "Chien" (
   "noProprietaire" ASC
);

/*==============================================================*/
/* Table : "Concours"                                           */
/*==============================================================*/
create table "Concours" 
(
   "noConcours"         INTEGER              not null,
   "noVille"            INTEGER              not null,
   "noTypeConcours"     INTEGER,
   "dateConcours"       INTEGER,
   constraint PK_CONCOURS primary key ("noConcours")
);

/*==============================================================*/
/* Index : DEROULERDANS_FK                                      */
/*==============================================================*/
create index DEROULERDANS_FK on "Concours" (
   "noVille" ASC
);

/*==============================================================*/
/* Index : CATEGORISER_FK                                       */
/*==============================================================*/
create index CATEGORISER_FK on "Concours" (
   "noTypeConcours" ASC
);

/*==============================================================*/
/* Table : GAGNER                                               */
/*==============================================================*/
create table GAGNER 
(
   "noTatouage"         INTEGER              not null,
   "noConcours"         INTEGER              not null,
   "score"              INTEGER,
   "libelle"            VARCHAR2(20),
   constraint PK_GAGNER primary key ("noTatouage", "noConcours")
);

comment on table GAGNER is
'Un chien peut gagner plusieurs concours.
Un concours possède un à plusieurs gagnants.';

/*==============================================================*/
/* Index : GAGNER_FK                                            */
/*==============================================================*/
create index GAGNER_FK on GAGNER (
   "noTatouage" ASC
);

/*==============================================================*/
/* Index : GAGNER_FK2                                           */
/*==============================================================*/
create index GAGNER_FK2 on GAGNER (
   "noConcours" ASC
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
/* Table : "Race"                                               */
/*==============================================================*/
create table "Race" 
(
   "noRace"             INTEGER              not null,
   "nomRace"            VARCHAR2(50),
   constraint PK_RACE primary key ("noRace")
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
/* Table : "Ville"                                              */
/*==============================================================*/
create table "Ville" 
(
   "noVille"            INTEGER              not null,
   "nomVille"           INTEGER,
   constraint PK_VILLE primary key ("noVille")
);

/*==============================================================*/
/* Table : "participer"                                         */
/*==============================================================*/
create table "participer" 
(
   "noTatouage"         INTEGER              not null,
   "noConcours"         INTEGER              not null,
   constraint PK_PARTICIPER primary key ("noTatouage", "noConcours")
);

comment on table "participer" is
'Un chien peut participer à plusieurs concours.
Un concours accueille un à plusieurs chiens.';

/*==============================================================*/
/* Index : PARTICIPER_FK                                        */
/*==============================================================*/
create index PARTICIPER_FK on "participer" (
   "noTatouage" ASC
);

/*==============================================================*/
/* Index : PARTICIPER_FK2                                       */
/*==============================================================*/
create index PARTICIPER_FK2 on "participer" (
   "noConcours" ASC
);

alter table "Chien"
   add constraint FK_CHIEN_APPARTENI_RACE foreign key ("noRace")
      references "Race" ("noRace");

alter table "Chien"
   add constraint FK_CHIEN_ELEVER_PROPRIET foreign key ("noProprietaire")
      references "Proprietaire" ("noProprietaire");

alter table "Concours"
   add constraint FK_CONCOURS_CATEGORIS_TYPECONC foreign key ("noTypeConcours")
      references "TypeConcours" ("noTypeConcours");

alter table "Concours"
   add constraint FK_CONCOURS_DEROULERD_VILLE foreign key ("noVille")
      references "Ville" ("noVille");

alter table GAGNER
   add constraint FK_GAGNER_GAGNER_CHIEN foreign key ("noTatouage")
      references "Chien" ("noTatouage");

alter table GAGNER
   add constraint FK_GAGNER_GAGNER_CONCOURS foreign key ("noConcours")
      references "Concours" ("noConcours");

alter table "participer"
   add constraint FK_PARTICIP_PARTICIPE_CHIEN foreign key ("noTatouage")
      references "Chien" ("noTatouage");

alter table "participer"
   add constraint FK_PARTICIP_PARTICIPE_CONCOURS foreign key ("noConcours")
      references "Concours" ("noConcours");

