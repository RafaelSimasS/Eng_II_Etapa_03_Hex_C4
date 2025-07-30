package hexagonal.adapters.in.controller;


import hexagonal.adapters.in.controller.request.ClienteRequest;
import hexagonal.core.domain.model.Cliente;
import hexagonal.ports.in.CreateClienteInputPort;
import hexagonal.ports.in.DeleteClienteInputPort;
import hexagonal.ports.in.GetClienteInputPort;
import hexagonal.ports.in.UpdateClienteInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final CreateClienteInputPort createPort;
    private final GetClienteInputPort getPort;
    private final UpdateClienteInputPort updatePort;
    private final DeleteClienteInputPort deletePort;
    public ClienteController(CreateClienteInputPort createPort,
                             GetClienteInputPort getPort,
                             UpdateClienteInputPort updatePort,
                             DeleteClienteInputPort deletePort) {
        this.createPort = createPort;
        this.getPort    = getPort;
        this.updatePort = updatePort;
        this.deletePort = deletePort;
    }


    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody ClienteRequest req) {
        Cliente saved = createPort.execute(req.getNome(), req.getEmail(), req.getTelefone(), req.getSenha());
        return ResponseEntity.created(URI.create("/clientes/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Optional<Cliente> c = getPort.execute(id);
        return c.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody ClienteRequest req) {
        Optional<Cliente> updated = updatePort.execute(id, req.getNome(), req.getEmail(), req.getTelefone(), req.getSenha());
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePort.execute(id);
        return ResponseEntity.noContent().build();
    }

}
