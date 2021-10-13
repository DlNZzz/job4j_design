create table type(
	id serial primary key, 
	name varchar(255)
);

create table product(
	id serial primary key, 
	name varchar(255), 
	type_id int references type(id), 
	expired_date date, 
	price int
);

select * from type;
select * from product;

insert into type(name) values ('МОЛОКО'), ('q'), ('w'), ('e'), ('СЫР');
insert into product(name, type_id, expired_date, price) values ('a', 13, date '2020.10.10', 120);
insert into product(name, type_id, expired_date, price) values ('a', 16, date '2021.10.10', 420);
insert into product(name, type_id, expired_date, price) values ('шоколадное мороженое с орехом', 16, date '2022.10.10', 420);
insert into product(name, type_id, expired_date, price) values ('молоко1', 21, date '2021.10.10', 40);
insert into product(name, type_id, expired_date, price) values ('молоко2', 21, date '2021.10.10', 50);
insert into product(name, type_id, expired_date, price) values ('молоко3', 21, date '2021.10.10', 40);
insert into product(name, type_id, expired_date, price) values ('молоко2', 21, date '2021.10.10', 50);
insert into product(name, type_id, expired_date, price) values ('молоко1', 21, date '2021.10.10', 40);
insert into product(name, type_id, expired_date, price) values ('молоко2', 21, date '2021.10.10', 50);
insert into product(name, type_id, expired_date, price) values ('молоко3', 21, date '2021.10.10', 40);
insert into product(name, type_id, expired_date, price) values ('молоко2', 21, date '2021.10.10', 50);
insert into product(name, type_id, expired_date, price) values ('молоко1', 21, date '2021.10.10', 40);
insert into product(name, type_id, expired_date, price) values ('молоко2', 21, date '2021.10.10', 50);
insert into product(name, type_id, expired_date, price) values ('молоко3', 21, date '2021.10.10', 40);
insert into product(name, type_id, expired_date, price) values ('молоко2', 21, date '2021.10.10', 50);

select * from product as p inner join type 
on p.type_id = type.id and type.name = 'СЫР';

select * from product where name LIKE '%мороженое%';

select * from product where expired_date < date '2021.10.13';

select * from product as p where p.price = (select max(price) from product);

select type.name, count(type_id) from product as p join type on p.type_id = type.id
group by type.name;

select * from product as p join type on p.type_id = type.id and (type.name = 'СЫР' or type.name = 'МОЛОКО'); 

select type.name from product as p RIGHT JOIN type 
on p.type_id = type.id 
group by type.name 
having count(type.name) < 10;

select * from product as p join type on p.type_id = type.id;