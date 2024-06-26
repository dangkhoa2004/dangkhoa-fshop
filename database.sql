USE master;
GO
CREATE DATABASE FSHOP;
GO
USE FSHOP;
GO

CREATE TABLE Brand
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Connect
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE LED
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Type
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Battery
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Color
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Coupon
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    code VARCHAR(50),
    discount INT CHECK (discount > 0),
    expirydate DATE
);


-- Create the Mouse table
CREATE TABLE Mouse
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price INT,
    saleprice INT,
    brand_id INT,
    connect_id INT,
    led_id INT,
    type_id INT,
    battery_id INT,
    color_id INT,
    FOREIGN KEY (brand_id) REFERENCES Brand(id),
    FOREIGN KEY (connect_id) REFERENCES Connect(id),
    FOREIGN KEY (led_id) REFERENCES LED(id),
    FOREIGN KEY (type_id) REFERENCES Type(id),
    FOREIGN KEY (battery_id) REFERENCES Battery(id),
    FOREIGN KEY (color_id) REFERENCES Color(id),
);

-- #### Liên quan tới sản phâm ####

-- tạo bảng kho
CREATE TABLE Storage
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255)
);
-- tạo bảng kho chứa mouse
CREATE TABLE MouseStorage
(
    mouse_id INT,
    storage_id INT,
    quantity INT,
    FOREIGN KEY (mouse_id) REFERENCES Mouse(id),
    FOREIGN KEY (storage_id) REFERENCES Storage(id),
    PRIMARY KEY (mouse_id, storage_id)
);

-- Tạo bảng Invoice
CREATE TABLE Invoice
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    time_create TIME,
    date_create DATE,
    total DECIMAL,
    coupon_id INT,
    FOREIGN KEY (coupon_id) REFERENCES Coupon(id)
);

-- Tạo bảng trung gian InvoiceMouse
CREATE TABLE invoiceMouse
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    invoice_id int, 
    mouse_id INT,
    quantity INT,
    money DECIMAL,
    total DECIMAL,
    FOREIGN KEY (invoice_id) REFERENCES Invoice(id),
    FOREIGN KEY (mouse_id) REFERENCES Mouse(id),
);

-- Create the ImageUrl table
CREATE TABLE ImageUrl
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    mouse_id INT,
    url TEXT,
    FOREIGN KEY (mouse_id) REFERENCES Mouse(id)
);
GO
-- Insert data into Brand table
INSERT INTO Brand
    (id, name)
VALUES
    (1, 'Logitech');
INSERT INTO Brand
    (id, name)
VALUES
    (2, 'Razer');
INSERT INTO Brand
    (id, name)
VALUES
    (3, 'Microsoft');
INSERT INTO Brand
    (id, name)
VALUES
    (4, 'Corsair');
INSERT INTO Brand
    (id, name)
VALUES
    (5, 'SteelSeries');
INSERT INTO Brand
    (id, name)
VALUES
    (6, 'Asus');

-- Insert data into Connect table
INSERT INTO Connect
    (id, name)
VALUES
    (1, 'USB');
INSERT INTO Connect
    (id, name)
VALUES
    (2, 'Bluetooth');
INSERT INTO Connect
    (id, name)
VALUES
    (3, 'Wireless');
INSERT INTO Connect
    (id, name)
VALUES
    (4, 'Wired');
INSERT INTO Connect
    (id, name)
VALUES
    (5, 'RF');

-- Insert data into LED table
INSERT INTO LED
    (id, name)
VALUES
    (1, 'RGB LED');
INSERT INTO LED
    (id, name)
VALUES
    (2, 'Blue LED');
INSERT INTO LED
    (id, name)
VALUES
    (3, 'Red LED');
INSERT INTO LED
    (id, name)
VALUES
    (4, 'Green LED');
INSERT INTO LED
    (id, name)
VALUES
    (5, 'No LED');

-- Insert data into Type table
INSERT INTO Type
    (id, name)
VALUES
    (1, 'Gaming Mouse');
INSERT INTO Type
    (id, name)
