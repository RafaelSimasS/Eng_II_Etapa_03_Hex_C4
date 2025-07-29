package hexagonal.adapters.out.repositories;

import hexagonal.adapters.out.repositories.entity.LocacaoEntity;
import hexagonal.adapters.out.repositories.jpa.LocacaoJpaRepository;
import hexagonal.adapters.out.repositories.mapper.ItemLocacaoMapper;
import hexagonal.adapters.out.repositories.mapper.LocacaoMapper;
import hexagonal.core.domain.model.Locacao;
import org.springframework.stereotype.Component;
import ports.out.ClienteRepositoryPort;
import ports.out.JogoPlataformaRepositoryPort;
import ports.out.LocacaoRepositoryPort;

import java.util.Optional;

@Component
public class LocacaoRepositoryAdapter implements LocacaoRepositoryPort {

    private final LocacaoJpaRepository jpa;
    private final LocacaoMapper mapper;

    public LocacaoRepositoryAdapter(LocacaoJpaRepository jpa,
                                    ClienteRepositoryPort clienteRepo,
                                    JogoPlataformaRepositoryPort jogoPlatRepo) {
        this.jpa = jpa;
        this.mapper = new LocacaoMapper(clienteRepo, new ItemLocacaoMapper(jogoPlatRepo));
    }

    @Override
    public Locacao save(Locacao loc) {
        LocacaoEntity ent = mapper.toEntity(loc);
        LocacaoEntity saved = jpa.save(ent);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Locacao> findById(Long id) {
        return jpa.findById(id)
                .map(mapper::toDomain);
    }
}