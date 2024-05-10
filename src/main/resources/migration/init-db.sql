CREATE TABLE Station(
	id_station     SERIAL ,
	station_name   VARCHAR (255) NOT NULL ,
	location       VARCHAR (255) NOT NULL ,
	reference      VARCHAR (255) NOT NULL  ,
	CONSTRAINT Station_PK PRIMARY KEY (id_station)
);

CREATE TABLE Product(
	id_product     SERIAL ,
	product_name   VARCHAR (255) NOT NULL  ,
	CONSTRAINT Product_PK PRIMARY KEY (id_product)
);

CREATE TYPE EVAPORATION_PERIOD AS ENUM ('PER_DAY', 'PER_HOUR');

CREATE TABLE Evaporation(
	id_evaporation   SERIAL ,
	rate             INT  NOT NULL ,
	period           EVAPORATION_PERIOD NOT NULL ,
	change_date      DATE  DEFAULT CURRENT_DATE ,
	id_product       INT  NOT NULL  ,
	CONSTRAINT Evaporation_PK PRIMARY KEY (id_evaporation),
	CONSTRAINT Evaporation_Product_FK FOREIGN KEY (id_product) REFERENCES Product(id_product)
);

CREATE TABLE Price(
	id_price     SERIAL ,
	unit_price   DOUBLE PRECISION  NOT NULL ,
	app_date     DATE  DEFAULT CURRENT_DATE ,
	id_product   INT  NOT NULL  ,
	CONSTRAINT Price_PK PRIMARY KEY (id_price),
	CONSTRAINT Price_Product_FK FOREIGN KEY (id_product) REFERENCES Product(id_product)
);

CREATE TYPE OPERATION_TYPE AS ENUM ('IN', 'OUT');

CREATE TABLE Make_Operation(
	id_make_operation            SERIAL PRIMARY KEY,
	id_station           INT  NOT NULL ,
	id_product   INT  NOT NULL ,
	quantity             DOUBLE PRECISION   ,
	operation_type       OPERATION_TYPE NOT NULL ,
	operation_datetime   TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ,
	CONSTRAINT Make_Operation_Product_FK FOREIGN KEY (id_product) REFERENCES Product(id_product),
	CONSTRAINT Make_Operation_Station_FK FOREIGN KEY (id_station) REFERENCES Station(id_station)
);