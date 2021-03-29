/*在线车辆管理系统的数据库表以及语句*/
create database car2020;
/*用户表*/
create table user (
  id         int primary key auto_increment,
  username   varchar(20),
  password   int,
  isSeller   varchar(10),
  identitys  varchar(20),
  nickname   varchar(20) null,
  sex        varchar(2) not null,
  mail       varchar(20),
  phone      varchar(20),
  imgUrl     varchar (100),
  logintime  time
);
insert into user
values(1,"admin",'12345','yes','normal','Jack','1','123@qq.com','13057507628',null,null);
insert into user(username, password, isSeller, identitys, nickname, sex, mail, phone, imgUrl, logintime)
values("admin1",'292736','yes','unnormal','Operator','1','456@qq.com','13012333333',null,null);
/*车辆表*/
create table product(
    productId            int(100) primary key auto_increment,
    productName          varchar(200) not null ,/*车辆名称*/
    productPrice         varchar(100) not null ,/*车辆的拍卖价格*/
    productMeters        int(50),/*里程数*/
    productAddress       varchar(200),/*车辆地址*/
    productOwner         varchar(20) not null ,/*发起拍卖的人*/
    productOwnerPhone    varchar(20),/*联系电话*/
    productTime          varchar(100),/*发布时间*/
    productImage1        varchar(100),/*车辆图片，最多四张*/
    productImage2        varchar(100),
    productImage3        varchar(100),
    productImage4        varchar(100),
    productOthers        varchar(100),/*过户次数*/
    productColor         varchar(100),/*车辆颜色*/
    productOil           varchar(100),/*燃油标号，比如95号汽油*/
    productLength        int,/*车辆长度*/
    productWidth         int,/*车辆宽度*/
    productBlueB         varchar(100),/*环保标准*/
    productOrinPrice     int,/*车辆原价*/
    productBrand         varchar(50),/*车辆品牌*/
    productMsg           varchar(100),/*车辆备注*/
    productStatus        varchar(100),/*拍卖的状态，可分为拍卖中/拍卖已结束*/
    productEndTime       varchar(200)
);
/*如果出现插入不了数据的情况，那么就alter table 表名 convert to character set utf8mb4 collate utf8mb4_bin;即可*/

/*邮件表*/
create table AdminMail(
    id            int primary key  auto_increment,
    sendMailer    varchar(50),
    msgTheme      varchar(50),
    message       varchar(50),
    mailTime      varchar(50),
    status        varchar(30)/*状态可分为已经处理，待处理*/
);
/*拍卖消息表*/
create table UserMessage(
    id           int primary key auto_increment,
    sellerName   varchar(100),/*发布拍卖的人*/
    userName     varchar(100),/*拍卖的人*/
    productName varchar(100),
    Message      varchar(100),
    price        int,
    time         varchar(100)
);
/*出现incorrect string value的时候，就alter table usermessage change userName userName varchar(100) character set utf8mb4;*/
/*车辆评论表*/
create table UserComments(
    id             int primary key auto_increment,
    text           varchar(100),/*评论内容*/
    username       varchar(20),/*品论这*/
    time           varchar(100),
    Name           varchar(100)/*商品名*/
);
/*已完成订单*/
create table completed(
    id            int primary key auto_increment,
    sellerName    varchar(20) character set utf8,/*商品主人*/
    user          varchar(20) character set utf8,/*成交的用户*/
    time          varchar(100) character set utf8,/*成交时间*/
    Name          varchar(100) character set utf8,
    cPrice        int /*成交价格*/
);
/*浏览记录*/
create table history(
    id       int primary key auto_increment,
    carName  varchar(100) character set utf8,
    time     varchar(100) character set utf8,
    scanner  varchar(100)/*浏览者*/
);