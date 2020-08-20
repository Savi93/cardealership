  -- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 07, 2017 at 01:31 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cardealershipdb`
--

CREATE DATABASE IF NOT EXISTS `cardealershipdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cardealershipdb`;

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE IF NOT EXISTS `cars` (
  `brand` text NOT NULL,
  `model` text NOT NULL,
  `color` text NOT NULL,
  `hp` text NOT NULL,
  `year` text NOT NULL,
  `price` int(11) NOT NULL,
  `km` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`brand`, `model`, `color`, `hp`, `year`, `price`, `km`) VALUES
('Audi', 'A3', 'Grey', '170', '2009', 4000, 160500),
('BMW', '530', 'Black', '210', '2006', 7000, 210000),
('Fiat', 'Punto', 'Grey', '65', '2003', 3000, 150000),
('Opel', 'Antara', 'White', '150', '2010', 9000, 130000),
('Mercedes', 'C', 'White', '177', '2007', 8000, 90000),
('Audi', 'A6', 'Black', '170', '2006', 7000, 200000),
('Zastava', '101', 'Yellow', '45', '1989', 200, 300000),
('Seat', 'Leon', 'White', '150', '2008', 6000, 160000),
('Alfa Romeo', 'Giulia', 'White', '177', '2015', 25000, 40000),
('Alfa Romeo', '147', 'Black', '120', '2009', 4000, 140000),
('BMW', 'Serie 3', 'Black', '170', '2008', 6000, 130000),
('Opel', 'Corsa', 'Grey', '65', '2001', 1000, 200000),
('Lada', 'Niva', 'Green', '100', '2005', 2000, 120000),
('Yugo', 'Koral 55', 'Red', '45', '1985', 200, 350000),
('Ferrari', 'Testarossa', 'Red', '300', '1995', 55000, 90000),
('Range Rover', 'Evoque', 'White', '150', '2009', 25000, 170000),
('Alfa Romeo', '159', 'Brown', '170', '2009', 7000, 150000),
('Ford', 'Fiesta', 'Blue', '65', '2004', 3000, 140000),
('VW', 'Polo', 'Black', '100', '2006', 3000, 140000),
('Mercedes', 'Class A', 'Black', '120', '2007', 5000, 90000),
('Fiat', 'Palio', 'White', '65', '2001', 400, 140000),
('Fiat', 'Stilo', 'Grey', '115', '2003', 600, 200000),
('Toyota', 'Yaris', 'Yellow', '55', '2007', 2000, 120000),
('BMW', 'Serie 6', 'White', '177', '2007', 5000, 160000),
('Audi', 'A1', 'White', '65', '2009', 9000, 70000),
('Ford', 'Mustang', 'Red', '230', '1985', 25000, 80000),
('Fiat', 'Ulysse', 'Green', '115', '2001', 2500, 195000),
('Fiat', 'Panda', 'Yellow', '90', '2009', 3500, 75000),
('Mercedes', 'Class B', 'Black', '150', '2008', 6500, 145000),
('Škoda', 'Fabia', 'White', '120', '2008', 6000, 160000),
('Alfa Romeo', 'Giulietta', 'Black', '170', '2009', 6500, 140000),
('Fiat', 'Punto', 'White', '65', '2000', 2500, 124000),
('Audi', 'S3', 'Red', '230', '2002', 5000, 176000),
('Vespa', 'X', 'Blue', '50', '1995', 1300, 55000),
('Fiat', '500', 'Yellow', '120', '2008', 6000, 165000),
('Renault', 'Megane', 'Green', '120', '1999', 2000, 132000),
('Jeep', 'Compass', 'Blue', '140', '2010', 15000, 150000),
('Mazda', 'CX-5', 'Grey', '175', '2009', 17000, 68000),
('Volvo', 'XC60', 'Black', '115', '2006', 7500, 95000),
('Škoda', 'Rapid', 'Red', '120', '2015', 12000, 66000),
('Citroen', 'C3', 'White', '115', '2004', 5000, 44000),
('Porsche', '911', 'Red', '350', '2010', 130000, 44000),
('Renault', 'Twingo', 'Orange', '65', '2008', 3000, 75000),
('Iveco', 'Daily', 'White', '170', '2007', 8000, 120000),
('Ferrari', '458', 'Red', '570', '2006', 55000, 150000),
('Mercedes', 'SL 300', 'Grey', '230', '1992', 22000, 30000),
('Nissan', 'Qashqai', 'Grey', '131', '2013', 13000, 115000),
('Volkswagen', 'Passat 2.0', 'White', '140', '2013', 12000, 120000),
('Maserati', 'Levante', 'Black', '275', '2016', 74000, 7000),
('Ford', 'Kuga', 'Blue', '140', '2014', 18000, 89000),
('Renault', 'Scenic', 'Grey', '110', '2005', 5000, 77000),
('Fiat', 'Sedici', 'White', '135', '2013', 13000, 84000),
('Suzuki', 'Vitara', 'Black', '129', '2011', 14000, 73000),
('Opel', 'Mokka', 'White', '140', '2015', 17000, 19000),
('Ford', 'Focus', 'Grey', '110', '2010', 8000, 89000),
('BMW', '120XD', 'Black', '184', '2013', 20000, 97000),
('Mercedes', 'ML270', 'Black', '163', '2003', 6500, 180000),
('Volkswagen', 'Golf 3', 'Green', '90', '1998', 1000, 300000),
('Mini', 'One', 'Yellow', '75', '2004', 6000, 152000),
('Opel', 'Sintra', 'Green', '141', '1998', 1500, 180000),
('Subaru', 'Impreza', 'Red', '160', '2006', 5000, 160000),
('Land Rover', 'Freelander', 'Grey', '97', '2000', 4000, 192000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `name` text,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `password`) VALUES
('admin', 'admin'),
('david', '12345'),
('.test', '12345'),
('fjjj-', '12345');

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' IDENTIFIED BY 'admin' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0; 

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;