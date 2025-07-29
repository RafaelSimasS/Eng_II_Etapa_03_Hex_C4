package hexagonal.adapters.out.repositories;

import hexagonal.adapters.out.repositories.entity.ClienteEntity;
import hexagonal.adapters.out.repositories.jpa.ClienteJpaRepository;
import hexagonal.adapters.out.repositories.mapper.ClienteMapper;
import hexagonal.core.domain.model.Cliente;
import org.springframework.stereotype.Component;
import hexagonal.ports.out.ClienteRepositoryPort;

import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository jpa;
    private final ClienteMapper mapper = new ClienteMapper();

    public ClienteRepositoryAdapter(ClienteJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity ent = mapper.toEntity(cliente);
        ClienteEntity saved = jpa.save(ent);
        return mapper.toDomain(saved);
    }
}
