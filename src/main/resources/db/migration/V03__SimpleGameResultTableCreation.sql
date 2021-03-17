CREATE TABLE IF NOT EXISTS simple_bet
(
    id serial primary key,
    result varchar(10) NOT NULL,
    date_time timestamp NOT NULL
);