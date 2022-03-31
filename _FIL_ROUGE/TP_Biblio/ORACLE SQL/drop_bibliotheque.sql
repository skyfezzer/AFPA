--==============================================================
--Nom de la base :                                        
--Nom du fichier : drop_bibliotheque.sql                            
--==============================================================


-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none


Prompt ****************************************
Prompt SUPPRESSION DES TABLES, VUES , SEQUENCES
Prompt ****************************************
drop public synonym Adherent;
drop public synonym Auteur;
drop public synonym Bibliotheque;
drop public synonym Dette;
drop public synonym Emplacement;
drop public synonym Employe;
drop public synonym Exemplaire;
drop public synonym Histopret;
drop public synonym Livre;
drop public synonym Paiement;
drop public synonym Pret;
drop public synonym Theme;
drop public synonym Utilisateur;
drop public synonym is_exemplaire_disponible;
drop public synonym is_adherent_autorise_pret;
drop public synonym SEQ_ADHERENT;
drop public synonym SEQ_AUTEUR;
drop public synonym SEQ_BIBLIOTHEQUE;
drop public synonym SEQ_DETTE;
drop public synonym SEQ_EMPLACEMENT;
drop public synonym SEQ_HISTOPRET;
drop public synonym SEQ_PAIEMENT;
drop public synonym SEQ_PERSONNE;
drop public synonym SEQ_PRET;
drop trigger HISTOPRET_AFTER_INSERT;
drop table HistoPret cascade constraints;
drop table Pret cascade constraints;
drop table Dette cascade constraints;
drop table Paiement cascade constraints;
drop table Emplacement cascade constraints;
drop table Exemplaire cascade constraints;
drop table Livre cascade constraints;
drop table Theme cascade constraints;
drop table Adherent cascade constraints;
drop table Auteur cascade constraints;
drop table Employe cascade constraints;
drop table Utilisateur cascade constraints;
drop table Bibliotheque cascade constraints;
drop sequence seq_personne;
drop sequence seq_adherent;
drop sequence seq_auteur;
drop sequence seq_emplacement;  
drop sequence SEQ_BIBLIOTHEQUE;
drop sequence seq_dette;
drop sequence seq_pret;
drop sequence SEQ_HISTOPRET;
drop sequence SEQ_PAIEMENT;
drop function is_adherent_autorise_pret;
drop function is_exemplaire_disponible;

purge recyclebin;

prompt
prompt
prompt
prompt ***********************
prompt Reste-t-il des objets ?
prompt ***********************
select * from cat;
