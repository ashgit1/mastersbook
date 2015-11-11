-- Database Name: mb

use mb;

/* 1. users table */

CREATE TABLE users(
email varchar(50) primary key,
fname varchar(50) not null,
lname varchar(50) not null,
phone varchar(15) not null
)


/* 2. orders table */

CREATE TABLE orders(
orderid 	 INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
orderdate 	 varchar(50) not null,
shipaddress	 varchar(200) not null,
totalprice   INT(6) not null,
status		 varchar(20) not null
)

/* 3. books table */

CREATE TABLE books(
bookid 	 	 INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
title 	 	 varchar(100) not null,
authorfname  varchar(50) not null,
authorlname  varchar(50) not null,
category 	 varchar(50) not null,
description  text not null,
publisher    varchar(100) not null,
price 		 INT(6) not null
)

/* 4. users_orders table */

CREATE TABLE users_orders(
email 		varchar(50) not null ,
orderid 	INT(8) not null,
FOREIGN KEY(email) REFERENCES users(email),
FOREIGN KEY(orderid) REFERENCES orders(orderid) 
)

/* 5. orders_books table */

CREATE TABLE orders_books(
orderid 				INT(8)  NOT NULL ,
bookid                  INT(8) not null,
FOREIGN KEY(orderid) 	REFERENCES orders(orderid),
FOREIGN KEY(bookid)  	REFERENCES books(bookid)
)