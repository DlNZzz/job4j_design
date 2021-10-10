create table barcode(
    id serial primary key,
    barcode int
);

create table library(
    id serial primary key,
	name varchar(255),
	barcode_id int references barcode(id) unique
);

insert into barcode(barcode) values (13);
insert into barcode(barcode) values (534);
insert into barcode(barcode) values (53);

insert into library(name, barcode_id) values ('q', 1);
insert into library(name, barcode_id) values ('w', 3);

select * from library;
select * from barcode;