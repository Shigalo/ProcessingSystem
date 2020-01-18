CREATE SCHEMA `processing` ;

use processing;

CREATE TABLE worker(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login varchar(45) NOT NULL,
    password varchar(45) NOT NULL);

CREATE TABLE user_role(
    user_id int,
    role varchar(45),
    CONSTRAINT user_role_worker FOREIGN KEY (user_id) REFERENCES worker (id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE product(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    factory varchar(45) NOT NULL,
    count int);

CREATE TABLE order(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data varchar(45),
    manager_id int,
    product_id int,
    CONSTRAINT order_manager FOREIGN KEY (manager_id) REFERENCES worker (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT order_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE waybill(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    sum double,
    worker_id int,
    CONSTRAINT waybill_worker FOREIGN KEY (worker_id) REFERENCES worker (id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE delivery(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    date date,
    factory varchar(45),
    waybill_id int,
    CONSTRAINT delivery_waybill FOREIGN KEY (waybill_id) REFERENCES waybill (id) ON DELETE CASCADE ON UPDATE CASCADE);

