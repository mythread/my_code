mkdir E:\oracle11g\admin\db\adump
mkdir E:\oracle11g\admin\db\dpdump
mkdir E:\oracle11g\admin\db\pfile
mkdir E:\oracle11g\cfgtoollogs\dbca\db
mkdir E:\oracle11g\database
mkdir E:\oracle11g\flash_recovery_area
mkdir E:\oracle11g\oradata\db
set ORACLE_SID=db
set PATH=%ORACLE_HOME%\bin;%PATH%
E:\oracle11g\bin\oradim.exe -new -sid DB -startmode manual -spfile 
E:\oracle11g\bin\oradim.exe -edit -sid DB -startmode auto -srvcstart system 
E:\oracle11g\bin\sqlplus /nolog @E:\oracle11g\admin\db\scripts\db.sql
