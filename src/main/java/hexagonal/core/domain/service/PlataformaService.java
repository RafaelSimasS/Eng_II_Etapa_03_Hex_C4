package hexagonal.core.domain.service;

import hexagonal.core.domain.model.Plataforma;
import hexagonal.ports.out.PlataformaRepositoryPort;

import java.util.Optional;

public class PlataformaService {
    private final PlataformaRepositoryPort repo;

    public PlataformaService(PlataformaRepositoryPort repo) {
        this.repo = repo;
    }

    public Plataforma create(String nome) {
        Plataforma p = new Plataforma(null, nome);
        return repo.save(p);
    }

    public Optional<Plataforma> get(Long id) {
        return repo.findById(id);
    }

    public Optional<Plataforma> update(Long id, String novoNome) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setNome(novoNome);
                    return repo.save(existing);
                });
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
