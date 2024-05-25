-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: demkaekz
-- ------------------------------------------------------
-- Server version	8.0.30-alt1.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `zayavki`
--

DROP TABLE IF EXISTS `zayavki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zayavki` (
  `id` int NOT NULL AUTO_INCREMENT,
  `requestID` int DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `homeTechType` varchar(100) DEFAULT NULL,
  `problemDescryption` varchar(100) DEFAULT NULL,
  `requestStatus` varchar(100) DEFAULT NULL,
  `completionDate` date DEFAULT NULL,
  `repairParts` varchar(100) DEFAULT NULL,
  `masterID` int DEFAULT NULL,
  `clientID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `masterID` (`masterID`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `zayavki_ibfk_1` FOREIGN KEY (`masterID`) REFERENCES `users` (`id`),
  CONSTRAINT `zayavki_ibfk_2` FOREIGN KEY (`clientID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zayavki`
--

LOCK TABLES `zayavki` WRITE;
/*!40000 ALTER TABLE `zayavki` DISABLE KEYS */;
INSERT INTO `zayavki` VALUES (1,NULL,'2024-01-01','qwe','qwe','qwe',NULL,NULL,NULL,NULL),(2,NULL,'2024-01-02','qwe','qwe','qwe',NULL,NULL,NULL,NULL),(3,NULL,'2024-01-02','qwe','qwe','qwe',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `zayavki` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-25 11:33:08
