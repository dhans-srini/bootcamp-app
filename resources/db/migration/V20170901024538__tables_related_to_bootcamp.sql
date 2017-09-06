CREATE TABLE `modules`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `tags` VARCHAR(255) NOT NULL,
  `unique_key` VARCHAR(50),
  `descriptions` LONGTEXT,
  `show_discriptions` TINYINT(1) DEFAULT 0,
  `org_id` BIGINT(20) NOT NULL,
  `is_scheduled` TINYINT(1) DEFAULT 0,
  `duration` SMALLINT(10),
  `duration_uom` VARCHAR(7),
  `is_hidden` TINYINT(1) DEFAULT 0,
  `is_active` TINYINT(1) DEFAULT 0,
  `parent_module_id` BIGINT(20),
  `created_by` BIGINT(20) NOT NULL,
  `created_on` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `mfk1_org_id` FOREIGN KEY (`org_id`) REFERENCES `organizations`(`ID`),
  CONSTRAINT `mfk2_created_by` FOREIGN KEY (`created_by`) REFERENCES `employees`(`ID`)
);


CREATE TABLE `curriculum_activities`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  `video_id` BIGINT(20),
  `quiz_id` BIGINT(20),
  `score` INT(10),
  `descriptions` LONGTEXT,
  `show_description` TINYINT(1) DEFAULT 0,
  `is_scheduled` TINYINT(1) DEFAULT 0,
  `duration` SMALLINT(10),
  `duration_uom` VARCHAR(7),
  `is_hidden` TINYINT(1) DEFAULT 0,
  `is_submission_req` TINYINT(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `cafk1_video_id` FOREIGN KEY (`video_id`) REFERENCES `videos`(`ID`),
  CONSTRAINT `cafk2_quiz_id` FOREIGN KEY (`quiz_id`) REFERENCES `assessments`(`ID`)
);


CREATE TABLE `curriculum_act_refs`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NOT NULL,
  `curriculum_act_id` BIGINT(20) NOT NULL,
  `uniq_name` VARCHAR(255),
  `file_name` VARCHAR(255),
  `video_id` BIGINT(20),
  `ref_url` VARCHAR(255),
  `descriptions` LONGTEXT,
  `is_tutorial_link` TINYINT(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `careffk1_video_id` FOREIGN KEY (`video_id`) REFERENCES `videos`(`ID`),
  CONSTRAINT `careffk2_cact_id` FOREIGN KEY (`curriculum_act_id`) REFERENCES `curriculum_activities`(`id`)
);


CREATE TABLE `curriculum_act_req_artifacts`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `curriculum_act_id` BIGINT(20) NOT NULL,
  `allowed_file_types` VARCHAR(500),
  `no_of_submission_allowed` INT(11) DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `carafk1_cact_id` FOREIGN KEY (`curriculum_act_id`) REFERENCES `curriculum_activities`(`id`)
);


CREATE TABLE `curriculum_module_activities`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `module_id` BIGINT(20) NOT NULL,
  `curriculum_act_id` BIGINT(20) NOT NULL,
  `parent_curriculum_act_id` BIGINT(20),
  `display_order` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `cmafk1_module_id` FOREIGN KEY (`module_id`) REFERENCES `modules`(`id`),
  CONSTRAINT `cmafk1_curriculum_act_id` FOREIGN KEY (`curriculum_act_id`) REFERENCES `curriculum_activities`(`id`)
);


CREATE TABLE `curriculums`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `descriptions` LONGTEXT,
  `unique_key` VARCHAR(50),
  `org_id` BIGINT(20) NOT NULL,
  `is_active` TINYINT(1) DEFAULT 0,
  `mode` CHAR(1),
  `created_on` DATETIME,
  `created_by` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `cfk1_org_id` FOREIGN KEY (`org_id`) REFERENCES `organizations`(`ID`),
  CONSTRAINT `cfk2_created_by` FOREIGN KEY (`created_by`) REFERENCES `employees`(`ID`)
);


CREATE TABLE `curriculum_sections`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `curriculum_id` BIGINT(20) NOT NULL,
  `display_order` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `csfk1_curriculum_id` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculums`(`id`)
);


CREATE TABLE `curriculum_section_contents`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `curriculum_sec_id` BIGINT(20) NOT NULL,
  `module_id` BIGINT(20) NULL,
  `curriculum_act_id` BIGINT(20) NULL,
  `parent_curriculum_act_id` BIGINT(20),
  `display_order` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `cscfk1_cur_sec_id` FOREIGN KEY (`curriculum_sec_id`) REFERENCES `curriculum_sections`(`id`),
  CONSTRAINT `cscfk1_module_id` FOREIGN KEY (`module_id`) REFERENCES `modules`(`id`),
  CONSTRAINT `cscfk1_cur_act_id` FOREIGN KEY (`curriculum_act_id`) REFERENCES `curriculum_activities`(`id`)
);


CREATE TABLE `curriculum_histories`(  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `curriculum_id` BIGINT(20) NOT NULL,
  `updated_by` BIGINT(20) NOT NULL,
  `updated_on` DATETIME,
  PRIMARY KEY (`id`),
  CONSTRAINT `chfk1_cur_id` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculums`(`id`),
  CONSTRAINT `chfk1_updated_by` FOREIGN KEY (`updated_by`) REFERENCES `employees`(`ID`)
);
