drop table tb_user if exists ;
CREATE TABLE IF NOT EXISTS tb_user (
    id bigint(20) primary key auto_increment,
    name varchar(50) not null,
    points DECIMAL(20,2) default 0,
    member_type_id TINYINT(8) default 1,
    deleted TINYINT(8) default 0,
    create_time TIMESTAMP default CURRENT_TIMESTAMP,
    update_time TIMESTAMP default CURRENT_TIMESTAMP
);

drop table tb_member_type if exists ;
CREATE TABLE IF NOT EXISTS tb_member_type (
    id TINYINT(8) primary key auto_increment,
    name varchar(50) not null,
    create_time TIMESTAMP default CURRENT_TIMESTAMP,
    update_time TIMESTAMP default CURRENT_TIMESTAMP
);

drop table tb_user_order if exists ;
CREATE TABLE tb_user_order (
    id bigint(20) primary key auto_increment,
    order_number varchar(20) default null ,
    user_id bigint(20),
    order_amount DECIMAL(20,2) ,
    trade_status tinyint(8) default 0 ,
    pay_status tinyint(8) default 0 ,
    deleted TINYINT(8) default 0,
    create_time TIMESTAMP default CURRENT_TIMESTAMP,
    update_time TIMESTAMP default CURRENT_TIMESTAMP
);

/**
  后期可扩展添加订单明细表，积分明细表等
 */