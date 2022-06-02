-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2022 at 06:45 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buah_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `buah`
--

CREATE TABLE `buah` (
  `NamaBuah` varchar(50) NOT NULL,
  `TujuanDistribusi` varchar(20) NOT NULL,
  `HargaPerKilo` double NOT NULL,
  `BanyakDistribusi` double NOT NULL,
  `TotalHarga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buah`
--

INSERT INTO `buah` (`NamaBuah`, `TujuanDistribusi`, `HargaPerKilo`, `BanyakDistribusi`, `TotalHarga`) VALUES
('Alpukat Mentega', 'Yogyakarta', 21500, 20, 430000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buah`
--
ALTER TABLE `buah`
  ADD KEY `NamaBuah` (`NamaBuah`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
