//*****************************************************************************
//** TASC - ALPHALINC - INC include.$syPidtab
//** Innovatium Systems - Code Converter - v1.28
//** 2014-05-26 21:13:36
//*****************************************************************************

package include;

import mLibrary.*;


//<< #;%syPidtab.INC -Defines for dynamic pidtab and ttyhash ; STC1086 10/04/06
//<< //#if 0   /*=======================Maintenance========================*/
//<< #;SML957  11/09/07 Simon Li, Fix getaltpid() macro for USETID platforms.
//<< #;STC1086 10/04/06 Steve Clay, Update TASKMGR LOCATION field.
//<< #;JO2062  8/02/06 Jeffrey Orlin, renumbered jobtypes to match pidtab.h.
//<< #;        Removed an unused type. Added PEX_ defined for resjob
//<< #;        exit status
//<< #;SAP565  4/24/06 Steve Pettibone, fill in offsets for pidoff,tidoff
//<< #;JO1984 11/16/05 Jeffrey Orlin, add PIDSIZE, PIDOFF, TIDOFF
//<< #;STC977  03/19/06 Steve Clay, LDAP and User-Defined Authentication
//<< #;SML674  1/26/06 Simon Li, Change Clean Daemon's jobtype from 146 to 152.
//<< #;GK383  12/14/04 Garen Kotikian, Added ECP process dmn to the process
//<< #;        class system jobs.
//<< #;LFT1316 11/10/4 Laura Tillem, %SYSTEM.Process -> SYS.Process
//<< #;JO1834 09/23/04 Jeffrey Orlin, add SYSWATCHTYPE for ^SYSWATCH dmn and
//<< #;                "names" for task mgr, clean dmn and syswatch dmn.
//<< #;SML471 07/09/04 Simon Li, Add CLNDTYPE for clean daemon
//<< #;STC471 09/19/03 Steve Clay, renamed, added %sySt
//<< #;STC362 09/16/02 Steve Clay, Updated jobtype fields
//<< #;STC351 06/03/02 Steve Clay, Add jobtype definitions
//<< #;STC345 04/06/02 Steve Clay, Add lots of macros
//<< #;LFT961 01/22/01 Laura Tillem, dynamic pidtab
//<< #;LFT965 11/02/01 Laura Tillem, dynamic ttyhash
//<< //#endif  /*=====================End Maintenance======================*/
//<< 
//<< //#ifndef %syPidtabinc
//<< //#define %syPidtabinc
//<< //#include %sySt
//<< #; defines for %SS,JOBEXAM, and SYS.Process
//<< //#ifdef TESTPID
//<< //#define startpidnum 16
//<< //#define pidtabshift 4
//<< //#define pidsperchunk 16
//<< //#else
public class $syPidtab extends mInclude {

  //<< #define startpidnum 256
  public static Object $$$startpidnum(mContext m$) {
    return (256);
  }

  //<< #define pidtabshift 5
  public static Object $$$pidtabshift(mContext m$) {
    return (5);
  }

  //<< #define pidsperchunk 32
  public static Object $$$pidsperchunk(mContext m$) {
    return (32);
  }

  //<< //#endif
  //<< #define altpidsize $s($$$USETID:8,1:4)
  public static Object $$$altpidsize(mContext m$) {
    return (m$.Fnc.$select($$$USETID(m$),8,1,4));
  }

  //<< #define pidtabstart $ZU(40,2,139)
  public static Object $$$pidtabstart(mContext m$) {
    return (m$.Fnc.$zutil(40,2,139));
  }

  //<< #; The following are all the offsets to the fields in the partition
  //<< #define pidtabsize $zu(40,28,0)
  public static Object $$$pidtabsize(mContext m$) {
    return (m$.Fnc.$zutil(40,28,0));
  }

  //<< 
  //<< //#define getaltpid(%x) $View($View($$$STALTPID+((%x\$$$pidsperchunk)*$$$STshmoff),-2,$$$STshmoff)+((%x#$$$pidsperchunk)*$$$altpidsize),-2,4)
  //<< 
  //<< //#define pidchunkstart(%x) $View($$$pidtabstart+((%x\$$$pidsperchunk)*$$$STshmoff),-2,$$$STshmoff)
  //<< 
  //<< #;JO1984+
  //<< #; USETID means that process id's are structures not simple #'s. When
  //<< #; USETID is FALSE, $$$TIDOFF should not be used. $$$PIDOFF is valid.
  //<< #; This Cache' binary can interact with threaded Cache' processes but
  //<< #; this process cannot be multi-threaded.
  //<< //#define USETID $ZBITGET($ZVERSION(0),40)
  //<< #define USETID 0
  public static Object $$$USETID(mContext m$) {
    return (0);
  }

