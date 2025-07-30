package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.service.ServicoItemLocacao;
import hexagonal.ports.in.CreateItemLocacaoInputPort;

public class CreateItemLocacaoUseCase implements CreateItemLocacaoInputPort {
    private final ServicoItemLocacao service;
    public CreateItemLocacaoUseCase(ServicoItemLocacao s) { this.service = s; }

    @Override
    public ItemLocacao execute(Long jogoPlataformaId, int dias) {
        return service.create(jogoPlataformaId, dias);
    }
}
