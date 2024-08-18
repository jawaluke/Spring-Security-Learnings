create table user_login (
    id int not null,
    client_name varchar(128) not null,
    client_secret varchar(128) not null,
    constraint user_pk primary key (id)
);

--INSERT INTO user_login (id, client_name, client_secret)
--VALUES (1, 'anton', 'fliesecret');
