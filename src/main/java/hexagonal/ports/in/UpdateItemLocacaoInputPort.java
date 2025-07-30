package hexagonal.ports.in;

import hexagonal.core.domain.model.ItemLocacao;

public interface UpdateItemLocacaoInputPort {
    ItemLocacao execute(Long id, int dias);
}
