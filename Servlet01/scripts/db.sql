set verify off
PROMPT specify a password for sys as parameter 1;
DEFINE sysPassword = &1
PROMPT specify a password for system as parameter 2;
DEFINE systemPassword = &2
PROMPT specify a password for sysman as parameter 3;
DEFINE sysmanPassword = &3
PROMPT specify a password for dbsnmp as parameter 4;
DEFINE dbsnmpPassword = &4
host E:\oracle11g\bin\orapwd.exe file=E:\oracle11g\database\PWDdb.ora password=&&sysPassword force=y
@E:\oracle11g\admin\db\scripts\CloneRmanRestore.sql
@E:\oracle11g\admin\db\scripts\cloneDBCreation.sql
@E:\oracle11g\admin\db\scripts\postScripts.sql
@E:\oracle11g\admin\db\scripts\ultraSearchCfg.sql
@E:\oracle11g\admin\db\scripts\lockAccount.sql
@E:\oracle11g\admin\db\scripts\postDBCreation.sql
