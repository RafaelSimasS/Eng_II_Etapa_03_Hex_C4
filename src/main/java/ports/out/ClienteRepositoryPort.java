package ports.out;

import core.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> findById(Long id);
}
