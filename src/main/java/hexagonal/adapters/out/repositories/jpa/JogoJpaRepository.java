package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoJpaRepository extends JpaRepository<JogoEntity, Long> {}
