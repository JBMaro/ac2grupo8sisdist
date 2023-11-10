CREATE TABLE flight (
                        flightID BIGINT PRIMARY KEY UNIQUE NOT NULL,
                        numOfSeats INT NOT NULL,
                        cidadePartida TEXT NOT NULL,
                        cidadeChegada TEXT NOT NULL,
                        horarioPartida TIME NOT NULL,
                        horarioChegada TIME NOT NULL,
                        dataPartida DATE NOT NULL,
                        dataChegada DATE NOT NULL
);