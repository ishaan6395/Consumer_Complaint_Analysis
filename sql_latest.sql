
create database if not exists bigdataproject2;
use bigdataproject2;

/*
	CFPB_COMPLAINT
*/

create table cfpb_complaint(
complaint_ID int primary key,
date_received varchar(30),
product_ID int,
subproduct_ID int,
issue_ID int,
subissue_ID int,
company_ID int,
submitted_VIA varchar(50),
complaint_narratives varchar(50),
tags varchar(50),
date_sent_to_company varchar(30),
consent_provided varchar(30)
);

/*
	Company_response
*/

create table company_response(
	response_ID int primary key auto_increment,
    complaint_ID int,
    company_ID int,
    company_response varchar(130),
    response_status varchar(50),
    consumer_disputed varchar(20),
    timely_response varchar(20)
);

/*
	Issue
*/

create table issue(
	issue_ID int primary key auto_increment,
    issue_name varchar(200)
);

/*
	Sub issue
*/

create table subissue(
	subissue_ID int primary key auto_increment,
    issue_ID int,
    subissue_name varchar(100)
);

/*
	Product
*/

create table product(
	product_ID int primary key auto_increment,
    product_Name varchar(100)
);

/*
	Subproduct
*/

create table subproduct(
	subproduct_ID int primary key auto_increment,
    product_ID int,
    subproduct_Name varchar(100)
);

/*
	Company
*/

create table company(
	company_ID int primary key auto_increment,
    company_name varchar(100)
);

/*
	Customer
*/

create table customer(
	customer_ID int primary key auto_increment,
    customer_name varchar(50),
    zip varchar(50),
    age int,
    income int
);

/*
	Company Location
*/

create table company_location(
	company_ID int primary key,
    zip varchar(50)
);

/*
	location
*/

create table location(
	state varchar(50),
    city varchar(50),
    zip varchar(50) primary key
);


