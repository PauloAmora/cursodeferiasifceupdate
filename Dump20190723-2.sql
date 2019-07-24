CREATE DATABASE  IF NOT EXISTS `deposito` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `deposito`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: deposito
-- ------------------------------------------------------
-- Server version	5.5.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `nome` varchar(50) NOT NULL DEFAULT '',
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('joao','rua coronel','0000000001'),('marco','cedro','00000000002'),('taires','centro,praca padre cicero','0000000003');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mercadoria`
--

DROP TABLE IF EXISTS `mercadoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mercadoria` (
  `nome` varchar(50) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `entrada` varchar(50) DEFAULT NULL,
  `saida` varchar(50) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mercadoria`
--

LOCK TABLES `mercadoria` WRITE;
/*!40000 ALTER TABLE `mercadoria` DISABLE KEYS */;
INSERT INTO `mercadoria` VALUES ('cambara',5,'06-05-2016','02-02-2013',5),('castelonome',5,'06-05-2016','02-02-2013',5),('cristal',5,'01-05-2013','06-03-2018',4),('cristalina',5,'05-05-2016','01-02-2013',5);
/*!40000 ALTER TABLE `mercadoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrodecompras`
--

DROP TABLE IF EXISTS `registrodecompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrodecompras` (
  `mercadoria` varchar(50) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `datadecompra` varchar(50) DEFAULT NULL,
  KEY `fk2` (`mercadoria`),
  CONSTRAINT `fk3` FOREIGN KEY (`mercadoria`) REFERENCES `mercadoria` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrodecompras`
--

LOCK TABLES `registrodecompras` WRITE;
/*!40000 ALTER TABLE `registrodecompras` DISABLE KEYS */;
INSERT INTO `registrodecompras` VALUES ('castelonome',20,'04-03-2019'),('cristalina',10,'02-05-2019'),('cristal',6,'02-06-1999');
/*!40000 ALTER TABLE `registrodecompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrodevendas`
--

DROP TABLE IF EXISTS `registrodevendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrodevendas` (
  `nomedocliente` varchar(50) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `mercadoria` varchar(50) DEFAULT NULL,
  `datadevenda` varchar(50) DEFAULT NULL,
  KEY `fk1` (`nomedocliente`),
  KEY `fk2` (`mercadoria`),
  CONSTRAINT `fk1` FOREIGN KEY (`nomedocliente`) REFERENCES `cliente` (`nome`),
  CONSTRAINT `fk2` FOREIGN KEY (`mercadoria`) REFERENCES `mercadoria` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrodevendas`
--

LOCK TABLES `registrodevendas` WRITE;
/*!40000 ALTER TABLE `registrodevendas` DISABLE KEYS */;
INSERT INTO `registrodevendas` VALUES ('joao',5,'cambara','01-02-2023');
/*!40000 ALTER TABLE `registrodevendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-23  9:29:25
