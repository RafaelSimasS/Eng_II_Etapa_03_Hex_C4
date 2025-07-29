package hexagonal.ports.out;

import hexagonal.core.domain.model.JogoPlataforma;

import java.util.Optional;

public interface JogoPlataformaRepositoryPort {
    JogoPlataforma save(JogoPlataforma jp);
    Optional<JogoPlataforma> findById(Long id);
}
