package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.JogoEntity;
import hexagonal.core.domain.model.Jogo;

import java.util.stream.Collectors;

public class JogoMapper {
    private final JogoPlataformaMapper jpMapper;

    public JogoMapper(JogoPlataformaMapper jpMapper) {
        this.jpMapper = jpMapper;
    }

    public Jogo toDomain(JogoEntity ent) {
        Jogo jogo = new Jogo(ent.getId(), ent.getTitulo());
        // map association
        jogo.setPrecosPorPlataforma(
                ent.getPrecosPorPlataforma().stream()
                        .map(jpMapper::toDomain)
                        .collect(Collectors.toList())
        );
        return jogo;
    }

    public JogoEntity toEntity(Jogo domain) {
        JogoEntity ent = new JogoEntity();
        ent.setId(domain.getId());
        ent.setTitulo(domain.getTitulo());
        // map association
        ent.setPrecosPorPlataforma(
                domain.getPrecosPorPlataforma().stream()
                        .map(jp -> {
                            var e = jpMapper.toEntity(jp);
                            e.setJogoEntity(ent);
                            return e;
                        })
                        .collect(Collectors.toList())
        );
        return ent;
    }
}
