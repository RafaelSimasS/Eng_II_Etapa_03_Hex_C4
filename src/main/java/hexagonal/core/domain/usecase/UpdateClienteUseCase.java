package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Cliente;
import hexagonal.ports.in.UpdateClienteInputPort;
import hexagonal.ports.out.ClienteRepositoryPort;

import java.util.Optional;

public class UpdateClienteUseCase implements UpdateClienteInputPort {
    private final ClienteRepositoryPort repo;

    public UpdateClienteUseCase(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Cliente> execute(Long id, String nome, String email, String telefone, String senha) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setNome(nome);
                    existing.setEmail(email);
                    existing.setTelefone(telefone);
                    existing.setSenha(senha);
                    return repo.save(existing);
                });
    }
}
