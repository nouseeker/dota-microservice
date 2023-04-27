-- liquibase formatted sql

--changeset n7meless:1
CREATE TABLE IF NOT EXISTS heroes
(
    id
               BIGSERIAL
        PRIMARY
            KEY,
    name
               VARCHAR(150) NOT NULL UNIQUE,
    win_rate   float,
    roles      VARCHAR(255),
    image_path VARCHAR(255) NOT NULL
)
--rollback DROP TABLE heroes;