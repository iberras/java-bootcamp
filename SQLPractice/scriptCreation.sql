CREATE DATABASE IF NOT EXISTS `high-schoolDB`;
USE `high-schoolDB`;
CREATE TABLE IF NOT EXISTS `Schedule` (
  `idSchedule` int(11) NOT NULL,
  `HourStart` datetime NOT NULL,
  `HourEnd` datetime NOT NULL,
  PRIMARY KEY (`idSchedule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `Student` (
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `registrationNumber` int(11) NOT NULL,
  `dateOfBirth` date NOT NULL,
  PRIMARY KEY (`registrationNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `Teacher` (
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `Course` (
  `idCourse` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `idAssignedTeacher` int(11) NOT NULL,
  `hoursByWeek` int(11) NOT NULL,
  `idSchedule` int(11) NOT NULL,
  PRIMARY KEY (`idCourse`),
  KEY `idTeacherAssigned_idx` (`idAssignedTeacher`),
  KEY `Schedule_idx` (`idSchedule`),
  CONSTRAINT `Schedule` FOREIGN KEY (`idSchedule`) REFERENCES `Schedule` (`idSchedule`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Teacher` FOREIGN KEY (`idAssignedTeacher`) REFERENCES `Teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `Notas` (
  `idStudent` int(11) NOT NULL,
  `idCourse` int(11) NOT NULL,
  `year` year(4) NOT NULL,
  `partialNote1` decimal(10,0) unsigned DEFAULT NULL,
  `partialNote2` decimal(10,0) DEFAULT NULL,
  `partialNote3` decimal(10,0) DEFAULT NULL,
  `finalNote` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idStudent`,`idCourse`,`year`),
  KEY `Course_idx` (`idCourse`),
  CONSTRAINT `Course` FOREIGN KEY (`idCourse`) REFERENCES `Course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Student` FOREIGN KEY (`idStudent`) REFERENCES `Student` (`registrationNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Marcelo', 'Berra', '1', '2010-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Patricio','Berra','2','2010-01-07');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Silvia','Santamarina','3','2010-06-08');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Felipe','Naveiro','4','2010-05-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Inaki','Berra','5','2010-10-10');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Maria','Berra','6','2010-12-11');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Camila','Virla','7','2010-03-02');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Eliel','Madero','8','2010-02-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Juan Pablo','Berra','9','2010-01-10');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Joaquin','Burs','10','0002-04-10');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Carla','Migliore','11','2010-04-10');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Ines','Blanco','12','2001-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Fernando','Blanco','13','2001-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Javier','Casal','14','1999-03-03');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Delfina','Casal','15','2004-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Lucas','Goni','16','2010-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Tomas','Goni','17','2002-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Segundo','Goni','18','1998-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Martin','Abella','19','2001-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Student`
(`firstName`,
`lastName`,
`registrationNumber`,
`dateOfBirth`)
VALUES
('Hernan','Abella','20','1997-01-05');
INSERT IGNORE INTO `high-schoolDB`.`Schedule`
(`idSchedule`,
`HourStart`,
`HourEnd`)
VALUES
('1','2011-02-02 09:00:00','2011-02-02 10:00:00');
INSERT IGNORE INTO `high-schoolDB`.`Schedule`
(`idSchedule`,
`HourStart`,
`HourEnd`)
VALUES
('2','2011-02-03 10:00:00','2011-02-03 11:00:00');
INSERT IGNORE INTO `high-schoolDB`.`Schedule`
(`idSchedule`,
`HourStart`,
`HourEnd`)
VALUES
('3','2011-02-04 20:00:00','2011-02-04 22:00:00');
INSERT IGNORE INTO `high-schoolDB`.`Schedule`
(`idSchedule`,
`HourStart`,
`HourEnd`)
VALUES
('4','2011-02-05 13:00:00','2011-02-05 15:00:00');
INSERT IGNORE INTO `high-schoolDB`.`Schedule`
(`idSchedule`,
`HourStart`,
`HourEnd`)
VALUES
('5','2011-02-06 17:00:00','2011-02-06 18:00:00');
INSERT IGNORE INTO `high-schoolDB`.`Teacher`
(`firstName`,
`lastName`,
`dateOfBirth`,
`id`)
VALUES
('Laura','Conforte','1980-01-05','1');
INSERT IGNORE INTO `high-schoolDB`.`Teacher`
(`firstName`,
`lastName`,
`dateOfBirth`,
`id`)
VALUES
('Fernando','Dente','1981-01-05','2');
INSERT IGNORE INTO `high-schoolDB`.`Teacher`
(`firstName`,
`lastName`,
`dateOfBirth`,
`id`)
VALUES
('Silvia','Guerrero','1970-01-05','3');
INSERT IGNORE INTO `high-schoolDB`.`Course`
(`idCourse`,
`name`,
`idAssignedTeacher`,
`hoursByWeek`,
`idSchedule`)
VALUES
('1','Lengua','1','2','1');
INSERT IGNORE INTO `high-schoolDB`.`Course`
(`idCourse`,
`name`,
`idAssignedTeacher`,
`hoursByWeek`,
`idSchedule`)
VALUES
('2','Matematica','2','2','2');
INSERT IGNORE INTO `high-schoolDB`.`Course`
(`idCourse`,
`name`,
`idAssignedTeacher`,
`hoursByWeek`,
`idSchedule`)
VALUES
('3','Biologia','3','2','3');
INSERT IGNORE INTO `high-schoolDB`.`Course`
(`idCourse`,
`name`,
`idAssignedTeacher`,
`hoursByWeek`,
`idSchedule`)
VALUES
('4','Ingles','3','2','4');
INSERT IGNORE INTO `high-schoolDB`.`Course`
(`idCourse`,
`name`,
`idAssignedTeacher`,
`hoursByWeek`,
`idSchedule`)
VALUES
('5','Literatura','2','2','5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('1', '1', 2014, '5', '6', '7', '6');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('2', '1', 2014, '6', '7', '8', '7');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('3', '1', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('4', '1', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('5', '1', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('6', '1', 2014, '9', '9', '9', '9');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('7', '1', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('8', '1', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('9', '1', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('10', '1', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('11', '1', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('12', '1', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('13', '1', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('14', '1', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('15', '1', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('16', '1', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('17', '1', 2014, '9', '9', '9', '9');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('18', '1', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('19', '1', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('20', '1', 2014, '10', '10', '10', '10');

INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('1', '2', 2014, '5', '6', '7', '6');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('2', '2', 2014, '6', '7', '8', '7');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('3', '2', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('4', '2', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('5', '2', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('6', '2', 2014, '9', '9', '9', '9');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('7', '2', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('8', '2', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('9', '2', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('10', '2', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('11', '2', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('12', '2', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('13', '2', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('14', '2', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('15', '2', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('16', '2', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('17', '2', 2014, '9', '9', '9', '9');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('18', '2', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('19', '2', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('20', '2', 2014, '10', '10', '10', '10');

INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('1', '3', 2014, '5', '6', '7', '6');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('2', '3', 2014, '6', '7', '8', '7');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('3', '3', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('4', '3', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('5', '3', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('6', '3', 2014, '9', '9', '9', '9');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('7', '3', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('8', '3', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('9', '3', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('10', '3', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('11', '3', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('12', '3', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('13', '3', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('14', '3', 2014, '8', '8', '8', '8');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('15', '3', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('16', '3', 2014, '10', '10', '10', '10');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('17', '3', 2014, '9', '9', '9', '9');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('18', '3', 2014, '4', '4', '4', '4');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('19', '3', 2014, '5', '5', '5', '5');
INSERT IGNORE INTO `high-schoolDB`.`Notas` (`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`) VALUES ('20', '3', 2014, '10', '10', '10', '10');



