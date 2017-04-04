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

-- Dumping data for table grill_bar.administrator: ~3 rows (approximately)
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` (`first_name`, `last_name`, `id_number`, `username`, `password`) VALUES
	('chris', 'kip', '32060754', 'chris', 'chris'),
	('CHRIS CHEMUT', 'KIPRUTO', '32060757', 'chrisadriane', 'chris'),
	('KILIMO KIPKORIR', 'CORNELIUS', '32060756', 'kilimoc@gmail.com', 'Korir9993@');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;

-- Dumping structure for table grill_bar.counter_drinks
CREATE TABLE IF NOT EXISTS `counter_drinks` (
  `drink_name` varchar(20) NOT NULL,
  `category` varchar(50) NOT NULL,
  `cartons` float DEFAULT NULL,
  `total_units` int(11) DEFAULT NULL,
  `selling_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.counter_drinks: ~4 rows (approximately)
/*!40000 ALTER TABLE `counter_drinks` DISABLE KEYS */;
INSERT INTO `counter_drinks` (`drink_name`, `category`, `cartons`, `total_units`, `selling_price`) VALUES
	('1/2 BOND 7', 'BEER', 4, 50, 170.00),
	('FOUR COUSIN', 'BEER', 20, 200, 170.00),
	('JOHN WALKER', 'IRISH WHISKY', 12, 300, 300.00),
	('SMIRNOFF', 'SPIRITS', 35, 2100, 250.00);
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

-- Dumping data for table grill_bar.employees: ~0 rows (approximately)
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;

-- Dumping structure for function grill_bar.hello
DELIMITER //
CREATE DEFINER=`root`@`%` FUNCTION `hello`(s CHAR(20)) RETURNS char(50) CHARSET latin1
    DETERMINISTIC
RETURN CONCAT ('Hello ',s,'!')//
DELIMITER ;

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

-- Dumping data for table grill_bar.items_sold: ~0 rows (approximately)
/*!40000 ALTER TABLE `items_sold` DISABLE KEYS */;
/*!40000 ALTER TABLE `items_sold` ENABLE KEYS */;

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

-- Dumping structure for table grill_bar.order_table
CREATE TABLE IF NOT EXISTS `order_table` (
  `order_no` int(11) NOT NULL AUTO_INCREMENT,
  `waiter` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.order_table: ~8 rows (approximately)
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` (`order_no`, `waiter`) VALUES
	(1, 'Item 1'),
	(2, 'Item 1'),
	(3, 'Item 1'),
	(4, 'Item 1'),
	(6, 'Item 3'),
	(7, 'Item 1'),
	(8, 'Item 1'),
	(9, 'Item 1');
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;

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
  PRIMARY KEY (`drink_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.store_drinks: ~32 rows (approximately)
/*!40000 ALTER TABLE `store_drinks` DISABLE KEYS */;
INSERT INTO `store_drinks` (`drink_name`, `cartons`, `units`, `wc_price`, `category`) VALUES
	('1/2 BOND 7', 50, 25, 5000.00, 'BEER'),
	('1/2 RICHOT', 20, 20, 3000.00, 'BEER'),
	('1/2 VICEROY', 20, 20, 3000.00, 'WINES'),
	('AMARULA 750ML', 30, 20, 5000.00, 'WINES'),
	('ASCDS', 30, 20, 3000.00, 'WINES'),
	('BEER', 30, 40, 3000.00, 'WHISKY'),
	('Caprice 1ltr', 50, 25, 5000.00, 'SPIRITS'),
	('CLAN MURRAY', 20, 25, 2500.00, 'SCOTCH WHISKY'),
	('Famous Crous', 50, 25, 5000.00, 'SPIRITS'),
	('FOUR COUSIN', 20, 20, 5000.00, 'BEER'),
	('GILBEYS 750ML', 50, 25, 5000.00, 'BEER'),
	('GUINESS CAN', 40, 20, 6000.00, 'BEER'),
	('GURANA', 20, 40, 2500.00, 'BEER'),
	('JOHN WALKER', 50, 25, 2500.00, 'IRISH WHISKY'),
	('KERINGET 300ML', 50, 24, 2500.00, 'SOFT DRINKS'),
	('KERINGET 500ML', 50, 24, 2500.00, 'SOFT DRINKS'),
	('KingFisher', 20, 20, 5000.00, 'WINES'),
	('LimeJuice', 30, 50, 5000.00, 'WINES'),
	('MALIBU 350ML', 50, 20, 5000.00, 'BEER'),
	('PENASOL', 50, 25, 5000.00, 'SPIRITS'),
	('pilsner', 20, 20, 5000.00, 'Beer'),
	('SMIRNOFF', 5, 60, 5000.00, 'SPIRITS'),
	('SODA', 20, 20, 2500.00, 'SOFT DRINKS'),
	('SODA 300ML', 50, 24, 2500.00, 'SOFT DRINKS'),
	('SODA 500ML', 50, 24, 2500.00, 'SOFT DRINKS'),
	('TRUST', 20, 25, 3000.00, 'BEER'),
	('TUSKER CAN', 40, 40, 6000.00, 'BEER'),
	('TUSKER LAGER', 20, 40, 5000.00, 'BEER'),
	('TUSKER LIME', 50, 20, 50000.00, 'BEER'),
	('VAT 69', 50, 80, 5000.00, 'WINES'),
	('VODKA', 20, 20, 2500.00, 'BEER'),
	('WELCOME', 20, 50, 2500.00, 'BEER');
/*!40000 ALTER TABLE `store_drinks` ENABLE KEYS */;

-- Dumping structure for table grill_bar.system_users
CREATE TABLE IF NOT EXISTS `system_users` (
  `emplId` int(11) DEFAULT NULL,
  `id_number` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `rank` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table grill_bar.system_users: ~1 rows (approximately)
/*!40000 ALTER TABLE `system_users` DISABLE KEYS */;
INSERT INTO `system_users` (`emplId`, `id_number`, `username`, `password`, `rank`, `status`) VALUES
	(NULL, '32060754', 'chris', 'chris', 'Director', 0);
/*!40000 ALTER TABLE `system_users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
