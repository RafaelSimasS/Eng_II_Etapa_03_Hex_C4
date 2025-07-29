package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.PlataformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlataformaJpaRepository extends JpaRepository<PlataformaEntity, Long> {}
