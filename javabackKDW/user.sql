CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `email` VARCHAR(45) NOT NULL COMMENT '사용자 이메일',
  `password` VARCHAR(255) NOT NULL COMMENT '사용자 비밀번호',
  `nickname` VARCHAR(45) NOT NULL COMMENT '사용자 닉네임',
  `tel_number` VARCHAR(13) NOT NULL COMMENT '사용자 전화번호',
  `address` TEXT NOT NULL COMMENT '사용자 주소',
  `profile` TEXT NULL COMMENT '사용자 프로필 사진 URL',
  PRIMARY KEY (`email`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
COMMENT = '사용자 정보'