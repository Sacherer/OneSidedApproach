SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
  `openid`      varchar(50) NOT NULL,
  `c_id`            int(11)    ,
  `uname`           varchar(255) NOT NULL,
  `gender`  tinyint,
  `phone` int(11)  ,
  `avatar` varchar(255),
  `isAdmin` varchar(255),
  `isVerify` tinyint,
  `nickName` varchar(255),
  PRIMARY KEY (`openid`),
   index `idx_openid` (`openid`) ,
   index `idx_uname` (`uname`) ,
   index `idx_nickName` (`nickName`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
