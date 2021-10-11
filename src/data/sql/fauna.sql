create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('q', 50, null);
insert into fauna(name, avg_age, discovery_date) values ('fish', 7000, date '500-02-01');
insert into fauna(name, avg_age, discovery_date) values ('w', 21000, date '1960-03-01');
insert into fauna(name, avg_age, discovery_date) values ('r', 15000, date '1962-03-01');
insert into fauna(name, avg_age, discovery_date) values ('jfishj', 32332, null);
insert into fauna(name, avg_age, discovery_date) values ('q', 45, date '1940-03-01');

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950.01.01';