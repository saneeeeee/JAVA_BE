-- DML (Data Management Language)
-- 데이터 조작 언어

-- 테이블에 레코드를 조작(추가, 수정, 삭제, 죄회)하기 위한 명령어들
-- INSERT(추가)
-- UPDATE(수정)
-- DELETE(삭제)
-- SELECT(조회 및 선택)

-- [1] 샘플 테이블 생성
create table exam01(
	deptno number(2),		-- 부서번호
	dname varchar2(14),	-- 부서명
	loc varchar2(14)			--	위치
);

-- [2] 레코드 추가
-- 레코드 추가 명령 사용1
-- insert into 테이블 이름( 필드명1, 필드명2, ... ) values( 값1, 값2, ... )
-- 값은 문자('123')와 숫자(123)를 구분하여 입력합니다

-- 레코드 추가 명령 사용2
-- insert into 테이블이름 values (전체 column(필드, 열)에 넣을 값들);

-- 첫번째 방식은 필드명과 입력되어야 하는 값을 1:1 로 매핑하여 입력합니다
-- 널값이 있어도 되는 필드는 필드명, 또는 기본값이 있는 필드명은 필드명과 값을 생략하고 입력가능합니다
-- 두번째 방식은 모든 필드에 해당하는 데이터를 모두 입력하는 경우로서 필드명들을 명령어 속에
-- 나열하지 않아도 되지만, 필드의 순서대로 빠짐없이 데이터가 나열되어야 하는 불편함도 잇습니다.

-- 첫번째 방식의 레코드 추가
insert into exam01(deptno, dname, loc) values(10,'ACCOUNT','NEW YORK');

-- 두번째 방식의 레코드 추가
insert into exam01 values(30, 'SALES','CHICHAGO');
	
-- 두가지 방법 모두 null 값을 입력할 수 있습니다
insert into exam01(deptno, dname) values(20,'MARKETING');	-- 첫번째 방법
insert into exam01 values(40,'OPERATION',null);

select * from exam01;

-- 두가지 방법중 자유롭게 선택하여서, booklist 테이블에 10개의 레코드를 추가해주세요.
-- num 은 시퀀스를 이용합니다
-- grade 는 'all' '13' '20' 세가지만 골라서 입력해주세요



insert into booklist (num,subject,makeyear,inprice,rentprice,grade)
values(book_seq.nextVal, '좀비아이',2020,12000,2500,'all');
insert into booklist values(book_seq.nextVal, '일곱해의 마지막',2020,12150,2000,'all');
insert into booklist values(book_seq.nextVal, '불편한 편의점',2021,12600,2000,'18');
insert into booklist values(book_seq.nextVal, '미드나잇 라이브러리',2021,14220,2000,'18');
insert into booklist values(book_seq.nextVal, '달러구트 꿈 백화점',2020,12420,2500,'13');
insert into booklist values(book_seq.nextVal, '달러구트 꿈 백화점2',2021,12420,2500,'13');
insert into booklist values(book_seq.nextVal, '크리스마스 피그',2021,18000,3000,'all');
insert into booklist values(book_seq.nextVal, '밝은 밤',2021,13050,2000,'all');
insert into booklist values(book_seq.nextVal, '완전한 행복',2021,14220,2500,'all');
insert into booklist values(book_seq.nextVal, '아몬드',2017,10800,2000,'13');

delete from booklist;

select * from booklist;

-- 같은 방식으로 memberlist 에 7명의 데이터를 추가해주세요. member_seq 를 이용해주세요
select * from MEMBERLIST;
insert into memberlist values(member_seq.nextVal,'추신수','010-4232-1231','84/07/07',240,'20/10/01','M',38);
insert into memberlist values(member_seq.nextVal,'강수진','010-5454-8775','79/12/22',220,'20/07/01','F',43);
insert into memberlist values(member_seq.nextVal,'김민수','010-3433-1245','07/11/06',120,'20/08/01','M',15);
insert into memberlist values(member_seq.nextVal,'최진수','010-5432-1723','99/01/01',20,'20/11/01','M',23);
insert into memberlist values(member_seq.nextVal,'박수민','010-1762-3267','93/03/15',140,'21/01/01','M',29);
insert into memberlist values(member_seq.nextVal,'김지영','010-3254-5223','81/05/27',180,'21/05/01','F',41);
insert into memberlist values(member_seq.nextVal,'이민영','010-1221-4351','00/11/17',220,'21/08/01','F',22);
insert into memberlist values(member_seq.nextVal,'조효진','010-3321-5664','87/12/12',240,'20/10/01','M',35);

