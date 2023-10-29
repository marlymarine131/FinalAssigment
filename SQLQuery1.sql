create database FastFoodAtYourDoor
go
use FastFoodAtYourDoor
go
create table Owner(
	ownerID int identity(1,1) not null primary key,
	taxNumber varchar(10) 
	check(taxNumber like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	ownerName nvarchar(50),
	areaServe nvarchar(100),
	phone varchar(10)
	check (phone like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	decription nvarchar(max),
	email varchar(30) unique check(email  like '[a-z]%@[a-z]%.[a-z]%'),
	addressHead nvarchar(200),
	banner varbinary(max) null,
	password varchar(20) not null,
)
go
create table Shop(
	shopID int identity(1,1) not null primary key,
	ownerID int not null FOREIGN KEY references Owner(ownerID),
	shopName nvarchar(50),
	shopAddress nvarchar(max),
	banner varchar(max) null,
)

go
create table Food(
	foodID int identity(1,1) not null primary key,
	shopID int not null foreign key references Shop(shopID),
	foodName nvarchar(50),
	price decimal(18,2),
)

go
<<<<<<< HEAD
create table voucher(
	dateAplied Date,
	queriDate Date,
	price float,
	voucherID int identity(1,1) primary key,
	foodID int not null foreign key references Food(foodID)	
)
=======
create table customer (
	cusID INT IDENTITY(1,1) PRIMARY KEY,
	address nvarchar(200),
	Username varchar(20),
	phone varchar(10) check (phone like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	password varchar(20) not null,
	name nvarchar(50),
	email varchar(30) unique check (email LIKE '[a-z]%@[a-z]%.[a-z]%')
	);

go
create table Shipper (
	ShipperID int not null primary key,
	address nvarchar(200),
	Username varchar(20),
	phone varchar(10) check (phone like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	password varchar(20) not null,
	name nvarchar(50),
	email varchar(30) check (email LIKE '[a-z]%@[a-z]%.[a-z]%')
	);
create table Order1 (
	OrderID int not null primary key,
	shopID int not null,
	ShipperID int,
	cusID int not null,
	foodID int not null,
	address nvarchar(200),
	quantity int,
	total_price decimal(18,2),
	status nvarchar(50),
	foreign key (shopID) references Shop(shopID),
	foreign key (ShipperID) references Shipper(ShipperID),
	foreign key (cusID) references Customer(cusID),
	foreign key (foodID) references Food(foodID)
	);

	
>>>>>>> 54393f68c438b9b0a3cfc0a995ac126ec9a9d20e
