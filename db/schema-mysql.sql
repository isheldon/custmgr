CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(20) NOT NULL,
  `real_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `manager_id` VARCHAR(45) NULL,
  `role` VARCHAR(30) NULL DEFAULT 'SALES',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_UNIQUE` (`user_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;