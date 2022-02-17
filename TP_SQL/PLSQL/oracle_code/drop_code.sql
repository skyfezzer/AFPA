--==============================================================
--Nom de la base :                                        
--Nom du fichier : drop_livraison.sql                            
--==============================================================


-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none


Prompt ****************************************
Prompt SUPPRESSION DES TABLES, VUES , SEQUENCES
Prompt ****************************************
DROP FUNCTION TO_WORD_EN;
DROP FUNCTION TRANSLATE_FR;
DROP FUNCTION nbToString;

DROP PROCEDURE MULTIPLE_LOOP;
DROP PROCEDURE MULTIPLE_WHILE;
DROP PROCEDURE MULTIPLE_FOR;

DROP TABLE RESULTAT;

purge recyclebin;

prompt
prompt
prompt
prompt ***********************
prompt Reste-t-il des objets ?
prompt ***********************
select * from cat;
