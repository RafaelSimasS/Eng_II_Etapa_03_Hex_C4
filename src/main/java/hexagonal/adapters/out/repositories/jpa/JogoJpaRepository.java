package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogoJpaRepository extends JpaRepository<JogoEntity, Long> {
    Optional<JogoEntity> findByTitulo(String titulo);
}
