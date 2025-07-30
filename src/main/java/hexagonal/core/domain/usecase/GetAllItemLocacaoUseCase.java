package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.service.ServicoItemLocacao;
import hexagonal.ports.in.GetAllItemLocacaoInputPort;

import java.util.List;

public class GetAllItemLocacaoUseCase implements GetAllItemLocacaoInputPort {
    private final ServicoItemLocacao service;
    public GetAllItemLocacaoUseCase(ServicoItemLocacao s) { this.service = s; }
    @Override public List<ItemLocacao> execute() { return service.getAll(); }

}

