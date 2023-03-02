# DB는 프로젝트, 테이블은 클래스, 열은 멤버 변수
# Board DataBase 만들기
CREATE DATABASE PEED;
USE PEED;

# User 테이블 생성
CREATE TABLE User(                        # 참조할 땐 기본키를 참조
   id INT PRIMARY KEY AUTO_INCREMENT,     # 아이디 / 정수 형태 / 기본키 / 자동 증가
   password VARCHAR(30) NOT NULL,         # 패스워드 / 길이 30의 가변 문자열 / 필수 값
   name VARCHAR(50) NOT NULL,             # 이름 / 길이 50의 가변 문자열 / 필수 값
   telNumber VARCHAR(15) NOT NULL UNIQUE  # 전화번호 / 길이 15의 가변 문자열 / 필수 값 / 중복 불가
   # password, name은 이미 쓰이고 있는 키워드라 이름색깔이 다름
   # 테이블 내에서는 이미 쓰이고 있는 키워드 써줘도 됨   
);

# Board 테이블 생성
# 게시물 번호 (boardNumber)가 존재하고 정수 타입으로 및 자동 증가로 관리, 게시물 번호로 각 데이터를 구분
# 게시물 제목 (boardTitle)이 존재하고 길이 200의 가변 문자열 및 필수 값으로 관리
# 게시물 내용 (boardContent)이 존재하고 길이의 제한이 없는 문자열 및 필수 값으로 관리
# 게시물 작성일 (boardDate)이 존재하고 날짜 타입이고 필수 값으로 관리
# 게시물 작성자 (boardWriter)가 존재하고 정수 형태 및 필수 값으로 관리
CREATE TABLE Board( # table = entity
 boardNumber INT AUTO_INCREMENT PRIMARY KEY,
 boardTitle VARCHAR(200) NOT NULL,
 boardContent TEXT NOT NULL, # 길이 제한이 없으면 TEXT
 boardDate DATE NOT NULL,
 boardWriter INT NOT NULL
);

# User 레코드를 삽입, DDL은 CREATE? DML은 INSERT?
# 아이디는 자동 값을 그대로 사용, 비밀번호는 'P!ssw0rd', 이름 '고길동', 전화번호는 '010-4488-9944'인 데이터를 생성

# -- 회원가입 때 사용 --
INSERT INTO User(password, name, telNumber) VALUES('P!ssw0rd', '고길동', '010-4488-9944');

# User 테이블에서 이름이 '고길동'인 레코드의 비밀번호를 'qwer1234!!'로 수정
# -- 각종 회원 정보 수정 할 때 사용 --
UPDATE User SET password = 'qwer1234' WHERE name = '고길동';

# User 테이블에서 id가 1인 레코드를 삭제
# 
DELETE FROM USER WHERE id = 1;
DROP TABLE BOARD;

INSERT INTO Board(boardTitle, boardContent, boardDate, boardWriter) 
VALUES ('안녕하세요. 처음뵙겠습니다.', '반갑습니다. 처음뵙겠습니다.', '2023-01-11', 3);
INSERT INTO Board(boardTitle, boardContent, boardDate, boardWriter) 
 VALUES ('10번 게시글', '10번 게시글입니다.', '2023-01-11', 3);
# 전체 게시물 보기
SELECT * FROM Board;

# 최신 글 순으로 보기
SELECT * FROM Board ORDER BY boardDate DESC;

# 오래된 글 순으로 보기
SELECT * FROM Board ORDER BY boardDate;

# 10일 이내 작성된 글 보기
SELECT * FROM Board WHERE boardDate >= '2023-01-08';

# 10일 이내에 작성된 글을 최신순으로 보기
SELECT * FROM Board WHERE boardDate >= '2023-01-08' ORDER BY boardDate DESC;

# 작성자가 1이면서 10일 이내에 작성된 글을 최신순으로 보기
SELECT * FROM Board WHERE boardWriter = 1 AND boardDate >= '2023-01-08' ORDER BY boardDate DESC;

