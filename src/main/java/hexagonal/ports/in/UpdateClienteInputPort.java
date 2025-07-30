package hexagonal.ports.in;

import hexagonal.core.domain.model.Cliente;

import java.util.Optional;

public interface UpdateClienteInputPort {
    Optional<Cliente> execute(Long id, String nome, String email, String telefone, String senha);
}
