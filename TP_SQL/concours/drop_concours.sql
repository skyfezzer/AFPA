drop sequence seq_concours;
drop sequence seq_chien;
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

purge recyclebin;

prompt
prompt *******************************************
prompt INTERROGATION DU DICTIONNAIRE
prompt    Reste-t-il des tables, vues, sequences ?
prompt *******************************************
select * from cat;
/