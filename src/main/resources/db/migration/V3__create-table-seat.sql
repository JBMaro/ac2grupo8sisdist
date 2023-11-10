CREATE TABLE seat (
                      seatID BIGINT PRIMARY KEY UNIQUE NOT NULL,
                      num INTEGER NOT NULL,
                      flightID BIGINT REFERENCES flight(flightID) NOT NULL,
                      clientID BIGINT REFERENCES client(clientID)
);