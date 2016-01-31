USE TFG;

 #--用户相关
DROP TABLE IF EXISTS `TGC_USER_TYPE_CFG`;


CREATE TABLE `TGC_USER_TYPE` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户类型ID：0会员，1总代,2一级代理，3代理',
    `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '类型从属关系,即上级ID',
    `CN_NAME` varchar(32) DEFAULT '' COMMENT '组中文名称',
    `EN_NAME` varchar(32) DEFAULT '' COMMENT '组英文名称',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有效 1有效 0无效',
    `USER_ID` bigint(20) NOT NULL COMMENT '更新人的数字ID',
    `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
    `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型配置表';


DROP TABLE IF EXISTS `TGC_USER_TYPE_AUTH_CFG`;


CREATE TABLE `TGC_USER_TYPE_AUTH` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `CN_NAME` varchar(32) DEFAULT '' COMMENT '权限中文名称',
    `EN_NAME` varchar(32) DEFAULT '' COMMENT '权限英文名称',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有效 1有效 0无效',
    `USER_ID` bigint(20) NOT NULL COMMENT '更新人的数字ID',
    `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
    `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型权限配置表';


DROP TABLE IF EXISTS `TGC_USER_TYPE_AUTH`;


CREATE TABLE `TGC_USER_TYPE_AUTH` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `TYPE_ID` bigint(20) NOT NULL COMMENT '用户类型ID,对应TGC_USER_TYPE_CFG.ID',
    `TYPE_AUTH_ID` bigint(20) NOT NULL COMMENT '类型权限ID,对应TGC_USER_TYPE_AUTH_CFG.ID',
    `USER_ID` bigint(20) NOT NULL COMMENT '变更人的数字ID',
    `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型权限表';


DROP TABLE IF EXISTS `TGC_USER_INFO`;


