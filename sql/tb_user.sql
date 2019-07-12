SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
  `uid`      varchar(50) NOT NULL,
  `username`           varchar(255) ,
  `password`           varchar(255) ,
  PRIMARY KEY (`uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
