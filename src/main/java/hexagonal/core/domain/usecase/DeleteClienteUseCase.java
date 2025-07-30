package hexagonal.core.domain.usecase;

import hexagonal.ports.in.DeleteClienteInputPort;
import hexagonal.ports.out.ClienteRepositoryPort;

public class DeleteClienteUseCase implements DeleteClienteInputPort {
    private final ClienteRepositoryPort repo;

    public DeleteClienteUseCase(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public void execute(Long id) {
        repo.deleteById(id);
    }

}
