create table role (
	id serial primary key,
	role varchar(255)
);

create table users (
    id serial primary key,
    name text,
	role_id int references role(id)
);

create table rules (
	id serial primary key,
    rules text
);

create table role_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table comments (
	id serial primary key,
    comments text
);

create table attachs (
	id serial primary key,
    attachs text
);

create table category (
	id serial primary key,
    category text
);

create table state (
	id serial primary key,
    state text
);

create table item (
	id serial primary key,
	users_id int references users(id),
	comments_id int references comments(id),
	attachs_id int references attachs(id),
	category_id int references category(id),
	state_id int references state(id),
	item text
);














