package core.domain.service;

import core.domain.model.Cliente;
import core.domain.model.ItemLocacao;
import core.domain.model.JogoPlataforma;
import core.domain.model.Locacao;
import ports.out.ClienteRepositoryPort;
import ports.out.JogoPlataformaRepositoryPort;
import ports.out.LocacaoRepositoryPort;

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
                                         int dias,
                                         int quantidade) {
        Locacao locacao = locacaoRepo.findById(locacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Locação não encontrada"));

        JogoPlataforma jp = jogoPlatRepo.findById(jogoPlataformaId)
                .orElseThrow(() -> new IllegalArgumentException("JogoPlataforma não encontrado"));

        ItemLocacao item = new ItemLocacao(jp, dias, quantidade);
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
