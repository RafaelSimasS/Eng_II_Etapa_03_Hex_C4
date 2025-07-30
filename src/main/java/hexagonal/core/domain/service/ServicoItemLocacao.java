package hexagonal.core.domain.service;

import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.ports.out.ItemLocacaoRepositoryPort;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ServicoItemLocacao {
    private final ItemLocacaoRepositoryPort repo;
    private final JogoPlataformaRepositoryPort jpRepo;

    public ServicoItemLocacao(ItemLocacaoRepositoryPort repo, JogoPlataformaRepositoryPort jpRepo) {
        this.repo = repo;
        this.jpRepo = jpRepo;
    }

    public ItemLocacao create(Long jogoPlataformaId, int dias) {
        JogoPlataforma jp = jpRepo.findById(jogoPlataformaId)
                .orElseThrow(() -> new IllegalArgumentException("JogoPlataforma não encontrado: " + jogoPlataformaId));
        ItemLocacao item = new ItemLocacao(jp, dias);
        return repo.save(item);
    }

    public Optional<ItemLocacao> getById(Long id) {
        return repo.findById(id);
    }

    public List<ItemLocacao> getAll() {
        return repo.findAll();
    }

    public ItemLocacao update(Long id, int dias) {
        ItemLocacao item = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + id));
        item.setDias(dias);
        return repo.save(item);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
