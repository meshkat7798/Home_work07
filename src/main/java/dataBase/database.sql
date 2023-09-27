CREATE TABLE IF NOT EXISTS Shareholder
(
    shareholderId   SERIAL PRIMARY KEY,
    shareholderName VARCHAR(50),
    phoneNumber     VARCHAR(50),
    nationalityCode VARCHAR(50) unique not null
    )
;


CREATE TABLE IF NOT EXISTS brand
(
    brandId          SERIAL PRIMARY KEY,
    brandName        VARCHAR(50) unique not null,
    brandWebsite     VARCHAR,
    brandDescription VARCHAR(255)
    )
;

CREATE TABLE IF NOT EXISTS shareholder_brand
(
    shareholderId INTEGER REFERENCES Shareholder (shareholderId),
    brandId       INTEGER REFERENCES brand (brandId)
    )
;


CREATE TABLE IF NOT EXISTS category
(
    categoryId          SERIAL PRIMARY KEY,
    categoryName        VARCHAR(50) unique not null,
    categoryDescription VARCHAR(255)

    )
;


CREATE TABLE IF NOT EXISTS product
(
    productId   serial primary key,
    productName VARCHAR(50),
    createDate  VARCHAR(50),
    category    int REFERENCES category (categoryId),
    brand       int REFERENCES brand (brandId)
    )
;

CREATE TABLE IF NOT EXISTS users
(
    userId   serial PRIMARY KEY,
    name     VARCHAR(50),
    userName VARCHAR(50) unique not null,
    password VARCHAR(50),
    email    VARCHAR(50) unique not null
    )
;