create table currency(
    code varchar primary key unique,
    name varchar not null,
    symbol varchar not null,
    exp integer not null,
    flag varchar
)