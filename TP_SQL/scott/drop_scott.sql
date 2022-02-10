/*==============================================================*/
/* Nom de la base :  LIBAS                                      */
/* Nom du fichier : drop_libas.sql                            */
/* Nom de SGBD :  ORACLE Version 9i                             */
/* Date de création :  01/07/2003 14:30:48                      */
/*==============================================================*/

-- Comportement par défaut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none


drop INDEX  I_DEPTNO;
drop INDEX  IN_IOB;

drop table emp cascade constraints;

drop table dept cascade constraints;

drop table BONUS cascade constraints;

drop table SALGRADE cascade constraints;

drop view EMPMAN;

purge recyclebin;

prompt
prompt
prompt
prompt ***********************
prompt Reste-t-il des objets ?
prompt ***********************
select * from cat;

