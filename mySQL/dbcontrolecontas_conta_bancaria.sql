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
-- Table structure for table `conta_bancaria`
--

DROP TABLE IF EXISTS `conta_bancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conta_bancaria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_agencia` int(11) NOT NULL,
  `id_primeiro_titular` int(11) NOT NULL,
  `id_segundo_titular` int(11) DEFAULT NULL,
  `data_abertura` date NOT NULL,
  `saldo_atual` decimal(10,2) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `bandeira_cartao` varchar(35) NOT NULL,
  `numero_cartao` bigint(20) NOT NULL,
  `expira_cartao` date NOT NULL,
  `cvv` int(11) NOT NULL,
  `situacao_conta` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_agencia` (`id_agencia`),
  KEY `id_primeiro_titular` (`id_primeiro_titular`),
  KEY `id_segundo_titular` (`id_segundo_titular`),
  CONSTRAINT `conta_bancaria_ibfk_1` FOREIGN KEY (`id_agencia`) REFERENCES `agencia` (`id`),
  CONSTRAINT `conta_bancaria_ibfk_2` FOREIGN KEY (`id_primeiro_titular`) REFERENCES `pessoa_fisica` (`id_pessoa`),
  CONSTRAINT `conta_bancaria_ibfk_3` FOREIGN KEY (`id_segundo_titular`) REFERENCES `pessoa_fisica` (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta_bancaria`
--

LOCK TABLES `conta_bancaria` WRITE;
/*!40000 ALTER TABLE `conta_bancaria` DISABLE KEYS */;
INSERT INTO `conta_bancaria` VALUES (1,1,5,NULL,'2019-03-10',1.00,'senhasenha','mastercard',9090,'2022-02-19',0,'ATIVO'),(2,1,5,NULL,'2020-04-10',9329.00,'909090','nubank',890,'2024-03-19',0,'ATIVO'),(3,1,5,NULL,'2020-04-10',500.00,'ooo','bradesco',8080,'2024-03-19',0,'ATIVO'),(4,1,5,NULL,'2020-04-10',500.00,'ooo','bradesco',90090,'2024-03-19',0,'ATIVO'),(5,1,5,NULL,'2020-04-10',9000.00,'000','bradesco',9090,'2024-03-19',0,'ATIVO'),(6,1,5,NULL,'2015-05-04',8000.00,'8089','bancodobrasil',100,'2022-03-04',1,'ATIVO'),(7,1,5,NULL,'2020-04-10',90.00,'7878','bandeirafoda',1313,'2024-03-19',8989,'ATIVO'),(8,1,5,NULL,'2020-04-10',80.00,'opop','bradesco',1111,'2024-03-19',7000,'ATIVO'),(9,1,5,NULL,'2020-04-10',90.00,'ioio','bradesco',1010,'2024-03-19',0,'ATIVO');
/*!40000 ALTER TABLE `conta_bancaria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-06 19:55:30
