SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_classes
-- ----------------------------
DROP TABLE IF EXISTS `tb_classes`;
CREATE TABLE `tb_classes`
(
  `c_id`            int(11)      NOT NULL auto_increment,
  `cname`           varchar(255) NOT NULL,
  `cnum`            int(10),
  PRIMARY KEY (`c_id`),
  index `idx_cname` (`cname`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
