package hexagonal.adapters.out.repositories;

import hexagonal.adapters.out.repositories.entity.JogoEntity;
import hexagonal.adapters.out.repositories.jpa.JogoJpaRepository;
import hexagonal.adapters.out.repositories.mapper.JogoMapper;
import hexagonal.core.domain.model.Jogo;
import hexagonal.ports.out.JogoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JogoRepositoryAdapter implements JogoRepositoryPort {

    private final JogoJpaRepository jpa;
    private final JogoMapper mapper;

    public JogoRepositoryAdapter(JogoJpaRepository jpa, JogoMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public Optional<Jogo> findById(Long id) {
        return jpa.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Jogo save(Jogo jogo) {
        JogoEntity ent = mapper.toEntity(jogo);
        JogoEntity saved = jpa.save(ent);
        return mapper.toDomain(saved);
    }
    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
    @Override
    public Optional<Jogo> findByTitulo(String titulo) {
        return jpa.findByTitulo(titulo)
                .map(mapper::toDomain);
    }
}
