
/* Drop Tables */

DROP TABLE f_comment CASCADE CONSTRAINTS;
DROP TABLE f_article CASCADE CONSTRAINTS;
DROP TABLE f_board CASCADE CONSTRAINTS;
DROP TABLE f_user CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_article;
DROP SEQUENCE seq_board;
DROP SEQUENCE seq_com;
DROP SEQUENCE seq_user;




/* Create Sequences */

CREATE SEQUENCE seq_article nocache;
CREATE SEQUENCE seq_board nocache;
CREATE SEQUENCE seq_com nocache;
CREATE SEQUENCE seq_user nocache;



/* Create Tables */

CREATE TABLE f_article
(
	art_no number NOT NULL,
	art_title varchar2(100) NOT NULL,
	art_content clob NOT NULL,
	art_regdate date DEFAULT sysdate NOT NULL,
	art_readcount number(4) DEFAULT 0 NOT NULL,
	art_good number DEFAULT 0 NOT NULL,
	art_bad number DEFAULT 0 NOT NULL,
	art_comcount number DEFAULT 0 NOT NULL,
	boa_no number NOT NULL,
	user_no number NOT NULL,
	PRIMARY KEY (art_no)
);

select a.art_no, a.art_title, a.art_content, a.art_regdate, a.art_readcount, a.art_good, a.art_bad, u.user_name
from f_article a inner join f_user u
on a.user_no = u.user_no
where art_no = 1


insert into f_user()


insert into f_article(art_no, art_title, art_content, boa_no, user_no)
values(seq_article.nextval,'얏옹 짭퉁2','짭퉁2',3,21);

select * from f_article;

select * from f_user;

select * from f_board;

CREATE TABLE f_board
(
	boa_no number NOT NULL,
	boa_name varchar2(20) NOT NULL,
	boa_level number(1) DEFAULT 1 NOT NULL,
	boa_type varchar2(20) NOT NULL,
	boa_url varchar2(10) NOT NULL,
	user_no number NOT NULL,
	PRIMARY KEY (boa_no)
);


CREATE TABLE f_comment
(
	com_no number NOT NULL,
	com_content varchar2(2000),
	com_regdate date DEFAULT sysdate NOT NULL,
	com_good number(3) DEFAULT 0 NOT NULL,
	com_bad number(3) DEFAULT 0 NOT NULL,
	art_no number NOT NULL,
	user_no number NOT NULL,
	PRIMARY KEY (com_no)
);

insert into f_comment(com_no, com_content, art_no, user_no)
values(seq_com.nextval, '스미마셍', 1, 2);

select * from f_comment
select * form f_board


CREATE TABLE f_user
(
	user_no number NOT NULL,
	user_name varchar2(128) NOT NULL,
	user_id varchar2(20) NOT NULL UNIQUE,
	user_nick varchar2(22) NOT NULL UNIQUE,
	user_pw varchar2(128) NOT NULL,
	user_level number(1) DEFAULT 1 NOT NULL,
	user_phone varchar2(15) NOT NULL UNIQUE,
	user_regdate date DEFAULT sysdate NOT NULL,
	user_email varchar2(30) NOT NULL UNIQUE,
	user_address varchar2(200) NOT NULL,
	user_ip varchar2(35),
	user_zipcode varchar2(12) NOT NULL,
	PRIMARY KEY (user_no)
);

select * from f_user;

/* Create Foreign Keys */

ALTER TABLE f_comment
	ADD FOREIGN KEY (art_no)
	REFERENCES f_article (art_no)
;


ALTER TABLE f_article
	ADD FOREIGN KEY (boa_no)
	REFERENCES f_board (boa_no)
;


ALTER TABLE f_article
	ADD FOREIGN KEY (user_no)
	REFERENCES f_user (user_no)
;


ALTER TABLE f_board
	ADD FOREIGN KEY (user_no)
	REFERENCES f_user (user_no)
;


ALTER TABLE f_comment
	ADD FOREIGN KEY (user_no)
	REFERENCES f_user (user_no)
;


select * from f_user;
insert into f_user(user_no, user_name, user_id, user_nick, user_pw, user_level, user_phone, user_email, user_address, user_zipcode)
values(seq_user.nextval, '얏옹','ditdhd','얏옹',1111,0,'010-8888-8888','tlqkf@naver.com', '구로구 구로3동', 01876)


insert into f_board(boa_no, boa_name, boa_level, user_no)
values(seq_board.nextval, '공지사항', 0, 1)

update f_board set boa_no = 1
where boa_name='자유게시판'

insert into f_user(user_no, user_name, user_id, user_nick, user_pw, user_level, user_phone, user_email, user_address, user_zipcode)
values(seq_user.nextval, '팡팡','hello','팡팡',1111,0,'010-8888-8888','hello@gmail.com', '구로구 구로3동', 01876)

insert into f_user(user_no, user_name, user_id, user_nick, user_pw, user_level, user_phone, user_email, user_address, user_zipcode)
values(seq_user.nextval, '위닝반','hihello','위닝반',1111,0,'010-8888-8777','hello22@gmail.com', '구로구 구로3동', 01876)


