-- Tạo database
DROP DATABASE IF EXISTS db_datn_shop_ban_quan_ao_lives_v2;
CREATE DATABASE db_datn_shop_ban_quan_ao_lives_v2;
USE db_datn_shop_ban_quan_ao_lives_v2;

-- Bảng category
CREATE TABLE `t_category` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `category_code` VARCHAR(20) UNIQUE DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parent_category` BIGINT DEFAULT NULL,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_brand` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `brand_code` VARCHAR(20) UNIQUE DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng supplier
CREATE TABLE `t_supplier` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `address_id` INT,
  `supplier_code` VARCHAR(20) UNIQUE DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `phone_number` VARCHAR(20) DEFAULT NULL,
  `email` VARCHAR(50) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Thêm dữ liệu thật vào bảng t_brand
INSERT INTO t_brand (brand_code, name, description, created_by, status)
VALUES
    ('BR001', 'Nike', 'Sportswear brand', 'Admin', 1),
    ('BR002', 'Adidas', 'Sportswear brand', 'Admin', 1),
    ('BR003', 'Apple', 'Technology company', 'Admin', 1);

-- Bảng product
CREATE TABLE `t_product` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `supplier_id` BIGINT,
  `brand_id` BIGINT,
  `category_id` BIGINT,
  `product_code` VARCHAR(20) UNIQUE DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `image` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng product_item
CREATE TABLE `t_product_item` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `product_id` BIGINT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `quantity` VARCHAR(255) DEFAULT NULL,
  `price_import` DECIMAL(20, 2) DEFAULT NULL,
  `price_selling` DECIMAL(20, 2) DEFAULT NULL,
  `price_old` DECIMAL(20, 2) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng image
CREATE TABLE `t_image` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `product_item_id` BIGINT,
  `url` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng variation
CREATE TABLE `t_variation` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `category_id` BIGINT,
  `name` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng variation_option
CREATE TABLE `t_variation_option` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `variation_id` BIGINT,
  `value` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng product_configuration
CREATE TABLE `r_product_configuration` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `product_item_id` BIGINT,
  `variation_option_id` BIGINT,
  PRIMARY KEY (`id`)
);

-- Bảng role
CREATE TABLE `t_role` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `role_code` VARCHAR(20) UNIQUE DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng address
CREATE TABLE `t_address` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `address_line1` VARCHAR(50) DEFAULT NULL,
  `address_line2` VARCHAR(50) DEFAULT NULL,
  `address_line3` VARCHAR(50) DEFAULT NULL,
  `detail_address` VARCHAR(20) DEFAULT NULL,
  `poston_code` VARCHAR(50) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng user
CREATE TABLE `t_user` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `role_id` BIGINT,
  `user_code` VARCHAR(20) UNIQUE DEFAULT NULL,
  `first_name` VARCHAR(50) DEFAULT NULL,
  `last_name` VARCHAR(50) DEFAULT NULL,
  `cccd` VARCHAR(20) UNIQUE DEFAULT NULL,
  `date_of_birth` DATE DEFAULT NULL,
  `email` VARCHAR(100) DEFAULT NULL,
  `phone_number` VARCHAR(100) DEFAULT NULL,
  `password` VARCHAR(50) DEFAULT NULL,
  `image` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng user_address
CREATE TABLE `r_user_address` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `user_id` BIGINT,
  `address_id` BIGINT,
  `is_default` BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`)
);

-- Bảng payment_type
CREATE TABLE `t_payment_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng shipping_method
CREATE TABLE `t_shipping_method` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `price` DECIMAL(20, 2) DEFAULT 0.00,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng bill_status
CREATE TABLE `t_bill_status` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng promotion
CREATE TABLE `t_promotion` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `promotion_code` VARCHAR(20) UNIQUE,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT 'no data',
  `promotion_type` INT DEFAULT NULL,
  `discount_rate` INT DEFAULT 0,
  `money_deals` DECIMAL(20, 2) DEFAULT 0.00,
  `start_date` DATE DEFAULT NULL,
  `end_date` DATE DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT DEFAULT 1,
  PRIMARY KEY (`id`)
);

