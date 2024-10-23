DROP TABLE IF EXISTS USER_EMPLOYEES;
DROP TABLE IF EXISTS WALLET_TBL;
DROP TABLE IF EXISTS USER_EMPLOYEES;
DROP TABLE IF EXISTS USER_EMPLOYEES;

create TABLE USER_EMPLOYEES(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(50) NOT NULL,
email VARCHAR(100) DEFAULT NULL
);

CREATE TABLE WALLET_TBL(

id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_id BIGINT,
usdt_balance DOUBLE DEFAULT 50000.0,
btc_value DOUBLE DEFAULT 0.0,
eth_value DOUBLE DEFAULT 0.0,
CONSTRAINT user_fk FOREIGN KEY(user_id) REFERENCES USER_EMPLOYEES(id)

);

CREATE TABLE TRANSACTION_TBL (

id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_id BIGINT,
crypto_type VARCHAR(20) NOT NULL,
transaction_type VARCHAR(5) NOT NULL,
amount DOUBLE NOT NULL,
price DOUBLE NOT NULL,
timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT trans_fk FOREIGN KEY(user_id) REFERENCES USER_EMPLOYEES(id)
);

CREATE TABLE PRICE_TBL(

id BIGINT AUTO_INCREMENT PRIMARY KEY,
crypto_type VARCHAR(10) NOT NULL,
bid_price DOUBLE NOT NULL,
ask_price DOUBLE NOT NULL,
timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);