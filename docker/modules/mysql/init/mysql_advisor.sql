/*
Navicat MySQL Data Transfer

Source Server         : 120.25.251.106
Source Server Version : 50173
Source Host           : 120.25.251.106:3306
Source Database       : mysql_advisor

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-03-18 12:11:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authmethod
-- ----------------------------
DROP TABLE IF EXISTS `authmethod`;
CREATE TABLE `authmethod` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `logintype` char(2) DEFAULT NULL,
  `loginname` varchar(64) DEFAULT NULL,
  `encrypttype` char(2) DEFAULT NULL,
  `enable` tinyint(4) DEFAULT NULL,
  `lastupdatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of authmethod
-- ----------------------------

-- ----------------------------
-- Table structure for authone
-- ----------------------------
DROP TABLE IF EXISTS `authone`;
CREATE TABLE `authone` (
  `id` bigint(20) NOT NULL,
  `loginstatus` tinyint(4) DEFAULT NULL COMMENT '1.用户密码错误次数过多被锁定\r\n            2.用户异地登陆\r\n            3.管理员禁止用户登陆（如灌水、垃圾账号等）\r\n            4.禁止邮箱或手机或微信登陆（具体需要讨论）\r\n            ',
  `password` varchar(128) DEFAULT NULL,
  `failcount` tinyint(4) DEFAULT NULL,
  `onlinestatus` char(1) DEFAULT NULL,
  `lastupdatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of authone
-- ----------------------------

-- ----------------------------
-- Table structure for dic_order_type
-- ----------------------------
DROP TABLE IF EXISTS `dic_order_type`;
CREATE TABLE `dic_order_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dic_order_type
-- ----------------------------

-- ----------------------------
-- Table structure for dic_problem_type
-- ----------------------------
DROP TABLE IF EXISTS `dic_problem_type`;
CREATE TABLE `dic_problem_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `alias` varchar(50) DEFAULT NULL,
  `code` varchar(50) NOT NULL,
  `sort` int(11) NOT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dic_problem_type
-- ----------------------------

-- ----------------------------
-- Table structure for dic_technological_type
-- ----------------------------
DROP TABLE IF EXISTS `dic_technological_type`;
CREATE TABLE `dic_technological_type` (
  `id` bigint(20) NOT NULL,
  `alias` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `sort` int(11) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_19` (`parent_id`) USING BTREE,
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`parent_id`) REFERENCES `dic_technological_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dic_technological_type
-- ----------------------------

-- ----------------------------
-- Table structure for examinetemplet
-- ----------------------------
DROP TABLE IF EXISTS `examinetemplet`;
CREATE TABLE `examinetemplet` (
  `templateid` int(11) NOT NULL,
  `examinetype` varchar(64) DEFAULT NULL COMMENT '4类\r\n            1.顺序审核\r\n            2.双边同步审核\r\n            3.或并审核\r\n            4.以上3中组合\r\n            数据格式为  单个数字 和 组合数据\r\n            如1|2|1|1|3',
  `url` varchar(1024) DEFAULT NULL COMMENT '审核数据游览页面',
  `describe` varchar(256) DEFAULT NULL,
  `lastupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`templateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of examinetemplet
-- ----------------------------

-- ----------------------------
-- Table structure for examine_operate
-- ----------------------------
DROP TABLE IF EXISTS `examine_operate`;
CREATE TABLE `examine_operate` (
  `examineid` bigint(20) NOT NULL,
  `templateid` int(11) DEFAULT NULL,
  `curstep` tinyint(4) DEFAULT NULL COMMENT '此主要是对应审核模板的第四种类型\r\n            如 1|2|3\r\n            如果到1的时候，则1\r\n            如果到2的时候，则2\r\n            如果到3的时候，则3意味着审核完成',
  `questionid` bigint(20) DEFAULT NULL,
  `operatorid` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0 未处理\r\n            1 已过审\r\n            2 拒绝\r\n            3 放弃\r\n            一般情况下,只要是非0时，就不允许修改了。',
  `describe` varchar(256) DEFAULT NULL,
  `operatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`examineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of examine_operate
-- ----------------------------

-- ----------------------------
-- Table structure for examine_person
-- ----------------------------
DROP TABLE IF EXISTS `examine_person`;
CREATE TABLE `examine_person` (
  `templateid` int(11) NOT NULL,
  `step` tinyint(4) NOT NULL COMMENT '此主要是对应审核模板的第四种类型\r\n            如 1|2|3\r\n            每到一阶段，审核人就开始激活了\r\n            ',
  `operatorid` bigint(20) NOT NULL COMMENT '表示审核当前阶段，需要此用户来审核',
  `lastupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`templateid`,`step`,`operatorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of examine_person
-- ----------------------------

-- ----------------------------
-- Table structure for examine_step
-- ----------------------------
DROP TABLE IF EXISTS `examine_step`;
CREATE TABLE `examine_step` (
  `examineid` bigint(20) NOT NULL,
  `templateid` int(11) DEFAULT NULL,
  `curstep` tinyint(4) DEFAULT NULL COMMENT '此主要是对应审核模板的第四种类型\r\n            如 1|2|3\r\n            如果到1的时候，则1\r\n            如果到2的时候，则2\r\n            如果到3的时候，则3意味着审核完成',
  `ownerid` bigint(20) DEFAULT NULL,
  `questionid` bigint(20) DEFAULT NULL,
  `describe` varchar(256) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0 未审核\r\n            1 正在审核中\r\n            2 通过审核\r\n            3 审核不通过',
  `priority` tinyint(4) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `lastupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`examineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of examine_step
-- ----------------------------

-- ----------------------------
-- Table structure for pay_channel
-- ----------------------------
DROP TABLE IF EXISTS `pay_channel`;
CREATE TABLE `pay_channel` (
  `channelno` varchar(16) NOT NULL,
  `channelname` varchar(64) DEFAULT NULL,
  `channelcode` varchar(16) DEFAULT NULL,
  `channeltype` char(2) DEFAULT NULL,
  `tradingmethod` varchar(128) DEFAULT NULL COMMENT '允许的交易手段，以逗号隔开\r\n            1.移动端\r\n            2.网站\r\n            3.客户端\r\n            4.第三方网站',
  `payaccount` varchar(64) NOT NULL,
  `paybank` varchar(128) DEFAULT NULL,
  `branchbank` varchar(128) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `lastupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`channelno`,`payaccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pay_channel
-- ----------------------------

-- ----------------------------
-- Table structure for pay_flow
-- ----------------------------
DROP TABLE IF EXISTS `pay_flow`;
CREATE TABLE `pay_flow` (
  `serialno` bigint(20) NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `channelno` varchar(16) NOT NULL,
  `branchbank` varchar(128) DEFAULT NULL,
  `payaccount` varchar(64) NOT NULL,
  `paybank` varchar(128) DEFAULT NULL,
  `businesscode` char(4) DEFAULT NULL,
  `transactiondate` date DEFAULT NULL,
  `transactiontime` time DEFAULT NULL,
  `targetuserid` bigint(20) DEFAULT NULL,
  `targetchannelno` varchar(16) DEFAULT NULL,
  `targetpayaccount` varchar(64) DEFAULT NULL,
  `targetpaybank` varchar(128) DEFAULT NULL,
  `targetbranchbank` varchar(128) DEFAULT NULL,
  `currencytype` varchar(3) DEFAULT NULL,
  `appamount` decimal(18,4) DEFAULT NULL,
  `specification` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`serialno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pay_flow
-- ----------------------------

-- ----------------------------
-- Table structure for rel_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_menu_role`;
CREATE TABLE `rel_menu_role` (
  `id` bigint(20) NOT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_6` (`menu_id`) USING BTREE,
  KEY `FK_Reference_7` (`role_id`) USING BTREE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`menu_id`) REFERENCES `tab_menu` (`id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`role_id`) REFERENCES `tab_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rel_menu_role
-- ----------------------------

-- ----------------------------
-- Table structure for rel_resource_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_resource_role`;
CREATE TABLE `rel_resource_role` (
  `id` bigint(20) NOT NULL,
  `resource_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`role_id`) USING BTREE,
  KEY `FK_Reference_5` (`resource_id`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`role_id`) REFERENCES `tab_role` (`id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`resource_id`) REFERENCES `tab_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rel_resource_role
-- ----------------------------

-- ----------------------------
-- Table structure for rel_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_user_role`;
CREATE TABLE `rel_user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_ie` bigint(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_36` (`user_id`) USING BTREE,
  KEY `FK_Reference_37` (`role_ie`) USING BTREE,
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`user_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`role_ie`) REFERENCES `tab_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rel_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sensitiveword
-- ----------------------------
DROP TABLE IF EXISTS `sensitiveword`;
CREATE TABLE `sensitiveword` (
  `id` bigint(20) NOT NULL,
  `group_name` varchar(64) DEFAULT NULL,
  `sensitiveword` varchar(128) NOT NULL,
  `enable` tinyint(4) DEFAULT NULL COMMENT '0 未启用\r\n            1 启用\r\n            2 分组禁用\r\n            3 敏感词禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sensitiveword
-- ----------------------------

-- ----------------------------
-- Table structure for system_param
-- ----------------------------
DROP TABLE IF EXISTS `system_param`;
CREATE TABLE `system_param` (
  `id` bigint(20) NOT NULL,
  `c_key` varchar(32) DEFAULT NULL,
  `c_name` varchar(128) DEFAULT NULL,
  `default_value` varchar(32) DEFAULT NULL,
  `c_value` varchar(32) DEFAULT NULL,
  `valid_type` varchar(32) DEFAULT NULL COMMENT '1.int 型\r\n            2.string型\r\n            3.val[1,32] 范围',
  `lastupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of system_param
-- ----------------------------

-- ----------------------------
-- Table structure for tab_adviser_score
-- ----------------------------
DROP TABLE IF EXISTS `tab_adviser_score`;
CREATE TABLE `tab_adviser_score` (
  `id` bigint(20) NOT NULL,
  `advisor_id` bigint(20) DEFAULT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`advisor_id`) USING BTREE,
  KEY `FK_Reference_3` (`problem_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`advisor_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`problem_id`) REFERENCES `tab_problem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_adviser_score
-- ----------------------------

-- ----------------------------
-- Table structure for tab_advisor_problem_type
-- ----------------------------
DROP TABLE IF EXISTS `tab_advisor_problem_type`;
CREATE TABLE `tab_advisor_problem_type` (
  `id` bigint(20) NOT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `advisor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_33` (`type_id`) USING BTREE,
  KEY `FK_Reference_34` (`advisor_id`) USING BTREE,
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`type_id`) REFERENCES `dic_problem_type` (`id`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`advisor_id`) REFERENCES `tab_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_advisor_problem_type
-- ----------------------------

-- ----------------------------
-- Table structure for tab_advisor_technological_type
-- ----------------------------
DROP TABLE IF EXISTS `tab_advisor_technological_type`;
CREATE TABLE `tab_advisor_technological_type` (
  `id` bigint(20) NOT NULL,
  `advisorr_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_31` (`advisorr_id`) USING BTREE,
  KEY `FK_Reference_32` (`type_id`) USING BTREE,
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`advisorr_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`type_id`) REFERENCES `dic_technological_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_advisor_technological_type
-- ----------------------------

-- ----------------------------
-- Table structure for tab_company
-- ----------------------------
DROP TABLE IF EXISTS `tab_company`;
CREATE TABLE `tab_company` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(10000) DEFAULT NULL,
  `people_num` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `is_market` int(11) DEFAULT NULL,
  `stock_code` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `industry` varchar(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_company
-- ----------------------------

-- ----------------------------
-- Table structure for tab_menu
-- ----------------------------
DROP TABLE IF EXISTS `tab_menu`;
CREATE TABLE `tab_menu` (
  `id` bigint(20) NOT NULL,
  `menu_title` varchar(20) DEFAULT NULL,
  `data_url` varchar(50) DEFAULT NULL,
  `tpl_url` varchar(50) DEFAULT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`parent_id`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`parent_id`) REFERENCES `tab_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_menu
-- ----------------------------

-- ----------------------------
-- Table structure for tab_order
-- ----------------------------
DROP TABLE IF EXISTS `tab_order`;
CREATE TABLE `tab_order` (
  `id` bigint(20) NOT NULL,
  `type` bigint(20) NOT NULL,
  `place_id` bigint(20) DEFAULT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  `advisor_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `paynumber` varchar(32) DEFAULT NULL,
  `paytype` int(11) DEFAULT NULL,
  `order_step` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_14` (`place_id`) USING BTREE,
  KEY `FK_Reference_15` (`advisor_id`) USING BTREE,
  KEY `FK_Reference_16` (`problem_id`) USING BTREE,
  KEY `FK_Reference_20` (`type`) USING BTREE,
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`place_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`advisor_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`problem_id`) REFERENCES `tab_problem` (`id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`type`) REFERENCES `dic_order_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_order
-- ----------------------------

-- ----------------------------
-- Table structure for tab_post_info
-- ----------------------------
DROP TABLE IF EXISTS `tab_post_info`;
CREATE TABLE `tab_post_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `code` varchar(30) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_post_info
-- ----------------------------

-- ----------------------------
-- Table structure for tab_problem
-- ----------------------------
DROP TABLE IF EXISTS `tab_problem`;
CREATE TABLE `tab_problem` (
  `id` bigint(20) NOT NULL,
  `technology_type_id` bigint(20) DEFAULT NULL,
  `problem_type_id` bigint(20) DEFAULT NULL,
  `problem_describe` text,
  `problem_key` varchar(50) DEFAULT NULL,
  `expect_describe` text,
  `submit_user_id` bigint(20) DEFAULT NULL,
  `process_man_id` bigint(20) DEFAULT NULL,
  `process_describe` text,
  `process_step` int(11) DEFAULT NULL,
  `step_update_time` datetime DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `process_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `click_rate` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_17` (`technology_type_id`) USING BTREE,
  KEY `FK_Reference_18` (`problem_type_id`) USING BTREE,
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`technology_type_id`) REFERENCES `dic_technological_type` (`id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`problem_type_id`) REFERENCES `dic_problem_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_problem
-- ----------------------------

-- ----------------------------
-- Table structure for tab_problem_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `tab_problem_evaluate`;
CREATE TABLE `tab_problem_evaluate` (
  `id` bigint(20) NOT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `result_score` int(11) DEFAULT NULL,
  `response_score` int(11) DEFAULT NULL,
  `serve_score` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `eval_user_id` bigint(20) DEFAULT NULL,
  `process_user_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_25` (`problem_id`) USING BTREE,
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`problem_id`) REFERENCES `tab_problem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_problem_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for tab_problem_leave_msg
-- ----------------------------
DROP TABLE IF EXISTS `tab_problem_leave_msg`;
CREATE TABLE `tab_problem_leave_msg` (
  `id` bigint(20) NOT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  `from_id` bigint(20) DEFAULT NULL,
  `to_id` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_21` (`problem_id`) USING BTREE,
  KEY `FK_Reference_22` (`parent_id`) USING BTREE,
  KEY `FK_Reference_23` (`to_id`) USING BTREE,
  KEY `FK_Reference_24` (`from_id`) USING BTREE,
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`problem_id`) REFERENCES `tab_problem` (`id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`parent_id`) REFERENCES `tab_problem_leave_msg` (`id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`to_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`from_id`) REFERENCES `tab_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_problem_leave_msg
-- ----------------------------

-- ----------------------------
-- Table structure for tab_problem_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `tab_problem_warehouse`;
CREATE TABLE `tab_problem_warehouse` (
  `id` bigint(20) NOT NULL,
  `technology_type_id` bigint(20) DEFAULT NULL,
  `problem_type_id` bigint(20) DEFAULT NULL,
  `problem_describe` text,
  `problem_key` varchar(50) DEFAULT NULL,
  `expect_describe` text,
  `submit_user_id` bigint(20) DEFAULT NULL,
  `process_man_id` bigint(20) DEFAULT NULL,
  `process_describe` text,
  `process_step` int(11) DEFAULT NULL,
  `step_update_time` datetime DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `process_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `click_rate` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_problem_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for tab_resource
-- ----------------------------
DROP TABLE IF EXISTS `tab_resource`;
CREATE TABLE `tab_resource` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_resource
-- ----------------------------

-- ----------------------------
-- Table structure for tab_role
-- ----------------------------
DROP TABLE IF EXISTS `tab_role`;
CREATE TABLE `tab_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_role
-- ----------------------------

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `user_alias` varchar(20) DEFAULT NULL,
  `email_address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `weixin` varchar(32) DEFAULT NULL,
  `weibo` varchar(32) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `company` int(11) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL,
  `zhifubao` varchar(50) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_user
-- ----------------------------

-- ----------------------------
-- Table structure for tab_user_like_consultant
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_like_consultant`;
CREATE TABLE `tab_user_like_consultant` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `consultant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_28` (`user_id`) USING BTREE,
  KEY `FK_Reference_29` (`consultant_id`) USING BTREE,
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`user_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`consultant_id`) REFERENCES `tab_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_user_like_consultant
-- ----------------------------

-- ----------------------------
-- Table structure for tab_user_like_type
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_like_type`;
CREATE TABLE `tab_user_like_type` (
  `id` bigint(20) NOT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_26` (`user_id`) USING BTREE,
  KEY `FK_Reference_27` (`type_id`) USING BTREE,
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`user_id`) REFERENCES `tab_user` (`id`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`type_id`) REFERENCES `dic_problem_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_user_like_type
-- ----------------------------

-- ----------------------------
-- Table structure for tab_user_login_info
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_login_info`;
CREATE TABLE `tab_user_login_info` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  `logout_time` datetime DEFAULT NULL,
  `lastmacaddr` varchar(128) DEFAULT NULL,
  `macaddr` varchar(128) DEFAULT NULL,
  `lastipaddr` varchar(64) DEFAULT NULL,
  `ipaddr` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_13` (`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`user_id`) REFERENCES `tab_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_user_login_info
-- ----------------------------

-- ----------------------------
-- Table structure for tab_user_type
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_type`;
CREATE TABLE `tab_user_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_user_type
-- ----------------------------

-- ----------------------------
-- Table structure for tab_vip
-- ----------------------------
DROP TABLE IF EXISTS `tab_vip`;
CREATE TABLE `tab_vip` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_8` (`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`user_id`) REFERENCES `tab_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_vip
-- ----------------------------

-- ----------------------------
-- Table structure for tab_vip_buyinfo
-- ----------------------------
DROP TABLE IF EXISTS `tab_vip_buyinfo`;
CREATE TABLE `tab_vip_buyinfo` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `buy_time` datetime DEFAULT NULL,
  `month_size` int(11) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `deal_number` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `vip_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`vip_id`) USING BTREE,
  KEY `FK_Reference_9` (`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`vip_id`) REFERENCES `tab_vip` (`id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`user_id`) REFERENCES `tab_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tab_vip_buyinfo
-- ----------------------------
