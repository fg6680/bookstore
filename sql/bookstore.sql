/*
SQLyog Ultimate v8.32 
MySQL - 5.5.62 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'int文章的唯一ID',
  `author` varchar(50) NOT NULL COMMENT '作者',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '文章的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`id`,`author`,`title`,`content`) values (1,'Fzc','抉择','一个农民从洪水中救起了他的妻子，他的孩子却被淹死了。\n事后，人们议论纷纷。有的说他做得对，因为孩子可以再生一个，妻子却不能死而复活。有的说他做错了，因为妻子可以另娶一个，孩子却不能死而复活。我听了人们的议论，也感到疑惑难决：如果只能救活一人，究竟应该救妻子呢，还是救孩子？于是我去拜访那个农民，问他当时是怎么想的。他答道：“我什么也没想。洪水袭来，妻子在我身过，我抓住她就往附近的山坡游。当我返回时，孩子已经被洪水冲走了。”归途上，我琢磨着农民的话，对自己说：如果当时这个农民稍有迟疑，可能一个都救不了；所谓人生的抉择，不少便是如此。'),(2,'Fzc','并不是你想象中的那样','两个旅行中的天使到一个富有的家庭借宿。这家人对他们并不友好，并且拒绝让他们在舒适的客人卧室过夜，而是在冰冷的地下室给他们找了一个角落。\n当他们铺床时，较老的天使发现墙上有一个洞，就顺手把它修补好了。年轻的天使问为什么，老天使答到：“有些事并不象它看上去那样。”第二晚，两人又到了一个非常贫穷的农家借宿。主人夫妇俩对他们非常热情，把仅有的一点点食物拿出来款待客人，然后又让出自己的床铺给两个天使。第二天一早，两个天使发现农夫和他的妻子在哭泣，他们唯一的生活来源——一头奶牛死了。\n年轻的天使非常愤怒，他质问老天使为什么会这样，第一个家庭什么都有，老天使还帮助他们修补墙洞，第二个家庭尽管如此贫穷还是热情款待客人，而老天使却没有阻止奶牛的死亡。\n“有些事并不象它看上去那样。”老天使答道，“当我们在地下室过夜时，我从墙洞看到墙里面堆满了金块。因为主人被贪欲所迷惑，不愿意分享他的财富，所以我把墙洞填上了。昨天晚上，死亡之神来召唤农夫的妻子，我让奶牛代替了她。所以有些事并不象它看上去那样。”'),(6,'Fg','简单道理','从前，有两个饥饿的人得到了一位长者的恩赐：一根鱼竿和一篓鲜活硕大的鱼。其中，一个人要了一篓鱼，另一个人要了一根鱼竿，于是他们分道扬镳了。\n得到鱼的人原地就用干柴搭起篝火煮起了鱼，他狼吞虎咽，还没有品出鲜鱼的肉香，转瞬间，连鱼带汤就被他吃了个精光，不久，他便饿死在空空的鱼篓旁。另一个人则提着鱼竿继续忍饥挨饿，一步步艰难地向海边走去，可当他已经看到不远处那片蔚蓝色的海洋时，他浑身的最后一点力气也使完了，他也只能眼巴巴地带着无尽的遗憾撒手人间。\n又有两个饥饿的人，他们同样得到了长者恩赐的一根鱼竿和一篓鱼。只是他们并没有各奔东西，而是商定共同去找寻大海，他俩每次只煮一条鱼，他们经过遥远的跋涉，来到了海边，从此，两人开始了捕鱼为生的日子，几年后，他们盖起了房子，有了各自的家庭、子女，有了自己建造的渔船，过上了幸福安康的生活。一个人只顾眼前的利益，得到的终将是短暂的欢愉；一个人目标高远，但也要面对现实的生活。');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(30) NOT NULL,
  `pub` varchar(30) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `date` datetime NOT NULL,
  `count` int(11) NOT NULL,
  `kind` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`bookname`,`pub`,`price`,`date`,`count`,`kind`) values (1,'霸道总裁爱上我','总裁出版社','38','2020-03-23 20:01:27',6,'言情类'),(5,'西游记','西游出版社','66','2020-02-02 20:00:00',10,'文学类'),(6,'三国演义','三国出版社','68','2019-12-31 16:00:00',25,'文学类'),(7,'红楼梦','红楼出版社','58','2020-01-01 06:00:00',28,'言情类'),(8,'水浒传','水壶出版社','76','2024-08-03 06:00:00',22,'文学类'),(9,'活着','人民出版社','66','2020-02-22 16:00:00',5,'文学类'),(10,'白夜行','樱花出版社','52','2020-02-02 06:00:00',15,'文学类'),(11,'解忧杂货店','东京出版社','70','2020-02-01 16:00:00',8,'文学类'),(12,'人生','海南出版社','128','2020-02-01 16:00:00',25,'哲学类'),(13,'万物生','神秘出版社','45','2020-02-01 16:00:00',32,'哲学类'),(14,'java编程语言','秃头出版社','99','2020-02-02 06:00:00',20,'语言类');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` char(5) DEFAULT NULL,
  `perm` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`phone`,`email`,`sex`,`perm`,`role`) values (1,'fzc','123123','15682537720','516560181@qq.com','m','A-C-U-R-D','super-administrator'),(2,'szhn','123456','15682537720','516560181@qq.com','m','A-C-U-R-D','super-adminstrator'),(3,'fg','123456','15682537720','516560181@qq.com','m','R','guest'),(4,'baby','123456','15682537720','516560181@qq.com','f','R','guest'),(5,'Jane','123456','15682537720','516560181@qq.com','f','R','guest'),(6,'Michel','123456','15682537720','516560181@qq.com','m','R','guest'),(7,'Ali','123456','15682537720','516560181@qq.com','f','R','guest'),(8,'Richard','123456','15682537720','516560181@qq.com','m','R','guest'),(9,'bingbing','123456','15682537720','516560181@qq.com','f','R','guest'),(10,'chris','123456','15682537720','516560181@qq.com','m','R','guest'),(11,'imeimei','123456','15682537720','516560181@qq.com','f','R','guest');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