  //<< 
  //<< #; USETHREAD means that this process is running a Cache' binary which
  //<< #; supports multiple Cache' threads for a single job.
  //<< //#define USETHREAD $ZBITGET($ZVERSION(0),38)
  //<< 
  //<< #;  PIDSIZE is the size in bytes of a ttypid entry
  //<< #define PIDSIZE     $ZU(40,0,77)
  public static Object $$$PIDSIZE(mContext m$) {
    return (m$.Fnc.$zutil(40,0,77));
  }

  //<< #;  PIDOFF is the offset to the 32-bit pid from a ttypid pointer
  //<< #define PIDOFF      $ZU(40,28,78)
  public static Object $$$PIDOFF(mContext m$) {
    return (m$.Fnc.$zutil(40,28,78));
  }

  //<< #;  TIDOFF is the offset to the 32-bit tid from a ttypid pointer.
  //<< #;  This has no meaning when $$$USETID is false.
  //<< #define TIDOFF      $ZU(40,28,79)
  public static Object $$$TIDOFF(mContext m$) {
    return (m$.Fnc.$zutil(40,28,79));
  }

  //<< #;  jobid is the process' presqpnt->jobid field which is the
  //<< #;  job # plus a counter to differentiate different processes
  //<< #;  using the same job slot. It is used in cases where we want
  //<< #;  a 32-bit id and we clean up after a dead job so we don't worry
  //<< #;  about the counter portion wrapping (eg. job10only, transactions
  //<< #;  in the journal file).
  //<< #define JOBID   $ZU(61,30,$zu(61))
  public static Object $$$JOBID(mContext m$) {
    return (m$.Fnc.$zutil(61,30,m$.Fnc.$zutil(61)));
  }

  //<< #;JO1984-
  //<< 
  //<< #; The following are definitions which get the values of the pidtab fields
  //<< #; Note that some are undefined as they are not currently either interesting
  //<< #; or required
  //<< #; The following are pidtab JobType defines (see pidtab.h)
  //<< #; ;JO2062+
  //<< #define NOJOB       0
  public static Object $$$NOJOB(mContext m$) {
    return (0);
  }

  //<< #define FOREJOB     1
  public static Object $$$FOREJOB(mContext m$) {
    return (1);
  }

  //<< #define APPMODE     2
  public static Object $$$APPMODE(mContext m$) {
    return (2);
  }

  //<< #define FORAPPJOB   3
  public static Object $$$FORAPPJOB(mContext m$) {
    return (3);
  }

  //<< #define CPTYPE      4
  public static Object $$$CPTYPE(mContext m$) {
    return (4);
  }

  //<< #define WDTYPE      5
  public static Object $$$WDTYPE(mContext m$) {
    return (5);
  }

  //<< #define GCTYPE      6
  public static Object $$$GCTYPE(mContext m$) {
    return (6);
  }

  //<< #define JDTYPE      7
  public static Object $$$JDTYPE(mContext m$) {
    return (7);
  }

  //<< #define ENQTYPE     8
  public static Object $$$ENQTYPE(mContext m$) {
    return (8);
  }

  //<< #define RDTYPE      9
  public static Object $$$RDTYPE(mContext m$) {
    return (9);
  }

  //<< #define SLWDTYPE    10
  public static Object $$$SLWDTYPE(mContext m$) {
    return (10);
  }

  //<< #define NETSRVTYPE  11
  public static Object $$$NETSRVTYPE(mContext m$) {
    return (11);
  }

  //<< #define NETDMNTYPE  12
  public static Object $$$NETDMNTYPE(mContext m$) {
    return (12);
  }

  //<< #define LICENSESRV  13
  public static Object $$$LICENSESRV(mContext m$) {
    return (13);
  }

  //<< #define BMCSRV      14
  public static Object $$$BMCSRV(mContext m$) {
    return (14);
  }

  //<< #define CSPDMNTYPE  15
  public static Object $$$CSPDMNTYPE(mContext m$) {
    return (15);
  }

  //<< #define DTMSRV      16
  public static Object $$$DTMSRV(mContext m$) {
    return (16);
  }

  //<< #define DTMNSPSRV   17
  public static Object $$$DTMNSPSRV(mContext m$) {
    return (17);
  }

