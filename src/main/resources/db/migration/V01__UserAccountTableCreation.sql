CREATE TABLE IF NOT EXISTS user_account (
    id serial PRIMARY KEY ,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    tax_Number int NOT NULL ,
    birthday date NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    balance int default 0 NOT NULL
);