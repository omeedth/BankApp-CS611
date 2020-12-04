@ECHO off
SET mypath=%~dp0
CD /D %mypath%
call ./clean
javac App.java