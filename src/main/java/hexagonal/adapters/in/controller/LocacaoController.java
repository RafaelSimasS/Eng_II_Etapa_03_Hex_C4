package hexagonal.adapters.in.controller;

import hexagonal.core.domain.model.Locacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ports.in.CalcularCustoTotalLocacaoInputPort;
import ports.in.CriarLocacaoInputPort;
import ports.in.InserirJogoLocacaoInputPort;

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
    public ResponseEntity<Locacao> criar(@RequestBody Map<String, String> body) {
        Long clienteId   = Long.valueOf(body.get("clienteId"));
        LocalDate data   = LocalDate.parse(body.get("dataLocacao"));
        Locacao loc = criarLocacao.execute(clienteId, data);
        return ResponseEntity
                .created(URI.create("/locacoes/" + loc.getId()))
                .body(loc);
    }

    @PostMapping("/{id}/jogos")
    public ResponseEntity<Locacao> adicionarJogo(
            @PathVariable("id") Long locacaoId,
            @RequestBody Map<String, String> body
    ) {
        Long jogoPlatId = Long.valueOf(body.get("jogoPlataformaId"));
        int dias        = Integer.parseInt(body.get("dias"));
        int qtde        = Integer.parseInt(body.get("quantidade"));
        Locacao updated = inserirJogo.execute(locacaoId, jogoPlatId, dias, qtde);
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
