@echo off
set dirToWork=%cd%
echo Test des archives dans %dirToWork%
pause
IF NOT "%1"=="" IF EXIST "%1" set dirToWork=%1
7z t %dirToWork%\*.zip