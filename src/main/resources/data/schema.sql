-- 테이블 드랍이 가능하도록 먼저 해주기
set foreign_key_checks = 0;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
    product_id int not null auto_increment,
    name varchar(100) not null,
    description varchar(200) null,
    price decimal(10,2) not null,
    primary key (product_id)
);

drop table if exists orders;

create table orders (
    order_id int not null auto_increment,
    customer_id int not null,
    order_at datetime not null,
    primary key (order_id)
);

drop table if exists order_items;

create table order_items (
    order_items_id int not null auto_increment,
    product_id int not null ,
    order_id int not null,
    order_quantity int not null ,
    primary key (order_items_id),
    foreign key (order_id) references orders (order_id)
);

drop table if exists customers;

create table customers (
    customer_id int not null auto_increment,
    name varchar(100) not null,
    phone_number varchar(100) null,
    address varchar(100) not null,
    primary key (customer_id)
);

drop table if exists stores;

create table stores (
    store_id int not null auto_increment,
    name varchar(100) not null,
    address varchar(100) not null,
    phone_nulber varchar(100) not null,
    open_at varchar(100) not null,
    close_at varchar(100) not null,
    primary key (store_id)
);


drop table if exists store_products;

create table store_products (
    store_product_id int not null auto_increment,
    store_id int not null,
    product_id int not null,
    stock_quantity int not null,
    primary key (store_product_id)
);
