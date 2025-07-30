package hexagonal.adapters.out.repositories;

import hexagonal.adapters.out.repositories.entity.ItemLocacaoEntity;
import hexagonal.adapters.out.repositories.jpa.ItemLocacaoJpaRepository;
import hexagonal.adapters.out.repositories.mapper.ItemLocacaoMapper;
import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.ports.out.ItemLocacaoRepositoryPort;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ItemLocacaoRepositoryAdapter implements ItemLocacaoRepositoryPort {
    private final ItemLocacaoJpaRepository jpa;
    private final ItemLocacaoMapper mapper;

    public ItemLocacaoRepositoryAdapter(ItemLocacaoJpaRepository jpa,
                                        JogoPlataformaRepositoryPort jpPort) {
        this.jpa = jpa;
        this.mapper = new ItemLocacaoMapper(jpPort);
    }

    @Override
    public ItemLocacao save(ItemLocacao item) {
        ItemLocacaoEntity ent = mapper.toEntity(item);
        ItemLocacaoEntity saved = jpa.save(ent);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ItemLocacao> findById(Long id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<ItemLocacao> findAll() {
        return jpa.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
