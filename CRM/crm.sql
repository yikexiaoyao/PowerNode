/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 16/11/2021 12:29:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cost` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f319', '2', '食品调研', '2010-01-02', '2010-01-20', '10000', '食品调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f320', '2', '游戏调研', '2010-01-02', '2010-01-20', '10000', '游戏调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f321', '2', '运动器材调研1', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f322', '2', '运动器材调研2', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f323', '2', '运动器材调研3', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f324', '2', '运动器材调研4', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f325', '2', '运动器材调研5', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f326', '2', '运动器材调研6', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f327', '2', '运动器材调研7', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f328', '2', '运动器材调研8', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('87b44bb9f5164f9c85f9fa1189b6f329', '2', '运动器材调研9', '2010-01-02', '2010-01-20', '10000', '运动器材调研', '2010-01-05', '张三', '2010-01-10', '管理员');
INSERT INTO `t_activity` VALUES ('cefd0c70367041a480a1d7f690047f6d', '1', '情感问题', '2021-04-13', '2021-05-15', '4000', '不错', '2021-04-15 10:54:46', '管理员', NULL, NULL);

-- ----------------------------
-- Table structure for t_activity_clue_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_clue_relation`;
CREATE TABLE `t_activity_clue_relation`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `activityId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clueId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_activity_clue_relation
-- ----------------------------
INSERT INTO `t_activity_clue_relation` VALUES ('e1148bbd1f1d434fb0619dbcf344bc94', '87b44bb9f5164f9c85f9fa1189b6f319', '56d15221ddbe48d78df9b9bcc549f0ca');
INSERT INTO `t_activity_clue_relation` VALUES ('e6d23af73ee646a19cf063d1352c13bb', '87b44bb9f5164f9c85f9fa1189b6f321', '56d15221ddbe48d78df9b9bcc549f0ca');
INSERT INTO `t_activity_clue_relation` VALUES ('f3a445394cb34897beb035d3dc9e46d8', '87b44bb9f5164f9c85f9fa1189b6f320', '56d15221ddbe48d78df9b9bcc549f0ca');

-- ----------------------------
-- Table structure for t_activity_contact_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_contact_relation`;
CREATE TABLE `t_activity_contact_relation`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `activityId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_activity_contact_relation
-- ----------------------------
INSERT INTO `t_activity_contact_relation` VALUES ('29f479f72033415d8fa43e6ad43d9835', '87b44bb9f5164f9c85f9fa1189b6f325', 'd17829c1daa94421a86d861280714a65');
INSERT INTO `t_activity_contact_relation` VALUES ('56ed47f986bb43d3ab972169f6078142', '87b44bb9f5164f9c85f9fa1189b6f329', 'f3223ede8f7643e39bfdb8a816ee826d');
INSERT INTO `t_activity_contact_relation` VALUES ('585b54fb117044b387def7f4ef9ca2a1', '87b44bb9f5164f9c85f9fa1189b6f323', 'd17829c1daa94421a86d861280714a65');
INSERT INTO `t_activity_contact_relation` VALUES ('5f9935b132db4ba09e80e6e6c95c68af', 'cefd0c70367041a480a1d7f690047f6d', 'f3223ede8f7643e39bfdb8a816ee826d');
INSERT INTO `t_activity_contact_relation` VALUES ('65358289904643d18a7d68c9b8aff711', '87b44bb9f5164f9c85f9fa1189b6f326', 'd17829c1daa94421a86d861280714a65');
INSERT INTO `t_activity_contact_relation` VALUES ('713d5adf90ad4d688485d176ca708f56', '87b44bb9f5164f9c85f9fa1189b6f321', 'bf67d1f32fda4cbb8690488ca51ee820');
INSERT INTO `t_activity_contact_relation` VALUES ('81885e5bcddc4ea8b8a2eb89acf0700d', '87b44bb9f5164f9c85f9fa1189b6f324', 'd17829c1daa94421a86d861280714a65');
INSERT INTO `t_activity_contact_relation` VALUES ('9148f12b6fe64bb9b9a98b3979e09e31', '7e2c5c78082c4de29eeaabe02f8cffe3', 'bf67d1f32fda4cbb8690488ca51ee820');
INSERT INTO `t_activity_contact_relation` VALUES ('bb88c62424bb40bcb8e5964c974cd909', '5c41a002751745e6b172be7cc8d1f398', 'bf67d1f32fda4cbb8690488ca51ee820');
INSERT INTO `t_activity_contact_relation` VALUES ('c299ff3cd2124d1b8b902fd79054ae22', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820');
INSERT INTO `t_activity_contact_relation` VALUES ('cf73ad7e6e424d55a59af9d657353cb4', '87b44bb9f5164f9c85f9fa1189b6f328', 'f3223ede8f7643e39bfdb8a816ee826d');
INSERT INTO `t_activity_contact_relation` VALUES ('e7f235f92a9346a4bca9cc8af3cf7e48', '87b44bb9f5164f9c85f9fa1189b6f327', 'f3223ede8f7643e39bfdb8a816ee826d');
INSERT INTO `t_activity_contact_relation` VALUES ('f701cb49a1b34a368486c0d4ec3b0a77', '87b44bb9f5164f9c85f9fa1189b6f320', 'bf67d1f32fda4cbb8690488ca51ee820');
INSERT INTO `t_activity_contact_relation` VALUES ('f7dfe8b6c340423d9a4fb1635b9fcaa7', '87b44bb9f5164f9c85f9fa1189b6f322', 'd17829c1daa94421a86d861280714a65');

-- ----------------------------
-- Table structure for t_activity_remark
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_remark`;
CREATE TABLE `t_activity_remark`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `noteContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activityId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_activity_remark
-- ----------------------------
INSERT INTO `t_activity_remark` VALUES ('218dff0cb1644a6b869b9d6e622399c4', '食品调研777', '2021-04-17 11:27:17', '管理员', '2021-04-19 09:21:30', '管理员', '1', '7e2c5c78082c4de29eeaabe02f8cffe3', 'b7658115358d4f3ea22f31604d721a18', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_activity_remark` VALUES ('3725fd7102394294b8ef77794c89a819', '自行车调研', '2021-04-19 09:22:47', '管理员', NULL, NULL, '0', '7e2c5c78082c4de29eeaabe02f8cffe3', 'b7658115358d4f3ea22f31604d721a18', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_activity_remark` VALUES ('3e8e56570f6a434884cca84829d45631', '食品调研3', '2021-04-17 11:27:59', '张三', NULL, NULL, '0', '7e2c5c78082c4de29eeaabe02f8cffe3', 'b7658115358d4f3ea22f31604d721a19', '/CRM\\upload\\1635420286336logo.jpg');
INSERT INTO `t_activity_remark` VALUES ('6d0171c24a8446fb896522593c6305e6', '食品调研4', '2021-04-17 11:28:30', '张三', NULL, NULL, '0', '7e2c5c78082c4de29eeaabe02f8cffe3', 'b7658115358d4f3ea22f31604d721a19', '/CRM\\upload\\1635420286336logo.jpg');
INSERT INTO `t_activity_remark` VALUES ('9c269e2568514672b055cc616c060788', '123', '2021-11-15 20:51:33', '张三', NULL, NULL, NULL, 'cefd0c70367041a480a1d7f690047f6d', '2', '/CRM\\upload\\1635420286336logo.jpg');
INSERT INTO `t_activity_remark` VALUES ('f88f0c092b6047ac93a9000cd886f003', '食品调研1', '2021-04-17 11:27:01', '管理员', NULL, NULL, '0', '7e2c5c78082c4de29eeaabe02f8cffe3', 'b7658115358d4f3ea22f31604d721a18', '/CRM\\upload\\1635420337983logo.jpg');

-- ----------------------------
-- Table structure for t_clue
-- ----------------------------
DROP TABLE IF EXISTS `t_clue`;
CREATE TABLE `t_clue`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactSummary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nextContactTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_clue
-- ----------------------------
INSERT INTO `t_clue` VALUES ('56d15221ddbe48d78df9b9bcc549f0ca', '张飞', '博士', '5', '35113afda68e4856be46bb636933c198', '部门经理', 'james@qq.com', '17000000000', 'www.bjpowernode.com', '343434', '未联系', '广告', NULL, NULL, '2021-11-13 17:22:34', '张三', '', '', '', '767676');
INSERT INTO `t_clue` VALUES ('837edd5e34ef4aef94eba4fbf5ba0974', '关羽', '教授', '1', '35113afda68e4856be46bb636933c197', '部门经理', 'james@qq.com', '16000000000', 'www.bjpowernode.com', '654321', '已联系', '合作伙伴研讨会', NULL, NULL, '2021-11-09 09:59:03', '张三', '', '65656', '2010-10-03', '767676');
INSERT INTO `t_clue` VALUES ('83e91829caa14c239fd77a40ac132412', '刘备', '教授', '1', '35113afda68e4856be46bb636933c196', '部门经理', 'james@qq.com', '15000000000', 'www.bjpowernode.com', '123456', '已联系', '销售邮件', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '767676');

-- ----------------------------
-- Table structure for t_clue_remark
-- ----------------------------
DROP TABLE IF EXISTS `t_clue_remark`;
CREATE TABLE `t_clue_remark`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `noteContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clueId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_clue_remark
-- ----------------------------
INSERT INTO `t_clue_remark` VALUES ('906ab7559d1b465e827fd5e5d21c075b', '123', '2021-11-12 09:42:55', '张三', NULL, NULL, NULL, '56d15221ddbe48d78df9b9bcc549f0ca', '2', '/CRM\\upload\\1635420286336logo.jpg');

-- ----------------------------
-- Table structure for t_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_contact`;
CREATE TABLE `t_contact`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactSummary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nextContactTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_contact
-- ----------------------------
INSERT INTO `t_contact` VALUES ('bf67d1f32fda4cbb8690488ca51ee820', '1', '销售邮件', '35113afda68e4856be46bb636933c196', '刘备', '教授', 'james@qq.com', '123456', '部门经理', '1988-01-01', '管理员', '2021-04-27 08:52:48', '张三', '2021-11-02 08:26:46', '', '', '', '767676');
INSERT INTO `t_contact` VALUES ('d17829c1daa94421a86d861280714a65', '1', '内部研讨会', '35113afda68e4856be46bb636933c197', '关羽', '教授', 'james@qq.com', '654321', '部门经理', '1988-11-14', '管理员', '2021-04-25 11:51:44', '张三', '2021-11-14 16:24:30', '', '65656', '2010-10-03', '767676');
INSERT INTO `t_contact` VALUES ('f3223ede8f7643e39bfdb8a816ee826d', '5', '广告', '35113afda68e4856be46bb636933c198', '张飞', '博士', 'james@qq.com', '343434', '部门经理', '1992-12-05', '管理员', '2021-04-27 08:43:28', '张三', '2021-11-02 21:11:22', '', '', '', '767676');

-- ----------------------------
-- Table structure for t_contact_remark
-- ----------------------------
DROP TABLE IF EXISTS `t_contact_remark`;
CREATE TABLE `t_contact_remark`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `noteContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_contact_remark
-- ----------------------------
INSERT INTO `t_contact_remark` VALUES ('02e973514a944a1b957a276e1008883b', '123456', '2021-04-27 08:43:28', '管理员', NULL, NULL, NULL, 'bf67d1f32fda4cbb8690488ca51ee820', '1', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_contact_remark` VALUES ('21ec7577115444408b8f7302afde03a3', '123123', '2021-04-25 11:51:44', '管理员', NULL, NULL, NULL, 'd17829c1daa94421a86d861280714a65', '1', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_contact_remark` VALUES ('9a05459e4d6c4cf7a3c5a4d735210c4f', 'test', '2021-04-27 08:52:48', '管理员', NULL, NULL, NULL, 'f3223ede8f7643e39bfdb8a816ee826d', '1', '/CRM\\upload\\1635420337983logo.jpg');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactSummary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nextContactTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('35113afda68e4856be46bb636933c196', '1', '动力节点1', 'www.bjpowernode.com', '15000000000', '管理员', '2021-04-25 11:50:57', '张三', '2021-11-02 17:28:41', '', '', '', '');
INSERT INTO `t_customer` VALUES ('35113afda68e4856be46bb636933c197', '3', '动力节点2', 'www.bjpowernode.com', '16000000000', '管理员', '2021-04-25 11:50:57', '张三', '2021-11-14 16:34:40', '', '', '', '');
INSERT INTO `t_customer` VALUES ('35113afda68e4856be46bb636933c198', '4', '动力节点3', 'www.bjpowernode.com', '17000000000', '管理员', '2021-04-25 11:50:57', '张三', '2021-11-14 16:14:58', '', '', '', '');
INSERT INTO `t_customer` VALUES ('35113afda68e4856be46bb636933c199', '5', '隔壁老王', 'www.baidu.com', '18000000000', '管理员', '2021-04-25 11:50:57', '张三', '2021-11-15 17:24:36', '', '', '', '');

-- ----------------------------
-- Table structure for t_customer_remark
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_remark`;
CREATE TABLE `t_customer_remark`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `noteContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_remark
-- ----------------------------
INSERT INTO `t_customer_remark` VALUES ('6ef0c50ee11a4c96afc0450e1ebf2957', '456', '张三', '2021-11-02 20:48:57', NULL, NULL, NULL, '35113afda68e4856be46bb636933c196', '2', '/CRM\\upload\\1635420286336logo.jpg');
INSERT INTO `t_customer_remark` VALUES ('b2772ed58e38428b9d5bd50b25620429', '123', '管理员', '2021-04-27 08:43:28', NULL, NULL, NULL, '35113afda68e4856be46bb636933c196', '1', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_customer_remark` VALUES ('bde0522cbada4266847638ac17e8bc46', '你好', '管理员', '2021-04-27 08:52:48', NULL, NULL, NULL, '35113afda68e4856be46bb636933c196', '1', '/CRM\\upload\\1635420337983logo.jpg');

-- ----------------------------
-- Table structure for t_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `t_dic_type`;
CREATE TABLE `t_dic_type`  (
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dic_type
-- ----------------------------
INSERT INTO `t_dic_type` VALUES ('appellation', '称呼', '');
INSERT INTO `t_dic_type` VALUES ('clueState', '线索状态', '');
INSERT INTO `t_dic_type` VALUES ('returnPriority', '回访优先级', '');
INSERT INTO `t_dic_type` VALUES ('returnState', '回访状态', '');
INSERT INTO `t_dic_type` VALUES ('source', '来源', '');
INSERT INTO `t_dic_type` VALUES ('stage', '阶段', '');
INSERT INTO `t_dic_type` VALUES ('transactionType', '交易类型', '');

-- ----------------------------
-- Table structure for t_dic_value
-- ----------------------------
DROP TABLE IF EXISTS `t_dic_value`;
CREATE TABLE `t_dic_value`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `typeCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dic_value
-- ----------------------------
INSERT INTO `t_dic_value` VALUES ('06e3cbdf10a44eca8511dddfc6896c55', '虚假线索', '虚假线索', '4', 'clueState');
INSERT INTO `t_dic_value` VALUES ('0fe33840c6d84bf78df55d49b169a894', '销售邮件', '销售邮件', '8', 'source');
INSERT INTO `t_dic_value` VALUES ('12302fd42bd349c1bb768b19600e6b20', '交易会', '交易会', '11', 'source');
INSERT INTO `t_dic_value` VALUES ('1615f0bb3e604552a86cde9a2ad45bea', '最高', '最高', '2', 'returnPriority');
INSERT INTO `t_dic_value` VALUES ('176039d2a90e4b1a81c5ab8707268636', '教授', '教授', '5', 'appellation');
INSERT INTO `t_dic_value` VALUES ('1e0bd307e6ee425599327447f8387285', '将来联系', '将来联系', '2', 'clueState');
INSERT INTO `t_dic_value` VALUES ('2173663b40b949ce928db92607b5fe57', '丢失线索', '丢失线索', '5', 'clueState');
INSERT INTO `t_dic_value` VALUES ('2876690b7e744333b7f1867102f91153', '未启动', '未启动', '1', 'returnState');
INSERT INTO `t_dic_value` VALUES ('29805c804dd94974b568cfc9017b2e4c', '07成交', '07成交', '7', 'stage');
INSERT INTO `t_dic_value` VALUES ('310e6a49bd8a4962b3f95a1d92eb76f4', '试图联系', '试图联系', '1', 'clueState');
INSERT INTO `t_dic_value` VALUES ('31539e7ed8c848fc913e1c2c93d76fd1', '博士', '博士', '4', 'appellation');
INSERT INTO `t_dic_value` VALUES ('37ef211719134b009e10b7108194cf46', '01资质审查', '01资质审查', '1', 'stage');
INSERT INTO `t_dic_value` VALUES ('391807b5324d4f16bd58c882750ee632', '08丢失的线索', '08丢失的线索', '8', 'stage');
INSERT INTO `t_dic_value` VALUES ('3a39605d67da48f2a3ef52e19d243953', '聊天', '聊天', '14', 'source');
INSERT INTO `t_dic_value` VALUES ('474ab93e2e114816abf3ffc596b19131', '低', '低', '3', 'returnPriority');
INSERT INTO `t_dic_value` VALUES ('48512bfed26145d4a38d3616e2d2cf79', '广告', '广告', '1', 'source');
INSERT INTO `t_dic_value` VALUES ('4d03a42898684135809d380597ed3268', '合作伙伴研讨会', '合作伙伴研讨会', '9', 'source');
INSERT INTO `t_dic_value` VALUES ('59795c49896947e1ab61b7312bd0597c', '先生', '先生', '1', 'appellation');
INSERT INTO `t_dic_value` VALUES ('5c6e9e10ca414bd499c07b886f86202a', '高', '高', '1', 'returnPriority');
INSERT INTO `t_dic_value` VALUES ('67165c27076e4c8599f42de57850e39c', '夫人', '夫人', '2', 'appellation');
INSERT INTO `t_dic_value` VALUES ('68a1b1e814d5497a999b8f1298ace62b', '09因竞争丢失关闭', '09因竞争丢失关闭', '9', 'stage');
INSERT INTO `t_dic_value` VALUES ('6b86f215e69f4dbd8a2daa22efccf0cf', 'web调研', 'web调研', '13', 'source');
INSERT INTO `t_dic_value` VALUES ('72f13af8f5d34134b5b3f42c5d477510', '合作伙伴', '合作伙伴', '6', 'source');
INSERT INTO `t_dic_value` VALUES ('7c07db3146794c60bf975749952176df', '未联系', '未联系', '6', 'clueState');
INSERT INTO `t_dic_value` VALUES ('86c56aca9eef49058145ec20d5466c17', '内部研讨会', '内部研讨会', '10', 'source');
INSERT INTO `t_dic_value` VALUES ('9095bda1f9c34f098d5b92fb870eba17', '进行中', '进行中', '3', 'returnState');
INSERT INTO `t_dic_value` VALUES ('954b410341e7433faa468d3c4f7cf0d2', '已有业务', '已有业务', '1', 'transactionType');
INSERT INTO `t_dic_value` VALUES ('966170ead6fa481284b7d21f90364984', '已联系', '已联系', '3', 'clueState');
INSERT INTO `t_dic_value` VALUES ('96b03f65dec748caa3f0b6284b19ef2f', '推迟', '推迟', '2', 'returnState');
INSERT INTO `t_dic_value` VALUES ('97d1128f70294f0aac49e996ced28c8a', '新业务', '新业务', '2', 'transactionType');
INSERT INTO `t_dic_value` VALUES ('9ca96290352c40688de6596596565c12', '完成', '完成', '4', 'returnState');
INSERT INTO `t_dic_value` VALUES ('9e6d6e15232549af853e22e703f3e015', '需要条件', '需要条件', '7', 'clueState');
INSERT INTO `t_dic_value` VALUES ('9ff57750fac04f15b10ce1bbb5bb8bab', '02需求分析', '02需求分析', '2', 'stage');
INSERT INTO `t_dic_value` VALUES ('a70dc4b4523040c696f4421462be8b2f', '等待某人', '等待某人', '5', 'returnState');
INSERT INTO `t_dic_value` VALUES ('a83e75ced129421dbf11fab1f05cf8b4', '推销电话', '推销电话', '2', 'source');
INSERT INTO `t_dic_value` VALUES ('ab8472aab5de4ae9b388b2f1409441c1', '常规', '常规', '5', 'returnPriority');
INSERT INTO `t_dic_value` VALUES ('ab8c2a3dc05f4e3dbc7a0405f721b040', '05提案/报价', '05提案/报价', '5', 'stage');
INSERT INTO `t_dic_value` VALUES ('b924d911426f4bc5ae3876038bc7e0ad', 'web下载', 'web下载', '12', 'source');
INSERT INTO `t_dic_value` VALUES ('c13ad8f9e2f74d5aa84697bb243be3bb', '03价值建议', '03价值建议', '3', 'stage');
INSERT INTO `t_dic_value` VALUES ('c83c0be184bc40708fd7b361b6f36345', '最低', '最低', '4', 'returnPriority');
INSERT INTO `t_dic_value` VALUES ('db867ea866bc44678ac20c8a4a8bfefb', '员工介绍', '员工介绍', '3', 'source');
INSERT INTO `t_dic_value` VALUES ('e44be1d99158476e8e44778ed36f4355', '04确定决策者', '04确定决策者', '4', 'stage');
INSERT INTO `t_dic_value` VALUES ('e5f383d2622b4fc0959f4fe131dafc80', '女士', '女士', '3', 'appellation');
INSERT INTO `t_dic_value` VALUES ('e81577d9458f4e4192a44650a3a3692b', '06谈判/复审', '06谈判/复审', '6', 'stage');
INSERT INTO `t_dic_value` VALUES ('fb65d7fdb9c6483db02713e6bc05dd19', '在线商场', '在线商场', '5', 'source');
INSERT INTO `t_dic_value` VALUES ('fd677cc3b5d047d994e16f6ece4d3d45', '公开媒介', '公开媒介', '7', 'source');
INSERT INTO `t_dic_value` VALUES ('ff802a03ccea4ded8731427055681d48', '外部介绍', '外部介绍', '4', 'source');

-- ----------------------------
-- Table structure for t_tran
-- ----------------------------
DROP TABLE IF EXISTS `t_tran`;
CREATE TABLE `t_tran`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expectedTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `possibility` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activityId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactSummary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nextContactTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tran
-- ----------------------------
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def903', '1', '6000', '动力节点-器材交易8', '2010--9-10', '35113afda68e4856be46bb636933c196', '03价值建议', '40', '已有业务', '广告', '87b44bb9f5164f9c85f9fa1189b6f319', 'd17829c1daa94421a86d861280714a65', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90b', '2', '6000', '动力节点-器材交易9', '2010--9-10', '35113afda68e4856be46bb636933c197', '07成交', '80', '已有业务', '广告', '87b44bb9f5164f9c85f9fa1189b6f319', 'd17829c1daa94421a86d861280714a65', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90f', '3', '6000', '动力节点-器材交易12', '2010--9-10', '35113afda68e4856be46bb636933c196', '03价值建议', '80', '已有业务', '广告', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90g', '4', '6000', '动力节点-器材交易13', '2010--9-10', '35113afda68e4856be46bb636933c197', '03价值建议', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90h', '5', '6000', '动力节点-器材交易14', '2010--9-10', '35113afda68e4856be46bb636933c196', '08丢失的线索', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90i', '1', '6000', '动力节点-器材交易15', '2010--9-10', '35113afda68e4856be46bb636933c196', '08丢失的线索', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90j', '2', '6000', '动力节点-器材交易16', '2010--9-10', '35113afda68e4856be46bb636933c196', '08丢失的线索', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'd17829c1daa94421a86d861280714a65', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90k', '3', '6000', '动力节点-器材交易17', '2010--9-10', '35113afda68e4856be46bb636933c196', '01资质审查', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90l', '4', '6000', '动力节点-器材交易18', '2010--9-10', '35113afda68e4856be46bb636933c196', '01资质审查', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90m', '5', '6000', '动力节点-器材交易19', '2010--9-10', '35113afda68e4856be46bb636933c196', '01资质审查', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90o', '1', '6000', '动力节点-器材交易20', '2010--9-10', '35113afda68e4856be46bb636933c196', '01资质审查', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('af3ba5432ea344398eb12f9bd0def90p', '2', '6000', '动力节点-器材交易21', '2010--9-10', '35113afda68e4856be46bb636933c196', '01资质审查', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def903', '3', '6000', '动力节点-器材交易1', '2010--9-10', '35113afda68e4856be46bb636933c196', '05提案/报价', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', NULL, NULL);
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def904', '4', '6000', '动力节点-器材交易2', '2010--9-10', '35113afda68e4856be46bb636933c196', '05提案/报价', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def905', '5', '6000', '动力节点-器材交易3', '2010--9-10', '35113afda68e4856be46bb636933c196', '02需求分析', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def906', '1', '6000', '动力节点-器材交易4', '2010--9-10', '35113afda68e4856be46bb636933c196', '02需求分析', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def907', '2', '6000', '动力节点-器材交易5', '2010--9-10', '35113afda68e4856be46bb636933c196', '02需求分析', '80', '已有业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def908', '3', '6000', '动力节点-器材交易6', '2010--9-10', '35113afda68e4856be46bb636933c196', '06谈判/复审', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def909', '4', '6000', '动力节点-器材交易7', '2010--9-10', '35113afda68e4856be46bb636933c196', '07成交', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');
INSERT INTO `t_tran` VALUES ('cf3ba5432ea344398eb12f9bd0def90e', '5', '6000', '动力节点-器材交易11', '2010--9-10', '35113afda68e4856be46bb636933c196', '07成交', '80', '新业务', '合作伙伴', '87b44bb9f5164f9c85f9fa1189b6f319', 'bf67d1f32fda4cbb8690488ca51ee820', '管理员', '2021-04-27 08:52:48', '', '', '', '', '');

-- ----------------------------
-- Table structure for t_tran_history
-- ----------------------------
DROP TABLE IF EXISTS `t_tran_history`;
CREATE TABLE `t_tran_history`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expectedTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tranId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `possibility` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tran_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_tran_remark
-- ----------------------------
DROP TABLE IF EXISTS `t_tran_remark`;
CREATE TABLE `t_tran_remark`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `noteContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `editFlag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tranId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tran_remark
-- ----------------------------
INSERT INTO `t_tran_remark` VALUES ('650166911f2948f69fa237904e748bc7', '123', '管理员', '2021-04-25 11:51:44', NULL, NULL, NULL, 'af3ba5432ea344398eb12f9bd0def903', '1', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_tran_remark` VALUES ('9a3cc74e38f44b9bb207922e496c32d8', '223', '管理员', '2021-04-27 08:43:33', NULL, NULL, NULL, 'af3ba5432ea344398eb12f9bd0def90b', '2', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_tran_remark` VALUES ('c556f0467a9648938e6c888023ddb6f5', '123456', '管理员', '2021-04-27 08:52:48', NULL, NULL, NULL, 'af3ba5432ea344398eb12f9bd0def90f', '3', '/CRM\\upload\\1635420337983logo.jpg');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `loginAct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `loginPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `expireTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失效时间',
  `lockState` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锁状态',
  `deptNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `allowIps` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '允许IP',
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `editTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编辑时间',
  `editBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编辑者',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 't_user' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '管理员', 'e10adc3949ba59abbe56e057f20f883e', '123456789@qq.com', '2030-10-01 12:00:00', '1', '10', '0:0:0:0:0:0:0:1', '2020-10-01 12:00:00', '管理员', '2020-10-01 12:00:00', '管理员', '/CRM\\upload\\1635420337983logo.jpg');
INSERT INTO `t_user` VALUES ('2', 'zhangsan', '张三', 'e10adc3949ba59abbe56e057f20f883e', '987654321@qq.com', '2030-10-01 12:00:00', '1', '10', '0:0:0:0:0:0:0:1', '2020-10-01 12:00:00', '管理员', '2020-10-01 12:00:00', '管理员', '/CRM\\upload\\1635420286336logo.jpg');
INSERT INTO `t_user` VALUES ('3', 'lisi', '李四', 'e10adc3949ba59abbe56e057f20f883e', '135792468@qq.com', '2021-10-01 12:00:00', '1', '10', '0:0:0:0:0:0:0:1', '2020-10-01 12:00:00', '管理员', '2020-10-01 12:00:00', '管理员', '/CRM\\upload\\1635303089926logo.jpg');
INSERT INTO `t_user` VALUES ('4', 'wangwu', '王五', 'e10adc3949ba59abbe56e057f20f883e', '454545@qq.com', '2030-10-01 12:00:00', '0', '10', '0:0:0:0:0:0:0:1', '2020-10-01 12:00:00', '管理员', '2020-10-01 12:00:00', '管理员', '/CRM\\upload\\1635303089926logo.jpg');
INSERT INTO `t_user` VALUES ('5', 'zhaoliu', '赵六', 'e10adc3949ba59abbe56e057f20f883e', '545454@qq.com', '2030-10-01 12:00:00', '1', '10', '192.168.0.1', '2020-10-01 12:00:00', '管理员', '2020-10-01 12:00:00', '管理员', '/CRM\\upload\\1635303089926logo.jpg');

SET FOREIGN_KEY_CHECKS = 1;
