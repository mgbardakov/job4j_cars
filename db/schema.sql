DROP TABLE IF EXISTS advertisement CASCADE;
DROP TABLE IF EXISTS car_body CASCADE;
DROP TABLE IF EXISTS car_brand CASCADE;
DROP TABLE IF EXISTS image CASCADE;

CREATE TABLE car_body (
    id serial PRIMARY KEY,
    name text
);

CREATE TABLE car_brand (
    id serial PRIMARY KEY,
    name text
);

CREATE TABLE image (
    id serial PRIMARY KEY,
    data bytea
);

CREATE TABLE advertisement (
    id serial PRIMARY KEY,
    description text,
    on_purchase boolean DEFAULT true,
    car_body_id int NOT NULL REFERENCES car_body(id),
    car_brand_id int NOT NULL REFERENCES car_brand(id),
    image_id int REFERENCES image(id)

);
