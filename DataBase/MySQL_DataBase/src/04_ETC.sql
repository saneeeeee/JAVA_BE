--	command 창에서 운영되는 mysql 프로그램 접속

--	mysql -h localhost -u root -p
--		-h 는 호스트, -u 는 사용자 -p 는 비밀번호 의미

--	mysql 종료는 quit 또는 exit

--	Schema 생성
create schema scott default character set utf8mb4;

--	사용하려는 스키마로 이동
use scott;

--	현재 스키마의 테이블 보기
show tables;

--	테이블 구조보기
desc 테이블이름;




--	LIMIT
--	select 로 데이터 조회 할때 조회할 레코드의 갯수를 조절 제한할 수 있습니다.
select * from memberlist order by num desc limit 5;
--	회원 정보 조회하여 5개의 레코드만 리턴

--	OFFSET
--	select 로 데이터 조회할 때, 맨위에서 부터 offset 에 지정한 번째까지는 뛰어넘고 그 다음부터 리턴
select * from memberlist order by num desc limit 3 offset 5;
--	6번째 데이터 부터 3개의 레코드 리턴 - 개수가 모자르면 있는곳까지 리턴

--	limit 와 offset 동시사용
select * from memberlist order by num desc limit 5 offset 5;
--	6번째 데이터부터 5개의 레코드리턴
--	offset 과 limit 는 게시판이나, 상품 진열시에 페이지를 표시하기 위한 용도로 가장 많이 사용됩니다.