package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Cliente;
import hexagonal.core.domain.service.ClienteService;
import hexagonal.ports.in.UpdateClienteInputPort;


import java.util.Optional;

public class UpdateClienteUseCase implements UpdateClienteInputPort {
    private final ClienteService service;

    public UpdateClienteUseCase(ClienteService service) {
        this.service = service;
    }

    @Override
    public Optional<Cliente> execute(Long id, String nome, String email, String telefone, String senha) {
        return service.update(id, nome, email, telefone, senha);
    }
}
