@echo off
set MYJAVA=java.exe
echo #####################################################
echo using java runtime: "%MYJAVA%"
echo #####################################################
REM @echo on
"%MYJAVA%" -ea -jar PhotoManage.jar PhotoManage.config
pause