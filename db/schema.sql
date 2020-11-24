CREATE TABLE cars
(
    id           serial primary key,
    model        TEXT NOT NULL,
    created      DATE NOT NULL,
    price        INT  NOT NULL,
    year         INT  NOT NULL,
    color        TEXT NOT NULL,
    mileage      INT  NOT NULL,
    body         TEXT NOT NULL,
    transmission TEXT NOT NULL,
    gear         TEXT NOT NULL,
    engines_id   INT  NOT NULL REFERENCES engines (id),
    user_id      int  NOT NULL REFERENCES users (id)
);
CREATE TABLE engines
(
    id       serial primary key,
    power    INT   NOT NULL,
    capacity FLOAT NOT NULL,
    type     TEXT
);
CREATE TABLE users
(
    id          serial primary key,
    login       TEXT NOT NULL UNIQUE,
    password    TEXT NOT NULL,
    phoneNumber TEXT NOT NULL UNIQUE
);