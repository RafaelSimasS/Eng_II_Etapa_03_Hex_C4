package hexagonal.adapters.out.repositories;

import hexagonal.adapters.out.repositories.entity.PlataformaEntity;
import hexagonal.adapters.out.repositories.jpa.PlataformaJpaRepository;
import hexagonal.adapters.out.repositories.mapper.PlataformaMapper;
import hexagonal.core.domain.model.Plataforma;
import hexagonal.ports.out.PlataformaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlataformaRepositoryAdapter implements PlataformaRepositoryPort {

    private final PlataformaJpaRepository jpa;
    private final PlataformaMapper mapper;

    public PlataformaRepositoryAdapter(PlataformaJpaRepository jpa, PlataformaMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public Optional<Plataforma> findById(Long id) {
        return jpa.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Plataforma save(Plataforma plataforma) {
        PlataformaEntity ent = mapper.toEntity(plataforma);
        PlataformaEntity saved = jpa.save(ent);
        return mapper.toDomain(saved);
    }
}
