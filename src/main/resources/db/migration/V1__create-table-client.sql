CREATE TABLE client (
                        clientID BIGINT PRIMARY KEY UNIQUE NOT NULL,
                        name TEXT NOT NULL,
                        lastname TEXT NOT NULL,
                        CPF TEXT NOT NULL,
                        login TEXT NOT NULL,
                        password TEXT NOT NULL
);