  //<< #define SHADMASTSRV 18
  public static Object $$$SHADMASTSRV(mContext m$) {
    return (18);
  }

  //<< #define SHADSRV     19
  public static Object $$$SHADSRV(mContext m$) {
    return (19);
  }

  //<< #define SHADCLISRV  20
  public static Object $$$SHADCLISRV(mContext m$) {
    return (20);
  }

  //<< #define RCVDMNTYPE  21
  public static Object $$$RCVDMNTYPE(mContext m$) {
    return (21);
  }

  //<< #define SHUTDOWNJOB 22
  public static Object $$$SHUTDOWNJOB(mContext m$) {
    return (22);
  }

  //<< #define JOBSRVTYPE  23
  public static Object $$$JOBSRVTYPE(mContext m$) {
    return (23);
  }

  //<< #define CMTMASTSRV  24
  public static Object $$$CMTMASTSRV(mContext m$) {
    return (24);
  }

  //<< #define MSMACTSRV   25
  public static Object $$$MSMACTSRV(mContext m$) {
    return (25);
  }

  //<< #define CDIRECTSRV  26
  public static Object $$$CDIRECTSRV(mContext m$) {
    return (26);
  }

  //<< #define CSPSRV      27
  public static Object $$$CSPSRV(mContext m$) {
    return (27);
  }

  //<< #define ODBCSRV     28
  public static Object $$$ODBCSRV(mContext m$) {
    return (28);
  }

  //<< #define COMMCTRLTYPE    29
  public static Object $$$COMMCTRLTYPE(mContext m$) {
    return (29);
  }

  //<< #define DBXDMNTYPE  30
  public static Object $$$DBXDMNTYPE(mContext m$) {
    return (30);
  }

  //<< #define ECPWorker   31
  public static Object $$$ECPWorker(mContext m$) {
    return (31);
  }

  //<< #define ECPCliR     32
  public static Object $$$ECPCliR(mContext m$) {
    return (32);
  }

  //<< #define ECPCliW     33
  public static Object $$$ECPCliW(mContext m$) {
    return (33);
  }

  //<< #define ECPSrvR     34
  public static Object $$$ECPSrvR(mContext m$) {
    return (34);
  }

  //<< #define ECPSrvW     35
  public static Object $$$ECPSrvW(mContext m$) {
    return (35);
  }

  //<< #define TASKTYPE    36
  public static Object $$$TASKTYPE(mContext m$) {
    return (36);
  }

  //<< #define SYSWATCHTYPE    37
  public static Object $$$SYSWATCHTYPE(mContext m$) {
    return (37);
  }

  //<< #define CLNDTYPE    38
  public static Object $$$CLNDTYPE(mContext m$) {
    return (38);
  }

  //<< #define SNMPTYPE    39
  public static Object $$$SNMPTYPE(mContext m$) {
    return (39);
  }

  //<< #define WMITYPE     40
  public static Object $$$WMITYPE(mContext m$) {
    return (40);
  }

  //<< #define MONITORTYPE 41
  public static Object $$$MONITORTYPE(mContext m$) {
    return (41);
  }

  //<< #define MONAPPTYPE  42
  public static Object $$$MONAPPTYPE(mContext m$) {
    return (42);
  }

  //<< #define LDAPTYPE    43
  public static Object $$$LDAPTYPE(mContext m$) {
    return (43);
  }

  //<< #; ;JO2062-
  //<< #define INTERACTIVEJOB(%x) (%x=$$$FOREJOB)!(%x=$$$FORAPPJOB)
  public static Object $$$INTERACTIVEJOB(mContext m$, Object ... _p) {
    mVar p$x = m$.varRef("p$x",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Or((mOp.Equal(p$x.get(),$$$FOREJOB(m$))),(mOp.Equal(p$x.get(),$$$FORAPPJOB(m$)))));
  }

  //<< #define BACKGROUNDJOB(%x) (%x=$$$APPMODE)!(%x=$$$CSPSRV)!(%x=$$$ODBCSRV)!(%x=$$$CDIRECTSRV)!(%x=$$$JOBSRVTYPE)!(%x=$$$MSMACTSRV)
  public static Object $$$BACKGROUNDJOB(mContext m$, Object ... _p) {
    mVar p$x = m$.varRef("p$x",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Or(mOp.Or(mOp.Or(mOp.Or(mOp.Or((mOp.Equal(p$x.get(),$$$APPMODE(m$))),(mOp.Equal(p$x.get(),$$$CSPSRV(m$)))),(mOp.Equal(p$x.get(),$$$ODBCSRV(m$)))),(mOp.Equal(p$x.get(),$$$CDIRECTSRV(m$)))),(mOp.Equal(p$x.get(),$$$JOBSRVTYPE(m$)))),(mOp.Equal(p$x.get(),$$$MSMACTSRV(m$)))));
  }

