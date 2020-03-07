/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : spring_security

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-03-07 19:12:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `auth_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '权限Id',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限名称',
  `permission` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`auth_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES ('1', '查看用户信息', 'sys:user:info');
INSERT INTO `auth` VALUES ('2', '查看权限信息', 'sys:auth:info');
INSERT INTO `auth` VALUES ('3', '查看角色信息', 'sys:role:info');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `role_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'TEST');
INSERT INTO `role` VALUES ('2', 'DEVELOPER');
INSERT INTO `role` VALUES ('3', 'OPERATOR');

-- ----------------------------
-- Table structure for role_auth
-- ----------------------------
DROP TABLE IF EXISTS `role_auth`;
CREATE TABLE `role_auth` (
  `role_auth_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限关系表',
  `role_id` int(11) NOT NULL COMMENT '角色Id',
  `auth_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_auth_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_auth
-- ----------------------------
INSERT INTO `role_auth` VALUES ('1', '1', '1');
INSERT INTO `role_auth` VALUES ('2', '1', '2');
INSERT INTO `role_auth` VALUES ('3', '2', '2');
INSERT INTO `role_auth` VALUES ('4', '3', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `user_status` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '账号状态',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'gjc', '$2a$10$dxcjwntEU4klkK.udIYI9eW1LZye7LXFoTQU/OHd7dVHCkeLkBoHy', 'NORMAL');
INSERT INTO `user` VALUES ('2', 'cgj', '$2a$10$aRU6JA62YdRzgLf/N.yxx.yVq1xGZCExRFQdD8OEKeoQnvS2KfmfS', 'NORMAL');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色用户关系Id',
  `user_id` int(11) NOT NULL COMMENT '用户Id',
  `role_id` int(11) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`user_role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
INSERT INTO `user_role` VALUES ('3', '2', '3');
