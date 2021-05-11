/*
 Navicat Premium Data Transfer

 Source Server         : 123.57.68.158
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 123.57.68.158:3306
 Source Schema         : serve

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 14/03/2021 13:15:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for service_community
-- ----------------------------
DROP TABLE IF EXISTS `service_community`;
CREATE TABLE `service_community`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `service_type` int(11) NULL DEFAULT NULL COMMENT '服务类型',
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题',
  `context` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态。1：未回复 2：已回复',
  `apply_man` int(11) NULL DEFAULT NULL COMMENT '申请人',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `reply_man` int(11) NULL DEFAULT NULL COMMENT '回复人',
  `reply_time` datetime NULL DEFAULT NULL COMMENT '回复时间',
  `reply_context` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_community
-- ----------------------------
INSERT INTO `service_community` VALUES (1, 0, NULL, NULL, NULL, 'APPLY', 4, '2021-03-12 22:36:33', 0, NULL, NULL);
INSERT INTO `service_community` VALUES (2, 0, NULL, NULL, NULL, 'APPLY', 4, '2021-03-12 22:38:23', 1, '2021-03-12 22:47:42', 'comment');
INSERT INTO `service_community` VALUES (3, 0, NULL, NULL, NULL, 'APPLY', 4, '2021-03-12 22:38:51', 0, NULL, NULL);
INSERT INTO `service_community` VALUES (4, 0, NULL, NULL, NULL, 'APPLY', 4, '2021-03-12 22:38:59', 0, NULL, NULL);
INSERT INTO `service_community` VALUES (5, 0, NULL, NULL, NULL, 'APPLY', 4, '2021-03-12 22:39:46', 0, NULL, NULL);
INSERT INTO `service_community` VALUES (6, 0, 'com1', 'com123', NULL, 'REPLY', 4, '2021-03-12 22:45:58', 8, '2021-03-14 10:21:52', 'comment');
INSERT INTO `service_community` VALUES (7, 0, '12321', '23213', NULL, 'REPLY', 8, '2021-03-13 17:32:33', 8, '2021-03-14 11:15:45', '22');
INSERT INTO `service_community` VALUES (8, 0, '1111', '1111', NULL, 'REPLY', 7, '2021-03-13 23:18:16', 8, '2021-03-14 11:21:09', '123');

-- ----------------------------
-- Table structure for service_family
-- ----------------------------
DROP TABLE IF EXISTS `service_family`;
CREATE TABLE `service_family`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `service_type` int(11) NULL DEFAULT NULL COMMENT '服务类型',
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题',
  `context` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态。1：已申请 2：待维修 3：已维修',
  `apply_man` int(11) NULL DEFAULT NULL COMMENT '申请人',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `accept_man` int(11) NULL DEFAULT NULL COMMENT '受理人',
  `accept_time` datetime NULL DEFAULT NULL COMMENT '受理时间',
  `repair_man` int(11) NULL DEFAULT NULL COMMENT '维修人',
  `repair_time` datetime NULL DEFAULT NULL COMMENT '维修时间',
  `comment` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价',
  `comment_time` datetime NULL DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_family
-- ----------------------------
INSERT INTO `service_family` VALUES (1, 1, '家庭水管', '家庭水管破裂。紧急！', 'C:/files/d1c383f8-8505-4d3b-b9a6-655559ccfdf7_v2-bf35e1b22266c687b07731fc3f4304e2_r.jpg', 'RECEIVE', 1, '2020-11-29 00:22:08', 1, '2020-12-02 22:55:10', 3, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (2, 1, '家庭水管', '我家庭水管破裂', 'C:/files/d51d5bdf-ba93-4f6f-8970-8cb0c049e308_v2-bf35e1b22266c687b07731fc3f4304e2_r.jpg', 'REPAIR', 1, '2020-11-29 15:48:25', 1, '2021-03-12 22:17:25', 2, '2021-03-12 22:23:04', '123', '2021-03-13 20:24:20');
INSERT INTO `service_family` VALUES (3, 2, '玻璃问题', '玻璃碎了', 'C:/files/6a23674d-e9ba-4551-ad9d-ef7996d9207d_v2-bf35e1b22266c687b07731fc3f4304e2_r.jpg', 'RECEIVE', 1, '2020-11-29 18:48:23', 1, '2020-12-02 23:00:42', 2, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (4, 0, 'string', 'string', NULL, 'APPLY', 4, '2021-03-12 22:34:37', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (5, 0, '123', '123', NULL, 'APPLY', 7, '2021-03-13 15:15:08', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (6, 0, '321', '1111', NULL, 'APPLY', 7, '2021-03-13 16:09:45', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (7, 0, '测试', '2222', NULL, 'APPLY', 7, '2021-03-13 16:10:05', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (8, 0, '窗户维修', '维护', NULL, 'REPAIR', 7, '2021-03-13 16:13:57', 8, '2021-03-13 23:01:19', 6, '2021-03-13 23:01:36', '1111', '2021-03-13 23:16:57');
INSERT INTO `service_family` VALUES (9, 0, '4444', '4444', NULL, 'APPLY', 6, '2021-03-13 16:19:51', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (10, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:21', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (11, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:22', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (12, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:23', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (13, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:23', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (14, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:24', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (15, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:24', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (16, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:24', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (17, 0, '', '', NULL, 'APPLY', 8, '2021-03-13 16:44:45', 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (18, 0, '21323', '123', NULL, 'REPAIR', 8, '2021-03-13 17:32:27', 8, '2021-03-13 22:11:50', 6, '2021-03-13 22:45:31', NULL, NULL);
INSERT INTO `service_family` VALUES (19, 0, '', '', NULL, 'RECEIVE', 8, '2021-03-13 18:51:52', 8, '2021-03-13 22:09:00', 3, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (20, 0, '123', '3213213', NULL, 'RECEIVE', 8, '2021-03-13 20:12:53', 8, '2021-03-13 22:08:31', 3, NULL, NULL, NULL);
INSERT INTO `service_family` VALUES (21, 0, '1111', '1111', NULL, 'RECEIVE', 8, '2021-03-13 20:13:05', 8, '2021-03-13 22:06:52', 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for service_token
-- ----------------------------
DROP TABLE IF EXISTS `service_token`;
CREATE TABLE `service_token`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'token',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_token
-- ----------------------------
INSERT INTO `service_token` VALUES (9, 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTkyMTkxMDMsImFjY291bnQiOiJzdW4ifQ.HKI8curTjwgLtm6_o0daGoFLGNXlEfL-w0Yl8GLZGn2hdVtVg1KaEtFE6FBf63BUR5ijwPl2ePewtTjE01FKIw', 1);
INSERT INTO `service_token` VALUES (10, 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTkyOTU5ODksImFjY291bnQiOiIyMjIyMjIifQ.ognHc0o4KcMIP-0UayRPdcrSoaVMEyn-4mzDYg1F-rCOJKwIuY4KyjdFRT1C23vklRBS3nMbQQHyNFMO1DvDAA', 7);
INSERT INTO `service_token` VALUES (11, 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTkyOTYwMjAsImFjY291bnQiOiIxMTExMTEifQ.PtDz4jAL7rqr0PJOvV-iG7xe-vozDfTw7_BwyOWWNLWkpb684fTN3HZiiZ3vGmks1bzfcWH8ed6-dr731rb5Lg', 6);
INSERT INTO `service_token` VALUES (12, 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTkyOTc3NzAsImFjY291bnQiOiIzMzMzMzMifQ.HBiSwpzExJd665DB9ZLFZfHfo_lEPw_LYITQiTRIjalukubg2R3yPPFTl0rno4hv8KJM2l9VgFbDTxLP5r8mgg', 8);

-- ----------------------------
-- Table structure for service_type
-- ----------------------------
DROP TABLE IF EXISTS `service_type`;
CREATE TABLE `service_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型。family：家庭服务 community：社区服务',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_type
-- ----------------------------
INSERT INTO `service_type` VALUES (1, 'family', '水管');
INSERT INTO `service_type` VALUES (2, 'family', '玻璃');
INSERT INTO `service_type` VALUES (3, 'family', '电路');
INSERT INTO `service_type` VALUES (4, 'community', '设施损坏');
INSERT INTO `service_type` VALUES (5, 'community', '设施占用');
INSERT INTO `service_type` VALUES (6, 'community', '活动举办');
INSERT INTO `service_type` VALUES (7, 'family', '暖气');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号类型。1：小程序登录 2：账号密码登录',
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色。1：业主 2：管理 3：维修人员',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `id_card` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `building` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼号',
  `part` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元',
  `room` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房号',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1, '2', 'sun', 'aaafff', '2', '孙', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_user` VALUES (2, '1', 'wang', 'aaafff', '3', '王师傅', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_user` VALUES (3, '1', 'li', 'aaafff', '3', '李师傅', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_user` VALUES (4, NULL, 'a1', 'p1', '1', 'n1', 'id1', '男', 'b1', 'p1', 'r1', 'p1');
INSERT INTO `system_user` VALUES (5, NULL, '123456', '123456', '2', '1111', '1111', '男', '', '', '', '1111');
INSERT INTO `system_user` VALUES (6, NULL, '111111', '111111', '3', '2323', '3232323', '女', '', '', '', '2323232');
INSERT INTO `system_user` VALUES (7, NULL, '222222', '222222', '1', '222', '222', '男', '11', '11', '11', '222');
INSERT INTO `system_user` VALUES (8, NULL, '333333', '333333', '2', '333333', '333', '男', '', '', '', '3333');

SET FOREIGN_KEY_CHECKS = 1;
