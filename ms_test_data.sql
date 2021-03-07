-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2021 at 02:55 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `omdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `ms_test_data`
--

CREATE TABLE `ms_test_data` (
  `native_name` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `movie_name` varchar(100) NOT NULL,
  `year_made` year(4) NOT NULL,
  `execution_status` varchar(100) NOT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ms_test_data`
--

INSERT INTO `ms_test_data` (`native_name`, `movie_name`, `title`, `year_made`, `execution_status`) VALUES
('The Greatest Showman', 'The Greatest Showman', 'A Million Dreams (Reprise)', 2017, 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Come Alive', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'The Other Side', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Never Enough', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'This Is Me', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Rewrite the Stars', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Tightrope', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Never Enough (Reprise)', 2017,'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'From Now On', 2017,'to be processed'),
('Chicago', 'Chicago ', 'Overture / All That Jazz', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Funny Honey', 2002,'to be processed'),
('Chicago', 'Chicago ', 'When You\'re Good to Mama', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Cell Block Tango', 2002,'to be processed'),
('Chicago', 'Chicago ', 'All I Care About', 2002,'to be processed'),
('Chicago', 'Chicago ', 'We Both Reached for the Gun', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Roxie', 2002,'to be processed'),
('Chicago', 'Chicago ', 'I Can\'t Do It Alone', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Mister Cellophane', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Razzle Dazzle', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Class', 2002,'to be processed'),
('Chicago', 'Chicago ', 'A Tap Dance', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Nowadays', 2002,'to be processed'),
('Chicago', 'Chicago ', 'Nowadays / Hot Honey Rag ', 2002,'to be processed'),
('Chicago', 'Chicago ', 'I Move On', 2002,'to be processed'),
('Chicago', 'Chicago ', 'All That Jazz (reprise)', 2002,'to be processed');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
