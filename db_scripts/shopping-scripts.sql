CREATE TABLE item (
	itemId INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	itemName VARCHAR(30) NOT NULL,
	catergory VARCHAR(30) NOT NULL,
	price float,
	createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ;

INSERT INTO `data-line-pipe`.`item` (`itemName`, `catergory`, `price`)
 VALUES ('Book', 'Friction', '5.5');

CREATE TABLE customer (
	customerId INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	customerName VARCHAR(30) NOT NULL,
	createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE shopping (
	shoppingId INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	shoppingDate TIMESTAMP,
    transitId int(10),
    customerId INT(10) unsigned,
    itemId INT(10) unsigned,
	createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_itemId FOREIGN KEY (itemId)
    REFERENCES item(itemId),
    CONSTRAINT FK_customerId FOREIGN KEY (customerId)
    REFERENCES customer(customerId)
);
