
--------------------------------------------------------
--  DDL for Table USERINFO
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USERINFO" 
   (	"USERNAME" VARCHAR2(20) NOT NULL ENABLE, 
	"PASSWORD" VARCHAR2(20), 
	 CONSTRAINT "USERINFO_PK" PRIMARY KEY ("USERNAME") ENABLE
   ) ;
 
--------------------------------------------------------
--  Constraints for Table USERINFO
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USERINFO" MODIFY ("USERNAME" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."USERINFO" ADD CONSTRAINT "USERINFO_PK" PRIMARY KEY ("USERNAME") ENABLE;
 
---------------------------------------------------
--   DATA FOR TABLE USERINFO
--   FILTER = none used
---------------------------------------------------
REM INSERTING into USERINFO
Insert into USERINFO (USERNAME,PASSWORD) values ('helinxfy','java');

---------------------------------------------------
--   END DATA FOR TABLE USERINFO
---------------------------------------------------
