CREATE TABLE car
(
    id        serial primary key,
    model     TEXT NOT NULL,
    color     TEXT NOT NULL,
    engine_id INT  NOT NULL REFERENCES engine (id)
);
CREATE TABLE engine
(
    id       serial primary key,
    power    INT NOT NULL,
    capacity FLOAT NOT NULL,
    type     TEXT
);
CREATE TABLE owner
(
    id    serial primary key,
    name  TEXT NOT NULL,
    phone TEXT NOT NULL UNIQUE
);
CREATE TABLE car_owner
(
    id       serial primary key,
    car_id   INT NOT NULL REFERENCES car (id),
    owner_id INT NOT NULL REFERENCES owner (id)

);