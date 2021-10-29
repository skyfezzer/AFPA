@echo off
set result=erreur
IF "%1" == "OUI" set result=affirmatif
IF "%1" == "NON" set result=négatif
echo %result%
