
/**
 * Author:  bikathi_martin
 * Created: Dec 30, 2022
 */

-- create schema
DROP SCHEMA IF EXISTS `little_schema`;
CREATE SCHEMA `little_schema`;
USE `little_schema`;

-- create table for project
DROP TABLE IF EXISTS `link_pair`;
CREATE TABLE `link_pair`(
--  fields in the table 
    id bigint NOT NULL AUTO_INCREMENT,
    original_url varchar(256) NOT NULL,
    short_url varchar(32) NOT NULL,
    link_id varchar(16) NOT NULL,

--  table constraints
    CONSTRAINT PRIMARY KEY(`id`)
);

--  set auto_incrememnt
ALTER TABLE `link_pair` AUTO_INCREMENT=1;

