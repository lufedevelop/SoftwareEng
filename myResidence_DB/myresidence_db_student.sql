-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: myresidence_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_username` char(8) NOT NULL,
  `student_password` varchar(255) NOT NULL,
  `student_email` char(21) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `year_num` int NOT NULL,
  `residence_ID` int DEFAULT NULL,
  `application_pending` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`student_username`),
  KEY `residence_ID` (`residence_ID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`residence_ID`) REFERENCES `residence` (`residence_ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('altlrios','annerios1','altlrios@lakeheadu.ca','Anne Rios',4,NULL,0),('amadhali','lo1ngsign3','amadhali@lakeheadu.ca','Ahmed Ali',2,NULL,0),('antburke','Up@efVf','antburke@lakeheadu.ca','Antonio Burke',3,NULL,0),('byburnet','oldJ@guar56','byburnet@lakeheadu.ca','Bruno Burnett',1,NULL,0),('cjbolton','20bolt01','cjbolton@lakeheadu.ca','Cecile Bolton',3,NULL,0),('clxlsims','>simbi20','clxlsims@lakeheadu.ca','Caitlyn Sims',2,NULL,0),('cmdpitts','wildLl@ma24','cmdpitts@lakeheadu.ca','Christopher Pitts',2,NULL,0),('erbyoung','yyed83s','erbyoung@lakeheadu.ca','Erin Young',1,NULL,0),('erjacobs','pass','erjacobs@lakeheadu.ca','Emily Jacobs',3,NULL,0),('fpcarter','dar<S','fpcarter@lakeheadu.ca','Faith Carter',1,NULL,0),('hzcallah','hcally03','hzcallah@lakeheadu.ca','Hazel Callahan',1,NULL,0),('jastyork','badPar<59','jastyork@lakeheadu.ca','Jasmine York',3,NULL,0),('jasxnlui','soccer98','jasxnlui@lakeheadu.ca','Jason Lui',5,NULL,0),('jmwillia','joseph','jmwillia@lakeheadu.ca','Joseph Williams',4,NULL,0),('karpears','fntcpe1','karpears@lakeheadu.ca','Kayla Pearson',4,NULL,0),('kmcguire','bestnail85','kmcguire@lakeheadu.ca','Kyle Mcguire',2,NULL,0),('lataimer','kin)Wing60','lataimer@lakeheadu.ca','Lauren Aimer',5,NULL,0),('lfederle','password','lfederle@lakeheadu.ca','Lukas Federle',3,1008,0),('llymchen','lillflow1','llymchen@lakeheadu.ca','Lily Chen',2,NULL,0),('marleiyu','clxxd3shn','marleiyu@lakeheadu.ca','Marie Yu',4,NULL,0),('mglfishe','be$tFish','mglfishe@lakeheadu.ca','Megean Fisher',2,NULL,0),('mpawadis','37pawMK4','mpawadis@lakeheadu.ca','Mark Pawadis',3,NULL,0),('paramsey','doglover2','paramsey@lakeheadu.ca','Paul Ramsey',4,NULL,0),('pelechoi','sunriseJX','pelechoi@lakeheadu.ca','Pearce Choi',1,NULL,0),('sajcorte','fifCZ8','sajcorte@lakeheadu.ca','Sue Cortez',3,NULL,0),('sastephe','d@rkPanda95','sastephe@lakeheadu.ca','Sal Stephens',2,NULL,0),('stejones','anej772','stejones@lakeheadu.ca','Stuart Jones',5,NULL,0),('stjakhan','=ancyLine49','stjakhan@lakeheadu.ca','Sterling Khan',1,NULL,0),('vicayers','99nitro39','vicayers@lakeheadu.ca','Victor Ayers',1,NULL,0),('vwsavery','11viv@','vwsavery@lakeheadu.ca','Vivian Avery',1,NULL,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-12 16:02:13
