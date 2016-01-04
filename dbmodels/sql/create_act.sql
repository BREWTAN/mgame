USE TFG;

drop table if exists T_ACT_INFO;

create table T_ACT_INFO
(
  	ACT_NO			VARCHAR(64)	NOT NULL	COMMENT '账号',
	ACT_NAME		VARCHAR(128)  NOT NULL	COMMENT '账户名称',
	CUST_ID			VARCHAR(128) NOT NULL	COMMENT '客户号',
	MCHNT_ID		VARCHAR(128) NOT NULL	COMMENT '所属商户号',
	ACT_TYPE		VARCHAR(8)	DEFAULT '0'  COMMENT '账户类型',
	MNY_SMB			VARCHAR(4)	DEFAULT 'CNY' COMMENT '货币符号',
	CHANNEL_ID		VARCHAR(64) NOT NULL	COMMENT '渠道号',
	CATALOG			VARCHAR(4)	DEFAULT '0' COMMENT '机构类型',
	ACT_YINIT_BAL	DECIMAL(24,8) DEFAULT 0.0	COMMENT '年初余额',
	ACT_DINIT_BAL	DECIMAL(24,8) DEFAULT 0.0	COMMENT '日初余额',
	ACT_CUR_BAL		DECIMAL(24,8) DEFAULT 0.0	COMMENT '账户当前余额',
	ACT_STAT		DECIMAL(24,8) DEFAULT 0.0	COMMENT '账户状态',
	ACT_MAXOD_AMT	DECIMAL(24,8) DEFAULT 0.0	COMMENT '最大透支金额',
	ACT_CTRL_BAL	DECIMAL(24,8) DEFAULT 0.0	COMMENT '余额最低控制金额',
	ACT_BAL_WARN_FLAG			VARCHAR(2)	COMMENT '余额预警标志',
	CREATE_TIME		TIMESTAMP	COMMENT '创建时间',
	UPDATE_TIME		TIMESTAMP	COMMENT '更新时间',
	MODIFY_ID		VARCHAR(32) COMMENT '更改人',
	MEMO		VARCHAR(1024)  COMMENT '其他信息',
   primary key (ACT_NO)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT = "账户信息表";

create index INX_ACT_INFO_CUSTID on T_ACT_INFO
(
   CUST_ID
);

drop table if exists T_ACT_FUND;

create table T_ACT_FUND
(
	FUND_NO			VARCHAR(128)	NOT NULL	COMMENT '资金账号=账号+账户类型+序号',
  	ACT_NO			VARCHAR(64)	NOT NULL	COMMENT '账号',
	CUST_ID			VARCHAR(128) NOT NULL	COMMENT '客户号',
	MCHNT_ID		VARCHAR(128) NOT NULL	COMMENT '所属商户号',
	ACT_TYPE		VARCHAR(8)	DEFAULT '0'  COMMENT '账户类型',
	MNY_SMB			VARCHAR(4)	DEFAULT 'CNY' COMMENT '货币符号',
	CATALOG			VARCHAR(4)	DEFAULT '0' COMMENT '机构类型',
	CHANNEL_ID		VARCHAR(64) NOT NULL	COMMENT '渠道号',
	CUR_BAL			DECIMAL(24,8) DEFAULT 0.0	COMMENT '当前余额',
	FREEZE_TOTAL	DECIMAL(24,8) DEFAULT 0.0	COMMENT	'冻结金额',
	INCOME_TOTAL	DECIMAL(24,8) DEFAULT 0.0	COMMENT	'收入总额：当日发生交易的总收入金额，如违约金收入',
	PAYOUT_TOTAL	DECIMAL(24,8) DEFAULT 0.0	COMMENT	'支付总额：当日发生交易的总收入金额，如违约金、货款支付',
	FOTBID_AMOUNT	DECIMAL(24,8) DEFAULT 0.0	COMMENT	'禁取资金',
	FOTBID_FLAG		CHAR(1)			COMMENT	'禁取标志，O:禁取，C:不禁取',
	ACT_STAT		VARCHAR(4) DEFAULT 0.0	COMMENT '账户状态',
	ACT_BAL_WARN_FLAG			VARCHAR(2)	COMMENT '余额预警标志',
	UPDATE_ACT_LOG_ID	VARCHAR(64) COMMENT '变动明细的主键',
   primary key (FUND_NO)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT = "账户余额表";


create index INX_T_ACT_FUND_ACT_NO on T_ACT_FUND
(
   ACT_NO
);

create index INX_T_ACT_FUND_LOGID on T_ACT_FUND
(
   UPDATE_ACT_LOG_ID
);

create index INX_T_ACT_FUND_CUSTID on T_ACT_FUND
(
   CUST_ID
);


drop table if exists T_ACT_TRADE_LOGS;

create table T_ACT_TRADE_LOGS
(
  	LOG_UUID         VARCHAR(64)  NOT NULL COMMENT '唯一字段',
	SETT_DATE         VARCHAR(8)  NOT NULL COMMENT '清算日期',
	CONS_DATE         VARCHAR(8)  NOT NULL COMMENT '委托日期',
	TX_SNO         VARCHAR(128)  NOT NULL COMMENT '交易序号',
	SEND_MCHNT_ID         VARCHAR(128)   COMMENT '发起商户号',
	TRANS_CODE         VARCHAR(8)  COMMENT '交易代号',
	SUB_TRANS_CODE         VARCHAR(32)  COMMENT '交易子代号',
	FUND_NO         VARCHAR(64)  NOT NULL COMMENT '资金账号',
	ACT_NO         VARCHAR(64)  NOT NULL COMMENT '账号',
	BIZ_TYPE         VARCHAR(8)  COMMENT '业务类型',
	BIZ_DTL_TYPE         VARCHAR(8)   COMMENT '业务种类',
	DEBT_CUST_ID         VARCHAR(128)  NOT NULL COMMENT '借记客户号转出账户',
	CRDT_CUST_ID         VARCHAR(128)  NOT NULL COMMENT '贷记客户号转入账户',
	DC_TYPE         VARCHAR(8)  NOT NULL COMMENT '借贷类型',
	AMT         DECIMAL(24,8)  NOT NULL COMMENT '发生额',
	CNT         INT	  NOT NULL COMMENT '发生总数',
	FLAG_CANCEL		CHAR(1)	COMMENT '冲销标志C:冲销，B:被冲销',
	RELATED_TRANS_ID	VARCHAR(64) COMMENT '相关流水ID，用于冲销',
	STATUS		VARCHAR(4) DEFAULT '0000' COMMENT '状态：0000新建，0001已更新到余额表，0002取消，0003已清空到历史',  
	ACT_BAL_AFTER         DECIMAL(24,8)  NOT NULL COMMENT '变动后账户余额',
	ACT_BAL_BEFORE         DECIMAL(24,8)  NOT NULL COMMENT '变动前账户余额',
	EXT_ID1		VARCHAR(64)  COMMENT '扩展id1',	
	EXT_ID2		VARCHAR(64)  COMMENT '扩展id2',	
	EXT_COMMETS		VARCHAR(256)  COMMENT '扩展信息',	
	CREATE_TIME         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
	UPDATE_TIME         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
   primary key (LOG_UUID)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT = "账务明细表";


create index T_ACT_LOGS_ACT_NO on T_ACT_TRADE_LOGS
(
   ACT_NO
);
create index T_ACT_LOGS_FUND_NO on T_ACT_TRADE_LOGS
(
   FUND_NO
);


drop table if exists T_ACT_TRADE_LOGS_HIS;

create table T_ACT_TRADE_LOGS_HIS
(
  	LOG_UUID         VARCHAR(64)  NOT NULL COMMENT '唯一字段',
	SETT_DATE         VARCHAR(8)  NOT NULL COMMENT '清算日期',
	CONS_DATE         VARCHAR(8)  NOT NULL COMMENT '委托日期',
	TX_SNO         VARCHAR(128)  NOT NULL COMMENT '交易序号',
	SEND_MCHNT_ID         VARCHAR(128)   COMMENT '发起商户号',
	TRANS_CODE         VARCHAR(8)  COMMENT '交易代号',
	SUB_TRANS_CODE         VARCHAR(32)  COMMENT '交易子代号',
	FUND_NO         VARCHAR(64)  NOT NULL COMMENT '资金账号',
	ACT_NO         VARCHAR(64)  NOT NULL COMMENT '账号',
	BIZ_TYPE         VARCHAR(8)  COMMENT '业务类型',
	BIZ_DTL_TYPE         VARCHAR(8)   COMMENT '业务种类',
	DEBT_CUST_ID         VARCHAR(128)  NOT NULL COMMENT '借记客户号转出账户',
	CRDT_CUST_ID         VARCHAR(128)  NOT NULL COMMENT '贷记客户号转入账户',
	DC_TYPE         VARCHAR(8)  NOT NULL COMMENT '借贷类型',
	AMT         DECIMAL(24,8)  NOT NULL COMMENT '发生额',
	FLAG_CANCEL		CHAR(1)	COMMENT '冲销标志C:冲销，B:被冲销',
	RELATED_TRANS_ID	VARCHAR(64) COMMENT '相关流水ID，用于冲销',
	STATUS		VARCHAR(4) DEFAULT '0000' COMMENT '状态：0000新建，0001已更新到余额表，0002取消，0003已清空到历史',
	ACT_BAL_AFTER         DECIMAL(24,8)  NOT NULL COMMENT '变动后账户余额',
	ACT_BAL_BEFORE         DECIMAL(24,8)  NOT NULL COMMENT '变动前账户余额',
	CREATE_TIME         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
	UPDATE_TIME         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
   primary key (LOG_UUID)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT = "账务明细表历史";


create index T_ACT_LOGS_HIS_ACT_NO on T_ACT_TRADE_LOGS_HIS
(
   ACT_NO
);
create index T_ACT_LOGS_HIS_FUND_NO on T_ACT_TRADE_LOGS_HIS
(
   FUND_NO
);

create index T_ACT_LOGS_HIS_SETT_DATE on T_ACT_TRADE_LOGS_HIS
(
   SETT_DATE
);




drop table if exists T_ACT_INTEREST;

create table T_ACT_INTEREST(
	INST_LOGID	VARCHAR(32)		NOT NULL,	
	INTEREST_DATE	VARCHAR(8)	COMMENT	'结息日',
	FUND_NO		VARCHAR(74)	COMMENT	'资金账号',
	ACT_NO		VARCHAR(64)	COMMENT	'账号',
	INTEREST_TYPE	VARCHAR(2)	COMMENT	'结息类型：0-季度结息；1-销户结息',
	INTEREST_AMOUNT	 DECIMAL(24,8)	COMMENT	'结息金额',
	GMT_CREATE	TIMESTAMP	COMMENT	'创建时间',
	GMT_MODIFY	TIMESTAMP	COMMENT	'最后修改时间',
	TRADE_DATE	VARCHAR(8)	COMMENT	'交易日',
	RATE_VALUE	 DECIMAL(19,8)COMMENT	'年利率',
	UNIT_NO	VARCHAR(8)	COMMENT	'银行号(或者发起计息的机构号)',
	primary key (INST_LOGID)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT = "计息明细表";


create index IDX_ACT_INTEREST_ACT_NO on T_ACT_INTEREST
(
   ACT_NO
);
create index IDX_ACT_INTEREST_FUN_NO on T_ACT_INTEREST
(
   FUND_NO
);
