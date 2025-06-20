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
  `numero_cartao` bigint(50) NOT NULL,
  `expira_cartao` date NOT NULL,
  `cvv` int(11) NOT NULL,
  `situacao_conta` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_agencia` (`id_agencia`),
  KEY `id_primeiro_titular` (`id_primeiro_titular`),
  KEY `id_segundo_titular` (`id_segundo_titular`),
  CONSTRAINT `fk_conta_agencia` FOREIGN KEY (`id_agencia`) REFERENCES `agencia` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_conta_primeiro_titular` FOREIGN KEY (`id_primeiro_titular`) REFERENCES `pessoa_fisica` (`id_pessoa`) ON DELETE CASCADE,
  CONSTRAINT `fk_conta_segundo_titular` FOREIGN KEY (`id_segundo_titular`) REFERENCES `pessoa_fisica` (`id_pessoa`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta_bancaria`
--

LOCK TABLES `conta_bancaria` WRITE;
/*!40000 ALTER TABLE `conta_bancaria` DISABLE KEYS */;
INSERT INTO `conta_bancaria` VALUES (1,1,1,NULL,'2020-01-10',1500.50,'senha123','Visa',12341231,'2027-10-01',123,'Ativa'),(2,1,2,NULL,'2021-03-15',2300.00,'senha456','Mastercard',5100123412341234,'2026-05-01',456,'Ativa'),(3,2,3,1,'2019-06-20',500.75,'senha789','Elo',6500123412341234,'2025-09-01',789,'Ativa'),(4,2,4,NULL,'2022-07-01',10000.00,'senhaabc','Visa',4000111122223333,'2028-01-01',111,'Ativa'),(5,1,5,NULL,'2018-11-11',750.90,'senhadef','Mastercard',5100999988887777,'2025-11-01',222,'Ativa'),(6,1,6,NULL,'2023-02-25',300.00,'senhaghi','Elo',6500555544443333,'2026-02-01',333,'Ativa'),(7,2,7,5,'2020-08-08',5000.00,'senhajkl','Visa',4000666611112222,'2027-12-01',444,'Ativa'),(8,2,1,NULL,'2021-10-10',1250.60,'senhamno','Mastercard',5100777722223333,'2026-06-01',555,'BLOQUEADA'),(9,1,2,4,'2017-09-09',999.99,'senhapqr','Visa',4000888833334444,'2027-04-01',666,'Ativa'),(10,1,3,NULL,'2024-01-01',4500.00,'senhastu','Elo',6500999966665555,'2028-03-01',777,'Ativa');
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

-- Dump completed on 2025-06-19 23:50:13
