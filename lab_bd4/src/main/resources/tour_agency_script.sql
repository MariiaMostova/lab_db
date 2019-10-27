CREATE SCHEMA IF NOT EXISTS `mostova_lab1` DEFAULT CHARACTER SET utf8 ;
USE `mostova_lab1` ;

DROP TABLE IF EXISTS route_stop_point;
DROP TABLE IF EXISTS stop_point;
DROP TABLE IF EXISTS hotel_room;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS room_type;
DROP TABLE IF EXISTS tour_client;
DROP TABLE IF EXISTS tour;
DROP TABLE IF EXISTS route_guide;
DROP TABLE IF EXISTS guide;
DROP TABLE IF EXISTS route;
DROP TABLE IF EXISTS route_type;
DROP TABLE IF EXISTS client;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`country` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`city` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_city_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `mostova_lab1`.`country` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`client` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`guide` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`hotel` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `city_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotel_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `mostova_lab1`.`city` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`room_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `person` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`hotel_room` (
  `hotel_id` INT(11) NOT NULL,
  `room_type_id` INT(11) NOT NULL,
  PRIMARY KEY (`hotel_id`, `room_type_id`),
  INDEX `fk_hotel_room_type_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  INDEX `fk_hotel_room_type_room_type1_idx` (`room_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_room_type_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `mostova_lab1`.`hotel` (`id`),
  CONSTRAINT `fk_hotel_room_type_room_type1`
    FOREIGN KEY (`room_type_id`)
    REFERENCES `mostova_lab1`.`room_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`route_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`route` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  `route_type_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_route_route_type_idx` (`route_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_route_type`
    FOREIGN KEY (`route_type_id`)
    REFERENCES `mostova_lab1`.`route_type` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`route_guide` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `guide_id` INT(11) NOT NULL,
  `route_id` INT(11) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_route_guide_guide1_idx` (`guide_id` ASC) VISIBLE,
  INDEX `fk_route_guide_route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_guide_guide1`
    FOREIGN KEY (`guide_id`)
    REFERENCES `mostova_lab1`.`guide` (`id`),
  CONSTRAINT `fk_route_guide_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `mostova_lab1`.`route` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`stop_point` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  `city_id` INT(11) NOT NULL,
  `hotel_id` INT(11),
  PRIMARY KEY (`id`),
  INDEX `fk_stop_point_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_stop_point_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_stop_point_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `mostova_lab1`.`city` (`id`),
  CONSTRAINT `fk_stop_point_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `mostova_lab1`.`hotel` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`route_stop_point` (
  `route_id` INT(11) NOT NULL,
  `stop_point_id` INT(11) NOT NULL,
  PRIMARY KEY (`route_id`, `stop_point_id`),
  INDEX `fk_route_stop_point_stop_point1_idx` (`stop_point_id` ASC) VISIBLE,
  INDEX `fk_route_stop_point_route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_stop_point_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `mostova_lab1`.`route` (`id`),
  CONSTRAINT `fk_route_stop_point_stop_point1`
    FOREIGN KEY (`stop_point_id`)
    REFERENCES `mostova_lab1`.`stop_point` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `mostova_lab1`.`tour` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `route_id` INT(11) NOT NULL,
  `price` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tour_route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_tour_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `mostova_lab1`.`route` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mostova_lab1`.`tour_client` (
  `client_id` INT(11) NOT NULL,
  `tour_id` INT(11) NOT NULL,
  PRIMARY KEY (`client_id`, `tour_id`),
  INDEX `fk_tour_client_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_tour_client_tour1_idx` (`tour_id` ASC) VISIBLE,
  CONSTRAINT `fk_tour_client_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `mostova_lab1`.`client` (`id`),
  CONSTRAINT `fk_tour_client_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `mostova_lab1`.`tour` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO country(name) VALUES
('Ukraine'),
('Poland'),
('Germany'),
('USA'),
('UK'),
('Netherland'),
('Hungary'),
('Spain'),
('Turkey'),
('Egypt'),
('Sweden');

INSERT INTO city(name, country_id) VALUES
('Lviv', 1),
('Kyiv', 1),
('Krakiv', 2),
('Warsaw', 2),
('Berlin', 3),
('Washigthon', 4),
('London', 5),
('Amsterdam', 6),
('Budapest', 7),
('Barcelona', 8),
('Kemer', 9),
('Alanya', 9),
('Cairo', 10),
('Stockholm', 11);

INSERT INTO client(first_name, last_name, birthday) VALUES
('Victoriia', 'Mostova', '2000-07-04'),
('Volody', 'Mosto', '1975-08-01'),
('Anna', 'Clear', '1987-06-28'),
('Mary', 'Queen', '1972-06-05'),
('Taras', 'King', '1981-09-10'),
('Lily', 'Party', '1999-10-10'),
('Iryna', 'Kozak', '1988-07-02'),
('Iryna', 'Sweet', '1979-04-04'),
('Kate', 'Middle', '1987-09-08'),
('Andrew', 'Wind', '1966-11-11'),
('Danylo', 'Chill', '1977-08-18'),
('Vlad', 'Tiny', '1993-10-27');

INSERT INTO guide(first_name, last_name, birthday, sex) VALUES
('Mariia','Mostova','2001-08-27','f'),
('Oxana','Mostova','1975-03-08','f'),
('Ilona','Vovk','2001-08-08','f'),
('Oleh','Paduchak','2001-04-22','m'),
('Oleh','Kuzyk','2001-06-23','m'),
('Maxim','Marina','2001-02-14','m'),
('Diana','Vynnyk','2001-03-03','f'),
('Jack','Smith','1989-08-12','m'),
('Oliia','Queen','1967-06-14','f'),
('Ivan','House','1973-09-27','m');

INSERT INTO hotel(name, city_id) VALUES
('Senza', 12),
('Sultan', 11),
('Palace', 13),
('Royal', 1),
('Best', 3),
('Dreams', 5),
('Gold', 5),
('Adam', 2),
('Fomich', 7),
('Queen', 9);

INSERT INTO room_type(name, person) VALUES
('Standart', 2),
('Standart', 3),
('Family', 3),
('Family', 4),
('Lux', 2),
('Lux', 4),
('Business', 2),
('Presidant', 2),
('Villa', 6),
('Villa', 8);

INSERT INTO hotel_room(hotel_id, room_type_id) VALUES
( 1, 1),
( 1, 2),
( 1, 3),
( 1, 4),
( 2, 9),
( 2, 10),
( 3, 1),
( 3, 2),
( 3, 3),
( 3, 4),
( 4, 1),
( 4, 2),
( 5, 5),
( 5, 6),
( 5, 7),
( 5, 8),
( 6, 1),
( 6, 4),
( 7, 1),
( 7, 3),
( 7, 5),
( 7, 7),
( 8, 1),
( 8, 2),
( 8, 3),
( 9, 3),
( 9, 4),
( 10, 5),
( 10, 6),
( 10, 7);

INSERT INTO route_type(name) VALUES
('cruise'),
('pedestian'),
('bus'),
('hotel');

INSERT INTO route(description, route_type_id) VALUES
('Fantastic tour that help you relax at the ship!', 1),
('Visiting attractions of the city is the best!', 2),
('It is the best way to visit many cities', 3),
('Sea, beach, pools and our hotel make your holidays unforgettable', 4),
('Our cruise is your best holiday', 1),
('Choose this tour and will be happy pedestrian tourist', 2),
('This tour is your dream', 3),
('Our hotel offers you to relax all holidays', 4),
('It will be the best your cruise', 1),
('You will enjoy architecture of cities the best ', 3);

INSERT INTO route_guide(guide_id, route_id, start_date, end_date) VALUES
( 1, 1,'2019-09-08', '2019-09-27'),
( 1, 2,'2019-04-06', '2019-05-06'),
( 2, 1,'2019-04-13', '2019-06-17'),
( 3, 1,'2019-07-07', '2019-08-28'),
( 4, 1,'2019-08-27', '2019-09-30'),
( 4, 5,'2019-06-08', '2019-07-28'),
( 4, 6,'2019-09-15', '2019-10-20'),
( 4, 9,'2019-10-01', '2019-11-04'),
( 5, 3,'2019-09-09', '2019-10-09'),
( 5, 4,'2019-08-01', '2019-09-09'),
( 5, 5,'2019-07-01', '2019-09-02'),
( 6, 7,'2019-09-02', '2019-09-06'),
( 6, 8,'2019-06-06', '2019-09-13'),
( 6, 9,'2019-07-01', '2019-08-24'),
( 6, 10,'2019-03-03', '2019-05-07'),
( 7, 10,'2019-02-28', '2019-04-09'),
( 7, 1,'2019-07-05', '2019-08-27'),
( 8, 2,'2019-03-04', '2019-05-08'),
( 8, 5,'2019-07-09', '2019-08-09'),
( 8, 7,'2019-10-10', '2019-11-27'),
( 9, 9,'2019-06-09', '2019-08-05'),
( 9, 6,'2019-11-11', '2019-11-28'),
( 10, 3,'2019-06-06', '2019-07-22'),
( 10, 8,'2019-07-22', '2019-06-09'),
( 10, 1,'2019-05-05', '2019-07-07');

INSERT INTO stop_point(description, city_id, hotel_id) VALUES
('Culture capital of Ukraine', 1, 4),
('Amazing historical and modern city', 2, 8),
('Expensive but it is worth to visit', 14, null),
('Sunny beaches, resort, SPA', 11, 2),
('One of the most interesting capital of Europe', 4, null),
('This is home for the best football players', 10, null),
('Exotic resort capital', 13, 3),
('The best city for pedestrian tourist', 3, 5),
('The opportunity to visit Capitol', 6, null),
('Rainy city and red busses', 7, 9),
('Unforgettable sunny resort', 12, 1);

INSERT INTO route_stop_point( route_id, stop_point_id) VALUES
( 3, 1),
( 10, 1),
( 7, 2),
( 3, 3),
( 1, 4),
( 7, 4),
( 9, 4),
( 10, 4),
( 3, 5),
( 7, 5),
( 1, 6),
( 5, 6),
( 9, 6),
( 1, 7),
( 2, 7),
( 5, 7),
( 8, 7),
( 3, 8),
( 6, 9),
( 7, 9),
( 10, 9),
( 10, 10),
( 3, 11),
( 4, 11),
( 5, 11),
( 9, 11);

INSERT INTO tour(start_date, end_date, route_id, price) VALUES
('2020-08-07','2020-08-14', 1, 13800),
('2020-07-05','2020-07-12', 1, 13500),
('2020-09-02','2020-09-12', 1, 12000),
('2020-09-12','2020-08-13', 2, 7800),
('2020-08-04','2020-08-12', 2, 7600),
('2019-10-02','2019-10-14', 3, 12300),
('2020-08-04','2020-08-14', 4, 17500),
('2020-06-03','2020-06-14', 5, 15800),
('2020-09-07','2020-09-18', 5, 12900),
('2019-09-21','2019-09-30', 5, 11000),
('2020-02-02','2020-02-15', 6, 7800),
('2020-07-09','2020-07-17', 7, 8200),
('2020-07-14','2020-07-22', 7, 8100),
('2020-06-01','2020-06-21', 8, 14000),
('2020-06-11','2020-06-30', 8, 14900),
('2020-07-06','2020-07-13', 9, 17700),
('2020-08-04','2020-08-14', 9, 18300),
('2019-10-05','2019-10-17', 10, 10300);

INSERT INTO tour_client(client_id, tour_id) VALUES
(1, 2),
(1, 18),
(2, 5),
(3, 7),
(4, 9),
(5, 14),
(6, 13),
(7, 3),
(7, 10),
(8, 1),
(9, 8),
(9, 10),
(9, 16),
(10, 8);

CREATE INDEX client_name ON client(first_name, last_name);
CREATE INDEX country_name ON country(name);
