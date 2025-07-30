package hexagonal.ports.in;

import hexagonal.core.domain.model.Cliente;

import java.util.Optional;

public interface GetClienteInputPort {
    Optional<Cliente> execute(Long id);

}
