/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : sblog

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-08-15 16:51:39
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
  `status` varchar(10) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modify_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `bg_article_user` (`user_id`),
  KEY `bg_article_category` (`category_id`),
  CONSTRAINT `bg_article_category` FOREIGN KEY (`category_id`) REFERENCES `bg_category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_article_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `bg_category_user` (`user_id`),
  CONSTRAINT `bg_category_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modify_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `bg_comment_article` (`article_id`),
  KEY `bg_comment_user` (`user_id`),
  CONSTRAINT `bg_comment_article` FOREIGN KEY (`article_id`) REFERENCES `bg_article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_comment_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bg_follow
-- ----------------------------
DROP TABLE IF EXISTS `bg_follow`;
CREATE TABLE `bg_follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`) USING HASH,
  KEY `bg_picture_user` (`user_id`),
  CONSTRAINT `bg_picture_article` FOREIGN KEY (`article_id`) REFERENCES `bg_article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_picture_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bg_stared_article
-- ----------------------------
DROP TABLE IF EXISTS `bg_stared_article`;
CREATE TABLE `bg_stared_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING HASH,
  KEY `article_id` (`article_id`) USING HASH,
  CONSTRAINT `bg_stared_article_article` FOREIGN KEY (`article_id`) REFERENCES `bg_article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bg_stared_article_user` FOREIGN KEY (`user_id`) REFERENCES `bg_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bg_user
-- ----------------------------
DROP TABLE IF EXISTS `bg_user`;
CREATE TABLE `bg_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
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
  `create_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_modify_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
