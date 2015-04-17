set echo off;
set serveroutput on;
select TO_CHAR(systimestamp,'YYYYMMDD HH:MI:SS') from dual;
variable devicename varchar2(255);
declare
omfname varchar2(512) := NULL;
  done boolean;
  begin
    dbms_output.put_line(' ');
    dbms_output.put_line(' Allocating device.... ');
    dbms_output.put_line(' Specifying datafiles... ');
       :devicename := dbms_backup_restore.deviceAllocate;
    dbms_output.put_line(' Specifing datafiles... ');
    dbms_backup_restore.restoreSetDataFile;
      dbms_backup_restore.restoreDataFileTo(1, 'E:\oracle11g\oradata\db\SYSTEM01.DBF', 0, 'SYSTEM');
      dbms_backup_restore.restoreDataFileTo(2, 'E:\oracle11g\oradata\db\SYSAUX01.DBF', 0, 'SYSAUX');
      dbms_backup_restore.restoreDataFileTo(3, 'E:\oracle11g\oradata\db\UNDOTBS01.DBF', 0, 'UNDOTBS1');
      dbms_backup_restore.restoreDataFileTo(4, 'E:\oracle11g\oradata\db\USERS01.DBF', 0, 'USERS');
    dbms_output.put_line(' Restoring ... ');
    dbms_backup_restore.restoreBackupPiece('E:\oracle11g\assistants\dbca\templates\Seed_Database.dfb', done);
    if done then
        dbms_output.put_line(' Restore done.');
    else
        dbms_output.put_line(' ORA-XXXX: Restore failed ');
    end if;
    dbms_backup_restore.deviceDeallocate;
  end;
/
select TO_CHAR(systimestamp,'YYYYMMDD HH:MI:SS') from dual;