-- Bảng bill
CREATE TABLE `t_bill` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT,
  `address_id` BIGINT,
  `shipping_method_id` BIGINT,
  `bill_status_id` BIGINT,
  `staff_id` BIGINT,
  `bill_code` VARCHAR(20) UNIQUE,
  `recipient_phone` VARCHAR(20) DEFAULT NULL,
  `cash` DECIMAL(20, 2) DEFAULT NULL,
  `money_transfer` DECIMAL(20, 2) DEFAULT NULL,
  `total_amount` DECIMAL(20, 2) DEFAULT NULL,
  `total_amount_after_discount` DECIMAL(20, 2) DEFAULT NULL,
  `created_by` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

-- Bảng shopping_cart
CREATE TABLE `t_shopping_cart` (
  `cart_id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT,
  PRIMARY KEY (`cart_id`)
);

-- Bảng shopping_cart_detail
CREATE TABLE `t_shopping_cart_detail` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cart_id` BIGINT,
  `product_item_id` BIGINT,
  `quantity` INT DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Bảng promotion_category
CREATE TABLE `r_promotion_category` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `category_id` BIGINT,
  `promotion_id` BIGINT,
  PRIMARY KEY (`id`)
);

-- Bảng promotion_product_item
CREATE TABLE `r_promotion_product_item` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `product_item_id` BIGINT,
  `promotion_id` BIGINT,
  PRIMARY KEY (`id`)
);

-- Bảng bill_detail
CREATE TABLE `r_bill_detail` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bill_id` BIGINT,
  `product_item_id` BIGINT,
  `quantity` INT DEFAULT NULL,
  `price` DECIMAL(20, 2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Bảng user_payment_method
CREATE TABLE `r_user_payment_method` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `customer_id` BIGINT,
  `payment_type_id` BIGINT,
  `bill_id` BIGINT,
  `provider` VARCHAR(100) DEFAULT NULL,
  `account_number` VARCHAR(30) DEFAULT NULL,
  `is_default` BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`)
);

-- Bảng user_review
CREATE TABLE `r_user_review` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `customer_id` BIGINT,
  `bill_detail_id` BIGINT,
  `rating_value` INT DEFAULT NULL,
  `comment` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- Thêm các quan hệ giữa các bảng
