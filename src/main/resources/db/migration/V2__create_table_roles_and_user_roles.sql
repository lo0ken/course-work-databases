create table roles(
    id serial not null primary key,
    name varchar not null unique
);

insert into roles(id, name)
values (default, 'USER'),
       (default, 'ANONYMOUS'),
       (default, 'PREMIUM');

create table user_roles(
    id serial not null primary key,
    user_id integer not null references users(id),
    role_id integer not null references roles(id)
);