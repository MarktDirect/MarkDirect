-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Servidor: localhost:3306
-- Tiempo de generación: 03-03-2017 a las 13:18:22
-- Versión del servidor: 5.5.42
-- Versión de PHP: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

-- Base de datos: `MarkDirect`
--
DROP DATABASE IF EXISTS MarkDirect;
CREATE DATABASE IF NOT EXISTS MarkDirect;

USE MarkDirect;
-- --------------------------------------------------------


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admins`
--

CREATE TABLE `admins` (
  `adminId` int(11) NOT NULL,
  `admin` varchar(45) NOT NULL,
  `adminPassword` varchar(45) NOT NULL,
  `adminEmail` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `admins`
--

INSERT INTO `admins` (`adminId`, `admin`, `adminPassword`, `adminEmail`) VALUES
(1, 'pepe', '12345', '1@gmail.com'),
(2, 'juan', '12345', '2@gmail.com'),
(3, 'cristian', '12345', '3@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centers`
--

CREATE TABLE `centers` (
  `centerId` int(11) NOT NULL,
  `centerDescription` varchar(45) NOT NULL,
  `center_adminId` int(11) DEFAULT '1',
  `centerName` varchar(45) DEFAULT NULL,
  `centerAddres` varchar(45) DEFAULT NULL,
  `centerType` varchar(45) DEFAULT NULL,
  `centerSubtype` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `centers`
--

INSERT INTO `centers` (`centerId`, `centerDescription`, `center_adminId`, `centerName`, `centerAddres`, `centerType`, `centerSubtype`) VALUES
(1, 'mediamarkt', 1, NULL, NULL, NULL, NULL),
(2, 'telefonica', 2, NULL, NULL, NULL, NULL),
(3, 'aaaa', 1, 'hola', 'aaaa', 'aaaa', 'aaaa'),
(4, 'aaaaa', 1, 'aaa', 'aaaa', 'aaaaaa', 'aaaaa'),
(5, 'aaaa', 1, 'tienda a', 'aaaaaa', 'aaaa', 'aaaaa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centerspromos`
--

CREATE TABLE `centerspromos` (
  `centerpromoId` int(11) NOT NULL,
  `centerpromo_centerId` int(11) DEFAULT NULL,
  `centerpromo_promotId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `centerspromos`
--

INSERT INTO `centerspromos` (`centerpromoId`, `centerpromo_centerId`, `centerpromo_promotId`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `controlzones`
--

CREATE TABLE `controlzones` (
  `controlzoneId` int(11) NOT NULL,
  `controlzoneMajor` varchar(45) DEFAULT NULL,
  `controlzoneMinor` varchar(45) DEFAULT NULL,
  `controlzoneEmplacement` varchar(45) DEFAULT NULL,
  `controlzone_centerId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `controlzones`
--

INSERT INTO `controlzones` (`controlzoneId`, `controlzoneMajor`, `controlzoneMinor`, `controlzoneEmplacement`, `controlzone_centerId`) VALUES
(1, '10', '1', 'entrada', 1),
(2, '10', '1', 'entrada', 2),
(3, '1', '22', 'aaaaa', 1),
(4, '3', '456', 'aaaaaa', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promos`
--

CREATE TABLE `promos` (
  `promoId` int(11) NOT NULL,
  `promoName` varchar(45) DEFAULT NULL,
  `promoDescription` varchar(300) DEFAULT NULL,
  `promoSince` date DEFAULT NULL,
  `promoTo` date DEFAULT NULL,
  `promoState` tinyint(1) DEFAULT NULL,
  `promoCreate` datetime DEFAULT NULL,
  `promoImage` varchar(300) DEFAULT NULL,
  `promoMinAge` int(11) DEFAULT '0',
  `promoMaxAge` int(11) DEFAULT '99',
  `promoGen` varchar(5) DEFAULT 'Todos',
  `promo_controlzoneId` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `promos`
--

INSERT INTO `promos` (`promoId`, `promoName`, `promoDescription`, `promoSince`, `promoTo`, `promoState`, `promoCreate`, `promoImage`, `promoMinAge`, `promoMaxAge`, `promoGen`, `promo_controlzoneId`) VALUES
(1, 'movil', 'ahorrativo', '2016-01-10', '2016-03-20', 0, '2016-05-20 00:00:00', NULL, 12, 25, 'H', 1),
(2, 'camara', 'oferta', '2016-04-10', '2016-05-20', 1, '2016-07-20 00:00:00', NULL, 18, 25, 'M', 1),
(5, 'promo prueba', 'promo prueba', '2016-03-23', '2017-07-06', 0, '2017-02-03 10:16:26', 'blablablabla', 12, 18, 'M', 0),
(6, 'promo prueba 2', 'promo prueba 2', '2015-03-17', '2017-04-19', 0, '2017-02-03 10:19:34', 'blablablabla', 12, 12, 'H', 0),
(7, 'promo prueba 3', 'promo prueba 3', '2014-07-12', '2017-12-28', 0, '2017-02-03 10:22:36', 'blablablabla', 16, 29, 'M', 1),
(8, 'promo prueba 4', 'promo prueba 4', '2012-11-12', '2017-07-25', 0, '2017-02-03 10:25:35', 'blablabla', 24, 29, 'M', 2),
(9, 'promo prueba 5', 'promo prueba 5', '2011-11-12', '2018-12-03', 0, '2017-02-03 10:33:15', 'img', 34, 38, 'M', 1),
(10, 'promo prueba 6', 'promo prueba 6', '2013-12-12', '2019-09-15', 0, '2017-02-03 10:36:57', 'img', 21, 29, 'M', 1),
(11, 'promo prueba 7', 'promo prueba 7', '2014-07-31', '2021-12-12', 0, '2017-02-03 10:41:37', 'img', 12, 19, 'M', 1),
(12, 'prueba 9', 'prueba 9', '2013-03-12', '2021-12-11', 0, '2017-02-03 10:43:24', 'img', 12, 19, 'Todos', 0),
(13, 'promo 10', 'promo 10', '2012-12-12', '2021-12-12', 0, '2017-02-03 10:44:13', 'img', 12, 19, 'M', 1),
(14, 'promo 12', 'promo 12', '2012-12-12', '2034-12-12', 1, '2017-02-03 10:48:56', 'img', 1, 8, 'M', 1),
(15, 'promopromo', 'promo promo', '2012-12-01', '2017-12-21', 1, '2017-02-03 11:00:44', 'img', 12, 18, 'M', 1),
(16, 'promo13', '12345', '2012-12-12', '2121-02-12', 1, '2017-02-03 12:37:14', 'img', 12, 18, 'M', 1),
(17, 'promo final', 'final', '2012-02-12', '2018-03-17', 1, '2017-02-03 13:18:04', 'aaaaaaa', 34, 39, 'Todos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promosusers`
--

CREATE TABLE `promosusers` (
  `promouserId` int(11) NOT NULL,
  `promouser_promoId` int(11) NOT NULL,
  `promouser_userId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `promosusers`
--

INSERT INTO `promosusers` (`promouserId`, `promouser_promoId`, `promouser_userId`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `userEmail` varchar(45) NOT NULL,
  `userGen` varchar(1) NOT NULL,
  `userBorn` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`userId`, `userEmail`, `userGen`, `userBorn`) VALUES
(1, 'juan@gmail.com', 'h', '1992-03-15'),
(2, 'cris@gmail.com', 'm', '1990-03-02');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`adminId`),
  ADD UNIQUE KEY `user_UNIQUE` (`admin`),
  ADD UNIQUE KEY `adminEmail_UNIQUE` (`adminEmail`);

--
-- Indices de la tabla `centers`
--
ALTER TABLE `centers`
  ADD PRIMARY KEY (`centerId`),
  ADD KEY `center_adminId` (`center_adminId`);

--
-- Indices de la tabla `centerspromos`
--
ALTER TABLE `centerspromos`
  ADD PRIMARY KEY (`centerpromoId`),
  ADD KEY `centerpromo_centerId` (`centerpromo_centerId`),
  ADD KEY `centerpromo_promoId` (`centerpromo_promotId`);

--
-- Indices de la tabla `controlzones`
--
ALTER TABLE `controlzones`
  ADD PRIMARY KEY (`controlzoneId`),
  ADD KEY `controlzone_centerId` (`controlzone_centerId`);

--
-- Indices de la tabla `promos`
--
ALTER TABLE `promos`
  ADD PRIMARY KEY (`promoId`);

--
-- Indices de la tabla `promosusers`
--
ALTER TABLE `promosusers`
  ADD PRIMARY KEY (`promouserId`),
  ADD KEY `promouser_promoId` (`promouser_promoId`),
  ADD KEY `promouser_userId` (`promouser_userId`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `admins`
--
ALTER TABLE `admins`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `centers`
--
ALTER TABLE `centers`
  MODIFY `centerId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `centerspromos`
--
ALTER TABLE `centerspromos`
  MODIFY `centerpromoId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `controlzones`
--
ALTER TABLE `controlzones`
  MODIFY `controlzoneId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `promos`
--
ALTER TABLE `promos`
  MODIFY `promoId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `promosusers`
--
ALTER TABLE `promosusers`
  MODIFY `promouserId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `centers`
--
ALTER TABLE `centers`
  ADD CONSTRAINT `center_adminId` FOREIGN KEY (`center_adminId`) REFERENCES `admins` (`adminId`);

--
-- Filtros para la tabla `centerspromos`
--
ALTER TABLE `centerspromos`
  ADD CONSTRAINT `centerpromo_centerId` FOREIGN KEY (`centerpromo_centerId`) REFERENCES `centers` (`centerId`),
  ADD CONSTRAINT `centerpromo_promoId` FOREIGN KEY (`centerpromo_promotId`) REFERENCES `promos` (`promoId`);

--
-- Filtros para la tabla `controlzones`
--
ALTER TABLE `controlzones`
  ADD CONSTRAINT `controlzone_centerId` FOREIGN KEY (`controlzone_centerId`) REFERENCES `centers` (`centerId`);

--
-- Filtros para la tabla `promosusers`
--
ALTER TABLE `promosusers`
  ADD CONSTRAINT `promouser_promoId` FOREIGN KEY (`promouser_promoId`) REFERENCES `promos` (`promoId`),
  ADD CONSTRAINT `promouser_userId` FOREIGN KEY (`promouser_userId`) REFERENCES `users` (`userId`);
