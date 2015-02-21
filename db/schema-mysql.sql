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

CREATE TABLE `custmg`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `org_name` VARCHAR(200) NOT NULL,
  `org_address` VARCHAR(300) NULL,
  `contact_name` VARCHAR(50) NULL,
  `contact_phone` VARCHAR(40) NULL,
  `email` VARCHAR(50) NULL,
  `qq` VARCHAR(30) NULL,
  `contacted` INT NOT NULL DEFAULT 0, #0:待联系,1:已联系,2:未接通
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `org_name_UNIQUE` (`org_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `customer_memo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `memo_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `memo` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;