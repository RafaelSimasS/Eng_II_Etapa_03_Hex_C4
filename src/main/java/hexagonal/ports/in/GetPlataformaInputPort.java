package hexagonal.ports.in;

import hexagonal.core.domain.model.Plataforma;

import java.util.Optional;

public interface GetPlataformaInputPort {
    Optional<Plataforma> execute(Long id);
}