VALUES
    (2, 'Ergonomic Mouse');
INSERT INTO Type
    (id, name)
VALUES
    (3, 'Travel Mouse');
INSERT INTO Type
    (id, name)
VALUES
    (4, 'Standard Mouse');
INSERT INTO Type
    (id, name)
VALUES
    (5, 'Trackball Mouse');

-- Insert data into Battery table
INSERT INTO Battery
    (id, name)
VALUES
    (1, 'AA Battery');
INSERT INTO Battery
    (id, name)
VALUES
    (2, 'AAA Battery');
INSERT INTO Battery
    (id, name)
VALUES
    (3, 'Rechargeable Battery');
INSERT INTO Battery
    (id, name)
VALUES
    (4, 'Lithium-ion Battery');
INSERT INTO Battery
    (id, name)
VALUES
    (5, 'No Battery');

-- Insert data into Color table
INSERT INTO Color
    (id, name)
VALUES
    (1, 'Black');
INSERT INTO Color
    (id, name)
VALUES
    (2, 'White');
INSERT INTO Color
    (id, name)
VALUES
    (3, 'Red');
INSERT INTO Color
    (id, name)
VALUES
    (4, 'Blue');
INSERT INTO Color
    (id, name)
VALUES
    (5, 'Gray');
INSERT INTO Color
    (id, name)
VALUES
    (6, 'Magenta');

-- insert bảng kho
INSERT INTO Storage
    (name)
VALUES
    ('Kho chính'),
    ('Kho phụ');
-- insert bảng kho chuột
INSERT INTO MouseStorage
    (mouse_id, storage_id, quantity)
VALUES
    (1, 1, 100),
    (1, 2, 50);

-- Insert data into Mouse table
INSERT INTO Mouse
    (name, description, price, saleprice, brand_id, connect_id, led_id, type_id, battery_id, color_id)
VALUES
    ('Logitech G Pro X Superlight 2 Magenta', '', 3890000, 3290000, 1, 3, 1, 1, 4, 1),
    ('Asus Rog Keris Wireless Aimpoint White', '', 2790000, 2590000, 2, 2, 1, 1, 3, 2),
    ('Logitech G502 X Plus LightSpeed White', '', 3890000, 3290000, 1, 3, 1, 1, 4, 2),
    ('Razer Basilisk V3 Pro White', '', 4090000, 3590000, 2, 3, 1, 1, 4, 2),
    ('Corsair Darkstar RGB', '', 3990000, 3590000, 4, 3, 1, 1, 4, 1);

-- Thêm dữ liệu mẫu vào bảng Coupon (giả định bảng này đã tồn tại)
INSERT INTO Coupon
    (code, discount, expirydate)
VALUES
    ('DISCOUNT10', 10.00, '2024-12-31');

INSERT INTO Coupon
    (code, discount, expirydate)
VALUES
    ('SUMMER20', 20.00, '2024-06-30');

-- Thêm dữ liệu mẫu vào bảng Invoice
INSERT INTO Invoice
    (time_create, date_create, total, coupon_id)
VALUES
    ('12:30:00', '2024-01-01', 90.00, 1),
    ('15:45:00', '2024-02-15', 200.00, 2);

-- Thêm dữ liệu mẫu vào bảng InvoiceMouse
INSERT INTO InvoiceMouse
    (invoice_id, mouse_id, quantity, money, total)
VALUES
    (1, 1, 2, 45.00, 90.00),
    (2, 2, 4, 50.00, 200.00);

