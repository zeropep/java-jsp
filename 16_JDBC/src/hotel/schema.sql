// hotel을 database를 사용하여 다시 만들기
// 제출은 아니지만 나중에 정리하여 레포트제출이 있음
// room table을 만들어야 한다.

mysql -uroot -pmysql

use javatest;

drop table if exists room;

create table if not exists room (
rno varchar(10) not null, 
uname varchar(100),
uage int(10),
ugen int(1),
isavail boolean not null default true,
checkintime datetime,
checkouttime datetime,
primary key(rno)
);

insert into room (rno) values (?);

select * from room; // 리스트조회 (모든 정보가 다 나온다.)

select rno, isavail from room;

select * from room where rno = ?;

update room set uname = ?, uage = ?, ugen = ?, isavail = false, checkintime = now() where rno = ?;

update room set uname = null, uage = null, ugen = null, isavail = true, checkintime = null, checkouttime = now() where rno = ?;

delete from room where rno = 2;