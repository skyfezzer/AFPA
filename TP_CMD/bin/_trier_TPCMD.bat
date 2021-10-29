@SETLOCAL
@ECHO OFF
set workingPath=%~dp0..\
IF EXIST %workingPath%\*.bat move %workingPath%\*.bat .\bin\
IF EXIST %workingPath%\*.txt move %workingPath%\*.txt .\resources\
IF EXIST %workingPath%\*.pdf move %workingPath%\*.pdf ..\PDFs\
echo %workingPath% fin du tri.
pause
@ENDLOCAL
