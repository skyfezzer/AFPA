-- Redirection de la sortie vers un fichier de log
SPOOL go.log
-- echo des requ�tes dans SQL*Plus
SET ECHO OFF
-- pas d'affichage des substitutions de variable
SET VERIFY OFF
-- sortir en cas d'erreur
WHENEVER OSERROR EXIT
WHENEVER SQLERROR EXIT
--ALTER SESSION SET NLS_LANGUAGE=American;
--ALTER SESSION SET NLS_TERRITORY=America;

ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY'
ALTER SESSION SET NLS_DATE_LANGUAGE = ENGLISH

SELECT to_char( sysdate , 'DD/MM/YY_HH24:MI:SS' ) FROM dual;
-- creation tables
@install_banque
/

-- populate
@install_data_banque
/

-- indexes
@req_banque
/

PROMPT     FIN NORMALE DU SCRIPT
-- fermeture du fichier log
spool off
set echo off