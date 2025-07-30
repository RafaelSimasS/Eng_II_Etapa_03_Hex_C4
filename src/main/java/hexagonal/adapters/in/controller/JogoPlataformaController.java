package hexagonal.adapters.in.controller;


import hexagonal.adapters.in.controller.request.JogoPlataformaCreateRequest;
import hexagonal.adapters.in.controller.request.JogoPlataformaUpdateRequest;
import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.ports.in.CreateJogoPlataformaInputPort;
import hexagonal.ports.in.DeleteJogoPlataformaInputPort;
import hexagonal.ports.in.GetJogoPlataformaInputPort;
import hexagonal.ports.in.UpdateJogoPlataformaInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/jogos-plataforma")
public class JogoPlataformaController {
    private final CreateJogoPlataformaInputPort createPort;
    private final GetJogoPlataformaInputPort getPort;
    private final UpdateJogoPlataformaInputPort updatePort;
    private final DeleteJogoPlataformaInputPort deletePort;
    public JogoPlataformaController(CreateJogoPlataformaInputPort createPort,
                                    GetJogoPlataformaInputPort getPort,
                                    UpdateJogoPlataformaInputPort updatePort,
                                    DeleteJogoPlataformaInputPort deletePort) {
        this.createPort = createPort;
        this.getPort    = getPort;
        this.updatePort = updatePort;
        this.deletePort = deletePort;
    }

    @PostMapping
    public ResponseEntity<JogoPlataforma> create(
            @RequestBody JogoPlataformaCreateRequest req
    ) {
        JogoPlataforma jp = createPort.execute(
                req.getPlataformaId(),
                req.getTituloJogo(),
                req.getPrecoDiario()
        );
        return ResponseEntity
                .created(URI.create("/jogos-plataforma/" + jp.getId()))
                .body(jp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoPlataforma> getById(@PathVariable Long id) {
        Optional<JogoPlataforma> jp = getPort.execute(id);
        return jp.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoPlataforma> update(
            @PathVariable Long id,
            @RequestBody JogoPlataformaUpdateRequest req
    ) {
        JogoPlataforma updated = updatePort.execute(id, req.getNovoPrecoDiario());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePort.execute(id);
        return ResponseEntity.noContent().build();
    }
}
