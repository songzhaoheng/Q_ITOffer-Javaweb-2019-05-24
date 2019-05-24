/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : qt_offer

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-05-22 19:18:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_applicant
-- ----------------------------
DROP TABLE IF EXISTS `tb_applicant`;
CREATE TABLE `tb_applicant` (
  `APPLICANT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `APPLICANT_EMAIL` varchar(50) NOT NULL,
  `APPLICANT_PWD` varchar(50) NOT NULL,
  `APPLICANT_REGISTDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`APPLICANT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_applicant
-- ----------------------------
INSERT INTO `tb_applicant` VALUES ('1', 'qst@itoffer.cn', '123456', '2011-01-01 13:14:20');
INSERT INTO `tb_applicant` VALUES ('2', '123@qq.com', '123', '2018-11-19 11:40:17');

-- ----------------------------
-- Table structure for tb_apply
-- ----------------------------
DROP TABLE IF EXISTS `tb_apply`;
CREATE TABLE `tb_apply` (
  `Apply_ID` int(255) NOT NULL AUTO_INCREMENT,
  `Apply_Name` varchar(255) DEFAULT NULL,
  `Apply_Phone` int(255) DEFAULT NULL,
  `Apply_Email` varchar(255) DEFAULT NULL,
  `Apply_Exper` varchar(255) DEFAULT NULL,
  `Apply_Intention` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Apply_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_apply
-- ----------------------------
INSERT INTO `tb_apply` VALUES ('1', '张三', '123456789', '123456789', '应届毕业生', 'Java开发');
INSERT INTO `tb_apply` VALUES ('2', '李四', null, null, null, null);
INSERT INTO `tb_apply` VALUES ('3', '王五', '123456789', '123456789', '应届毕业生', 'Android开发');

-- ----------------------------
-- Table structure for tb_company
-- ----------------------------
DROP TABLE IF EXISTS `tb_company`;
CREATE TABLE `tb_company` (
  `COMPANY_ID` int(10) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(50) DEFAULT NULL,
  `COMPANY_AREA` varchar(50) DEFAULT NULL,
  `COMPANY_SIZE` varchar(50) DEFAULT NULL,
  `COMPANY_TYPE` varchar(50) DEFAULT NULL,
  `COMPANY_BRIEF` varchar(2000) DEFAULT NULL,
  `COMPANY_STATE` int(2) DEFAULT NULL,
  `COMPANY_SORT` int(10) DEFAULT NULL,
  `COMPANY_VIEWNUM` mediumtext,
  `COMPANY_PIC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_company
-- ----------------------------
INSERT INTO `tb_company` VALUES ('1', '凌志软件股份有限公司', '苏州市', '1000人以上', '股份制企业', '凌志软件股份有限公司成立于2003年1月，是一家致力于为各行业提供软件产品研发，软件外包开发及IT系统集成服务。业务范围包括证券，银行，保险，电子商务，物流等。金融行业产品研发及软件外包服务的专业性及稳定性，已成为企业的核心竞争力。公司在日本东京、上海、北京、深圳等地均设有分支机构。凌志软件经过10年多的发展，得到现有海内外客户高度认可，并在中国和日本形成了一定的品牌知名度，海外业务以日本市场为核心，已成为国际知名企业的核心供应商，在2011年软件出口企业排行榜中名列第10名，并获得2011-2012年国家规划布局内重点软件企业称号。凌志软件在稳步扩大高端软件外包业务的同时，自主研发国内高端金融产品，现已申请多项发明专利并开发了多款拥有自主知识产权的金融软件产品，投入商业应用并得到客户的高度评价，逐步在国内市场上崭露头角。', '1', '1', '1389', '635170123249913750.jpg');
INSERT INTO `tb_company` VALUES ('2', '苏州大宇宙信息创造有限公司', '苏州市', '100-200人', '外资企业', '苏州大宇宙信息创造有限公司成立于2008年10月，是大宇宙信息创造（中国）有限公司全资子公司，注册资金为1600万元。公司位于风景优美的中国新加坡合作苏州工业园区独墅湖高教区，拥有自己的办公及研发大楼，是园区重点引进的软件服务外包企业。公司是一家专业从事国际和国内企事业信息化解决方案、软件外包的高科技企业，为国内外企业提供一流的软件开发、系统集成及维护、客户支持等综合的信息服务。公司拥有一支高素质的管理与开发团队，具有良好的外语能力和丰富的软件设计开发经验，同时具备与国内外客户的良好商务沟通能力。公司成立至今，保持着稳健发展的势头，事业日益发展和壮大，目前已与国内外多家企业建立了长期稳定的客户关系。公司于2009年7月份顺利通过ISO27001信息安全管理的国际认证，2010年6月顺利通过CMMI3级认证。公司具备完善的管理、教育培训和薪酬福利体系以及健全的规章制度，为员工的工作和学习提供了广阔、自由的发展空间。', '1', '2', '577', '635508802169230812.jpg');
INSERT INTO `tb_company` VALUES ('3', '北京日立华胜信息系统有限公司', '东城区', '200-500人', '合资企业', '北京日立华胜信息系统有限公司（简称BHH）是世界五百强之一的HITACHI日立集团和信息产业部电子六所共同投资设立的高新技术企业。公司主要从事对日软件开发,自成立以来，我们承接了日本各大银行?证券交易所相关系统、日本新干线铁路座位预约系统、面向日本政府机关的财务会计系统/税金管理系统/居民信息管理系统、纳税系统、生产管理系统、销售管理系统、日本各大汽车厂商的ECU软件、信息终端设备软件等各种大型软件开发项目。业务领域涵盖：金融、产业/流通、公共政府、ATM以及嵌入式五大领域。从1996年起，公司便已经开始从事汽车引擎控制、变速器控制、自动巡航控制等领域的嵌入式软件开发，积累了丰富的嵌入式软件的开发经验。公司十分注重对员工的外语及业务技能培训，提供多次出国工作机会和充分的发展空间；公司员工均享有良好的薪资和完备的福利保险待遇（“五险一金”和补充医疗/意外伤害保险，以及多项补贴）。诚挚邀请有志于从事对日软件开发、德才兼备的毕业生加盟，开辟属于自己的崭新生活。欢迎各位有识之士的加盟。', '1', '3', '1183', '635086129655240312.jpg');
INSERT INTO `tb_company` VALUES ('4', '222', '3333', '444', '555', '0000', '6', '7', '888', '999');

-- ----------------------------
-- Table structure for tb_job
-- ----------------------------
DROP TABLE IF EXISTS `tb_job`;
CREATE TABLE `tb_job` (
  `JOB_ID` int(10) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` int(10) NOT NULL,
  `JOB_NAME` varchar(100) DEFAULT NULL,
  `JOB_HIRINGNUM` int(10) DEFAULT NULL,
  `JOB_SALARY` varchar(20) DEFAULT NULL,
  `JOB_AREA` varchar(255) DEFAULT NULL,
  `JOB_DESC` varchar(255) DEFAULT NULL,
  `JOB_ENDTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `JOB_STATE` int(10) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_job
-- ----------------------------
INSERT INTO `tb_job` VALUES ('1', '2', 'Java软件开发工程师（提供岗前培训）', '20', '2500~4000元/月', '工业园区', '针对客户现场软件问题提供技术支持，包括在研发实验室重现客户软件问题，分析代码问题原因，提供解决方案，并测试更新的代码符合客户要求', '2016-03-05 00:00:00', '1');
INSERT INTO `tb_job` VALUES ('2', '3', '对日软件开发（提供岗前培训）', '40', '4万-4.5万/年', '历城区', 'J2EE开发 TOMCAT/JBOSS等主流应用服务器 Webservice、SOCKET、SNMP等标准接口和协议,Struts2、Spring、Hibernate等常用框架 Linux操作系统及oracle。', '2016-03-05 00:00:00', '1');

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_LOGNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_PWD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_REALNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_EMAIL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_ROLE` int(11) NOT NULL,
  `USER_STATE` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `TB_USERS_FK1` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('11', 'Hern', '10043632', '是否', '123456@163.com', '2', '3');
INSERT INTO `tb_users` VALUES ('18', 'hern123456', 'hern123456', '宋兆恒', '2336909208@qq.com', '3', '1');
INSERT INTO `tb_users` VALUES ('19', '2233', '4567789', '2233', '2233', '3', '1');
INSERT INTO `tb_users` VALUES ('23', 'admin123456', 'admin1234567', 'admin123456', '2336909208@qq.com', '3', '1');
INSERT INTO `tb_users` VALUES ('24', 'hern123456', 'hern123456', '宋兆恒', '2336909208@qq.com', '3', '1');
INSERT INTO `tb_users` VALUES ('25', 'hern1234567', 'hern123456', '宋兆恒', '2336909208@qq.com', '3', '1');
INSERT INTO `tb_users` VALUES ('26', 'hern12345678', 'hern123456', '宋兆恒', '2336909208@qq.com', '3', '1');
INSERT INTO `tb_users` VALUES ('27', 'hern123456789', 'hern123456', '宋兆恒', '2336909208@qq.com', '3', '1');
INSERT INTO `tb_users` VALUES ('28', '测试用例1', '123456', '测试用户1', '2336909208@qq.com', '1', '2');
INSERT INTO `tb_users` VALUES ('29', 'admin789', '123456', '青软实训', '463512238@qq.com', '1', '1');
INSERT INTO `tb_users` VALUES ('30', 'amdin12345678910', 'amdin12345678910', 'amdin12345678910', '2336909206@qq.com', '3', '1');

-- ----------------------------
-- Table structure for tb_users_copy
-- ----------------------------
DROP TABLE IF EXISTS `tb_users_copy`;
CREATE TABLE `tb_users_copy` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_LOGNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_PWD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_REALNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_EMAIL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_ROLE` int(11) NOT NULL,
  `USER_STATE` int(11) NOT NULL,
  `USER_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`),
  KEY `TB_USERS_FK1` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_users_copy
-- ----------------------------
INSERT INTO `tb_users_copy` VALUES ('3', 'fengjj', '123456', '冯娟娟', 'fengjj@test.com', '1', '1', '2019-05-17 11:34:33');
INSERT INTO `tb_users_copy` VALUES ('4', 'test', '123456', 'test', 'test@test.com', '1', '1', '2019-05-18 10:34:41');
INSERT INTO `tb_users_copy` VALUES ('5', 'zhangsan', '123', 'ttt', 'ssd', '3', '1', '2019-05-17 10:34:46');
INSERT INTO `tb_users_copy` VALUES ('6', 'Hern', '123456', '宋兆恒', '123456789@qq.com', '1', '1', '2019-05-17 10:34:50');
INSERT INTO `tb_users_copy` VALUES ('10', 'Hern', '10043632', '宋兆恒', '2336909208@qq.com', '2', '1', '2019-05-18 10:35:03');
INSERT INTO `tb_users_copy` VALUES ('11', 'Hern', '10043632', '是否', '123456@163.com', '2', '3', '2019-05-19 10:35:09');
INSERT INTO `tb_users_copy` VALUES ('12', 'Hern', '10043632', '是否', '123456@163.com', '2', '3', '2019-05-19 10:35:14');
INSERT INTO `tb_users_copy` VALUES ('13', 'Hern', '10043632', '是否', '123456@163.com', '2', '3', '2019-05-19 10:35:18');
INSERT INTO `tb_users_copy` VALUES ('14', 'Hern', '10043632', '是否', '123456@163.com', '2', '3', '2019-05-20 10:35:27');
INSERT INTO `tb_users_copy` VALUES ('15', 'Hern', '10043632', '是否', '123456@163.com', '2', '3', '2019-05-20 10:35:32');
INSERT INTO `tb_users_copy` VALUES ('16', 'admin123', 'admin123', '管理员123', 'admin123@163.com', '1', '1', '2019-05-20 10:35:36');
INSERT INTO `tb_users_copy` VALUES ('17', 'admin123', 'admin123', '管理员', '2336909208@qq.com', '1', '3', '2019-05-20 10:35:40');
INSERT INTO `tb_users_copy` VALUES ('19', '2233', '4567789', '2233', '2233', '3', '1', '2019-05-20 10:35:47');
INSERT INTO `tb_users_copy` VALUES ('20', 'admin123', 'admin123', '管理员', '2336909208@qq.com', '1', '3', '2019-05-21 10:35:50');
INSERT INTO `tb_users_copy` VALUES ('21', 'admin123', 'admin123', '管理员123', 'admin123@163.com', '1', '1', '2019-05-21 10:35:53');
INSERT INTO `tb_users_copy` VALUES ('22', 'Hern2', '10043632', '是否2', '2336909208@qq.com', '2', '3', '2019-05-21 10:35:57');
INSERT INTO `tb_users_copy` VALUES ('23', 'Hern', '10043632', '是否5', '2336909208@qq.com', '2', '3', '2019-05-21 10:36:02');
INSERT INTO `tb_users_copy` VALUES ('24', 'Hern', '123456', '宋兆恒', '2336909208@qq.com', '1', '1', '2019-05-21 10:36:06');
INSERT INTO `tb_users_copy` VALUES ('25', 'Hern', '10043632', '宋兆恒3', '2336909208@qq.com', '2', '1', '2019-05-21 10:36:10');
INSERT INTO `tb_users_copy` VALUES ('26', 'Hern', '10043632', '是否6', '2336909208@qq.com', '2', '3', '2019-05-21 10:36:13');
INSERT INTO `tb_users_copy` VALUES ('27', 'Hern', '10043632', '是否3', '2336909208@qq.com', '2', '3', '2019-05-21 10:36:18');
INSERT INTO `tb_users_copy` VALUES ('31', 'admin1234', 'admin1234', '管理员123', '2336909208@qq.com', '3', '1', '2019-05-21 12:10:45');
INSERT INTO `tb_users_copy` VALUES ('32', 'admin1234', 'admin1234', 'admin1234', '2336909208@qq.com', '3', '1', '2019-05-21 12:14:58');
INSERT INTO `tb_users_copy` VALUES ('33', 'admin1234', 'admin1234', 'admin1234', '2336909208@qq.com', '3', '1', '2019-05-21 12:16:11');
INSERT INTO `tb_users_copy` VALUES ('34', 'test', '123456', 'test', '2336909208@qq.com', '1', '1', '2019-05-21 12:16:58');
INSERT INTO `tb_users_copy` VALUES ('35', 'admin12345678', 'admin12345678', '青软实训2', '2336909208@qq.com', '1', '1', '2019-05-21 19:36:59');
INSERT INTO `tb_users_copy` VALUES ('36', 'fengjj', '123456', '冯娟娟', '2336909208@qq.com', '1', '1', '2019-05-21 19:41:14');
INSERT INTO `tb_users_copy` VALUES ('37', 'zhangsan', '123', 'ttt', '2336909207@qq.com', '3', '1', '2019-05-21 19:43:04');
