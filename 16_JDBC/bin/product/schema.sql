mysql -uroot -pmysql

use javatest;

drop table if exists product;

create table if not exists product (
pno int(10) auto_increment, // 보통은 bigint로 만들고 java에서는 long으로 받는다.
pname varchar(100) not null,
price int(10) not null,
regdate datetime default now(),
madeby varchar(50) not null,
primary key(pno)
);

insert into product (pname, price, madeby)
values ("TestProduct1", 1234, "TestCompany1");
insert into product (pname, price, madeby)
values ("TestProduct2", 2345, "TestCompany2");
insert into product (pname, price, madeby)
values ("TestProduct3", 3456, "TestCompany3");
insert into product (pname, price, madeby)
values ("TestProduct4", 4567, "TestCompany4");
insert into product (pname, price, madeby)
values ("TestProduct5", 5678, "TestCompany5");

select * from product; // 리스트조회 (모든 정보가 다 나온다.)

select pno, pname, price from product;

select * from product where pno = 2;

update product set pname = "TestProduct7", price = 9876, regdate = now(), madeby = "TestCompany7" where pno = 1;

delete from product where pno = 2;