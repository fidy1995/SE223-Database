drop database My_Bookstore;
create database My_Bookstore;

create table My_Bookstore.users (
	uname varchar(16) not null,
    upass varchar(16) not null,
   
    primary key (uname)
);

create table My_Bookstore.books (
	isbn char(13) not null,
	title varchar(256),
    category varchar(256),
    price numeric(10, 2) not null,
    
    primary key (isbn)
);

create table My_Bookstore.orders (
	uname varchar(16) not null,
    isbn char(13) not null,
    amount int not null,
    paytime datetime,
    
    foreign key (uname) references My_Bookstore.users(uname),
    foreign key (isbn) references My_Bookstore.books(isbn),
    primary key (uname, isbn, paytime)
);

insert into My_Bookstore.users values ("admin", "admin");