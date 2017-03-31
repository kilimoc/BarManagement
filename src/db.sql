-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.35-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for grill_bar
CREATE DATABASE IF NOT EXISTS `grill_bar` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `grill_bar`;

-- Dumping structure for table grill_bar.activated_orders
CREATE TABLE IF NOT EXISTS `activated_orders` (
  `item_No` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` int(11) NOT NULL,
  `drink_name` varchar(40) NOT NULL,
  `units` int(11) NOT NULL,
  `unit_price` decimal(9,2) NOT NULL,
  `total_cost` decimal(9,2) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_No`),
  KEY `orderNo` (`orderNo`),
  CONSTRAINT `activated_orders_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `orders` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.activated_orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `activated_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `activated_orders` ENABLE KEYS */;

-- Dumping structure for table grill_bar.counter_drinks
CREATE TABLE IF NOT EXISTS `counter_drinks` (
  `drinkId` int(11) NOT NULL AUTO_INCREMENT,
  `drink_name` varchar(20) NOT NULL,
  `cartons` int(5) NOT NULL,
  `total_units` int(5) DEFAULT NULL,
  PRIMARY KEY (`drinkId`),
  KEY `drink_name` (`drink_name`),
  CONSTRAINT `counter_drinks_ibfk_1` FOREIGN KEY (`drink_name`) REFERENCES `store_drinks` (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.counter_drinks: ~0 rows (approximately)
/*!40000 ALTER TABLE `counter_drinks` DISABLE KEYS */;
/*!40000 ALTER TABLE `counter_drinks` ENABLE KEYS */;

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

-- Dumping data for table grill_bar.developer_d: ~0 rows (approximately)
/*!40000 ALTER TABLE `developer_d` DISABLE KEYS */;
/*!40000 ALTER TABLE `developer_d` ENABLE KEYS */;

-- Dumping structure for table grill_bar.employees_details
CREATE TABLE IF NOT EXISTS `employees_details` (
  `IdNo` int(8) NOT NULL DEFAULT '0',
  `f_name` varchar(20) DEFAULT NULL,
  `l_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`IdNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.employees_details: ~0 rows (approximately)
/*!40000 ALTER TABLE `employees_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees_details` ENABLE KEYS */;

-- Dumping structure for table grill_bar.employee_jobd
CREATE TABLE IF NOT EXISTS `employee_jobd` (
  `jobNo` int(11) NOT NULL AUTO_INCREMENT,
  `IdNo` int(8) NOT NULL,
  `j_group` varchar(20) NOT NULL,
  `b_salary` decimal(13,2) DEFAULT NULL,
  PRIMARY KEY (`jobNo`),
  KEY `IdNo` (`IdNo`),
  CONSTRAINT `employee_jobd_ibfk_1` FOREIGN KEY (`IdNo`) REFERENCES `employees_details` (`IdNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.employee_jobd: ~0 rows (approximately)
/*!40000 ALTER TABLE `employee_jobd` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_jobd` ENABLE KEYS */;

-- Dumping structure for table grill_bar.misc_expenses
CREATE TABLE IF NOT EXISTS `misc_expenses` (
  `expenseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` decimal(13,2) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`expenseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.misc_expenses: ~0 rows (approximately)
/*!40000 ALTER TABLE `misc_expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `misc_expenses` ENABLE KEYS */;

-- Dumping structure for table grill_bar.mpesa_sales
CREATE TABLE IF NOT EXISTS `mpesa_sales` (
  `orderNo` int(11) NOT NULL,
  `amount` decimal(13,2) NOT NULL,
  `transaction_code` varchar(50) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transaction_code`),
  KEY `orderNo` (`orderNo`),
  CONSTRAINT `mpesa_sales_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `orders` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.mpesa_sales: ~0 rows (approximately)
/*!40000 ALTER TABLE `mpesa_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `mpesa_sales` ENABLE KEYS */;

-- Dumping structure for table grill_bar.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `orderNo` int(11) NOT NULL AUTO_INCREMENT,
  `IdNo` int(8) NOT NULL,
  `orderValue` decimal(13,2) NOT NULL DEFAULT '0.00',
  `amountpayed` decimal(13,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`orderNo`),
  KEY `IdNo` (`IdNo`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`IdNo`) REFERENCES `employees_details` (`IdNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table grill_bar.sales
CREATE TABLE IF NOT EXISTS `sales` (
  `drinkId` int(11) NOT NULL AUTO_INCREMENT,
  `drink_name` varchar(20) NOT NULL,
  `units` int(5) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`drinkId`),
  KEY `drink_name` (`drink_name`),
  CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`drink_name`) REFERENCES `store_drinks` (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.sales: ~0 rows (approximately)
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;

-- Dumping structure for table grill_bar.scard_sales
CREATE TABLE IF NOT EXISTS `scard_sales` (
  `orderNo` int(11) NOT NULL,
  `amount` decimal(13,2) NOT NULL,
  `transaction_code` varchar(50) NOT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transaction_code`),
  KEY `orderNo` (`orderNo`),
  CONSTRAINT `scard_sales_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `orders` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.scard_sales: ~0 rows (approximately)
/*!40000 ALTER TABLE `scard_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `scard_sales` ENABLE KEYS */;

-- Dumping structure for table grill_bar.selling_prices
CREATE TABLE IF NOT EXISTS `selling_prices` (
  `drinkNo` int(11) NOT NULL AUTO_INCREMENT,
  `drink_name` varchar(40) DEFAULT NULL,
  `selling_price` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`drinkNo`),
  KEY `drink_name` (`drink_name`),
  CONSTRAINT `selling_prices_ibfk_1` FOREIGN KEY (`drink_name`) REFERENCES `store_drinks` (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.selling_prices: ~0 rows (approximately)
/*!40000 ALTER TABLE `selling_prices` DISABLE KEYS */;
/*!40000 ALTER TABLE `selling_prices` ENABLE KEYS */;

-- Dumping structure for table grill_bar.store_drinks
CREATE TABLE IF NOT EXISTS `store_drinks` (
  `drink_name` varchar(20) NOT NULL,
  `cartons` int(5) NOT NULL,
  `units` int(5) NOT NULL,
  `wc_price` decimal(9,2) NOT NULL,
  `category` varchar(50) NOT NULL,
  `date _r` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.store_drinks: ~35 rows (approximately)
/*!40000 ALTER TABLE `store_drinks` DISABLE KEYS */;
INSERT INTO `store_drinks` (`drink_name`, `cartons`, `units`, `wc_price`, `category`, `date _r`) VALUES
	('1/4 bond 7', 25, 25, 3000.00, 'SPIRITS', '2017-03-01 14:29:19'),
	('1/4 gilbeys', 25, 25, 2500.00, 'SPIRITS', '2017-03-01 14:31:06'),
	('1/4 richot', 25, 25, 3000.00, 'SPIRITS', '2017-03-01 14:30:52'),
	('1/4 Smirnoff Vodka', 25, 25, 2500.00, 'BEER', '2017-03-01 14:27:36'),
	('1/4 viceroy', 25, 25, 2500.00, 'SPIRITS', '2017-03-01 14:31:27'),
	('alvaro', 25, 25, 2500.00, 'SOFT DRINKS', '2017-03-01 14:04:35'),
	('balozi', 25, 25, 2500.00, 'BEER', '2017-03-01 14:20:24'),
	('black ice', 15, 25, 2500.00, 'WINE', '2017-03-01 14:22:55'),
	('Carlsberg', 25, 25, 2500.00, 'BEER', '2017-03-01 14:24:54'),
	('dasani 1ltr', 25, 25, 1200.00, 'SOFT DRINKS', '2017-03-01 14:03:49'),
	('dasani 500ml', 25, 20, 1000.00, 'SOFT DRINKS', '2017-03-01 14:02:16'),
	('delmonte', 25, 25, 2500.00, 'SOFT DRINKS', '2017-03-01 14:05:56'),
	('guarana', 25, 25, 2500.00, 'WINE', '2017-03-01 14:24:16'),
	('guiness can', 25, 25, 2500.00, 'BEER', '2017-03-01 14:13:31'),
	('guiness lager', 25, 25, 2500.00, 'BEER', '2017-03-01 14:13:59'),
	('Heineken', 25, 25, 2500.00, 'BEER', '2017-03-01 14:20:43'),
	('keringet 1ltr', 25, 25, 1000.00, 'SOFT DRINKS', '2017-03-01 14:03:08'),
	('Keringet 500ml', 80, 24, 960.00, 'SOFT DRINKS', '2017-03-01 14:00:30'),
	('novida', 25, 25, 1250.00, 'SOFT DRINKS', '2017-03-01 14:06:30'),
	('pilsner lager', 25, 25, 2500.00, 'BEER', '2017-03-01 14:20:11'),
	('red bull', 25, 25, 2500.00, 'ENERGY DRINK', '2017-03-01 14:07:14'),
	('red ice', 25, 25, 2500.00, 'WINE', '2017-03-01 14:23:11'),
	('redds', 25, 25, 2500.00, 'WINE', '2017-03-01 14:23:55'),
	('shark', 25, 25, 2500.00, 'ENERGY DRINK', '2017-03-01 14:07:32'),
	('snapp', 25, 25, 2500.00, 'WINE', '2017-03-01 14:23:37'),
	('soda 300ml', 50, 24, 720.00, 'SOFT DRINKS', '2017-03-01 13:55:33'),
	('soda 500ml', 25, 24, 960.00, 'SOFT DRINKS', '2017-03-01 13:59:26'),
	('summit lager', 25, 25, 2500.00, 'BEER', '2017-03-01 14:26:18'),
	('summit malt', 25, 25, 2500.00, 'BEER', '2017-03-01 14:26:37'),
	('tusker can', 25, 25, 2500.00, 'BEER', '2017-03-01 14:12:39'),
	('tusker lager', 25, 25, 2500.00, 'BEER', '2017-03-01 14:11:37'),
	('tusker lite', 25, 25, 2500.00, 'BEER', '2017-03-01 14:12:10'),
	('tusker malt', 25, 25, 2500.00, 'BEER', '2017-03-01 14:11:50'),
	('whitecap', 25, 25, 2500.00, 'BEER', '2017-03-01 14:13:09'),
	('whitecap can', 25, 25, 2500.00, 'BEER', '2017-03-01 14:19:51');
/*!40000 ALTER TABLE `store_drinks` ENABLE KEYS */;

-- Dumping structure for table grill_bar.system_users
CREATE TABLE IF NOT EXISTS `system_users` (
  `emplId` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `rank` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.system_users: ~0 rows (approximately)
/*!40000 ALTER TABLE `system_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
