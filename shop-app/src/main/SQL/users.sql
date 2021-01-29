USE shop;
drop table if exists Users;
create table Users (
    id int primary key auto_increment,
    login varchar(20),
    password VARCHAR(50)
);