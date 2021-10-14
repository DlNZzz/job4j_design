create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table gearbox(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	body_id int references body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);

insert into body(name) values ('body1'), ('body2'), ('body3'), ('body4'), ('body5');
insert into engine(name) values ('engine1'), ('engine2'), ('engine3'), ('engine4'), ('engine5'), ('engine6');
insert into gearbox(name) values ('gearbox1'), ('gearbox2'), ('gearbox3'), ('gearbox4'), ('gearbox5');

insert into car(body_id, engine_id, gearbox_id) values (1, 2, 3), (5, 5, 5), (3, 2, 3);

select * from car join body on car.body_id = body.id join engine on car.engine_id = engine.id join gearbox on car.gearbox_id = gearbox.id;

select b.name, b.id from car full join body as b on car.body_id = b.id where car.body_id is null;
select e.name, e.id from car right join engine as e on car.engine_id = e.id where car.engine_id is null;
select g.name, g.id from car right join gearbox as g on car.gearbox_id = g.id where car.gearbox_id is null;









