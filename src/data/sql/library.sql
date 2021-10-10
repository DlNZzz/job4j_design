create table library(
	id serial primary key,
	name char(100),
	author varchar(255),
	availability bool
);
insert into library(name, author, availability) values('Java Полное руководство', 'Герберт Шилдт', true);
update library set availability = false;
delete from library;
select * from library;