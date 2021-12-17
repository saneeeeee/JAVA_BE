-- 그룹 함수(Group Function) : 지정된 필드의 값 전체를 대상으로 한번 계산하는 함수


-- sum() : 특정 필드의 합계
-- 대여 가격의 합계
select sum(rentprice) as "대여가격 합계" from booklist;
-- 입고가격이 18000 원 이상인 책들의 대여 가격 합계
select sum(rentprice) as "대여가격 합계" from booklist where inprice >= 18000;

-- count(*) : 필드 내의 데이터 갯수(레코드 갯수)
-- 전체 회원 수
select count(*) as "회원 인원 수" from memberlist;
-- 사은 포인트가 150 이상인 회원의 인원 수
select count(*) as "회원 인원 수" from memberlist where bpoint >= 150;

-- avg : 평균
select round(avg(inprice),0) from BOOKLIST;

-- max : 최대값
select max(inprice) from booklist;

-- min : 최소값
select min(inprice) from booklist;

-- variance(분산), stddev(표준편차)
select variance(salary), stddev(salary) from employees;




-- group by : 하나의 필드를 지목해서 같은 값끼리 그룹을 형상한 결과를 도출합니다
-- 전체 대여 건수
select count(*) from rentlist;

-- 각 도서별 대여 건수 : 한번도 대여안된 도서 제외
select booknum, count(*) from rentlist group by BOOKnum;

-- rentlist 날짜별 할인금액의 평균
select rentdate, round( avg(discount), 0) from rentlist group by rentdate order by rentdate desc;

-- rentlist 날짜별 대여 건수
select rentdate, count(*) from rentlist group by rentdate order by rentdate desc;

select * from employees;
-- employees 테이블의 부서 id 별 급여의 평균
select department_id as "부서 id", round(avg(salary),0) as "급여 평균" from employees group by department_id;
-- kor_loan_status 테이블의 period (년도와 월) 을 그룹으로 대출 잔액(loan_jan_amt)의 합계
select * from kor_loan_status;
select period, sum(loan_jan_amt) from kor_loan_status group by period;

-- period( 년도와 월 ) 을 1차 그룹으로 region(지역) 을 2차 그룹으로 한
-- 대출 잔액(loan_jan_amt)의 합계
select period, region, sum(loan_jan_amt) from kor_loan_status group by period, region;

-- having 절 : 그룹핑된 내용들에 조건을 붙일때
-- 날짜별 할인 금액의 평균을 출력합니다. 다만 그 평균 금액이 100미만인 그룹만 출력
select rentdate as 날짜, avg(discount) as 할인평균 from rentlist group by rentdate having avg(discount)<180;

--- ★★★ GROUP BY 절에는 SELECT 와 FROM 사이에 쓰여진 함수를 제외한 모든 필드를 반드시 써줘야 합니다.