@echo off
if "%1"=="" goto err
echo le parametre est:%1
goto fin

:err
echo entrer un parametre
:fin