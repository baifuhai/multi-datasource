/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : mds1

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-03-03 11:06:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a');
