create database Shop;
use Shop;

create table Types (
    id int primary key auto_increment,
    name varchar(20)        -- może nie 20, nwm
);

create table Brands (
    id int primary key auto_increment,
    name varchar(30)
);

create table Colors (
    id int primary key auto_increment,
    name varchar(30),
);

create table CoverageLevel (
    id int primary key auto_increment,
    name varchar(30),
    numericValue int        -- może coś stałoprzecinkowego też być
)

create table Products (
    id int primary key auto_increment,
    color int,
    brand int,
    coverageLevel int,
    type int,

    name varchar(100),      -- tego nie było w projekcie

    foreign key (color) references Colors(id),
    foreign key (brand) references Brands(id),
    foreign key (coverageLevel) references coverageLevel,
    foreign key (type) references Types(id)
);

create table Offer (
    id int primary key auto_increment,
    pricePerUnit decimal(5, 2),          -- fixed point ig
    unitsInStock int,
    product int,

    foreign key (product) references Products(id) 
);

create table Clients (
    id int primary key auto_increment,
    name varchar(50),
    surname varchar(50),
    address varchar(100),
);

create table Invoices (
    id int primary key auto_increment,
    dateIssued date,
    client int,

    foreign key (client) references Clients(id)
);

create table InvoiceLine (
    id int primary key auto_increment,
    pricePerUnit decimal(5, 2),
    units int,
    product int,
    invoice int,

    foreign key (product) references Products(id),
    foreign key (invoice) references Invoices(id)
);
