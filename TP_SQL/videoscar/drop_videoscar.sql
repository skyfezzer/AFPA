--/***************************************************************
--Script drop_voyage.sql
--***************************************************************/

-- Comportement par défaut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none

drop sequence seq_realise;
drop sequence seq_film;
drop sequence seq_categorie;
drop sequence seq_acteur;
drop sequence seq_k7;

Prompt ****************************************
Prompt SUPPRESSION DES TABLES, VUES , SEQUENCES
Prompt ****************************************

drop table JOUER cascade constraints;

drop table K7 cascade constraints;

drop table FILM cascade constraints;

drop table REALISE cascade constraints;

drop table CATEGORIE cascade constraints;

drop table ACTEUR cascade constraints;



purge recyclebin;

prompt
prompt *******************************************
prompt INTERROGATION DU DICTIONNAIRE
prompt    Reste-t-il des tables, vues, sequences ?
prompt *******************************************
select * from cat;
