/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : onlineSchedule

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 28/11/2020 18:06:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `schedule_name` varchar(255) DEFAULT NULL,
  `start_point` varchar(255) DEFAULT NULL,
  `cur_point` varchar(255) DEFAULT NULL,
  `end_point` varchar(255) DEFAULT NULL,
  `point_unit` varchar(255) DEFAULT NULL,
  `bar_color` varchar(255) DEFAULT NULL,
  `pin_flag` varchar(255) DEFAULT NULL COMMENT 'pin表示固定，nopin未固定，delete删除',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `bin_flag` varchar(255) DEFAULT NULL COMMENT '表示是否在回收站',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
BEGIN;
INSERT INTO `schedule` VALUES (1, 1, 'testUpdate222', NULL, NULL, NULL, NULL, NULL, 'true', '2020-11-27 16:41:07', '2020-11-27 21:58:49', NULL);
INSERT INTO `schedule` VALUES (2, 1, 'test', NULL, NULL, NULL, NULL, NULL, 'true', NULL, NULL, NULL);
INSERT INTO `schedule` VALUES (3, 2, 'test', NULL, NULL, NULL, NULL, NULL, 'true', NULL, NULL, NULL);
INSERT INTO `schedule` VALUES (5, 1, 'test111', NULL, NULL, NULL, NULL, NULL, 'true', '2020-11-27 18:08:01', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_note
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note` (
  `note_id` int(10) NOT NULL AUTO_INCREMENT,
  `note_title` varchar(255) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `todo_id` int(10) DEFAULT NULL,
  `remarks` text,
  `tag_id` int(10) DEFAULT NULL,
  `pin_flag` varchar(255) DEFAULT NULL,
  `delete_flag` varchar(255) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_note
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'abc', 'abc', '2020-10-11 00:00:00', NULL);
INSERT INTO `user` VALUES (2, 'Kongfu', '777', '2020-11-26 07:13:07', NULL);
INSERT INTO `user` VALUES (3, '', '1234567', '2020-11-26 15:13:52', NULL);
INSERT INTO `user` VALUES (4, 'abc', 'abd', NULL, NULL);
INSERT INTO `user` VALUES (5, 'Kongfu2', '1234567', '2020-11-26 17:03:48', NULL);
INSERT INTO `user` VALUES (6, 'Kongfu3', '1234567', '2020-11-26 17:04:41', NULL);
INSERT INTO `user` VALUES (7, 'Kongfu4', '1234567', '2020-11-26 17:05:26', NULL);
INSERT INTO `user` VALUES (8, 'Kongfu10', '1234567', '2020-11-26 17:19:16', NULL);
INSERT INTO `user` VALUES (9, 'Kongfu101', '1234567', '2020-11-26 17:20:21', NULL);
INSERT INTO `user` VALUES (10, 'abc111', 'abc', '2020-11-26 17:37:40', NULL);
INSERT INTO `user` VALUES (11, 'abc1111', 'abc', '2020-11-26 17:39:20', NULL);
INSERT INTO `user` VALUES (12, 'abc111111', 'abc', '2020-11-26 17:39:25', NULL);
INSERT INTO `user` VALUES (13, 'abcnew', '123', '2020-11-26 17:42:23', NULL);
INSERT INTO `user` VALUES (14, 'register', '222222', '2020-11-27 22:25:14', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
