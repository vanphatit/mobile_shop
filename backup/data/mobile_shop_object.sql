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
-- Table structure for table `object`
--

DROP TABLE IF EXISTS `object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `object` (
  `id` varchar(7) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `status` varchar(1000) NOT NULL,
  `manufacture` varchar(1000) NOT NULL,
  `unitprice` int DEFAULT NULL,
  `id_category` varchar(7) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_category` (`id_category`),
  CONSTRAINT `object_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `object_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object`
--

LOCK TABLES `object` WRITE;
/*!40000 ALTER TABLE `object` DISABLE KEYS */;
INSERT INTO `object` VALUES ('O001','iPhone 15 Pro Max','Sắp hết hàng','Apple',34000000,'OC01'),('O002','iPhone 15 Pro','Sắp hết hàng','Apple',29000000,'OC01'),('O003','iPhone 15 Plus','Sắp hết hàng','Apple',26000000,'OC01'),('O004','iPhone 15','Sắp hết hàng','Apple',22000000,'OC01'),('O005','Samsung Galaxy A05s','Còn hàng','Samsung',4000000,'OC02'),('O006','OPPO Find N3 Flip 5G','Còn hàng','OPPO',23000000,'OC02'),('O007','Xiaomi Redmi 13C','Còn hàng','Xiaomi',2900000,'OC02'),('O008','vivo V29e 5G','Còn hàng','Vivo',9500000,'OC02'),('O009','realme C53','Còn hàng','realme',4000000,'OC02'),('O010','OPPO Reno10 5G','Còn hàng','OPPO',11490000,'OC02');
/*!40000 ALTER TABLE `object` ENABLE KEYS */;
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
