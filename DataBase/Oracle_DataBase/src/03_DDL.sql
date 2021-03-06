-- DDL(Data Definition Language) 데이터 정의어

-- 테이블의 생성(Create)
-- Create Table 테이블 이름(
--			필드명1 DATATYPE [DEFAULT 값 or 제약조건 및 형식],										
--			필드명2 DATATYPE [DEFAULT 값 or 제약조건 및 형식],
--			필드명3 DATATYPE [DEFAULT 값 or 제약조건 및 형식]
-- );

-- 도서대여점의 도서목록 테이블 생성
-- 필드 : booknum, subject, makeyear, inprice, rentprice
-- 자료형 : booknum(문자5자리), subject(문자30), makeyear(숫자4), inprice(숫자6),rentprice(숫자6)
-- 제약조건 : booknum(Not null), subject(Not null), makeyear(), inprice(), rentprice()
-- 기본키 : booknum

drop table booklist purge;

create table booklist(
	booknum varchar2(5) not null,
	subject varchar2(30) not null,
	makeyear number(4) default 2021,	-- number(4) 는 4바이트 숫자가 아니라 4자리 숫자를 의미합니다.
	inprice number(6) default 0,	
	rentprice number(6) default 0,			-- 마지막 필드를 쓰고 더 쓸 내용이 없으면 컴마(,)를 쓰지 않습니다.
	-- 제약조건은 필드 옆에 기술하는 필드레벨 제약조건이 있고, 테이블 생성 명령 마지막에 모아서 쓰
	-- 테이블 레벨의 제약조건이 있습니다.	제약조건은 어디에다 써도 무관합니다. 다만 필드레벨의 제약조건은
	-- 해당 필드 옆에 써야 그 필드에 적용됩니다.
	
	constraint booknum_pk primary key(booknum)
	-- constraint : 테이블 레벨의 제약조건을 지정하는 키워드
	-- booknum_pk : 테이블 외부에서 현재 제약조건을 컨트롤 하기 위한 제약조건의 고유 이름
	-- primary key(booknum) : 기본키로 booknum 을 지정하겠다는 뜻입니다.
);


-- Create Table 명령의 세부 규칙
-- 테이블의 이름은 객체를 의미할 수 있는 적절한 이름을 사용합니다(자바 변수 이름 규칙과 거의 동일)
-- 다른 테이블과 중복되지 않게 테이블 이름을 지정합니다
-- 한 테이블 내에서 필드이름도 중복되지 않게 합니다
-- 각 필드들은 ","로 구분하여 생성합니다
-- create를 비롯한 모든 sql명령은 ";"로 끝납니다
-- 필드명 뒤에 DATATYPE은 반드시 지정하고 []안에 내용은 해당내용이 있을 때 작성하며 생략 가능합니다
-- 테이블 명과 필드명은 반드시 문자로 시작해야 하고 예약어 명령어 등을 테이블명과 필드명으로 쓸 수 없습니다
-- 테이블 생성시 대/소문자 구분은 하지 않습니다(기본적으로 테이블이나 컬럼명은 대문자로 만들어짐)
-- DATE 데이터형식은 별도로 크기를 지정하지 않습니다
-- 문자데이터의 DataType -> varchar2(10), 숫자데이터의 데이터타입 -> number(4)
-- 문자 데이터 유형은 반드시 가질 수 있는 최대 길이를 표시해야 합니다
-- 컬럼과 컬럼의 구분은 컴마로 하되, 작성이 모두 종료되는 마지막 컬럼 또는 제약사항의 내용 뒤에는 컴마를 찍지 않습니다

