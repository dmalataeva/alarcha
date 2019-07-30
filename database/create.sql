CREATE DATABASE IF NOT EXISTS `may_prototype`;
USE `may_prototype`;

DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS `OrderItem`;
DROP TABLE IF EXISTS `Item`;
DROP TABLE IF EXISTS `Delivery`;
DROP TABLE IF EXISTS `Pickup`;

CREATE TABLE `Order` (
  orderId INT NOT NULL AUTO_INCREMENT,
  userId INT,
  datePlaced TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  collectMethod VARCHAR(255) NOT NULL,
  total FLOAT(6),
  PRIMARY KEY (orderId)
);

CREATE TABLE `OrderItem` (
  orderId INT NOT NULL,
  itemId INT NOT NULL,
  options VARCHAR(255),
  quantity INT NOT NULL,
  cost FLOAT(6),
  PRIMARY KEY(orderId, itemId, options)
);

CREATE TABLE `Item` (
  itemId INT NOT NULL,
  customizations VARCHAR(255),
  price FLOAT(6),
  PRIMARY KEY(itemId)
);

CREATE TABLE `Delivery` (
  orderId INT NOT NULL,
  deliveryId INT NOT NULL AUTO_INCREMENT,
  address VARCHAR(255),
  status VARCHAR(255),
  userNote VARCHAR(255),
  PRIMARY KEY(deliveryID)
);

CREATE TABLE `Pickup` (
  orderId INT NOT NULL,
  pickupId INT NOT NULL AUTO_INCREMENT,
  address VARCHAR(255),
  status VARCHAR(255),
  PRIMARY KEY(pickupId)
);

-- create some test records
-- WARNING: these will not show up if you are using Jpa com.dmalataeva.alarcha.repositories with Spring Boot!!! The Jpa repository is treated as a new instance
--INSERT INTO `Order`(userId, collectMethod, total) VALUES (1, "WHATEVER", 120.85);
--INSERT INTO `Order`(userId, collectMethod, total) VALUES (2, "NO PICKUP", 15667.1);



