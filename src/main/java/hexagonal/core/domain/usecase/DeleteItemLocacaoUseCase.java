package hexagonal.core.domain.usecase;

import hexagonal.core.domain.service.ServicoItemLocacao;
import hexagonal.ports.in.DeleteItemLocacaoInputPort;

public class DeleteItemLocacaoUseCase implements DeleteItemLocacaoInputPort {
    private final ServicoItemLocacao service;
    public DeleteItemLocacaoUseCase(ServicoItemLocacao s) { this.service = s; }
    @Override public void execute(Long id) { service.delete(id); }
}