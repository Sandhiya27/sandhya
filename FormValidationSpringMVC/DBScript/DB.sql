CREATE TABLE `Usertable` (
  `id` int(11) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `gender` varchar(10) default NULL,
  `course` varchar(100) NOT NULL,
  `location` varchar(100) default NULL,
  `email` varchar(50) NOT NULL,
  `pwd` varchar(20) default NULL,
  `mobile` bigint(30) default NULL,
  PRIMARY KEY  (`id`)
) ;


