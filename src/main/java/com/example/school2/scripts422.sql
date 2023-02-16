CREATE TABLE human (
    name varchar(200) NOT NULL PRIMARY KEY,
    age INTEGER NOT NULL,
    driver_license BOOLEAN DEFAULT (1)
);
CREATE TABLE car (
    brand varchar(200) NOT NULL,
    model varchar(200) NOT NULL,
    prise INTEGER,
    auto_id NUMERIC REFERENCES human(name)
);
