SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_d
-- ----------------------------
DROP TABLE IF EXISTS `t_d`;
CREATE TABLE `t_d`
(
  `id`      int(11) NOT NULL auto_increment,
  `did`     int(11) ,
  `tid`     varchar(50) ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