  //<< #; The following correspond to the above jobtype definitions. Use these
  //<< #; for %SS, JOBEXAM, etc. displays
  //<< #define FOREJOBNAME "shell"
  public static Object $$$FOREJOBNAME(mContext m$) {
    return ("shell");
  }

  //<< #define APPMODENAME
  public static Object $$$APPMODENAME(mContext m$) {
    return null;
  }

  //<< #define FORAPPJOBNAME
  public static Object $$$FORAPPJOBNAME(mContext m$) {
    return null;
  }

  //<< #define CPTYPENAME  "CONTROL"
  public static Object $$$CPTYPENAME(mContext m$) {
    return ("CONTROL");
  }

  //<< #define WDTYPENAME  "WRTDMN"
  public static Object $$$WDTYPENAME(mContext m$) {
    return ("WRTDMN");
  }

  //<< #define GCTYPENAME  "GARCOL"
  public static Object $$$GCTYPENAME(mContext m$) {
    return ("GARCOL");
  }

  //<< #define JDTYPENAME  "JRNDMN"
  public static Object $$$JDTYPENAME(mContext m$) {
    return ("JRNDMN");
  }

  //<< #define ENQTYPENAME "ENQDMN"
  public static Object $$$ENQTYPENAME(mContext m$) {
    return ("ENQDMN");
  }

  //<< #define RDTYPENAME
  public static Object $$$RDTYPENAME(mContext m$) {
    return null;
  }

  //<< #define SLWDTYPENAME "SLAVWD"
  public static Object $$$SLWDTYPENAME(mContext m$) {
    return ("SLAVWD");
  }

  //<< #define NETSRVTYPENAME  "DCP"
  public static Object $$$NETSRVTYPENAME(mContext m$) {
    return ("DCP");
  }

  //<< #define NETDMNTYPENAME  "DMNNET"
  public static Object $$$NETDMNTYPENAME(mContext m$) {
    return ("DMNNET");
  }

  //<< #define LICENSESRVNAME
  public static Object $$$LICENSESRVNAME(mContext m$) {
    return null;
  }

  //<< #define BMCSRVNAME
  public static Object $$$BMCSRVNAME(mContext m$) {
    return null;
  }

  //<< #define CSPDMNNAME
  public static Object $$$CSPDMNNAME(mContext m$) {
    return null;
  }

  //<< #define DTMSRVNAME
  public static Object $$$DTMSRVNAME(mContext m$) {
    return null;
  }

  //<< #define DTMNSPSRVNAME
  public static Object $$$DTMNSPSRVNAME(mContext m$) {
    return null;
  }

  //<< #define SHADMASTSRVNAME
  public static Object $$$SHADMASTSRVNAME(mContext m$) {
    return null;
  }

  //<< #define SHADSRVNAME
  public static Object $$$SHADSRVNAME(mContext m$) {
    return null;
  }

  //<< #define SHADCLISRVNAME
  public static Object $$$SHADCLISRVNAME(mContext m$) {
    return null;
  }

  //<< #define RCVDMNTYPENAME
  public static Object $$$RCVDMNTYPENAME(mContext m$) {
    return null;
  }

  //<< #define SHUTDOWNJOBNAME
  public static Object $$$SHUTDOWNJOBNAME(mContext m$) {
    return null;
  }

  //<< #define JOBSRVTYPENAME  "JOBSRV"
  public static Object $$$JOBSRVTYPENAME(mContext m$) {
    return ("JOBSRV");
  }

  //<< #define CMTMASTSRVNAME
  public static Object $$$CMTMASTSRVNAME(mContext m$) {
    return null;
  }

  //<< #define MSMACTSRVNAME
  public static Object $$$MSMACTSRVNAME(mContext m$) {
    return null;
  }

  //<< #define CDIRECTSRVNAME
  public static Object $$$CDIRECTSRVNAME(mContext m$) {
    return null;
  }

  //<< #define COBJSRVNAME
  public static Object $$$COBJSRVNAME(mContext m$) {
    return null;
  }

  //<< #define CSPSRVNAME
  public static Object $$$CSPSRVNAME(mContext m$) {
    return null;
  }

