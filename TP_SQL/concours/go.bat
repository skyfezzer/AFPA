REM @echo off
prompt CMD$g

if (%ORACLE_HOME%) == () goto nooraclehome
set SOURCE=.
%ORACLE_HOME%\bin\SQLPLUS concours/concours@localhost/xepdb1 @"%SOURCE%\go.sql"
pause
goto exit

:nooraclehome
echo ORACLE_HOME variable d environement non positionnee
pause
exit 1

:exit
echo SCRIPT TERMINE SANS ERREUR
exit 0


