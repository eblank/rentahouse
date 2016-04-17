DROP TABLE IF EXISTS `user`;

create table user (
	id bigint not null auto_increment,
	nick_name varchar(50) not null,
	real_name varchar(50) not null,
	create_time datetime not null,
	mobile varchar(100),
	sex varchar(2),
	address varchar(300),
	member_state bigint,
	member_type bigint,
	login_password varchar(256) not null,
	email varchar(100),
	country varchar(100),
	province varchar(100),
	city varchar(100),
	county varchar(100),
	town varchar(100),
	neighbourhood varchar(100),
	housing_estate varchar(100),
	primary key (id)
);
    
create table house (
	id bigint not null auto_increment,
	main_title varchar(300) not null,
	primary_pic_List varchar(300) not null,
	house_price bigint not null,
	bed_room bigint,
	living_room bigint,
	rest_room bigint,
	area bigint,
	rent_floor bigint,
	toward varchar(10),
	house_type varchar(30),
	country varchar(100),
	province varchar(100),
	city varchar(100),
	county varchar(100),
	town varchar(100),
	housing_estate varchar(100),
	build_num varchar(10),
	unit_num varchar(10),
	room_num varchar(10),
	furniture varchar(200),
	description varchar(800),
	housing_estate_description varchar(800),

	contact bigint not null,
	primary key (id)
);

/*
联系人
*/
create table landlord (
	id bigint not null auto_increment,
	name varchar(50) not null,
	mobile varchar(30),
	sex varchar(2),
	type bigint not null,
	primary key (id)
);

/*
个人收藏信息
*/
create table user_house (
	id bigint not null auto_increment,
	user_id bigint not null,
	house_id bigint not null,
    remark varchar(300),
	description varchar(100),
	primary key(id)
);

/*
攻略
*/
create table strategy(
	id bigint not null auto_increment,
    title varchar(100) not null,
    user bigint,
    author varchar(50),
    create_time datetime,
    content varchar(1000),
    status bigint,
    primary key(id)
);

/*
评论
*/
create table comment(
	id bigint not null auto_increment,
    house bigint,
    user bigint,
    content varchar(100),
    create_time datetime,
    primary key(id)
);

/* 
访问过的url
*/
create table url(
	id bigint not null auto_increment,
    url varchar(300) not null,
    status bigint
);

/* 
地区
*/
create table country(
	id bigint not null auto_increment,
    code varchar(20) not null,
    name varchar(100) not null,
    primary key(id)
);
create table province(
	id bigint not null auto_increment,
    code varchar(20) not null,
    name varchar(100) not null,
    country_code varchar(100) not null,
    primary key(id)
);
create table city(
	id bigint not null auto_increment,
    code varchar(20) not null,
    name varchar(100) not null,
    url varchar(300) not null,
    province_code varchar(100) not null,
    primary key(id)
);
create table county(
	id bigint not null auto_increment,
    code varchar(20) not null,
    name varchar(100) not null,
    url varchar(300) not null,
    city_code varchar(100) not null,
    primary key(id)
);
create table town(
	id bigint not null auto_increment,
    code varchar(20) not null,
    name varchar(100) not null,
    url varchar(300) not null,
    county_code varchar(100) not null,
    primary key(id)
);












    
    
    