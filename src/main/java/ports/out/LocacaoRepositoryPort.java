package ports.out;

import core.domain.model.Locacao;

import java.util.Optional;

public interface LocacaoRepositoryPort {
    Locacao save(Locacao locacao);
    Optional<Locacao> findById(Long id);
}
