--|=============================================================
--| Fichier: go.sql
--| Objet : Cr�ation de la BD
--|=============================================================
--| 01/01/04 -> XH    : cr�ation
--|=============================================================

-- Ecriture de l'affichage dans un fichier de log
SPOOL go.log


set sqlprompt "SQL> "


-- echo des commandes et des commentaires dans SQL*Plus
SET ECHO ON

-- Pas d'affichage des substitutions de variable
SET VERIFY OFF

-- Sortir en cas d'erreur SQL
WHENEVER SQLERROR exit rollback

@install_entreprise
@install_data_entreprise
@p_insert_continent
@p_insert_continent2
@p_augment_employe

PROMPT     FIN NORMALE DU SCRIPT

-- Comportement par d�faut
spool off
set echo off
set verify on

-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none
