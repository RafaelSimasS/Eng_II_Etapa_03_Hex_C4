package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.PlataformaEntity;
import hexagonal.core.domain.model.Plataforma;

import java.util.stream.Collectors;

public class PlataformaMapper {
    private final JogoPlataformaMapper jpMapper;

    public PlataformaMapper(JogoPlataformaMapper jpMapper) {
        this.jpMapper = jpMapper;
    }

    public Plataforma toDomain(PlataformaEntity ent) {
        Plataforma plt = new Plataforma(ent.getId(), ent.getNome());
        plt.setPrecosDeJogos(
                ent.getPrecosDeJogos().stream()
                        .map(jpMapper::toDomain)
                        .collect(Collectors.toList())
        );
        return plt;
    }

    public PlataformaEntity toEntity(Plataforma domain) {
        PlataformaEntity ent = new PlataformaEntity();
        ent.setId(domain.getId());
        ent.setNome(domain.getNome());
        ent.setPrecosDeJogos(
                domain.getPrecosDeJogos().stream()
                        .map(jp -> {
                            var e = jpMapper.toEntity(jp);
                            e.setPlataformaEntity(ent);
                            return e;
                        })
                        .collect(Collectors.toList())
        );
        return ent;
    }
}
