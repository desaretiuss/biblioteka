drop database if exists `library_database`;
create database if not exists `library_database`;
use `library_database`;

create table `member`(

`member_id` int auto_increment,
`member_firstname` varchar(20) not null,
`member_lastname` varchar(20) not null,
`member_email` varchar(250) not null,
`member_mobile` int(10) not null,
`member_birthdate` date not null,
`member_address` varchar(250) not null,
`member_category` varchar(50) not null,
`member_password` blob not null,
`member_password_salt` blob not null,
`member_activation_code` varchar(1024) not null,
`member_activation_salt` blob not null,
`member_account_enabled` boolean default null,

primary key(`member_id`, `member_email`)

);
             
             