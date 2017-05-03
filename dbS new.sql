-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.46 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for grill_bar
CREATE DATABASE IF NOT EXISTS `grill_bar` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `grill_bar`;


-- Dumping structure for table grill_bar.administrator
CREATE TABLE IF NOT EXISTS `administrator` (
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `id_number` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `id_number` (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.counter_drinks
CREATE TABLE IF NOT EXISTS `counter_drinks` (
  `drink_name` varchar(20) NOT NULL,
  `category` varchar(50) NOT NULL,
  `cartons` float DEFAULT NULL,
  `total_units` int(11) DEFAULT NULL,
  `selling_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for view grill_bar.dailysales
-- Creating temporary table to overcome VIEW dependency errors



-- Dumping structure for table grill_bar.developer_d
CREATE TABLE IF NOT EXISTS `developer_d` (
  `c_name` varchar(50) NOT NULL,
  `director` varchar(40) DEFAULT NULL,
  `phone` varchar(13) NOT NULL,
  `address` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `website` varchar(50) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`c_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `id_number` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `responsibility` varchar(50) DEFAULT NULL,
  `basic_salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for function grill_bar.hello



-- Dumping structure for table grill_bar.items_sold
CREATE TABLE IF NOT EXISTS `items_sold` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(11) DEFAULT NULL,
  `drink_name` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT '500',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `p_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.misc_expenses
CREATE TABLE IF NOT EXISTS `misc_expenses` (
  `expenseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` decimal(13,2) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`expenseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.order_table
CREATE TABLE IF NOT EXISTS `order_table` (
  `order_no` int(11) NOT NULL AUTO_INCREMENT,
  `waiter` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.received_payments
CREATE TABLE IF NOT EXISTS `received_payments` (
  `cashier_username` varchar(50) DEFAULT NULL,
  `order_no` int(11) NOT NULL,
  `transaction_mode` enum('CASH','M~PESA','MASTERCARD') NOT NULL,
  `amount_payed` decimal(10,2) NOT NULL,
  `Transaction_code` varchar(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.selling_prices



-- Dumping structure for table grill_bar.store_drinks
CREATE TABLE IF NOT EXISTS `store_drinks` (
  `drink_name` varchar(20) NOT NULL,
  `cartons` int(5) NOT NULL,
  `units` int(5) NOT NULL,
  `wc_price` decimal(9,2) NOT NULL,
  `category` varchar(50) NOT NULL,
  PRIMARY KEY (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.system_users
CREATE TABLE IF NOT EXISTS `system_users` (
  `id_number` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `rank` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table grill_bar.transactions
CREATE TABLE IF NOT EXISTS `transactions` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `cashier_username` varchar(50) DEFAULT NULL,
  `order_no` int(11) NOT NULL,
  `transaction_mode` enum('CASH','M~PESA','MASTERCARD') NOT NULL,
  `amount_payed` decimal(10,2) NOT NULL,
  `Transaction_code` varchar(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for view grill_bar.dailysales
-- Removing temporary table and create final VIEW structure

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`127.0.0.1` VIEW `dailysales` AS select drink_name AS 'DRINK NAME',sum(quantity) AS 'TOTAL QUANTITY',sum(quantity*price) AS 'TOTAL AMOUNT' from items_sold  WHERE DATE(time)=CURDATE() GROUP BY drink_name ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
