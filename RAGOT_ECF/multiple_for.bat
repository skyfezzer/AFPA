@echo off
setlocal EnableDelayedExpansion
FOR /L %%I in (1,1,10) do (
set /a number=%%I %%3
if !number!==0 echo %%I
)


endlocal