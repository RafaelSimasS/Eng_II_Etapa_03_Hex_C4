package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.service.ServicoItemLocacao;
import hexagonal.ports.in.GetItemLocacaoInputPort;

import java.util.Optional;

public class GetItemLocacaoUseCase implements GetItemLocacaoInputPort {
    private final ServicoItemLocacao service;
    public GetItemLocacaoUseCase(ServicoItemLocacao s) { this.service = s; }
    @Override public Optional<ItemLocacao> execute(Long id) { return service.getById(id); }

}
