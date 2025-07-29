package hexagonal.ports.out;

import hexagonal.core.domain.model.Plataforma;

import java.util.Optional;

public interface PlataformaRepositoryPort {
    Optional<Plataforma> findById(Long id);
    Plataforma save(Plataforma plataforma);
}
