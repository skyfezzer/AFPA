@echo off
@setlocal

set nbValMax=10
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
set valMaxID=%val%)

IF %var% LSS %valMin% (set valMin=%var%
set valMinID=%val%)

IF NOT %val% EQU %nbValMax% GOTO BOUCLE
:end
echo Fin du programme !
echo La valeur la plus haute est la num‚ro %valMaxID%, qui est %valMax%
echo La valeur la plus basse est la num‚ro %valMinID%, qui est %valMin%
pause
@endlocal