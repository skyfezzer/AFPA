/***************************************************************
MAJ: Alexis RAGOT
Credits : XR
***************************************************************/
--S'il y a un param�tre � ce fichier, alors il contient le chemin absolu
--
-- Redirection de la sortie
SPOOL go.log
-- echo des requ�tes dans SQL*Plus
SET ECHO ON
-- pas d'affichage des substitutions de variable
SET VERIFY OFF
-- sortir en cas d'erreur
WHENEVER OSERROR EXIT
WHENEVER SQLERROR EXIT rollback
set linesize 60
set pagesize 200
@f_to_word_en
@f_translate_fr
@f_nbToString
@p_multiple_loop
@p_multiple_while
@p_multiple_for

PROMPT     FIN NORMALE DU SCRIPT

-- Comportement par d�faut
spool off
set echo off
set verify on

-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none
