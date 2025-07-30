package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.service.ServicoItemLocacao;
import hexagonal.ports.in.UpdateItemLocacaoInputPort;

public class UpdateItemLocacaoUseCase implements UpdateItemLocacaoInputPort {
    private final ServicoItemLocacao service;
    public UpdateItemLocacaoUseCase(ServicoItemLocacao s) { this.service = s; }
    @Override public ItemLocacao execute(Long id, int dias) {
        return service.update(id, dias);
    }
}