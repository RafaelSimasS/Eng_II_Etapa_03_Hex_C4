package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.ClienteEntity;
import hexagonal.core.domain.model.Cliente;

public class ClienteMapper {

    public Cliente toDomain(ClienteEntity ent) {
        Cliente c = new Cliente(ent.getNome(), ent.getEmail(), ent.getTelefone(), ent.getSenha());
        c.setId(ent.getId());
        return c;
    }

    public ClienteEntity toEntity(Cliente domain) {
        ClienteEntity e = new ClienteEntity();
        e.setId(domain.getId());
        e.setNome(domain.getNome());
        e.setEmail(domain.getEmail());
        e.setTelefone(domain.getTelefone());
        e.setSenha(domain.getSenha());
        return e;
    }
}
