package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.PlataformaEntity;
import hexagonal.core.domain.model.Plataforma;

import java.util.stream.Collectors;

public class PlataformaMapper {

    public Plataforma toDomain(PlataformaEntity ent) {
        return new Plataforma(ent.getId(), ent.getNome());
        // Não define precosDeJogos aqui
    }

    public PlataformaEntity toEntity(Plataforma domain) {
        PlataformaEntity ent = new PlataformaEntity();
        ent.setId(domain.getId());
        ent.setNome(domain.getNome());
        // Não define precosDeJogos aqui
        return ent;
    }
}