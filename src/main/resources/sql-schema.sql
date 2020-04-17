create database if not exists ims;
create table if not exists ims.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40),address varchar(40), email varchar(40), phone_number varchar(12));
create table if not exists ims.items(item_id int primary key auto_increment, item_name varchar(40), item_cost varchar (40));
create table if not exists ims.orders(order_id int primary key auto_increment, customer_id int NOT NULL, order_date DATE, order_cost float NOT NULL, item_id int not NULL, FOREIGN KEY(customer_id) REFERENCES customers(customer_id), FOREIGN KEY(item_id) REFERENCES items(item_id));
create table if not exists ims.orderline(orderline_id int primary key auto_increment, customer_id INT NOT NULL, item_id INT NOT NULL, order_id INT NOT NULL ,FOREIGN KEY (customer_id) REFERENCES customers(customer_id), FOREIGN KEY (item_id) REFERENCES items(item_id), FOREIGN KEY (order_id) REFERENCES orders(order_id));
