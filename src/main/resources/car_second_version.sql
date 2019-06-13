/*
 Navicat Premium Data Transfer

 Source Server         : 60.205.187.142
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 60.205.187.142:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 04/06/2019 09:35:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for WARNING
-- ----------------------------
DROP TABLE IF EXISTS `WARNING`;
CREATE TABLE `WARNING`  (
  `id` int(11) NOT NULL,
  `warning` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `Bitcoin_Address` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `Email` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for audit_hierarchy
-- ----------------------------
DROP TABLE IF EXISTS `audit_hierarchy`;
CREATE TABLE `audit_hierarchy`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit_hierarchy
-- ----------------------------
INSERT INTO `audit_hierarchy` VALUES ('f083b624-f950-4dfa-be5f-c0b577a15607', '公司级');
INSERT INTO `audit_hierarchy` VALUES ('9503ba57-442d-45fe-8cda-c2b4b1d5078d', '车间级');
INSERT INTO `audit_hierarchy` VALUES ('639d1147-47b1-4531-aa9f-4bbf9188f24d', '工段级');
INSERT INTO `audit_hierarchy` VALUES ('aa443d30-156c-49ec-8411-33c5bc4784e3', '班组级');

-- ----------------------------
-- Table structure for completion_status
-- ----------------------------
DROP TABLE IF EXISTS `completion_status`;
CREATE TABLE `completion_status`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of completion_status
-- ----------------------------
INSERT INTO `completion_status` VALUES ('492ee83f-c867-4c53-b09c-5c07084abbd4', '4/4');
INSERT INTO `completion_status` VALUES ('5479c37f-fe3c-4527-a5b7-48c0e6259e4b', '6/6');
INSERT INTO `completion_status` VALUES ('0306471c-7e53-4d6d-9e71-408a2f74ee38', '完成');

-- ----------------------------
-- Table structure for problem_classification
-- ----------------------------
DROP TABLE IF EXISTS `problem_classification`;
CREATE TABLE `problem_classification`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem_classification
-- ----------------------------
INSERT INTO `problem_classification` VALUES ('149dff35-73a7-4656-a82f-dc93d8833ea2', '不安全行为');
INSERT INTO `problem_classification` VALUES ('b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0', '化学品安全');
INSERT INTO `problem_classification` VALUES ('81155412-e228-4ca2-ad3b-0e0176f9878b', '交通安全');
INSERT INTO `problem_classification` VALUES ('7e35f3fe-9dd1-4c47-866f-913fc6c5818f', '环境保护');
INSERT INTO `problem_classification` VALUES ('dbd6428d-d36a-44d0-98ef-1d6b7416aa0e', '消防安全');
INSERT INTO `problem_classification` VALUES ('0aa12a14-2321-41c7-bb69-a39853869b6d', '用电安全');
INSERT INTO `problem_classification` VALUES ('edc21820-4d19-48f2-be75-f1b9a32a81a0', '能量锁定');
INSERT INTO `problem_classification` VALUES ('88a54aff-93f8-4224-9bc3-8e41d6e1d23b', '有限空间');
INSERT INTO `problem_classification` VALUES ('8a9af291-e60e-4658-a914-5c203bf99369', '危险隔离区');
INSERT INTO `problem_classification` VALUES ('9f7d5032-94a5-4afc-a300-922875854d8a', '高处作业');
INSERT INTO `problem_classification` VALUES ('b958c303-8e46-4880-a207-8796dafeb25b', '机械安全');
INSERT INTO `problem_classification` VALUES ('e8170c89-d32c-4376-98bc-489b4d7aad0a', '职业健康');
INSERT INTO `problem_classification` VALUES ('5c0b3466-ee20-455e-87d5-da80fc8c2a6e', '目视化信息');
INSERT INTO `problem_classification` VALUES ('0432b20b-c967-4708-b0e6-dce97d7abf01', '作业现场及5S');
INSERT INTO `problem_classification` VALUES ('471afed4-006f-4728-976b-d019aec81dc7', '管理缺失');

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES ('b1488df4-8681-4d20-8a27-4189b91719d5', 'A');
INSERT INTO `rank` VALUES ('8000c228-f024-406f-89d1-0d0aeddecb4b', 'B');
INSERT INTO `rank` VALUES ('ed45b184-57fb-4abe-b3a0-179cac8728a8', 'C');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `record_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commit_time` datetime NULL DEFAULT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2199c72954fb11c59ccff5f598207276', '111', '111', '2019-06-02 16:12:22', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('27b0e7d5eee756036af357b1ac64ad4d', '111', '111', '2019-05-31 08:49:23', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('33dbf9b424e06c6a1878d5132a86e8b2', '111', '111', '2019-05-31 09:18:49', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('77cf79a980252bd3ff6122deb4db71da', '111', '111', '2019-05-31 09:13:32', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('78451f7379da7399faecd36d5928487b', '111', '111', '2019-05-31 09:17:01', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('bb56dc289c9dc736922f11b130532a58', '111', '111', '2019-05-31 09:07:39', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('fb07549a1d8d07c2ec1b5d653fbccd2b', '112', '112', '2019-05-31 08:35:08', '86e9343b57ad7114c61ee3b73f5b1af3');

-- ----------------------------
-- Table structure for responsible_area
-- ----------------------------
DROP TABLE IF EXISTS `responsible_area`;
CREATE TABLE `responsible_area`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of responsible_area
-- ----------------------------
INSERT INTO `responsible_area` VALUES ('7a0316a2-f04c-46ae-9d2a-9b528bb67f45', '总装车间');
INSERT INTO `responsible_area` VALUES ('7fe0b2c6-b368-46e3-9894-43754dd08222', '涂装车间');
INSERT INTO `responsible_area` VALUES ('ede64b1a-97c9-4fac-838e-307b2b9ad2c3', '车身车间');
INSERT INTO `responsible_area` VALUES ('f991925a-29af-4bf3-9950-2014156f6b79', '冲压车间');
INSERT INTO `responsible_area` VALUES ('6c39ee83-5b62-4122-9b0e-80bf8ee273d9', '发动机工厂');
INSERT INTO `responsible_area` VALUES ('93f7c715-292c-448c-97a9-99363b784546', '维修车间');
INSERT INTO `responsible_area` VALUES ('cda6fead-053c-4efe-af55-f60e57d177d0', '采购及供应链管理科');
INSERT INTO `responsible_area` VALUES ('c67f78ef-40f5-48d3-9ead-2bf3dc2dbee6', '质量科');
INSERT INTO `responsible_area` VALUES ('8a52c4ee-a026-4504-9713-4634bf77b362', 'KD车间');
INSERT INTO `responsible_area` VALUES ('b80fa9b7-c5aa-4f40-9815-70345a40b682', '销售公司售后配件科');
INSERT INTO `responsible_area` VALUES ('61712630-0cc3-453b-9ab6-d5b3ba73bc8e', '销售公司整车物流科');
INSERT INTO `responsible_area` VALUES ('30b50f69-ddbc-47e6-9940-780ccab56658', '党群工作科');
INSERT INTO `responsible_area` VALUES ('2968d97e-7eab-443f-b9e1-e2251828d66d', '财务科');
INSERT INTO `responsible_area` VALUES ('0a3a8818-ad85-4982-a757-0e3297dbad65', '技术工程科');
INSERT INTO `responsible_area` VALUES ('1bdadce1-6abf-4e22-9f06-a5eda0dbd1dd', '信息系统与服务科');
INSERT INTO `responsible_area` VALUES ('89afbd97-a165-47a9-91cc-f50e369eacf4', '人力资源科');
INSERT INTO `responsible_area` VALUES ('19e7bac7-8396-48ab-8679-29c9cd59cd2e', '兴菱公司');
INSERT INTO `responsible_area` VALUES ('fd0ce58e-fdd0-4f2a-8ad9-0dcd71863f51', '总科办');
INSERT INTO `responsible_area` VALUES ('d7129272-5123-44da-a01c-4c4d276213e1', '安全科');
INSERT INTO `responsible_area` VALUES ('af5ecc9b-6346-4a0e-bf19-ee196d8ed651', '生产计划科');
INSERT INTO `responsible_area` VALUES ('', '新能源');

-- ----------------------------
-- Table structure for safe_problem
-- ----------------------------
DROP TABLE IF EXISTS `safe_problem`;
CREATE TABLE `safe_problem`  (
  `problem_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `audit_area` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `propose_time` date NULL DEFAULT NULL,
  `problem_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state_judgement` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_classification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subdivision_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rectification_measures` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `responsible_area` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `person_liable` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `completion_deadline` date NULL DEFAULT NULL,
  `audit_hierarchy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repeat_question` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `completion_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finish_photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `record_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`problem_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of safe_problem
-- ----------------------------
INSERT INTO `safe_problem` VALUES ('09614ecdb6fedbbdbc60dd844a5e1b0a', '11', '2019-01-01', '11', 'ff2d2a00-5b24-4362-b15b-ddc05d644c09.png', '11', '11', '11', '11', '11', '11', '11', '2019-01-01', '11', '11', '11', '72d34e6e-fd7f-4106-a421-e7390f303b4b.png', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('0a3d3e961e0dc6d6820cadba7d1ad0eb', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'd8472c05-7c65-48d7-a5ee-b74adc92d83a.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '227934e5-9807-4ddb-be01-0bbc095d5a75.jpeg', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('0afc7882752074fe6e8013f66630e51c', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '9dd0acf8-1502-4268-b446-13ef114f7fc2.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '166a9865-c1e0-4e37-b4d2-97cc7bf2b4e1.png', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('0ea6115ef2814648669ae345e5dd3013', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '78beed9e-2b0f-4cce-aa6e-e18e401c05d4.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '860f0c02-da99-42fc-af58-112b4024fa97.png', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('0f5b2147b44200f74930cb2d3186c5c5', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '1fadc9c8-ecf0-4d85-9a4f-4b241fb7a3d1.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '07211297-2cbb-4f1a-8e95-137a7b1001c9.jpeg', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('104bad2f00506dd808ffe665dfcc5388', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '19ee0fb2-f34c-4008-a86b-68923a2f42fb.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '9b4b53ce-a10a-45db-ba67-c7c42bc6bdbc.jpeg', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('10cf6b9bca8226fdb38012821b98042d', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'f54bb59b-256a-40e9-b926-5503aa15740b.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'd14cfd5e-3cfa-4dd1-be02-90f0a18e4c21.png', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('1ad49a67d2a1ac135ff6b7321816498c', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'd7510022-005a-4ed3-8610-4a456a997f4d.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '032e1947-26f0-4391-a8b5-cf5da2ca9e18.png', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('1ba1c5f65fe923e64decb4de6c42b09c', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'b1c0f8db-71f0-446e-bc13-ae264fe6d097.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '56b36ed9-6e53-4d8f-bbb7-071f87250afd.jpeg', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('1ba88f7fbc69f015016f72b2fe443fa9', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '8f4efe89-c421-453d-a68f-cfb7efecb645.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'f626eaac-b6fb-4416-9af1-e252ac2a910a.png', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('1c8d4fc6ed5d6d1f1da6672aaa12de27', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '15ba8238-96e8-459b-8376-dd0920248872.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '2fa2cb9b-ce44-4e32-8839-8576c929b27f.png', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('2405b059155fafc78f4da676bc1f18b2', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/f83bdf12977840979024e40811154a9c/{1}/{2}/{3}.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '/8896ec09b5cc44a9bd835dc829c8b89c/{1}/{2}/{3}.jpeg', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('2839fcc8907473b486c6946494f188a1', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '8f821cba-7682-4205-931e-d4b934752e71.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', '418d52ce-89e7-43b9-a28c-18ebac2b268c.jpeg', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('28491a5f882ddc90494c778e284cc0a2', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'e7ada838-49ef-4685-bfe8-a71f5d6568ca.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'b958f307-a3eb-4d7d-ae56-32221d956777.png', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('2cb7e00ee882f2f4f7a4afec288a9974', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '5c0a81bd-50a1-4fed-81ce-81cd27815c56.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '5779b192-5b8c-4da3-be79-b8907131512d.jpeg', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('2f2da75306e6f1c9c02d4e385c9587d9', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/006ac6f81b2742298c6c2b95de2ea0c9/{1}/{2}/{3}.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '/f120798866e04de88b04deb6f7a74aed/{1}/{2}/{3}.jpeg', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('309784cc6dff823506b8124cc398860b', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '9117b0da-6377-4dd5-b0a9-8f19d7ac84f7.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '61a307ea-e579-4dd8-b334-04d88b5f4286.png', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('38f583293b65e60804a48bce4468ea56', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '0d6d86ce-5144-41c8-a969-b3c47af98f8d.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '6cbbf347-2263-4877-9843-f5351358697b.png', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('39ad2e923bcb3dcdc060ead3f9c61ab9', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '976a2285-659a-464a-8db1-1af5a73de12a.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '917f2fe4-264c-407c-bcb0-3ac83ca9d05a.png', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('3f7a3ca83f2de58d542253476697480a', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '76ff7f9f-8021-4af7-a616-2c945d621612.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '770b2c5c-4a19-4d58-badc-6fdcac9be04c.png', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('43058e91c0e149dc8fed1dad6f487951', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '86d7dd62-260a-4f22-bf05-02ee6dd00a1e.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '414d17fd-08f1-4fef-b8b0-857c5aae4569.png', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('435f6b8030c4ba4cccf1c2ebe345e5c0', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'db3e8c96-0f5a-490b-89b5-7cf45db1d4e3.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '84d608c3-7e0e-4d15-bf4b-6200c4d6e862.jpeg', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('44e9046cabdf54d0259e156544fa6058', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '2389b9ad-304a-4c7a-9c7d-8ff44ed20853.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '3bf02f0d-4571-473c-a8dd-4b23140f2efd.png', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('4536c348bd904d476a6395869c29bfa1', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'f8092b6b-f7df-43d5-957c-de553abf9eae.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', '674b0262-c300-4286-afb7-9dad4bb2f3c0.jpeg', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('4846fbb52b3a009a9ea37e069e66082f', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'e6b1a8e6-bd4f-46cd-bd26-692d26911e71.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '00bc9d87-0c83-4ee4-a5d5-0dbbdb113582.jpeg', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('4e7cfb305acc4e3f307176f40a295353', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '0fbeb366-c4d7-4950-908b-09ea041a761a.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'ba0211e6-18e5-44c2-af8f-f1aef27c1fb9.jpeg', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('4efdf61bc7897341bb78fd3e9ae1a117', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '56c685b8-c7f2-47a6-a335-9701e83e1c3a.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', 'f82dabc4-1b2d-447f-8093-3d19638c07d6.png', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('533d5dc70476055b7934acca33e363dc', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/0e643cb6dbc04707b9446a2fc1892252/{1}/{2}/{3}.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/583d7386085c40a399a799fe7b456adb/{1}/{2}/{3}.png', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('5564a654dedf31dcc0d41049754ad618', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'd3868582-aec0-4073-a44f-25adb4a1f3de.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'd3ca64e1-8fb8-4ed7-950d-2a422e674b47.jpeg', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('55995d3c2194d98c5f94f1abcb8bf31d', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'fcf8d10a-9184-40c4-8d3c-d7f16b049949.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '0100a143-98e5-4c46-8bc1-70cca90ba0c9.png', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('55c9452e5623815594cdd6fb27f5fb6c', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/83b1b3f5a87643958a2d4e46847b6d65/{1}/{2}/{3}.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '/436843bef75d435ab607ec7586780648/{1}/{2}/{3}.jpeg', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('564eaf44836f23899c8fb192c7849a50', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/4e9c678f84fb4da8b3e0570f20681685/{1}/{2}/{3}.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '/dab034f74aaa4540bd25a3d1578b59d6/{1}/{2}/{3}.jpeg', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('5a27334831c0eccdad8de5dbb4b8c76e', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/1f30a291e50d4faaabb2827b902c2961/{1}/{2}/{3}.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/652a920f4cbf46bc80821165c9c9b766/{1}/{2}/{3}.png', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('5b730a2fa8dad8baa2db007fabbee6ea', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/8b91cb6840984202aa97a3d3e7a051d2/{1}/{2}/{3}.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', '/8eb612645e884caab0fad773f6ff13a3/{1}/{2}/{3}.jpeg', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('5bf5a113bafe7f16ca64f51676fe88ee', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'eb178ea0-d209-4a7c-a97f-5d10862d50d7.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', 'f7a9eb7d-125b-4346-a1d9-841893cd67f5.jpeg', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('5c04c05a78892df5575309e05bcf161c', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '986e95c0-86ec-4f38-bd1f-35ddf5713736.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '0476b384-4037-4898-8139-7bfdc955e615.png', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('6426cc489888c2e507ff4c03cd1aa44e', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '189d6804-2533-4feb-832f-f707bb406598.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'a1ddfbfb-ece3-4653-815f-d18769dc0904.jpeg', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('655f38877696789cd5077c8e1bfd0dd0', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'c8d9859b-dadd-4300-8f11-f9134d29943b.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'db3ba811-93ee-4b8c-8651-5bb839d8f365.png', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('6b4c36a354ece18ef8929cfc444ecb79', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '8cd533bb-3cf9-420c-90ef-263acc6acf1a.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', 'a76e5267-c448-4963-abcd-1309c723cf42.jpeg', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('6b64bac298ebed598d1990bb8ff2065b', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'ca2e2ed5-278b-488a-a203-4bc11278846b.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'dc23884e-cb7c-4461-9d5a-b702f4989cd1.png', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('6f6b72c5eded5e8a6db13f47fcf7dea2', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/53c777fb62c34fd59d8b798a702a55e0/{1}/{2}/{3}.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', '/13e4846a565a406298903286eeb617f9/{1}/{2}/{3}.jpeg', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('7362db4cede1b477bff26cc402a9d1f7', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/b1d41845db204948b65b427aad03e570/{1}/{2}/{3}.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/4641df26226c4e49a564b76d53aa6cf3/{1}/{2}/{3}.png', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('74822b1d3350a5ba2597075931eea7e9', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '7556d2e8-f71a-4686-9898-d201661731e9.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'f36c793d-5347-49f0-a4e3-5b28eeec7983.png', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('75cf14c67719dfb95c7975c8609edc8f', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '3aae52cb-0abb-4fae-ad06-6d44be7d1f26.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'e33574d6-075f-4324-9ce6-2ad782eaf654.jpeg', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('83754165712b4c87e2ac767d5bd700dc', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'e57b97b4-6efb-4840-b5ef-a8f4a15e0a15.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', '251cbca3-e273-4b7d-8f3f-ef43f9a93576.jpeg', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('9212bb92860c2146e6be4e90d68979a9', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/b797473ff88549d295e8800e02e6605a/{1}/{2}/{3}.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/123ca53da92b489d93d65ace4b449f85/{1}/{2}/{3}.png', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('92858d6a8ca67b2feea3aadd727910d7', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'b2af8e70-e949-483f-ab5b-cdc22e7a55cf.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '980d5737-208a-48d1-be07-8abc9c8cbb3f.jpeg', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('939f6796422b0bfcb6f6b33fcf0caab8', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'fe7a296f-1664-45a2-b600-87f51b836338.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '6e8a2698-6466-455c-a1d9-eefcf26aa6cf.jpeg', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('950268e5026d35cf4853a55cd873f914', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'ecb75a87-e2c0-468b-a68a-4d35c868d40e.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '3284bbf3-dbfe-4702-9806-9d15d11506ee.jpeg', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('95de8b45a00efafafcf84b6fb3ab465d', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'a5c42b91-83ca-4605-9578-601f295c1ddc.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', 'e72afa5e-2076-490e-8fdc-2a46f6c33617.jpeg', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('9800c4e15df8d9f89cac90c9e8391dd4', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '7a4f6a3c-6c36-4446-811c-f4e61fea29bb.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'a1545124-8064-45c9-9c82-e1b96b19d917.png', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('9894a90a622235e520d91fa04a7d400b', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'e738f033-08c8-4675-9b2a-f0b3aa6bf9b7.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'a6b8b95f-0224-452a-b67a-ada4e68c3b87.png', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('9ba4bcefdc1237bb986a51520b47b23c', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '5406d8a9-9abc-4ad8-b9f8-c7696f40bf46.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '3378ea34-ab3f-49c4-a122-68d8ffe20945.png', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('9d63543902c2de23f92be0b6f18cd2ca', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '51d85529-e526-41e1-8b26-88eab4bb9905.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '8c7dce84-8659-4d27-adc6-4fc1ec808cb4.png', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('a28de64ad1a2fd71be7a215562780db3', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'f1144bb9-9910-4808-8c16-dbe48d134e19.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '9f151a3b-4806-45a0-a5cb-df58450c8f44.png', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('a53ab73860035ab4d4945ccbc0d89c3c', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '196a4624-a687-4f07-8bb3-97c2bc7896d6.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '840b730c-4122-4df6-b21a-5cfe71c22de0.png', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('a641dc75bcabfc468d2878adeac8f9a5', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '0fdf6a5e-9a54-4190-9250-00ffa4066137.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'ef8f46bf-45d9-4d89-b460-29bc9e03a633.png', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('aa5f63b4ee692dee20371edc78be42a4', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'd0eac8f7-d69b-4d41-a73d-85349c057f5a.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', 'b169843a-2c38-4598-82c2-da461559ee64.jpeg', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('b2d8fb0150e98aa3516a522bfb8192ab', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '99c22749-9e92-456a-ad84-1ccbc86d142c.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '0bc4b4e6-ec84-4e6b-a69a-4255c2506583.jpeg', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('b6ffb79008a6238deb954e621fd824bb', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '590cc249-6d23-46b5-b510-088d8422fa3b.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '0f731c11-61ee-4838-8898-3c4e46a7cf44.png', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('b8acbe2f1707a0a2d80642225e86891f', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '164de01b-0f98-4efe-ac40-66f02447988a.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', 'ed632d77-c136-4a85-b07a-bf2e08808313.png', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('ba018b1c1a50fb44f058414a247f3f5e', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '56696dd3-4ea1-473b-8a4e-9b95fa8863a3.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '0b1847d7-627a-4e9b-a33a-f8b379eec0cb.jpeg', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('bd63cd083794d49f348bf91a36e5f49a', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'dcff9673-1836-4a7f-b738-ca88be52a5a9.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', '3cab3fd4-bc3c-4627-bf86-793c260196c6.jpeg', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('c6d1815e200d3378e6644c389351ff61', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'ef840c56-1140-45e1-be79-4b3ced4244ba.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', 'e9652f54-9f43-4164-a449-2ae105d0b5ce.jpeg', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('c850305d5a32c9b36a2a9977ab8c0761', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '0de39860-df6b-4e08-9828-53a0d357e005.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', '44bd36cb-7dd5-4401-8e97-d5b6e1e8a9eb.jpeg', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('c8ae4d996adddec02dbe3b29a2e9977c', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'eab3b6f3-3bba-4854-825d-bafdbf3356d8.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'd2ad69b1-eb3c-4a0e-af85-34f21e47cab4.jpeg', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('cc155b974baa6f6bf1dee52df1d5749a', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'e5f919f2-d0aa-48b8-89fc-8d7c7e95c2d7.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '1500eeb2-6ecc-4dac-9db1-cb4d6d20f442.jpeg', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('cefb55369c1610902780349a6ec7930a', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '5646abae-7d17-4389-a13b-a09ad5785930.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '7eb839ba-a16c-4aa5-9b17-59ca9dd497a8.png', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('cf8ec91d7ef56a1e70812a1d483a6fdb', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '81797150-fad8-4c4f-98ea-ade06727df36.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'a886df73-fa90-4a09-ae94-b7af0cb62376.jpeg', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('d347c500c245ffe0911128590bce307d', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/cfb6eb6e3108444c8e7a4f7ecbc5267f/{1}/{2}/{3}.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '/7879a1eaf4ae49dc876c63834f89817f/{1}/{2}/{3}.png', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('d73d9d0a30223923cbef70433bcceb0d', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '201e28c4-84e6-43a2-b2f5-7f1373c91059.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '17d62923-1b27-45e1-b3e2-79af38f2e41f.jpeg', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('ddc5ce5d4e2c0ab6d373f2066eb2ed3c', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '49ce0583-6c6b-4724-9df7-bbeba62d7a7c.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', 'e2b65996-2707-459d-9b91-a73f365ec527.jpeg', '2019-05-31 08:49:23', '27b0e7d5eee756036af357b1ac64ad4d');
INSERT INTO `safe_problem` VALUES ('dee7cef292eec3a23b7d7bb48e8cb7fe', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'd6a3dd8b-dad6-4c02-b6ce-362735e39727.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '0174a2ed-bb0e-4f82-96fc-c436832794b4.png', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');
INSERT INTO `safe_problem` VALUES ('e0f36be92ad77e026f1c934a97302cff', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '0493cb2e-80bc-4d44-9db4-163af8f4a554.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '6c7e6936-65fb-4b8f-abeb-1201ceadfa26.jpeg', '2019-05-31 08:35:08', 'fb07549a1d8d07c2ec1b5d653fbccd2b');
INSERT INTO `safe_problem` VALUES ('e76092ca58acb45191fc47e0ea81be6a', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '3998cfa3-130b-458d-bb61-bf9714b8e13a.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '25efce11-7f40-487c-9bea-43d9c5dd906a.png', '2019-05-31 09:17:01', '78451f7379da7399faecd36d5928487b');
INSERT INTO `safe_problem` VALUES ('e86e340ee0163260eaa2e98ae1e06bca', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'b3273e4c-1f4d-44bb-9655-d617c5532377.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '495a26f3-e024-4fe4-adc0-0e076d094c37.png', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('eea773e9d9f7544ba448f0bbdbc88e97', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '48165fe9-ecdd-44a0-8149-e1a06121775f.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '7ed57de3-c022-4d1b-8ae3-91fbd2ec52f5.png', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('eefd9bdabf35220e52affdc9a3ad9529', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '26689770-b316-46a1-a906-23cf890484e3.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', '2f6e13ca-e926-4860-a07f-ae75fff36cb1.jpeg', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('f30e393d27e73629511dd94c34aea69f', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '2b91b3e0-fe6b-43eb-bcc3-c8f7a1b78e5c.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', 'fa38b80a-83d9-4ae5-80b1-2ccc94bb20b7.png', '2019-05-31 09:13:32', '77cf79a980252bd3ff6122deb4db71da');
INSERT INTO `safe_problem` VALUES ('f458c46bc48b560d6004b55380309f54', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'b3241229-b0df-4885-9e93-0623675e7d7e.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '701e33ef-0d17-44fb-a849-7b1bdd5ad3cb.jpeg', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('f585330c010173f707a6565129c58090', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/32ec78afb4eb4d2f8d30c26dfdc82d9c/{1}/{2}/{3}.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '/2d28199f5cf04cac8b30d3506ebdd5c3/{1}/{2}/{3}.png', '2019-06-02 16:12:22', '2199c72954fb11c59ccff5f598207276');
INSERT INTO `safe_problem` VALUES ('fe76c605586963aefe5a08e0535ecc3d', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', 'f979c216-0e15-43e4-a2cd-a2e2b4f4628c.png', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '74e156f1-0732-45a0-8c26-3b16fe9d673c.png', '2019-05-31 09:18:49', '33dbf9b424e06c6a1878d5132a86e8b2');
INSERT INTO `safe_problem` VALUES ('ff45817b1b2ea79ca05dff6ab3e6a5dc', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', 'dce991f9-5f6d-44b5-812b-174ec22631e3.png', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '0bc812cb-6f52-4385-8499-b2a8bdf51a6c.jpeg', '2019-05-31 09:07:39', 'bb56dc289c9dc736922f11b130532a58');

-- ----------------------------
-- Table structure for state_judgement
-- ----------------------------
DROP TABLE IF EXISTS `state_judgement`;
CREATE TABLE `state_judgement`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of state_judgement
-- ----------------------------
INSERT INTO `state_judgement` VALUES ('6a11b124-bfd2-4caf-b462-4971eebc3028', '管理执行类');
INSERT INTO `state_judgement` VALUES ('5343263d-ea20-42cb-a2db-39aeaf824681', '不安全行为类');
INSERT INTO `state_judgement` VALUES ('a43e6244-a3e6-4028-a6e2-2592f59c1151\r\n', '静态隐患类');

-- ----------------------------
-- Table structure for subdivision_type
-- ----------------------------
DROP TABLE IF EXISTS `subdivision_type`;
CREATE TABLE `subdivision_type`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pc_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subdivision_type
-- ----------------------------
INSERT INTO `subdivision_type` VALUES ('8cc4b2b0-c0c7-4490-aed2-d101eb8ecaf5', '驾驶车辆超速', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('6c07d700-606d-44ea-8842-02f4d72dcccf', '驾驶车辆不系安全带', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('198ca527-066e-400e-a227-44e92d411eeb', '违章停车', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('4a57ace3-5020-41c3-8770-5f2f0f66ff79', '不按要求使用手机', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('84e47977-d365-4c4a-8458-87bc293ecee3', '不走人行道', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('173e95fd-a136-4f28-9f0a-55beed084228', '不执行3210', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('9bb84c3a-0bb9-463b-b235-8c4fef229b45', '作业不执行SOP', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('e056a008-6abc-4967-83c2-d2e03ead91f3', '不佩戴PPE', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('e950087c-4012-4417-9682-ccdfaad5c5a0', '双手插兜行走', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('d34f1f61-10b5-4143-80a6-96e13abb94c3', '其他', '149dff35-73a7-4656-a82f-dc93d8833ea2');
INSERT INTO `subdivision_type` VALUES ('de266191-a6b3-41fc-a142-a43c4bb1f43f', '未按规定张贴标签', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('a6614d55-bc27-4ba4-9823-a7fcbffaa8dc', '使用其他容器盛装化学品', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('de8e8236-6ae2-4421-a120-8d21f36f35d7', '区域未张贴SUI和MSDS', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('892b2dac-9732-49e2-a254-70fbe7e2a6b7', '化学品未按规定位置储存', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('f66ada94-cce4-4e38-a91c-436ddb4f0e29', '使用现场未设置洗眼器和点检', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('d86de372-df99-425e-afe2-529d0ebbe4ea', '带入未经许可的化学品', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('0522defa-55b8-4cc1-82ff-476ab4240e05', '其他', 'b4f5a2f1-4ed5-4579-8e5f-47ce0adc30d0');
INSERT INTO `subdivision_type` VALUES ('1f06219a-5ab9-4a2b-b58a-69d53e6b157e', '物流车辆有损坏', '81155412-e228-4ca2-ad3b-0e0176f9878b');
INSERT INTO `subdivision_type` VALUES ('57c761c3-94e9-4329-a0c4-da86b94fec14', '物流车辆点检不全', '81155412-e228-4ca2-ad3b-0e0176f9878b');
INSERT INTO `subdivision_type` VALUES ('878836f6-3f30-46fe-91ec-2f8b31740512', '其他', '81155412-e228-4ca2-ad3b-0e0176f9878b');
INSERT INTO `subdivision_type` VALUES ('77fc77b7-6612-4533-ae1d-c56031c1b9a8', '未按规定进行垃圾分类', '7e35f3fe-9dd1-4c47-866f-913fc6c5818f');
INSERT INTO `subdivision_type` VALUES ('cb1aec88-ee9a-4305-8745-8a7edf1f8bf3', '排污设备没有正常运行', '7e35f3fe-9dd1-4c47-866f-913fc6c5818f');
INSERT INTO `subdivision_type` VALUES ('c4544404-45f3-4fd5-a83f-91f75cb89d65', '危废包装破损', '7e35f3fe-9dd1-4c47-866f-913fc6c5818f');
INSERT INTO `subdivision_type` VALUES ('1a056a19-2fa1-4be1-a740-c2e05b7c99c1', '危险废物包装容器未张贴对应标识', '7e35f3fe-9dd1-4c47-866f-913fc6c5818f');
INSERT INTO `subdivision_type` VALUES ('509049db-6eb3-49e0-bda3-ec538043a858', '其他', '7e35f3fe-9dd1-4c47-866f-913fc6c5818f');
INSERT INTO `subdivision_type` VALUES ('a9553a66-3b70-4009-9e76-5d0baffa9b96', '灭火器未点检，周围放杂物', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('62083615-fac0-44be-ba9c-e713b25fe871', '应急照明损坏', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('094bdf62-f668-43ca-800a-961aaf849212', '安全通道堵塞', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('298a38b6-8a9d-4196-80ab-e5ccb2c74d01', '安全疏散指示标识缺失', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('df6225b3-189f-4eaf-af00-8978c39f855c', '安全出口堵塞', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('be2e89f8-b790-4abe-afc8-06b244e7e5fd', '消防设施破损', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('34b8ba62-d044-4bda-9917-6c38bf913689', '其他', 'dbd6428d-d36a-44d0-98ef-1d6b7416aa0e');
INSERT INTO `subdivision_type` VALUES ('33c53181-783f-4374-9e4e-48f4a83ea425', '作业人员未持电工证', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('5195f540-c2f5-49ce-9dce-264ab61ce8f6', '电气设备超负荷或带病运行', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('cc63d134-2a3a-45d8-a406-9f6cb10be395', '电气设备接线损坏或松脱', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('4e8b0e54-824c-4b56-b11e-0d13e472f8b1', '电气设备附近易燃易爆腐蚀品', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('8d371052-5e3e-4cc5-8ef1-1fb7cf69dbc7', '配电箱标签缺失或损坏', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('82b4c9f1-a779-4542-8ba4-c43c3d17b8b1', '用电设施积尘、破损、护罩缺失、线头裸露、运行振动等现象', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('cf1eb073-53d3-43fc-9ae1-6b9c4839fa24', '配电箱积尘，0.8米有杂物', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('62936c58-4ec9-43f8-a877-c6c1a3674eca', '其他', '0aa12a14-2321-41c7-bb69-a39853869b6d');
INSERT INTO `subdivision_type` VALUES ('aff7f2ab-9e2b-4f05-aab2-a4a81bd51e48', '能量锁无信息或信息不全', 'edc21820-4d19-48f2-be75-f1b9a32a81a0');
INSERT INTO `subdivision_type` VALUES ('27e20df1-b660-486b-a7a0-40517d75893d', '能量锁定图、锁定点与现场信息不对应', 'edc21820-4d19-48f2-be75-f1b9a32a81a0');
INSERT INTO `subdivision_type` VALUES ('40b605a8-18b4-4210-b0c3-aec1b1943ba9', '未执行能量锁定流程', 'edc21820-4d19-48f2-be75-f1b9a32a81a0');
INSERT INTO `subdivision_type` VALUES ('c77aae99-f5f3-4bf7-a745-4856ddb46443', '其他', 'edc21820-4d19-48f2-be75-f1b9a32a81a0');
INSERT INTO `subdivision_type` VALUES ('82103d93-1250-45d8-90c1-af7fe1c201fc', '作业未经过审批，作业证内容与现场不符', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('aaf3c29f-2c95-4b77-8134-816e19f20f47', '无现场监护或监护人无资质', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('bdba2823-8c10-4f62-b7e8-a39beb4d077e', '无防护措施或措施不到位', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('20ce3bf6-572f-480f-9320-3f8f5ff0661a', '高风险作业所用设备设施损坏', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('417cdd19-5805-4e3a-8539-72dd73286111', '未按照SOP或作业预计划内容进行作业', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('d03f062d-747c-495a-882f-9fe6307f4f9a', '有限空间目视标识有误', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('90c85889-f4e8-4e1b-bd55-bc799945eef2', '人员进出未按规定登记或未授权人进入', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('35833209-d183-46a6-94f2-e1b076538aa4', '其他', '88a54aff-93f8-4224-9bc3-8e41d6e1d23b');
INSERT INTO `subdivision_type` VALUES ('14a2d61e-6efc-402a-99ea-40d2fd1d656f', '作业未经过审批，作业证内容与现场不符', '9f7d5032-94a5-4afc-a300-922875854d8a9f7d5032-94a5-');
INSERT INTO `subdivision_type` VALUES ('60638677-25cf-4558-904d-df925ce64e1a', '无现场监护或监护人无资质', '9f7d5032-94a5-4afc-a300-922875854d8a');
INSERT INTO `subdivision_type` VALUES ('4b7d08f6-c41b-4563-959b-5085c6290987', '无防护措施或措施不到位', '9f7d5032-94a5-4afc-a300-922875854d8a');
INSERT INTO `subdivision_type` VALUES ('58452d55-3885-449d-9ab2-2c5fe2904663', '高风险作业所用设备设施损坏', '9f7d5032-94a5-4afc-a300-922875854d8a');
INSERT INTO `subdivision_type` VALUES ('daf754e2-fca2-4b74-92c3-53fc211e0788', '未按照SOP或作业预计划内容进行作业', '9f7d5032-94a5-4afc-a300-922875854d8a');
INSERT INTO `subdivision_type` VALUES ('f9d7facf-d691-4850-b4b1-720e5522b020', '高处作业人员未考取相关证件', '9f7d5032-94a5-4afc-a300-922875854d8a');
INSERT INTO `subdivision_type` VALUES ('98580ea8-1328-4206-93eb-b61cdc3b6e00', '其他', '9f7d5032-94a5-4afc-a300-922875854d8a');
INSERT INTO `subdivision_type` VALUES ('dcadc42d-831c-4e0c-b389-5bd63e030cb1', '人员进出未按规定登记或未授权人进入', '8a9af291-e60e-4658-a914-5c203bf99369');
INSERT INTO `subdivision_type` VALUES ('c57c5204-7753-4b37-8783-ac151f8ce085', '现场无监护或监护人员无资质', '8a9af291-e60e-4658-a914-5c203bf99369');
INSERT INTO `subdivision_type` VALUES ('75469849-54c4-4653-a702-4a0208075b99', '无防护措施或措施不到位', '8a9af291-e60e-4658-a914-5c203bf99369');
INSERT INTO `subdivision_type` VALUES ('c82cec6c-7897-431e-84ea-f8d36b1d6606', '未按照SOP或作业预计划内容进行作业', '8a9af291-e60e-4658-a914-5c203bf99369');
INSERT INTO `subdivision_type` VALUES ('6a46d380-a5ef-474d-8d02-17de5c9be49b', '危险隔离区目视标识有误', '8a9af291-e60e-4658-a914-5c203bf99369');
INSERT INTO `subdivision_type` VALUES ('b216a471-ad87-4fa8-ac82-8f5fabed2150', '其他', '8a9af291-e60e-4658-a914-5c203bf99369');
INSERT INTO `subdivision_type` VALUES ('d2d21424-a09a-49d7-9de6-8ddb53937916', '作业区域防护缺失', 'b958c303-8e46-4880-a207-8796dafeb25b');
INSERT INTO `subdivision_type` VALUES ('87643b0c-db3b-4e1f-a6bc-98457f292f52', '各种行程限位、联锁装置、抗干扰屏蔽及急停装置故障或失效', 'b958c303-8e46-4880-a207-8796dafeb25b');
INSERT INTO `subdivision_type` VALUES ('68d01a9a-02b7-4a98-ad96-9e9f9f084efc', '执行机构应定位准确、抓取牢固；自动锁紧装置应灵敏、可靠', 'b958c303-8e46-4880-a207-8796dafeb25b');
INSERT INTO `subdivision_type` VALUES ('baca08df-65c6-426e-8ca9-3f24ebaf65c0', '其他', 'b958c303-8e46-4880-a207-8796dafeb25b');
INSERT INTO `subdivision_type` VALUES ('f122cb6e-e7b1-4540-b484-d8e17b87ff05', '现场公示信息不全', 'e8170c89-d32c-4376-98bc-489b4d7aad0a');
INSERT INTO `subdivision_type` VALUES ('ca0fe8e6-2334-4035-ad67-406e0b611a85', 'PPE使用错误', 'e8170c89-d32c-4376-98bc-489b4d7aad0a');
INSERT INTO `subdivision_type` VALUES ('a52b8adc-a912-499e-8342-7517319af947', '其他', 'e8170c89-d32c-4376-98bc-489b4d7aad0a');
INSERT INTO `subdivision_type` VALUES ('cff1420a-5136-4130-8b0c-8ca4d2f81ca1', '现场标示牌破损', '5c0b3466-ee20-455e-87d5-da80fc8c2a6e');
INSERT INTO `subdivision_type` VALUES ('fc83a86f-55bb-4f2c-b31f-ae38068df849', '现场目视化信息不全、错误', '5c0b3466-ee20-455e-87d5-da80fc8c2a6e');
INSERT INTO `subdivision_type` VALUES ('9bf446e3-67a5-49fd-adc5-02158e0cdef2', '现场目视化信息未及时更新', '5c0b3466-ee20-455e-87d5-da80fc8c2a6e');
INSERT INTO `subdivision_type` VALUES ('477d0079-7777-4cf3-9d88-aa014713dfe9', '其他', '5c0b3466-ee20-455e-87d5-da80fc8c2a6e');
INSERT INTO `subdivision_type` VALUES ('bb4a0139-b305-4a0c-9b6b-86b04166d2c9', '物品未进行定制定位', '0432b20b-c967-4708-b0e6-dce97d7abf01');
INSERT INTO `subdivision_type` VALUES ('037dd5d8-fc32-4d3f-a746-0b5d17f02942', '地面不用平整，有障碍物和绊脚物，坑、壕、池应设置盖板或护栏', '0432b20b-c967-4708-b0e6-dce97d7abf01');
INSERT INTO `subdivision_type` VALUES ('88f071e4-a33c-4e5f-91e1-c467ee68dec7', '地面有积水、积油或垃圾杂物，排水管网不通畅', '0432b20b-c967-4708-b0e6-dce97d7abf01');
INSERT INTO `subdivision_type` VALUES ('66054efd-9e69-4b23-9773-d3e6e89b6b3d', '通道两边有突出物品或锐边物品', '0432b20b-c967-4708-b0e6-dce97d7abf01');
INSERT INTO `subdivision_type` VALUES ('be9b6ba2-e101-49cc-86b9-4f7de1bb179a', '照明不良', '0432b20b-c967-4708-b0e6-dce97d7abf01');
INSERT INTO `subdivision_type` VALUES ('b7dcf1d3-73d9-47ba-b1f2-5a1def7deda9', '其他', '0432b20b-c967-4708-b0e6-dce97d7abf01');
INSERT INTO `subdivision_type` VALUES ('5f99186e-54c5-4bcd-8377-9ffde9d84967', '未辨识风险', '471afed4-006f-4728-976b-d019aec81dc7');
INSERT INTO `subdivision_type` VALUES ('15678be4-978d-49de-874b-a920a47a865e', '未执行TPM或不按规定执行', '471afed4-006f-4728-976b-d019aec81dc7');
INSERT INTO `subdivision_type` VALUES ('00e1c015-0d44-4cdc-8217-c02840ce783b', '未经培训', '471afed4-006f-4728-976b-d019aec81dc7');
INSERT INTO `subdivision_type` VALUES ('0cdc966b-f73d-400c-87d0-1ef236aabd49', '其他', '471afed4-006f-4728-976b-d019aec81dc7');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `superior_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `review_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('213653ea74d188f6a682d32fa60035ef', '1n', '1n', '666', 'root', '已注销', '2019-05-24 21:25:56', '2019-05-31 08:33:43');
INSERT INTO `user` VALUES ('2c9faa2796384aab4d3adafc80efecf2', '0838_8', '111', '888888', '8faa3fc1528cac842cb67f11ea0a7875', '已审核', '2019-06-03 08:07:29', '2019-06-03 08:07:29');
INSERT INTO `user` VALUES ('86e9343b57ad7114c61ee3b73f5b1af3', '112', '112', '112', '8faa3fc1528cac842cb67f11ea0a7875', '已审核', '2019-05-31 08:34:30', '2019-05-31 08:34:51');
INSERT INTO `user` VALUES ('8faa3fc1528cac842cb67f11ea0a7875', '111', '111', '111', '', '已审核', '2019-05-31 08:17:14', '2019-05-31 08:21:31');
INSERT INTO `user` VALUES ('admin', 'admin', 'admin', 'admin', '', '已审核', '2019-05-24 21:26:38', '2019-05-24 21:35:10');
INSERT INTO `user` VALUES ('audit', 'audit', 'audit', 'audit', '', '已审核', '2019-05-24 21:21:04', '2019-05-31 08:33:47');
INSERT INTO `user` VALUES ('d767a39260e38c40231926f8857fa26d', '110', 'wcj', '123', '8faa3fc1528cac842cb67f11ea0a7875', '已审核', '2019-05-31 08:28:56', '2019-05-31 08:32:57');
INSERT INTO `user` VALUES ('root', 'root', 'root', 'root', 'admin', '已注销', '2019-05-24 21:20:55', '2019-05-31 08:33:30');

SET FOREIGN_KEY_CHECKS = 1;
