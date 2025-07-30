package hexagonal.ports.in;

import hexagonal.core.domain.model.ItemLocacao;

import java.util.Optional;

public interface GetItemLocacaoInputPort {
    Optional<ItemLocacao> execute(Long id);
}
