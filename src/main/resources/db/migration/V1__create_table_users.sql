create table users(
    id serial not null primary key,
    username varchar not null unique,
    password varchar not null,
    phone varchar not null,
    email varchar not null
);