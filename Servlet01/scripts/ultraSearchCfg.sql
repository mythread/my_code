connect "SYS"/"&&sysPassword" as SYSDBA
set echo on
spool E:\oracle11g\admin\db\scripts\ultraSearchCfg.log
alter user WKSYS account unlock identified by change_on_install;
@E:\oracle11g\ultrasearch\admin\wk0config.sql change_on_install (DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=helinxfy)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=db))) false " ";
spool off
