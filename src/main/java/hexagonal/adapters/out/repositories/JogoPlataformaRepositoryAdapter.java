package hexagonal.adapters.out.repositories;

import hexagonal.adapters.out.repositories.entity.JogoPlataformaEntity;
import hexagonal.adapters.out.repositories.jpa.JogoPlataformaJpaRepository;
import hexagonal.adapters.out.repositories.mapper.JogoMapper;
import hexagonal.adapters.out.repositories.mapper.JogoPlataformaMapper;
import hexagonal.adapters.out.repositories.mapper.PlataformaMapper;
import hexagonal.core.domain.model.JogoPlataforma;
import org.springframework.stereotype.Component;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;

import java.util.Optional;

@Component
public class JogoPlataformaRepositoryAdapter implements JogoPlataformaRepositoryPort {

    private final JogoPlataformaJpaRepository jpa;
    private final JogoPlataformaMapper mapper;

    public JogoPlataformaRepositoryAdapter(JogoPlataformaJpaRepository jpa,
                                           JogoMapper jogoMapper,
                                           PlataformaMapper plataformaMapper) {
        this.jpa = jpa;
        this.mapper = new JogoPlataformaMapper(jogoMapper, plataformaMapper);
    }

    @Override
    public Optional<JogoPlataforma> findById(Long id) {
        return jpa.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public JogoPlataforma save(JogoPlataforma jp) {
        JogoPlataformaEntity ent = mapper.toEntity(jp);
        JogoPlataformaEntity saved = jpa.save(ent);
        return mapper.toDomain(saved);
    }
}