select * from f_user

update f_user set user_pw = '33275a8aa48ea918bd53a9181aa975f15ab0d0645398f5918a006d08675c1cb27d5c645dbd084eee56e675e25ba4019f2ecea37ca9e2995b49fcb12c096a032e'
where user_id = 'hello'

select * from f_board

update f_user set user_no = 1
where user_id='hello'


delete from f_user
where user_no = 1

update f_user set user_pw = 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db';
select * from f_article

select a.art_no, a.art_title, u.user_name, a.art_regdate, a.art_readcount, a.art_good, a.art_bad
from f_article a inner join f_user u
on a.user_no = u.user_no
where a.boa_no = 1
order by a.art_no desc

insert into f_article(art_no, art_title, user_no, art_content, boa_no)
values (seq_article.nextval, 'test2', 1,'test', 1)



select 	a.art_no, a.art_title, a.art_regdate, to_char(a.art_regdate,'YYYY-MM-DD') as art_regdate, a.art_comcount, u.user_name
	 	  from 		f_article a inner join f_user u
  	 	  on 		a.user_no = u.user_no	
  	 	  where 	a.boa_no = 1 

select * from F_USER
select * from f_board
select * from F_ARTICLE
order by art_no desc

insert into f_board(boa_no, boa_name, boa_type, user_no, boa_url)
values(seq_board.nextval, '자유게시판', 'community', 1, 'free');

insert into f_board(boa_no, boa_name, boa_type, user_no, boa_url)
values(seq_board.nextval, '공지사항', 'community', 1, 'notice');

insert into f_board(boa_no, boa_name, boa_type, user_no, boa_url)
values(seq_board.nextval, '질문게시판', 'community', 1, 'qa');

insert into f_board(boa_no, boa_name, boa_type, user_no, boa_url)
values(seq_board.nextval, '팁게시판', 'community', 1, 'tip');

insert into f_article(art_no, art_title, art_content, boa_no, user_no)
values(seq_article.nextval, 'test','test',1,64);

insert into f_comment(com_no, com_content, art_no, user_no)
values(seq_com.nextval, 'test comment',2,1);

update f_article set art_comcount = art_comcount +1
where art_no = '2';

update f_board set boa_type = '커뮤니티';

update f_board set boa_level = '2'
where boa_url = 'tip';

select * from f_article
where art_title = 'ttestt'

select * from f_user;

select * from f_board

select * from f_comment

select * from f_article
order by art_no desc;

delete from F_ARTICLE
where art_no = '1501';

update f_article set art_readcount = art_readcount + 1
where art_no = '1502';


select B.*
from(select A.*, rownum as rnum
	from (select a.art_title, a.art_regdate, b.boa_name 
				from f_article a join f_board b
				on a.boa_no = b.boa_no and b.boa_name = '자유게시판'
				order by a.art_no desc
				 ) A) B
where rnum between 1 and 5


select * from f_board
insert into f_board(boa_no, boa_name, boa_level, boa_type, boa_url, user_no)
values(seq_board.nextval, '공지사항', '1', '공지사항', 'notice', '1')

alter table f_board
rename column favolite to favorite

update F_BOARD set boa_no = 1
where boa_name = '공지사항'

delete from f_board
where boa_no = 14

delete from f_board
where boa_no = 9

select * from f_user

select a.art_title, a.art_regdate, b.boa_name 
from f_article a join f_board b
on a.boa_no = b.boa_no and b.boa_name = '자유게시판'
order by a.art_no desc

commit
				
				
select * from F_ARTICLE


select B.art_no, B.art_title, B.art_regdate, B.art_comcount
from(select A.*, rownum as rnum
   from (select art_no, art_title, to_char(art_regdate,'MM-DD') as art_regdate, art_comcount
            from f_article
            where boa_no = '1'
            order by art_no desc) A)B
where rnum between 1 and 5


update f_user set user_level = 9
where user_id = 'tlqkf12349'

commit

select a.art_no, a.art_title, to_char(a.art_regdate,'YYYY-MM-DD') as art_regdate, u.user_nick, a.art_readcount, art_good
	 	from f_article a inner join f_user u
	 	on a.user_no = u.user_no
	 	where u.user_nick like '팡팡'
	 	order by a.art_no desc

	 	
select count(*) as cnt
		from f_article
		where boa_no = 1 and art_title like '%' || 'test' || '%'
		
select B.*
		from (select A.*, rownum as rnum
		from (select 	a.art_no, a.art_title, a.art_readcount, to_char(a.art_regdate,'YYYY-MM-DD') as art_regdate, a.art_comcount, u.user_nick, u.user_no, a.art_good
		 	  from 		f_article a inner join f_user u
	  	 	  on 		a.user_no = u.user_no	
	  	 	  where 	art_title like '%' || 1 || '%'
	  	 	  order by 	a.art_no desc) A) B
 	 	where rnum between 1 and 10