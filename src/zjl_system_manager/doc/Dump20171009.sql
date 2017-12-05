-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: zjl_system_master
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `system_button`
--

DROP TABLE IF EXISTS `system_button`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_button` (
  `id` varchar(36) NOT NULL,
  `button_name` varchar(50) DEFAULT NULL,
  `button_method` varchar(50) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `style` varchar(100) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `modifytime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_button`
--

LOCK TABLES `system_button` WRITE;
/*!40000 ALTER TABLE `system_button` DISABLE KEYS */;
INSERT INTO `system_button` VALUES ('260979b9-92ef-4cb2-8e6f-a5c2eae32d87','删除','Delete ()',' fa fa-times','btn btn-outline btn-default',3,'无','2017-08-14 20:27:50',NULL,'admin'),('6545daf7-6dac-4647-a954-aa380cc4397e','修改','Update()',' fa fa-pencil','btn btn-outline btn-default',2,'无','2017-08-14 20:30:11',NULL,'admin'),('6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','添加','Add()',' fa fa-plus-circle','btn btn-outline btn-default',1,'无','2017-08-14 20:26:35',NULL,'admin'),('a0e96c43-40da-4ab2-aa3e-5986496cfbab','分配菜单','AllocationMenu()',' fa fa-share','btn btn-outline btn-default',4,'无','2017-08-14 20:59:55',NULL,'admin'),('c5170f01-86fa-4cfe-806d-e44e6487cf5e','分配按钮','AllocationButton()',' fa fa-share','btn btn-outline btn-default',5,'无','2017-08-14 21:00:35',NULL,'admin'),('f5eb8db4-63df-45f3-94a1-e69b69f02df4','分配角色','AllocationRole()',' fa fa-share','btn btn-outline btn-default',6,'无','2017-08-17 20:45:04',NULL,'admin');
/*!40000 ALTER TABLE `system_button` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_menu`
--

