@echo off
:start
IF [%1]==[] EXIT /B 1
echo %1
SHIFT
GOTO :start