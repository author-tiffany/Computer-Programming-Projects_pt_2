-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`INSTRUCTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`INSTRUCTOR` (
  `INSTRUCTOR_ID` INT NOT NULL,
  `COURSE` VARCHAR(45) NULL,
  PRIMARY KEY (`INSTRUCTOR_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`COURSE` (
  `COURSE_ID` INT NOT NULL,
  `COURSE_NAME` VARCHAR(45) NULL,
  `TERM` VARCHAR(45) NULL,
  `INSTRUCTOR_ID` VARCHAR(45) NULL,
  `DEPARTMENT_ID` INT NULL,
  `DEPARTMENT_TYPE` VARCHAR(45) NULL,
  `INSTRUCTOR_NAME` VARCHAR(45) NULL,
  `INSTRUCTOR_INSTRUCTOR_ID` INT NOT NULL,
  `COURSE_INSTRUCTOR_INSTRUCTOR_ID` INT NOT NULL,
  PRIMARY KEY (`COURSE_INSTRUCTOR_INSTRUCTOR_ID`),
  INDEX `fk_COURSE_COURSE1_idx` (`COURSE_INSTRUCTOR_INSTRUCTOR_ID` ASC) VISIBLE,
  CONSTRAINT `fk_COURSE_INSTRUCTOR1`
    FOREIGN KEY (`INSTRUCTOR_INSTRUCTOR_ID`)
    REFERENCES `mydb`.`INSTRUCTOR` (`INSTRUCTOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_INSTRUCTOR_INSTRUCTOR_ID`)
    REFERENCES `mydb`.`COURSE` (`INSTRUCTOR_INSTRUCTOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RESIDENCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RESIDENCE` (
  `RESIDENCE_ID` INT NOT NULL,
  `RESIDENCE_NAME` VARCHAR(45) NULL,
  `STREET_NUMBER` VARCHAR(45) NULL,
  `STREET` VARCHAR(45) NULL,
  `CITY` VARCHAR(45) NULL,
  `ZIP` VARCHAR(45) NULL,
  PRIMARY KEY (`RESIDENCE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STUDENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STUDENTS` (
  `STUDENT_ID` INT NULL,
  `STUDENT_NAME` VARCHAR(45) NULL,
  `SSN` INT NULL,
  `DOB` DATETIME NULL,
  `ADDRESS1` VARCHAR(45) NULL,
  `ADDRESS2` VARCHAR(45) NULL,
  `ZIP` VARCHAR(45) NULL,
  `GUARDIANNAME` VARCHAR(45) NULL,
  `STUDENTSCOL` VARCHAR(45) NULL,
  `RESIDENCE_ID` INT NULL,
  `RESIDENCE_ADDRESS` VARCHAR(45) NULL,
  `DEPARTMENT_ID` INT NULL,
  `DEPARTMENT_NAME` VARCHAR(45) NULL,
  `RESIDENCE_RESIDENCE_ID` INT NOT NULL,
  PRIMARY KEY (`STUDENT_ID`, `RESIDENCE_RESIDENCE_ID`),
  INDEX `fk_STUDENTS_RESIDENCE1_idx` (`RESIDENCE_RESIDENCE_ID` ASC) VISIBLE,
  CONSTRAINT `fk_STUDENTS_RESIDENCE1`
    FOREIGN KEY (`RESIDENCE_RESIDENCE_ID`)
    REFERENCES `mydb`.`RESIDENCE` (`RESIDENCE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STUDENT_COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STUDENT_COURSE` (
  `STUDENT_ID` INT NOT NULL AUTO_INCREMENT,
  `COURSE_ID` VARCHAR(45) NOT NULL,
  `TERM` VARCHAR(45) NULL,
  `NUMBER_OF_STUDENT` INT NULL,
  `COURSE_INSTRUCTOR_INSTRUCTOR_ID` INT NOT NULL,
  `STUDENTS_STUDENT_ID` INT NOT NULL,
  PRIMARY KEY (`STUDENT_ID`, `COURSE_INSTRUCTOR_INSTRUCTOR_ID`, `STUDENTS_STUDENT_ID`),
  INDEX `fk_STUDENT_COURSE_COURSE1_idx` (`COURSE_INSTRUCTOR_INSTRUCTOR_ID` ASC) VISIBLE,
  INDEX `fk_STUDENT_COURSE_STUDENTS1_idx` (`STUDENTS_STUDENT_ID` ASC) VISIBLE,
  CONSTRAINT `fk_STUDENT_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_INSTRUCTOR_INSTRUCTOR_ID`)
    REFERENCES `mydb`.`COURSE` (`INSTRUCTOR_INSTRUCTOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_STUDENT_COURSE_STUDENTS1`
    FOREIGN KEY (`STUDENTS_STUDENT_ID`)
    REFERENCES `mydb`.`STUDENTS` (`STUDENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DEPARTMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DEPARTMENT` (
  `DEPARTMENT_ID` INT NOT NULL,
  `DEPARTMENT_NAME` VARCHAR(45) NULL,
  `DEPARTMENT_HEAD` VARCHAR(45) NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PARKING`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PARKING` (
  `PARKING_ID` INT NOT NULL,
  `PARKING_PERMIT` VARCHAR(45) NULL,
  `CAR_MODEL` VARCHAR(45) NULL,
  `LICENSE_PLATE_NUMBER` VARCHAR(45) NULL,
  `STUDENTS_STUDENT_ID` VARCHAR(45) NULL,
  `STUDENTS_DEPARTMENT_NAME` VARCHAR(45) NULL,
  `STUDENT_RESIDENCE_ADDRESS` VARCHAR(45) NULL,
  `STUDENTS_STUDENT_ID1` INT NOT NULL,
  PRIMARY KEY (`PARKING_ID`),
  INDEX `fk_PARKING_STUDENTS_idx` (`STUDENTS_STUDENT_ID1` ASC) VISIBLE,
  CONSTRAINT `fk_PARKING_STUDENTS`
    FOREIGN KEY (`STUDENTS_STUDENT_ID1`)
    REFERENCES `mydb`.`STUDENTS` (`STUDENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STUDENT_RESIDENCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STUDENT_RESIDENCE` (
  `STUDENT_ID` INT NOT NULL,
  `ROOM_NUMBER` INT NULL,
  `HALL_NUMBER` INT NULL,
  `RESIDENCE_ID` INT NULL,
  `STUDENTS_STUDENT_ID` INT NULL,
  `STUDENTS_DEPARTMENT_NAME` VARCHAR(45) NULL,
  `STUDENTS_RESIDENCE_ADDRESS` VARCHAR(45) NULL,
  `STUDENTS_STUDENT_ID1` INT NOT NULL,
  `RESIDENCE_RESIDENCE_ID` INT NOT NULL,
  PRIMARY KEY (`STUDENT_ID`, `RESIDENCE_RESIDENCE_ID`),
  INDEX `fk_STUDENT_RESIDENCE_STUDENTS1_idx` (`STUDENTS_STUDENT_ID1` ASC) VISIBLE,
  INDEX `fk_STUDENT_RESIDENCE_RESIDENCE1_idx` (`RESIDENCE_RESIDENCE_ID` ASC) VISIBLE,
  CONSTRAINT `fk_STUDENT_RESIDENCE_STUDENTS1`
    FOREIGN KEY (`STUDENTS_STUDENT_ID1`)
    REFERENCES `mydb`.`STUDENTS` (`STUDENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_STUDENT_RESIDENCE_RESIDENCE1`
    FOREIGN KEY (`RESIDENCE_RESIDENCE_ID`)
    REFERENCES `mydb`.`RESIDENCE` (`RESIDENCE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
