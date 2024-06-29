/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.32-MariaDB : Database - db_pengunjung
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_pengunjung` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `db_pengunjung`;

/*Table structure for table `tb_pengunjung` */

DROP TABLE IF EXISTS `tb_pengunjung`;

CREATE TABLE `tb_pengunjung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pengunjung` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `tujuan` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tb_pengunjung` */

insert  into `tb_pengunjung`(`id`,`nama_pengunjung`,`alamat`,`tujuan`,`email`,`no_hp`) values 
(1,'Anjas','Gianyar','Buat Project UAS OOP','agusanjas11@gmail.com','08970415186'),
(5,'Komang Agus ','Denpasar','Revisi project UAS OOP','anjasputra1102@gmail.com','089111222333');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
