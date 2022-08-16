DROP TABLE IF EXISTS portfolio;
DROP SEQUENCE IF EXISTS portfolio_seq;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_seq;

CREATE SEQUENCE portfolio_seq START 100000;
CREATE SEQUENCE users_seq START 100000;

CREATE TABLE users
(
    id               BIGINT PRIMARY KEY DEFAULT nextval('users_seq'),
    name             VARCHAR                 NOT NULL,
    email            VARCHAR                 NOT NULL,
    password         VARCHAR                 NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL,
    enabled          BOOL DEFAULT TRUE       NOT NULL
);

CREATE TABLE portfolio
(
    id               BIGINT PRIMARY KEY DEFAULT nextval('portfolio_seq'),
    name             VARCHAR                 NOT NULL,
    created          TIMESTAMP DEFAULT now() NOT NULL,
    user_id          BIGINT                  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX portfolio_name_idx ON portfolio (user_id, name);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);