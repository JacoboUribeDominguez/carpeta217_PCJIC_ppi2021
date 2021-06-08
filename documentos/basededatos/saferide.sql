-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: baoptpgbaex6r89omvkj-mysql.services.clever-cloud.com:3306
-- Generation Time: Jun 08, 2021 at 06:11 AM
-- Server version: 8.0.15-5
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baoptpgbaex6r89omvkj`
--

-- --------------------------------------------------------

--
-- Table structure for table `comentario`
--

CREATE TABLE `comentario` (
  `id_comentario` varchar(500) NOT NULL,
  `id_usuario` varchar(500) NOT NULL,
  `id_ruta` varchar(500) NOT NULL,
  `descripcion` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hurto`
--

CREATE TABLE `hurto` (
  `id_hurto` varchar(500) NOT NULL,
  `multimedia` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `modalidad` varchar(45) NOT NULL,
  `id_usuario` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `metrica`
--

CREATE TABLE `metrica` (
  `id_metrica` varchar(500) NOT NULL,
  `tiempo` float NOT NULL,
  `id_usuario` varchar(500) NOT NULL,
  `id_ruta` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `puntuacion_hurto`
--

CREATE TABLE `puntuacion_hurto` (
  `id_puntuacion_hurto` int(11) NOT NULL,
  `id_hurto` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_usuario` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `puntuacion_ruta`
--

CREATE TABLE `puntuacion_ruta` (
  `id_puntuacion_ruta` int(11) NOT NULL,
  `id_ruta` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_usuario` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `puntuacion_sendero`
--

CREATE TABLE `puntuacion_sendero` (
  `id_puntuacion_sendero` int(11) NOT NULL,
  `id_sendero` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_usuario` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ruta`
--

CREATE TABLE `ruta` (
  `id_ruta` varchar(500) NOT NULL,
  `multimedia` varchar(45) NOT NULL,
  `id_usuario` varchar(500) NOT NULL,
  `me_gusta` int(11) DEFAULT NULL,
  `ubicacion` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruta`
--

INSERT INTO `ruta` (`id_ruta`, `multimedia`, `id_usuario`, `me_gusta`, `ubicacion`) VALUES
('20210531210354255', 'imagenes/20210518190923320imgPrueba1.jpg', '20210518190923320', 10, 'Manrique - Buenos Aires'),
('20210531210358037', 'imagenes/20210518190923320imgPrueba1.jpg', '20210518190923320', 17, 'Bello - Castilla'),
('20210531210404742', 'imagenes/20210518190923320imgPrueba1.jpg', '20210518190923320', 0, 'Sabaneta - Poblado'),
('20210531210409507', 'imagenes/20210518190923320imgPrueba1.jpg', '20210518190923320', 0, 'Sabaneta - Poblado'),
('20210531210412555', 'imagenes/20210518190923320imgPrueba1.jpg', '20210518190923320', 0, 'Sabaneta - Poblado'),
('20210531210416046', 'imagenes/20210518190923320imgPrueba1.jpg', '20210518190923320', 0, 'Sabaneta - Poblado'),
('20210607195509352', 'imagenes/2021051819092332014.jpg', '20210518190923320', 0, 'Envigado - Niquía'),
('20210607205011577', 'imagenes/2021051819092332016.jpg', '20210518190923320', 0, 'cadas - dsadas'),
('20210607210306028', 'imagenes/20210518190923320hola.jpg', '20210518190923320', 0, 'itagui - belen');

-- --------------------------------------------------------

--
-- Table structure for table `sendero`
--

CREATE TABLE `sendero` (
  `id_sendero` varchar(500) NOT NULL,
  `multimedia` varchar(45) NOT NULL,
  `me_gusta` int(11) DEFAULT NULL,
  `id_usuario` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` varchar(500) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `usuario`, `correo`, `contraseña`) VALUES
('20210518190923320', 'Jacobo Uribe Dominguez', 'jakopapafrita', 'jako@gmail.com', '123'),
('20210604131613303', 'Luis Alejandro Calvo Alvarez', 'Offztinger', 'Offztinger@gmail.com', 'alejo0502'),
('20210604203620057632200', 'Juan David Velasquez Toro', 'ernasz12', 'juandavidvelasqueztoro@gmail.com', '271996savtasd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `comentario_usuario` (`id_usuario`),
  ADD KEY `comentario_ruta` (`id_ruta`);

--
-- Indexes for table `hurto`
--
ALTER TABLE `hurto`
  ADD PRIMARY KEY (`id_hurto`),
  ADD KEY `hurto_usuario` (`id_usuario`);

--
-- Indexes for table `metrica`
--
ALTER TABLE `metrica`
  ADD PRIMARY KEY (`id_metrica`),
  ADD KEY `ruta_metrica` (`id_ruta`),
  ADD KEY `usuario_metrica` (`id_usuario`);

--
-- Indexes for table `puntuacion_hurto`
--
ALTER TABLE `puntuacion_hurto`
  ADD PRIMARY KEY (`id_puntuacion_hurto`),
  ADD KEY `FK_puntuacion_hurto_hurto` (`id_hurto`),
  ADD KEY `FK_puntuacion_hurto_usuario` (`id_usuario`);

--
-- Indexes for table `puntuacion_ruta`
--
ALTER TABLE `puntuacion_ruta`
  ADD PRIMARY KEY (`id_puntuacion_ruta`),
  ADD KEY `FK_puntuacion_ruta_ruta` (`id_ruta`),
  ADD KEY `FK_puntuacion_ruta_usuario` (`id_usuario`);

--
-- Indexes for table `puntuacion_sendero`
--
ALTER TABLE `puntuacion_sendero`
  ADD PRIMARY KEY (`id_puntuacion_sendero`),
  ADD KEY `FK_puntuacion_sendero_sendero` (`id_sendero`),
  ADD KEY `FK_puntuacion_sendero_usuario` (`id_usuario`);

--
-- Indexes for table `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`id_ruta`),
  ADD KEY `ruta_publicada` (`id_usuario`);

--
-- Indexes for table `sendero`
--
ALTER TABLE `sendero`
  ADD PRIMARY KEY (`id_sendero`),
  ADD KEY `sendero_usuario` (`id_usuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `puntuacion_hurto`
--
ALTER TABLE `puntuacion_hurto`
  MODIFY `id_puntuacion_hurto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `puntuacion_ruta`
--
ALTER TABLE `puntuacion_ruta`
  MODIFY `id_puntuacion_ruta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `puntuacion_sendero`
--
ALTER TABLE `puntuacion_sendero`
  MODIFY `id_puntuacion_sendero` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ruta` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`),
  ADD CONSTRAINT `comentario_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Constraints for table `hurto`
--
ALTER TABLE `hurto`
  ADD CONSTRAINT `hurto_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Constraints for table `metrica`
--
ALTER TABLE `metrica`
  ADD CONSTRAINT `ruta_metrica` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`),
  ADD CONSTRAINT `usuario_metrica` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Constraints for table `puntuacion_hurto`
--
ALTER TABLE `puntuacion_hurto`
  ADD CONSTRAINT `FK_puntuacion_hurto_hurto` FOREIGN KEY (`id_hurto`) REFERENCES `hurto` (`id_hurto`),
  ADD CONSTRAINT `FK_puntuacion_hurto_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Constraints for table `puntuacion_ruta`
--
ALTER TABLE `puntuacion_ruta`
  ADD CONSTRAINT `FK_puntuacion_ruta_ruta` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`),
  ADD CONSTRAINT `FK_puntuacion_ruta_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `ruta` (`id_usuario`);

--
-- Constraints for table `puntuacion_sendero`
--
ALTER TABLE `puntuacion_sendero`
  ADD CONSTRAINT `FK_puntuacion_sendero_sendero` FOREIGN KEY (`id_sendero`) REFERENCES `sendero` (`id_sendero`),
  ADD CONSTRAINT `FK_puntuacion_sendero_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Constraints for table `ruta`
--
ALTER TABLE `ruta`
  ADD CONSTRAINT `ruta_publicada` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Constraints for table `sendero`
--
ALTER TABLE `sendero`
  ADD CONSTRAINT `sendero_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