-- rentlist 테이블도 rent_seq 를 이용해서 10개의 데이터를 추가해주세요
drop sequence rent_seq;
create sequence rent_seq start with 1 increment by 1;


select * from rentlist;
delete from rentlist;

-- rentlist 테이블도 rent_seq 를 이용해서 10개의 데이터를 추가해주세요
insert into RENTLIST values('2021/12/01',rent_seq.nextVal,15,22,100); -- 실패
-- integrity constraint (SCOTT.FK1) violated - parent key not found
insert into RENTLIST values('2021/12/01',rent_seq.nextVal,3,1,100);
insert into RENTLIST values('2021/12/02',rent_seq.nextVal,4,13,300);
insert into RENTLIST values('2021/12/03',rent_seq.nextVal,5,14,200);
insert into RENTLIST values('2021/12/02',rent_seq.nextVal,6,15,200);
insert into RENTLIST values('2021/12/02',rent_seq.nextVal,3,20,100);
insert into RENTLIST values('2021/12/05',rent_seq.nextVal,2,2,300);
insert into RENTLIST values('2021/12/05',rent_seq.nextVal,1,3,200);
insert into RENTLIST values('2021/12/06',rent_seq.nextVal,5,1,100);
insert into RENTLIST values('2021/12/01',rent_seq.nextVal,7,16,100);
insert into RENTLIST values('2021/12/07',rent_seq.nextVal,8,17,300);

select * from rentlist;

-- [3] 데이터 변경 - 수정(UPDATE)
-- UPDATE 테이블명 SET 변경내용 WHERE 검색 조건
-- update memberlist set age = 30 where membernum = 10;

-- 명령문에 wherer 이후 구문은 생략이 가능합니다
-- 다만 이 부분을 생략하면 모든 레코드를 대상으로 해서 update 명령이 실행되어 모든 레코드가 수정됩니다.
-- 검색 조건 : 필드명 (비교-관계연산자) 조건값 으로 이루어진 조건연산이며, 흔히 자바에서 if()
-- 괄호안에 사용했던 연산을 그대로 사용하는게 보통입니다.
-- 나이가 29세 이상 -> where age >= 29

-- 데이터 수정의 실 예
-- exam01 테이블에서 deptno 값을 모두 30으로 수정
update exam01 set deptno = 30;
-- exam01 테이블에서 dname이 'ACCOUNT' 인 레코드의 deptno 를 10으로 수정
update exam01 set deptno = 10 where dname = 'ACCOUNT';

-- exam01 테이블에서 dname이 'SALES' 인 레코드의 deptno 를 20으로 수정하세요
update exam01 set deptno = 20 where dname = 'SALES';
-- exam01 테이블에서 dname이 'OPERATION' 인 레코드의 deptno 를 30으로 수정하세요
update exam01 set deptno = 30 where dname = 'OPERATION';
-- exam01 테이블에서 dname이 'MARKETING' 인 레코드의 deptno 를 40으로 수정하세요
update exam01 set deptno = 40 where dname = 'MARKETING';
-- exam01 테이블에서 deptno 를 30인 레코드의 loc 를 'BOSTON' 로 수정하세요
update exam01 set loc = 'BOSTON' where deptno = 30;
-- exam01 테이블에서 deptno 를 40인 레코드의 loc 를 'LA' 로 수정하세요
update exam01 set loc = 'LA' where deptno = 40;

select * from exam01;

