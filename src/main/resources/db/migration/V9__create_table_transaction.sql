create table transaction_type(
    id int primary key,
    name varchar not null
);

insert into transaction_type values
(0, 'Expense'), (2, 'Income');

create table transaction(
    id serial primary key,
    amount int not null,
    note varchar,
    date date not null,

    type_id int references transaction_type(id) not null,
    currency_code varchar references currency(code) not null,
    account_id int references account(id) not null,
    linked_account_id int references account(id),
    linked_amount int,
    linked_currency_code varchar references currency(code),
    key varchar not null unique
);

create table transaction_tag(
    id serial primary key,
    transaction_id int references transaction(id),
    tag_id int references tag(id)
)