SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_company
-- ----------------------------
DROP TABLE IF EXISTS `tb_company`;
CREATE TABLE `tb_company`
(
  `cid`            int(11)      NOT NULL auto_increment,
  `name`           varchar(255) NOT NULL,
  PRIMARY KEY (`cid`),
  index `idx_name` (`name`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
