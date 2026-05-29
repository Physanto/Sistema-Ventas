-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: multibelleza
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Maquillaje'),(2,'Cuidado Facial'),(3,'Cuidado Capilar'),(4,'Perfumería'),(5,'Uñas'),(6,'Accesorios'),(7,'Skincare'),(8,'Barbería'),(9,'Cuidado Corporal'),(10,'Dermocosmética');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `carrera` varchar(20) NOT NULL,
  `calle` varchar(20) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `barrio` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'mamianpalta2@gmail.com','sebastian ','Mamian Palta','2005-04-28','17B','15a','40','La ladera'),(2,'Hernando10@gmail.com','hernando','Peña Izquierdo','2004-06-13','15B','12a','32','bello horizonte'),(3,'Juanerazo@gmail.com','Juan david','erazo meneses','2007-07-12','8a','15b','14','las americas'),(4,'Manuelesco@gmail.com','manuel','escobar figueroa','2003-12-23','7a','8a','32','pomona'),(5,'daniel@gmail.com','daniel felipe','quintero ochoa','2004-03-21','7b','12a','15','la ladera'),(6,'andrea@gmail.com','andrea','gomez lino','2004-12-21','5a','16b','40','la maria'),(7,'luisa@gmail.com','luisa','botina noguera','2002-05-12','5a','15b','23','lomas de granada'),(8,'ivan@gmail.com','iivan stive','cordoba','1999-07-30','2b','17a','15','benito juarez'),(9,'sofia@gmaill.com','loren sofia','flores bolaños','2000-06-13','7b','6b','36','obando'),(10,'john@gmailcom','john','frusciante lopez','1992-05-23','9a','8b','41','la pradera ');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `fecha_compra` date NOT NULL,
  `numero_factura` varchar(10) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `id_proveedor` int NOT NULL,
  `id_usuario_sistema` int NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_proveedor_compra_idx` (`id_proveedor`),
  KEY `id_usuario_sistema_idx` (`id_usuario_sistema`),
  CONSTRAINT `id_proveedor_compra` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`),
  CONSTRAINT `id_usuario_sistema` FOREIGN KEY (`id_usuario_sistema`) REFERENCES `usuario_sistema` (`id_usuario_sistema`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2026-05-01','FAC001',450000.00,1,3),(2,'2026-05-02','FAC002',320000.00,2,3),(3,'2026-05-03','FAC003',510000.00,3,3),(4,'2026-05-04','FAC004',280000.00,4,3),(5,'2026-05-05','FAC005',600000.00,5,3),(6,'2026-05-06','FAC006',470000.00,6,3),(7,'2026-05-07','FAC007',390000.00,7,3),(8,'2026-05-08','FAC008',730000.00,8,3),(9,'2026-05-09','FAC009',260000.00,9,3),(10,'2026-05-10','FAC010',540000.00,10,3);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra` (
  `id_detalle_compra` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `precio_base` int NOT NULL,
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id_detalle_compra`),
  KEY `id_compra_idx` (`id_compra`),
  KEY `id_producto_detalle_compra_idx` (`id_producto`),
  CONSTRAINT `id_compra` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `id_producto_detalle_compra` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
INSERT INTO `detalle_compra` VALUES (1,10,45000,1,1),(2,8,40000,2,2),(3,15,34000,3,3),(4,7,38000,4,6),(5,12,50000,5,4),(6,10,47000,6,8),(7,9,43000,7,5),(8,14,52000,8,9),(9,6,43000,9,7),(10,11,49000,10,10);
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_venta` (
  `id_detalle_venta` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `precio_venta` decimal(10,2) NOT NULL,
  `id_producto` int NOT NULL,
  `id_venta` int NOT NULL,
  PRIMARY KEY (`id_detalle_venta`),
  KEY `id_producto_detalle_venta_idx` (`id_producto`),
  KEY `id_venta_idx` (`id_venta`),
  CONSTRAINT `id_producto_detalle_venta` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `id_venta` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,2,45000.00,1,1),(2,2,28000.00,2,2),(3,1,35000.00,3,3),(4,1,120000.00,4,4),(5,1,55000.00,5,5),(6,1,40000.00,6,6),(7,1,32000.00,7,7),(8,1,47000.00,8,8),(9,2,25000.00,9,9),(10,2,38000.00,10,10);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `stock_actual` int NOT NULL,
  `precio_venta` decimal(10,2) NOT NULL,
  `stock_minimo` int NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_categoria_idx` (`id_categoria`),
  CONSTRAINT `id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Base Líquida Matte',30,45000.00,5,'2027-01-15','Estante A1',1),(2,'Corrector HD',25,28000.00,5,'2027-03-10','Estante A2',1),(3,'Shampoo Reparador',40,35000.00,8,'2026-11-20','Estante B1',3),(4,'Perfume Floral',15,120000.00,3,'2028-05-01','Vitrina P1',4),(5,'Kit de Uñas Gel',20,55000.00,4,'2027-09-14','Estante C1',5),(6,'Crema Hidratante',50,40000.00,10,'2027-02-22','Estante D1',7),(7,'Aceite para Barba',18,32000.00,3,'2026-12-12','Estante E1',8),(8,'Protector Solar FPS 50',35,47000.00,7,'2027-08-30','Estante D2',10),(9,'Labial Mate Rojo',60,25000.00,15,'2027-06-17','Estante A3',1),(10,'Exfoliante Corporal',28,38000.00,6,'2027-04-11','Estante F1',9);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id_proveedor` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `carrera` varchar(20) NOT NULL,
  `calle` varchar(20) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `barrio` varchar(20) NOT NULL,
  `rut` varchar(40) NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'proveedor1@gmail.com','Carlos','Ramírez','1985-03-12','10A','15A','22','Centro','900100100-1'),(2,'proveedor2@gmail.com','Andrea','López','1990-07-19','8B','10B','18','La Paz','900100100-2'),(3,'proveedor3@gmail.com','Miguel','Torres','1982-01-25','7C','9A','33','Modelo','900100100-3'),(4,'proveedor4@gmail.com','Laura','Fernández','1995-11-02','5A','12B','44','Santa Elena','900100100-4'),(5,'proveedor5@gmail.com','Julián','Martínez','1988-09-13','4B','20A','12','Campestre','900100100-5'),(6,'proveedor6@gmail.com','Valentina','Muñoz','1991-04-09','6A','18C','50','Mirador','900100100-6'),(7,'proveedor7@gmail.com','David','Castro','1984-06-30','11A','7B','41','La Esmeralda','900100100-7'),(8,'proveedor8@gmail.com','Paula','Gómez','1993-12-18','9C','6A','28','San José','900100100-8'),(9,'proveedor9@gmail.com','Camilo','Rojas','1987-08-14','3B','11A','19','Los Pinos','900100100-9'),(10,'proveedor10@gmail.com','Natalia','Díaz','1992-10-22','2A','14B','31','La Rivera','900100100-10');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_cliente`
--

DROP TABLE IF EXISTS `telefono_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono_cliente` (
  `telefono` varchar(30) NOT NULL,
  `id_cliente` int NOT NULL,
  KEY `id_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_cliente`
--

LOCK TABLES `telefono_cliente` WRITE;
/*!40000 ALTER TABLE `telefono_cliente` DISABLE KEYS */;
INSERT INTO `telefono_cliente` VALUES ('3201000001',1),('3201000002',2),('3201000003',3),('3201000004',4),('3201000005',5),('3201000006',6),('3201000007',7),('3201000008',8),('3201000009',9),('3201000010',10);
/*!40000 ALTER TABLE `telefono_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_proveedor`
--

DROP TABLE IF EXISTS `telefono_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono_proveedor` (
  `telefono` varchar(30) NOT NULL,
  `id_proveedor` int NOT NULL,
  KEY `id_proveedor_idx` (`id_proveedor`),
  CONSTRAINT `id_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_proveedor`
--

LOCK TABLES `telefono_proveedor` WRITE;
/*!40000 ALTER TABLE `telefono_proveedor` DISABLE KEYS */;
INSERT INTO `telefono_proveedor` VALUES ('3001111111',1),('3002222222',2),('3003333333',3),('3004444444',4),('3005555555',5),('3006666666',6),('3007777777',7),('3008888888',8),('3009999999',9),('3010000000',10);
/*!40000 ALTER TABLE `telefono_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_usuario`
--

DROP TABLE IF EXISTS `telefono_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono_usuario` (
  `telefono` varchar(30) NOT NULL,
  `id_usuario` int NOT NULL,
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario_sistema` (`id_usuario_sistema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_usuario`
--

LOCK TABLES `telefono_usuario` WRITE;
/*!40000 ALTER TABLE `telefono_usuario` DISABLE KEYS */;
INSERT INTO `telefono_usuario` VALUES ('3125550001',3),('3125550002',3);
/*!40000 ALTER TABLE `telefono_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_sistema`
--

DROP TABLE IF EXISTS `usuario_sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_sistema` (
  `id_usuario_sistema` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `carrera` varchar(20) NOT NULL,
  `calle` varchar(20) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `barrio` varchar(20) NOT NULL,
  `rol` varchar(15) NOT NULL,
  `contraseña` varchar(60) NOT NULL,
  PRIMARY KEY (`id_usuario_sistema`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_sistema`
--

LOCK TABLES `usuario_sistema` WRITE;
/*!40000 ALTER TABLE `usuario_sistema` DISABLE KEYS */;
INSERT INTO `usuario_sistema` VALUES (3,'multibelleza@gmail.com','Francy','Meneses','1968-09-22','No aplica','6','12-55','Valencia','Admin','Hijos2112@');
/*!40000 ALTER TABLE `usuario_sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total_venta` decimal(10,2) NOT NULL,
  `metodo_pago` varchar(30) NOT NULL,
  `id_cliente` int NOT NULL,
  `id_usuario_sistema` int NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_cliente_venta_idx` (`id_cliente`),
  KEY `id_usuario_sistema_venta_idx` (`id_usuario_sistema`),
  CONSTRAINT `id_cliente_venta` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `id_usuario_sistema_venta` FOREIGN KEY (`id_usuario_sistema`) REFERENCES `usuario_sistema` (`id_usuario_sistema`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2026-05-11',90000.00,'Efectivo',1,3),(2,'2026-05-11',56000.00,'Tarjeta',2,3),(3,'2026-05-12',35000.00,'Transferencia',3,3),(4,'2026-05-12',120000.00,'Efectivo',4,3),(5,'2026-05-13',55000.00,'Tarjeta',5,3),(6,'2026-05-13',40000.00,'Transferencia',6,3),(7,'2026-05-14',32000.00,'Efectivo',7,3),(8,'2026-05-14',47000.00,'Tarjeta',8,3),(9,'2026-05-15',50000.00,'Transferencia',9,3),(10,'2026-05-15',76000.00,'Efectivo',10,3);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-29 11:37:02
