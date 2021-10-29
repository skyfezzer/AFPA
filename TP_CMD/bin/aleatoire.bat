@echo off
set /a myVar=%RANDOM% %% 9 + 1
echo %myVar%
