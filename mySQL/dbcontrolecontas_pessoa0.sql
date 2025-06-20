-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbcontrolecontas
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_enderecamento_cep` int(11) NOT NULL,
  `numero_endereco` int(11) NOT NULL,
  `comple_endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `cliente_desde` date DEFAULT NULL,
  `situacao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pessoa_ibfk_1` (`id_enderecamento_cep`),
  CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`id_enderecamento_cep`) REFERENCES `enderecamento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,3,779,'Street','(011) 6094 3429','2019-09-04','Ativo'),(2,1,187,'Street','+55 (031) 3888-7171','2022-10-20','Ativo'),(3,1,959,'Street','+55 (061) 6620-2296','2017-11-26','Ativo'),(4,2,581,'Street','(021) 9835-1022','2018-04-11','Ativo'),(5,1,622,'Street','(011) 9967-7733','2020-06-30','Ativo'),(6,3,415,'Street','(031) 9855-1122','2021-01-15','Inativo'),(7,2,320,'Street','(061) 9888-5566','2022-03-22','Ativo'),(8,2,703,'Street','(051) 9977-4433','2021-07-07','Ativo'),(9,1,245,'Street','(071) 9856-3344','2019-09-09','Inativo'),(10,3,344,'Street','(081) 9866-2277','2020-10-10','Ativo'),(11,3,411,'Street','(091) 9877-1199','2023-02-02','Ativo'),(12,1,177,'Street','(041) 9899-2233','2020-12-12','Ativo'),(13,2,267,'Street','(051) 9822-3344','2018-08-08','Ativo');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-19 23:50:13
