-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2022 at 08:58 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devices_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `dep_id` int(11) NOT NULL,
  `department` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`dep_id`, `department`) VALUES
(117, '1112'),
(116, 'النظم'),
(114, 'تكهين'),
(115, 'يي');

-- --------------------------------------------------------

--
-- Table structure for table `departments_offices`
--

CREATE TABLE `departments_offices` (
  `id` int(11) NOT NULL,
  `parent_department_id` int(11) NOT NULL,
  `sub_department_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `serial_number` varchar(20) NOT NULL,
  `current_department_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `model_id` int(11) NOT NULL,
  `adding_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`id`, `serial_number`, `current_department_id`, `name`, `model_id`, `adding_timestamp`) VALUES
(464, 'YKAM147890', 116, '11', 53, '2022-11-15 18:13:04'),
(465, 'YKAM147015', 116, '1', 53, '2022-11-15 18:13:04'),
(466, 'YKAM147996', 116, '1', 53, '2022-11-15 18:13:04'),
(467, 'TRF338099W', 116, '1', 54, '2022-11-15 18:13:04'),
(468, 'TRF33809BT', 116, '1', 54, '2022-11-15 18:13:04'),
(469, 'TRF33809CC', 116, '11', 54, '2022-11-15 18:13:04'),
(470, 'SCZC0112M04', 116, '1', 55, '2022-11-15 18:13:04'),
(471, 'SCZC0112M0Z', 116, '1', 55, '2022-11-15 18:13:04'),
(472, 'SCZC0112M3P', 116, '1', 55, '2022-11-15 18:13:04'),
(473, '9P41NV1', 116, '1', 56, '2022-11-15 18:13:04'),
(474, '9W6ZMV1', 116, '1', 56, '2022-11-15 18:13:04'),
(475, '717ZMV1', 116, '1', 56, '2022-11-15 18:13:04'),
(476, 'YLJC006904', 116, 'n', 57, '2022-11-15 18:13:04'),
(477, 'YLFK015782', 116, 'سيرفر منظومة الإمتحانات', 58, '2022-11-15 18:13:04'),
(478, 'YLFK015755', 116, 'سيرفر منظومة الإمتحانات', 58, '2022-11-15 18:13:04'),
(479, 'CZC0404SLN', 116, '123.0', 59, '2022-11-15 18:13:04'),
(480, 'PHCPH50181', 116, '124.0', 60, '2022-11-15 18:13:04'),
(481, 'PHCPB47454', 116, '125.0', 60, '2022-11-15 18:13:04'),
(482, 'PHKBD42197', 116, '126.0', 61, '2022-11-15 18:13:04'),
(483, 'PHKBD42318', 116, '127.0', 61, '2022-11-15 18:13:04'),
(484, 'CNCJN80422', 116, '128.0', 62, '2022-11-15 18:13:04'),
(485, 'CNCJN77346', 116, '129.0', 62, '2022-11-15 18:13:04'),
(486, 'CNCJ871296', 116, '130.0', 62, '2022-11-15 18:13:04'),
(487, 'PVZZ001725', 116, '131.0', 63, '2022-11-15 18:13:04'),
(488, 'CN43B3M0S3', 116, '132.0', 64, '2022-11-15 18:13:04'),
(489, 'CN2AFAD0CR', 116, '133.0', 65, '2022-11-15 18:13:04'),
(490, 'CNU2070KMW', 116, '134.0', 66, '2022-11-15 18:13:04'),
(491, 'F3KE03700', 116, '135.0', 67, '2022-11-15 18:13:04'),
(492, 'F3KE03561', 116, '136.0', 67, '2022-11-15 18:13:04'),
(493, 'F3KE03508', 116, '137.0', 67, '2022-11-15 18:13:04'),
(494, '010', 116, '010', 54, '2022-11-15 18:19:32');

-- --------------------------------------------------------

--
-- Table structure for table `devices_brands`
--

CREATE TABLE `devices_brands` (
  `brand_id` int(11) NOT NULL,
  `brand` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `devices_brands`
--

INSERT INTO `devices_brands` (`brand_id`, `brand`) VALUES
(47, 'DELL'),
(48, 'EPSON'),
(45, 'Fujitsu'),
(49, 'HITACHI'),
(46, 'HP');

-- --------------------------------------------------------

--
-- Table structure for table `devices_models`
--

CREATE TABLE `devices_models` (
  `model_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `model` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `devices_models`
--

INSERT INTO `devices_models` (`model_id`, `brand_id`, `type_id`, `model`) VALUES
(53, 45, 14, 'Siemens'),
(54, 46, 14, 'Core i5'),
(55, 46, 14, 'Core 2'),
(56, 47, 14, 'dell'),
(57, 45, 14, 'Esprimo '),
(58, 45, 15, 'single core'),
(59, 46, 14, 'quad core 500 B'),
(60, 46, 16, '402.0'),
(61, 46, 16, '400.0'),
(62, 46, 16, '2055.0'),
(63, 46, 16, 'ألوان'),
(64, 48, 17, 'A3'),
(65, 46, 17, 'A4 scanjet'),
(66, 46, 18, 'PROBOOK 4530S'),
(67, 49, 19, 'بروجكتور');

-- --------------------------------------------------------

--
-- Table structure for table `devices_transactions`
--

CREATE TABLE `devices_transactions` (
  `trans_id` int(11) NOT NULL,
  `device_id` int(11) NOT NULL,
  `current_department_id` int(11) NOT NULL,
  `distination_department_id` int(11) NOT NULL,
  `receiver_name` varchar(100) NOT NULL,
  `sender_name` varchar(100) NOT NULL,
  `trans_timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `transaction_reason` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `devices_transactions`
--

INSERT INTO `devices_transactions` (`trans_id`, `device_id`, `current_department_id`, `distination_department_id`, `receiver_name`, `sender_name`, `trans_timestamp`, `transaction_reason`) VALUES
(46, 476, 115, 116, 'n', 'n', '2022-11-15 18:15:17', 'n'),
(47, 475, 115, 116, '1', '1', '2022-11-15 18:15:38', '1'),
(48, 474, 115, 116, '1', '1', '2022-11-15 18:15:45', '1'),
(49, 473, 115, 116, '1', '1', '2022-11-15 18:15:51', '1'),
(50, 472, 115, 116, '1', '1', '2022-11-15 18:15:59', '1'),
(51, 471, 115, 116, '1', '1', '2022-11-15 18:16:06', '1'),
(52, 470, 115, 116, '1', '1', '2022-11-15 18:16:15', '1'),
(53, 469, 115, 116, '1', '1', '2022-11-15 18:16:24', '1'),
(54, 468, 115, 116, '11', '1', '2022-11-15 18:16:31', '1'),
(55, 467, 115, 116, '1', '1', '2022-11-15 18:16:36', '1'),
(56, 466, 115, 116, '1', '1', '2022-11-15 18:16:43', '1'),
(57, 465, 115, 116, '1', '11', '2022-11-15 18:16:51', '1'),
(58, 464, 114, 116, '1', '1', '2022-11-15 18:17:03', '1');

-- --------------------------------------------------------

--
-- Table structure for table `devices_types`
--

CREATE TABLE `devices_types` (
  `type_id` int(11) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `devices_types`
--

INSERT INTO `devices_types` (`type_id`, `type`) VALUES
(19, 'بروجكتور'),
(17, 'سكانر'),
(15, 'سيرفر'),
(16, 'طابعة'),
(14, 'كمبيوتر'),
(18, 'لابتوب');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`dep_id`),
  ADD UNIQUE KEY `department` (`department`);

--
-- Indexes for table `departments_offices`
--
ALTER TABLE `departments_offices`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sub_department_name` (`sub_department_name`),
  ADD UNIQUE KEY `parent_department_id_2` (`parent_department_id`,`sub_department_name`),
  ADD KEY `parent_department_id` (`parent_department_id`);

--
-- Indexes for table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `serial_number` (`serial_number`),
  ADD KEY `department_id` (`current_department_id`),
  ADD KEY `model_id` (`model_id`);

--
-- Indexes for table `devices_brands`
--
ALTER TABLE `devices_brands`
  ADD PRIMARY KEY (`brand_id`),
  ADD UNIQUE KEY `brand` (`brand`),
  ADD UNIQUE KEY `brand_2` (`brand`);

--
-- Indexes for table `devices_models`
--
ALTER TABLE `devices_models`
  ADD PRIMARY KEY (`model_id`),
  ADD UNIQUE KEY `brand_id_2` (`brand_id`,`model`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `type_id` (`type_id`);

--
-- Indexes for table `devices_transactions`
--
ALTER TABLE `devices_transactions`
  ADD PRIMARY KEY (`trans_id`),
  ADD KEY `device_id` (`device_id`),
  ADD KEY `current_department_id` (`current_department_id`),
  ADD KEY `distination_department_id` (`distination_department_id`);

--
-- Indexes for table `devices_types`
--
ALTER TABLE `devices_types`
  ADD PRIMARY KEY (`type_id`),
  ADD UNIQUE KEY `type` (`type`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

--
-- AUTO_INCREMENT for table `departments_offices`
--
ALTER TABLE `departments_offices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=495;

--
-- AUTO_INCREMENT for table `devices_brands`
--
ALTER TABLE `devices_brands`
  MODIFY `brand_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `devices_models`
--
ALTER TABLE `devices_models`
  MODIFY `model_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `devices_transactions`
--
ALTER TABLE `devices_transactions`
  MODIFY `trans_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `devices_types`
--
ALTER TABLE `devices_types`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `departments_offices`
--
ALTER TABLE `departments_offices`
  ADD CONSTRAINT `dep_sub_dep_fk` FOREIGN KEY (`parent_department_id`) REFERENCES `departments` (`dep_id`);

--
-- Constraints for table `devices`
--
ALTER TABLE `devices`
  ADD CONSTRAINT `device_id_and_department_id_fk` FOREIGN KEY (`current_department_id`) REFERENCES `departments` (`dep_id`),
  ADD CONSTRAINT `devices_ibfk_3` FOREIGN KEY (`model_id`) REFERENCES `devices_models` (`model_id`);

--
-- Constraints for table `devices_models`
--
ALTER TABLE `devices_models`
  ADD CONSTRAINT `devices_models_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `devices_brands` (`brand_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `type_id_with_model_id` FOREIGN KEY (`type_id`) REFERENCES `devices_types` (`type_id`);

--
-- Constraints for table `devices_transactions`
--
ALTER TABLE `devices_transactions`
  ADD CONSTRAINT `devices_transactions_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `devices_transactions_ibfk_2` FOREIGN KEY (`current_department_id`) REFERENCES `departments` (`dep_id`),
  ADD CONSTRAINT `devices_transactions_ibfk_3` FOREIGN KEY (`distination_department_id`) REFERENCES `departments` (`dep_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
