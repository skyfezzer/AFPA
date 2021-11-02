@echo off
@setlocal
IF "%1"=="" (set valMax=10) ELSE (set valMax=%1)
echo Les multiples de 3, de 1 … %valMax% sont :
set compteur=0
:BOUCLE

set /a compteur+=1
IF %compteur% GTR %valMax% GOTO END
set /a mod=%compteur% %%3
IF %mod% == 0 echo %compteur% est un multiple de 3 !
GOTO BOUCLE

:END
pause
echo Bonus:Il est possible de trouver les multiples au del… de 10 : passez un nombre maximum en argument de ce fichier.
@endlocal