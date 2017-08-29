/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : sblog

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-08-25 16:33:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bg_article
-- ----------------------------
DROP TABLE IF EXISTS `bg_article`;
CREATE TABLE `bg_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) NOT NULL,
  `content` text,
  `category_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `visit_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `shared_count` int(11) DEFAULT NULL,
  `stared_count` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  `last_modify_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bg_article_user` (`user_id`),
  KEY `bg_article_category` (`category_id`),
  CONSTRAINT `bg_article_category` FOREIGN KEY (`category_id`) REFERENCES `bg_category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_article_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_article
-- ----------------------------
INSERT INTO `bg_article` VALUES ('2', '第一篇博客', '这是关于鬼吹灯--黄皮子坟的估值', '1', '6', null, null, null, null, null, null, null);
INSERT INTO `bg_article` VALUES ('3', '鬼吹灯之精绝古城', '精绝古城是鬼吹灯里最有名的一部。讲述了胡八一一行寻找大漠里精绝古城的故事', '1', '6', null, null, null, null, null, null, null);
INSERT INTO `bg_article` VALUES ('4', '测试', '测试文章', '1', '6', null, null, null, null, null, null, null);
INSERT INTO `bg_article` VALUES ('14', '鬼吹灯', '鬼吹灯很好看， 真的很好看！', '1', '6', null, null, null, null, 'publish', '2017-08-21 17:54:26', '2017-08-21 17:54:26');
INSERT INTO `bg_article` VALUES ('15', '发福图', '<img src=\"/upload/71e03e8d2069fc340be24673a5d8a632.jpg\" alt=\"\" />', '1', '6', null, null, null, null, 'publish', '2017-08-22 14:49:04', '2017-08-22 14:49:04');
INSERT INTO `bg_article` VALUES ('16', '上传一个文件试试', '<a href=\"/upload/RUNNING.txt\">点击打开链接</a>', '1', '6', null, null, null, null, 'publish', '2017-08-22 15:40:42', '2017-08-22 15:40:42');
INSERT INTO `bg_article` VALUES ('17', '哈哈哈', '哈哈哈哈哈哈或或或或或或', '1', '6', null, null, null, null, 'publish', '2017-08-22 16:23:06', '2017-08-22 16:23:06');
INSERT INTO `bg_article` VALUES ('18', '蓝色恋人', '恋人是一部非常美丽的爱情故事。然而，美好的东西总是不会轻易得来。', '2', '6', '5', '6', null, null, 'publish', '2017-08-22 18:02:53', '2017-08-22 18:02:53');
INSERT INTO `bg_article` VALUES ('19', '玄幻小说哎', '<p>真不错</p><p><img src=\"/upload/505647.png\" alt=\"\" /><br /></p>', '1', '6', null, null, null, null, 'publish', '2017-08-24 20:34:31', '2017-08-24 20:34:31');
INSERT INTO `bg_article` VALUES ('20', 'sdfsdfsdfdsdfsdfd', 'sdfsdfsdfsdfsdfsdfsd', '1', '6', null, null, null, null, 'draft', '2017-08-25 14:41:24', '2017-08-25 14:41:24');
INSERT INTO `bg_article` VALUES ('21', '黄皮子坟更新的好慢啊', '期待今天更新大结局！', '1', '6', null, null, null, null, 'publish', '2017-08-25 14:55:01', '2017-08-25 14:55:01');
INSERT INTO `bg_article` VALUES ('22', '鬼吹灯之盗墓迷城-1', '哇咔咔咔，好期待啊！', '2', '6', null, null, null, null, 'publish', '2017-08-25 14:56:08', '2017-08-25 14:56:08');
INSERT INTO `bg_article` VALUES ('23', 'sssssssssss', '<p><img src=\"/upload/505647.png\" alt=\"\" /></p><p><br /></p><p>oops!</p>', '1', '6', null, null, null, null, 'publish', '2017-08-25 15:46:08', '2017-08-25 15:46:09');
INSERT INTO `bg_article` VALUES ('24', 'testtest', '<p><img src=\"/upload/71e03e8d2069fc340be24673a5d8a632.jpg\" alt=\"\" /></p><p><br /></p><p>sdfsdfsdf</p><p><br /></p><p>s</p><p>dfsdfsdsdfsd</p>', '1', '6', null, null, null, null, 'publish', '2017-08-25 16:22:06', '2017-08-25 16:31:53');
INSERT INTO `bg_article` VALUES ('25', '搞篇技术的文章', '<p>哈哈哈哈哈哈, 很好玩！！！！</p><p><img src=\"/upload/71e03e8d2069fc340be24673a5d8a632.jpg\" alt=\"\" /><br /></p>', '1', '6', null, null, null, null, 'publish', '2017-08-25 15:49:27', '2017-08-25 15:49:27');

