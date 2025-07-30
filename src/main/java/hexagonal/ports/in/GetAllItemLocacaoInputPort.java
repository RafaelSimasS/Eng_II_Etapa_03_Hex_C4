package hexagonal.ports.in;

import hexagonal.core.domain.model.ItemLocacao;

import java.util.List;

public interface GetAllItemLocacaoInputPort {
    List<ItemLocacao> execute();
}
