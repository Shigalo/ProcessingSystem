CREATE SCHEMA `processing` ;

use processing;

CREATE TABLE worker(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login varchar(45) NOT NULL UNIQUE,
    password varchar(45) NOT NULL,
    active int NOT NULL,
    name varchar(45) NULL,
    surname varchar(45) NULL);

CREATE TABLE user_role(
    user_id int,
    role varchar(45),
    CONSTRAINT user_role_worker FOREIGN KEY (user_id) REFERENCES worker (id) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO `processing`.`worker` VALUES (1, 'a', 'a', 1, 'a', 'a');
INSERT INTO `processing`.`user_role` (`user_id`, `role`) VALUES (1, 'ADMIN');

CREATE TABLE nomenclature(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    factory varchar(45) NOT NULL,
    collection varchar(45) NOT NULL,
    wholesale double NULL,
    retail double NULL,
    article varchar(45) NOT NULL);
CREATE UNIQUE INDEX nomenclature_article_uindex ON nomenclature (article);

CREATE TABLE customer(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    address varchar(255),
    send_date date DEFAULT null,
    payment int NOT NULL);

CREATE TABLE ordering(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    manager_id int,
    start_date date NOT NULL,
    ready_date date DEFAULT null NULL,
    send_date date DEFAULT null  NULL,
    status int NOT NULL,
    sum double NULL,
    customer_id int NOT NULL,
    position int DEFAULT null NULL,
    CONSTRAINT ordering_customer FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT order_manager FOREIGN KEY (manager_id) REFERENCES worker (id) ON DELETE CASCADE ON UPDATE CASCADE,);

CREATE TABLE waybill(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    sum double,
    date date,
    worker_id int,
    CONSTRAINT waybill_worker FOREIGN KEY (worker_id) REFERENCES worker (id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE delivery(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    waybill_id int,
    nomenclature_id int,
    count int NOT NULL,
    CONSTRAINT delivery_nomenclature FOREIGN KEY (nomenclature_id) REFERENCES nomenclature (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT delivery_waybill FOREIGN KEY (waybill_id) REFERENCES waybill (id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE product(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    order_id int NOT NULL,
    nomenclature_id int,
    ordered int NOT NULL,
    done int DEFAULT 0 NOT NULL,
    CONSTRAINT product_order FOREIGN KEY (order_id) REFERENCES ordering (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT product_nomenclature FOREIGN KEY (nomenclature_id) REFERENCES nomenclature (id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE route(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    date date NOT NULL);
REATE UNIQUE INDEX route_date_uindex ON route (date);

CREATE TABLE route_data(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    route_id int NOT NULL,
    order_id int NOT NULL,
    position int NOT NULL,
    CONSTRAINT route_data_route FOREIGN KEY (route_id) REFERENCES route (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT route_data_order FOREIGN KEY (order_id) REFERENCES ordering (id) ON DELETE CASCADE ON UPDATE CASCADE);