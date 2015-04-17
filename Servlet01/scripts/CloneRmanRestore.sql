connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\oracle11g\admin\db\scripts\CloneRmanRestore.log
startup nomount pfile="E:\oracle11g\admin\db\scripts\init.ora";
@E:\oracle11g\admin\db\scripts\rmanRestoreDatafiles.sql;
