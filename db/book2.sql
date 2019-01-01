CREATE DATABASE  IF NOT EXISTS `book2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `book2`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: book2
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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `categoryId` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `publisherId` int(11) NOT NULL,
  `available` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_book_category` (`categoryId`),
  KEY `FK_Book_Publisher` (`publisherId`),
  CONSTRAINT `FK_Book_Publisher` FOREIGN KEY (`publisherId`) REFERENCES `publisher` (`id`),
  CONSTRAINT `FK_book_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'지혜수정성공진짜루','루비',2,400,3,1),(2,'죄와벌','도스토예프스키',1,10000,1,1),(3,'레미제라블','빅토르 위고',1,11000,2,1),(4,'나나','에밀졸라',1,9000,1,1),(5,'그리스인 조르바','카잔차카스',1,8000,3,0),(9,'노인과 바다','헤밍웨이',1,8500,2,0),(10,'돈키호테','세르반테스',1,9500,1,1),(11,'리어 왕','세익스피어',1,9000,1,1),(12,'몽테크리스토 백작','뒤마',1,10000,4,1),(13,'모비딕','멜빌',1,10000,1,1),(14,'바람과 함께 사라지다','마가렛 미첼',1,12000,2,0),(15,'실낙원','밀턴',1,9000,1,0),(16,'토지','박경리',1,13000,1,0),(17,'경제학 개론','홍길동',3,10000,2,1),(18,'미시경제학','임꺽정',3,9000,1,1),(19,'거시경제학','온달',3,9000,1,1),(20,'자본시장론','평강',3,9500,1,0),(21,'지질학개론','홍길동',4,10000,8,1),(22,'천문학개론','임꺽정',4,1500,1,0),(24,'과학사','전우치',4,3000,1,0),(25,'동양문화사','온달',5,4000,3,0),(26,'동북아시아고대사','평강',5,5000,4,0),(27,'중세유럽사','홍길동',5,6000,1,1),(28,'영국사','임꺽정',5,7000,1,1),(29,'환율의 미래','전우치',3,11000,2,0),(30,'ETF 투자','홍길동',3,9000,7,1),(31,'에너지 혁명','온달',3,8000,2,0),(32,'해양학 개론','임꺽정',4,10000,6,0),(33,'식물학 개론','홍길동',4,11000,1,1),(34,'동물학 개론','전우치',4,15000,1,0),(35,'미생물학 개론','전우치',4,9000,2,1),(36,'지구과학 개론','전우치',4,8000,7,1),(37,'미국사','임꺽정',5,5000,1,1),(39,'한국사','임꺽정',5,6000,1,0),(40,'고구려사','전우치',5,10000,1,1),(41,'고려사','전우치',5,9000,1,1),(42,'조선사','온달',5,8000,2,1),(43,'고조선사','온달',5,13000,2,1),(44,'일본역사','홍길동',5,9000,2,1),(45,'중국사','홍길동',5,15000,1,1),(46,'러시아사','홍길동',5,10000,1,1),(47,'유라시아역사','홍길동',5,9000,1,1),(48,'새책','홍길동',2,10000,1,1),(49,'제인에어','브론테',1,13000,2,1),(50,'데미안','헤르만 헤세',1,14000,2,1),(51,'파우스트','괴테',1,10000,1,1),(52,'심판','카프카',1,9000,1,1),(53,'향수','쥐스킨트',1,9000,1,1),(54,'젊은 베르테르의 슬픔','괴테',1,10000,2,1),(55,'어린왕자','셍텍쥐페리',1,3500,1,1),(56,'오만과 편견','제인 오스틴',1,7000,2,1),(57,'이방인','카뮈',1,6000,2,1),(58,'동물농장','조지 오웰',1,5000,1,1),(59,'달과 6펜스','서머멧 모옴',1,6300,1,1),(60,'위대한 개츠비','스콧 피츠제럴드',1,5600,1,1),(61,'페스트','카뮈',1,9100,2,1),(62,'싯다르타','헤르만 헤세',1,4900,1,1),(63,'노인과 바다','헤밍웨이',1,2000,1,1),(64,'좁은문','지드',1,2500,1,1),(66,'등록합니다','김지혜',4,800000,5,1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'소설'),(2,'수필'),(3,'경제'),(4,'과학'),(5,'역사');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'바다'),(2,'보름'),(3,'하늘'),(4,'강산'),(5,'태양'),(6,'문화'),(7,'대지'),(8,'지구'),(16,'바다'),(17,'보름'),(18,'하늘'),(19,'강산'),(20,'태양'),(21,'문화'),(22,'대지'),(23,'지구');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-30 13:38:55
