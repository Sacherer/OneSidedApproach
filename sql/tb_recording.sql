SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_recording
-- ----------------------------
DROP TABLE IF EXISTS `tb_recording`;
CREATE TABLE `tb_recording`
(
  `rid`            int(11)      NOT NULL auto_increment,
  `cid`     int(11) ,
  `sid`     int(11) ,
  `did`     int(11) ,
  `thumbup`           int(11)      ,
  `visits`            int(11)      ,
  `recordingTime`     varchar(255)  ,
  `fileUrl`          varchar(255) ,
  `isAdopt` int(10)  ,  
  PRIMARY KEY (`rid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
