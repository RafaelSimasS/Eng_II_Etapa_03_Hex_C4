package hexagonal.adapters.in.controller;


import hexagonal.adapters.in.controller.request.PlataformaCreateRequest;
import hexagonal.adapters.in.controller.request.PlataformaUpdateRequest;
import hexagonal.core.domain.model.Plataforma;
import hexagonal.ports.in.CreatePlataformaInputPort;
import hexagonal.ports.in.DeletePlataformaInputPort;
import hexagonal.ports.in.GetPlataformaInputPort;
import hexagonal.ports.in.UpdatePlataformaInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {

    private final CreatePlataformaInputPort createPort;
    private final GetPlataformaInputPort getPort;
    private final UpdatePlataformaInputPort updatePort;
    private final DeletePlataformaInputPort deletePort;

    public PlataformaController(CreatePlataformaInputPort createPort,
                                GetPlataformaInputPort getPort,
                                UpdatePlataformaInputPort updatePort,
                                DeletePlataformaInputPort deletePort) {
        this.createPort = createPort;
        this.getPort    = getPort;
        this.updatePort = updatePort;
        this.deletePort = deletePort;
    }

    @PostMapping
    public ResponseEntity<Plataforma> create(
            @RequestBody PlataformaCreateRequest req
    ) {
        Plataforma p = createPort.execute(req.getNome());
        return ResponseEntity
                .created(URI.create("/plataformas/" + p.getId()))
                .body(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plataforma> getById(@PathVariable Long id) {
        Optional<Plataforma> p = getPort.execute(id);
        return p.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plataforma> update(
            @PathVariable Long id,
            @RequestBody PlataformaUpdateRequest req
    ) {
        Optional<Plataforma> updated = updatePort.execute(id, req.getNovoNome());
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePort.execute(id);
        return ResponseEntity.noContent().build();
    }
}
