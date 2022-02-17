/*==============================================================*/
/* Nom de la base :  ENTREPRISE2                                */
/* Nom de SGBD :  ORACLE Version 9i                             */
/* Date de cr�ation :  04/12/2004 21:33:38                      */
/*==============================================================*/

-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none

DROP SEQUENCE SEQ_CONTINENT_NO;

DROP PROCEDURE INSERT_CONTINENT;

DROP PROCEDURE INSERT_CONTINENT2;

drop table E_ARTICLE cascade constraints;

drop table E_COMMANDE cascade constraints;

drop table E_CLIENT cascade constraints;

drop table E_STOCK cascade constraints;

drop table E_ENTREPOT cascade constraints;

drop table E_EMP cascade constraints;

drop table E_PRODUIT cascade constraints;

drop table E_TITRE cascade constraints;

drop table E_TEXTE cascade constraints;

drop table E_SERVICE cascade constraints;

drop table E_RESULTAT cascade constraints;

drop table E_IMAGE cascade constraints;

drop table E_CONTINENT cascade constraints;

purge recyclebin;

prompt
prompt
prompt
prompt *****************************
prompt INTERROGATION DU DICTIONNAIRE
prompt    Reste-t-il des objets ?
prompt *****************************
select * from cat;
