package hexagonal.adapters.in.controller;

import hexagonal.adapters.in.controller.request.LocacaoAddJogoRequest;
import hexagonal.adapters.in.controller.request.LocacaoCreateRequest;
import hexagonal.core.domain.model.Locacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hexagonal.ports.in.CalcularCustoTotalLocacaoInputPort;
import hexagonal.ports.in.CriarLocacaoInputPort;
import hexagonal.ports.in.InserirJogoLocacaoInputPort;

import java.net.URI;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    private final CriarLocacaoInputPort criarLocacao;
    private final InserirJogoLocacaoInputPort inserirJogo;
    private final CalcularCustoTotalLocacaoInputPort calcularCusto;

    public LocacaoController(
            CriarLocacaoInputPort criarLocacao,
            InserirJogoLocacaoInputPort inserirJogo,
            CalcularCustoTotalLocacaoInputPort calcularCusto
    ) {
        this.criarLocacao = criarLocacao;
        this.inserirJogo = inserirJogo;
        this.calcularCusto = calcularCusto;
    }

    @PostMapping
    public ResponseEntity<Locacao> criar(@RequestBody LocacaoCreateRequest req) {
        Locacao loc = criarLocacao.execute(req.getClienteId(), req.getDataLocacao());
        return ResponseEntity
                .created(URI.create("/locacoes/" + loc.getId()))
                .body(loc);
    }

    @PostMapping("/{id}/jogos")
    public ResponseEntity<Locacao> adicionarJogo(
            @PathVariable("id") Long locacaoId,
            @RequestBody LocacaoAddJogoRequest req
    ) {
        Locacao updated = inserirJogo.execute(
                locacaoId,
                req.getJogoPlataformaId(),
                req.getDias(),
                req.getQuantidade()
        );
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}/custo")
    public ResponseEntity<Map<String, Object>> custoTotal(@PathVariable("id") Long locacaoId) {
        var total = calcularCusto.execute(locacaoId);
        return ResponseEntity.ok(Map.of(
                "locacaoId", locacaoId,
                "custoTotal", total
        ));
    }
}
