create table tag_type(
    id int primary key,
    name varchar not null
);

insert into tag_type values
(0, 'Expense'), (2, 'Income');

create table tag(
    id serial primary key,
    name varchar not null,
    type_id int references tag_type(id),
    user_id int references users(id)
)