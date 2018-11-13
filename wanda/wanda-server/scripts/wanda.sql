/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : wanda

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/11/2018 17:50:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for phone
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `platform_id` int(2) DEFAULT NULL COMMENT '平台号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for phone_user
-- ----------------------------
DROP TABLE IF EXISTS `phone_user`;
CREATE TABLE `phone_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `platform_id` int(2) DEFAULT NULL COMMENT '号码平台',
  `default` int(1) DEFAULT '0' COMMENT '是否默认 0否 1是',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_platform_id_default` (`platform_id`,`default`) COMMENT 'platform_id和default不能同时相等'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='该表是获取验证码平台账户表，通过平台号和是否默认账号选取使用';

-- ----------------------------
-- Records of phone_user
-- ----------------------------
BEGIN;
INSERT INTO `phone_user` VALUES (1, 'ye907182374', 'baobao1515', '2018-11-13 15:23:50', '2018-11-13 15:23:50', 1, 1);
INSERT INTO `phone_user` VALUES (2, 'demon3019', '12345678', '2018-11-13 15:23:51', '2018-11-13 15:23:51', 2, 1);
INSERT INTO `phone_user` VALUES (3, 'demon3019', '123456', '2018-11-13 15:23:51', '2018-11-13 15:23:51', 3, 1);
INSERT INTO `phone_user` VALUES (4, 'demon3019', '12345678', '2018-11-13 15:23:52', '2018-11-13 15:23:52', 4, 1);
COMMIT;

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '平台名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of platform
-- ----------------------------
BEGIN;
INSERT INTO `platform` VALUES (1, '易码');
INSERT INTO `platform` VALUES (2, '讯码');
INSERT INTO `platform` VALUES (3, '海码');
INSERT INTO `platform` VALUES (4, '云享');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
