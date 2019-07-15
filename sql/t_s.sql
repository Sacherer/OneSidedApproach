SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_s
-- ----------------------------
DROP TABLE IF EXISTS `t_s`;
CREATE TABLE `t_s`
(
  `id`      int(11) NOT NULL auto_increment,
  `sid`     varchar(50) ,
  `tid`     varchar(50) ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
