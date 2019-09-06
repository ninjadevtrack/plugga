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
INSERT INTO `card` VALUES (1,'2019-09-06 15:10:39'),(2,'2019-09-06 15:10:40'),(3,'2019-09-06 15:10:41'),(4,'2019-09-06 15:10:42'),(5,'2019-09-06 15:10:42'),(6,'2019-09-06 15:10:42'),(7,'2019-09-06 15:10:43'),(8,'2019-09-06 15:10:43'),(9,'2019-09-06 15:10:43'),(10,'2019-09-06 15:10:44'),(11,'2019-09-06 15:11:50'),(12,'2019-09-06 15:11:50'),(13,'2019-09-06 15:11:51'),(14,'2019-09-06 15:11:51'),(15,'2019-09-06 15:11:51'),(16,'2019-09-06 15:11:52'),(17,'2019-09-06 15:11:52'),(18,'2019-09-06 15:11:53'),(19,'2019-09-06 15:11:53'),(20,'2019-09-06 15:11:54');
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
INSERT INTO `pile` VALUES (1,1,1),(2,1,7),(3,1,1),(4,1,7),(5,1,1),(6,1,7),(7,1,1),(8,1,2),(9,1,1),(10,1,30),(11,1,1),(12,1,7),(13,1,1),(14,1,365),(15,1,30),(16,1,365),(17,1,1),(18,1,2),(19,1,2),(20,1,7);
/*!40000 ALTER TABLE `pile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `side`
--

LOCK TABLES `side` WRITE;
/*!40000 ALTER TABLE `side` DISABLE KEYS */;
INSERT INTO `side` VALUES (1,1,'http://plugga.com/static/some_card_image.gif','How many hearts do octopuses have?'),(2,1,'http://plugga.com/static/some_card_image.gif','Three'),(3,2,'http://plugga.com/static/some_card_image.gif','On which planet is the largest mountain in the solar system found?'),(4,2,'http://plugga.com/static/some_card_image.gif','Mars: the mountain is called Olympus Mons.'),(5,3,'http://plugga.com/static/some_card_image.gif','What is the heaviest organ in the human body?'),(6,3,'http://plugga.com/static/some_card_image.gif','The liver.'),(7,4,'http://plugga.com/static/some_card_image.gif','Who discovered penicillin?'),(8,4,'http://plugga.com/static/some_card_image.gif','Alexander Fleming.'),(9,5,'http://plugga.com/static/some_card_image.gif','Which creature has the largest heart?'),(10,5,'http://plugga.com/static/some_card_image.gif','The blue whale: its heart weighs more than 1,500 pounds.'),(11,6,'http://plugga.com/static/some_card_image.gif','Who developed the special theory of relativity?'),(12,6,'http://plugga.com/static/some_card_image.gif','Albert Einstein.'),(13,7,'http://plugga.com/static/some_card_image.gif','How many hydrogen atoms are in one molecule of water?'),(14,7,'http://plugga.com/static/some_card_image.gif','Two.'),(15,8,'http://plugga.com/static/some_card_image.gif','Who was the first woman to win a Nobel Prize (for Physics in 1903)?'),(16,8,'http://plugga.com/static/some_card_image.gif','Marie Curie.'),(17,9,'http://plugga.com/static/some_card_image.gif','Who performed the first human heart transplant in 1967?'),(18,9,'http://plugga.com/static/some_card_image.gif','Dr. Christiaan Barnard'),(19,10,'http://plugga.com/static/some_card_image.gif','What is the fattest human organ?'),(20,10,'http://plugga.com/static/some_card_image.gif','The brain: it is about 60% fat.'),(21,11,'http://plugga.com/static/some_card_image.gif','Which of these is not found in the nucleus: A. proton, B. neutron, C. electron?'),(22,11,'http://plugga.com/static/some_card_image.gif','Electron.'),(23,12,'http://plugga.com/static/some_card_image.gif','Which planet in our solar system is closest to the sun?'),(24,12,'http://plugga.com/static/some_card_image.gif','Mercury.'),(25,13,'http://plugga.com/static/some_card_image.gif','How many compartments does a cow\'s stomach have?'),(26,13,'http://plugga.com/static/some_card_image.gif','Four.'),(27,14,'http://plugga.com/static/some_card_image.gif','What is the most abundant gas in the earth\'s atmosphere?'),(28,14,'http://plugga.com/static/some_card_image.gif','Nitrogen.'),(29,15,'http://plugga.com/static/some_card_image.gif','What is the longest bone in the human body?'),(30,15,'http://plugga.com/static/some_card_image.gif','The femur (thighbone).'),(31,16,'http://plugga.com/static/some_card_image.gif','What is the chemical symbol for potassium?'),(32,16,'http://plugga.com/static/some_card_image.gif','K'),(33,17,'http://plugga.com/static/some_card_image.gif','Who was the second man to walk on the moon?'),(34,17,'http://plugga.com/static/some_card_image.gif','Buzz Aldrin.'),(35,18,'http://plugga.com/static/some_card_image.gif','Which branch of biology deals with the behavior of animals, usually concentrating on animal behavior under natural conditions?'),(36,18,'http://plugga.com/static/some_card_image.gif','Ethology.'),(37,19,'http://plugga.com/static/some_card_image.gif','Who first formulated the theory of evolution in his book, \"The Origin of Species\"?'),(38,19,'http://plugga.com/static/some_card_image.gif','Charles Darwin.'),(39,20,'http://plugga.com/static/some_card_image.gif','What number on the Beaufort wind scale corresponds to hurricane force?'),(40,20,'http://plugga.com/static/some_card_image.gif','12.');
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

-- Dump completed on 2019-09-06 12:01:27
