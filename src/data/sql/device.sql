create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('q', '1.1'), ('w', '5'), ('e', '2.5');
insert into devices(name, price) values ('a', '1234.1'), ('s', '3245'), ('d', '13242.5');
insert into people(name) values ('Аня'), ('Ваня'), ('Боря');
insert into people(name) values ('Коля'), ('Катя');
insert into devices_people(device_id, people_id) values (1, 1), (1, 2), (2, 1), (3, 1), (2, 3);
insert into devices_people(device_id, people_id) values (6, 4), (5, 5), (6, 5);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people as dp join people p
on dp.people_id = p.id
join devices as d on d.id = dp.device_id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp join people p
on dp.people_id = p.id
join devices as d on d.id = dp.device_id
group by p.name
having avg(d.price) > 5000;