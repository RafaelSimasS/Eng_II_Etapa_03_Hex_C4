package hexagonal.ports.out;

import hexagonal.core.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
}
