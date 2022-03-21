/*==============================================================*/
/* Nom de SGBD :  ORACLE Version 11g                            */
/* Date de cr�ation :  07/03/2022 16:53:07                      */
/*==============================================================*/


alter table Amende
   drop constraint FK_AMENDE_PAYER_PAIEMENT;

alter table Amende
   drop constraint FK_AMENDE_PUNIR_ADHERENT;

alter table Emplacement
   drop constraint FK_EMPLACEM_TRIER_THEME;

alter table Exemplaire
   drop constraint FK_EXEMPLAI_MATERIALI_LIVRE;

alter table HistoPret
   drop constraint FK_HISTOPRE_STOCKER_PRET;

alter table Livre
   drop constraint FK_LIVRE_ECRIRE_AUTEUR;

alter table Pret
   drop constraint FK_PRET_CONCERNER_EXEMPLAI;

drop table Adherent cascade constraints;

drop table Amende cascade constraints;

drop table Auteur cascade constraints;

drop table Emplacement cascade constraints;

drop table Employe cascade constraints;

drop table Exemplaire cascade constraints;

drop table HistoPret cascade constraints;

drop table Livre cascade constraints;

drop table Paiement cascade constraints;

drop table Personne cascade constraints;

drop table Pret cascade constraints;

drop table Theme cascade constraints;

drop table Utilisateur cascade constraints;

/*==============================================================*/
/* Table : Personne                                           */
/*==============================================================*/
create table Personne 
(
   noPersonne         INTEGER              not null,
   nom                VARCHAR2(31),
   prenom             VARCHAR2(31),
   constraint PK_PERSONNE primary key (noPersonne)
);

/*==============================================================*/
/* Table : Utilisateur                                        */
/*==============================================================*/
create table Utilisateur 
(
   noPersonne         INTEGER              not null,
   constraint PK_UTILISATEUR primary key (noPersonne),
   constraint FK_UTILISAT_GENERALIS_PERSONNE foreign key (noPersonne)
         references Personne (noPersonne)
);

/*==============================================================*/
/* Table : Adherent                                           */
/*==============================================================*/
create table Adherent 
(
   noPersonne         INTEGER              not null,
   noTelAdherent      VARCHAR2(14),
   constraint PK_ADHERENT primary key (noPersonne),
   constraint FK_ADHERENT_GENERALIS_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne)
);

/*==============================================================*/
/* Table : Paiement                                           */
/*==============================================================*/
create table Paiement 
(
   noPaiement         INTEGER              not null,
   montantPaiement    FLOAT               
      constraint CKC_MONTANTPAIEMENT_PAIEMENT check (montantPaiement is null or (montantPaiement >= 0)),
   datePaiement       DATE,
   typePaiement       VARCHAR2(15)        
      constraint CKC_TYPEPAIEMENT_PAIEMENT check (typePaiement is null or (typePaiement in ('AMENDE','COTISATION'))),
   constraint PK_PAIEMENT primary key (noPaiement)
);

/*==============================================================*/
/* Table : Amende                                             */
/*==============================================================*/
create table Amende 
(
   noAmende           INTEGER              not null,
   noPaiement         INTEGER,
   noPersonne         INTEGER              not null,
   montantAmende      FLOAT               
      constraint CKC_MONTANTAMENDE_AMENDE check (montantAmende is null or (montantAmende >= 0)),
   motifAmende        VARCHAR2(127),
   dateAmende         DATE,
   constraint PK_AMENDE primary key (noAmende),
   constraint FK_AMENDE_PAYER_PAIEMENT foreign key (noPaiement)
         references Paiement (noPaiement),
   constraint FK_AMENDE_PUNIR_ADHERENT foreign key (noPersonne)
         references Adherent (noPersonne)
);

/*==============================================================*/
/* Table : Auteur                                             */
/*==============================================================*/
create table Auteur 
(
   noPersonne         INTEGER              not null,
   constraint PK_AUTEUR primary key (noPersonne),
   constraint FK_AUTEUR_GENERALIS_PERSONNE foreign key (noPersonne)
         references Personne (noPersonne)
);

/*==============================================================*/
/* Table : Theme                                              */
/*==============================================================*/
create table Theme 
(
   noTheme            INTEGER              not null,
   intituleTheme      VARCHAR2(63),
   constraint PK_THEME primary key (noTheme)
);

/*==============================================================*/
/* Table : Emplacement                                        */
/*==============================================================*/
create table Emplacement 
(
   noEmplacement      INTEGER              not null,
   noTheme            INTEGER              not null,
   constraint PK_EMPLACEMENT primary key (noEmplacement),
   constraint FK_EMPLACEM_TRIER_THEME foreign key (noTheme)
         references Theme (noTheme)
);

/*==============================================================*/
/* Table : Employe                                            */
/*==============================================================*/
create table Employe 
(
   noPersonne         INTEGER              not null,
   gradeEmploye       VARCHAR2(31),
   constraint PK_EMPLOYE primary key (noPersonne),
   constraint FK_EMPLOYE_GENERALIS_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne)
);

/*==============================================================*/
/* Table : Livre                                              */
/*==============================================================*/
create table Livre 
(
   iSBNLivre          INTEGER              not null,
   noTheme            INTEGER              not null,
   noPersonne         INTEGER              not null,
   titreLivre         VARCHAR2(127),
   constraint PK_LIVRE primary key (iSBNLivre),
   constraint FK_LIVRE_CORRESPON_THEME foreign key (noTheme)
         references Theme (noTheme),
   constraint FK_LIVRE_ECRIRE_AUTEUR foreign key (noPersonne)
         references Auteur (noPersonne)
);

/*==============================================================*/
/* Table : Exemplaire                                         */
/*==============================================================*/
create table Exemplaire 
(
   codeExemplaire     SMALLINT             not null,
   iSBNLivre          INTEGER              not null,
   commentaireExemplaire VARCHAR2(127),
   constraint PK_EXEMPLAIRE primary key (codeExemplaire),
   constraint FK_EXEMPLAI_MATERIALI_LIVRE foreign key (iSBNLivre)
         references Livre (iSBNLivre)
);

/*==============================================================*/
/* Table : Pret                                               */
/*==============================================================*/
create table Pret 
(
   noPret             INTEGER              not null,
   dateEmprunt        DATE                 not null,
   codeExemplaire     SMALLINT             not null,
   noPersonne         INTEGER              not null,
   dureePret          INTEGER,
   constraint PK_PRET primary key (noPret, dateEmprunt),
   constraint FK_PRET_CONCERNER_EXEMPLAI foreign key (codeExemplaire)
         references Exemplaire (codeExemplaire),
   constraint FK_PRET_ATTRIBUER_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne)
);

/*==============================================================*/
/* Table : HistoPret                                          */
/*==============================================================*/
create table HistoPret 
(
   noHisto            INTEGER              not null,
   noPret             INTEGER              not null,
   dateEmprunt        DATE                 not null,
   dateRemise         DATE,
   constraint PK_HISTOPRET primary key (noHisto),
   constraint FK_HISTOPRE_STOCKER_PRET foreign key (noPret, dateEmprunt)
         references Pret (noPret, dateEmprunt)
);

