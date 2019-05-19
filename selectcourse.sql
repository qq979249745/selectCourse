/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : 127.0.0.1:3306
 Source Schema         : selectcourse

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 14/05/2019 22:18:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_college
-- ----------------------------
DROP TABLE IF EXISTS `tb_college`;
CREATE TABLE `tb_college`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  `manager` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理者',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院地址',
  `degree_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学位名称',
  `score` int(11) NOT NULL COMMENT '学位总学分',
  `study_time` int(11) NOT NULL COMMENT '学位总学时',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_college
-- ----------------------------
INSERT INTO `tb_college` VALUES (1, '软件学院', '段老师', '南昌航空大学', '软件工程', 30, 100);
INSERT INTO `tb_college` VALUES (3, '软件学院', '段老师', '昌南航天航空大学', '软件工程', 30, 100);
INSERT INTO `tb_college` VALUES (4, '信工学院', '段老师', '昌南航天航空大学', '信息工程', 22, 100);
INSERT INTO `tb_college` VALUES (6, '音乐学院', '音乐学院管理者', '江西省南昌市新建县丰和南大道696号南昌航空大学', '音乐', 26, 109);

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `course_score` int(11) NOT NULL COMMENT '课程学分',
  `level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程级别',
  `fee` int(11) NOT NULL COMMENT '课程费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (1, 'UML', 3, '必修', 20);
INSERT INTO `tb_course` VALUES (2, '软件工程', 4, '必修', 44);
INSERT INTO `tb_course` VALUES (3, 'Java', 4, '必修', 55);
INSERT INTO `tb_course` VALUES (4, 'Java网络编程', 4, '必修', 43);
INSERT INTO `tb_course` VALUES (5, '专业英语', 4, '必修', 32);
INSERT INTO `tb_course` VALUES (6, '大学语文', 3, '选修', 43);
INSERT INTO `tb_course` VALUES (7, 'C语言', 12, '必修', 32);
INSERT INTO `tb_course` VALUES (8, 'C++', 23, '必修', 41);
INSERT INTO `tb_course` VALUES (9, 'Python', 32, '必修', 15);
INSERT INTO `tb_course` VALUES (10, '数据结构', 13, '必修', 32);
INSERT INTO `tb_course` VALUES (11, '数据库', 14, '必修', 31);

-- ----------------------------
-- Table structure for tb_courseoffering
-- ----------------------------
DROP TABLE IF EXISTS `tb_courseoffering`;
CREATE TABLE `tb_courseoffering`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sem_id` int(11) NOT NULL COMMENT '学年',
  `course_id` int(11) NOT NULL COMMENT '课程编号',
  `professor_id` int(11) NOT NULL COMMENT '教授id',
  `prerequisite` int(11) NULL DEFAULT NULL COMMENT '先决条件课程的id',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '已选课程人数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `frk_c_c`(`course_id`) USING BTREE,
  INDEX `frk_c_p`(`professor_id`) USING BTREE,
  INDEX `frk_c_s`(`sem_id`) USING BTREE,
  CONSTRAINT `frk_c_c` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `frk_c_p` FOREIGN KEY (`professor_id`) REFERENCES `tb_professor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `frk_c_s` FOREIGN KEY (`sem_id`) REFERENCES `tb_sem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_courseoffering
-- ----------------------------
INSERT INTO `tb_courseoffering` VALUES (1, 3, 1, 4, 2, 1);
INSERT INTO `tb_courseoffering` VALUES (2, 3, 6, 4, 5, 2);
INSERT INTO `tb_courseoffering` VALUES (3, 3, 4, 4, NULL, 1);
INSERT INTO `tb_courseoffering` VALUES (4, 3, 2, 4, NULL, 0);
INSERT INTO `tb_courseoffering` VALUES (5, 3, 3, 4, NULL, 1);

-- ----------------------------
-- Table structure for tb_professor
-- ----------------------------
DROP TABLE IF EXISTS `tb_professor`;
CREATE TABLE `tb_professor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教授id',
  `account` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教授账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教授姓名',
  `college_id` int(11) NOT NULL COMMENT '学院id',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `frk_pro_col`(`college_id`) USING BTREE,
  CONSTRAINT `frk_pro_col` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_professor
