USE TFG;


drop table if exists T_SYS_BRANCH;

drop table if exists T_SYS_BUSINESS;

drop table if exists T_SYS_MENU;

drop table if exists T_SYS_ROLE;

drop table if exists T_SYS_ROLE_MENU;

drop table if exists T_SYS_ROLE_MUTEX;

drop table if exists T_SYS_RSP_CODE;

drop table if exists T_SYS_USER;

drop table if exists T_SYS_USER_ROLE;




/*==============================================================*/
/* Table: T_SYS_BRANCH                                          */
/*==============================================================*/
create table T_SYS_BRANCH
(
   ID					VARCHAR(32) not null,
   BRANCH_ID            VARCHAR(38) not null,
   BRANCH_DESC          VARCHAR(200),
   BRANCH_NAME          VARCHAR(100),
   BRANCH_MANAGER       VARCHAR(50),
   MOBILE               VARCHAR(20),
   BEGIN_TIME           datetime,
   END_TIME             datetime,
   PARENT_ID            VARCHAR(38) not null,
   LEAF_FLAG            int not null COMMENT '1是，0不是',
   BRANCH_SEQ           int not null,
   LEVEL                int not null,
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = "(按层级编码，三位一级，100开头，顺序递增，有系统自动控制)',";

/*==============================================================*/
/* Table: T_SYS_BUSINESS                                        */
/*==============================================================*/
create table T_SYS_BUSINESS
(
   BUSINESS_ID          VARCHAR(38) not null,
   BUSINESS_NAME        VARCHAR(100),
   BUSINESS_DESC        VARCHAR(100),
   BUSINESS_MANAGER     VARCHAR(100),
   BUSINESS_MOBILE      VARCHAR(100),
   BUSINESS_SEQ         int,
   BEGIN_TIME           datetime,
   END_TIME             datetime,
   STATUS               int,
   BUSINESS_DATA_PERMISSION int COMMENT '系统分配值，从1,2,4,8,16,32.。。。。',
   primary key (BUSINESS_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

/*==============================================================*/
/* Table: T_TRADE_PARAM                                             */
/*==============================================================*/
drop table if exists T_SYS_PARAM;
create table T_SYS_PARAM
(
   PARAM_ID             VARCHAR(32) not null,
   PARAM_TYPE           VARCHAR(32),
   PARAM_VALUE          VARCHAR(200),
   DSC                  VARCHAR(100),
   CRT_TIME             VARCHAR(14),
   FIELD1               VARCHAR(100),
   FIELD2               VARCHAR(200),
   FIELD3               VARCHAR(400),
   primary key (PARAM_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = "保存 系统的 静态参数";

/*==============================================================*/
/* Table: T_SYS_MENU                                            */
/*==============================================================*/
create table T_SYS_MENU
(
   MENU_ID              int not null,
   MENU_NAME            VARCHAR(100),
   MENU_DESC            VARCHAR(200),
   MENU_SEQ             int,
   MENU_URL             VARCHAR(200),
   PARENT_ID            int,
   LEAF_FLAG            int,
   LEVEL                int,
   ICON                 VARCHAR(50),
   primary key (MENU_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

/*==============================================================*/
/* Table: T_SYS_ROLE                                            */
/*==============================================================*/
create table T_SYS_ROLE
(
   ROLE_ID              VARCHAR(38)
                         not null,
   ROLE_NAME            VARCHAR(50),
   ROLE_DESC            VARCHAR(100),
   STATUS               int,
   primary key (ROLE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

/*==============================================================*/
/* Table: T_SYS_ROLE_MENU                                       */
/*==============================================================*/
create table T_SYS_ROLE_MENU
(
   ID                   VARCHAR(38)
                         not null,
   MENU_ID              int,
   ROLE_ID              VARCHAR(38),
   STATUS               int,
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

/*==============================================================*/
/* Table: T_SYS_ROLE_MUTEX                                      */
/*==============================================================*/
create table T_SYS_ROLE_MUTEX
(
   ROLE_MUTEX_ID        VARCHAR(38) not null,
   ROLE_ID_A            VARCHAR(38),
   ROLE_ID_B            VARCHAR(38),
   STATUS               int,
   primary key (ROLE_MUTEX_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

/*==============================================================*/
/* Table: T_SYS_RSP_CODE                                        */
/*==============================================================*/
create table T_SYS_RSP_CODE
(
   ID		VARCHAR(32)not null,
   PROD_ID              VARCHAR(32) not null,
   OUT_RSP_CODE         VARCHAR(20) not null,
   IN_RSP_CODE2         VARCHAR(20) not null,
   RSP_DESC             VARCHAR(100),
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = "保存 产品提供方 与民生宝 之间 的应答码对应关系";

/*==============================================================*/
/* Table: T_SYS_USER                                            */
/*==============================================================*/
create table T_SYS_USER
(
   USER_ID              VARCHAR(38)
                         not null,
   BRANCH_ID            VARCHAR(38),
   LOGIN_NAME           VARCHAR(32)
                         not null,
   USER_NAME            VARCHAR(50)
                         not null,
   MOBILE               VARCHAR(20),
   USER_WORKADDRESS     VARCHAR(100),
   STATUS               VARCHAR(2),
   PASSWORD             VARCHAR(32),
   UPDATE_TIME          datetime,
   CREATE_TIME          datetime,
   CREATED_BY           VARCHAR(32),
   MODIFIED_BY          VARCHAR(32),
   EMAIL                VARCHAR(32),
   DATA_ENVIRON         int,
   ICON                 VARCHAR(100),
   primary key (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

drop table if exists T_SYS_ACTION;

CREATE TABLE T_SYS_ACTION (
  ACTION_ID bigint(20) NOT NULL COMMENT '权限ID',
  ACTION_FLAG VARCHAR(30) NOT NULL COMMENT '权限标识',
  ACTION_NAME VARCHAR(100) NOT NULL COMMENT '权限名称',
  ACTION_DESC VARCHAR(200) DEFAULT NULL COMMENT '权限描述',
  ACTION_MENU bigint(20) NOT NULL COMMENT '所属菜单',
  FIELD1 VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (ACTION_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

drop table if exists T_SYS_ROLE_ACTION;

CREATE TABLE T_SYS_ROLE_ACTION (
  ID char(38) NOT NULL COMMENT '角色权限表ID',
  ACTION_ID bigint(20) DEFAULT NULL COMMENT '权限ID',
  ROLE_ID char(38) DEFAULT NULL COMMENT '角色ID',
  STATUS bigint(20) NOT NULL COMMENT '状态，采用统一状态字典',
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';


/*==============================================================*/
/* Table: T_SYS_USER_ROLE                                       */
/*==============================================================*/
create table T_SYS_USER_ROLE
(
   USER_ROLE_ID         VARCHAR(38) not null,
   ROLE_ID              VARCHAR(64),
   USER_ID              VARCHAR(38),
   STATUS               int,
   primary key (USER_ROLE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


DROP TABLE IF EXISTS T_SYS_OP_LOGS;
CREATE TABLE T_SYS_OP_LOGS (
  ID varchar(64) NOT NULL,
  SKEYS varchar(128) NOT NULL,
  CONTENTS 	varchar(1024) NOT NULL,
  LEVEL	 varchar(4) DEFAULT 'INFO' comment '级别' ,
  CRT_TIME datetime,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '系统操作信息';

create index T_SYS_OP_LOGS_IDX0 on T_SYS_OP_LOGS
(
   LEVEL
);

create index T_SYS_OP_LOGS_IDX1 on T_SYS_OP_LOGS
(
   SKEYS
);





