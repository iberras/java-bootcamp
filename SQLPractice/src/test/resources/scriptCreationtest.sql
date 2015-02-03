CREATE DATABASE `high-schoolTest`;
USE `high-schoolTest`;
CREATE TABLE `Schedule` (
  `idSchedule` INT(11) NOT NULL AUTO_INCREMENT,
  `Day` varchar(10) NOT NULL,
  `HourStart` varchar(15) NOT NULL,
  `HourEnd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSchedule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Student` (
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `registrationNumber` INT(11) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` date NOT NULL,
  PRIMARY KEY (`registrationNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Teacher` (
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Course` (
  `idCourse` INT(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `idAssignedTeacher` int(11) NOT NULL,
  `hoursByWeek` int(11) NOT NULL,
  `idSchedule` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCourse`),
  KEY `idTeacherAssigned_idx` (`idAssignedTeacher`),
  KEY `Schedule_idx` (`idSchedule`),
  CONSTRAINT `Schedule` FOREIGN KEY (`idSchedule`) REFERENCES `Schedule` (`idSchedule`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Teacher` FOREIGN KEY (`idAssignedTeacher`) REFERENCES `Teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Notas` (
  `idStudent` INT(11) NOT NULL AUTO_INCREMENT,
  `idCourse` INT(11) NOT NULL AUTO_INCREMENT,
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