-- Một danh mục có thể chứa nhiều sản phẩm
ALTER TABLE `t_product` ADD CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `t_category`(`id`);
-- Một thương hiệu có thể chứa nhiều sản phẩm
ALTER TABLE `t_product` ADD CONSTRAINT `fk_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `t_brand`(`id`);
-- Một nhà cung cấp có thể cung cấp nhiều sản phẩm
ALTER TABLE `t_product` ADD CONSTRAINT `fk_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `t_supplier`(`id`);
-- Một sản phẩm có thể có nhiều phiên bản hoặc chi tiết sản phẩm
ALTER TABLE `t_product_item` ADD CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `t_product`(`id`);
-- Một phiên bản sản phẩm có thể có nhiều hình ảnh
ALTER TABLE `t_image` ADD CONSTRAINT `fk_product_item_id` FOREIGN KEY (`product_item_id`) REFERENCES `t_product_item`(`id`);
-- Một danh mục có thể có nhiều biến thể
ALTER TABLE `t_variation` ADD CONSTRAINT `fk_category_id2` FOREIGN KEY (`category_id`) REFERENCES `t_category`(`id`);
-- Một biến thể có thể có nhiều tùy chọn biến thể
ALTER TABLE `t_variation_option` ADD CONSTRAINT `fk_variation_id` FOREIGN KEY (`variation_id`) REFERENCES `t_variation`(`id`);
-- Một phiên bản sản phẩm có thể có nhiều cấu hình sản phẩm
ALTER TABLE `r_product_configuration` ADD CONSTRAINT `fk_product_item_id2` FOREIGN KEY (`product_item_id`) REFERENCES `t_product_item`(`id`);
-- Một tùy chọn biến thể có thể có nhiều cấu hình sản phẩm
ALTER TABLE `r_product_configuration` ADD CONSTRAINT `fk_variation_option_id` FOREIGN KEY (`variation_option_id`) REFERENCES `t_variation_option`(`id`);
-- Một vai trò có thể có nhiều người dùng
ALTER TABLE `t_user` ADD CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role`(`id`);
-- Một người dùng có thể có nhiều địa chỉ, và một trong số chúng có thể được đánh dấu là mặc định
ALTER TABLE `r_user_address` ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user`(`id`);
ALTER TABLE `r_user_address` ADD CONSTRAINT `fk_address_id` FOREIGN KEY (`address_id`) REFERENCES `t_address`(`id`);
-- Một người dùng có thể có nhiều phương thức thanh toán, và một trong số chúng có thể được đánh dấu là mặc định
ALTER TABLE `r_user_payment_method` ADD CONSTRAINT `fk_payment_type_id` FOREIGN KEY (`payment_type_id`) REFERENCES `t_payment_type`(`id`);
ALTER TABLE `r_user_payment_method` ADD CONSTRAINT `fk_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `t_user`(`id`);
-- Một đơn vị vận chuyển có thể được sử dụng trong nhiều đơn hàng
ALTER TABLE `t_bill` ADD CONSTRAINT `fk_shipping_method_id` FOREIGN KEY (`shipping_method_id`) REFERENCES `t_shipping_method`(`id`);
-- Một trạng thái đơn hàng có thể được sử dụng trong nhiều đơn hàng
ALTER TABLE `t_bill` ADD CONSTRAINT `fk_bill_status_id` FOREIGN KEY (`bill_status_id`) REFERENCES `t_bill_status`(`id`);
-- Một khuyến mãi có thể áp dụng cho nhiều danh mục
ALTER TABLE `r_promotion_category` ADD CONSTRAINT `fk_promotion_id` FOREIGN KEY (`promotion_id`) REFERENCES `t_promotion`(`id`);
ALTER TABLE `r_promotion_category` ADD CONSTRAINT `fk_category__id3` FOREIGN KEY (`category_id`) REFERENCES `t_category`(`id`);
-- Một khuyến mãi có thể áp dụng cho nhiều phiên bản sản phẩm
ALTER TABLE `r_promotion_product_item` ADD CONSTRAINT `fk_promotion_id2` FOREIGN KEY (`promotion_id`) REFERENCES `t_promotion`(`id`);
ALTER TABLE `r_promotion_product_item` ADD CONSTRAINT `fk_product_item_id3` FOREIGN KEY (`product_item_id`) REFERENCES `t_product_item`(`id`);
-- Một người dùng có thể có nhiều đơn hàng
ALTER TABLE `t_bill` ADD CONSTRAINT `fk_customer_id2` FOREIGN KEY (`customer_id`) REFERENCES `t_user`(`id`);
-- Một phiên bản sản phẩm có thể xuất hiện trong nhiều chi tiết đơn hàng
ALTER TABLE `r_bill_detail` ADD CONSTRAINT `fk_product_item_id4` FOREIGN KEY (`product_item_id`) REFERENCES `t_product_item`(`id`);
-- Một người dùng có thể nhận xét nhiều sản phẩm đã mua
ALTER TABLE `r_user_review` ADD CONSTRAINT `fk_customer_id3` FOREIGN KEY (`customer_id`) REFERENCES `t_user`(`id`);
ALTER TABLE `r_user_review` ADD CONSTRAINT `fk_bill_detail_id2` FOREIGN KEY (`bill_detail_id`) REFERENCES `r_bill_detail`(`id`);
-- Một giỏ hàng có thể chứa nhiều mục giỏ hàng
ALTER TABLE `t_shopping_cart_detail` ADD CONSTRAINT `fk_cart_id` FOREIGN KEY (`cart_id`) REFERENCES `t_shopping_cart`(`cart_id`);
-- Một mục giỏ hàng liên quan đến một sản phẩm
ALTER TABLE `t_shopping_cart_detail` ADD CONSTRAINT `fk_product_item_id5` FOREIGN KEY (`product_item_id`) REFERENCES `t_product_item`(`id`);
-- Một người dùng có có thể sở hữu 1 giỏ hàng
ALTER TABLE `t_shopping_cart` ADD CONSTRAINT `fk_customer_id4` FOREIGN KEY (`customer_id`) REFERENCES `t_user`(`id`);
-- Một hóa đơn có nhiều hóa đơn chi tiết
ALTER TABLE `r_bill_detail` ADD CONSTRAINT `fk_bill_id` FOREIGN KEY (`bill_id`) REFERENCES `t_bill`(`id`);
-- Thêm khóa ngoại cho cột parent_category
ALTER TABLE `t_category` ADD CONSTRAINT `fk_parent_category` FOREIGN KEY (`parent_category`) REFERENCES `t_category`(`id`);

-- Thêm dữ liệu vào t_role
INSERT INTO t_role (role_code, name, description, created_by)
VALUES
  ('admin', 'Quản trị viên', 'Vai trò quản trị viên', 'Admin'),
  ('user', 'Người dùng', 'Vai trò người dùng', 'Admin');

-- Thêm dữ liệu vào t_category
INSERT INTO t_category (category_code, name, description, created_by)
VALUES
  ('cat001', 'Điện tử', 'Danh mục Điện tử', 'Admin'),
  ('cat002', 'Thời trang', 'Danh mục Thời trang', 'Admin');

-- Thêm dữ liệu vào t_supplier
INSERT INTO t_supplier (supplier_code, name, phone_number, email, description, created_by)
VALUES
  ('sup001', 'Nhà cung cấp A', '123-456-7890', 'nhacungcapA@example.com', 'Mô tả Nhà cung cấp A', 'Admin'),
  ('sup002', 'Nhà cung cấp B', '987-654-3210', 'nhacungcapB@example.com', 'Mô tả Nhà cung cấp B', 'Admin');

-- Thêm dữ liệu vào t_product
INSERT INTO t_product (supplier_id, brand_id, category_id, product_code, name, description, created_by)
VALUES
  (1, 1, 1, 'prod001', 'Sản phẩm 1', 'Mô tả Sản phẩm 1', 'Admin'),
  (2, 2, 2, 'prod002', 'Sản phẩm 2', 'Mô tả Sản phẩm 2', 'Admin');

-- Thêm dữ liệu vào t_product_item
INSERT INTO t_product_item (product_id, sku, quantity, price_import, price_selling, created_by)
VALUES
  (1, 'SKU001', '100', 50.00, 75.00, 'Admin'),
  (2, 'SKU002', '200', 40.00, 60.00, 'Admin');

-- Thêm dữ liệu vào t_image
INSERT INTO t_image (product_item_id, url, created_by)
VALUES
  (1, 'image1.jpg', 'Admin'),
  (2, 'image2.jpg', 'Admin');
select * from t_image;
-- Thêm dữ liệu vào t_variation
INSERT INTO t_variation (category_id, name, created_by)
VALUES
  (1, 'Kích thước', 'Admin'),
  (1, 'Màu sắc', 'Admin');

-- Thêm dữ liệu vào t_variation_option
INSERT INTO t_variation_option (variation_id, value, created_by)
VALUES
  (1, 'Nhỏ', 'Admin'),
  (1, 'Trung bình', 'Admin'),
  (2, 'Đỏ', 'Admin'),
  (2, 'Xanh', 'Admin');

-- Thêm dữ liệu vào r_product_configuration
INSERT INTO r_product_configuration (product_item_id, variation_option_id)
VALUES
  (1, 1),
  (2, 2);
  
  -- Thêm dữ liệu vào t_promotion
INSERT INTO t_promotion (promotion_code, name, description, promotion_type, discount_rate, money_deals, start_date, end_date, created_by)
VALUES
  ('promo001', 'Khuyến mãi mùa hè', 'Khuyến mãi mùa hè', 1, 20, 0.00, '2023-06-01', '2023-08-31', 'Admin'),
  ('promo002', 'Ưu đãi ngày lễ', 'Ưu đãi ngày lễ', 2, 0, 50.00, '2023-12-01', '2023-12-31', 'Admin');

-- Thêm dữ liệu vào t_shipping_method
INSERT INTO t_shipping_method (name, price, created_by)
VALUES
  ('Giao hàng tiêu chuẩn', 5.00, 'Admin'),
  ('Giao hàng nhanh', 10.00, 'Admin');

-- Thêm dữ liệu vào t_bill_status
INSERT INTO t_bill_status (name)
VALUES
  ('Đang xử lý'),
  ('Đã giao hàng');

-- Thêm dữ liệu vào r_promotion_category
INSERT INTO r_promotion_category (category_id, promotion_id)
VALUES
  (1, 1),
  (2, 2);

-- Thêm dữ liệu vào r_promotion_product_item
INSERT INTO r_promotion_product_item (product_item_id, promotion_id)
VALUES
  (1, 1),
  (2, 2);