-- ----------------------------
INSERT INTO `tb_professor` VALUES (1, '1234567', '123456', '教授1', 4, '13345677654');
INSERT INTO `tb_professor` VALUES (2, '12345', '123456', '教授2', 1, '12345678903');
INSERT INTO `tb_professor` VALUES (4, '123456', '123456', '教授2', 6, '12345677654');

-- ----------------------------
-- Table structure for tb_registrar
-- ----------------------------
DROP TABLE IF EXISTS `tb_registrar`;
CREATE TABLE `tb_registrar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_registrar
-- ----------------------------
INSERT INTO `tb_registrar` VALUES (1, 'admin', 'admin', '13812344321');

-- ----------------------------
-- Table structure for tb_sem
-- ----------------------------
DROP TABLE IF EXISTS `tb_sem`;
CREATE TABLE `tb_sem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sem` date NULL DEFAULT NULL COMMENT '学年度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sem
-- ----------------------------
INSERT INTO `tb_sem` VALUES (3, '2019-02-22');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `account` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生密码',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `college_id` int(11) NOT NULL COMMENT '学院id',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `frk_stu_col`(`college_id`) USING BTREE,
  CONSTRAINT `frk_stu_col` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, '123456', '123456', '张三', 1, '地址', '2019-03-19', '13312345678');
INSERT INTO `tb_student` VALUES (2, '12345', '123456', '李四', 6, '丰和南大道696号南昌航空大学', '2018-08-08', '13345677654');

-- ----------------------------
-- Table structure for tb_study
-- ----------------------------
DROP TABLE IF EXISTS `tb_study`;
CREATE TABLE `tb_study`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `sem_id` int(11) NOT NULL COMMENT '学年度id',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未提交' COMMENT '学习计划提交状态',
  `total_fee` int(11) NOT NULL DEFAULT 0 COMMENT '总费用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `frk_s_s`(`stu_id`) USING BTREE,
  INDEX `frk_s_sem`(`sem_id`) USING BTREE,
  CONSTRAINT `frk_s_s` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `frk_s_sem` FOREIGN KEY (`sem_id`) REFERENCES `tb_sem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_study
-- ----------------------------
INSERT INTO `tb_study` VALUES (6, 1, 3, '未提交', 161);
INSERT INTO `tb_study` VALUES (7, 1, 3, '未提交', 43);
INSERT INTO `tb_study` VALUES (8, 1, 3, '未提交', 0);

-- ----------------------------
-- Table structure for tb_studyprogram
-- ----------------------------
DROP TABLE IF EXISTS `tb_studyprogram`;
CREATE TABLE `tb_studyprogram`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `study_id` int(11) NOT NULL COMMENT '学习计划id',
  `courseOffering_id` int(11) NOT NULL COMMENT '课程计划id',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主选或备选',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `frk_sp_co`(`courseOffering_id`) USING BTREE,
  INDEX `frk_sp_st`(`study_id`) USING BTREE,
  CONSTRAINT `frk_sp_co` FOREIGN KEY (`courseOffering_id`) REFERENCES `tb_courseoffering` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `frk_sp_st` FOREIGN KEY (`study_id`) REFERENCES `tb_study` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_studyprogram
-- ----------------------------
INSERT INTO `tb_studyprogram` VALUES (19, 6, 3, '主选');
INSERT INTO `tb_studyprogram` VALUES (20, 6, 2, '主选');
INSERT INTO `tb_studyprogram` VALUES (21, 6, 1, '主选');
INSERT INTO `tb_studyprogram` VALUES (22, 6, 5, '主选');
INSERT INTO `tb_studyprogram` VALUES (25, 7, 2, '主选');

SET FOREIGN_KEY_CHECKS = 1;
