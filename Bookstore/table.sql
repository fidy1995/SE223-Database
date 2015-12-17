create database bookstore;

create table bookstore.users (
	username varchar(16) not null,
	password varchar(16) not null,
	email varchar(32),
	
	primary key (username)
);

create table bookstore.books (
	isbn char(13) not null,
	title varchar(256),
	category varchar(256),
	price numeric(10, 2) not null,

	primary key (isbn)
);

create table bookstore.orderForm (
	username varchar(16),
	isbn char(13),
	quantity int,
	paiddate date,
	
	foreign key (username) references bookstore.users(username),
	foreign key (isbn) references bookstore.books(isbn)
);

insert into bookstore.users (username, password, email)
values ("admin", "admin", "admin@admin");