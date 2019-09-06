create database library_db;
create user cursor with encrypted password 'secret_password';
grant all privileges on database library_db to cursor;
ALTER USER cursor WITH SUPERUSER;


CREATE TABLE authors (
  id integer,
  firstName varchar(255),
  lastName varchar(255),
  country varchar(255),
  age integer,
  PRIMARY KEY (id)
  );

CREATE TABLE  books(
  id integer,
  title varchar(255),
  genre varchar(255),
  description varchar(255),
  rate NUMERIC,
  authorId integer,
  PRIMARY KEY (id),
  FOREIGN KEY (authorId) REFERENCES authors(id) ON DELETE CASCADE
  );
  
  INSERT INTO authors(id, firstName, lastName, country, age)
  VALUES('1', 'Boris', 'Akynin','Georgia', '63');
  
  INSERT INTO authors(id, firstName, lastName, country, age)
  VALUES('2', 'Haruki ', 'Murakami','Japan', '70');
  
  INSERT INTO authors(id, firstName, lastName, country, age)
  VALUES('3', 'Joanne ', 'Rowling','Scotland', '54');
  
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('1', 'Azazel', 'Detective', 'about the adventures of Erast Fandorin', '9.9', '1');
  
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('2', 'Turkish gambit', 'Detective', 'about the adventures of Erast Fandorin', '9.8', '1');
  
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('3', 'State Councillor', 'Detective', 'about the adventures of Erast Fandorin', '9.7', '1');
  
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('4', '1Q84', 'Alternate history', 'year of 1984 in parallel with a "real" one', '9.6', '2');
    
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('5', 'Kafka On the Shore', 'Fantasy', 'story abouy Kafka', '9.5', '2');
      
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('6', 'The Philosophers Stone', 'Fantasy', 'story abouy Harry Potter', '9.9', '3');
        
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('7', 'The Chamber of Secrets', 'Fantasy', 'story abouy Harry Potter', '9.4', '3');
          
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('8', 'The Goblet of Fire', 'Fantasy', 'story abouy Harry Potter', '9.0', '3');
  
  INSERT INTO books(id, title, genre, description, rate, authorId)
  VALUES('9', 'The Prisoner of Azkaban', 'Fantasy', 'story abouy Harry Potter', '9.8', '3');
  
  SELECT authors.firstName, authors.lastName, books.title, books.genre, books.description, books.rate
  FROM authors
  INNER JOIN books ON authors.id = books.authorId;
  
  SELECT * FROM books
  ORDER BY genre;
  
  SELECT * FROM books
  ORDER BY rate DESC;
  
  SELECT * FROM authors
  ORDER BY rate DESC;
  
  SELECT authors.firstName, authors.lastName, authors.age
  FROM authors
  ORDER BY age DESC;
  
  SELECT authors.firstName, authors.lastName, books.title
  FROM authors
  INNER JOIN books ON authors.id = books.authorId;

  SELECT authors.id, authors.firstName, authors.lastName,  COUNT(books.authorId) AS count_books FROM authors
  INNER JOIN books ON authors.id=books.authorId
  GROUP BY authors.id
  ORDER BY count_books DESC
  LIMIT 1;
