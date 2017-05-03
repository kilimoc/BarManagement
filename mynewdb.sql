-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.73-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Dumping data for table grill_bar.administrator: ~1 rows (approximately)
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` (`first_name`, `last_name`, `id_number`, `username`, `password`) VALUES
	('LEE', 'CHESSOS', '111234', 'lee@gmail.com', 'lee');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;

-- Dumping data for table grill_bar.control_account: ~0 rows (approximately)
/*!40000 ALTER TABLE `control_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `control_account` ENABLE KEYS */;

-- Dumping data for table grill_bar.counter_drinks: ~1 rows (approximately)
/*!40000 ALTER TABLE `counter_drinks` DISABLE KEYS */;
INSERT INTO `counter_drinks` (`drink_name`, `category`, `cartons`, `total_units`, `selling_price`) VALUES
	('tusker lager', 'BEER', 5, 125, 170.00);
/*!40000 ALTER TABLE `counter_drinks` ENABLE KEYS */;

-- Dumping data for table grill_bar.developer_d: ~0 rows (approximately)
/*!40000 ALTER TABLE `developer_d` DISABLE KEYS */;
/*!40000 ALTER TABLE `developer_d` ENABLE KEYS */;

-- Dumping data for table grill_bar.employees: ~2 rows (approximately)
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`id_number`, `first_name`, `last_name`, `phone`, `responsibility`, `basic_salary`) VALUES
	('111', 'serr', 'sss', '071727856', 'Cashier', 12000.00),
	('123', 'dsdd', 'sde', '8665345', 'Manager', 23000.00);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;

-- Dumping data for table grill_bar.items_sold: ~1 rows (approximately)
/*!40000 ALTER TABLE `items_sold` DISABLE KEYS */;
INSERT INTO `items_sold` (`item_id`, `order_no`, `drink_name`, `quantity`, `price`, `time`, `p_status`) VALUES
	(1, 1, 'tusker lager', 5, 850, '2017-05-01 14:04:34', 1);
/*!40000 ALTER TABLE `items_sold` ENABLE KEYS */;

-- Dumping data for table grill_bar.misc_expenses: ~0 rows (approximately)
/*!40000 ALTER TABLE `misc_expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `misc_expenses` ENABLE KEYS */;

-- Dumping data for table grill_bar.order_table: ~1 rows (approximately)
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` (`order_no`, `waiter`) VALUES
	(1, 'serr sss');
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;

-- Dumping data for table grill_bar.received_payments: ~1 rows (approximately)
/*!40000 ALTER TABLE `received_payments` DISABLE KEYS */;
INSERT INTO `received_payments` (`cashier_username`, `order_no`, `transaction_mode`, `amount_payed`, `Transaction_code`, `time`) VALUES
	('111', 1, 'CASH', 850.00, '', '2017-05-01 14:05:14');
/*!40000 ALTER TABLE `received_payments` ENABLE KEYS */;

-- Dumping data for table grill_bar.store_drinks: ~1 rows (approximately)
/*!40000 ALTER TABLE `store_drinks` DISABLE KEYS */;
INSERT INTO `store_drinks` (`drink_name`, `cartons`, `units`, `wc_price`, `category`) VALUES
	('tusker lager', 15, 25, 2500.00, 'BEER');
/*!40000 ALTER TABLE `store_drinks` ENABLE KEYS */;

-- Dumping data for table grill_bar.system_users: ~4 rows (approximately)
/*!40000 ALTER TABLE `system_users` DISABLE KEYS */;
INSERT INTO `system_users` (`id_number`, `username`, `password`, `rank`, `status`) VALUES
	('111', '111', '111', 'Cashier', 1),
	('123', '123', '123', 'Manager', 0),
	('32060756', 'chessos', 'luke', 'Director', 0),
	('111234', 'lee@gmail.com', 'lee', 'Director', 0);
/*!40000 ALTER TABLE `system_users` ENABLE KEYS */;

-- Dumping data for table grill_bar.transactions: ~0 rows (approximately)
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;

-- Dumping data for table grill_bar.waiter_float: ~1 rows (approximately)
/*!40000 ALTER TABLE `waiter_float` DISABLE KEYS */;
INSERT INTO `waiter_float` (`id_number`, `first_name`, `last_name`, `standing_float`, `debt`, `time`) VALUES
	(1, 'EVANS', 'KANDA', 3000.00, 0.00, '2017-04-29 09:14:30');
/*!40000 ALTER TABLE `waiter_float` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
