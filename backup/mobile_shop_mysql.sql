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
    `id_receipt` varchar(7) not null,
    `id_object` varchar(7) not null,
    primary key(id_receipt, id_object),

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
    `id_object` varchar(7) not null,
    `id_bill` varchar(7) not null,
    primary key(id_object, id_bill),

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
INSERT INTO staff (id, name, password, gender, role, id_shift) VALUES ('ST01', 'Lê Văn Phát', 'ADMIN', true, 1, 'WS3');
INSERT INTO staff (id, name, password, gender, role, id_shift) VALUES ('ST02', 'Huỳnh Thanh Duy', 'ADMIN', true, 1, 'WS1');
INSERT INTO staff (id, name, password, gender, role, id_shift) VALUES ('ST03', 'Lê Thị A', 'ST03', false, 0, 'WS2');

-- Inserting into customer_category table
INSERT INTO customer_category (id, name, discount) VALUES ('CC01', 'Học sinh, sinh viên', 0);
INSERT INTO customer_category (id, name, discount) VALUES ('CC02', 'Khách hàng thân thiết', 0);
INSERT INTO customer_category (id, name, discount) VALUES ('CC03', 'Bình thường', 0);

-- Inserting into object_category table
INSERT INTO object_category (id, name) VALUES ('OC01', 'Chính hãng');
INSERT INTO object_category (id, name) VALUES ('OC02', 'Like new');