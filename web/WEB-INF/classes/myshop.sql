create database MyShop;
use Myshop;

SET FOREIGN_KEY_CHECKS = 0;


# 管理员表
DROP TABLE IF EXISTS t_admin;
CREATE TABLE t_admin
(
  aname varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  apwd  varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (aname)
) ENGINE = InnoDB #InnoDB，是MySQL的数据库引擎之一
  DEFAULT CHARSET = utf8 #数据库默认编码为utf-8
  COLLATE = utf8_unicode_ci;

INSERT INTO t_admin
VALUES ('罗丛建', '970603');


# 用户表
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
  id     int(11)                             NOT NULL AUTO_INCREMENT,
  uemail varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  upwd   varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


#购物车表
DROP TABLE IF EXISTS t_shoppingcar;
CREATE TABLE t_shoppingcar
(
  `id`          int(11) NOT NULL AUTO_INCREMENT,
  `user_id`     int(11) NOT NULL,
  `goods_id`    int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`user_id`),
  KEY `gno` (`goods_id`),
  CONSTRAINT `bid` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `gno` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


# 关注表
DROP TABLE IF EXISTS `t_focus`;
CREATE TABLE `t_focus`
(
  `id`        int(11) NOT NULL AUTO_INCREMENT,
  `goods_id`  int(11) NOT NULL,
  `user_id`   int(11) NOT NULL,
  `focustime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gno1` (`goods_id`),
  KEY `bid1` (`user_id`),
  CONSTRAINT `bid1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `gno1` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


# 商品信息表
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`
(
  `id`           int(11) NOT NULL AUTO_INCREMENT,
  `gname`        varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goprice`      double                              DEFAULT NULL,
  `grprice`      double                              DEFAULT NULL,
  `gstore`       int(11)                             DEFAULT NULL,
  `gpicture`     varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodstype_id` int(11)                             DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`goodstype_id`),
  CONSTRAINT `typeid` FOREIGN KEY (`goodstype_id`) REFERENCES `t_goodstype` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


# 商品类型表
DROP TABLE IF EXISTS `t_goodstype`;
CREATE TABLE `t_goodstype`
(
  `id`       int(11)                             NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


# 公告表
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`
(
  `id`       int(11) NOT NULL AUTO_INCREMENT,
  `ntitle`   varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL,
  `ncontent` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ntime`    datetime                             DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


# 订单基础表
DROP TABLE IF EXISTS `t_orderbase`;
CREATE TABLE `t_orderbase`
(
  `id`        int(11)    NOT NULL AUTO_INCREMENT,
  `user_id`   int(11)    NOT NULL,
  `amount`    double     NOT NULL,
  `status`    tinyint(4) NOT NULL,
  `orderdate` datetime   NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid2` (`user_id`),
  CONSTRAINT `bid2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;


# 订单详情表
DROP TABLE IF EXISTS `t_orderdetail`;
CREATE TABLE `t_orderdetail`
(
  `id`           int(11) NOT NULL AUTO_INCREMENT,
  `orderbase_id` int(11) NOT NULL,
  `goods_id`     int(11) NOT NULL,
  `shoppingnum`  int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `odsn` (`orderbase_id`),
  KEY `gno3` (`goods_id`),
  CONSTRAINT `odsn` FOREIGN KEY (`orderbase_id`) REFERENCES `t_orderbase` (`id`),
  CONSTRAINT `gno3` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 16
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
