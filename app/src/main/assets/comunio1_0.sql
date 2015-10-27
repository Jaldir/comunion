-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2015 a las 13:02:48
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `comunio1.0`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bidding_list`
--

CREATE TABLE IF NOT EXISTS `bidding_list` (
  `Email` varchar(65) NOT NULL,
  `ApeName` varchar(35) NOT NULL,
  `Date` date NOT NULL,
  `Quantity` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `football_players`
--

CREATE TABLE IF NOT EXISTS `football_players` (
  `ApeName` varchar(65) NOT NULL,
  `Age` int(2) NOT NULL,
  `Nation` varchar(20) NOT NULL,
  `Team` varchar(35) DEFAULT NULL,
  `Rol` varchar(15) NOT NULL,
  `Price` int(11) NOT NULL,
  `Market Status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `football_players`
--

INSERT INTO `football_players` (`ApeName`, `Age`, `Nation`, `Team`, `Rol`, `Price`, `Market Status`) VALUES
('Agüero', 25, 'Argentina', NULL, 'Delantero', 10000100, 0),
('Arbeloa', 29, 'España', NULL, 'Cono', 100, 0),
('Arda', 29, 'Turquia', NULL, 'Medio', 10000000, 0),
('De Gea', 26, 'España', NULL, 'Portero', 8500000, 0),
('Diego', 30, 'Brasil', NULL, 'Medio', 9000000, 0),
('Gabi', 30, 'España', NULL, 'Medio', 3500000, 0),
('Godin', 29, 'Uruguay', NULL, 'Defensa', 5000000, 0),
('Griezman', 22, 'Francia', NULL, 'Delantero', 10000000, 0),
('Molina', 38, 'España', NULL, 'Portero', 7000000, 0),
('Perea', 30, 'Colombia', NULL, 'Defensa', 900000, 0),
('Torres', 28, 'España', NULL, 'Delantero', 5000000, 1),
('Ujfalusi', 32, 'Rep Checa', NULL, 'Defensa', 3200000, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `players`
--

CREATE TABLE IF NOT EXISTS `players` (
  `Email` varchar(35) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Password` varchar(5) NOT NULL,
  `Team Name` varchar(35) NOT NULL,
  `Total Score` int(3) NOT NULL,
  `Last Score` int(3) NOT NULL,
  `Cash` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `players`
--

INSERT INTO `players` (`Email`, `Name`, `Password`, `Team Name`, `Total Score`, `Last Score`, `Cash`) VALUES
('jugador1@comunio.es', 'Jugador1', '123', 'Uno FC', 0, 0, 30000000),
('jugador2@comunio.es', 'Jugador2', '321', 'Dos FC', 0, 0, 30000000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bidding_list`
--
ALTER TABLE `bidding_list`
 ADD PRIMARY KEY (`Email`(1)), ADD KEY `Email` (`Email`);

--
-- Indices de la tabla `football_players`
--
ALTER TABLE `football_players`
 ADD PRIMARY KEY (`ApeName`);

--
-- Indices de la tabla `players`
--
ALTER TABLE `players`
 ADD PRIMARY KEY (`Email`), ADD UNIQUE KEY `Name` (`Name`,`Team Name`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bidding_list`
--
ALTER TABLE `bidding_list`
ADD CONSTRAINT `bidding_list_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `players` (`Email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
