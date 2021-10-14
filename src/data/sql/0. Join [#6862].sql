create table emploers(
	id serial primary key,
	name varchar(255)
);

create table departments(
	id serial primary key,
	name varchar(255),
	emploers_id int references emploers(id)
);

insert into emploers(name) values ('user1'), ('user2'), ('user3'), ('user4'), ('user5'), ('user6');
select * from emploers;

insert into departments(name, emploers_id) values ('a', null), ('b', 1), ('a', 2), ('b', 5);
insert into departments(name, emploers_id) values ('c', null), ('a', 4), ('b', 4), ('b', 3);
select * from departments;


SELECT * FROM departments AS d LEFT OUTER JOIN emploers AS e ON d.emploers_id = e.id;
SELECT * FROM departments AS d RIGHT OUTER JOIN emploers AS e ON d.emploers_id = e.id;
SELECT * FROM departments AS d FULL JOIN emploers AS e ON d.emploers_id = e.id;
SELECT * FROM departments AS d CROSS JOIN emploers AS e;

SELECT * FROM departments AS d LEFT OUTER JOIN emploers AS e ON d.emploers_id = e.id where d.emploers_id is null;

SELECT d.id, d.name, d.emploers_id, e.id, e.name FROM departments AS d LEFT OUTER JOIN emploers AS e ON d.emploers_id = e.id;
SELECT d.id, d.name, d.emploers_id, e.id, e.name FROM emploers AS e RIGHT OUTER JOIN departments AS d ON d.emploers_id = e.id;

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('user1', 'm'), ('user2', 'w'), ('user3', 'w'), ('user4', 'w'), ('user5', 'w'), ('user6', 'm');

select m.name, w.name from teens m cross join teens w where m.gender != w.gender and m.gender = 'm';




