package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.JogoPlataformaEntity;
import hexagonal.core.domain.model.Jogo;
import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.core.domain.model.Plataforma;
import hexagonal.ports.out.JogoRepositoryPort;
import hexagonal.ports.out.PlataformaRepositoryPort;

public class JogoPlataformaMapper {

    private final JogoMapper jogoMapper;
    private final PlataformaMapper plataformaMapper;

    public JogoPlataformaMapper(JogoMapper jogoMapper,
                                PlataformaMapper plataformaMapper) {
        this.jogoMapper = jogoMapper;
        this.plataformaMapper = plataformaMapper;
    }


    public JogoPlataforma toDomain(JogoPlataformaEntity ent) {
        var jogo = jogoMapper.toDomain(ent.getJogoEntity());
        var plataforma = plataformaMapper.toDomain(ent.getPlataformaEntity());

        JogoPlataforma domain = new JogoPlataforma(jogo, plataforma, ent.getPrecoDiario());
        domain.setId(ent.getId());
        return domain;
    }

    public JogoPlataformaEntity toEntity(JogoPlataforma domain) {
        JogoPlataformaEntity ent = new JogoPlataformaEntity();
        ent.setId(domain.getId());

        // set nested entity objects
        var jogoEnt = jogoMapper.toEntity(domain.getJogo());
        var platEnt = plataformaMapper.toEntity(domain.getPlataforma());
        ent.setJogoEntity(jogoEnt);
        ent.setPlataformaEntity(platEnt);

        ent.setPrecoDiario(domain.getPrecoDiario());
        return ent;
    }
}

