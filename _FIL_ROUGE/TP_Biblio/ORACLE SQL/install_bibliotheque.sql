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
CREATE SEQUENCE seq_personne START WITH 1 INCREMENT BY 1 nomaxvalue;
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
CREATE SEQUENCE seq_adherent START WITH 1 INCREMENT BY 1 nomaxvalue;
/*==============================================================*/
/* Table : Auteur                                             */
/*==============================================================*/
create table Auteur 
(
   noAuteur           INTEGER              not null,
   nomCompletAuteur   VARCHAR2(63),
   constraint PK_AUTEUR primary key (noAuteur)
);
CREATE SEQUENCE SEQ_AUTEUR START WITH 1 INCREMENT BY 1;
/*==============================================================*/
/* Table : Bibliotheque                                       */
/*==============================================================*/
create table Bibliotheque 
(
   noBibliotheque     INTEGER              not null,
   adresse            VARCHAR2(254),
   constraint PK_BIBLIOTHEQUE primary key (noBibliotheque)
);
CREATE SEQUENCE SEQ_BIBLIOTHEQUE START WITH 1 INCREMENT BY 1;
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
CREATE SEQUENCE SEQ_DETTE START WITH 1 INCREMENT BY 1;
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
CREATE SEQUENCE SEQ_EMPLACEMENT START WITH 1 INCREMENT BY 1;
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
   noHisto            INTEGER,
   constraint PK_PRET primary key (noPret),
   constraint FK_PRET_ATTRIBUER_UTILISAT foreign key (noPersonne)
         references Utilisateur (noPersonne),
   constraint FK_PRET_CONCERNER_EXEMPLAI foreign key (iSBNLivre, codeExemplaire)
         references Exemplaire (iSBNLivre, codeExemplaire)
);
CREATE SEQUENCE SEQ_PRET START WITH 1 INCREMENT BY 1;
comment on table Pret is
'Cette classe conceptualise les pr?ts d''exemplaires.';

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
alter table PRET add constraint FK_PRET_RENDU_HISTO foreign key (noHisto) references HistoPret (noHisto);
CREATE SEQUENCE SEQ_HISTOPRET START WITH 1 INCREMENT BY 1;
comment on table HistoPret is
'Cette classe conceptualise la fin d''un pr?t';


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
CREATE SEQUENCE SEQ_PAIEMENT START WITH 1 INCREMENT BY 1;
comment on table Paiement is
'Cette classe conceptualise les paiements de cotisations ainsi que les amendes.';

/*==============================================================*/
/* Table : HistoPret, TRIGGER                                   */
/*==============================================================*/
CREATE OR REPLACE TRIGGER HISTOPRET_AFTER_INSERT
AFTER INSERT ON HISTOPRET
FOR EACH ROW
BEGIN
    UPDATE PRET SET PRET.NOHISTO = :new.NOHISTO WHERE PRET.NOPRET = :new.NOPRET;
    dbms_output.put_line('Pret <'||:new.noPret||'>.noHisto updated');
END;
/

/*==============================================================*/
/* Fonction : SMALLINT is_Exemplaire_Disponible                 */
/*          ( noISBN NUMBER, codeExemplaire NUMBER )            */
/*==============================================================*/
CREATE OR REPLACE FUNCTION is_exemplaire_disponible(
    in_noISBN NUMBER,
    in_codeExemplaire NUMBER)
RETURN SMALLINT
IS 
    l_nbEmpruntsEnCours SMALLINT;
BEGIN
    SELECT COUNT(*) INTO l_nbempruntsencours FROM EXEMPLAIRE, PRET
                WHERE in_noISBN = exemplaire.isbnlivre AND in_codeExemplaire = exemplaire.codeexemplaire 
                AND exemplaire.codeexemplaire = pret.codeexemplaire
                AND exemplaire.isbnlivre = pret.isbnlivre
                AND PRET.noPret IS NOT NULL AND PRET.noHisto IS NULL;
    IF l_nbempruntsencours = 0 
    THEN 
        RETURN 1; 
    END IF;
    RETURN 0;
END;
/
/*==============================================================*/
/* Fonction : SMALLINT is_adherent_en_retard                    */
/*          ( noPersonne NUMBER )                               */
/*==============================================================*/
CREATE OR REPLACE FUNCTION is_adherent_en_regle(
    in_noPersonne adherent.nopersonne%TYPE)
RETURN SMALLINT
IS 
    CURSOR cur_dateEmprunts IS 
        SELECT PRET.DATEEMPRUNT, PRET.DUREEPRET FROM PRET
        WHERE pret.nohisto IS NULL AND PRET.NOPERSONNE = in_noPersonne;
    rec_dateEmprunts cur_dateEmprunts%ROWTYPE;
    l_result SMALLINT := 1;
    calculated_date PRET.DATEEMPRUNT%TYPE;
BEGIN
    OPEN cur_dateEmprunts;
    LOOP
        FETCH cur_dateEmprunts INTO rec_dateEmprunts;
        EXIT WHEN cur_dateEmprunts%NOTFOUND OR cur_dateEmprunts%ROWCOUNT > 3;
        -- add (either dureePret or 15) days to DateEmprunt.
        -- set l_result to 1 (true) if the new calculated Date is before right now.
        calculated_date := rec_dateEmprunts.DATEEMPRUNT + 
            CASE WHEN rec_dateEmprunts.DUREEPRET IS NOT NULL
                THEN rec_dateEmprunts.DUREEPRET
                ELSE 15
            END;
        IF calculated_date < sysdate OR cur_dateEmprunts%ROWCOUNT >= 3
        THEN
            l_result := 0;
        END IF;
        
    END LOOP;
    CLOSE cur_dateEmprunts;
    RETURN l_result;
END;
/
prompt
prompt
prompt
Prompt ******************************
prompt Recapitulatif des Objets cr??s
Prompt ******************************
select * from user_catalog;
prompt
prompt
prompt
prompt ************************************
prompt Recapitulatif des contraintes pos?es
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
