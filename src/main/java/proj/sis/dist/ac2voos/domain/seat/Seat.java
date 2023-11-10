package proj.sis.dist.ac2voos.domain.seat;


import lombok.*;
import proj.sis.dist.ac2voos.domain.flight.RequestFlight;

import javax.persistence.*;

@Table(name="seat")
@Entity(name="seat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "seatID")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seatID;
    private Integer num;
    private Long flightID;
    private Long clientID;

    public Seat(RequestSeat requestSeat){
        this.seatID = requestSeat.seatID();
        this.num = requestSeat.num();
        this.flightID = requestSeat.flightID();
        this.clientID = requestSeat.clientID();
    }
}
