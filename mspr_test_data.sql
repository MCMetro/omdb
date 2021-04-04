-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2021 at 11:08 PM
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
-- Table structure for table `mspr_test_data`
--

CREATE TABLE `mspr_test_data` (
  `native_name` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `movie_name` varchar(100) NOT NULL,
  `year_made` year(4) NOT NULL,
  `stage_name` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `execution_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mspr_test_data`
--

INSERT INTO `mspr_test_data` (`native_name`, `title`, `movie_name`, `year_made`, `stage_name`, `role`, `execution_status`) VALUES
('The Greatest Showman', 'A Million Dreams (Reprise)', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'Come Alive', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'The Other Side', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'Never Enough', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'This Is Me', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'Rewrite the Stars', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'Tightrope', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'Never Enough (Reprise)', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('The Greatest Showman', 'From Now On', 'The Greatest Showman', 2017, '', '', 'to be processed'),
('Chicago', 'Overture / All That Jazz', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Funny Honey', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'When You\'re Good to Mama', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Cell Block Tango', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'All I Care About', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'We Both Reached for the Gun', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Roxie', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'I Can\'t Do It Alone', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Mister Cellophane', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Razzle Dazzle', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Class', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'A Tap Dance', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Nowadays', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'Nowadays / Hot Honey Rag ', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'I Move On', 'Chicago ', 2002, '', '', 'to be processed'),
('Chicago', 'All That Jazz (reprise)', 'Chicago ', 2002, '', '', 'to be processed');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
