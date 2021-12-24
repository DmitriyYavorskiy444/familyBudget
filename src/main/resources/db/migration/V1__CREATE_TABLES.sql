-- create table hibernate_sequence
-- (
--     next_val bigint
-- ) engine=MyISAM; --must be correct on Postgres

-- insert into hibernate_sequence
-- values (1);
-- insert into hibernate_sequence
-- values (1);
-- insert into hibernate_sequence
-- values (1);

create table familyApi
(
    id serial primary key,
    familyName varchar(64) not null unique,
    balance  decimal CHECK(balance >= 0)
);

create table userApi
(
    id serial primary key,
    password varchar(64),
    username varchar(64) not null unique,
    role     varchar(64),
    balance  decimal CHECK(balance >= 0)
);

create table todo
(
    id serial primary key,
    title       varchar(64),
    completed   BOOLEAN,
    transaction decimal
);
