package hexagonal.ports.in;

import hexagonal.core.domain.model.JogoPlataforma;

import java.util.Optional;

public interface GetJogoPlataformaInputPort {
    Optional<JogoPlataforma> execute(Long id);
}
