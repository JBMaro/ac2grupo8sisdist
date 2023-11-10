package proj.sis.dist.ac2voos.domain.flight;
import lombok.*;
import proj.sis.dist.ac2voos.domain.client.RequestClient;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Table(name="flight")
@Entity(name="flight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "flightID")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightID;

    private Integer numOfSeats;
    private String cidadePartida;
    private String cidadeChegada;
    private Time horarioPartida;
    private Time horarioChegada;
    private Date dataPartida;
    private Date dataChegada;

    public Flight(RequestFlight requestFlight){
        this.flightID = requestFlight.flightID();
        this.numOfSeats = requestFlight.numOfSeats();
        this.cidadePartida = requestFlight.cidadePartida();
        this.cidadeChegada = requestFlight.cidadeChegada();
        this.horarioPartida = requestFlight.horarioPartida();
        this.horarioChegada = requestFlight.horarioChegada();
        this.dataPartida = requestFlight.dataPartida();
        this.dataChegada = requestFlight.dataChegada();
    }
}