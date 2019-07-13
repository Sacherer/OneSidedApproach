SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`
(
  `tid`            int(11)      NOT NULL ,
  `openid`      varchar(50) NOT NULL,
  `did`            int(11)    ,
  `tname`           varchar(255) NOT NULL,
  `avatar` varchar(255),
  `phone` int(11)  ,
  `gender`  tinyint,
  `nickName` varchar(255),
  PRIMARY KEY (`tid`),
   index `idx_tid` (`tid`) ,
   index `idx_tname` (`tname`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
