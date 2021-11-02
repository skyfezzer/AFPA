@echo off
@setlocal

IF "%1"=="" (set nbValMax=4) ELSE (set nbValMax=%1)
set val=0

:BOUCLE
set /a val+=1
set /p var="Nombre nø%val% :"

IF %val% EQU 1 (
set valMin=%var%
set valMinID=%val%
set valMax=%var%
set valMaxID=%val%
)
IF %var% GTR %valMax% (set valMax=%var%
set valMaxID=%val%
)
IF %var% LSS %valMin% (set valMin=%var%
set valMinID=%val%
)

IF NOT %val% EQU %nbValMax% GOTO BOUCLE
:end
echo Fin du programme !
echo La valeur la plus haute est la nø%valMaxID%, qui vaut %valMax%
echo La valeur la plus basse est la nø%valMinID%, qui vaut %valMin%
pause
echo Bonus:Il est possible d'entrer + de 4 valeurs : passez un nombre maximum en argument de ce fichier.
@endlocal