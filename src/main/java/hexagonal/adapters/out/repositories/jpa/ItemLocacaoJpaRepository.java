package hexagonal.adapters.out.repositories.jpa;

import hexagonal.adapters.out.repositories.entity.ItemLocacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemLocacaoJpaRepository extends JpaRepository<ItemLocacaoEntity, Long> {}
