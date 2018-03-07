-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2018 at 11:03 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_simplecrud`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `fullname`, `city`, `status`) VALUES
(1, 'des', 'b02dd1f9ddf82871026edd1786c47ed3', 'boleh', 'bandung', 'bagus'),
(2, 'des', 'b02dd1f9ddf82871026edd1786c47ed3', 'boleh', 'bandung', 'bagus200'),
(3, 'destantifw', 'f2a4ed8ac88e73a921cde5cc43a423bc', 'destanti fatwakhyuni', 'garut', 'siang'),
(4, 'coba', '0a843cd79f11e767f847038735d6ded5', 'quantus', 'bandung', 'kantor'),
(5, 'coba', '0a843cd79f11e767f847038735d6ded5', 'quantus', 'bandung', 'kantor'),
(6, 'aaa', '47bce5c74f589f4867dbd57e9ca9f808', 'aaaa', 'aaa', 'aaa'),
(7, 'aaa', '47bce5c74f589f4867dbd57e9ca9f808', 'aaaa', 'aaa', 'aaa'),
(8, 'des', '4e4d6c332b6fe62a63afe56171fd3725', 'destan', 'bandung', 'q'),
(9, 'des', '4e4d6c332b6fe62a63afe56171fd3725', 'destan', 'bandung', 'q'),
(10, 'des', '4e4d6c332b6fe62a63afe56171fd3725', 'destanti', 'bandung', '200'),
(11, 'coba', 'tes', 'tes', 'tes', 'tes'),
(12, 'destanti', 'coba', 'tes', 'bandung', 'coba');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
