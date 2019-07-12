SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_recording
-- ----------------------------
DROP TABLE IF EXISTS `tb_recording`;
CREATE TABLE `tb_recording`
(
  `rid`            int(11)      NOT NULL auto_increment,
  `openid`      varchar(50) ,
  `fileName`      varchar(255) NOT NULL,
  `thumbup`           int(11)      ,
  `visits`            int(11)      ,
  `uploadTime`        datetime     ,
  `recordingTime`     varchar(255)  ,
  `companyName`       varchar(255) ,
  `fileUrl`          varchar(255) ,
  `isAdopt` int(10)  ,  
  PRIMARY KEY (`rid`),
   index `idx_openid` (`openid`) ,
   index `idx_companyName` (`companyName`) ,
   index `idx_uploadTime` (`uploadTime`) 
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
