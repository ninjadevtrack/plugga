CREATE DATABASE  IF NOT EXISTS `plugga` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `plugga`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: plugga
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `card` (
  `card_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `last_used` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deck`
--

DROP TABLE IF EXISTS `deck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `deck` (
  `deck_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `image_url` text,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`deck_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deck`
--

LOCK TABLES `deck` WRITE;
/*!40000 ALTER TABLE `deck` DISABLE KEYS */;
/*!40000 ALTER TABLE `deck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deck_card`
--

DROP TABLE IF EXISTS `deck_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `deck_card` (
  `deck_card_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `deck_id` int(10) unsigned NOT NULL,
  `card_id` int(10) unsigned NOT NULL,
  `pile_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`deck_card_id`),
  KEY `deck_card_id_idx` (`card_id`),
  KEY `card_deck_id_idx` (`deck_id`),
  KEY `deck_card_pile_id_idx` (`pile_id`),
  CONSTRAINT `card_deck_id` FOREIGN KEY (`deck_id`) REFERENCES `deck` (`deck_id`),
  CONSTRAINT `deck_card_id` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`),
  CONSTRAINT `deck_card_pile_id` FOREIGN KEY (`pile_id`) REFERENCES `pile` (`pile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deck_card`
--

LOCK TABLES `deck_card` WRITE;
/*!40000 ALTER TABLE `deck_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `deck_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pile`
--

DROP TABLE IF EXISTS `pile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pile` (
  `pile_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `deck_id` int(10) unsigned NOT NULL,
  `rank` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `freq` tinyint(4) unsigned NOT NULL DEFAULT '7',
  PRIMARY KEY (`pile_id`),
  KEY `deck_id_idx` (`deck_id`),
  CONSTRAINT `pile_deck_id` FOREIGN KEY (`deck_id`) REFERENCES `deck` (`deck_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pile`
--

LOCK TABLES `pile` WRITE;
/*!40000 ALTER TABLE `pile` DISABLE KEYS */;
/*!40000 ALTER TABLE `pile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `side`
--

DROP TABLE IF EXISTS `side`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `side` (
  `side_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `card_id` int(10) unsigned NOT NULL,
  `image_url` text,
  `text` text,
  PRIMARY KEY (`side_id`),
  KEY `side_card_id_idx` (`card_id`),
  CONSTRAINT `side_card_id` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `side`
--

LOCK TABLES `side` WRITE;
/*!40000 ALTER TABLE `side` DISABLE KEYS */;
/*!40000 ALTER TABLE `side` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Leslie','leslie@plugga.com','{bcrypt}$2a$04$WG3OFFCMts4XFhveEzh5lu/UrlaYFt25TsK4Yw.sRoBrzPMk.swQ.','2019-07-12 00:55:46',NULL),(2,'Knope','knope@plugga.com','{bcrypt}$2a$04$56l2q4SSgogthTelarpnve43lqOx5zGgBFriE4gyvjxyDWPAqqrWO','2019-07-12 00:55:46',NULL),(3,'Neo','neo@plugga.com','{bcrypt}$2a$04$HmERLmZb.yg5WX3VUM0c0u7eF.ASN7SaTFf.2/XJo28FA1pQYGI6i','2019-07-12 00:55:46',NULL),(4,'Matina','matina@plugga.com','{bcrypt}$2a$04$2LGkBB0JDWFbAmI13sjPau8zthlgstgx6oZcKHc6rWPHekfqesd9y','2019-07-12 00:55:46',NULL),(5,'Bulbasaur','bulbasaur@plugga.com','{bcrypt}$2a$04$IeW.VCpSY7OwSCZxZYeN/Oy1b5ze3MIxCsIqKohQbaur/5btTmgki','2019-07-12 00:55:46',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_deck`
--

DROP TABLE IF EXISTS `user_deck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_deck` (
  `user_deck_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `deck_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_deck_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `deck_id_idx` (`deck_id`),
  CONSTRAINT `deck_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_deck_id` FOREIGN KEY (`deck_id`) REFERENCES `deck` (`deck_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_deck`
--

LOCK TABLES `user_deck` WRITE;
/*!40000 ALTER TABLE `user_deck` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_deck` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-07 15:46:44
