@SETLOCAL
@echo off

set /a secretNumber="%RANDOM% %%9+1"
set nbTour = 0

:ASKNUMBER
set /a nbTour+=1
set /p nbr=Trouvez le nombre entre 0 et 9..
IF %nbr% EQU %secretNumber% GOTO :WIN
IF %nbr% GTR %secretNumber% ( set result=moins) ELSE set result=plus

echo Presque, mais mon nombre est %result% grand...
GOTO ASKNUMBER
:WIN
echo Felicitations! Le nombre etait bien %secretNumber%. Vous avez trouve en %nbTour% tours...
@ENDLOCAL