CREATE TABLE `Orders` (
  orderId INT NOT NULL AUTO_INCREMENT,
  userId INT,
  datePlaced TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  collectMethod VARCHAR(255) NOT NULL,
  total FLOAT(6),
  PRIMARY KEY (orderId)
);

CREATE TABLE `OrderItems` (
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



