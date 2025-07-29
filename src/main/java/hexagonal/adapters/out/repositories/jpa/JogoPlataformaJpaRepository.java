package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.JogoPlataformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoPlataformaJpaRepository extends JpaRepository<JogoPlataformaEntity, Long> {}
