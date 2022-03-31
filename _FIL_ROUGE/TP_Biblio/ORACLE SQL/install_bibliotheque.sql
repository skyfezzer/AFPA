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
/* Fonction : SMALLINT is_adherent_autorise_pret                */
/*          ( noPersonne NUMBER )                               */
/*==============================================================*/
CREATE OR REPLACE FUNCTION is_adherent_autorise_pret(
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
/*==============================================================*/
/*         PRIVILEGES                                           */
/*                 ET SYNONYMES                                 */
/*==============================================================*/
revoke all on Adherent from public;
revoke all on Auteur from public;
revoke all on Bibliotheque from public;
revoke all on Dette from public;
revoke all on Emplacement from public;
revoke all on Employe from public;
revoke all on Exemplaire from public;
revoke all on Histopret from public;
revoke all on Livre from public;
revoke all on Paiement from public;
revoke all on Pret from public;
revoke all on Theme from public;
revoke all on Utilisateur from public;
revoke all on is_exemplaire_disponible from public;
revoke all on is_adherent_autorise_pret from public;
grant select, update on Adherent to public;
grant select, update, insert on Auteur to public;
grant select on Bibliotheque to public;
grant select on Dette to public;
grant select, update on Emplacement to public;
grant select on Employe to public;
grant select, insert, update on Exemplaire to public;
grant select, insert on Histopret to public;
grant select on Livre to public;
grant select on Paiement to public;
grant select, insert, update on Pret to public;
grant select on Theme to public;
grant select, insert, update on Utilisateur to public;
grant EXECUTE on is_exemplaire_disponible to public;
grant EXECUTE on is_adherent_autorise_pret to public;
create or replace public synonym Adherent for bibliotheque.Adherent;
create or replace public synonym Auteur for bibliotheque.Auteur;
create or replace public synonym Bibliotheque for bibliotheque.Bibliotheque;
create or replace public synonym Dette for bibliotheque.Dette;
create or replace public synonym Emplacement for bibliotheque.Emplacement;
create or replace public synonym Employe for bibliotheque.Employe;
create or replace public synonym Exemplaire for bibliotheque.Exemplaire;
create or replace public synonym Histopret for bibliotheque.Histopret;
create or replace public synonym Livre for bibliotheque.Livre;
create or replace public synonym Paiement for bibliotheque.Paiement;
create or replace public synonym Pret for bibliotheque.Pret;
create or replace public synonym Theme for bibliotheque.Theme;
create or replace public synonym Utilisateur for bibliotheque.Utilisateur;
create or replace public synonym is_exemplaire_disponible for bibliotheque.is_exemplaire_disponible;
create or replace public synonym is_adherent_autorise_pret for bibliotheque.is_adherent_autorise_pret;
create or replace public synonym SEQ_ADHERENT for bibliotheque.SEQ_ADHERENT;
create or replace public synonym SEQ_AUTEUR for bibliotheque.SEQ_AUTEUR;
create or replace public synonym SEQ_BIBLIOTHEQUE for bibliotheque.SEQ_BIBLIOTHEQUE;
create or replace public synonym SEQ_DETTE for bibliotheque.SEQ_DETTE;
create or replace public synonym SEQ_EMPLACEMENT for bibliotheque.SEQ_EMPLACEMENT;
create or replace public synonym SEQ_HISTOPRET for bibliotheque.SEQ_HISTOPRET;
create or replace public synonym SEQ_PAIEMENT for bibliotheque.SEQ_PAIEMENT;
create or replace public synonym SEQ_PERSONNE for bibliotheque.SEQ_PERSONNE;
create or replace public synonym SEQ_PRET for bibliotheque.SEQ_PRET;
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
