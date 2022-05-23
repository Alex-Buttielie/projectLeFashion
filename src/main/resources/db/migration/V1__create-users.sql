CREATE SEQUENCE TB_USER_ID_SEQ;
CREATE SEQUENCE TB_STOCK_ID_SEQ;
CREATE SEQUENCE TB_SALE_ID_SEQ;
CREATE SEQUENCE TB_PRODUCT_ID_SEQ;
CREATE SEQUENCE TB_PAYMENT_ID_SEQ;
CREATE SEQUENCE TB_ITEMS_SOLD_ID_SEQ;
CREATE SEQUENCE TB_BRAND_ID_SEQ;

CREATE TABLE IF  NOT EXISTS TB_USER
(
    ID_USER     	INTEGER  PRIMARY KEY DEFAULT nextval('TB_USER_ID_SEQ'),
    DS_LOGIN    	VARCHAR(300) UNIQUE NOT NULL,
    NAME_USER   	VARCHAR(300) NOT NULL,
    CPF         	VARCHAR (11) UNIQUE  NOT NULL,
    PASSWORD_USER   VARCHAR(300)  NOT NULL,
    RG          	VARCHAR(9)  UNIQUE  NOT NULL,
    BIRTH_DATE  	DATE ,
    EMAIL       	VARCHAR (300),
    TELEPHONE   	VARCHAR (15),
    TELEPHONE2  	VARCHAR (15),
    CADASTRE_DATE   DATE,
    SEX 			INT,
    USER_TYPE 		INT
);

CREATE TABLE IF  NOT EXISTS TB_STOCK
(
    ID_STOCK     	INTEGER  PRIMARY KEY DEFAULT nextval('TB_STOCK_ID_SEQ'),
    STOCK_START_DATE DATE,
    STOCK_END_DATE DATE,
    QUANTITY_PARTYS_STOCK INTEGER ,
    REFERECE_MONTH INTEGER
);

CREATE TABLE IF  NOT EXISTS TB_SALE
(
    ID_SALE   INTEGER  PRIMARY KEY DEFAULT nextval('TB_SALE_ID_SEQ'),
    SALE_DATE DATE,
    SALE_TIME TIME,
    VALUE_SALE INTEGER ,
    FK_ID_USER INTEGER,
    CONSTRAINT FK_ID_USER FOREIGN KEY (FK_ID_USER)
        REFERENCES TB_USER (ID_USER)
);
CREATE TABLE IF  NOT EXISTS TB_BRAND
(
    ID_BRAND INTEGER  PRIMARY KEY DEFAULT nextval('TB_BRAND_ID_SEQ'),
    DESCRIPTIONS VARCHAR (300)
);
CREATE TABLE IF  NOT EXISTS TB_PRODUCT
(
    ID_PRODUCT   INTEGER  PRIMARY KEY DEFAULT nextval('TB_PRODUCT_ID_SEQ'),
    IDENTIFICATION_PRODUCT_CODE INTEGER,
    PRODUCT_NAME VARCHAR (300),
    CADASTRE_DATE DATE,
    MODEL INTEGER,
    SIZE INTEGER,
    IS_ACCEPTS_DISCOUNT BOOLEAN,
    IS_ACCEPTS_EXCHANGE BOOLEAN,
    PRICE_COST INTEGER,
    FK_ID_BRAND INTEGER,
    FK_ID_STOCK INTEGER,
    CONSTRAINT FK_ID_BRAND FOREIGN KEY (FK_ID_BRAND)
        REFERENCES TB_BRAND (ID_BRAND),
    CONSTRAINT FK_ID_STOCK FOREIGN KEY (FK_ID_STOCK)
        REFERENCES TB_STOCK (ID_STOCK)
);

CREATE TABLE IF  NOT EXISTS TB_PAYMENT
(
    ID_PAYMENT   INTEGER  PRIMARY KEY DEFAULT nextval('TB_PAYMENT_ID_SEQ'),
    TYPE_PAYMENT INTEGER,
    VALUE_CHANGE INTEGER,
    VALUE_ENTRY INTEGER,
    FK_ID_SALE INTEGER,
    CONSTRAINT FK_ID_SALE FOREIGN KEY (FK_ID_SALE)
        REFERENCES TB_SALE (ID_SALE)
);

CREATE TABLE IF  NOT EXISTS TB_ITEMS_SOLD
(
    ID_ITEMS_SOLD INTEGER  PRIMARY KEY DEFAULT nextval('TB_ITEMS_SOLD_ID_SEQ'),
    FK_ID_PRODUCT INTEGER,
    FK_ID_SALE INTEGER,
    CONSTRAINT FK_ID_PRODUCT FOREIGN KEY (FK_ID_PRODUCT)
        REFERENCES TB_PRODUCT (ID_PRODUCT),
    CONSTRAINT FK_ID_SALE FOREIGN KEY (FK_ID_SALE)
        REFERENCES TB_SALE (ID_SALE)
);

ALTER SEQUENCE TB_USER_ID_SEQ
    OWNED BY TB_USER.ID_USER;

ALTER SEQUENCE TB_STOCK_ID_SEQ
    OWNED BY TB_STOCK.ID_STOCK;

ALTER SEQUENCE TB_SALE_ID_SEQ
    OWNED BY TB_SALE.ID_SALE;

ALTER SEQUENCE TB_PRODUCT_ID_SEQ
    OWNED BY TB_PRODUCT.ID_PRODUCT;

ALTER SEQUENCE TB_PAYMENT_ID_SEQ
    OWNED BY TB_PAYMENT.ID_PAYMENT;

ALTER SEQUENCE TB_ITEMS_SOLD_ID_SEQ
    OWNED BY TB_ITEMS_SOLD.ID_ITEMS_SOLD;

ALTER SEQUENCE TB_BRAND_ID_SEQ
    OWNED BY TB_BRAND.ID_BRAND;

insert into TB_USER (ds_login,
                     name_user,
                     cpf,
                     password_user,
                     rg,
                     email,
                     birth_date,
                     telephone,
                     cadastre_date,
                     sex,
                     user_type)
values ('Alex.Buttielie','Alex Buttielie','70846792192','Alex@99592706','6796000','buttielle3@gmail.com', '2001-03-16','62994291748',now(),1, 1);

insert into tb_brand (descriptions)
values ('calvin klein');

insert into tb_stock (stock_start_date,
                      stock_end_date,
                      quantity_partys_stock,
                      referece_month)
values (now(),'2022-05-31', 20, 5);


insert into tb_product (identification_product_code,
                        product_name,
                        cadastre_date,
                        model,
                        size,
                        is_accepts_discount,
                        is_accepts_exchange,
                        price_cost,
                        fk_id_brand,
                        fk_id_stock)
values(123, 'calça', now(), 3, 1, false, false, 20.00,1, 1);

insert into tb_sale (sale_date, sale_time, value_sale, fk_id_user)
values (now(), now(), 20.00, 1 );

insert into tb_items_sold (fk_id_product, fk_id_sale) values (1, 1);

insert into tb_payment  (type_payment, value_change, value_entry, fk_id_sale) values (1, 5.00, 25.00, 1);