# 게시물 제목에 '안녕하세요'가 포함된 게시글 보기
SELECT * FROM Board WHERE boardTitle LIKE '%안녕하세요%';

# 게시물 내용에 '반갑습니다'가 포함된 게시글 보기
SELECT * FROM Board WHERE boardContent LIKE '%반갑습니다%';

# 게시물 제목 + 내용에 '안녕히가세요'가 포함된 게시글 보기
SELECT * FROM Board WHERE boardContent LIKE '%안녕히가세요' OR boardTitle LIKE '%안녕히가세요';

SELECT * FROM Board WHERE boardTitle Like '%%';
# board 테이블에서 boardWriter가 1이거나 2인 레코드에서 모든 컬럼 선택
SELECT * FROM Board WHERE boardWriter = 1 OR boardWriter = 2;
SELECT * FROM Board WHERE boardWriter BETWEEN 1 AND 2;
SELECT * FROM Board WHERE boardWriter IN(1, 2);

# Board 테이블에서 boardDate가 2023-01-03부터 2023-01-10까지의 레코드 중 모든 컬럼을 선택
SELECT * FROM Board WHERE boardDate BETWEEN '2023-01-03' AND '2023-01-10';

# Board 테이블에서 작성일자가 1월 달인 레코드 중에서 모든 컬럼 선택
SELECT * FROM Board WHERE boardDate BETWEEN '2023-01-01' AND '2023-01-31'; # 2월은 사용 힘들 수도
SELECT * FROM Board WHERE boardDate LIKE '%-01-%'; # LIKE % 사용
SELECT * FROM Board WHERE boardDate LIKE '____01___'; # LIKE _ 사용

DROP TABLE Board;
DROP TABLE User;

CREATE TABLE Board(
    id INT AUTO_INCREMENT PRIMARY KEY,
    boardTitle VARCHAR(200) NOT NULL,
    boardContent TEXT NOT NULL,
    boardDateTime DATETIME NOT NULL,
    boardLike INT DEFAULT 0,
    boardWriter INT NOT NULL,
    
    CONSTRAINT Board_FK FOREIGN KEY(boardWriter)
    REFERENCES User(id)
); # 테이블 만들 땐 세미콜론 잘 찍기

SELECT * FROM Board;
SELECT * FROM User;

INSERT INTO User(password, name, telNumber) VALUES('P!ssw0rd', 'John Doe', '010-1111-4444');
INSERT INTO User(password, name, telNumber) VALUES('qwer1234!!', 'Alies', '010-2222-8888');
INSERT INTO User(password, name, telNumber) VALUES('NewJeans', 'BROWN', '010-3333-6666');
INSERT INTO User(password, name, telNumber) VALUES('ah-oh', 'yahoo', '010-4363-5676');

INSERT INTO Board(boardTitle, boardContent, boardDateTime, boardWriter) 
VALUES('Hello World!', 'Hello MySQL', now(), 1);
INSERT INTO Board(boardTitle, boardContent, boardDateTime, boardWriter) 
VALUES('Hello World!', 'Hello MySQL@', now(), 2);
INSERT INTO Board(boardTitle, boardContent, boardDateTime, boardWriter) 
VALUES('Good Bye World!', 'Good Bye MySQL', now(), 3);
INSERT INTO Board(boardTitle, boardContent, boardDateTime, boardWriter) 
VALUES('Muyaho', 'yaho', now(), 4);

# 게시물을 작성한 경험이 있는 유저의 이름과 전화번호, 작성한 게시물 제목을 구하시오.
SELECT U.name, U.telNumber, B.boardTitle FROM User2 AS U, Board AS B WHERE U.id = B.boardWriter;

SELECT U.name, U.telNumber, B.boardTitle FROM User2 AS U RIGHT JOIN Board AS B ON U.id = B.boardWriter;

# 게시물을 작성한 경험이 있는 유저의 이름과 전화번호를 구하시오
SELECT DISTINCT U.name, U.telNumber FROM User2 AS U, Board AS B WHERE U.id = B.boardWriter;

SELECT name, telNumber FROM USER2 WHERE id IN( SELECT DISTINCT boardWriter FROM Board);