CREATE DATABASE 'Mobilestore';
USE Mobilestore;

CREATE TABLE `mobile` (
                          'mobile_id' int(11) NOT NULL AUTO_INCREMENT,
                          'refrence' varchar(128) NOT NULL,
                          'brand' varchar(45) NOT NULL,
                          'price' float NOT NULL,
                          PRIMARY KEY ('mobile_id'),
                          UNIQUE KEY 'mobile_id_UNIQUE' ('mobile_id'),
                          UNIQUE KEY 'refrence_UNIQUE' ('refrence')
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1
