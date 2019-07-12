SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_s
-- ----------------------------
DROP TABLE IF EXISTS `t_s`;
CREATE TABLE `t_s`
(
  `id`      int(11) NOT NULL auto_increment,
  `sid`     int(11) ,
  `tid`     int(11) ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
