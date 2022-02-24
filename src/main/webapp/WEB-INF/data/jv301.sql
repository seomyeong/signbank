CREATE TABLE Customer(
	id 			BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name 		VARCHAR(30) NOT NULL,
	ssn 		VARCHAR(14)	NOT NULL,
	userId		VARCHAR(13) NOT NULL,
	userPw		VARCHAR(13)	NOT NULL,
	regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM Customer;
DROP TABLE Customer;


CREATE TABLE Account(
	id				BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	customerid		BIGINT NOT NULL,
	accType			CHAR(1) NOT NULL DEFAULT 'S',
	balance			DOUBLE NOT NULL DEFAULT 0.0,
	interestRate	DOUBLE NOT NULL DEFAULT 0.0,
	overAmount 		DOUBLE NOT NULL DEFAULT 0.0,
	accountNum		VARCHAR(9) NOT NULL,
	regDate			TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Account_customerId_FK FOREIGN KEY(customerid) REFERENCES Customer(id)
);
SELECT * FROM Account;
DROP TABLE Account;

ALTER TABLE Account DROP CONSTRAINT Account_customerId_FK;
DELETE FROM CUSTOMER WHERE id=101;
DELETE FROM ACCOUNT WHERE customerid=101;
ALTER TABLE Account ADD CONSTRAINT Account_customerId_FK FOREIGN KEY(customerid) REFERENCES Customer(id);


DELETE FROM ACCOUNT WHERE customerid=102;
DELETE FROM CUSTOMER WHERE id=102;