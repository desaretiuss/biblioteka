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


create table `dewey`(

 `dewey_code` varchar(7) not null,
 `name` varchar(250) unique,
 
  primary key(`dewey_code`)
);

insert into `library_database`.`dewey`(`dewey_code`, `name`)
values
    ("000", "Shkenca Kompjuterike, Informacione, Vepra te pergjithshme"),
    ("010", "Bibliografi"),
    ("020", "Librari"),
    ("030", "Enciklopedi"),
    ("040",  null),
    ("050", "Gazeta, Revista, Periodike"),
    ("060", "Shoqata, Organizata, muzeume"),
    ("070", "Lajme, gazetari, publicstike"),
    ("080", "Thenie dhe Citime"),
    ("090", "Doreshkrime dhe Libra te rralle"),
    ("100", "Filozofi"),
    ("110", "Metafizike"),
    ("120", "Epistemologji"),
	("130", "Parapsikologji dhe Shkenca Okulte"),
    ("140", "Shkolla te mendimit filozofik"),
    ("150", "Psikologji"),
    ("160", "Logjike Filozofike"),
    ("170", "Etike"),
    ("180", "Filozofi Antike, e Mesjetes dhe Filozofi Lindore"),
    ("190", "Filozofi moderne perendimore"),
    ("200", "Besime"),
    ("210", "Filozofi e Besimit"),
    ("230", "Krishterimi"),
    ("300", "Shkenca shoqerore"),
    ("310", "Statistike"),
    ("320", "Shkenca Politike"),
    ("330", "Ekonomiks"),
    ("340", "Drejtesi"),
    ("350", "Administrim Publik dhe Shkenca Ushtarake"),
    ("370", "Edukim dhe Arsim"),
    ("380", "Tregti, Marketing"),
    ("390", "Tradita, Folkor"),
    ("400", "Gjuhesi"),
    ("410", "Linguistike"),
    ("420", "Anglisht"),
    ("430", "Gjermanisht"),
    ("440", "Frengjisht"),
    ("450", "Italisht"),
    ("460", "Spanjisht"),
    ("470", "Latinisht"),
    ("480", "Gjuhe Klasike dhe Greke"),
    ("490", "Gjuhe te tjera"),
    ("500", "Shkenca"),
    ("510", "Mathematike"),
    ("520", "Astronomi"),
    ("530", "Fizike"),
    ("540", "Kimi"),
    ("550", "Gjeologji"),
    ("570", "Biologji"),
    ("590", "Zoologji"),
    ("600", "Teknologji"),
    ("610", "Mjekesi dhe Shendetesi"),
    ("620", "Inxhineri"),
    ("630", "Agrikulture"),
    ("690", "Ndertimtari"),
    ("700", "Arte"),
    ("720", "Arkitekture"),
    ("740", "Arte grafike, dizajn"),
    ("750", "Pikture"),
    ("770", "Fotografi"),
    ("780", "Muzike"),
    ("790", "Sporte"),
    ("800", "Literature"),
    ("810", "Literature Shqipe"),
    ("810.1", "Literature e Mesjetes"),
    ("810.2", "Literature e Rilindjes"),
    ("810.23", "Poete shqiptare ne Trojet Shqiptare"),
    ("810.24", "Poete arbereshe ne Itali"),
	("810.25", "Poete shqiptare ne Kolonite Shqiptare ne Emigracion"),
    ("810.3", "Literature e Realizmit Socialist"),
    ("810.4", "Literature Bashkekohore"),
    ("820", "Literature Angleze"),
    ("830", "Literature Gjermane"),
    ("840", "Literature Franceze"),
    ("850", "Literature Italiane"),
    ("860", "Literature Spanjolle"),
    ("870", "Literature Latine"),
    ("890", "Literature te tjera"),
    ("900", "Histori"),
    ("910", "Gjeografi"),
    ("920", "Biografi"),
    ("930", "Histori Antike"),
    ("940", "Histori e Europes"),
    ("950", "Histori e Azise"),
    ("960", "Histori e Afrikes"),
    ("970", "Histori e Amerikes Veriore"),
    ("980", "Histori Amerikes Jugore");
    

create table `book`(

    `book_id` int auto_increment,
	`book_title` varchar(250) not null,
    `book_author` varchar(250) not null,
    `book_isbn` varchar(250) not null,
    `book_deweyCode` varchar(250) not null,
    `book_language` varchar(50) not null,
	`book_year` int,
	`book_publisher` varchar(250) not null,
	`book_edition` int,
	`book_pages` int,
	`book_copies` int not null,
    

primary key(`book_id`, `book_isbn`)

);
