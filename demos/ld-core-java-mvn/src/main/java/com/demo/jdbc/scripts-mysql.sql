
use testdb;
show tables;
CREATE TABLE user (
  user_id int NOT NULL,
  email varchar(255) NOT NULL, 
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
) ;
select * from user;
select * from user where user_id = 1 and `FIRST_NAME` = 'John';
delete from user;

INSERT INTO user (user_id, email, first_name, last_name) VALUES
(1, 'user1@example.com', 'John', 'Doe'),
(2, 'user2@example.com', 'Jane', 'Doe'),
(3, 'user3@example.com', 'Jim', 'Beam'),
(4, 'user4@example.com', 'Jack', 'Daniels'),
(5, 'user5@example.com', 'Jill', 'Valentine');

use sakila;
-- As a user I would like to display the movie title, language and category in the below format.
-- FILM.TITLE
-- LANGUAGE.NAME
-- CATEGORY.NAME
-- FILM_CATEGORY

SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'
FROM FILM
JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id
JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID
JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id;
# WHERE CATEGORY.name = 'ACTION';



---------------- EXPLORE -------------------
DELIMITER $$
CREATE PROCEDURE GET_MOVIE_DETAILS1()
BEGIN
    SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'
    FROM FILM
             JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id
             JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID
             JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id;
             JOIN 
END;

-- As a user I would like to display the movie title, language and category in the below format.
-- FILM.TITLE
-- LANGUAGE.NAME
-- CATEGORY.NAME
-- FILM_CATEGORY

SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'
FROM FILM
JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id
JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID
JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id;
# WHERE CATEGORY.name = 'ACTION';

DELIMITER $$
CREATE PROCEDURE GET_MOVIE_DETAILS1()
BEGIN
    SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'
    FROM FILM
             JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id
             JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID
             JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id;
END;
$$
DELIMITER ;


CALL GET_MOVIE_DETAILS1;

----------------- EPLORATORY LEARNING -----------
drop procedure GET_MOVIE_DETAILS2;
CREATE PROCEDURE GET_MOVIE_DETAILS2(CATEGORY_NAME_IN CHAR(50))
BEGIN
    SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'
    FROM FILM
             JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id
             JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID
             JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id
    WHERE CATEGORY.name = CATEGORY_NAME_IN;
END;

CALL GET_MOVIE_DETAILS1;
CALL GET_MOVIE_DETAILS2('Comedy');

DROP PROCEDURE GET_MOVIE_DETAILS3;

DELIMITER $$
CREATE PROCEDURE GET_MOVIE_DETAILS3(TITLE_IN CHAR(50), CATEGORY_NAME_IN CHAR(50))
BEGIN
#   USE IF ELSE
    select f.title as TITLE, l.name AS LANGUAGE, c.name AS CATEGORY
    from film f inner join film_category fc on f.film_id=fc.film_id
                inner join category c on fc.category_id=c.category_id
                inner join language l on f.language_id=l.language_id
    where f.title like  CONCAT(TITLE_IN,'%') and c.name = category_name_in;
END;
$$
DELIMITER ;

CALL GET_MOVIE_DETAILS3('A','ACTION');
CALL GET_MOVIE_DETAILS3('A','COMEDY');
CALL GET_MOVIE_DETAILS3('','COMEDY');
CALL GET_MOVIE_DETAILS3('A','');