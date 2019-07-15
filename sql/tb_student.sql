SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`
(
  `sid`            varchar(50)      NOT NULL ,
  `openid`      varchar(50) NOT NULL,
  `did`            int(11)    ,
  `avatar` varchar(255),
  `phone` int(11)  ,
  `gender`  tinyint,
  `sname`           varchar(255) NOT NULL,
  `nickName` varchar(255),
  PRIMARY KEY (`sid`),
   index `idx_sid` (`sid`) ,
   index `idx_sname` (`sname`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
