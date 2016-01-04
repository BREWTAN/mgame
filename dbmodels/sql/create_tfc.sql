USE TFG;



/*==============================================================*/
/* Table    FOR TFC_SYSTEM  ---------                                   */
/*==============================================================*/


DROP TABLE IF EXISTS TFC_CHANNEL_PRODUCT;


/*==============================================================*/
/* Table: TFC_CHANNEL_PRODUCT                                   */
/*==============================================================*/
CREATE TABLE TFC_CHANNEL_PRODUCT
(
   ROW_ID                VARCHAR(32) NOT NULL ,
   GAME_ID               VARCHAR(32) COMMENT '渠道所属游戏',
   CHANNEL_ID            VARCHAR(32) NOT NULL COMMENT '渠道一级编号',
   PRODUCT_ID            VARCHAR(32) NOT NULL COMMENT '渠道二级编号',
   NOTE                 VARCHAR(200),
   AUTHOR               VARCHAR(20),
   RECTIME              DATETIME,
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='只是对货币来源记录明细而用，利于运营';

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
CREATE UNIQUE INDEX INDEX_1 ON TFC_CHANNEL_PRODUCT
(
   CHANNEL_ID,
   PRODUCT_ID
);

DROP TABLE IF EXISTS TFC_COIN_TYPE;

/*==============================================================*/
/* Table: TFC_COIN_TYPE                                         */
/*==============================================================*/
CREATE TABLE TFC_COIN_TYPE
(
   COIN_TYPE_ID               VARCHAR(32) NOT NULL,
   COIN_NAME             VARCHAR(100) NOT NULL,
   COIN_SCRIPT           VARCHAR(200),
   HAVE_CHILD            INT(2),
   CAN_SPLIT             INT(2),
   USE_LEVEL             INT(3),
   PRIMARY KEY (COIN_TYPE_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT= '1:斗地主金币 2:斗地主元宝 等等';


DROP TABLE IF EXISTS TFC_CONFIG_UPDATE_LOG;
/*==============================================================*/
/* Table: TFC_CONFIG_UPDATE_LOG                                 */
/*==============================================================*/
CREATE TABLE TFC_CONFIG_UPDATE_LOG
(
   CONFIG_TYPE           VARCHAR(32) NOT NULL,
   UPDATE_TIME           DATETIME NOT NULL,
   NOTE                 VARCHAR(100) NOT NULL,
   PRIMARY KEY (CONFIG_TYPE)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1:游戏支持货币表数据变化';


DROP TABLE IF EXISTS TFC_GAME_SUPPORT_COIN;
/*==============================================================*/
/* Table: TFC_GAME_SUPPORT_COIN                                  */
/*==============================================================*/
CREATE TABLE TFC_GAME_SUPPORT_COIN
(
   ROW_ID                VARCHAR(32) NOT NULL,
   COIN_TYPE_ID               VARCHAR(32) NOT NULL,
   GAME_ID               VARCHAR(32) NOT NULL,
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1:游戏支持货币表';


DROP TABLE IF EXISTS TFC_ORDER;
/*==============================================================*/
/* Table: TFC_ORDER                                            */
/*==============================================================*/
CREATE TABLE TFC_ORDER
(
   ORDER_ID              VARCHAR(128) NOT NULL COMMENT '与充值系统统一的订单号',
   USER_ID              BIGINT(20) NOT NULL,
   ORDER_STATUS          INT(1) NOT NULL COMMENT '订单状态 未处理0 已处理1已完成2',
   ITEM_ID               VARCHAR(128) NOT NULL COMMENT '产品ID 在充值平台申请的商品id，预留',
   COIN_NUM              BIGINT,
   STORAGE_TIME          DATETIME,
   HANDLE_TIME           DATETIME,
   PRIMARY KEY (ORDER_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='';

DROP TABLE IF EXISTS TFC_ORDER_DETAIL;

/*==============================================================*/
/* Table: TFC_ORDER_DETAIL                                     */
/*==============================================================*/
CREATE TABLE TFC_ORDER_DETAIL
(
   ROW_ID               VARCHAR(32) NOT NULL,
   USER_ID              BIGINT(20),
   HANDLE_TIME           DATETIME,
   HANLDE_STATUS         INT(4) COMMENT '1:正在充值，2:充值完成，3:已经通知用户充值完成',
   NUM_BEFORE            BIGINT,
   CHANGE_NUM            BIGINT,
   NUM_AFTER             BIGINT,
   NOTE                 VARCHAR(128) COMMENT '支付序列号等',
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

DROP TABLE IF EXISTS TFC_USER_COIN;
/*==============================================================*/
/* Table: TFC_USER_COIN                                         */
/*==============================================================*/
CREATE TABLE TFC_USER_COIN
(
   COIN_ROWID            VARCHAR(32) NOT NULL ,
   COIN_TYPE_ID               VARCHAR(32),
   USER_ID               BIGINT(20) NOT NULL,
   START_TIME            DATETIME COMMENT '记录开始时间',
   EXPIRE_TIME           DATETIME COMMENT '保留字段',
   COIN_NUM              BIGINT(20) NOT NULL,
   LOCK_COUNT            BIGINT(10) COMMENT '如果已锁定则此数值递增,解锁递减,可以锁定多次',
   SHOW_CHILD            INT(1) COMMENT '保留字段',
   PRIMARY KEY (COIN_ROWID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户货币表';


DROP TABLE IF EXISTS TFC_USER_COIN_CHANGE_DETAIL;
/*==============================================================*/
/* Table: TFC_USER_COIN_CHANGE_DETAIL                            */
/*==============================================================*/
CREATE TABLE TFC_USER_COIN_CHANGE_DETAIL
(
   COIN_ROW_ID               VARCHAR(32) NOT NULL ,
   COIN_TYPE_ID              VARCHAR(32),
   REC_TIME             DATETIME NOT NULL,
   USER_ID              BIGINT(20) NOT NULL,
   CHANGE_NUM            BIGINT(20) NOT NULL,
   REMAIN_NUM            BIGINT(20) NOT NULL,
   LOCK_ID               VARCHAR(32) COMMENT '如果操作是在锁上面则此值大于0,不在锁上操作为0',
   CHANNEL_ID            VARCHAR(32),
   PRODUCT_ID            VARCHAR(32),
   FLOW_NUMBER           VARCHAR(60) COMMENT '此值应与货币ID一起用来保证交易不会重复',
   USER_IP               VARCHAR(32),
   SERVER_IP             VARCHAR(32),
   GAME_ID               INT COMMENT '查询需要，加上游戏ID',
   PRIMARY KEY (COIN_ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='需要针对此表的货币ID/流水号做频繁查询操作,用这三项保证不重复增加同一流水的记录,但流水号也可以为NULL,系统操作时';

/*==============================================================*/
/* Index: INDEX_GCC_D_1                                         */
/*==============================================================*/
CREATE INDEX INDEX_GCC_D_1 ON TFC_USER_COIN_CHANGE_DETAIL
(
   REC_TIME,
   USER_ID
);

DROP TABLE IF EXISTS TFC_USER_COIN_CHANGE_LIMIT;
/*==============================================================*/
/* Table: TFC_USER_COIN_CHANGE_LIMIT                              */
/*==============================================================*/
CREATE TABLE TFC_USER_COIN_CHANGE_LIMIT
(
   COIN_ROW_ID            VARCHAR(32) NOT NULL COMMENT '自增量',
   IN_NUM                BIGINT(20),
   OUT_NUM               BIGINT(20),
   CHANGE_NUM            BIGINT(20),
   LASTUPDATETIME       DATETIME COMMENT '根据最后变化时间判断此数据是否要删除，减少此表数据量',
   RESETTIME            DATETIME COMMENT '数据重置时间',
   PRIMARY KEY (COIN_ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户货币变化量限制';

DROP TABLE IF EXISTS TFC_USER_COIN_RECLAIM_DETAIL;
/*==============================================================*/
/* Table: TFC_USER_COIN_RECLAIM_DETAIL                           */
/*==============================================================*/
CREATE TABLE TFC_USER_COIN_RECLAIM_DETAIL
(
   ROW_ID                VARCHAR(32) NOT NULL ,
   COIN_TYPE_ID               VARCHAR(32),
   REC_TIME              DATETIME NOT NULL,
   USER_ID               BIGINT(20),
   RECLAIM_NUM           BIGINT(20) NOT NULL,
   REQ_NUM               BIGINT(20) COMMENT '请求变化时的数量',
   CHANGED_NUM           BIGINT(20) COMMENT '超限减去超限量后实际变化量,应与其它明细记录一致',
   LOCK_ID               VARCHAR(32) COMMENT '如果操作是在锁上面则此值大于0,不在锁上操作为0',
   CHANNEL_ID            VARCHAR(32),
   PRODUCT_ID            VARCHAR(32),
   FLOW_NUMBER           VARCHAR(60) COMMENT '此值应与货币ID一起用来保证交易不会重复',
   USER_IP               VARCHAR(16),
   SERVER_IP             VARCHAR(16),
   GAME_ID               VARCHAR(32),
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏货币回收明细表';


DROP TABLE IF EXISTS TFC_USER_LOCK;

/*==============================================================*/
/* Table: TFC_USER_LOCK                                         */
/*==============================================================*/
CREATE TABLE TFC_USER_LOCK
(
   ROW_ID                VARCHAR(32) NOT NULL ,
   LOCK_ID               VARCHAR(32) NOT NULL COMMENT '依据表tb_sequence中的seq_lockid这条记录的current_value定',
   USER_ID               VARCHAR(32) NOT NULL,
   COIN_ROW_ID           VARCHAR(32) COMMENT '自增量',
   GAME_ID               VARCHAR(32),
   SERVER_IP             VARCHAR(16) NOT NULL,
   SERVER_NAME           VARCHAR(20) COMMENT '此项暂时没有用到,游戏服务器每盘游戏的GUID',
   COIN_TYPE_ID               VARCHAR(32) NOT NULL,
   LOCK_NUM              BIGINT(20) NOT NULL,
   REC_DATE              DATETIME NOT NULL,
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户货币锁定表';

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
CREATE INDEX INDEX_1 ON TFC_USER_LOCK
(
   USER_ID,
   COIN_TYPE_ID
);

DROP TABLE IF EXISTS TFC_USE_LOCK_DETAIL;
/*==============================================================*/
/* Table: TFC_USE_LOCK_DETAIL                                  */
/*==============================================================*/
CREATE TABLE TFC_USE_LOCK_DETAIL
(
   ROW_ID                VARCHAR(32) NOT NULL,
   COIN_TYPE_ID               VARCHAR(32) NOT NULL,
   REC_TIME              DATETIME NOT NULL,
   ACTIONTYPE            INT(1) NOT NULL COMMENT '1:加锁,2:解锁',
   LOCK_ID               VARCHAR(32) NOT NULL COMMENT '依据表tb_sequence中的seq_lockid这条记录的current_value定',
   USER_ID               VARCHAR(32) NOT NULL,
   SERVER_IP             VARCHAR(16) NOT NULL,
   GAME_ID               VARCHAR(32),
   SERVER_NAME           VARCHAR(20) COMMENT '此项暂时没有用到,游戏服务器每盘游戏的GUID',
   LOCK_NUM              BIGINT(20) NOT NULL COMMENT '锁上数量，加锁时指加锁后数量，解锁时指加锁前数量',
   CHANGE_NUM            BIGINT(20) COMMENT '变化量，加锁时此值为0，解锁时为解锁请求变化量',
   REMAIN_NUM            BIGINT(20) NOT NULL COMMENT '货币剩余数量，加锁时全锁为0，部分锁则为剩余数量，解锁时为解锁后剩余数量',
   OTHER_LOCK_NUM         BIGINT(20),
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户货币加解锁明细表';



DROP TABLE IF EXISTS TFC_USER_LOCK_CHANGE_DETAIL;
/*==============================================================*/
/* Table: TFC_USER_LOCK_CHANGE_DETAIL                            */
/*==============================================================*/
CREATE TABLE TFC_USER_LOCK_CHANGE_DETAIL
(
   ROW_ID               VARCHAR(32) NOT NULL,
   COIN_TYPE_ID              VARCHAR(32) NOT NULL,
   REC_TIME              DATETIME NOT NULL,
   LOCK_ID               VARCHAR(32) NOT NULL COMMENT '依据表tb_sequence中的seq_lockid这条记录的current_value定',
   USER_ID               VARCHAR(32) NOT NULL,
   CHANGE_NUM            BIGINT(20) NOT NULL COMMENT '此次操作锁上将要变化量',
   LOCKED_NUM            BIGINT(20) NOT NULL COMMENT '未变化之前锁上数量',
   CHANNEL_ID            VARCHAR(32),
   PRODUCT_ID            VARCHAR(32),
   FLOW_NUMBER           VARCHAR(60) COMMENT '此值应与货币ID一起用来保证交易不会重复',
   USER_IP               VARCHAR(16),
   SERVER_IP             VARCHAR(16),
   GAME_ID               VARCHAR(32) COMMENT '统计需要，20120615新增游戏ID',
   PRIMARY KEY (ROW_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户货币锁上变化明细';


DROP TABLE IF EXISTS TFC_USER_LOCKCS;
/*==============================================================*/
/* Table: TFC_USER_LOCKCS                                       */
/*==============================================================*/
CREATE TABLE TFC_USER_LOCKCS
(
   USER_ID               VARCHAR(32) NOT NULL,
   READ_COUNT            BIGINT(20),
   WRITE_COUNT           BIGINT(20),
   PRIMARY KEY (USER_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='由数据表实现用户操作临界区机制,在需要临界操作时先更新此表中用户记录';


DROP TABLE IF EXISTS TFC_SEQUENCE;
/*==============================================================*/
/* Table: TFC_SEQUENCE                                           */
/*==============================================================*/
CREATE TABLE TFC_SEQUENCE
(
   NAME                 VARCHAR(50) NOT NULL,
   CURRENT_VALUE        BIGINT(20) NOT NULL,
   _INCREMENT           INT NOT NULL,
   PRIMARY KEY (NAME)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表数据设置(此表主要负责锁ID的全局计数值)需要执行的初始化sql语句 Insert int';

/*==============================================================*/
/* Index: I_NAME                                                */
/*==============================================================*/
CREATE INDEX I_NAME ON TFC_SEQUENCE
(
   NAME
);