DROP TABLE IF EXISTS `system_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_menu` (
  `id` varchar(36) NOT NULL,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `parentid` varchar(36) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `levels` int(11) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `modifytime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_menu`
--

LOCK TABLES `system_menu` WRITE;
/*!40000 ALTER TABLE `system_menu` DISABLE KEYS */;
INSERT INTO `system_menu` VALUES ('81c8bc0c-a185-4e79-8a02-21e710caafea','按钮管理','/permissions/systembutton/index.shtml','ab666351-8720-44a7-8b35-4159bba9f162','bars',4,2,'','2017-07-30 20:30:59','2017-07-30 20:30:59','Admin'),('ab666351-8720-44a7-8b35-4159bba9f162','权限管理','#','0','fa-home',1,1,'','2017-07-30 20:11:15','2017-07-30 20:11:15','Admin'),('bd2112aa-4a83-451b-9dd8-11c746221fab','菜单管理','/permissions/systemmenu/index.shtml','ab666351-8720-44a7-8b35-4159bba9f162','fa-home',3,2,'','2017-07-30 20:27:35','2017-07-30 20:27:35','Admin'),('e3d512b1-092a-4700-825b-b3b635abab1e','用户管理','/permissions/systemuser/index.shtml','ab666351-8720-44a7-8b35-4159bba9f162','fa-home',1,2,'','2017-07-30 20:19:43','2017-07-30 20:19:43','Admin'),('e4507f57-2594-4ec5-93a6-793dbb4e4b09','角色管理','/permissions/systemrole/index.shtml','ab666351-8720-44a7-8b35-4159bba9f162','fa-home',2,2,'','2017-07-30 20:22:21','2017-07-30 20:22:21','Admin');
/*!40000 ALTER TABLE `system_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_menu_button`
--

DROP TABLE IF EXISTS `system_menu_button`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_menu_button` (
  `id` varchar(36) NOT NULL,
  `menuid` varchar(36) DEFAULT NULL,
  `buttonid` varchar(36) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_menu_button`
--

LOCK TABLES `system_menu_button` WRITE;
/*!40000 ALTER TABLE `system_menu_button` DISABLE KEYS */;
INSERT INTO `system_menu_button` VALUES ('0919075d-cde9-4b1b-b973-ae51998b0c16','ab666351-8720-44a7-8b35-4159bba9f162','','无⃣️','2017-08-22 20:06:31','admin'),('0b63efb0-155c-4e45-b4da-298a950d0c7a','bd2112aa-4a83-451b-9dd8-11c746221fab','6545daf7-6dac-4647-a954-aa380cc4397e','无⃣️','2017-08-17 20:04:15','admin'),('0f3f835f-047a-4acd-98f5-6e85c951e3ab','e3d512b1-092a-4700-825b-b3b635abab1e','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无⃣️','2017-08-17 20:45:15','admin'),('1adbefa4-d546-46fa-a9b4-2454b821603e','e3d512b1-092a-4700-825b-b3b635abab1e','f5eb8db4-63df-45f3-94a1-e69b69f02df4','无⃣️','2017-08-17 20:45:15','admin'),('1e993070-eb10-4022-b216-ac1be5e8513b','e3d512b1-092a-4700-825b-b3b635abab1e','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无⃣️','2017-08-17 20:45:15','admin'),('2bd90529-8d82-458b-bcc4-82f2dacc2d58','bd2112aa-4a83-451b-9dd8-11c746221fab','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无⃣️','2017-08-17 20:04:15','admin'),('6a409095-88c2-4145-83b0-e38398f93bb5','e4507f57-2594-4ec5-93a6-793dbb4e4b09','6545daf7-6dac-4647-a954-aa380cc4397e','无⃣️','2017-08-17 20:45:55','admin'),('8629406d-e24c-4ae3-8405-c71b479a62ba','bd2112aa-4a83-451b-9dd8-11c746221fab','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无⃣️','2017-08-17 20:04:15','admin'),('88aebbd7-8753-48bc-bbb7-c9cdda7b8d24','81c8bc0c-a185-4e79-8a02-21e710caafea','6545daf7-6dac-4647-a954-aa380cc4397e','无⃣️','2017-08-17 20:03:46','admin'),('8c339580-8da4-4b6b-aaa0-986f8793fd12','81c8bc0c-a185-4e79-8a02-21e710caafea','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无⃣️','2017-08-17 20:03:46','admin'),('b2204625-b161-4a97-b8ac-cc614d190139','e4507f57-2594-4ec5-93a6-793dbb4e4b09','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无⃣️','2017-08-17 20:45:55','admin'),('c722126d-0d55-4d3e-bda4-e3a4482cc3d7','81c8bc0c-a185-4e79-8a02-21e710caafea','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无⃣️','2017-08-17 20:03:46','admin'),('d05dea36-2e30-4016-b301-59510d2d1f7b','e4507f57-2594-4ec5-93a6-793dbb4e4b09','a0e96c43-40da-4ab2-aa3e-5986496cfbab','无⃣️','2017-08-17 20:45:55','admin'),('d07f3c31-3bb1-40f5-b60f-10cfb1cbe05a','bd2112aa-4a83-451b-9dd8-11c746221fab','c5170f01-86fa-4cfe-806d-e44e6487cf5e','无⃣️','2017-08-17 20:04:15','admin'),('eacc1f03-9bcd-45ec-bbd0-91f7dc98a8fc','e3d512b1-092a-4700-825b-b3b635abab1e','6545daf7-6dac-4647-a954-aa380cc4397e','无⃣️','2017-08-17 20:45:15','admin'),('fd98d26e-1da2-4887-bfed-be934360d723','e4507f57-2594-4ec5-93a6-793dbb4e4b09','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无⃣️','2017-08-17 20:45:55','admin');
/*!40000 ALTER TABLE `system_menu_button` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_role`
--

DROP TABLE IF EXISTS `system_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_role` (
  `id` varchar(36) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `role_type` varchar(10) DEFAULT NULL,
  `role_code` varchar(10) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `modifytime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_role`
--

LOCK TABLES `system_role` WRITE;
/*!40000 ALTER TABLE `system_role` DISABLE KEYS */;
INSERT INTO `system_role` VALUES ('0ca70002-2fbb-417c-ab29-b84d1223b9dd','普通管理员','10001','10001',2,'2017-08-23 20:28:10',NULL,'admin'),('ed453cc5-6451-49db-996c-9d02c3607706','超级管理员','10000',NULL,1,'2017-07-30 20:34:31','2017-07-30 20:34:31','Admin');
/*!40000 ALTER TABLE `system_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_role_menu`
--

DROP TABLE IF EXISTS `system_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_role_menu` (
  `id` varchar(36) NOT NULL,
  `roleid` varchar(36) DEFAULT NULL,
  `menuid` varchar(36) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_role_menu`
--

LOCK TABLES `system_role_menu` WRITE;
/*!40000 ALTER TABLE `system_role_menu` DISABLE KEYS */;
INSERT INTO `system_role_menu` VALUES ('073ad053-e858-463f-a3d6-b146e73fa8fe','ed453cc5-6451-49db-996c-9d02c3607706','e3d512b1-092a-4700-825b-b3b635abab1e','无','2017-08-22 21:35:15','admin'),('3e801906-dfb0-4437-b7ad-cf305a1ac4fb','ed453cc5-6451-49db-996c-9d02c3607706','81c8bc0c-a185-4e79-8a02-21e710caafea','无','2017-08-22 21:35:15','admin'),('46d57f0d-8881-4e76-9371-e3bb765a9055','ed453cc5-6451-49db-996c-9d02c3607706','ab666351-8720-44a7-8b35-4159bba9f162','无','2017-08-22 21:35:15','admin'),('4ea35966-5fa9-4ffb-aae8-b40677c6c408','0ca70002-2fbb-417c-ab29-b84d1223b9dd','81c8bc0c-a185-4e79-8a02-21e710caafea','无','2017-08-23 20:45:18','admin'),('61f0ad9c-0394-4c75-9a45-26b8ae0f41ae','ed453cc5-6451-49db-996c-9d02c3607706','e4507f57-2594-4ec5-93a6-793dbb4e4b09','无','2017-08-22 21:35:15','admin'),('721c64b1-5b6c-42db-9bbc-555e32c79433','0ca70002-2fbb-417c-ab29-b84d1223b9dd','ab666351-8720-44a7-8b35-4159bba9f162','无','2017-08-23 20:45:18','admin'),('c904942a-28a9-4f66-8775-5141e75fe86f','ed453cc5-6451-49db-996c-9d02c3607706','bd2112aa-4a83-451b-9dd8-11c746221fab','无','2017-08-22 21:35:15','admin');
/*!40000 ALTER TABLE `system_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_role_menu_button`
--

DROP TABLE IF EXISTS `system_role_menu_button`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_role_menu_button` (
  `id` varchar(36) NOT NULL,
  `roleid` varchar(36) DEFAULT NULL,
  `menuid` varchar(36) DEFAULT NULL,
  `buttonid` varchar(36) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_role_menu_button`
--

LOCK TABLES `system_role_menu_button` WRITE;
/*!40000 ALTER TABLE `system_role_menu_button` DISABLE KEYS */;
INSERT INTO `system_role_menu_button` VALUES ('0aed9d27-a0d5-4ec6-a074-88491e4e0dbb','ed453cc5-6451-49db-996c-9d02c3607706','81c8bc0c-a185-4e79-8a02-21e710caafea','6545daf7-6dac-4647-a954-aa380cc4397e','无','2017-08-22 21:35:15','admin'),('0b74d39c-d063-4bd1-b55d-5a9925b0ac69','ed453cc5-6451-49db-996c-9d02c3607706','81c8bc0c-a185-4e79-8a02-21e710caafea','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无','2017-08-22 21:35:15','admin'),('0c34c223-af51-4fb5-8364-b1c72bb5dea3','ed453cc5-6451-49db-996c-9d02c3607706','e4507f57-2594-4ec5-93a6-793dbb4e4b09','a0e96c43-40da-4ab2-aa3e-5986496cfbab','无','2017-08-22 21:35:15','admin'),('27f73cd3-969a-495d-b03b-cd2fce47452f','ed453cc5-6451-49db-996c-9d02c3607706','bd2112aa-4a83-451b-9dd8-11c746221fab','6545daf7-6dac-4647-a954-aa380cc4397e','无','2017-08-22 21:35:15','admin'),('34c2f8ed-a373-4df0-b6ee-d151f7030796','ed453cc5-6451-49db-996c-9d02c3607706','bd2112aa-4a83-451b-9dd8-11c746221fab','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无','2017-08-22 21:35:15','admin'),('51e5415a-3cdc-4500-9f40-3802e2f76dd9','ed453cc5-6451-49db-996c-9d02c3607706','e4507f57-2594-4ec5-93a6-793dbb4e4b09','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无','2017-08-22 21:35:15','admin'),('52c06c43-e815-4a6b-ac7f-156f39969acf','ed453cc5-6451-49db-996c-9d02c3607706','bd2112aa-4a83-451b-9dd8-11c746221fab','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无','2017-08-22 21:35:15','admin'),('55087033-8a13-47f5-9358-66c3dd3e6238','0ca70002-2fbb-417c-ab29-b84d1223b9dd','81c8bc0c-a185-4e79-8a02-21e710caafea','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无','2017-08-23 20:45:18','admin'),('6ff845f9-8600-47cd-a2dd-2e2bb2f3b72a','0ca70002-2fbb-417c-ab29-b84d1223b9dd','81c8bc0c-a185-4e79-8a02-21e710caafea','6545daf7-6dac-4647-a954-aa380cc4397e','无','2017-08-23 20:45:18','admin'),('70404bfe-564c-4214-9e83-f9cd775154fe','ed453cc5-6451-49db-996c-9d02c3607706','e3d512b1-092a-4700-825b-b3b635abab1e','260979b9-92ef-4cb2-8e6f-a5c2eae32d87','无','2017-08-22 21:35:15','admin'),('732bcdc4-b809-4f8b-8aac-0566f9ca61a9','ed453cc5-6451-49db-996c-9d02c3607706','e3d512b1-092a-4700-825b-b3b635abab1e','6545daf7-6dac-4647-a954-aa380cc4397e','无','2017-08-22 21:35:15','admin'),('ab32f2fc-359c-4429-94df-2b96c47a144d','ed453cc5-6451-49db-996c-9d02c3607706','bd2112aa-4a83-451b-9dd8-11c746221fab','c5170f01-86fa-4cfe-806d-e44e6487cf5e','无','2017-08-22 21:35:15','admin'),('accb1a2f-06e6-4879-a95b-ee3dc0ba9563','ed453cc5-6451-49db-996c-9d02c3607706','e4507f57-2594-4ec5-93a6-793dbb4e4b09','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无','2017-08-22 21:35:15','admin'),('affa44fb-96f2-4e36-bd0c-bae9f6f9afe5','ed453cc5-6451-49db-996c-9d02c3607706','e3d512b1-092a-4700-825b-b3b635abab1e','f5eb8db4-63df-45f3-94a1-e69b69f02df4','无','2017-08-22 21:35:15','admin'),('be57a77e-2355-41cf-9a20-a797400cd7bb','ed453cc5-6451-49db-996c-9d02c3607706','81c8bc0c-a185-4e79-8a02-21e710caafea','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无','2017-08-22 21:35:15','admin'),('dc5e7d57-fc98-4519-a57d-e1dfd4a44995','0ca70002-2fbb-417c-ab29-b84d1223b9dd','81c8bc0c-a185-4e79-8a02-21e710caafea','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无','2017-08-23 20:45:18','admin'),('eb9026b7-a2b4-4572-887f-235da74961d9','ed453cc5-6451-49db-996c-9d02c3607706','e3d512b1-092a-4700-825b-b3b635abab1e','6d17b1b2-8cfa-45cb-a20e-01f3a84387ce','无','2017-08-22 21:35:15','admin'),('f8d0dfff-0998-41d5-b3e2-2e3d9f992f0b','ed453cc5-6451-49db-996c-9d02c3607706','e4507f57-2594-4ec5-93a6-793dbb4e4b09','6545daf7-6dac-4647-a954-aa380cc4397e','无','2017-08-22 21:35:15','admin');
/*!40000 ALTER TABLE `system_role_menu_button` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user` (
  `id` varchar(36) NOT NULL,
  `user_account` varchar(50) DEFAULT NULL,
  `user_realname` varchar(20) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_tel` varchar(20) DEFAULT NULL,
  `user_headimg` varchar(100) DEFAULT NULL,
  `user_birthday` varchar(20) DEFAULT NULL,
  `user_lastlogintime` varchar(20) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `modifytime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  `status` varchar(200) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` VALUES ('c54ccc12-90a6-4c9c-8331-fc22af572b0d','zhujingling','zhujingling','123456','15295953561','','2017/08/14','2017-08-23 08:53:18','2017-08-14 20:59:10',NULL,'admin','1'),('dbac76e6-868e-4f8a-bb2a-572a30cf4b48','admin','admin','admin','15295953561','','2017/08/10','2017-08-23 08:53:32','2017-08-10 20:56:26',NULL,'admin','1');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_role`
--

DROP TABLE IF EXISTS `system_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_role` (
  `id` varchar(36) NOT NULL,
  `userid` varchar(36) DEFAULT NULL,
  `roleid` varchar(36) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `createman` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_role`
--

LOCK TABLES `system_user_role` WRITE;
/*!40000 ALTER TABLE `system_user_role` DISABLE KEYS */;
INSERT INTO `system_user_role` VALUES ('45184770-3182-426f-9e39-cd82bf25a0e1','c54ccc12-90a6-4c9c-8331-fc22af572b0d','0ca70002-2fbb-417c-ab29-b84d1223b9dd','无','2017-08-23 20:44:30','admin'),('ed453cc5-6451-49db-996c-9d02c3607706','dbac76e6-868e-4f8a-bb2a-572a30cf4b48','ed453cc5-6451-49db-996c-9d02c3607706','无','2017-07-30 20:34:31','Admin');
/*!40000 ALTER TABLE `system_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'zjl_system_master'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-09 19:59:39
