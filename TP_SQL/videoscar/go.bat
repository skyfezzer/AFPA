REM @echo off
prompt CMD$g
REM
REM
REM NAME
REM   go.bat
REM
REM DESCRIPTION
REM   Commande de création des bases de données
REM USAGE
REM
REM   Pour rendre le script facilement réutilisable,
REM   Les variables d'environnement suivantes
REM   doivent être positionnées : ...
REM
REM
REM   Creation : Xavier HER
REM        MAJ : 


REM Vérification de la présence des variables d'environnement
if (%ORACLE_HOME%) == () goto nooraclehome



REM set SOURCE=%PROJETS_HOME%\...\Oracle
set SOURCE=.

REM - lancement de SQL*Plus en mode ligne avec le script 
%ORACLE_HOME%\bin\SQLPLUS videoscar/videoscad@localhost:1521/xepdb1 @"%SOURCE%\go.sql"


pause

goto exit

:nooraclehome
echo ORACLE_HOME variable d environement non positionnee
pause
exit 1

:exit
echo SCRIPT TERMINE SANS ERREUR
pause


