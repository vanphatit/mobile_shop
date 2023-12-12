CREATE DATABASE  IF NOT EXISTS `mobile_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mobile_shop`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: mobile_shop
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `receipt_note`
--

DROP TABLE IF EXISTS `receipt_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt_note` (
  `id` varchar(7) NOT NULL,
  `date` datetime NOT NULL,
  `more_info` varchar(1000) DEFAULT NULL,
  `id_suplier` varchar(7) NOT NULL,
  `id_staff` varchar(7) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_suplier` (`id_suplier`),
  KEY `id_staff` (`id_staff`),
  CONSTRAINT `receipt_note_ibfk_1` FOREIGN KEY (`id_suplier`) REFERENCES `suplier` (`id`),
  CONSTRAINT `receipt_note_ibfk_2` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_note`
--

LOCK TABLES `receipt_note` WRITE;
/*!40000 ALTER TABLE `receipt_note` DISABLE KEYS */;
INSERT INTO `receipt_note` VALUES ('RN001','2023-12-12 00:00:00','Hoàn thành','S001','ST02'),('RN002','2023-12-01 00:00:00','Thanh toán 50%','S002','ST03'),('RN003','2023-11-12 00:00:00','Hoàn thành','S003','ST02'),('RN004','2023-11-01 00:00:00','Hoàn thành','S001','ST01'),('RN005','2023-10-12 00:00:00','Thanh toán 50%','S002','ST02');
/*!40000 ALTER TABLE `receipt_note` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-12 16:38:16
