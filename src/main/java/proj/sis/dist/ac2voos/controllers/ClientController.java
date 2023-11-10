package proj.sis.dist.ac2voos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.sis.dist.ac2voos.domain.client.Client;
import proj.sis.dist.ac2voos.domain.client.ClientRepository;
import proj.sis.dist.ac2voos.domain.client.RequestClient;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
@Controller
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository repository;
    @GetMapping
    public ResponseEntity getAllClients(){
        var allClients = repository.findAll();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    public ResponseEntity registerClient(@RequestBody @Valid RequestClient data){
        Client newClient = new Client(data);
        repository.save(newClient);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody @Valid RequestClient data){
        Optional<Client> optionalClient = repository.findById(data.clientID());;
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(data.name());
            client.setLastname(data.lastname());
            client.setCpf(data.cpf());
            client.setLogin(data.login());
            client.setPassword(data.password());
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteClient(@RequestBody @Valid RequestClient data){
        repository.deleteById(data.clientID());
        return ResponseEntity.ok().build();
    }

}