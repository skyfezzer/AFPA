--==============================================================
--Nom de la base :                                        
--Nom du fichier : drop_bibliotheque.sql                            
--==============================================================


-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none


Prompt ****************************************
Prompt SUPPRESSION DES TABLES, VUES , SEQUENCES
Prompt ****************************************

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
drop table Personne cascade constraints;
drop table Bibliotheque cascade constraints;
drop sequence seq_personne;
drop sequence seq_adherent;

purge recyclebin;

prompt
prompt
prompt
prompt ***********************
prompt Reste-t-il des objets ?
prompt ***********************
select * from cat;
