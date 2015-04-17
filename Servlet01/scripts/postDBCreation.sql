connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\oracle11g\admin\db\scripts\postDBCreation.log
connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
create spfile='E:\oracle11g\database\spfiledb.ora' FROM pfile='E:\oracle11g\admin\db\scripts\init.ora';
shutdown immediate;
connect "SYS"/"&&sysPassword" as SYSDBA
startup ;
alter user SYSMAN identified by "&&sysmanPassword" account unlock;
alter user DBSNMP identified by "&&dbsnmpPassword" account unlock;
select 'utl_recomp_begin: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute utl_recomp.recomp_serial();
select 'utl_recomp_end: ' || to_char(sysdate, 'HH:MI:SS') from dual;
execute dbms_swrf_internal.cleanup_database(cleanup_local => FALSE);
commit;
host E:\oracle11g\bin\emca.bat -config dbcontrol db -silent -DB_UNIQUE_NAME db -PORT 1521 -EM_HOME E:\oracle11g -LISTENER LISTENER -SERVICE_NAME db -SYS_PWD &&sysPassword -SID db -ORACLE_HOME E:\oracle11g -DBSNMP_PWD &&dbsnmpPassword -HOST helinxfy -LISTENER_OH E:\oracle11g -LOG_FILE E:\oracle11g\admin\db\scripts\emConfig.log -SYSMAN_PWD &&sysmanPassword;
connect "SYS"/"&&sysPassword" as SYSDBA
spool E:\oracle11g\admin\db\scripts\postDBCreation.log
