package core.domain.usecase;

import core.domain.model.Locacao;
import core.domain.service.LocacaoService;
import ports.in.CriarLocacaoInputPort;


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
