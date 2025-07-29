package hexagonal.ports.out;

import hexagonal.core.domain.model.Locacao;

import java.util.Optional;

public interface LocacaoRepositoryPort {
    Locacao save(Locacao locacao);
    Optional<Locacao> findById(Long id);
}
