	create table user (
		id bigint not null auto_increment,
        name varchar(100) not null,
		mobile varchar(100),
        sex varchar(2),
        login_password varchar(256) not null,
        email varchar(100),
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
    
    create table broker (
		id bigint not null auto_increment,
        name varchar(100) not null,
		mobile varchar(100),
        sex varchar(2),
        primary key (id)
    );
    
    create table user_house (
		id bigint not null auto_increment,
        user_id bigint not null,
        house_id bigint not null,
        description varchar(100)
    );