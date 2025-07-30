package hexagonal.core.domain.service;

import hexagonal.core.domain.model.Cliente;
import hexagonal.ports.out.ClienteRepositoryPort;

import java.util.Optional;

public class ClienteService {
    private final ClienteRepositoryPort repo;

    public ClienteService(ClienteRepositoryPort repo) {
        this.repo = repo;
    }

    public Cliente create(String nome, String email, String telefone, String senha) {
        Cliente c = new Cliente(nome, email, telefone, senha);
        return repo.save(c);
    }

    public Optional<Cliente> getById(Long id) {
        return repo.findById(id);
    }

    public Optional<Cliente> update(Long id, String nome, String email, String telefone, String senha) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setNome(nome);
                    existing.setEmail(email);
                    existing.setTelefone(telefone);
                    existing.setSenha(senha);
                    return repo.save(existing);
                });
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
