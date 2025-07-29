package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Locacao;
import hexagonal.core.domain.service.LocacaoService;
import hexagonal.ports.in.CriarLocacaoInputPort;


import java.time.LocalDate;

public class CriarLocacaoUseCase implements CriarLocacaoInputPort {
    private final LocacaoService servico;

    public CriarLocacaoUseCase(LocacaoService servico) {
        this.servico = servico;
    }

    @Override
    public Locacao execute(Long clienteId, LocalDate dataLocacao) {
        return servico.criarLocacao(clienteId, dataLocacao);
    }
}