select * from booklist;
-- booklist 테이블의 제목 '봉제인형 살인사건' 도서의 grade 를 '18'으로 수정
update booklist set grade = '18' where subject = '밝은 밤';
-- emp 테이블의 모든 사원의 sal 값을 10% 씩 인상
update emp set sal = sal*1.1;
-- emp 테이블에서 sal 값이 3000이상인 사원의 급여 10% 삭감
update emp set sal = sal*0.9 where sal >= 3000;
-- emp 테이블의 hiredate가 2002년 이전인 사원의 급여를 + 2000
update emp set sal = sal+2000 where hiredate <= '2001-12-31';
update emp set sal = sal+2000 where hiredate < '2002-01-01';
-- emp 테이블의 ename 이 j로 시작하는 사원의 job을 manager로 변경
update emp set job = 'MANAGER' where ename like 'J%';
update emp set job = 'MANAGER' where ename like '%J';		-- J로 끝나는 이름 검색
update emp set job = 'MANAGER' where ename like '%J%';	-- J를 포함하는 이름 검색
-- memberlist 테이블에서 bpoint 가 200이 넘는 사람만 bpoint*100으로 변경
update MEMBERLIST set Bpoint = Bpoint*100 where Bpoint> 200;
-- rentlist 테이블에서 할인금액이 100원이 넘으면 모두 할인금액을 90으로 변경
update rentlist set discount = 90 where discount >100;

-- 등급이 '18' 인 책은 rentprice 을 10% 인상 , 책 제목 끝에 18+ 추가
update booklist set rentprice = rentprice*1.1, subject = subject || ' 18+' where grade = '18';
-- 오라클의 문자 이어붙이기 연산 : ||

-- booklist에 grade 가 '18'인 레코드의 grade 를 '20' 으로 변경, rentprice을 10% 인상,
-- 책 제목 끝에 20+ 를 추가해주세요.
update booklist set grade = '20', rentprice = rentprice*1.1, subject = subject || '20+' where grade = '18';
-- value too large for column "SCOTT"."BOOKLIST"."SUBJECT" (actual: 32, maximum: 30)
alter table booklist modify subject varchar2(100);

select * from booklist;
select * from MEMBERLIST ;
select * from rentlist;
select * from emp;


-- [4] 레코드의 삭제
-- delete from 테이블명 where 조건식
-- rentlist 테이블에서 discount가 100이하인 레코드를 삭제
delete from rentlist where discount <= 100;
-- where 절이 없으면 테이블 내의 모든 레코드를 삭제합니다.

-- 삭제의 제한
delete from booklist where subject ='좀비아이';
-- 봉제인형 살인 사건 도서가 rentlist 에 대여목록으로 존재하므로...
-- 외래키의 참조 무결성에 위배됩니다. 따라서 이 삭제 명령은 에러가 발생합니다.
select * from booklist;
select * from rentlist;
-- integrity constraint (SCOTT.FK1) violated - child record found


-- 해결방법 #1
-- 이를 해결하려면 우선 rentlist 테이블에  해당 도서 대여목록 레코드를 모두 삭제한 후
-- booklist 테이블에서 해당 도서를 삭제해야 합니다

delete from RENTLIST where booknum = 5;
delete from booklist where num = 5;


-- 해결방법 #2
-- 외래키 제약조건을 삭제한 후 다시 생성
-- 생성시에 옵션을 추가해서 참조되는 값이 삭제되면 참조하는 값도 같이 삭제되게 구성합니다
alter table rentlist drop constraint fk1;
alter table rentlist add constraint fk1 foreign key(booknum) references BOOKLIST(num) on delete cascade;
-- on delete cascade : booklist의 도서가 삭제되면
--								rentlist 의 해당 도서 대여내역도 함께 삭제하는 옵션

-- memberlist 테이블에서 회원 한명을 삭제하면, rentlist 테이블에서도 해당회원이 대여한 기록을
-- 같이 삭제하도록 외래키 설정을 바꿔주세요(외래키 제약조건 삭제 후 재생성)
alter table rentlist drop constraint fk2;
alter table rentlist add constraint fk2 foreign key(membernum) references memberlist(num) on delete cascade;

-- 참조되는 값의 삭제가 아니라 수정은 적용되지 않습니다.
-- booklist 와 memberlist 테이블의 num 은 대여기록이 있을경우 수정이 아직 불가능합니다
-- 이를 해결하기 위해서 외래키 설정시 on update cascade 옵션을 추가하면 될듯 하지만
-- 이는 오라클에서 허용하지 않습니다
-- mysql에서만 사용이 가능하며, 오라클에서는 뒷단원의 트리거를 공부하면서 외래키가
-- 수정이 되도록 하겠습니다.