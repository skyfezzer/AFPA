prompt CMD$g
if (%ORACLE_HOME%) == () goto nooraclehome
set SOURCE=.
%ORACLE_HOME%\bin\SQLPLUS entreprise/entreprise@localhost/xepdb1 @"%SOURCE%\drop_code.sql"
pause
goto exit

:nooraclehome
echo ORACLE_HOME variable d environement non positionnee
pause
exit 1

:exit
echo SCRIPT TERMINE SANS ERREUR
exit 0


