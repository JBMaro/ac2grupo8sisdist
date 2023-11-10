package proj.sis.dist.ac2voos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.sis.dist.ac2voos.domain.flight.Flight;
import proj.sis.dist.ac2voos.domain.flight.RequestFlight;
import proj.sis.dist.ac2voos.domain.seat.RequestSeat;
import proj.sis.dist.ac2voos.domain.seat.Seat;
import proj.sis.dist.ac2voos.domain.seat.SeatRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatRepository repository;
    @GetMapping
    public ResponseEntity getAllSeats(){
        var allSeats = repository.findAll();
        return ResponseEntity.ok(allSeats);
    }

    @PostMapping
    public ResponseEntity registerSeat(@RequestBody @Valid RequestSeat data){
        Seat newSeat = new Seat(data);
        repository.save(newSeat);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateSeat(@RequestBody @Valid RequestSeat data){
        Optional<Seat> optionalSeat = repository.findById(data.seatID());;
        if (optionalSeat.isPresent()) {
            Seat seat = optionalSeat.get();
            seat.setNum(data.num());
            seat.setClientID(data.clientID());
            seat.setFlightID(data.flightID());

            return ResponseEntity.ok(seat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteSeat(@RequestBody @Valid RequestSeat data){
        repository.deleteById(data.seatID());
        return ResponseEntity.ok().build();
    }
}
