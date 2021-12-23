CREATE TABLE scott.booklist (
  num INT NOT NULL AUTO_INCREMENT,
  subject VARCHAR(100) NOT NULL,
  makeyear INT NOT NULL,
  inprice INT NOT NULL,
  rentprice INT NOT NULL,
  grade VARCHAR(6) NULL DEFAULT 'all',
  PRIMARY KEY (num))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '도서 목록';

select * from `scott`.`booklist`;
-- AUTO_INCREMENT : 오라클의 sequence 를 대신하는 자동 숫자 증가 옵션
-- VARCHAR2 는 없고, VARCHAR 가 가변 길이 문자를 나타냅니다.
-- CONSTRAINT 없이 제약 사항을 표시합니다.
-- 테이블 이름 앞에 `스키마이름`. 을 반드시 붙여서 사용합니다.

-- 자주 쓰는 자료형
-- INT : 정수 자료형 (FLOAT, DOUBLE 은 실수)
-- VARCHAR : 문자열 자료형, 가변 길이(CHAR은 고정 길이)
-- TEXT : 긴 문자열은 TEXT로 별도 저장
-- DATETIME : 날짜 자료형 저장
-- TINYINT : -128 에서 127 까지 저장하지만 여기서는 1또는 0 만 저장해 불 값 표현

-- 자주 쓰는 제약 조건
-- NOT NULL : 빈 값은 받지 않는다는 뜻(NULL은 빈 값 허용)
-- AUTO_INCREMENT : 숫자 자료형인 경우 다음 로우가 저장될 때 자동으로 1 증가
-- UNSIGNED : 0 과 양수만 허용
-- ZEROFILL : 숫자의 자리 수가 고정된 경우 빈 자리에 0을 넣음
-- DEFAULT now() : 날짜 컬럼의 기본값을 현재 시간으로

create table scott.memberlist (
	num int not null auto_increment,
	name varchar(30) not null,
	birth datetime not null,
	bpoint int not null,
	joindate datetime default now(),
	age int null,
	gender varchar(3) null,
	primary key(num))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '회원 목록';

ALTER TABLE `scott`.`memberlist` 
ADD COLUMN `phone` VARCHAR(45) NULL AFTER `birth`,
CHANGE COLUMN `bpoint` `bpoint` INT NOT NULL DEFAULT 0 ;

CREATE TABLE `scott`.`rentlist` (
  `rentdate` DATETIME NOT NULL DEFAULT now(),
  `num` INT NOT NULL AUTO_INCREMENT,
  `booknum` INT NOT NULL,
  `membernum` INT NOT NULL,
  `discount` INT default 0,
  PRIMARY KEY (`num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '대출 목록';