-- ----------------------------
-- Table structure for bg_category
-- ----------------------------
DROP TABLE IF EXISTS `bg_category`;
CREATE TABLE `bg_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `visiable` tinyint(4) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bg_category_user` (`user_id`),
  CONSTRAINT `bg_category_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_category
-- ----------------------------
INSERT INTO `bg_category` VALUES ('1', '玄幻故事', '玄幻故事小说', '1', '6', '2017-08-21 12:50:31');
INSERT INTO `bg_category` VALUES ('2', '爱情故事', '爱情故事大全', '1', '6', '2017-08-22 16:24:05');
INSERT INTO `bg_category` VALUES ('3', '技术文章', '各种技术', '1', '6', '2017-08-25 15:15:22');

-- ----------------------------
-- Table structure for bg_comment
-- ----------------------------
DROP TABLE IF EXISTS `bg_comment`;
CREATE TABLE `bg_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `article_id` int(11) NOT NULL,
  `reply_comment_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  `last_modify_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bg_comment_article` (`article_id`),
  KEY `bg_comment_user` (`user_id`),
  CONSTRAINT `bg_comment_article` FOREIGN KEY (`article_id`) REFERENCES `bg_article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_comment_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_comment
-- ----------------------------

-- ----------------------------
-- Table structure for bg_follow
-- ----------------------------
DROP TABLE IF EXISTS `bg_follow`;
CREATE TABLE `bg_follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_follow
-- ----------------------------

-- ----------------------------
-- Table structure for bg_picture
-- ----------------------------
DROP TABLE IF EXISTS `bg_picture`;
CREATE TABLE `bg_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture` mediumblob,
  `thumbnail` mediumblob,
  `mime_type` varchar(20) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `file_url` varchar(300) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`) USING HASH,
  KEY `bg_picture_user` (`user_id`),
  CONSTRAINT `bg_picture_article` FOREIGN KEY (`article_id`) REFERENCES `bg_article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_picture_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_picture
-- ----------------------------

-- ----------------------------
-- Table structure for bg_stared_article
-- ----------------------------
DROP TABLE IF EXISTS `bg_stared_article`;
CREATE TABLE `bg_stared_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING HASH,
  KEY `article_id` (`article_id`) USING HASH,
  CONSTRAINT `bg_stared_article_article` FOREIGN KEY (`article_id`) REFERENCES `bg_article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_stared_article_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_stared_article
-- ----------------------------

-- ----------------------------
-- Table structure for bg_user
-- ----------------------------
DROP TABLE IF EXISTS `bg_user`;
CREATE TABLE `bg_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `display_name` varchar(100) DEFAULT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `qq` varchar(30) DEFAULT NULL,
  `wechat` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `photo` mediumblob,
  `gender` tinyint(4) DEFAULT '1' COMMENT 'Male',
  `marriage` tinyint(4) DEFAULT '1' COMMENT 'Single',
  `job` varchar(100) DEFAULT NULL,
  `employer` varchar(100) DEFAULT NULL,
  `job_status` tinyint(4) DEFAULT '1' COMMENT 'Working',
  `hobby` varchar(200) DEFAULT NULL,
  `target` varchar(100) DEFAULT NULL,
  `motto` varchar(100) DEFAULT NULL,
  `self_intr` varchar(255) DEFAULT NULL,
  `ext_id` varchar(50) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL,
  `inform_type` tinyint(4) DEFAULT '1' COMMENT 'email',
  `status` varchar(20) DEFAULT NULL,
  `blog_title` varchar(100) DEFAULT NULL,
  `blog_subtitle` varchar(200) DEFAULT NULL,
  `blog_theme` varchar(100) DEFAULT NULL,
  `last_logon_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_at` timestamp NULL DEFAULT NULL,
  `last_modify_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_user
-- ----------------------------
INSERT INTO `bg_user` VALUES ('6', 'jan', 'jan1234', null, null, null, null, null, null, null, '1', '1', null, null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, null);
INSERT INTO `bg_user` VALUES ('7', 'ian', 'ian1234', null, null, 'ian.zheng@sap.com', null, null, null, null, '1', '1', null, null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, null);
INSERT INTO `bg_user` VALUES ('8', 'test', 'test1234', null, null, 'test@sap.com', null, null, null, null, '1', '1', null, null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, null);
