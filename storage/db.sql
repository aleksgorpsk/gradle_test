CREATE TABLE "books" (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    subtitle VARCHAR(500),
    author VARCHAR(255),
    publisher VARCHAR(255),
    published INTEGER,
    pages INTEGER,
    description TEXT,
    website VARCHAR(500)
);