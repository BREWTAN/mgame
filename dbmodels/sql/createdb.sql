CREATE DATABASE `tfg`;
CREATE USER tfw@'localhost' IDENTIFIED BY 'tfw001';
CREATE USER tfw@'%' IDENTIFIED BY 'tfw001';
GRANT ALL PRIVILEGES ON tfg.* TO tfw;

flush privileges;
