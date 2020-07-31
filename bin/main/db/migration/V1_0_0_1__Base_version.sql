USE `telemed`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: telemed
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

SET FOREIGN_KEY_CHECKS=0;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `availability` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `start` varchar(255) NOT NULL,  
  `end` varchar(255) DEFAULT NULL,
  `type` varchar(36) DEFAULT NULL,
  `all_day` tinyint(1) DEFAULT '0',
  `group_id` varchar(36) DEFAULT NULL,
  `schedule_type` varchar(36) DEFAULT NULL,
  `timezone` varchar(36) DEFAULT NULL,
  `schedule_status` varchar(36) DEFAULT NULL,
  `time_slot_start` varchar(36) DEFAULT NULL,
  `time_slot_end` varchar(36) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `role_id` INT NOT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `email` (`email`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` varchar(36) NOT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `patient`
--


DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` varchar(36) NOT NULL,
  `middle_name` varchar(36) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `patient_age` varchar(36) DEFAULT NULL,
  `patient_gender` varchar(36) DEFAULT NULL,
  `email` varchar(36) DEFAULT NULL,
  `contact_number` varchar(36) DEFAULT NULL,
  `insurance_details_id` BIGINT DEFAULT NULL,
  `appointment_details_id` BIGINT DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `provider`
--


DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `doctor_id` BIGINT NOT NULL AUTO_INCREMENT,
  `appointment_dates` varchar(255) DEFAULT NULL,
  `appointments_slots` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `recurring` bit(1) DEFAULT NULL,
  `specialities` varchar(255) DEFAULT NULL,
  `time_zones` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `insurance_details`
--


DROP TABLE IF EXISTS `insurance_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance_details` (
  `insurance_id` INT NOT NULL AUTO_INCREMENT,
  `member_id` varchar(36) NOT NULL,
  `group_name` varchar(36) DEFAULT NULL,
  `benefit_plan` varchar(255) NOT NULL,
  `effective_date` varchar(36) NOT NULL,
  `insurance_notes` varchar(36) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`insurance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `appointment_schedules`
--


DROP TABLE IF EXISTS `appointment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment_details` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `provider_id` varchar(255) DEFAULT NULL,
  `provider_name` varchar(255) DEFAULT NULL,
  `appointment_start_time` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `duration_unit` varchar(255) DEFAULT NULL,
  `appointment_note` varchar(255) DEFAULT NULL,
  `timezone` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_by` INT DEFAULT NULL,
  `modified_by` INT DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_details`
--

LOCK TABLES `appointment_details` WRITE;
/*!40000 ALTER TABLE `appointment_details` DISABLE KEYS */;
INSERT INTO `appointment_details` VALUES (1,"1","Satish","2:50","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (2,"1","Satish","3:00","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (3,"4","Suresh","4:00","30 minutes",NULL,NULL,"IST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (4,"1","Satish","3:30","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (5,"3","Mahesh","5:00","30 minutes",NULL,NULL,"CST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (6,"3","Mahesh","5:30","30 minutes",NULL,NULL,"CST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (7,"4","Suresh","6:30","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (8,"4","Suresh","2:00","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (9,"2","Varun","2:30","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (10,"2","Varun","6:00","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (11,"2","Varun","4:30","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
INSERT INTO `appointment_details` VALUES (12,"3","Mahesh","2:00","30 minutes",NULL,NULL,"EST",1,2,1,NOW(),NULL);
/*!40000 ALTER TABLE `appointment_details` ENABLE KEYS */;
UNLOCK TABLES;



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-09 15:30:33








