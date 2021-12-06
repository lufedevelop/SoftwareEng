-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: myresidence_db
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `residence`
--

DROP TABLE IF EXISTS `residence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residence` (
  `residence_ID` int NOT NULL,
  `living_style` varchar(255) DEFAULT NULL,
  `room_type` varchar(225) DEFAULT NULL,
  `residence_price` int NOT NULL,
  `residence_address` varchar(255) DEFAULT NULL,
  `has_mealplan` tinyint(1) DEFAULT NULL,
  `student_usernames` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`residence_ID`),
  CONSTRAINT `residence_chk_1` CHECK (((`living_style` = _utf8mb4'Residence Hall') or (`living_style` = _utf8mb4'Apartment') or (`living_style` = _utf8mb4'Townhouse'))),
  CONSTRAINT `residence_chk_2` CHECK (((`room_type` = _utf8mb4'Double') or (`room_type` = _utf8mb4'Basic Single') or (`room_type` = _utf8mb4'Single')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residence`
--

LOCK TABLES `residence` WRITE;
/*!40000 ALTER TABLE `residence` DISABLE KEYS */;
INSERT INTO `residence` VALUES (1001,'Residence Hall','Basic Single',11196,'Bartley Residence Bartley Cir',1,NULL),(1002,'Residence Hall','Basic Single',11196,'Bartley Residence Bartley Cir',1,NULL),(1003,'Residence Hall','Basic Single',11196,'Bartley Residence Bartley Cir',1,NULL),(1004,'Residence Hall','Basic Single',11196,'Bartley Residence Bartley Cir',1,NULL),(1005,'Residence Hall','Single',12395,'Bartley Residence Bartley Cir',1,NULL),(1006,'Residence Hall','Single',12395,'Bartley Residence Bartley Cir',1,NULL),(1007,'Residence Hall','Single',12395,'Bartley Residence Bartley Cir',1,NULL),(1008,'Residence Hall','Double',10235,'Bartley Residence Bartley Cir',1,NULL),(1009,'Residence Hall','Double',10235,'Bartley Residence Bartley Cir',1,NULL),(1010,'Residence Hall','Double',10235,'Bartley Residence Bartley Cir',1,NULL),(1101,'Residence Hall','Basic Single',11196,'Prettie Residence Lakehead University Dr N',1,NULL),(1102,'Residence Hall','Basic Single',11196,'Prettie Residence Lakehead University Dr N',1,NULL),(1103,'Residence Hall','Basic Single',11196,'Prettie Residence Lakehead University Dr N',1,NULL),(1104,'Residence Hall','Single',12395,'Prettie Residence Lakehead University Dr N',1,NULL),(1105,'Residence Hall','Single',12395,'Prettie Residence Lakehead University Dr N',1,NULL),(1106,'Residence Hall','Single',12395,'Prettie Residence Lakehead University Dr N',1,NULL),(1107,'Residence Hall','Single',12395,'Prettie Residence Lakehead University Dr N',1,NULL),(1108,'Residence Hall','Double',10235,'Prettie Residence Lakehead University Dr N',1,NULL),(1109,'Residence Hall','Double',10235,'Prettie Residence Lakehead University Dr N',1,NULL),(4001,'Townhouse','Single',7982,'100 Deer Lake Rd',0,NULL),(4002,'Townhouse','Single',7982,'103 Deer Lake Rd',0,NULL),(4003,'Townhouse','Single',7982,'105 Deer Lake Rd',0,NULL),(4101,'Apartment','Single',7571,'223 North Spirit Rd',0,NULL),(4102,'Apartment','Single',7571,'225 North Spirit Rd',0,NULL),(4103,'Apartment','Single',7571,'227 North Spirit Rd',0,NULL);
/*!40000 ALTER TABLE `residence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-27 17:29:22
