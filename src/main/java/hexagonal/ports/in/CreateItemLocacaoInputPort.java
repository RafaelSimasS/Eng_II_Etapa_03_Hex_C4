package hexagonal.ports.in;

import hexagonal.core.domain.model.ItemLocacao;

public interface CreateItemLocacaoInputPort {
    ItemLocacao execute(Long jogoPlataformaId, int dias);
}
