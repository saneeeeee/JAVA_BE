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