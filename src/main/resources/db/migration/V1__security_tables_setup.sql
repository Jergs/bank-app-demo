create table db.customer
(
    id    int          not null auto_increment,
    email varchar(50)  not null,
    pwd   varchar(200) not null,
    role  varchar(50)  not null,
    primary key (id)
);