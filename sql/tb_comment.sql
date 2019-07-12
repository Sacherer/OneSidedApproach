SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`
(
  `mid`            int(11)      NOT NULL auto_increment,
  `rid`            int(11)     ,
  `content`           varchar(520) ,
  `mTime` datetime,
  PRIMARY KEY (`mid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
