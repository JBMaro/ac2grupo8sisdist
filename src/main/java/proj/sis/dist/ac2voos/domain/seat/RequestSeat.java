package proj.sis.dist.ac2voos.domain.seat;

import javax.validation.constraints.NotBlank;

public record RequestSeat(
        Long seatID,

        @NotBlank
        Integer num,
        Long flightID,
        Long clientID
) {
}