  //<< #define ODBCSRVNAME
  public static Object $$$ODBCSRVNAME(mContext m$) {
    return null;
  }

  //<< #define COMMCTRLTYPENAME
  public static Object $$$COMMCTRLTYPENAME(mContext m$) {
    return null;
  }

  //<< #define DBXDMNTYPENAME  "EXPDMN"
  public static Object $$$DBXDMNTYPENAME(mContext m$) {
    return ("EXPDMN");
  }

  //<< #define ECPWorkerNAME   "ECPWORK"
  public static Object $$$ECPWorkerNAME(mContext m$) {
    return ("ECPWORK");
  }

  //<< #define ECPCliRNAME
  public static Object $$$ECPCliRNAME(mContext m$) {
    return null;
  }

  //<< #define ECPCliWNAME
  public static Object $$$ECPCliWNAME(mContext m$) {
    return null;
  }

  //<< #define ECPSrvRNAME
  public static Object $$$ECPSrvRNAME(mContext m$) {
    return null;
  }

  //<< #define ECPSrvWNAME
  public static Object $$$ECPSrvWNAME(mContext m$) {
    return null;
  }

  //<< #define TASKNAME "TASKMGR"
  public static Object $$$TASKNAME(mContext m$) {
    return ("TASKMGR");
  }

  //<< #define CLNDNAME "CLEANDMN"
  public static Object $$$CLNDNAME(mContext m$) {
    return ("CLEANDMN");
  }

  //<< #define SYSWATCHNAME "SYSWATCH"
  public static Object $$$SYSWATCHNAME(mContext m$) {
    return ("SYSWATCH");
  }

  //<< 
  //<< #; size of ttyhash[] array
  //<< #define ttyhashtopnum    $ZU(40,0,66)
  public static Object $$$ttyhashtopnum(mContext m$) {
    return (m$.Fnc.$zutil(40,0,66));
  }

  //<< #;  ttyentry structure definitions
  //<< #define ttypid(%x)       %x+$ZU(40,33,0)
  public static Object $$$ttypid(mContext m$, Object ... _p) {
    mVar p$x = m$.varRef("p$x",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Add(p$x.get(),m$.Fnc.$zutil(40,33,0)));
  }

  //<< #define ttynamlen(%x)    %x+$ZU(40,33,1)
  public static Object $$$ttynamlen(mContext m$, Object ... _p) {
    mVar p$x = m$.varRef("p$x",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Add(p$x.get(),m$.Fnc.$zutil(40,33,1)));
  }

  //<< #define ttylow8(%x)      %x+$ZU(40,33,2)
  public static Object $$$ttylow8(mContext m$, Object ... _p) {
    mVar p$x = m$.varRef("p$x",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Add(p$x.get(),m$.Fnc.$zutil(40,33,2)));
  }

  //<< #define ttynam(%x)       %x+$ZU(40,33,3)
  public static Object $$$ttynam(mContext m$, Object ... _p) {
    mVar p$x = m$.varRef("p$x",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (mOp.Add(p$x.get(),m$.Fnc.$zutil(40,33,3)));
  }

  //<< #; ;JO2062+
  //<< #; PEXSHUTDOWN and PEXKILLJOB are exit code values for
  //<< #; $ZU(4,pid,exitcode). Certain processes will not respond to
  //<< #; resjob (see jtinfo table) unless one of these codes is
  //<< #; specified. See pidtab.h for more info.
  //<< #define PEXSHUTDOWN $ZU(40,0,79)
  public static Object $$$PEXSHUTDOWN(mContext m$) {
    return (m$.Fnc.$zutil(40,0,79));
  }

  //<< #define PEXKILLDMN  $ZU(40,0,80)
  public static Object $$$PEXKILLDMN(mContext m$) {
    return (m$.Fnc.$zutil(40,0,80));
  }

  //<< #;
  //<< #; The following return 1 if the pid/job# is an active
  //<< #; Cache' job (in the pidtab, passes 'checkjob') and 0 if
  //<< #; not.
  //<< #define PIDALIVE(%pid) $ZU(67,%pid)
  public static Object $$$PIDALIVE(mContext m$, Object ... _p) {
    mVar p$pid = m$.varRef("p$pid",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zutil(67,p$pid.get()));
  }

  //<< #define JOBALIVE(%job) $ZU(61,%job)
  public static Object $$$JOBALIVE(mContext m$, Object ... _p) {
    mVar p$job = m$.varRef("p$job",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    return (m$.Fnc.$zutil(61,p$job.get()));
  }

//<< #; JO2062-
}
