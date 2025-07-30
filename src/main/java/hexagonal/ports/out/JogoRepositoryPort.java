package hexagonal.ports.out;

import hexagonal.core.domain.model.Jogo;

import java.util.Optional;

public interface JogoRepositoryPort {
    Optional<Jogo> findById(Long id);
    Jogo save(Jogo jogo);
    Optional<Jogo> findByTitulo(String titulo);
    void deleteById(Long id);
}
