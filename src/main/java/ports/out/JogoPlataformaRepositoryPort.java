package ports.out;

import core.domain.model.JogoPlataforma;

import java.util.Optional;

public interface JogoPlataformaRepositoryPort {
    Optional<JogoPlataforma> findById(Long id);

}
