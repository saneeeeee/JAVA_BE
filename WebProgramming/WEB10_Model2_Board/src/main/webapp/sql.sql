select * from board;
select * from member;

drop table board purge;
create table board(
	num number(5) primary key,
	pass varchar2(30),						--	게시물 삭제 시 필요한 비밀번호
	userid varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,		--	조회수
	writedate date default sysdate		--	작성일자
);

drop sequence board_seq;
create sequence board_seq start with 1 increment by 1;

insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'hong','abc@abc.com','1234','첫 방문입니다.',
	'반갑습니다. 앞으로 많은 격려와 지도편달 부탁드립니다.');
insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'somi','abc2@abc.com','1234','게시판 개설.',
	'축하드립니다. 무궁한 발전을 기원할께요.');
insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'light','abc3@abc.com','1234','돼지골마을.',
	'돼지 삼겹살이 맛있습니다.');
insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'hana','abc4@abc.com','1234','2021년 겨울.',
	'추워요.');
insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'hana','abc4@abc.com','1234','코로나',
	'백신3차 ㄷㄱㅈ.');
insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'somi','abc2@abc.com','1234','쓸 내용이',
	'더이상 없는데요???');
insert into board(num, userid, email, pass, title, content) 
values(board_seq.nextVal,'somi','abc2@abc.com','1234','도배용 1',
	'내용은 도배');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal,'somi','abc2@abc.com','1234','도배용 2',
	'내용은 도배');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal,'somi','abc2@abc.com','1234','도배용 3',
	'내용은 도배');
	
	
drop table reply purge;
create table reply(
	replynum number(7) primary key,
	boardnum number(5),
	userid varchar2(20),
	writedate date default sysdate,
	content varchar2(1000)
);

drop sequence reply_seq;
create sequence reply_seq start with 1 increment by 1;