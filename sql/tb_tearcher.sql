SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`
(
  `tid`            varchar(50)      NOT NULL ,
  `openid`      varchar(50) ,
  `did`            int(11)    ,
  `tname`           varchar(255) NOT NULL,
  `avatar` varchar(255),
  `phone` varchar(12)  NOT NULL  ,
  `gender`  tinyint,
  `nickName` varchar(255),
  PRIMARY KEY (`tid`),
   index `idx_tid` (`tid`) ,
   index `idx_tname` (`tname`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
