package hexagonal.ports.out;

import hexagonal.core.domain.model.ItemLocacao;

import java.util.List;
import java.util.Optional;

public interface ItemLocacaoRepositoryPort {
    ItemLocacao save(ItemLocacao item);
    Optional<ItemLocacao> findById(Long id);
    List<ItemLocacao> findAll();
    void deleteById(Long id);
}
