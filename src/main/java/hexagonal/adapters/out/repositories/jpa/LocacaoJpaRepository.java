package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.LocacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoJpaRepository extends JpaRepository<LocacaoEntity, Long> {}
