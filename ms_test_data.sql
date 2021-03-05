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
  `execution_status` varchar(100) NOT NULL,
  `movie_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ms_test_data`
--

INSERT INTO `ms_test_data` (`native_name`, `title`, `execution_status`, `movie_name`) VALUES
('The Greatest Showman', 'The Greatest Showman', 'A Million Dreams (Reprise)', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Come Alive', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'The Other Side', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Never Enough', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'This Is Me', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Rewrite the Stars', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Tightrope', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'Never Enough (Reprise)', 'to be processed'),
('The Greatest Showman', 'The Greatest Showman', 'From Now On', 'to be processed'),
('Chicago', 'Chicago ', 'Overture / All That Jazz', 'to be processed'),
('Chicago', 'Chicago ', 'Funny Honey', 'to be processed'),
('Chicago', 'Chicago ', 'When You\'re Good to Mama', 'to be processed'),
('Chicago', 'Chicago ', 'Cell Block Tango', 'to be processed'),
('Chicago', 'Chicago ', 'All I Care About', 'to be processed'),
('Chicago', 'Chicago ', 'We Both Reached for the Gun', 'to be processed'),
('Chicago', 'Chicago ', 'Roxie', 'to be processed'),
('Chicago', 'Chicago ', 'I Can\'t Do It Alone', 'to be processed'),
('Chicago', 'Chicago ', 'Mister Cellophane', 'to be processed'),
('Chicago', 'Chicago ', 'Razzle Dazzle', 'to be processed'),
('Chicago', 'Chicago ', 'Class', 'to be processed'),
('Chicago', 'Chicago ', 'A Tap Dance', 'to be processed'),
('Chicago', 'Chicago ', 'Nowadays', 'to be processed'),
('Chicago', 'Chicago ', 'Nowadays / Hot Honey Rag ', 'to be processed'),
('Chicago', 'Chicago ', 'I Move On', 'to be processed'),
('Chicago', 'Chicago ', 'All That Jazz (reprise)', 'to be processed');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
