package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {}
