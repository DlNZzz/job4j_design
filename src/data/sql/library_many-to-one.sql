create table library_staff(
	id serial primary key,
	name varchar(255)
);

create table people(
    id serial primary key,
    position varchar(255),
    library_staff_id int references library_staff(id)
);

insert into library_staff(name) values ('Секретарь');
insert into library_staff(name) values ('Директор');
insert into people(position, library_staff_id) VALUES ('Ivan', 2);
insert into people(position, library_staff_id) VALUES ('Anna', 1);

select * from library_staff;

select * from people where id in (select id from library_staff);