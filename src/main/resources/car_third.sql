/*
Navicat MySQL Data Transfer

Source Server         : 60.205.187.142_3306
Source Server Version : 50173
Source Host           : 60.205.187.142:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-07-30 17:51:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audit_hierarchy
-- ----------------------------
DROP TABLE IF EXISTS `audit_hierarchy`;
CREATE TABLE `audit_hierarchy` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audit_hierarchy
-- ----------------------------
INSERT INTO `audit_hierarchy` VALUES ('f083b624-f950-4dfa-be5f-c0b577a15607', '公司级');
INSERT INTO `audit_hierarchy` VALUES ('9503ba57-442d-45fe-8cda-c2b4b1d5078d', '车间级');
INSERT INTO `audit_hierarchy` VALUES ('639d1147-47b1-4531-aa9f-4bbf9188f24d', '工段级');
INSERT INTO `audit_hierarchy` VALUES ('aa443d30-156c-49ec-8411-33c5bc4784e3', '班组级');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` char(32) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('e05804b745ae6aa1e2f2f1202268d81d', '冲压车间2', '2019-06-24');
INSERT INTO `category` VALUES ('26663fcb42dd847efa6c6736ccf3174d', '冲压车间4', '2019-06-11');
INSERT INTO `category` VALUES ('e7b7b940a832fee6a4b179491131b2fb', '冲压车间5', '2019-06-11');

-- ----------------------------
-- Table structure for completion_status
-- ----------------------------
DROP TABLE IF EXISTS `completion_status`;
CREATE TABLE `completion_status` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of completion_status
-- ----------------------------
INSERT INTO `completion_status` VALUES ('492ee83f-c867-4c53-b09c-5c07084abbd4', '4/4');
INSERT INTO `completion_status` VALUES ('5479c37f-fe3c-4527-a5b7-48c0e6259e4b', '6/6');
INSERT INTO `completion_status` VALUES ('0306471c-7e53-4d6d-9e71-408a2f74ee38', '完成');
INSERT INTO `completion_status` VALUES ('6659fe2e-e15e-4696-9d9f-4f641aa1295a', '1');

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `doc_id` char(32) NOT NULL,
  `doc_new_name` varchar(255) NOT NULL,
  `doc_origin_name` varchar(255) NOT NULL,
  `happen_time` date NOT NULL,
  `second_category_id` char(32) NOT NULL,
  `user_id` char(32) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('3ddcd3b96632e962811d49d2ab650cdc', '/df7df8a9dfd448a7b2d16fbe1eb55cb0.docx', '简历.docx', '2019-06-22', 'b7c3061f13e1d043b74c7697255c4f7b', '8faa3fc1528cac842cb67f11ea0a7875', '2019-06-22');

-- ----------------------------
-- Table structure for integration
-- ----------------------------
DROP TABLE IF EXISTS `integration`;
CREATE TABLE `integration` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `mark` double(50,2) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `mark_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integration
-- ----------------------------
INSERT INTO `integration` VALUES ('5d05ed5536aa5c47faca10e48cceb96a', '555', '山东科技大学', '-1.00', '0776db34710758bf930801507b93ad3d', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `integration` VALUES ('6d4fc81ae974383c69125f8e69da6c71', '555', '山东科技大学', '0.00', '0776db34710758bf930801507b93ad3d', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `integration` VALUES ('fc5fd58c3db0898a4f48a0b024a1697a', '666', '山东理工大学', '-1.00', '6541708a46f36e6f38925db73bc649dd', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `integration` VALUES ('49597a0d5e7c825fe4f52aa184a521e4', '444', '山东理工大学', '44.00', 'c9f08142dbf3ec312dbdf778edaed5b0', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `integration` VALUES ('5fb451d1a6927bca253b38c9586584e6', '666', '山东科技大学', '-1.00', '6541708a46f36e6f38925db73bc649dd', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `integration` VALUES ('cb1747aab2be146c306503d8960b4d9d', '555', '山东科技大学', '100.00', '0776db34710758bf930801507b93ad3d', '8faa3fc1528cac842cb67f11ea0a7875');

-- ----------------------------
-- Table structure for problem_classification
-- ----------------------------
DROP TABLE IF EXISTS `problem_classification`;
CREATE TABLE `problem_classification` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES ('b1488df4-8681-4d20-8a27-4189b91719d5', 'A');
INSERT INTO `rank` VALUES ('8000c228-f024-406f-89d1-0d0aeddecb4b', 'B');
INSERT INTO `rank` VALUES ('ed45b184-57fb-4abe-b3a0-179cac8728a8', 'C');

-- ----------------------------
-- Table structure for reason
-- ----------------------------
DROP TABLE IF EXISTS `reason`;
CREATE TABLE `reason` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reason
-- ----------------------------
INSERT INTO `reason` VALUES ('f051a62d-04d6-475b-af5f-b232eabc912f', '山东科技大学');
INSERT INTO `reason` VALUES ('d2130939-4b0d-44a9-b8c5-599e08d4c19a', '山东理工大学');
INSERT INTO `reason` VALUES ('e3d52841-0a31-4ea6-ab97-82d392225001', '中国石油大学');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` varchar(50) NOT NULL,
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `commit_time` datetime DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('5146875475230e023df6a5907b21b2a6', '111', '111', '2019-06-25 20:38:49', '8faa3fc1528cac842cb67f11ea0a7875');
INSERT INTO `record` VALUES ('5ad77d8a34f23944471327b2ce88da7e', '555', '555', '2019-06-25 16:02:54', '0776db34710758bf930801507b93ad3d');
INSERT INTO `record` VALUES ('a96b63769a1b55e48c57250b557249e5', '111', '111', '2019-06-25 16:00:38', '8faa3fc1528cac842cb67f11ea0a7875');

-- ----------------------------
-- Table structure for responsible_area
-- ----------------------------
DROP TABLE IF EXISTS `responsible_area`;
CREATE TABLE `responsible_area` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
INSERT INTO `responsible_area` VALUES ('cc0d03f1-08d1-40b8-af91-9091455c2c12', '新能源');

-- ----------------------------
-- Table structure for safe_problem
-- ----------------------------
DROP TABLE IF EXISTS `safe_problem`;
CREATE TABLE `safe_problem` (
  `problem_id` varchar(50) NOT NULL,
  `audit_area` varchar(50) DEFAULT NULL,
  `propose_time` date DEFAULT NULL,
  `problem_description` varchar(50) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `state_judgement` varchar(50) DEFAULT NULL,
  `problem_classification` varchar(50) DEFAULT NULL,
  `subdivision_type` varchar(50) DEFAULT NULL,
  `rank` varchar(50) DEFAULT NULL,
  `rectification_measures` varchar(50) DEFAULT NULL,
  `responsible_area` varchar(50) DEFAULT NULL,
  `person_liable` varchar(50) DEFAULT NULL,
  `completion_deadline` date DEFAULT NULL,
  `audit_hierarchy` varchar(50) DEFAULT NULL,
  `repeat_question` varchar(50) DEFAULT NULL,
  `completion_status` varchar(50) DEFAULT NULL,
  `finish_photo` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `record_id` varchar(50) DEFAULT NULL,
  `is_completion` int(5) DEFAULT '0',
  PRIMARY KEY (`problem_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of safe_problem
-- ----------------------------
INSERT INTO `safe_problem` VALUES ('027ce791d930651683893bc95e328fa5', '总装车间', '2019-06-20', '总装车间东侧男厕所内发现违章吸烟的现象', '/8fb98967f0314d07855630bc0cda1153', '管理执行类', '消防安全', '其他', 'C', '对区域内员工进行重复培训，并对违章人员进行处罚', '各相关区域', '各相关区域经理', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('0535400c6c19a5834fa57f20d46794ef', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/a6eecff16f5b4873a56cb73693cc9a97', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/fccc9823861d403cb8f3055f8ccf4d3a', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '1');
INSERT INTO `safe_problem` VALUES ('09226843d8653cb15569c76510fb9795', '涂装车间', '2019-06-18', '涂装车间电泳液转移循环泵2设备地面有油污残液，人员有滑倒风险', '/63378c5e913a437fb86ccb3b8028a16f', '静态隐患类', '作业现场及5S', '地面有积水、积油或垃圾杂物，排水管网不通畅', 'C', '清理地面油污，增加对设备检查，查找原因进行修复', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('0eeb096b8ad8e4903aa773633997e53a', '发动机工厂', '2019-06-19', '一期装配打印发动机号处小储油罐未设置防泄漏托盘，润滑油有很多滴落地面，易滑倒作业人员', '/7ff502dc83e8447dba6d08185b7503bb', '静态隐患类', '化学品安全', '其他', 'C', '设置防泄漏托盘', '发动机工厂', '许可会', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('0f92149712de6198b9b1a67a3681a8c5', '维保办公室', '2019-06-16', '维保办公室门口绿化带内有一桶固化剂，名称标签已不清晰，无化学品标签', '/b530acea23764e818b06c3bb749c5ca7', '静态隐患类', '化学品安全', '未按规定张贴标签', 'C', '化学品进厂应进行申请，使用、存放现场应张贴MSDS和SUI', '维修车间', '王钦光', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('117264240e4ecc83fd8ddfba8304ce57', '总装车间', '2019-06-14', '质量检测线旁的斑马线没有执行3210的安全确认目视', '/f84166788c5b4e0e93a5f8c52fe78c1a', '静态隐患类', '目视化信息', '其他', 'C', '整条检测线中间以及侧面过车的地方都没有增加目视化', '质量科', '张作展', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('1274b7d48a566e66a647ca1204a43556', '车身车间', '2019-06-17', '车身车间BD-DRP-005、BD-105两处灭火器6月份未开展点检，且一处灭火器已过期', '/50325c57d000413385fd65dbdcd4dc19', '管理执行类', '消防安全', '灭火器未点检，周围放杂物', 'C', '对灭火器开展6月份点检，更换过期灭火器', '车身车间', '张建刚', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('140fb626e779708a80a14b47e2e8f32b', '总装车间', '2019-06-20', '上汽实业员工在总装车间在非手机接听点使用手机', '/99aab2eee3f5462996b12959e172e717', '不安全行为类', '不安全行为', '其他', 'C', '对违章员工按公司相关要求进行处罚，并培训相关安全要求', '采购物流', '李琦嵘', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('14a90c6b54f5012ad09432abc85dea68', '总装车间', '2019-06-20', '上汽实业员工在总装车间在非手机接听点使用手机', '/5e9e9a3c1ac54a2ba20a9a03ced4c814', '不安全行为类', '不安全行为', '其他', 'C', '对违章员工按公司相关要求进行处罚，并培训相关安全要求', '采购物流', '李琦嵘', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('163ceab2fe72f109d05e461032e33edc', 'B线污水处理站', '2019-06-18', '涂装B线污水处理站一安全出口指示灯电源开关被关闭，安全出口紧急情况下无法使用', '/66faa313388e41e7ae1d16ab2c360f5e', '管理执行类', '消防安全', '其他', 'C', '恢复电源开关，相关方班长增加对安全设施的检查', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('190c51212a61db5c035b5b954006f3cc', '厂区', '2019-06-15', '车身东侧DOCK区铺设沥青时主干道石块掉落，影响物流车通行', '/ebaf94db28334ea7829186415c5d52ff', '静态隐患类', '管理缺失', '其他', 'C', '及时清理', '采购及供应链管理科', '李琦嵘', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('1f26e50ec4a870f2ba5c0cd470879a60', '发动机工厂', '2019-06-18', 'PT-108机柜进线线槽连接处缺少跨接线', '/802b9b07b6ab46c5a2bace4611430ba2', '静态隐患类', '用电安全', '其他', 'C', '线槽连接处增加跨接线', '发动机工厂', '许可会', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('1f3189cb437ad961dc71a2d0c38df940', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/485f4ad716a1446192f98ca785898970', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '发动机工厂', '李琦嵘', '2019-04-10', '车间级', '是', '3/4', '/8b43d21a090c4c48875abf113e58356a', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '0');
INSERT INTO `safe_problem` VALUES ('2213972f7a4091622476fcc11555b0aa', '涂装车间', '2019-06-18', '涂装车间电泳液转移循环泵2设备地面有油污残液，人员有滑倒风险', '/a8b7e7bc45284bbd97dfa9476f6b2f7f', '静态隐患类', '作业现场及5S', '地面有积水、积油或垃圾杂物，排水管网不通畅', 'C', '清理地面油污，增加对设备检查，查找原因进行修复', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('2457ba50490c7b9038d0565642d5ac55', '车身维修', '2019-06-18', '车身维修班长（田玉普）没有按照班组长每日安全巡视过程记录表进行每日的安全巡视', '/07ab25f6bd6a48ddb0c380e1bedc6377', '管理执行类', '管理缺失', '其他', 'C', '班组长应按照班组长每日安全巡视过程记录表进行每日的安全巡视，并将发现问题记录在表单中', '维修车间', '王钦光', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('29f504cfe565ffba14c6b0cb1f11d4bd', '总装车间', '2019-06-20', '上汽实业SPS员工在总装车间内边走路边看手机（证件登记的归口管理部门为采购科）', '/30de6c0a6c90413a8f12c6250d8e29ac', '不安全行为类', '不安全行为', '走路使用手机', 'C', '对违章员工按公司相关要求进行处罚，并培训相关安全要求', '总装车间', '王洪磊', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('2db7f2d0dbf6a1084e8ebf2ad7befedc', '冲压车间', '2019-06-17', '冲压修模区电缆桥架开焊', '/cd7e5376465a45b2862943db8c5c9f09', '静态隐患类', '用电安全', '电气设备接线损坏或松脱', 'C', '对开焊点进行维修，举一反三排查', '冲压车间', '叶迎江', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('3064870afb98bcae616339683e4e03a4', '厂区', '2019-06-14', '总装至RDC的门岗附近掉落零件存在隐患，过往的司机视而不见', '/f40553cb377e438d924308522139c850', '静态隐患类', '管理缺失', '其他', 'C', '责任区域传达相关的问题', '采购及供应链管理科', '李琦嵘', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('30b7d55dcb932ace17bdf28364cf9de4', '总装车间', '2019-06-20', '质量检测线产品车停放在斑马线上，导致员工无法正常通行', '/6ddf3fa65e2b4e5ba7ae6a183f0ab5b6', '管理执行类', '管理缺失', '其他', 'C', '规范产品车停放，严禁占用人行通道', '质量科', '张作展', '2019-06-21', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('37d58fe0448a4857afec16f0f4cef053', '餐厅', '2019-06-14', '行政楼餐厅垃圾桶阻挡电器开关，垃圾桶也没有定制', '/f9976ebb1fe74679aba10cd9746547c1', '静态隐患类', '用电安全', '其他', 'C', '将垃圾桶重新放置位置并增加定制', '人力资源科', '罗旭东', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('3bc327b51c6b1f3b4028c33d3458c897', '总装车间', '2019-06-20', '总装东侧物流通道一处托笼随意停放', '/1dd81ad0f0044bac9c2cdc9d00e14854', '管理执行类', '管理缺失', '其他', 'C', '物料托笼严禁随意停放', '采购物流', '李琦嵘', '2019-06-21', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('40d85b59aefd8af7df14da97808278a8', '总装车间', '2019-06-20', 'A线内饰一工段一处危险隔离区域多名授权进入人员培训考试非本人作答', '/ecda0ddef5ed466d91929e9a27b388f2', '管理执行类', '危险隔离区', '其他', 'C', '严格执行危险隔离区域授权进入人员培训考试制度，严禁替考', '总装车间', '王洪磊', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('44c59c462fb0cbaa7667e5fe9444ef3d', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/2489ebe1482d4e9599722d6f401bcf92', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '/e059c1cf7bbc4b2bac7d7215e122d723', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '0');
INSERT INTO `safe_problem` VALUES ('46ed4ec809cad0025c9a7b3a37f19db3', '车身车间', '2019-06-16', '车身门厅改造现场使用两芯线，接地线未连接。请停用设备。', '/28c60ee3de0642478594f657c9ed3fbb', '管理执行类', '用电安全', '电气设备接线损坏或松脱', 'C', '停用设备，非I.II类电动工具应使用三芯线', '车身车间', '张建刚', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('4773cec65803a8550ba74ac0435f4faf', '维保办公室', '2019-06-16', '维保办公室门口绿化带内有一桶固化剂，名称标签已不清晰，无化学品标签', '/1043191f3a074de684065bb8a2d3d817', '静态隐患类', '化学品安全', '未按规定张贴标签', 'C', '化学品进厂应进行申请，使用、存放现场应张贴MSDS和SUI', '维修车间', '王钦光', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('47e9f7778eca6f4313534a6bbf42a60d', 'B线污水处理站', '2019-06-18', '涂装B线污水处理站一安全出口指示灯电源开关被关闭，安全出口紧急情况下无法使用', '/ebcda8ba001d4e33a28694391deb4896', '管理执行类', '消防安全', '其他', 'C', '恢复电源开关，相关方班长增加对安全设施的检查', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('48f452ccf92707227276a20ee2ebf047', '厂区', '2019-06-15', '车身连廊下方建筑垃圾未及时清理', '/09b6a9ff69ca4fff8c1702a4990d9978', '静态隐患类', '作业现场及5S', '其他', 'C', '及时清理', '维修车间', '王钦光', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('490cbd38fa6706c808a7451504d20368', '总装车间', '2019-06-17', '总装车间GA-B09L工位休息时未完成工作，但照明已切断，作业时照明不足', '/4ab9010f30554599ac051f0d5fa3113d', '管理执行类', '作业现场与5S', '照明不足', 'C', '作业完成后再切断照明', '总装车间', '王洪磊', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('4ad4673887507d2e8ec4aa665af614e8', '总装车间', '2019-06-20', '上汽实业SPS员工在总装车间内边走路边看手机（证件登记的归口管理部门为采购科）', '/3913a8dd0f334a04990ee2ea95be4908', '不安全行为类', '不安全行为', '走路使用手机', 'C', '对违章员工按公司相关要求进行处罚，并培训相关安全要求', '总装车间', '王洪磊', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('4ca01ae5e5d51802f056a091141873ce', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/634d0a0a42b14b71846fd8c2978f4140', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '信息系统与服务科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '/c7c3ba69b4f3422686067439473a6402', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '0');
INSERT INTO `safe_problem` VALUES ('4dec5ecb227987c191f82f664667bad4', '涂装车间', '2019-06-18', '涂装车间F19立柱旁一配电箱电线裸露，防护不到位，有磨损漏电风险', '/2f387aed91ec4f48a3066c4e95ee0a1c', '管理执行类', '用电安全', '其他', 'C', '重新对裸露线束进行防护，举一反三排查类似问题', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('511c198989dc8694ffe65a8e2f54a84e', '总装车间', '2019-06-20', '总装东侧物流通道一处托笼随意停放', '/6d7d7eae575b4203a7eceb823202b098', '管理执行类', '管理缺失', '其他', 'C', '物料托笼严禁随意停放', '采购物流', '李琦嵘', '2019-06-21', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('584c21739f8372d5c4aff2f5a1cc3bff', '冲压车间', '2019-06-15', '冲压维修临时用电架空高度不足2.5米', '/4c8a41a7d33c4917b18f23ad1fc085b2', '管理执行类', '用电安全', '其他', 'C', '临时用电室内架空高度不得低于2.5米', '维修车间', '王钦光', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('5d9aae4096f4dc32e2c316cdad3af40f', '发动机工厂', '2019-06-18', '缸盖工段A班次1班组孙巨龙SOT记录表未做周总结，主管未签字确认', '/93d3be749cb14a3a9eabeced3327aa30', '管理执行类', '管理缺失', '其他', 'C', '按照SOT记录表要求回顾总结，主管领导按时确认', '发动机工厂', '许可会', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('61382a28a003d787402eb19f3d97e38d', '涂装车间', '2019-06-18', '涂装车间武汉爱普洗地车充电计时器显示充电2小时，充电记录表登记时间为15:50分，两者时间不一致', '/9b3d9555508440b080945bb0ebae0795', '管理执行类', '管理缺失', '未执行TPM或不按规定执行', 'C', '培训相关方用电要求，严格执行用电安全操作，区域增加巡查', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('634351e2a4de8e65123b563582d426d7', '涂装车间', '2019-06-18', '涂装车间TB-029号灭火器检查表一灭火器有效期过期，更换灭火器后未及时更改检查表有效期', '/01fba7dcacae44658c44bb873575c925', '管理执行类', '消防安全', '灭火器未点检，周围放杂物', 'C', '区域班长按要求按时进行点检确认', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('6642368fd9e927ca2e20ab35db5ed2e2', '发动机', '2019-06-14', '武汉爱普员工在登高作业时站到人字梯最高一层除了监护人在扶着梯子外，其他没有任何防护', '/73e78575b31b4e368479cb86f142e27b', '管理执行类', '高处作业', '无防护措施或措施不到位', 'B', '要求区域对相关方做好培训及管理', '发动机工厂', '许可会', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', '0');
INSERT INTO `safe_problem` VALUES ('6f6800a02dedf99466f21ad44566e1ab', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/f1c4430597f442e0acee6961110b1349', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '公司级', '是', '4/4', '/53a5d7d7f8b54e7ba7b68d56cfe23194', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '1');
INSERT INTO `safe_problem` VALUES ('6f9236ee47131ea3d5db4e3d1cf9b908', '发动机工厂', '2019-06-18', '爱普2号扫地车6月13日充电记录出现在两个表格中，且记录的状态不一致', '/43a063c3f4ee4810a4c955bf1e01340b', '管理执行类', '消防安全', '其他', 'C', '按照要求如实记录充电作业时间', '发动机工厂', '许可会', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('7182e2830c6cce0190c7d2f4f888c77d', '总装车间', '2019-06-20', '总装车间保洁人员未执行3210，提问该员工3210相关内容，该员工不清楚', '/081e7ae46673403b8d4c28c9816e7f22', '不安全行为类', '不安全行为', '不执行3210', 'C', '对违章员工按公司相关要求进行处罚，并培训相关安全要求', '总装车间', '王洪磊', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('735d8304c352751c9ff9ccfe6b628c1c', '发动机工厂', '2019-06-18', 'PT-108机柜进线线槽连接处缺少跨接线', '/b7b0ea954beb49768f0411e51d22a183', '静态隐患类', '用电安全', '其他', 'C', '线槽连接处增加跨接线', '发动机工厂', '许可会', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('7746e0f3ef532194e53151724bb09198', '冲压车间', '2019-06-17', '冲压废料间灭火器上存放杂物', '/88f3a88c6abd49a9b8c0a91f798f6543', '管理执行类', '消防安全', '其他', 'C', '灭火器上禁止存放杂物，区域做好管理', '冲压车间', '叶迎江', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('7b9e7ef32340ed35c2dc58d60d193035', '质量科', '2019-06-18', '质量检验2工段  刘凯  SOT问题对策 未更新', '/dc1be9d806424e8694e75932c969e51d', '管理执行类', '管理缺失', '其他', 'C', '按照问题节点回顾更新', '质量科', '张作展', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('7df95229ffe573c9cc3dcd27594fdac2', '发动机', '2019-06-14', '缸盖毛坯上线及打标工位旁电控箱锁具缺少目视化', '/cdf87edab9d6432191c622e7d276bbb9', '静态隐患类', '目视化信息', '其他', 'C', '增加目视化信息', '发动机工厂', '许可会', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', '0');
INSERT INTO `safe_problem` VALUES ('8689becc02b7b82fd03c5fa7fe9ea215', '涂装车间', '2019-06-18', '涂装车间F19立柱旁一配电箱电线裸露，防护不到位，有磨损漏电风险', '/b98392cdc717403b9b904d7c0f343640', '管理执行类', '用电安全', '其他', 'C', '重新对裸露线束进行防护，举一反三排查类似问题', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('89698543937008ef12197da8be480a04', '发动机', '2019-06-14', '缸盖毛坯上线及打标工位旁电控箱锁具缺少目视化', '/769dc5d75600472fb46504000fa6389f', '静态隐患类', '目视化信息', '其他', 'C', '增加目视化信息', '发动机工厂', '许可会', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', '0');
INSERT INTO `safe_problem` VALUES ('897ca09c22fd29f919a5579cd57d02f1', '发动机', '2019-06-14', '武汉爱普员工在登高作业时站到人字梯最高一层除了监护人在扶着梯子外，其他没有任何防护', '/c1d9cb47840542bcb33318eff44f765c', '管理执行类', '高处作业', '无防护措施或措施不到位', 'B', '要求区域对相关方做好培训及管理', '发动机工厂', '许可会', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', '0');
INSERT INTO `safe_problem` VALUES ('8a5707db1deb345fd393bcaef738bbcb', '总装车间', '2019-06-20', '总装车间保洁人员未执行3210，提问该员工3210相关内容，该员工不清楚', '/f456f90cc18d4579af5f9d6f6130fcaa', '不安全行为类', '不安全行为', '不执行3210', 'C', '对违章员工按公司相关要求进行处罚，并培训相关安全要求', '总装车间', '王洪磊', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('8e1352a592751b3861174ef858bacc5d', '总装车间', '2019-06-20', '质量检测线产品车停放在斑马线上，导致员工无法正常通行', '/3db9da3d1d484a1da2df8bba08380d0b', '管理执行类', '管理缺失', '其他', 'C', '规范产品车停放，严禁占用人行通道', '质量科', '张作展', '2019-06-21', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('8fef5cf054bb6380afd9bbe5d96d4162', '厂区', '2019-06-15', '车身连廊下方建筑垃圾未及时清理', '/83a3fbe343c842468eb2c590774ab937', '静态隐患类', '作业现场及5S', '其他', 'C', '及时清理', '维修车间', '王钦光', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('9029bbe7d00becca3987e999472782d7', 'B线污水处理站', '2019-06-18', '涂装B线污水处理站化学品浓硫酸间TPM检查表班长未及时签名', '/a1703713783749f3b507831733552947', '静态隐患类', '目视化信息', '现场目视化信息未及时更新', 'C', '相关方班长按要求进行检查，确保化学品有效管理', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('9229bbc2c8888c16ed670d2e0871e2bb', '总装车间', '2019-06-14', '质量检测线旁的斑马线没有执行3210的安全确认目视', '/92ebd635c946479fb1b55327277c4446', '静态隐患类', '目视化信息', '其他', 'C', '整条检测线中间以及侧面过车的地方都没有增加目视化', '质量科', '张作展', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('9651122b29b7fba07be8854ba23ba2dd', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/1587ab7cdb7f41aba7b5033fb7706793', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '车间级', '是', '4/4', '/3d5239980b014862be852b06276aea4f', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '1');
INSERT INTO `safe_problem` VALUES ('968d4f9c20de12e32cd17c96955d1ad7', '轮胎区', '2019-06-17', '轮胎区能量锁定流程不全', '/234d385688b141c8a9fb68f5ead0abd9', '管理执行类', '能量锁定', '其他', 'C', '补齐能量锁定步骤', '采购及供应链管理科', '李琦嵘', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('974f91c671f713bb65686cf3b874950e', '质量科', '2019-06-18', '质量检验2工段  刘凯  SOT问题对策 未更新', '/5826a633d50740bfa129101d4c61f03a', '管理执行类', '管理缺失', '其他', 'C', '按照问题节点回顾更新', '质量科', '张作展', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('97fcfa584471c3eef3513f691d36894d', '总装车间', '2019-06-17', '总装车间GA-B09L工位休息时未完成工作，但照明已切断，作业时照明不足', '/7b9d86582ce540db860a7a0370dacf43', '管理执行类', '作业现场与5S', '照明不足', 'C', '作业完成后再切断照明', '总装车间', '王洪磊', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('9a5fc407475c15fe498fdab0e2e1a6ba', '行政楼餐厅', '2019-06-17', '行政楼餐厅配菜间电缆桥架开裂', '/db1c30e4c7f44057bca87a006cc2f95c', '静态隐患类', '用电安全', '电气设备接线损坏或松脱', 'C', '对开裂的桥架进行维修，举一反三排查', '人力资源科', '罗旭东', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('9b26b88d82a19126a2bd6cdceae263aa', '厂区', '2019-06-17', '车身东侧热泵房大门未进行锁闭，可从外部打开', '/3f6b363716bb485ebaa5ac716cd00a41', '管理执行类', '管理缺失', '其他', 'C', '对大门进行锁闭管理', '维修车间', '王钦光', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('9c535a8a97b9e31092fa1beec28cb61e', '总装车间', '2019-06-14', '正菱员工李硕在过斑马线时未按照要求执行3210，询问3210要求也回答不上来', '/8d0c2af9ed89457ea0d6c28ce5b47f51', '不安全行为类', '不安全行为', '不执行3210', 'B', '责任区域做好相关方的培训及管理', '采购及供应链管理科', '李琦嵘', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('a19df51294f90e28edd4cd78d7deaa51', '车身车间', '2019-06-15', '车身新能源项目叉车进行吊装作业时，不用单叉作业（货物重量过重容易侧翻）', '/a4dcf2c8fcd541739ce8929bcb0ec3fc', '不安全行为类', '不安全行为', '其他', 'C', '叉车作业严禁单叉作业，加强施工人员培训', '车身车间', '张建刚', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('a4b05029ccc8c16eb3d1cc08d6fb8a72', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/d82b34aff16e49179698f46e2fcb66c6', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '公司级', '是', '3/4', '/6a70a8d44cf04cdba16b30ff26f5e614', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '0');
INSERT INTO `safe_problem` VALUES ('a5101f0003d82d3c6921d7f152f09ee3', '车身车间', '2019-06-15', '车身新能源项目叉车进行吊装作业时，不用单叉作业（货物重量过重容易侧翻）', '/756c5983c4644227ae3ce52ff624147d', '不安全行为类', '不安全行为', '其他', 'C', '叉车作业严禁单叉作业，加强施工人员培训', '车身车间', '张建刚', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('b0431a8d4b8dd6e6f2ae4acaa6c72abf', '发动机工厂', '2019-06-18', '缸盖工段A班次1班组孙巨龙SOT记录表未做周总结，主管未签字确认', '/3048213c9f6649a58d3bbe815da6e169', '管理执行类', '管理缺失', '其他', 'C', '按照SOT记录表要求回顾总结，主管领导按时确认', '发动机工厂', '许可会', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('b860a98c46b31c82781a16aad6d7ef99', '总装车间', '2019-06-14', '正菱员工李硕在过斑马线时未按照要求执行3210，询问3210要求也回答不上来', '/5a4a80e4fdec44c896465ded1a51234b', '不安全行为类', '不安全行为', '不执行3210', 'B', '责任区域做好相关方的培训及管理', '采购及供应链管理科', '李琦嵘', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('ba0a520e665d6930ea6a0bcccd3285d6', '车身车间', '2019-06-16', '车身门厅改造现场使用两芯线，接地线未连接。请停用设备。', '/b119121b618346f78c8482308380a305', '管理执行类', '用电安全', '电气设备接线损坏或松脱', 'C', '停用设备，非I.II类电动工具应使用三芯线', '车身车间', '张建刚', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('bdf6542c1a686b1490755437ebb4416a', '厂区', '2019-06-16', '发动机工厂东侧绿化带内有无水乙醇空瓶。', '/4210cb9b217e4a53a013a32695ca4338', '静态隐患类', '化学品安全', '其他', 'C', '化学品容器废物应做危险废物处理，不得随意丢弃', '各区域', '各区域经理', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('c213a24a9533aadb04c6dd188147e191', '餐厅', '2019-06-14', '行政楼餐厅垃圾桶阻挡电器开关，垃圾桶也没有定制', '/3b7eca34bf5e4bd998a5ea3ca47f0962', '静态隐患类', '用电安全', '其他', 'C', '将垃圾桶重新放置位置并增加定制', '人力资源科', '罗旭东', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('c31b926854e6866a359eef35bac45acb', '发动机工厂', '2019-06-19', '一期装配打印发动机号处小储油罐未设置防泄漏托盘，润滑油有很多滴落地面，易滑倒作业人员', '/cf0d1f01f8ab40bebf6ad9a119e89b73', '静态隐患类', '化学品安全', '其他', 'C', '设置防泄漏托盘', '发动机工厂', '许可会', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('c35a383f3777206ddaf18b36abfd825c', '车身车间', '2019-06-17', '车身车间BD-DRP-005、BD-105两处灭火器6月份未开展点检，且一处灭火器已过期', '/a7d352d2e9bf4df4abe644c966f7404a', '管理执行类', '消防安全', '灭火器未点检，周围放杂物', 'C', '对灭火器开展6月份点检，更换过期灭火器', '车身车间', '张建刚', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('c3b2ad746f616aa3b0207e53254c6ad0', '车身车间', '2019-06-17', '车身车间东四门垃圾存放区A类垃圾区中存放废弃油手套及轴承零件', '/bf254bbf00b847e7a33de0aff1b90e7e', '管理执行类', '环境保护', '未按规定进行垃圾分类', 'C', '对废弃垃圾进行分类存放', '车身车间', '张建刚', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('c3fc90e0a35d0cd3bd25dd227e1aec0a', 'B线污水处理站', '2019-06-18', '涂装B线污水处理站化学品浓硫酸间TPM检查表班长未及时签名', '/073ae5fa5cc24ebda0b1b4ce49efe529', '静态隐患类', '目视化信息', '现场目视化信息未及时更新', 'C', '相关方班长按要求进行检查，确保化学品有效管理', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('c66cbcba00adcc8809008c277773c100', '冲压车间', '2019-06-17', '冲压修模区电缆桥架开焊', '/9472a4a471c54879b376865e3d4c3959', '静态隐患类', '用电安全', '电气设备接线损坏或松脱', 'C', '对开焊点进行维修，举一反三排查', '冲压车间', '叶迎江', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('d026909a548a6db4156f81fe43b1032a', '车身车间', '2019-06-17', '车身车间东四门垃圾存放区A类垃圾区中存放废弃油手套及轴承零件', '/3c8dc1358b4e4866b56c8c3a2386ce96', '管理执行类', '环境保护', '未按规定进行垃圾分类', 'C', '对废弃垃圾进行分类存放', '车身车间', '张建刚', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('d35a06c873a54c602e0e5055d4afd123', '涂装车间', '2019-06-18', '涂装车间武汉爱普洗地车充电计时器显示充电2小时，充电记录表登记时间为15:50分，两者时间不一致', '/07262f5e83a948f1bb3ec1145d375d7f', '管理执行类', '管理缺失', '未执行TPM或不按规定执行', 'C', '培训相关方用电要求，严格执行用电安全操作，区域增加巡查', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('d5721be053da38eb0d2a3c114c1c7491', '厂区', '2019-06-14', '总装至RDC的门岗附近掉落零件存在隐患，过往的司机视而不见', '/fd77eee276814e5fbbb35d42baf5692a', '静态隐患类', '管理缺失', '其他', 'C', '责任区域传达相关的问题', '采购及供应链管理科', '李琦嵘', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('d69c245d7fb225994ec90e91efe6998a', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/1f87d46644bb4025a3881b5056fb67b0', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '班组级', '是', '3/4', '/d60038da03c54e8ea733e193daed0bd8', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '0');
INSERT INTO `safe_problem` VALUES ('d6f2c08a162a660439e462f846edf16c', '厂区', '2019-06-17', '车身东侧热泵房大门未进行锁闭，可从外部打开', '/aff5189e71df460d94101881dfeed9d1', '管理执行类', '管理缺失', '其他', 'C', '对大门进行锁闭管理', '维修车间', '王钦光', '2019-06-18', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('d90e53aa9aebc695bfba2446c9615161', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/ca632180d44e44e082368c7e7f6351a1', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/e7c943a34ef04b229057f30aeb08a055', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '1');
INSERT INTO `safe_problem` VALUES ('dcd91a03d0058831ebced2aa761a506a', '行政楼餐厅', '2019-06-17', '行政楼餐厅配菜间电缆桥架开裂', '/ed124d4810564ce1a132ce09ff36eb06', '静态隐患类', '用电安全', '电气设备接线损坏或松脱', 'C', '对开裂的桥架进行维修，举一反三排查', '人力资源科', '罗旭东', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('dd44e5f7b1a0a3f7ec6e5d3d99bc7087', '厂区', '2019-06-15', '车身东侧DOCK区铺设沥青时主干道石块掉落，影响物流车通行', '/108685230b8346a598150f52dfed693d', '静态隐患类', '管理缺失', '其他', 'C', '及时清理', '采购及供应链管理科', '李琦嵘', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('df3a12c5b1744410ac227fd5e2111fe4', '冲压车间', '2019-06-17', '冲压废料间灭火器上存放杂物', '/6a36b665a5cb4b3aa8330e46b97a32fb', '管理执行类', '消防安全', '其他', 'C', '灭火器上禁止存放杂物，区域做好管理', '冲压车间', '叶迎江', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('df3a398050fb75c681bdcc58b12eb99f', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/8ab54f7871784245bee938f57e9b92af', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/6a5df7547e804f73b77f5f7069ad678b', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '1');
INSERT INTO `safe_problem` VALUES ('df96a4c6f91902d650651ed69ab7716f', '总装车间', '2019-06-20', 'A线内饰一工段一处危险隔离区域多名授权进入人员培训考试非本人作答', '/13b0cb3291af4244a071ba538818860e', '管理执行类', '危险隔离区', '其他', 'C', '严格执行危险隔离区域授权进入人员培训考试制度，严禁替考', '总装车间', '王洪磊', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('e6922a1b6a3be51a8249bae4839c7afb', '涂装车间', '2019-06-18', '涂装车间TB-029号灭火器检查表一灭火器有效期过期，更换灭火器后未及时更改检查表有效期', '/9f38337028aa4ebfbfafe8fb1e53df4f', '管理执行类', '消防安全', '灭火器未点检，周围放杂物', 'C', '区域班长按要求按时进行点检确认', '涂装车间', '朱晓春', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('ebb0fd79b0197a147bfa7aae4e66f2e7', '厂区', '2019-06-16', '发动机工厂东侧绿化带内有无水乙醇空瓶。', '/79bd44bc75f04715907ad23cfdab8d85', '静态隐患类', '化学品安全', '其他', 'C', '化学品容器废物应做危险废物处理，不得随意丢弃', '各区域', '各区域经理', '2019-06-15', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('ec89b44d929831e6e3d5e7157fead33a', '车身维修', '2019-06-18', '车身维修班长（田玉普）没有按照班组长每日安全巡视过程记录表进行每日的安全巡视', '/106c7576840a4d07af6b3ba96cfe4296', '管理执行类', '管理缺失', '其他', 'C', '班组长应按照班组长每日安全巡视过程记录表进行每日的安全巡视，并将发现问题记录在表单中', '维修车间', '王钦光', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('f06ec55339a742f0957f591fb0453b3e', '冲压车间', '2019-06-15', '冲压维修临时用电架空高度不足2.5米', '/a98b26c4d79d47cb91ec22527b5f7171', '管理执行类', '用电安全', '其他', 'C', '临时用电室内架空高度不得低于2.5米', '维修车间', '王钦光', '2019-06-15', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('f1a14f2b5e01e3f6612f30555bd187cc', '发动机工厂', '2019-06-18', '爱普2号扫地车6月13日充电记录出现在两个表格中，且记录的状态不一致', '/2bc55cff3b0942adb736e4fa6879604f', '管理执行类', '消防安全', '其他', 'C', '按照要求如实记录充电作业时间', '发动机工厂', '许可会', '2019-06-19', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('f2e4a82659c711990b7251ae12ad917d', '厂区', '2019-04-09', '鲁B6J8P7（涂装车间青岛奥普达公司）车辆驾驶员，在沿主干道行驶时，驾驶车辆使用手机。', '/1e1154a52ed14377887bb0327eff71ab', '静态隐患类', '化学品安全', '区域未张贴SUI和MSDS', 'B', '取消进厂资格', '涂装车间', '朱晓春', '2019-04-10', '工段级', '是', '4/4', '/750a499e285543169b9e7699ef58f697', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '1');
INSERT INTO `safe_problem` VALUES ('f4315c704f464c0c07354ab64c90d6e3', '轮胎区', '2019-06-17', '轮胎区能量锁定流程不全', '/541fad59a7064efa9057a8e66199e139', '管理执行类', '能量锁定', '其他', 'C', '补齐能量锁定步骤', '采购及供应链管理科', '李琦嵘', '2019-06-18', '公司级', '', '', null, '2019-06-25 20:38:49', '5146875475230e023df6a5907b21b2a6', null);
INSERT INTO `safe_problem` VALUES ('fa8266bb693a0b364538d8def94931bf', '总装车间', '2019-06-20', '总装车间东侧男厕所内发现违章吸烟的现象', '/4b1557d062ae45de83d23465ab23d10b', '管理执行类', '消防安全', '其他', 'C', '对区域内员工进行重复培训，并对违章人员进行处罚', '各相关区域', '各相关区域经理', '2019-06-19', '公司级', '', '', null, '2019-06-25 16:00:38', 'a96b63769a1b55e48c57250b557249e5', null);
INSERT INTO `safe_problem` VALUES ('fe4417d3c1e76e961dae75e5f73d4c7f', '总装车间', '2019-04-10', '总装上实员工华雷，穿行通道检查物料状态时不执行3210，并存在斜插道路现象。', '/ed0354763b7642b39f7df36c79e429ce', '不安全行为类', '消防安全', '物流车辆点检不全', 'A', '重新培训员工3210相关知识，员工穿行区域进行规划，增加人行道和3210标识。', '采购及供应链管理科', '李琦嵘', '2019-04-10', '工段级', '是', '3/4', '/794843e58fae456192d60c482bf2302f', '2019-06-25 16:02:54', '5ad77d8a34f23944471327b2ce88da7e', '0');

-- ----------------------------
-- Table structure for second_category
-- ----------------------------
DROP TABLE IF EXISTS `second_category`;
CREATE TABLE `second_category` (
  `second_category_id` char(32) NOT NULL,
  `second_category_name` varchar(255) NOT NULL,
  `category_id` char(32) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`second_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_category
-- ----------------------------
INSERT INTO `second_category` VALUES ('26899f2e32abd93a05f88c8ec1775ff9', '哈哈2', 'e05804b745ae6aa1e2f2f1202268d81d', '2019-06-24');
INSERT INTO `second_category` VALUES ('f7ac81bb1dd65e93985d39e0b2e80c83', 'lalal', '26663fcb42dd847efa6c6736ccf3174d', '2019-06-12');
INSERT INTO `second_category` VALUES ('a7ac2f92965953d96abe86904b5522dc', '啊啊啊', 'e7b7b940a832fee6a4b179491131b2fb', '2019-06-13');

-- ----------------------------
-- Table structure for state_judgement
-- ----------------------------
DROP TABLE IF EXISTS `state_judgement`;
CREATE TABLE `state_judgement` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
CREATE TABLE `subdivision_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pc_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(50) NOT NULL,
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `superior_id` varchar(50) DEFAULT NULL,
  `review_state` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  `detail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0776db34710758bf930801507b93ad3d', '555', '555', '555', '8faa3fc1528cac842cb67f11ea0a7875', '已审核', '2019-06-24 14:59:35', '2019-06-25 16:53:59', '工段长', 'abc');
INSERT INTO `user` VALUES ('0cbaa41a58bc8e44dcbde11b8315a304', '777', '777', '666', 'admin', '已注销', '2019-06-25 10:51:31', '2019-06-25 16:54:19', '工段长', 'a6');
INSERT INTO `user` VALUES ('4a8d2565bc0b447fd9771cf8cf628864', '444', '444', '444', 'admin', '已注销', '2019-06-24 11:03:43', '2019-06-24 11:04:33', '班组长', 'A');
INSERT INTO `user` VALUES ('5fc9d6d781ec0d888896646e81a4a434', 'ddd', 'ddd', 'ddd', '8faa3fc1528cac842cb67f11ea0a7875', '已注销', '2019-06-25 09:10:27', '2019-06-25 18:57:12', '工段长', 'A工段');
INSERT INTO `user` VALUES ('6541708a46f36e6f38925db73bc649dd', '666', '666', '666', '8faa3fc1528cac842cb67f11ea0a7875', '已审核', '2019-06-24 17:03:25', '2019-06-24 17:11:36', '班组长', '11');
INSERT INTO `user` VALUES ('6d26318ba81661bf145d16f86f9026da', '999', '999', '999', '8faa3fc1528cac842cb67f11ea0a7875', '已注销', '2019-06-25 16:53:33', '2019-06-25 20:35:32', '工段长', '9');
INSERT INTO `user` VALUES ('755113079b254ebb2e956a9edb8e8d15', '888', '888', '888', '0776db34710758bf930801507b93ad3d', '已审核', '2019-06-25 10:57:21', '2019-06-25 10:57:21', '班组长', 'a8');
INSERT INTO `user` VALUES ('8faa3fc1528cac842cb67f11ea0a7875', '111', '111', '111', '', '已审核', '2019-05-31 08:17:14', '2019-06-25 20:43:08', '车间长', 'e2');
INSERT INTO `user` VALUES ('admin', 'admin', 'admin', 'admin', '', '已审核', '2019-05-24 21:26:38', '2019-05-24 21:35:10', '管理员', '管理员');
INSERT INTO `user` VALUES ('audit', 'audit', 'audit', 'audit', '', '已审核', '2019-05-24 21:21:04', '2019-05-31 08:33:47', null, null);
INSERT INTO `user` VALUES ('c9f08142dbf3ec312dbdf778edaed5b0', '444', '444', '444', '8faa3fc1528cac842cb67f11ea0a7875', '已审核', '2019-06-25 17:11:30', '2019-06-25 17:11:30', '工段长', '444');
