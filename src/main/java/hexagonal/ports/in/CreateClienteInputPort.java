package hexagonal.ports.in;

import hexagonal.core.domain.model.Cliente;

public interface CreateClienteInputPort {
    Cliente execute(String nome, String email, String telefone, String senha);
}
