package proj.sis.dist.ac2voos.domain.flight;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Time;

public record RequestFlight(
        Long flightID,

        @NotBlank
        Integer numOfSeats,
        @NotBlank
        String cidadePartida,
        @NotBlank
        String cidadeChegada,
        @NotBlank
        Time horarioPartida,
        @NotBlank
        Time horarioChegada,
        @NotBlank
        Date dataPartida,
        @NotBlank
        Date dataChegada

) {
}
