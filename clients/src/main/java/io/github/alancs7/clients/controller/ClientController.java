package io.github.alancs7.clients.controller;

import io.github.alancs7.clients.model.entity.Client;
import io.github.alancs7.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found.")));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        findById(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Client clientUp) {
        repository
                .findById(id)
                .map(client -> {
                    client.setId(id);
                    client.setNome(clientUp.getNome());
                    client.setCpf(clientUp.getCpf());

                    return repository.save(client);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found."));
    }
}