-- 제약조건 (CONSTRAINT)
--	PRIMARY KEY
--		- 테이블에 저장된 레코드를 고유하게 식별하기 위한 키, 하나의 테이블에 하나의 기본키만 정의할 수 있습니다.
--		- 여러 필드가 조합된 기본키 생성 가능합니다
--		- 기본키는 중복된 값을 갖을 수 없으며 빈칸도 있을 ㅅ ㅜ없습니다
--		- PRIMARY KEY = UNIQUE KEY + NOT NULL
--	UNIQUE KEY
--		- 테이블에 저장된 행 데이터를 고유하게 식별하기 위한 고유키를 정의합니다
--		- 단 NULL 은 고유키 제약의 대상이 아니므로, NULL 값을 가진 행이 여러개가 UNIQUE KEY
--		  제약에 위반하지는 않습니다
-- NOT NULL
--		- 비어있는 상태, 아무것도 없는 상태를 허용하지 않습니다 	- 입력 필수
-- CHECK
--		- 입력할 수 있는 값의 범위를 제한한다. CHECK 제약으로는 TRUE or FALSE 로 평가할 수 있는
--		  논리식을 지정합니다
--	FOREIGN KEY
--		- 관계형 데이터 베이스에서 테이블간에 관계를 정의하기 위해 기본키를 다른 테이블의 외래키로
--		- 복사하는 경우 외래키가 생성됩니다 추가로 참조 무결성 제약 옵션이 생성됩니다 

-- 테이블 생성 2
-- 테이블 이름 : MemberList(회원리스트)
-- 필드 : memberNum, memberName, Phone, Birth, Bpoint, joinDate
-- 데이터 형식 : memberNum : VARCHAR2(5), memberName : VARCHAR2(12), 
--					Phone : VARCHAR2(13), Birth : DATE, Bpoint : NUMBER(6), 
--					joinDate : DATE
-- 제약조건 : memberNum, memberName, Phone 세 개의 필드 Not Null - 필드레벨로 설정
--				memberNum : Primary Key - 테이블 레벨로 설정
-- 				Bpoint 기본값 0, joinDate 기본값 sysdate( joindate date default sysdate)
 
drop table MemberList purge;

create table MemberList(
	memberNum varchar2(5) not null,
	memberName varchar2(12) not null,
	Phone varchar2(13) not null,
	Birth date,
	Bpoint number(6) default 0,
	joinDate date default sysdate,		-- 오늘 날짜를 표시하는 오라클의 키워드
	constraint member_pk primary key(memberNum)
);

select * from booklist;	-- 테이블의 내용 전체를 조회하는 명령
select * from MemberList;	-- 테이블의 내용 전체를 조회하는 명령

-- 테이블 생성 3
-- 테이블 이름 : rentlist
-- 필드 : rent_date(date), idx(number(3)), booknum(number(5)),
--			membernum(number(5)), discount(number(4))
-- 제약조건 : booknum, membernum : not null
-- 기본값 : rent_date - 오늘 날짜
-- 외래키 : booknum - booklist 의 booknum을 참조합니다
--			  membernum - memberlist 의 membernum을 참조합니다
--	기본키 : rent_date, idx 조합에 의한 기본키 설정

drop table rentlist purge;
create table rentlist(
	rent_date date default sysdate,
	idx number(5) not null,				-- 해당일자의 대여순번
	booknum varchar2(5) not null,
	memberNum varchar2(5) not null,
	discount number(4),
	
	constraint rent_pk primary key(rent_date, idx),
	constraint fk1 foreign key(booknum) references booklist(booknum),
	constraint fk2 foreign key(memberNum) references MemberList(memberNum)
);

select * from rentlist;

-- rent_date 와 idx 를 조합하여 기본키(rent_pk)를 생성합니다. 두 개의 필드가 조합되어 기본키로 지정될 수 있습니다.
-- 이를 슈퍼키라고 합니다.
-- rentlist 테이블의 booknum 은 booklist 테이블의 booknum 을 참조하는 외래키로 지정
-- (제약조건이름 fk1)
-- rentlist 테이블의 membernum 은 memberlist 테이블의 membernum 을 참조하는 외래키로 지정
-- (제약조건이름 fk2)