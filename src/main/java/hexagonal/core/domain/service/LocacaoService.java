package hexagonal.core.domain.service;

import hexagonal.core.domain.model.Cliente;
import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.core.domain.model.Locacao;
import hexagonal.ports.out.ClienteRepositoryPort;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;
import hexagonal.ports.out.LocacaoRepositoryPort;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocacaoService {
    private final ClienteRepositoryPort clienteRepo;
    private final LocacaoRepositoryPort locacaoRepo;
    private final JogoPlataformaRepositoryPort jogoPlatRepo;

    public LocacaoService(ClienteRepositoryPort clienteRepo,
                          LocacaoRepositoryPort locacaoRepo,
                          JogoPlataformaRepositoryPort jogoPlatRepo) {
        this.clienteRepo       = clienteRepo;
        this.locacaoRepo       = locacaoRepo;
        this.jogoPlatRepo      = jogoPlatRepo;
    }

    public Locacao criarLocacao(Long clienteId, LocalDate data) {
        Cliente cliente = clienteRepo.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Locacao locacao = new Locacao(cliente, data);
        return locacaoRepo.save(locacao);
    }
    public Locacao adicionarJogoALocacao(Long locacaoId,
                                         Long jogoPlataformaId,
                                         int dias
                                         ) {
        Locacao locacao = locacaoRepo.findById(locacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Locação não encontrada"));

        JogoPlataforma jp = jogoPlatRepo.findById(jogoPlataformaId)
                .orElseThrow(() -> new IllegalArgumentException("JogoPlataforma não encontrado"));

        ItemLocacao item = new ItemLocacao(jp, dias);
        locacao.addItem(item);

        return locacaoRepo.save(locacao);
    }
    public BigDecimal calcularCustoTotal(Long locacaoId) {
        Locacao locacao = locacaoRepo.findById(locacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Locação não encontrada"));

        return locacao.getItens().stream()
                .map(ItemLocacao::custo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
