CREATE TABLE IF NOT EXISTS hibernate_sequence (
    next_val       BIGSERIAL
);

INSERT INTO hibernate_sequence (next_val)
SELECT 1
WHERE NOT EXISTS (SELECT * FROM hibernate_sequence);

CREATE TABLE IF NOT EXISTS address (
    id             BIGSERIAL NOT NULL PRIMARY KEY,
    country        varchar(255),
    country_code   varchar(255),
    county         varchar(255),
    postcode       varchar(255),
    state          varchar(255),
    state_district varchar(255)
);

CREATE TABLE IF NOT EXISTS users (
    id             BIGSERIAL NOT NULL PRIMARY KEY,
    email          varchar(255) NOT NULL ,
    email_verified boolean,
    image_url      varchar(255),
    name           varchar(255),
    password       varchar(255),
    provider       varchar(255),
    provider_id    varchar(255)
);

CREATE TABLE IF NOT EXISTS property (
    id                   BIGSERIAL NOT NULL primary key,
    has_central_heating  boolean,
    has_cleaning_machine boolean,
    has_cooling          boolean,
    has_concierge        boolean,
    has_elevator         boolean,
    has_fire_place       boolean,
    has_garden           boolean,
    has_internet         boolean,
    has_microwave        boolean,
    has_modern_kitchen   boolean,
    has_mountain_view    boolean,
    has_oven             boolean,
    has_refrigerator     boolean,
    has_satellite_dish   boolean,
    has_sea_view         boolean,
    has_security         boolean,
    has_swimming_pool    boolean,
    hastv                boolean,
    has_terrace          boolean,
    latitude             double precision,
    longitude            double precision,
    form_type            int,
    property_type        int,
    nb_bathrooms         int,
    nb_bedrooms          int,
    nb_floors            int,
    price                int,
    age                  int,
    area                 int,
    available_date       timestamp,
    address_id           int,
    CONSTRAINT fk_address
    FOREIGN KEY (address_id)
    REFERENCES address (id),
    user_id              bigint,
    CONSTRAINT fk_users
    FOREIGN KEY (user_id)
    REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS cproperty_images (
    cproperty_id int,
    constraint fk_property
    FOREIGN KEY (cproperty_id)
    REFERENCES property (id),
    images      varchar(255)
);
