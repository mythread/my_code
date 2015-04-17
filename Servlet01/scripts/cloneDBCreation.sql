connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\oracle11g\admin\db\scripts\cloneDBCreation.log
Create controlfile reuse set database "db"
MAXINSTANCES 8
MAXLOGHISTORY 1
MAXLOGFILES 16
MAXLOGMEMBERS 3
MAXDATAFILES 100
Datafile 
'E:\oracle11g\oradata\db\SYSTEM01.DBF',
'E:\oracle11g\oradata\db\SYSAUX01.DBF',
'E:\oracle11g\oradata\db\UNDOTBS01.DBF',
'E:\oracle11g\oradata\db\USERS01.DBF'
LOGFILE GROUP 1 ('E:\oracle11g\oradata\db\redo01.log') SIZE 51200K,
GROUP 2 ('E:\oracle11g\oradata\db\redo02.log') SIZE 51200K,
GROUP 3 ('E:\oracle11g\oradata\db\redo03.log') SIZE 51200K RESETLOGS;
exec dbms_backup_restore.zerodbid(0);
shutdown immediate;
startup nomount pfile="E:\oracle11g\admin\db\scripts\initdbTemp.ora";
Create controlfile reuse set database "db"
MAXINSTANCES 8
MAXLOGHISTORY 1
MAXLOGFILES 16
MAXLOGMEMBERS 3
MAXDATAFILES 100
Datafile 
'E:\oracle11g\oradata\db\SYSTEM01.DBF',
'E:\oracle11g\oradata\db\SYSAUX01.DBF',
'E:\oracle11g\oradata\db\UNDOTBS01.DBF',
'E:\oracle11g\oradata\db\USERS01.DBF'
LOGFILE GROUP 1 ('E:\oracle11g\oradata\db\redo01.log') SIZE 51200K,
GROUP 2 ('E:\oracle11g\oradata\db\redo02.log') SIZE 51200K,
GROUP 3 ('E:\oracle11g\oradata\db\redo03.log') SIZE 51200K RESETLOGS;
alter system enable restricted session;
alter database "db" open resetlogs;
alter database rename global_name to "db";
ALTER TABLESPACE TEMP ADD TEMPFILE 'E:\oracle11g\oradata\db\TEMP01.DBF' SIZE 20480K REUSE AUTOEXTEND ON NEXT 640K MAXSIZE UNLIMITED;
select tablespace_name from dba_tablespaces where tablespace_name='USERS';
select sid, program, serial#, username from v$session;
alter database character set INTERNAL_CONVERT ZHS16GBK;
alter database national character set INTERNAL_CONVERT AL16UTF16;
alter user sys identified by "&&sysPassword";
alter user system identified by "&&systemPassword";
alter system disable restricted session;