CREATE TABLE `TGC_USER_INFO` (
    `USER_ID` bigint(20) NOT NULL COMMENT '用户数字ID',
    `USER_NAME` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
    `NICKNAME` varchar(32) DEFAULT '' COMMENT '昵称',
    `PASSWORD` varchar(32) DEFAULT '' COMMENT '登录密码 md5加密处理',
    `GENDER` enum('保密', '男', '女')CHARACTER SET utf8 NOT NULL DEFAULT '保密' COMMENT '0:保密，1:男，2:女',
    `BIRTHDAY` date DEFAULT NULL COMMENT '生日',
    `COUNTRY` varchar(16) DEFAULT '' COMMENT '国籍',
    `PROVINCE` varchar(16) DEFAULT '' COMMENT '所省份',
    `CITY` varchar(16) DEFAULT '' COMMENT '所属市',
    `ADDRESS` varchar(64) DEFAULT '' COMMENT '用户地址',
    `QQ` varchar(32) DEFAULT '' COMMENT 'QQ号',
    `WEIXIN` varchar(32) DEFAULT '' COMMENT '微信号',
    `WEIBO` varchar(20) DEFAULT '' COMMENT '微博ID',
    `MOBILE` varchar(32) DEFAULT '' COMMENT '手机号',
    `EMAIL` varchar(64) DEFAULT '' COMMENT '电邮地址',
    `PHONE` varchar(32) DEFAULT '' COMMENT '固话',
    `UPDATE_TIME` datetime DEFAULT NULL COMMENT '个人信息更新时间',
    `REG_TIME` datetime DEFAULT NULL COMMENT '注册时间',
    `REG_IP` varchar(20) DEFAULT '' COMMENT '注册时用户IP',
    `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后一次登录时间',
    `LAST_LOGIN_IP` varchar(20) DEFAULT '' COMMENT '最后一次登录时的用户ip',
    `LAST_LOGIN_TERMINAL` int(2) DEFAULT '0' COMMENT '最后登录终端， 1:browser 2:android  3:ios',
    `LAST_LOGIN_SYSINFO` varchar(40) DEFAULT '' COMMENT '最后登录终端的系统信息， 如：iphone6 4G',
    `USER_STATUS` enum('N', 'F', 'D') DEFAULT 'N' NOT NULL COMMENT '会员状态 0:正常，1:冻结，2:删除',
    `TYPE_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户类型ID,对应TGC_USER_TYPE_CFG.ID',
    `USER_AUTH` int(4) NOT NULL DEFAULT '0' COMMENT '用户权限：1VIP,.....',
    `REALNAME` varchar(16) DEFAULT '' COMMENT '用户真实姓名',
    `ID_CARD` varchar(20) DEFAULT '' COMMENT '身份证号码',
    `COINS` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '可用资产',
    `COINS_FREEZE` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '冻结资产',
    `COINS_PWD` varchar(32) DEFAULT '' COMMENT '货币操作密码，充值提款密码',
    `PARENT_U_ID` bigint(20) DEFAULT NULL COMMENT '会员从属关系,即上级代理ID',
    `SUBUSER_MAXNUM` int(4) NOT NULL DEFAULT '0' COMMENT '可以开户最大人数限制，即下级用户数',
    PRIMARY KEY (`USER_ID`),
    UNIQUE KEY `USER_NAME` (`USER_NAME`),
    KEY `PARENT_U_ID` (`PARENT_U_ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';


DROP TABLE IF EXISTS `TGC_USER_BANK`;


CREATE TABLE `TGC_USER_BANK` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `USER_ID` bigint(20) NOT NULL COMMENT '用户数字ID',
    `BANK_ID` bigint(20) NOT NULL COMMENT '银行ID，见银行信息表',
    `USERNAME` varchar(16) NOT NULL DEFAULT '' COMMENT '银行开户名',
    `ACCOUNT` varchar(64) NOT NULL DEFAULT '' COMMENT '银行账号',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1有效 0无效',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户银行帐户信息';


DROP TABLE IF EXISTS `TGC_USER_WITHDRAW`;


CREATE TABLE `TGC_USER_WITHDRAW` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `USER_ID` bigint(20) NOT NULL COMMENT '用户数字ID',
    `FOLLOWNO` varchar(128) NOT NULL DEFAULT '' COMMENT '订单流水号',
    `APPLYTIME` datetime DEFAULT NULL COMMENT '申请时间',
    `COINS` float(10 , 2 ) NOT NULL DEFAULT '0' COMMENT '提现金额',
    `BANK_ID` bigint(20) NOT NULL COMMENT '银行ID',
    `USERNAME` varchar(16) NOT NULL DEFAULT '' COMMENT '银行开户名',
    `ACCOUNT` varchar(64) NOT NULL DEFAULT '' COMMENT '银行帐号',
    `STATUS` tinyint(4) NOT NULL DEFAULT '1' COMMENT '提现状态：1用户申请，2已取消，3已支付，4提现失败, 5后台删除，0确认到帐',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户提现过程表';


CREATE INDEX TGC_USER_WITHDRAW_IDX1 ON TGC_USER_WITHDRAW (USER_ID,FOLLOWNO);


DROP TABLE IF EXISTS `TGC_USER_RECHARGE`;


CREATE TABLE `TGC_USER_RECHARGE` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `USER_ID` bigint(20) NOT NULL COMMENT '用户数字ID',
    `FOLLOWNO` varchar(128) NOT NULL DEFAULT '' COMMENT '订单流水号',
    `AMOUNT` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '充值资金',
    `COINS` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '充值前用户资金',
    `COINS_FREEZE` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '充值前用户冻结资金',
    `USER_BANK_ID` bigint(20) NOT NULL COMMENT '用户银行信息ID，保留字段',
    `ACTION_UID` bigint(20) NOT NULL COMMENT '操作用户数字ID,即上级代理ID',
    `ACTION_IP` varchar(20) NOT NULL DEFAULT '' COMMENT '操作用户IP',
    `ACTION_TIME` datetime DEFAULT NULL COMMENT '操作时间',
    `RECHARGE_TIME` datetime DEFAULT NULL COMMENT '到帐时间',
    `STATUS` tinyint(1) NOT NULL DEFAULT '0' COMMENT '充值订单状态：0申请，1成功到账',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值过程表';


CREATE INDEX TGC_USER_RECHARGE_IDX1 ON TGC_USER_RECHARGE (USER_ID,FOLLOWNO);


DROP TABLE IF EXISTS `TGC_USER_COINCHANGE_DETAIL`;


CREATE TABLE `TGC_USER_COINCHANGE_DETAIL` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `USER_ID` bigint(20) NOT NULL COMMENT '用户数字ID',
    `USER_NAME` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
    `LTYPE_ID` tinyint(4) NOT NULL DEFAULT '0' COMMENT '彩种类，对应TGC_LTYPE.ID，如果与彩票无关，这采用默认值(比如充值)',
    `LPLAY_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '玩法，对应TGC_LPLAY.ID',
    `COINS` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '流动资金',
    `FCOINS` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '流动冻结资金，消费的用负值，充值的用正',
    `USER_COIN` float(10 , 2 ) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
    `CHANGE_TYPE` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '1充值，2返点，3提现失败从冻结资金返回，4撤单资金，5中奖派奖... ，101提现，102投注，103提现资金冻结，104开奖扣除冻结资金...',
    `ACTION_UID` bigint(20) NOT NULL COMMENT '操作用户数字ID',
    `ACTION_IP` varchar(20) NOT NULL DEFAULT '' COMMENT '由系统生成或管理员操作的采用默认值',
    `ACTION_TIME` datetime DEFAULT NULL COMMENT '操作时间',
    `REMARK` varchar(255) DEFAULT '' COMMENT '备注信息',
    PRIMARY KEY (`ID`),
    KEY `USER_ID` (`USER_ID`),
    KEY `LTYPE_ID` (`LTYPE_ID`),
    KEY `CHANGE_Type` (`CHANGE_Type`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户资金流动明细表，即账变信息表';


DROP TABLE IF EXISTS `TGC_USER_PLAY_CONFIG`;


CREATE TABLE `TGC_USER_PLAY_CONFIG` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `USER_ID` bigint(20) NOT NULL COMMENT '用户数字ID',
    `PLAY_ID` bigint(20) NOT NULL COMMENT '玩法ID',
    `REBATE` float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '返点',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有效 1有效 0无效',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户可参与的玩法与返点配置表';

 # ----------------------------
# --游戏相关表
# ----------------------------
#------彩种管理-----------------------------------------
DROP TABLE IF EXISTS `TGC_LT_TYPE`;

CREATE TABLE `TGC_LT_TYPE` (
    `LT_TYPE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称，如：数字型、乐透同区型等',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `REMARK` varchar(255) DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`LT_TYPE_ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='彩种类型表';


DROP TABLE IF EXISTS `TLT_TYPE`;


CREATE TABLE `TLT_TYPE` (
    `LTYPE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LT_TYPE_ID` bigint(20) NOT NULL COMMENT '所属类型，对应TGC_LT_TYPE.LT_TYPE_ID',
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `CODE_LIST` varchar(32) DEFAULT '0,1,2,3,4,5,6,7,8,9' COMMENT '号码形态之：彩票可选号码列表，用半角逗号分隔',
    `CODE_LEN` int(4) DEFAULT '0' COMMENT '号码形态之：号码总长度',
    `SORT` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序，一般显示用',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停售 1销售中',
    `REMARK` varchar(255) DEFAULT NULL COMMENT '备注,描述',
    `DELAY_TIME` int(4) DEFAULT '0' COMMENT '延后时长，秒？？？？？？',
    `CATCH_CODE_COUNT` int(4) DEFAULT '0' COMMENT '抓号次数',
    `CATCH_CODE_INTERVAL` int(4) DEFAULT '0' COMMENT '抓号间隔时长，秒，抓号频率最低不得低于30秒，最高不得高于300秒',
    `MIN_LEFT` float(10 , 3 ) DEFAULT '0.000' COMMENT '最小剩余利润率',
    `MIN_SPREAD` float(10 , 3 ) DEFAULT '0.000' COMMENT '上下级最小返点差',
    `ISSUE_NO_FMT` varchar(16) DEFAULT 'yyyymmdd-nnn' COMMENT '期号格式,yyyymmdd-nnn',
    `CLEAR_YMD` varchar(8) DEFAULT 'Y,M,D' COMMENT '清零规则，Y年清零，M月清零，D日清零；以逗号分隔，有哪个字母就清零',
    `LOTTERY_CYCLE` varchar(16) DEFAULT '1,2,3,4,5,6,7' COMMENT '开奖周期,1星期一 2星期二 3星期三 4星期四 5星期五 6星期六 7星期日',
    `CLOSE_STIME` datetime DEFAULT NULL COMMENT '休市开始时间',
    `CLOSE_ETIME` datetime DEFAULT NULL COMMENT '休市结束时间',
    `REBATE` float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认返点',
    `DELO_REBATE` float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认不定位返点',
    PRIMARY KEY (`LTYPE_ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='彩种（又称游戏）信息表';


DROP TABLE IF EXISTS `TLT_PLAYVGROUP`;


CREATE TABLE `TLT_PLAYVGROUP` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `DEFAULT_PG` int(11) DEFAULT NULL COMMENT '默认显示哪个玩法组',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩法群信息表，即虚拟玩法组，是逻辑分组层';


DROP TABLE IF EXISTS `TLT_PLAYGROUP`;


CREATE TABLE `TLT_PLAYGROUP` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `LPVG_ID` bigint(20) NOT NULL COMMENT '所属玩法群，对应TLT_PLAYVGROUP.ID',
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `LOCK_TABLE` varchar(64) DEFAULT NULL COMMENT '封锁表名称',
    `AWARD_LEVEL` int(1) DEFAULT '0' COMMENT '奖级，1单奖级 2多奖级',
    `COST` float(10 , 2 ) DEFAULT '0.00' COMMENT '全包成本',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停售 1销售中',
    `REMARK` varchar(255) DEFAULT NULL COMMENT '备注,描述',
    `REBATE` float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认返点',
    `DELO_REBATE` float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认不定位返点',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩法组信息表';


DROP TABLE IF EXISTS
 `TLT_PLAY`;


CREATE TABLE `TLT_PLAY` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `LPG_ID` bigint(20) NOT NULL COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `LOCK_FUNC` varchar(64) DEFAULT NULL COMMENT '封锁表初始化函数',
    `LOCK_TABLE` varchar(64) DEFAULT NULL COMMENT '封锁表名称',
    `LOCK_STATUS` tinyint(1) DEFAULT '0' COMMENT '封锁状态，0未封锁 1封锁',
    `MODE_YJFL` varchar(16) DEFAULT '1,2,3,4' COMMENT '元角模式，1支持元,2支持角 3支持分 4支持厘',
    `ISANDVALUE` tinyint(1) DEFAULT '0' COMMENT '是否为和值玩法，0否 1是',
    `MAX_BUY_CODENUM` int(10) DEFAULT '0' COMMENT '最大购买号码个数，0表示无限制',
    `WIN_FUNC` varchar(64) DEFAULT NULL COMMENT '中奖函数名',
    `WIN_BEGINPOS` int(4) DEFAULT NULL COMMENT '中奖号码起始位置',
    `WIN_CODENUM` int(4) DEFAULT NULL COMMENT '中奖号码个数',
    `WIN_DISCONTINUOUSPOS` int(4) DEFAULT NULL COMMENT '非连续中奖号码位置',
    `WIN_CHECKFUNC` varchar(64) DEFAULT NULL COMMENT '中奖判断函数名',
    `WIN_PAYBONUSFUNC` varchar(64) DEFAULT NULL COMMENT '派发奖金函数名',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停售 1销售中',
    `REMARK` varchar(255) DEFAULT NULL COMMENT '备注,描述',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩法信息表';



DROP TABLE IF EXISTS
 `TLT_BONUSGROUP`;

CREATE TABLE `TLT_BONUSGROUP` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `STATUS` int(2) NOT NULL DEFAULT '0' COMMENT '状态，0不需要审核 1未审核 2审核中 3已审核',
    `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
    `USER_ID` bigint(20) NOT NULL COMMENT '更新人的数字ID',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金组表';




DROP TABLE IF EXISTS
 `TLT_BONUS`;

CREATE TABLE `TLT_BONUS` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `BONUSGROUP_ID` bigint(20) NOT NULL COMMENT '所属奖金组，对应TLT_BONUSGROUP.ID',
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `LPG_ID` bigint(20) NOT NULL COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
    `CN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    `EN_NAME` varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    `BONUS` float(20 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '奖金额',
    `BET_NUM` int(10) DEFAULT '0' COMMENT '奖金对应投注数',
    `TOTAL_MARGIN` float(5 , 3 ) DEFAULT '0.000' COMMENT '总利润率',
    `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '封锁状态，0禁用 1启用',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金表';




#-------开奖管理-----------------------------------------
DROP TABLE IF EXISTS
 `TLT_ISSUETIME`;

CREATE TABLE `TLT_ISSUETIME` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属彩种，对应TLT_TYPE.LTYPE_ID',
    `SALE_STIME` datetime DEFAULT NULL COMMENT '销售开始时间',
    `SALE_ETIME` datetime DEFAULT NULL COMMENT '销售截止时间',
    `SALE_FI_ETIME` datetime DEFAULT NULL COMMENT '第一期销售截止时间，FI即First Issue',
    `SALE_CYCLE` int(4) DEFAULT '0' COMMENT '销售周期，秒',
    `WAIT_RL_DUR` int(4) DEFAULT '0' COMMENT '等待开奖时长，秒',
    `CANCEL_DUR` int(4) DEFAULT '0' COMMENT '撤单限制时长，秒',
    `INPUT_DUR` int(4) DEFAULT '0' COMMENT '录入时长，秒',
    `SORT` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序，一般显示用',
    `ENABLE` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0无效 1有效',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖期时间设置表，是批量生成期号的基础';



DROP TABLE IF EXISTS
 `TLT_ISSUE`;

CREATE TABLE `TLT_ISSUE` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属彩种，对应TLT_TYPE.LTYPE_ID',
    `ISSUE_NO` varchar(16) NOT NULL DEFAULT '' COMMENT '期号',
    `SALE_STIME` datetime DEFAULT NULL COMMENT '实际销售开始时间',
    `SALE_ETIME` datetime DEFAULT NULL COMMENT '实际销售截止时间',
    `CANCEL_LTIME` datetime DEFAULT NULL COMMENT '最后撤单时间',
    `CHECK_STATUS` int(2) DEFAULT '0' COMMENT '号码验证状态 0未开始 1已开始 2已验证',
    `DEBIT_STATUS` int(2) DEFAULT '0' COMMENT '扣款状态 0未开始 1已开始 2已完成',
    `REBATE_STATUS` int(2) DEFAULT '0' COMMENT '返点状态 0未开始 1已开始 2已完成',
    `WIN_STATUS` int(2) DEFAULT '0' COMMENT '中奖状态 0未开始 1已开始 2已完成',
    `SEND_STATUS` int(2) DEFAULT '0' COMMENT '派奖状态 0未开始 1已开始 2已完成',
    `AUTOBET_STATUS` int(2) DEFAULT '0' COMMENT '追号状态 0未开始 1已开始 2已完成',
    `LOCK_STATUS` int(2) DEFAULT '0' COMMENT '封锁状态 0未开始 1已开始 2已完成',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖期表';






#-------投注管理-----------------------------------------
DROP TABLE IF EXISTS `TLT_BET`;

CREATE TABLE `TLT_BET` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `BET_NO` varchar(32) NOT NULL COMMENT '投注编号，由后台生成',
    `USER_ID` bigint(20) NOT NULL COMMENT '投注用户ID',
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `LPG_ID` bigint(20) NOT NULL COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
    `LP_ID` bigint(20) NOT NULL COMMENT '所属玩法，对应TLT_PLAY.ID',
    `BET_IP` varchar(20) DEFAULT '' COMMENT '投注IP',
    `BET_ISSUE` varchar(16) NOT NULL COMMENT '投注期号',
    `BET_TIME` datetime NOT NULL COMMENT '投注时间',
    `BET_NUM` int(11) NOT NULL COMMENT '投注注数',
    `BET_DATA` varchar(128) NOT NULL COMMENT '投注号码,格式(1,2,3,4.4,3,2,1.5,7,8,9),每注之间用.分隔,每注中的号码用,分隔',
    `BET_COINS` float(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '投注金额',
    `BONUS` float(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '奖金',
    `WIN_NO` varchar(128) COMMENT '开奖号码,格式(1,2,3,4)',
    `MODE` int(2) NOT NULL DEFAULT '1' COMMENT '模式，1元 2角 3分 4厘',
    `TIMES` int(11) NOT NULL DEFAULT '1' COMMENT '倍数',
    `WIN_STATUS` int(2) NOT NULL DEFAULT '0' COMMENT '获奖状态 0未判断 1未中奖 2已中奖',
    `STATUS` int(2) NOT NULL DEFAULT '0' COMMENT '状态 0正常 1撤单',
    `AUTOBET_NO` varchar(32) DEFAULT '' COMMENT '追号编号，由后台生成',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投注表';



DROP TABLE IF EXISTS
 `TLT_BET_AUTO`;

CREATE TABLE `TLT_BET_AUTO` (
    `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `AUTOBET_NO` varchar(32) NOT NULL COMMENT '追号编号，由后台生成',
    `USER_ID` bigint(20) NOT NULL COMMENT '追号用户ID',
    `LTYPE_ID` bigint(20) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE_ID',
    `LPG_ID` bigint(20) NOT NULL COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
    `LP_ID` bigint(20) NOT NULL COMMENT '所属玩法，对应TLT_PLAY.ID',
    `CREATE_TIME` int(11) NOT NULL COMMENT '追号时间',
    `START_ISSUE` varchar(16) NOT NULL COMMENT '开始期号',
    `ISSUE_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '追号期数',
    `COMPLETE_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '完成期数',
    `CANCEL_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '取消期数',
    `BET_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '投注注数',
    `BET_DATA` varchar(128) NOT NULL COMMENT '投注号码,格式(1,2,3,4.4,3,2,1.5,7,8,9),每注之间用.分隔,每注中的号码用,分隔',
    `BET_COINS` float(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '追号总金额',
    `COMPLETE_COINS` float(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '完成金额',
    `CANCEL_COINS` float(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '取消金额',
    `MODE` int(2) NOT NULL DEFAULT '1' COMMENT '模式，1元 2角 3分 4厘',
    `TIMES` int(11) NOT NULL DEFAULT '1' COMMENT '倍数',
    `WIN_STOP` int(2) DEFAULT '0' COMMENT '是否中奖即停 0否 1是',
    `STATUS` int(2) NOT NULL DEFAULT '0' COMMENT '追号状态 0进行中 1已完成 2已取消',
    `BET_NO` varchar(32) DEFAULT NULL COMMENT '投注编号，由后台生成',
    PRIMARY KEY (`ID`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='追号表';

