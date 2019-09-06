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
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deck`
--

LOCK TABLES `deck` WRITE;
/*!40000 ALTER TABLE `deck` DISABLE KEYS */;
INSERT INTO `deck` VALUES (1,'Leslie\'s Deck','http://plugga.com/somefakeimage.jp','2019-09-05 22:55:02'),(2,'Knope\'s Deck','http://plugga.com/somefakeimage.jp','2019-09-05 23:10:40'),(3,'Neo\'s Deck','http://plugga.com/somefakeimage.jp','2019-09-05 23:10:46'),(4,'Matina\'s Deck','http://plugga.com/somefakeimage.jp','2019-09-05 23:10:55'),(5,'Bulbasaur\'s Deck','http://plugga.com/somefakeimage.jp','2019-09-05 23:11:05'),(6,'Leslie\'s Deck2','http://plugga.com/somefakeimage.jp','2019-09-06 14:48:11'),(7,'Knope\'s Deck2','http://plugga.com/somefakeimage.jp','2019-09-06 14:49:14'),(8,'Neo\'s Deck2','http://plugga.com/somefakeimage.jp','2019-09-06 14:49:20'),(9,'Matina\'s Deck2','http://plugga.com/somefakeimage.jp','2019-09-06 14:49:24'),(10,'Bulbasaur\'s Deck2','http://plugga.com/somefakeimage.jp','2019-09-06 14:49:31');
/*!40000 ALTER TABLE `deck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deck_card`
--

LOCK TABLES `deck_card` WRITE;
/*!40000 ALTER TABLE `deck_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `deck_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pile`
--

LOCK TABLES `pile` WRITE;
/*!40000 ALTER TABLE `pile` DISABLE KEYS */;
/*!40000 ALTER TABLE `pile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `side`
--

LOCK TABLES `side` WRITE;
/*!40000 ALTER TABLE `side` DISABLE KEYS */;
/*!40000 ALTER TABLE `side` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Leslie','leslie@plugga.com','{bcrypt}$2a$04$WG3OFFCMts4XFhveEzh5lu/UrlaYFt25TsK4Yw.sRoBrzPMk.swQ.','2019-07-12 00:55:46',NULL),(2,'Knope','knope@plugga.com','{bcrypt}$2a$04$56l2q4SSgogthTelarpnve43lqOx5zGgBFriE4gyvjxyDWPAqqrWO','2019-07-12 00:55:46',NULL),(3,'Neo','neo@plugga.com','{bcrypt}$2a$04$HmERLmZb.yg5WX3VUM0c0u7eF.ASN7SaTFf.2/XJo28FA1pQYGI6i','2019-07-12 00:55:46',NULL),(4,'Matina','matina@plugga.com','{bcrypt}$2a$04$2LGkBB0JDWFbAmI13sjPau8zthlgstgx6oZcKHc6rWPHekfqesd9y','2019-07-12 00:55:46',NULL),(5,'Bulbasaur','bulbasaur@plugga.com','{bcrypt}$2a$04$IeW.VCpSY7OwSCZxZYeN/Oy1b5ze3MIxCsIqKohQbaur/5btTmgki','2019-07-12 00:55:46',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_deck`
--

LOCK TABLES `user_deck` WRITE;
/*!40000 ALTER TABLE `user_deck` DISABLE KEYS */;
INSERT INTO `user_deck` VALUES (1,1,1),(2,1,6),(3,2,2),(4,2,7),(5,3,3),(6,3,8),(7,4,4),(8,4,9),(9,5,5),(10,5,10);
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

-- Dump completed on 2019-09-06 10:58:55
