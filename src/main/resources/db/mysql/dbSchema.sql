# create schema
CREATE SCHEMA Rentit;

# select schema
USE Rentit;

# drop tables
DROP TABLE categories;
DROP TABLE products;
DROP TABLE rented_products;
DROP TABLE rentees;
DROP TABLE renters;
DROP TABLE images;

# create tables
CREATE TABLE renters (
	id int auto_increment not null primary key, 
    first_name varchar(30) not null, 
    last_name varchar(30) not null,
    email varchar(50) unique not null,
    mobile varchar(20) unique not null
    );

CREATE TABLE rentees (
	id int auto_increment not null primary key, 
    first_name varchar(30) not null, 
    last_name varchar(30) not null,
    email varchar(50) unique,
    mobile varchar(20) unique not null
);

CREATE TABLE categories (
	id int auto_increment not null primary key,
    name varchar(255) not null
);

CREATE TABLE products (
	id int auto_increment not null primary key,
    category_id int not null,
    name varchar(255) not null,
    price_per_day int not null,
    description text not null,
    foreign key (category_id) references categories(id)
);

CREATE TABLE rented_products (
	id int auto_increment not null primary key,
    category_id int not null,
    product_id int not null,
    renter_id int not null,
    rentee_id int not null,
    address varchar(255) not null,
    start_date date not null,
    end_date date not null,
    foreign key (product_id) references products(id),
    foreign key (category_id) references categories(id),
    foreign key (renter_id) references renters(id),
    foreign key (rentee_id) references rentees(id)
);

CREATE TABLE images (
	id int not null,
    url varchar(255) not null,
    product_id int not null,
    foreign key (product_id) references products(id)
);