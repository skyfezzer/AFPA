@echo off
IF "%1"=="bond" (
	IF "%2"=="007" ( echo Bienvenue MR Bond ! ) ELSE echo argument 2 doit être 007 
) ELSE (
	echo argument 1 doit être bond
)
