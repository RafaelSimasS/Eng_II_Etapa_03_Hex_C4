package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Cliente;
import hexagonal.ports.in.GetClienteInputPort;
import hexagonal.ports.out.ClienteRepositoryPort;

import java.util.Optional;

public class GetClienteUseCase implements GetClienteInputPort {
    private final ClienteRepositoryPort repo;

    public GetClienteUseCase(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Cliente> execute(Long id) {
        return repo.findById(id);
    }
}
