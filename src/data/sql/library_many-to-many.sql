create table library(
	id serial primary key,
	name char(255),
	author varchar(255),
	availability bool
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table people_library(
	id serial primary key,
	people_id int references people(id),
	library_id int references library(id)
);

insert into people(name) values ('Ivan');
insert into people(name) values ('Anton');

insert into library(name, author, availability) values('Java Полное руководство', 'Герберт Шилдт', true);
insert into library(name, author, availability) values('Изучаем Java', 'Кэти и Берт', true);

insert into people_library(people_id, library_id) values (1, 1);
insert into people_library(people_id, library_id) values (1, 2);
insert into people_library(people_id, library_id) values (2, 2);