package hexagonal.adapters.in.controller;

import hexagonal.adapters.in.controller.request.ItemLocacaoCreateRequest;
import hexagonal.adapters.in.controller.request.ItemLocacaoUpdateRequest;
import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.ports.in.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-locacao")
public class ItemLocacaoController {

    private final CreateItemLocacaoInputPort createPort;
    private final GetItemLocacaoInputPort getPort;
    private final GetAllItemLocacaoInputPort getAllPort;
    private final UpdateItemLocacaoInputPort updatePort;
    private final DeleteItemLocacaoInputPort deletePort;

    public ItemLocacaoController(CreateItemLocacaoInputPort createPort,
                                 GetItemLocacaoInputPort getPort,
                                 GetAllItemLocacaoInputPort getAllPort,
                                 UpdateItemLocacaoInputPort updatePort,
                                 DeleteItemLocacaoInputPort deletePort) {
        this.createPort = createPort;
        this.getPort    = getPort;
        this.getAllPort = getAllPort;
        this.updatePort = updatePort;
        this.deletePort = deletePort;
    }

    @PostMapping
    public ResponseEntity<ItemLocacao> create(@RequestBody ItemLocacaoCreateRequest req) {
        ItemLocacao saved = createPort.execute(
                req.getJogoPlataformaId(),
                req.getDias()
        );
        return ResponseEntity
                .created(URI.create("/itens-locacao/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemLocacao> getById(@PathVariable Long id) {
        Optional<ItemLocacao> opt = getPort.execute(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ItemLocacao>> getAll() {
        List<ItemLocacao> list = getAllPort.execute();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemLocacao> update(
            @PathVariable Long id,
            @RequestBody ItemLocacaoUpdateRequest req
    ) {
        ItemLocacao updated = updatePort.execute(id, req.getDias());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePort.execute(id);
        return ResponseEntity.noContent().build();
    }
}

