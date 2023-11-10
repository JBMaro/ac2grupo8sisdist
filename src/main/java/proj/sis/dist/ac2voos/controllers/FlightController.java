package proj.sis.dist.ac2voos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.sis.dist.ac2voos.domain.flight.Flight;
import proj.sis.dist.ac2voos.domain.flight.FlightRepository;
import proj.sis.dist.ac2voos.domain.flight.RequestFlight;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightRepository repository;
    @GetMapping
    public ResponseEntity getAllFlights(){
        var allFlights = repository.findAll();
        return ResponseEntity.ok(allFlights);
    }

    @PostMapping
    public ResponseEntity registerFlight(@RequestBody @Valid RequestFlight data){
        Flight newFlight = new Flight(data);
        repository.save(newFlight);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateFlight(@RequestBody @Valid RequestFlight data){
        Optional<Flight> optionalFlight = repository.findById(data.flightID());;
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flight.setNumOfSeats(data.numOfSeats());
            flight.setCidadePartida(data.cidadePartida());
            flight.setCidadeChegada(data.cidadeChegada());
            flight.setHorarioPartida(data.horarioPartida());
            flight.setHorarioChegada(data.horarioChegada());
            flight.setDataPartida(data.dataPartida());
            flight.setDataChegada(data.dataChegada());

            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteFlight(@RequestBody @Valid RequestFlight data){
        repository.deleteById(data.flightID());
        return ResponseEntity.ok().build();
    }

}
