-- create database
DROP DATABASE if exists `mobile_shop`;
create database `mobile_shop`;
use `mobile_shop`;

-- create tables
create table `suplier`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null,
    `address` varchar(1000) not null,
    `phone` varchar(10),
    `status` boolean
);

create table `customer_category`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null,
    `discount` double default 0
);

create table `customer`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null,
    `address` varchar(1000),
    `gender` boolean not null,
    `birthday` datetime,
    `phone` varchar(10),
    `id_category` varchar(7) not null,

    foreign key(id_category) references customer_category(id)
);

create table `object_category`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null
);

create table `object`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null,
    `status` varchar(1000) not null,
    `manufacture` varchar(1000) not null,
    `unitprice` int,
    `id_category` varchar(7) not null,

    foreign key(id_category) references object_category(id)
);

create table `work_shift`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null
);

create table `staff`
(
    `id` varchar(7) primary key not null,
    `name` varchar(1000) not null,
    `password` varchar(100),
    `address` varchar(1000),
    `gender` boolean not null,
    `birthday` datetime,
    `phone` varchar(10),
    `role` boolean not null,
    `id_shift` varchar(7) not null,

    foreign key(id_shift) references work_shift(id)
);

create table `receipt_note`
(
    `id` varchar(7) primary key not null,
    `date` datetime not null,
    `more_info` varchar(1000),
    `id_suplier` varchar(7) not null,
    `id_staff` varchar(7) not null,

    foreign key(id_suplier) references suplier(id),
    foreign key(id_staff) references staff(id)
);

create table `rn_detail`
(
    `unit_price` int not null,
    `count` int not null,
    `id_receipt` varchar(7) primary key not null,
    `id_object` varchar(7) not null,

    foreign key(id_receipt) references receipt_note(id),
    foreign key(id_object) references object(id)
);

create table `bill`
(
    `id` varchar(7) primary key not null,
    `date` datetime not null,
    `status` varchar(1000),
    `id_customer` varchar(7) not null,
    `id_staff` varchar(7) not null,

    foreign key(id_customer) references customer(id),
    foreign key(id_staff) references staff(id)
);

create table `bill_detail`
(
    `count` int not null,
    `id_object` varchar(7) primary key not null,
    `id_bill` varchar(7) not null,

    foreign key(id_object) references object(id),
    foreign key(id_bill) references bill(id)
);

-- //////////////////////////////////////////////////////////////////
-- //////////////////////////////////////////////////////////////////
-- //////////////////////////////////////////////////////////////////

use `mobile_shop`;
-- Inserting into work_shift table
INSERT INTO work_shift (id, name) VALUES ('WS1', '7h - 12h');
INSERT INTO work_shift (id, name) VALUES ('WS2', '12h - 5h');
INSERT INTO work_shift (id, name) VALUES ('WS3', 'ADMIN');

-- Inserting into staff table
INSERT INTO staff (id, name, password, gender, role, id_shift) VALUES ('ST01', 'Lê Văn Phát', 'admin', true, 1, 'WS3');
INSERT INTO staff (id, name, password, gender, role, id_shift) VALUES ('ST02', 'Huỳnh Thanh Duy', 'admin', true, 1, 'WS1');
INSERT INTO staff (id, name, gender, role, id_shift) VALUES ('ST03', 'Lê Thị A', false, 1, 'WS2');

-- Inserting into suplier table
INSERT INTO suplier (id, name, address, phone, status) VALUES ('S01', 'Suplier 1', 'Address 1', 1234567890, true);
INSERT INTO suplier (id, name, address, phone, status) VALUES ('S02', 'Suplier 2', 'Address 2', 9876543210, false);
INSERT INTO suplier (id, name, address, phone, status) VALUES ('S03', 'Suplier 3', 'Address 3', 5555555555, true);

-- Inserting into customer_category table
INSERT INTO customer_category (id, name, discount) VALUES ('CC01', 'Category 1', 0.1);
INSERT INTO customer_category (id, name, discount) VALUES ('CC02', 'Category 2', 0.2);
INSERT INTO customer_category (id, name, discount) VALUES ('CC03', 'Category 3', 0.3);

-- Inserting into customer table
INSERT INTO customer (id, name, address, gender, birthday, phone, id_category) VALUES ('C0001', 'Customer 1', 'Address 1', true, '1990-01-01', 1234567890, 'CC01');
INSERT INTO customer (id, name, address, gender, birthday, phone, id_category) VALUES ('C0002', 'Customer 2', 'Address 2', false, '1995-05-05', 9876543210, 'CC02');
INSERT INTO customer (id, name, address, gender, birthday, phone, id_category) VALUES ('C0003', 'Customer 3', 'Address 3', true, '2000-10-10', 5555555555, 'CC03');

-- Inserting into object_category table
INSERT INTO object_category (id, name) VALUES ('OC01', 'Category 1');
INSERT INTO object_category (id, name) VALUES ('OC02', 'Category 2');
INSERT INTO object_category (id, name) VALUES ('OC03', 'Category 3');

-- Inserting into object table
INSERT INTO object (id, name, status, manufacture, unitprice, id_category) VALUES ('O0001', 'Object 1', 'Status 1', 'Manufacture 1', 100, 'OC01');
INSERT INTO object (id, name, status, manufacture, unitprice, id_category) VALUES ('O0002', 'Object 2', 'Status 2', 'Manufacture 2', 200, 'OC02');
INSERT INTO object (id, name, status, manufacture, unitprice, id_category) VALUES ('O0003', 'Object 3', 'Status 3', 'Manufacture 3', 300, 'OC03');

-- Inserting into receipt_note table
INSERT INTO receipt_note (id, date, more_info, id_suplier, id_staff) VALUES ('RN01', '2022-01-01', 'More info 1', 'S01', 'ST01');
INSERT INTO receipt_note (id, date, more_info, id_suplier, id_staff) VALUES ('RN02', '2022-02-02', 'More info 2', 'S02', 'ST02');
INSERT INTO receipt_note (id, date, more_info, id_suplier, id_staff) VALUES ('RN03', '2022-03-03', 'More info 3', 'S03', 'ST03');

-- Inserting into rn_detail table
INSERT INTO rn_detail (unit_price, count, id_receipt, id_object) VALUES (1000, 1, 'RN01', 'O0001');
INSERT INTO rn_detail (unit_price, count, id_receipt, id_object) VALUES (2000, 2, 'RN02', 'O0002');
INSERT INTO rn_detail (unit_price, count, id_receipt, id_object) VALUES (3000, 3, 'RN03', 'O0003');

-- Inserting into bill table
INSERT INTO bill (id, date, status, id_customer, id_staff) VALUES ('B0001', '2022-01-01', 'Status 1', 'C0001', 'ST01');
INSERT INTO bill (id, date, status, id_customer, id_staff) VALUES ('B0002', '2022-02-02', 'Status 2', 'C0002', 'ST02');
INSERT INTO bill (id, date, status, id_customer, id_staff) VALUES ('B0003', '2022-03-03', 'Status 3', 'C0003', 'ST03');

-- Inserting into bill_detail table
INSERT INTO bill_detail (count, id_object, id_bill) VALUES (1, 'O0001', 'B0001');
INSERT INTO bill_detail (count, id_object, id_bill) VALUES (2, 'O0002', 'B0002');
INSERT INTO bill_detail (count, id_object, id_bill) VALUES (3, 'O0003', 'B0003');