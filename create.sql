
-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jkshop` DEFAULT CHARACTER SET utf8 ;
USE `jkshop` ;

DROP TABLE IF EXISTS `cart_item`;
DROP TABLE IF EXISTS `order_item`;
DROP TABLE IF EXISTS `cart`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `shipping`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `seller`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `shop_order`;

-- -----------------------------------------------------
-- Table `shop`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `register_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`)
);

-- -----------------------------------------------------
-- Table `shop`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `customer_name` VARCHAR(255) NOT NULL,
  `customer_email` VARCHAR(255) NOT NULL,
  `payment_info` VARCHAR(255),
  PRIMARY KEY (`customer_id`)
);

-- -----------------------------------------------------
-- Table `shop`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(255),
  `street_no` VARCHAR(255),
  `unit_no` VARCHAR(255),
  `city` VARCHAR(255),
  `country` VARCHAR(255),
  `other` VARCHAR(255),
  PRIMARY KEY (`address_id`)
);

-- -----------------------------------------------------
-- Table `shop`.`seller`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seller` (
  `seller_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `seller_name` VARCHAR(255) NOT NULL,
  `seller_email` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`seller_id`)
  );

-- -----------------------------------------------------
-- Table `shop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(255) NOT NULL,
  `date_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` TEXT NOT NULL,
  `stock` INT NOT NULL,
  `unit_cost` FLOAT NOT NULL,
  `seller_id` INT NOT NULL,
  PRIMARY KEY (`product_id`)
  );

-- -----------------------------------------------------
-- Table `shop`.`shipping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shipping` (
  `shipping_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255), -- delivery or pickup at pickup points
  `shipping_cost` FLOAT,
  PRIMARY KEY (`shipping_id`)
  );

-- -----------------------------------------------------
-- Table `shop`.`shop_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(255) NOT NULL,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sub_total` FLOAT NOT NULL,
  `customer_id` INT NOT NULL,
  `shipping_id` INT NOT NULL,
  PRIMARY KEY (`order_id`)
  );

-- -----------------------------------------------------
-- Table `shop`.`order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `order_item` (
  `product_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`product_id`,`order_id`)
  );

-- -----------------------------------------------------
-- Table `shop`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT,
  `sub_total` FLOAT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`cart_id`)
  );

-- -----------------------------------------------------
-- Table `shop`.`cart_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cart_item` (
  `product_id` INT NOT NULL,
  `cart_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`product_id`, `cart_id`)
  );

ALTER TABLE `customer` ADD FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`);
ALTER TABLE `customer` ADD FOREIGN KEY (`address_id`) REFERENCES `address`(`address_id`);

ALTER TABLE `seller` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

ALTER TABLE `product` ADD FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`);

ALTER TABLE `shop_order` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);
ALTER TABLE `shop_order` ADD FOREIGN KEY (`shipping_id`) REFERENCES `shipping` (`shipping_id`);

ALTER TABLE `order_item` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
ALTER TABLE `order_item` ADD FOREIGN KEY (`order_id`) REFERENCES `shop_order` (`order_id`);

ALTER TABLE `cart` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

ALTER TABLE `cart_item` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
ALTER TABLE `cart_item` ADD FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`);
