SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_deptment
-- ----------------------------
DROP TABLE IF EXISTS `tb_deptment`;
CREATE TABLE `tb_deptment`
(
  `did`            int(11)      NOT NULL auto_increment,
  `dname`           varchar(255) ,
  `pid`            int(11)   ,  
  PRIMARY KEY (`did`)         ,
  index `idx_pid` (`pid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
