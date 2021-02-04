create database aboradInfo;

create table user(
    id varchar(40) primary key ,
    username varchar(30) not null ,
    password varchar(30) not null ,
    mail varchar(80) not null ,
    phoneNumber int(64) not null,
    type varchar(20) not null
);

create table userInfo(
    id varchar(40) primary key ,
    username varchar(30) not null ,
    realName varchar(30),
    password varchar(30) not null ,
    mail varchar(80) not null,
    phoneNumber int(64) not null,
    age int(6),
    bir datetime,
    sex varchar(4),
    university varchar(40),
    constraint foreign key (id) references user(id) on update cascade
);
