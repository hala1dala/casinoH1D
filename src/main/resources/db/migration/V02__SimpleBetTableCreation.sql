CREATE TABLE IF NOT EXISTS simple_bet(
    id serial primary key,
    bet varchar(10) NOT NULL,
    user_account_id int references user_account(id) NOT NULL
);