DROP TABLE IF EXISTS portfolio;
DROP SEQUENCE IF EXISTS portfolio_seq;

CREATE SEQUENCE portfolio_seq START 100000;

CREATE TABLE portfolio
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('portfolio_seq'),
    name             VARCHAR                 NOT NULL,
    created          TIMESTAMP DEFAULT now() NOT NULL
);

CREATE UNIQUE INDEX users_name_idx ON portfolio (name);