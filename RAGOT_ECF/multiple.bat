@echo off
@setlocal
echo Les multiples de 3 sont :
set compteur=0
:BOUCLE
set /a compteur+=1
set /a mod=%compteur% %%3
IF %mod% == 0 echo %compteur% est un multiple de 3 !
IF %compteur% GTR 9 GOTO END
GOTO BOUCLE

:END
pause
@endlocal