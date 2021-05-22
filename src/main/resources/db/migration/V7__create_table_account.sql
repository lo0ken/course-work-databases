create table account(
    id serial primary key,
    key varchar unique not null,
    name varchar not null,
    group_code varchar references account_group(code) not null,
    user_id int references users(id) not null
);

create table account_balance(
    id serial primary key,
    account_id int references account(id),
    currency_code varchar references currency(code),
    balance int not null
);