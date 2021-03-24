CREATE TABLE IF NOT EXISTS role(
    id serial primary key,
    role_name varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_account_x_role(
    role_id int references role (id) NOT NULL,
    user_account_id int references user_account (id) NOT NULL,

    PRIMARY KEY (role_id, user_account_id)
);