create table city(
    id serial primary key,
    name varchar(255)
);

create table country(
    id serial primary key,
    name varchar(255),
    city_id int references city(id) unique
);

insert into city(name) values ('Moscow');
insert into city(name) values ('Kiev');
insert into city(name) values ('Minsk');
insert into city(name) values ('Z');

insert into country(name, city_id) values ('Russia', 1);
insert into country(name, city_id) values ('Ukraine', 2);
insert into country(name) values ('Q');
insert into country(name) values ('W');
insert into country(name, city_id) values ('Belarus', 3);

select * from country join city c on country.city_id = c.id;
select c.name Country, ci.name City, c.city_id from country c join city ci on c.city_id = ci.id;
select c.name, co.name from country as co join city as c on co.city_id = c.id;
select ci.name as Город, c.name as Страна from country as c join city as ci on c.city_id = ci.id;