/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 26/04/2019 08:28:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for safe_problem
-- ----------------------------
DROP TABLE IF EXISTS `safe_problem`;
CREATE TABLE `safe_problem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_aera` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `propose_time` date NULL DEFAULT NULL,
  `problem_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state_judgement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_classification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subdivision_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rectification_measures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `responsible_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `person_liable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `completion_deadline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audit_hierarchy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repeat_question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `completion_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finish_photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `submit_person` int(11) UNSIGNED ZEROFILL NULL DEFAULT 00000000001,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of safe_problem
-- ----------------------------
INSERT INTO `safe_problem` VALUES (1, '12', '2019-04-01', '14', '15', '16', '17', '18', '19', '110', '111', '112', '113', '114', '115', '116', '117', 00000000001, '2019-04-25 20:04:31', '2019-04-25 20:04:38');

SET FOREIGN_KEY_CHECKS = 1;
