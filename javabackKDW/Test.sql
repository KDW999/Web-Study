CREATE DATABASE BLOG; # DB 생성
SHOW DATABASES; # DB 확인

USE BLOG; # DB 사용

CREATE TABLE BlogData(
  boardNum INT Auto_INCREMENT PRIMARY KEY,
  boardTitle VARCHAR(50) NOT NULL

);

SELECT * FROM BlogData WHERE boardTitle = '일기';

ALTER TABLE BlogData ADD boardWelcome VARCHAR(30);
ALTER TABLE BlogData ADD boardCategory VARCHAR(30) NOT NULL;
ALTER TABLE BlogData DROP boardCategory;
ALTER TABLE BlogData MODIFY COLUMN boardCategory INT;

INSERT INTO BlogData(boardTitle, BoardWelcome) VALUES('일기', '어서와');

UPDATE BlogData SET boardTitle = '야호' WHERE boardWelcome = '어서와';
