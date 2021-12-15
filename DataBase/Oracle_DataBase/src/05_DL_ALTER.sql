--	테이블의 수정(ALTER)

--	1. 필드명의 변경
--	ALTER TABLE 테이블 이름 RENAME COLUMN 변경전 이름 TO 변경 후 이름
-- 테이블 이름 : 변경하고자하는 필드명이 있는 테이블의 이름

-- booklist 테이블의 subject 필드명을 title 로 수정하세요
alter table booklist rename column subject to title;
-- 반대로 title 필드명을 subject 필드명으로 수정합니다
alter table booklist rename column title to subject;
-- memberlist 테이블의 membername 필드를 name 으로 변경하세요
alter table MemberList rename column memberName to name;
-- rentlist 테이블의 rent_date 필드를 rentdate 로 변경하세요
alter table rentlist rename column rent_date to rentdate;
-- rentlist 의 idx 를 numseq 로 변경하세요
alter table rentlist rename column idx to numseq;
-- booklist 의 booknum 을 num 으로 변경하세요
alter table booklist rename column booknum to num;
-- memberlist 의 membernum 을 num 으로 변경하세요
alter table memberlist rename column membernum to num;

select * from booklist;
select * from MemberList;
select * from rentlist;

-- 테이블을 만들며 생성한 기본키와 외래키 등등은 필드명이 바뀌면, 바뀐 이름으로 자동 적용됩니다

-- 외래키는 참조하는 필드의 자료형과, 참조되는 필드의 자료형이 일치해야, 생성도 되고 유지도 됩니다
-- 따라서 아래의 필드의 자료형 변경을 연결된 외래키에서 하려고 한다면 에러입니다.

-- 2. 필드 자료형의 변경
-- ALTER TABLE 테이블명 MODIFY 필드명 자료형

-- varchar2(12) 였던 memberlist 테이블의 name 필드를 varchar2(50)으로 변경
alter table memberlist modify name varchar2(50);		-- 수정 성공

-- booklist 의 num 필드를 varchar2(5) 로 자료형 변경
alter table booklist modify num varchar2(5);				-- 수정 실패

-- column type incompatible with referenced column type 수정 실패
-- 참조되는 컬럼(필드)의 자료형이 현재 수정하려는 컬럼(필드)자료형과 호환되지 않음.

-- 외래키로 연결되어서 참조되고, 참조하고 있는 필드들은 위의 명령으로 수정이 바로 불가능합니다
-- 가능하게 하려면, 외래키 제약 조건을 수정하여 없애버리고, 참조되는 필드와 참조하는 필드를 모두
-- 수정한 후 외래키 제약 조건을 다시 설정합니다
-- alter 명령에 의해서 제약조건을 수정하는 명령을 아래에서 학습합니다

-- 3. 필드의 추가
-- ALTER TABLE 테이블명 ADD 필드명 자료형

-- booklist에 구매등급을 저장할 수 있는 grade 필드를 varchar2(15)로 추가
alter table booklist add grade varchar2(15);

-- memberlist 에 성별(gender) 필드를 varchar2(3) 으로 추가
alter table memberlist add gender varchar2(3);

-- memberlist 에 나이(age) 필드를 number(2) 로 추가
alter table memberlist add age number(2);

-- 4. 필드의 삭제
-- ALTER TABLE 테이블명 DROP COLUMN 필드명
-- memberlist 테이블에서 성별 필드 제거
alter table memberlist drop column gender;

-- booklist에 grade 필드 삭제
alter table booklist drop column grade;

-- memberlist 에 나이(age) 필드를 삭제
alter table memberlist drop column age;

-- 다음 항목을 위해 삭제됐던 필드들 다시 생성
alter table booklist add grade varchar2(15);
alter table memberlist add gender varchar2(3);
alter table memberlist add age number(2);


-- 5. 제약 조건의 추가/제거

-- 삭제 : ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명
-- rentlist 테이블의 booknum 에 걸려 있는 외래키 제약조건 제거
alter table rentlist drop constraint fk1;
-- rentlist 테이블의 membernum 에 걸려 있는 외래키 제약조건 제거
alter table rentlist drop constraint fk2;
-- rentlist 테이블의 기본키 제거
alter table rentlist drop constraint rent_pk;

-- 위에서 실패했던 필드의 자료형 수정 재실행
-- booklist 의 num 을 varchar2(5) 로 수정
alter table booklist modify num varchar2(5);
-- memberlist 의 num 을 varchar2(5) 로 수정
alter table memberlist modify num varchar2(5);
-- rentlist 의 booknum 을 varchar2(5) 로 수정
alter table rentlist modify booknum varchar2(5);
-- rentlist 의 membernum 을 varchar2(5) 로 수정
alter table rentlist modify membernum varchar2(5);

-- 원래대로 복원
alter table booklist modify num number(5);
alter table memberlist modify num number(5);
alter table rentlist modify booknum number(5);
alter table rentlist modify membernum number(5);


-- 추가 : ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건식

-- 필드 level(수준) 의 제약 조건은 필드의 modify  하여서 같이 수정 생성 합니다.
-- 테이블 level 의 제약 조건은 위의 명령 형식으로 제약조건 이름과 함께 추가합니다

-- memberlist 테이블의 성별(gender) 필드에 'F','M' 두글자만 입력되도록 제약조건을 추가하세요
alter table memberlist add constraint check_gender check(gender in ('F','M'));
-- in() 함수 : 괄호안의 항목 중 하나에 해당하면 true 가 리턴되는 함수입니다. 위의 내용은 chekc 함수에 의해
-- gender 필드에 들어갈 값이 in() 함수 안의 항목 중 하나와 같다면 입력 허용, 아니면 불허하는 제약조건입니다

-- memberlist 테이블의 나이(age) 필드에 120 살이 초과 되는 나이는 입력되지 못하게 제약 조건 추가
alter table memberlist add constraint check_age check(age<100);

-- 위에 삭제되었던 fk1, fk2, rent_pk 제약조건은 다시 설정하세요
-- rent_pk 는 num 필드로만 설정하세요

alter table rentlist add constraint fk1 foreign key (booknum) references booklist(num);
alter table rentlist add constraint fk2 foreign key (membernum) references memberlist(num);
alter table rentlist add constraint rent_pk primary key(booknum,membernum);

select * from BOOKLIST;
select * from MEMBERLIST;
select * from RENTLIST;

-- 테이블 생성 연습 문제

create table orders1(
	order_id number(12,0),
	order_date date,
	order_mode varchar2(8),
	customer_id number(6,0),
	order_status number(2,0),
	order_total number(8,2) default 0,
	sales_rep_id number(6,0),
	promotion_id number(6,0),
	constraint order_pk primary key (order_id),
	constraint mode_ck check (order_mode in('direct','online'))
);

-- 테이블 수정 예제
alter table orders1 rename column customer_id to customer_number;
alter table orders1 add constraint pid_ck check(promotion_id between 10000 and 99999);

-- 테이블의 복사
create table orders2 as select * from orders1;
-- as select 구분은 select 구문 이후에 다시 학습합니다

-- 테이블의 제거
drop table orders2 purge; -- purge 는 생략 가능
-- purge 가 없이 삭제된 테이블은 나중에 휴지통과 같이 복구가 가능
-- purge 를 사용하면 완전 삭제

select * from orders1;