-- Insert data into ImageUrl table
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (1, 'https://product.hstatic.net/200000722513/product/6_cc9e6a9210494554aed0ed8cbb6f8a5a_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (1, 'https://product.hstatic.net/200000722513/product/7_d8b8b4ab4ad14b049c4e64ba3ea395c6_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (1, 'https://product.hstatic.net/200000722513/product/8_e5a2d429ad874de4ab2171ab05c91e1d_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (1, 'https://product.hstatic.net/200000722513/product/9_03e31c8eddac4fb69ceac0560069b31c_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (1, 'https://product.hstatic.net/200000722513/product/10_7899fa26926b4cf2a3c476ca82f965a0_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (2, 'https://product.hstatic.net/200000722513/product/2_11b39f50b7fc443485a8ee56b4db6905_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (2, 'https://product.hstatic.net/200000722513/product/rog-keris-wireless-aimpoint-white-05_14f0b66d2aca4273857379a208e9da6c_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (2, 'https://product.hstatic.net/200000722513/product/rog-keris-wireless-aimpoint-white-02_18488763418548e0a3fc2dc29653557b_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (2, 'https://product.hstatic.net/200000722513/product/rog-keris-wireless-aimpoint-white-03_293d839259774d30a8e0e08bef79f213_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (2, 'https://product.hstatic.net/200000722513/product/rog-keris-wireless-aimpoint-white-08_4b567000162b403ab2713d084d2b8afe_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (3, 'https://product.hstatic.net/200000722513/product/g502x-plus-gallery-2-white_69229c9ba5534ad5bfae7d827037a28f_365394a31b6342e4949249099adb755e_1024x1024.png');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (3, 'https://product.hstatic.net/200000722513/product/gitech-g502-x-plus-lightspeed-white-2_090a6410c89c4d26badc50edaa35ec0a_6c65ae8ddb37403fa1ad73c88e35c09f_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (3, 'https://product.hstatic.net/200000722513/product/gitech-g502-x-plus-lightspeed-white-4_0ef5e503aac946288ad0a1c4d446f112_b13cc6c8275449ff9b08730c19ebd0e4_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (3, 'https://product.hstatic.net/200000722513/product/gitech-g502-x-plus-lightspeed-white-5_378b369c5b7646e5a53a1216ca6ef2d3_49957a032f654c7b96b728c5e1886b40_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (3, 'https://product.hstatic.net/200000722513/product/gitech-g502-x-plus-lightspeed-white-6_021463df5b8c4ed68e5923f14cf4b591_64083972a1b34409a23c5a6752ce904f_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (4, 'https://product.hstatic.net/200000722513/product/thumbchuot-recovered_44dcc374ea4d40e9bfaa4fa0d086f62f_c213a6395356408aae12d54abc6ff8ee_1024x1024.gif');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (4, 'https://product.hstatic.net/200000722513/product/techspace-zowie-ec2-wl-3_61d7e530856045489c9f6430ef933cee_3be34c92ef894418a81a57a154000fe7_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (4, 'https://product.hstatic.net/200000722513/product/techspace-zowie-ec2-wl-2_39d19fcffd9f4d909c3d08b91014b1ad_8de7639abaf047ff90a72af1abdcdfac_1024x1024.jpg');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (5, 'https://product.hstatic.net/200000722513/product/zkcjs5el_4e9208da4d9648fba24bf590fed636cd_1024x1024.png');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (5, 'https://product.hstatic.net/200000722513/product/4dywf2sh_aaf9095c5f604198ba15257cd3bbcb84_1024x1024.png');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (5, 'https://product.hstatic.net/200000722513/product/sfnvk9vc_8a38e9948c8147e59cb59a4b08ff7757_1024x1024.png');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (5, 'https://product.hstatic.net/200000722513/product/riup6haq_b412064379c04dcd8ea29a7042fdbb6b_1024x1024.png');
INSERT INTO ImageUrl
    (mouse_id, url)
VALUES
    (5, 'https://product.hstatic.net/200000722513/product/0o6qlqve_83e210487fb64775a16dd18acc5b5bce_1024x1024.png');

-- Tạo bảng Account
CREATE TABLE Account
(
    id INT IDENTITY PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    avt VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50),
    sex VARCHAR(10),
    status INT
);

-- Thêm dữ liệu vào bảng Account
INSERT INTO Account
    (username, password, name, email, phone, sex, status)
VALUES
    ('admin', '123', 'Quản Trị Viên', 'khoacdpp02847@fpt.edu.vn', '0869938981', 'Male', 1),
    ('user', '123', 'Người Dùng', 'khoacdpp02847@fpt.edu.vn', '0869938981', 'Male', 1);


