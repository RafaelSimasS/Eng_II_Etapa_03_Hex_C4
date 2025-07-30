package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Cliente;
import hexagonal.core.domain.service.ClienteService;
import hexagonal.ports.in.CreateClienteInputPort;

public class CreateClienteUseCase implements CreateClienteInputPort {
    private final ClienteService service;

    public CreateClienteUseCase(ClienteService service) {
        this.service = service;
    }

    @Override
    public Cliente execute(String nome, String email, String telefone, String senha) {
        return service.create(nome, email, telefone, senha);
    }
}
