-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.8


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema dmdb
--

CREATE DATABASE IF NOT EXISTS dmdb;
USE dmdb;

--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `catid` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(30) NOT NULL,
  PRIMARY KEY (`catid`),
  UNIQUE KEY `category_UNIQUE` (`category`),
  KEY `index` (`catid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`catid`,`category`) VALUES 
 (19,'Education'),
 (44,'Food'),
 (43,'games'),
 (3,'Movie'),
 (39,'science'),
 (22,'social'),
 (38,'sports'),
 (27,'Travelling');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `cmtstatus`
--

DROP TABLE IF EXISTS `cmtstatus`;
CREATE TABLE `cmtstatus` (
  `cmtid` int(11) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `liked` int(11) DEFAULT NULL,
  `unliked` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cmtstatus`
--

/*!40000 ALTER TABLE `cmtstatus` DISABLE KEYS */;
INSERT INTO `cmtstatus` (`cmtid`,`mail`,`liked`,`unliked`) VALUES 
 (59,'admin@gmail.com',0,1),
 (58,'admin@gmail.com',0,1),
 (3,'admin@gmail.com',1,0),
 (60,'admin@gmail.com',0,1),
 (61,'admin@gmail.com',0,1),
 (55,'admin@gmail.com',1,0),
 (5,'admin@gmail.com',0,1),
 (1,'admin@gmail.com',1,0),
 (69,'admin@gmail.com',1,0),
 (72,'admin@gmail.com',1,0),
 (81,'admin@gmail.com',0,1),
 (82,'admin@gmail.com',0,1),
 (90,'admin@gmail.com',1,0),
 (96,'admin@gmail.com',1,0),
 (104,'Shan@gmail.com',1,0),
 (103,'Shan@gmail.com',1,0),
 (108,'sonu@gmail.com',1,0),
 (110,'sonu@gmail.com',1,0),
 (112,'sonu@gmail.com',1,0),
 (111,'sonu@gmail.com',1,0),
 (113,'sonu@gmail.com',1,0),
 (114,'sonu@gmail.com',1,0),
 (123,'sonu@gmail.com',1,0),
 (124,'sonu@gmail.com',1,0);
/*!40000 ALTER TABLE `cmtstatus` ENABLE KEYS */;


--
-- Definition of table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `cmtid` int(11) NOT NULL AUTO_INCREMENT,
  `newsid` int(11) NOT NULL,
  `cmtstr` varchar(1024) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL,
  `author` varchar(30) NOT NULL,
  `nolikes` int(11) NOT NULL,
  `nodislikes` int(11) NOT NULL,
  PRIMARY KEY (`cmtid`),
  KEY `cmtfkey_idx` (`newsid`),
  CONSTRAINT `cmtfkey` FOREIGN KEY (`newsid`) REFERENCES `news` (`newsid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`cmtid`,`newsid`,`cmtstr`,`time`,`date`,`author`,`nolikes`,`nodislikes`) VALUES 
 (1,6,'hello','20:46:03','2016-08-14','admin@gmail.com',0,0),
 (2,6,'hello','20:46:16','2016-08-14','admin@gmail.com',0,0),
 (3,3,'povande...','20:52:56','2016-08-14','admin@gmail.com',1,0),
 (4,6,'atheyo...','21:06:23','2016-08-14','admin@gmail.com',0,0),
 (5,6,'2','21:08:27','2016-08-14','admin@gmail.com',0,1),
 (6,3,'1','21:27:22','2016-08-14','admin@gmail.com',0,0),
 (7,3,'2','21:27:29','2016-08-14','admin@gmail.com',0,0),
 (9,8,'nannai','00:11:33','2016-08-15','admin@gmail.com',0,0),
 (10,8,'ohh','00:11:44','2016-08-15','admin@gmail.com',0,0),
 (13,8,'og','00:13:51','2016-08-15','admin@gmail.com',0,0),
 (18,3,'ponam','00:56:31','2016-08-15','admin@gmail.com',0,0),
 (19,3,'5','00:57:00','2016-08-15','admin@gmail.com',0,0),
 (51,18,'nannai','21:14:16','2016-08-16','admin@gmail.com',0,0),
 (52,18,'eppa..........','15:20:46','2016-08-17','admin@gmail.com',0,0),
 (53,19,'kashtam aaayi poi..','15:36:49','2016-08-17','admin@gmail.com',0,0),
 (56,3,'ya','22:30:43','2016-08-17','admin@gmail.com',0,0),
 (57,3,'/','22:30:50','2016-08-17','admin@gmail.com',0,0),
 (58,3,'/','22:31:10','2016-08-17','admin@gmail.com',1,1),
 (59,3,'\\\\\\\\\\\\\\\\','22:31:34','2016-08-17','admin@gmail.com',1,1),
 (60,3,'.','22:32:02','2016-08-17','admin@gmail.com',4,-2),
 (70,19,'sho...kashtam aaayi poi..','17:37:39','2016-08-18','admin@gmail.com',0,0),
 (72,3,'jhhg','15:35:31','2016-08-29','admin@gmail.com',1,0),
 (73,28,'yeah....','00:18:52','2016-09-08','admin@gmail.com',0,0),
 (80,32,'1','00:09:43','2016-09-11','admin@gmail.com',0,0),
 (81,32,'2','00:09:48','2016-09-11','admin@gmail.com',0,1),
 (82,32,'Dinu','00:22:53','2016-09-11','admin@gmail.com',0,1),
 (83,45,'10','14:52:20','2016-09-11','admin@gmail.com',0,0),
 (84,45,'Hi','14:54:47','2016-09-11','admin@gmail.com',0,0),
 (85,45,'Kol','15:34:34','2016-09-11','admin@gmail.com',0,0),
 (86,45,'Ji','15:36:45','2016-09-11','admin@gmail.com',0,0),
 (87,47,'Hio','16:14:58','2016-09-11','sonu@gmail.com',0,0),
 (88,47,'100','16:17:27','2016-09-11','sonu@gmail.com',0,0),
 (89,32,'100','16:18:20','2016-09-11','sonu@gmail.com',0,0),
 (90,47,'200','16:27:46','2016-09-11','sonu@gmail.com',1,0),
 (91,47,'25','16:28:56','2016-09-11','sonu@gmail.com',0,0),
 (93,47,'5','16:52:38','2016-09-11','Shan@gmail.com',0,0),
 (94,47,'6','19:48:34','2016-09-11','Shan@gmail.com',0,0),
 (95,47,'k','19:50:34','2016-09-11','Shan@gmail.com',0,0),
 (96,47,'zz','19:52:59','2016-09-11','Shan@gmail.com',1,0),
 (97,47,'9','20:07:07','2016-09-11','Shan@gmail.com',0,0),
 (98,47,'8','20:07:11','2016-09-11','Shan@gmail.com',0,0),
 (99,47,'9','20:17:54','2016-09-11','Shan@gmail.com',0,0),
 (100,47,'10','20:18:01','2016-09-11','Shan@gmail.com',0,0),
 (101,47,'2555','20:25:54','2016-09-11','Shan@gmail.com',0,0),
 (102,47,'5556565','21:35:58','2016-09-11','Shan@gmail.com',0,0),
 (103,48,'yyy','22:10:15','2016-09-11','Shan@gmail.com',1,0),
 (104,48,'G','22:10:45','2016-09-11','Shan@gmail.com',1,0),
 (107,50,'hi','23:42:54','2016-09-11','sonu@gmail.com',0,0),
 (108,50,'lol','23:45:27','2016-09-11','sonu@gmail.com',1,0),
 (109,52,'&#9748; ','15:48:11','2016-09-12','A',0,0),
 (110,51,':)','16:03:47','2016-09-12','sonu@gmail.com',1,0),
 (111,51,'&#128514; ','16:05:38','2016-09-12','sonu@gmail.com',1,0),
 (112,51,'&#128536; ','16:06:09','2016-09-12','sonu@gmail.com',1,0),
 (113,52,'ithentha kudayo','21:35:42','2016-09-12','sonu@gmail.com',1,0),
 (114,6,'Hi','22:54:22','2016-09-12','sonu@gmail.com',1,0),
 (116,6,'lin','13:05:28','2016-09-16','sonu@gmail.com',0,0),
 (117,6,'lin','13:05:32','2016-09-16','sonu@gmail.com',0,0),
 (118,6,'lin','13:05:33','2016-09-16','sonu@gmail.com',0,0),
 (119,6,'lin','13:05:34','2016-09-16','sonu@gmail.com',0,0),
 (120,6,'lin','13:06:03','2016-09-16','sonu@gmail.com',0,0),
 (121,55,'Hii','09:50:40','2016-09-21','sonu@gmail.com',0,0),
 (122,55,'Aano','09:53:01','2016-09-21','sonu@gmail.com',0,0),
 (123,55,'T','09:56:41','2016-09-21','sonu@gmail.com',0,0),
 (124,55,'T','10:01:33','2016-09-21','sonu@gmail.com',1,0),
 (126,67,'Hello','11:26:22','2016-09-21','sonu@gmail.com',0,0);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;


--
-- Definition of table `fav`
--

DROP TABLE IF EXISTS `fav`;
CREATE TABLE `fav` (
  `email` varchar(45) NOT NULL,
  `newsid` int(11) NOT NULL DEFAULT '11'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fav`
--

/*!40000 ALTER TABLE `fav` DISABLE KEYS */;
INSERT INTO `fav` (`email`,`newsid`) VALUES 
 ('sonusoman@gmail.com',45),
 ('sonu@gmail.com',50),
 ('sonu@gmail.com',47);
/*!40000 ALTER TABLE `fav` ENABLE KEYS */;


--
-- Definition of table `likestatus`
--

DROP TABLE IF EXISTS `likestatus`;
CREATE TABLE `likestatus` (
  `newsid` int(15) NOT NULL,
  `mail` varchar(35) NOT NULL,
  `liked` int(11) DEFAULT NULL,
  `unliked` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `likestatus`
--

/*!40000 ALTER TABLE `likestatus` DISABLE KEYS */;
INSERT INTO `likestatus` (`newsid`,`mail`,`liked`,`unliked`) VALUES 
 (4,'admin@gmail.com',0,1),
 (6,'admin@gmail.com',1,0),
 (8,'admin@gmail.com',1,0),
 (1,'admin@gmail.com',1,0),
 (7,'admin@gmail.com',1,0),
 (18,'admin@gmail.com',1,0),
 (19,'admin@gmail.com',1,0),
 (3,'admin@gmail.com',0,1),
 (28,'admin@gmail.com',0,1),
 (32,'admin@gmail.com',1,0),
 (45,'admin@gmail.com',1,0),
 (45,'admin@gmail.com',1,0),
 (45,'admin@gmail.com',1,0),
 (45,'admin@gmail.com',1,0),
 (45,'admin@gmail.com',1,0),
 (45,'sonu@gmail.com',1,0),
 (46,'sonu@gmail.com',1,0),
 (47,'sonu@gmail.com',0,1),
 (46,'Shan@gmail.com',0,1),
 (47,'Shan@gmail.com',0,1),
 (48,'Shan@gmail.com',1,0),
 (52,'sonu@gmail.com',1,0),
 (63,'sonu@gmail.com',1,0),
 (66,'jithjob123@gmail.com',0,0),
 (66,'admin@gmail.com',1,0),
 (61,'admin@gmail.com',1,0),
 (55,'sonu@gmail.com',1,0);
/*!40000 ALTER TABLE `likestatus` ENABLE KEYS */;


--
-- Definition of table `locations`
--

DROP TABLE IF EXISTS `locations`;
CREATE TABLE `locations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `lat` varchar(45) DEFAULT NULL,
  `lng` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locations`
--

/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` (`id`,`email`,`lat`,`lng`) VALUES 
 (1,'sonu@gmail.com','10.00500',76.377);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `email` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `usertype` binary(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`email`,`pwd`,`usertype`) VALUES 
 ('A','a',0x30),
 ('a@g.a','a',0x30),
 ('admin@gmail.com','admin123',0x31),
 ('Anju@email.com','Illa',0x30),
 ('Dff','Cvvv',0x30),
 ('jithjob123@gmail.com','jit',0x30),
 ('poka@OGmail.com','koch',0x30),
 ('Shan@gmail.com','shan',0x30),
 ('Sinumichael@gmail.com','sinu',0x30),
 ('sonu@gmail.com','sonu',0x30);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsid` int(15) NOT NULL AUTO_INCREMENT,
  `cat` varchar(30) NOT NULL,
  `newsstr` varchar(1024) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `author` varchar(30) NOT NULL,
  `nolikes` int(11) NOT NULL,
  `nodislikes` int(11) NOT NULL,
  `nocmts` int(11) NOT NULL,
  PRIMARY KEY (`newsid`),
  KEY `newscat_idx` (`cat`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`newsid`,`cat`,`newsstr`,`time`,`date`,`longitude`,`latitude`,`address`,`author`,`nolikes`,`nodislikes`,`nocmts`) VALUES 
 (3,'Travelling','meeshappulimala :)','09:52:55','2016-08-09','10','76.3711','kerala','admin@gmail.com',101,101,110),
 (6,'Personal',' 1.	Introduction\r\n1.1	Purpose \r\n                  The Software Requirements Specification (SRS) will provide a detailed description of the requirements for the software Web in my Hand.  This SRS will allow for a complete understanding of what is to be expected from the s/w. The clear understanding of the project and itsï¿½ functionality will allow for the correct software to be developed for the end user and will be used for the development of the future stages of the project. This SRS will provide the foundation for the project. From this SRS, the s/w can be designed, constructed, and finally tested.\r\n                  The project ï¿½WEB IN MY HAND \" aims at facilitating the website programmer a framework where he can create web page dynamically. Our framework takes input from an xml in ','16:00:26','2016-08-09','10','76.3711','aluva','admin@gmail.com',100,102,104),
 (8,'games','SmartHome are mainly used to provide a friendly environment with excellent power efficiency. SmartHome is the term commonly used to define a residence that integrates technology and services through home networking to enhance power efficiency and improve the quality of living.','17:30:46','2016-08-09','10','76.3711','cvfd','admin@gmail.com',104,102,103),
 (18,'social','assembly pirichu vitt..','20:45:29','2016-08-16','10','76.3711','kerala','admin@gmail.com',1,1,2),
 (19,'sports','rio il Indiak 2 medal mathram :(\r\n','15:36:28','2016-08-17','10','76.3711','kerala','admin@gmail.com',1,0,2),
 (27,'social','naale UDF harthal prekhyapichu.\r\n','00:06:44','2016-09-08','0','0','null','sonu@gmail.com',0,0,0),
 (28,'Food','Biriyani@Hotel International,Nice experience :)','00:07:52','2016-09-08','0','0','null','admin@gmail.com',0,1,2),
 (29,'Travelling',' awesome moments #Meeshappulimala.','00:09:27','2016-09-08','0','0','null','admin@gmail.com',0,0,0),
 (32,'null','Posted from Android','22:35:52','2016-09-10','10','10','null','admin@gmail.com',1,0,4),
 (45,'null','kilo','14:33:03','2016-09-11','0','0','null','admin@gmail.com',10,1,4),
 (46,'games','nn','15:51:25','2016-09-11','10','10','null','admin@gmail.com',2,6,0),
 (47,'null','A','16:14:11','2016-09-11','10','10','null','admin@gmail.com',1,1,15),
 (48,'Education','Test document ','21:36:32','2016-09-11','10','10','null','Shan@gmail.com',34,12,2),
 (49,'null','1','23:01:29','2016-09-11','10','10','null','Shan@gmail.com',1,0,2),
 (50,'Food','hello friends','23:27:18','2016-09-11','10','10','null','sonu@gmail.com',4,0,2),
 (51,'null','Hu','15:44:26','2016-09-12','10','10','null','sonu@gmail.com',0,0,2),
 (52,'null','Hi','15:46:23','2016-09-12','10','10','null','A',1,0,2),
 (53,'null','trd','16:05:09','2016-09-15','76.3125','10','null','sonu@gmail.com',0,0,0),
 (54,'null','test','16:26:17','2016-09-15','76.4171','10','null','sonu@gmail.com',0,0,0),
 (55,'null','Suggested to sonu\r\n\r\n','16:57:40','2016-09-15','76.4313','10.000','null','sonu@gmail.com',4,0,4),
 (60,'games','c','11:09:14','2016-09-16','10.00500','76.3177','null','sonu@gmail.com',0,0,0),
 (61,'null','Hiiii','12:35:17','2016-09-16','10.00500','76.3177','null','sonu@gmail.com',0,0,0),
 (62,'null','Jiiii','12:37:19','2016-09-16','','','null','A',0,0,0),
 (63,'null','Givi','12:39:41','2016-09-16','10.00500','76.3177','null','sonu@gmail.com',2,0,0),
 (66,'science','Hehe ','16:44:12','2016-09-16','','','null','Admin@gmail.com',0,0,0),
 (67,'science','Bb','21:27:32','2016-09-20','10.005','76.3177','','sonu@gmail.com',1,0,1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


--
-- Definition of table `reg`
--

DROP TABLE IF EXISTS `reg`;
CREATE TABLE `reg` (
  `email` varchar(30) NOT NULL,
  `proname` varchar(30) NOT NULL,
  `phno` varchar(15) NOT NULL,
  `gender` varchar(6) NOT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `fkey` FOREIGN KEY (`email`) REFERENCES `login` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg`
--

/*!40000 ALTER TABLE `reg` DISABLE KEYS */;
INSERT INTO `reg` (`email`,`proname`,`phno`,`gender`) VALUES 
 ('A','Ashan','A','Male'),
 ('a@g.a','a','S','Male'),
 ('admin@gmail.com','Admin','+919847211832','Male'),
 ('Anju@email.com','Anju','9846201235','Female'),
 ('jithjob123@gmail.com','Jith job K. I','9746204578','Male'),
 ('poka@OGmail.com','shalu','+919874561230','Male'),
 ('Shan@gmail.com','Shan Rehman','+919986154238','Male'),
 ('Sinumichael@gmail.com','Sinu Michael','9656616658','Male'),
 ('sonu@gmail.com','Sonu smokie','+919874560321','Male');
/*!40000 ALTER TABLE `reg` ENABLE KEYS */;


--
-- Definition of table `settings`
--

DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL,
  `distance` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `settings`
--

/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;


--
-- Definition of table `user_location`
--

DROP TABLE IF EXISTS `user_location`;
CREATE TABLE `user_location` (
  `email` varchar(35) NOT NULL,
  `lng` double DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_location`
--

/*!40000 ALTER TABLE `user_location` DISABLE KEYS */;
INSERT INTO `user_location` (`email`,`lng`,`lat`,`address`) VALUES 
 ('sonu@gmail.com',10.005,76.3177,'palarivattom');
/*!40000 ALTER TABLE `user_location` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
