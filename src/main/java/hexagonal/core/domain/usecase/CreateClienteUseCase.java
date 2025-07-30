package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Cliente;
import hexagonal.ports.in.CreateClienteInputPort;
import hexagonal.ports.out.ClienteRepositoryPort;

public class CreateClienteUseCase implements CreateClienteInputPort {
    private final ClienteRepositoryPort repo;

    public CreateClienteUseCase(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Cliente execute(String nome, String email, String telefone, String senha) {
        Cliente c = new Cliente(nome, email, telefone, senha);
        return repo.save(c);
    }
}
