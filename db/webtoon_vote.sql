CREATE DATABASE  IF NOT EXISTS `webtoon_vote` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `webtoon_vote`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: webtoon_vote
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vote` (
  `user` varchar(100) NOT NULL,
  `webtoon_no` int(11) NOT NULL,
  `character_no` int(11) NOT NULL,
  PRIMARY KEY (`user`,`webtoon_no`),
  KEY `webtoon_no_idx` (`webtoon_no`),
  KEY `charater_no_idx` (`character_no`),
  CONSTRAINT `charater_no` FOREIGN KEY (`character_no`) REFERENCES `webtoon_character` (`character_no`),
  CONSTRAINT `webtoon_no` FOREIGN KEY (`webtoon_no`) REFERENCES `webtoon` (`webtoon_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES ('user1',1,1),('user3',2,1),('user2',1,2),('user4',3,3);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webtoon`
--

DROP TABLE IF EXISTS `webtoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `webtoon` (
  `webtoon_no` int(11) NOT NULL AUTO_INCREMENT,
  `webtoon_name` varchar(100) NOT NULL,
  `vote_start_date` datetime NOT NULL,
  `vote_end_date` datetime NOT NULL,
  PRIMARY KEY (`webtoon_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webtoon`
--

LOCK TABLES `webtoon` WRITE;
/*!40000 ALTER TABLE `webtoon` DISABLE KEYS */;
INSERT INTO `webtoon` VALUES (1,'외모지상주의','2018-11-30 00:00:00','2018-12-01 15:00:00'),(2,'유미의세포','2018-11-28 05:00:00','2018-11-28 06:00:00'),(3,'여신강림','2018-11-29 05:00:00','2018-11-29 20:00:00');
/*!40000 ALTER TABLE `webtoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webtoon_character`
--

DROP TABLE IF EXISTS `webtoon_character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `webtoon_character` (
  `character_no` int(11) NOT NULL AUTO_INCREMENT,
  `webtoon_vote_no` int(11) NOT NULL,
  `character_name` varchar(100) NOT NULL,
  `count` int(11) DEFAULT '0',
  `image` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`character_no`,`webtoon_vote_no`),
  KEY `webtoon_vote_no_idx` (`webtoon_vote_no`),
  CONSTRAINT `webtoon_vote_no` FOREIGN KEY (`webtoon_vote_no`) REFERENCES `webtoon` (`webtoon_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webtoon_character`
--

LOCK TABLES `webtoon_character` WRITE;
/*!40000 ALTER TABLE `webtoon_character` DISABLE KEYS */;
INSERT INTO `webtoon_character` VALUES (1,1,'박형석',0,NULL),(1,2,'유미',0,NULL),(1,3,'임주경',0,NULL),(2,1,'바스코',0,NULL),(2,2,'바비',0,NULL),(2,3,'한서준',0,NULL),(3,3,'이수호',0,NULL);
/*!40000 ALTER TABLE `webtoon_character` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-30 13:39:57
