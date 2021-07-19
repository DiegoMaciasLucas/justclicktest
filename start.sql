CREATE DATABASE justclickmacias;

CREATE TABLE url(
   id SERIAL PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   uri  VARCHAR(500) NOT NULL,
   attempt INT NOT NULL
);

INSERT INTO url(name,uri,attempt) VALUES ('google','https://www.google.com',5);
INSERT INTO url(name,uri,attempt) VALUES ('facebook','https://www.facebook.com',4);
INSERT INTO url(name,uri,attempt) VALUES ('justclick','https://www.justclick.media',6);
