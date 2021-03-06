insert into rules(rules) values ('rules1');
insert into rules(rules) values ('rules2');

insert into role(role) values ('role1');
insert into role(role) values ('role2');

insert into role_rules(role_id, rules_id) values (2, 1);
insert into role_rules(role_id, rules_id) values (2, 2);
insert into role_rules(role_id, rules_id) values (1, 2);

insert into users(name, role_id) values ('name1', 2);
insert into users(name, role_id) values ('name2', 1);
insert into users(name, role_id) values ('name3', 2);

insert into category(category) values ('category1');
insert into category(category) values ('category2');
insert into category(category) values ('category3');
insert into category(category) values ('category4');

insert into state(state) values ('state1');
insert into state(state) values ('state2');
insert into state(state) values ('state3');
insert into state(state) values ('state4');

insert into item(item, users_id, category_id, state_id) values ('item1', 2, 1, 1);
insert into item(item, users_id, category_id, state_id) values ('item2', 3, 1, 2);
insert into item(item, users_id, category_id, state_id) values ('item3', 1, 2, 3);
insert into item(item, users_id, category_id, state_id) values ('item4', 2, 3, 4);
insert into item(item, users_id, category_id, state_id) values ('item5', 3, 4, 1);

insert into comments(comments, item_id) values ('comments1', 1);
insert into comments(comments, item_id) values ('comments2', 2);
insert into comments(comments, item_id) values ('comments3', 3);
insert into comments(comments, item_id) values ('comments4', 5);

insert into attachs(attachs, item_id) values ('attachs1', 1);
insert into attachs(attachs, item_id) values ('attachs2', 2);
insert into attachs(attachs, item_id) values ('attachs3', 3);
insert into attachs(attachs, item_id) values ('attachs4', 5);