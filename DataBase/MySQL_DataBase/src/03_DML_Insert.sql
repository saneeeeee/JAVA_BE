insert into scott.booklist (subject,makeyear,inprice,rentprice,grade)values( '좀비아이',2020,12000,2500,'all');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('일곱해의 마지막',2020,12150,2000,'all');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('불편한 편의점',2021,12600,2000,'18');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('미드나잇 라이브러리',2021,14220,2000,'18');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values( '달러구트 꿈 백화점',2020,12420,2500,'13');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('달러구트 꿈 백화점2',2021,12420,2500,'13');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('크리스마스 피그',2021,18000,3000,'all');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('밝은 밤',2021,13050,2000,'all');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('완전한 행복',2021,14220,2500,'all');
insert into scott.booklist (subject,makeyear,inprice,rentprice,grade) values('아몬드',2017,10800,2000,'13');

insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('홍길동','010-1234-4321','94/10/17',240,'20/10/01','M',28);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('홍길서','010-2234-4322','89/03/12',220,'20/07/01','F',33);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('홍길남','010-3234-4323','97/12/06',220,'20/08/01','M',25);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('추신수','010-4232-1231','84/07/07',240,'20/10/01','M',38);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('강수진','010-5454-8775','79/12/22',220,'20/07/01','F',43);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('김민수','010-3433-1245','07/11/06',120,'20/08/01','M',15);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('최진수','010-5432-1723','99/01/01',20,'20/11/01','M',23);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('박수민','010-1762-3267','93/03/15',140,'21/01/01','M',29);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('김지영','010-3254-5223','81/05/27',180,'21/05/01','F',41);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('이민영','010-1221-4351','00/11/17',220,'21/08/01','F',22);
insert into scott.memberlist(name,phone,birth,bpoint,joindate,gender,age) values('조효진','010-3321-5664','87/12/12',240,'20/10/01','M',35);


insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/01',3,1,100);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/02',4,3,300);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/03',5,4,200);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/02',6,5,200);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/02',3,7,100);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/05',2,8,300);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/05',1,3,200);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/06',5,1,100);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/01',7,2,100);
insert into scott.rentlist(rentdate,booknum,membernum,discount) values('2021/12/07',8,4,300);
insert into scott.rentlist(booknum,membernum,discount) values(2,11,200);
insert into scott.rentlist(booknum,membernum,discount) values(3,3,200);

select * from scott.booklist;
select * from scott.memberlist;
select * from scott.rentlist;
update scott.rentlist set num = num-10;