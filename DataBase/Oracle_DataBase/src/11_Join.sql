-- JOIN 
-- ; 두개이상의 테이블에 나눠져 있는 관련 데이터들을 하나의 테이블로 모아서 조회하고자 할때
-- 사용하는 명령 입니다.

-- [1] 이름 Douglas Grant가 근무하는 부서명과 상급 부서 출력하고자 한다면...
select * from employees;
select * from departments;


select department_id from employees where emp_name = 'Douglas Grant';
-- 위 명령을 실행 후 얻어진 부서 번호로 아래와 같이 부서 번호 검색하여 부서명과 상급 부서의 이름을 알아냅니다
select department_name, parent_id from departments where department_id = 50;
select department_name from departments where department_id = 10;

-- 위 두개의 명령을 하나의 명령으로 합해주는 역할을 join 명령이 실행합니다

-- * 가장 최악의 결과를 얻는 조인 방식
-- A 테이블과 B 테이블의 cross join 된다면
-- A 테이블의 1번 레코드와 B 테이블의 모든 레코드와 하나하나 모두 조합
-- A 테이블의 2번 레코드와 B 테이블의 모든 레코드와 하나하나 모두 조합
-- A 테이블의 3번 레코드와 B 테이블의 모든 레코드와 하나하나 모두 조합
	
select * from dept;	-- 레코드 4, 필드 3
select * from emp;	-- 레코드 14, 필드 8

-- 크로스 조인
select * from dept, emp;

-- equi join : 조인 대상이 되는 두테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성
select * from emp, dept where emp.deptno = dept.deptno;

-- 각 사원의 이름, 부서번호, 부서명, 지역을 출력하세요
select emp.ename, emp.deptno, dept.dname, dept.loc from emp, dept where emp.deptno = dept.deptno;

-- 이름 Douglas Grant 가 근무하는 부서명과 상급 부서의 이름을 출력하고자한다면...
select employees.emp_name as 사원이름, employees.department_id as 부서번호, departments.department_name as 부서명,employees.salary as 월급여 from employees , departments where employees.emp_name = 'Douglas Grant' and employees.department_id = departments.department_id;

-- 이름이 SCOTT 인 사원의 이름 , 부서번호, 부서명, 위치 출력
select emp.ename as 사원이름, emp.deptno as 부서번호, dept.dname as 부서명, dept.loc as 위치 from emp, dept where emp.deptno = dept.deptno and emp.ename='SCOTT';
 
-- 필드명 앞에 테이블이름을 기술하여 컬럼의 소속을 명확히 해주어야 오류가 없습니다.


-- rentlist 의 booknum 에 해당하는 도서제목을 rentlist 의 rentdate, num, booknum 과 함께 출력하세요
select * from rentlist;
select * from rentlist, booklist;
select * from rentlist, booklist where rentlist.booknum = booklist.num;
select rentlist.rentdate, rentlist.numseq , rentlist.booknum, booklist.subject
from rentlist, booklist where rentlist.booknum = booklist.num;

-- rentlist 의 membernum 에 해당하는 회원의 이름과 전화번호를 rentlist 의 rentdate, num, -- membernum 과 함께 출력하세요
select memberlist.name, memberlist.phone, rentlist.rentdate, rentlist.num 
from rentlist, memberlist where rentlist.membernum = memberlist.num;

alter table rentlist rename column numseq to num;

-- 테이블 명에 별칭을 부여한 후 컬럼 앞에 소속 테이블을 지정
-- 테이블 명으로 소속을 기술할 때는 한쪽에만 있는 필드에 생략이 가능하지만 아래와 같이
-- 별칭 부여시에는 모든 필드 앞에 반드시 별칭을 기술해야함
select a.ename, b.dname, b.loc, a.deptno from emp a, dept b
where a.deptno = b.deptno and a.ename = 'SCOTT';

-- non-equi join
-- 동일 컬럼이 없어서 다른 조건을 사용하여 조인
-- 조인 조건에 특정 범위내에 있는지를 조사하기 위해 조건절에 조인 조건을 '=' 연산자 이외의 비교

select * from emp;
select * from salgrade;

-- 연산자를 이용
select a.ename, a.sal, b.grade from emp a, salgrade b
where a.sal>b.losal and a.sal<=b.hisal;

select a.ename, a.sal, b.grade from emp a, salgrade b
where a.sal between b.losal and b.hisal;

-- 세개의 테이블을 하나로 JOIN(equi, non-equi 조인의 조
select a.ename, a.sal, c.grade, b.dname from emp a, dept b, salgrade c
where a.deptno = b.deptno and a.sal <= c.hisal and a.sal >losal ;

select a.ename, a.sal, c.grade, b.dname from emp a, dept b, salgrade c
where a.deptno = b.deptno and a.sal between c.losal and c.hisal;

select * from emp;
select * from dept;
select * from salgrade;
select * from booklist;

update booklist set subject = subject || '20+' where grade = '20';
-- 연습 문제
-- rentlist 테이블의 rentdate, booknum, membernum 을 조회하되,
-- booklist 와 memberlist 테이블을 조인해서 책 제목과 대여가격, 회원 이름과 사은 포인트를 출력하세요
-- 출력순서 - 대여일자, 도서제목, 회원이름, 포인트
-- 테이블의 별칭은 a,b,c로 하세요

select a.rentdate as "대여 일자", b.subject as "도서 제목", c.name as "회원 성명", c.bpoint as "사은포인트" 
from rentlist a, booklist b, memberlist c
where a.membernum = c.num and b.num = a.booknum;

-- 2021 12 30 시험 문제 예상 --
-- 조인된 테이블에 계산식으로 필드를 생성할 수도 있습니다.
select a.rentdate as "대여 일자", b.subject as "도서 제목", c.name as "회원 성명", c.bpoint as "사은포인트", 
			b.rentprice - a.discount as "매출 금액" 
from rentlist a, booklist b, memberlist c
where a.membernum = c.num and b.num = a.booknum;



-- outer join
-- 조인 조건에 만족하지 못해서 해당 결과를 출력시에 누락이 되는 문제점이 발생할 때 해당 레코드를 출력하는 조인
select a.num, a.subject, b.rentdate from booklist a, rentlist b
where a.num(+) = b.booknum;

select * from emp a, dept b
where a.deptno(+)=b.deptno;


-- [3] ANSI join
--		(1) Ansi Cross Join
select * from emp, dept;				-- 일반크로스 조인 표현
select * from emp cross join dept;	-- ansi Cross join -> 일반 크로스 조인과 같은 표현

--		(2) Ansi Inner Join	-- 일반 equi 조인과 같은 효과
-- 일반 equi 조인 표현 방식
select ename, dname from emp a, dept b where a.deptno = b.deptno;
-- Ansi 이너 조인의 표현 방식
select ename, dname from emp inner join dept on emp.deptno = dept.deptno;
-- Ansi 이너 조인의 다른 표현 방식 : 두 테이블의 조인 기준이 되는 필드명이 똑같을 때만 사용
select ename, dname from emp inner join dept using (deptno);

--		(3) Ansi Outer Join 	
-- 기존 아우터 조인의 표현 방식
select * from emp, dept where emp.deptno = dept.deptno(+);
select * from emp, dept where emp.deptno(+) = dept.deptno;
-- Ansi Outer Join 표현 방식
select * from emp left outer join dept on emp.deptno = dept.deptno;
select * from emp right outer join dept on emp.deptno = dept.deptno;
-- 기준이 되는 필드명 중 A 테이블의 필드에는 있으나 B 테이블 필드에는 해당값이 없는 경우에 대한 표현 여부 결정

