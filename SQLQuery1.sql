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
	banner varbinary(max) null,
)

go
create table Food(
	foodID int identity(1,1) not null primary key,
	shopID int not null foreign key references Shop(shopID),
	foodName nvarchar(50),
	price decimal(18,2),
	imagine varbinary(max) null,
)
go
create table voucher(
	dateAplied Date,
	queriDate Date,
	price float,
	voucherID int identity(1,1) primary key,
	foodID int not null foreign key references Food(foodID)	
)
go
create table customer (
	cusID INT IDENTITY(1,1) PRIMARY KEY,
	address nvarchar(200),
	phone varchar(10)
	check (phone like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	password varchar(20) not null,
	name nvarchar(50),
	email varchar(30) unique check (email LIKE '[a-z]%@[a-z]%.[a-z]%')
	);
	go
create table Shipper (
	ShipperID int IDENTITY(1,1) not null primary key,
	address nvarchar(200),
	Username varchar(20),
	phone varchar(10) check (phone like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	password varchar(20) not null,
	name nvarchar(50),
	email varchar(30) check (email LIKE '[a-z]%@[a-z]%.[a-z]%')
	);
	go
CREATE TABLE OrderTotal (
    OrderID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    cusID INT NOT NULL,
    address NVARCHAR(200),
    total_price DECIMAL(18,2) DEFAULT 0,
    status NVARCHAR(50) DEFAULT 'Not Delivery',    
    FOREIGN KEY (cusID) REFERENCES Customer(cusID)
);
go
	CREATE TABLE OrderDetail (
    quantity INT DEFAULT 0,
    orderDetailID INT IDENTITY(1,1) PRIMARY KEY,
    cusID INT FOREIGN KEY REFERENCES Customer(cusID),
    OrderID INT DEFAULT NULL FOREIGN KEY REFERENCES OrderTotal(OrderID),
    foodID INT FOREIGN KEY REFERENCES Food(foodID),
    shopID INT FOREIGN KEY REFERENCES Shop(shopID),
    subTotal DECIMAL(18,2),  
);
CREATE TABLE OderShop(
	orderShopID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	shopID INT FOREIGN KEY REFERENCES Shop(shopID),
	foodName nvarchar(50),
	ShipperID INT NULL,
	cusID INT NOT NULL,
	quantity INT,
	address NVARCHAR(200),
	shopOrderPrice DECIMAL(18,2),
	orderDetailID INT FOREIGN KEY REFERENCES OrderDetail(orderDetailID),
	FOREIGN KEY (ShipperID) REFERENCES Shipper(ShipperID),

)
create table shopShipper(
	shopID int not null foreign key references Shop(shopID),
	ShipperID int foreign key (ShipperID) references Shipper(ShipperID),
)
go
CREATE TRIGGER tr_OrderDetail_Insert
ON OrderDetail
AFTER INSERT , UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    UPDATE od
    SET od.subTotal = f.price * i.quantity
    FROM OrderDetail od
    INNER JOIN Food f ON od.foodID = f.foodID
    INNER JOIN inserted i ON od.orderDetailID = i.orderDetailID;
END;
go
CREATE TRIGGER tr_OrderDetail_AfterInsert
ON OrderDetail
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    UPDATE o
    SET o.total_price = (
        SELECT SUM(od.subTotal)
        FROM OrderDetail od
        WHERE od.OrderID = o.OrderID
    )
    FROM OrderTotal o
    INNER JOIN inserted i ON o.OrderID = i.OrderID;
END;



	

