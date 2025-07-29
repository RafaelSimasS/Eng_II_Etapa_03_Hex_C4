package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.JogoEntity;
import hexagonal.core.domain.model.Jogo;

import java.util.stream.Collectors;

public class JogoMapper {
    public Jogo toDomain(JogoEntity ent) {
        return new Jogo(ent.getId(), ent.getTitulo());
        // Removido: setPrecosPorPlataforma()
    }

    public JogoEntity toEntity(Jogo domain) {
        JogoEntity ent = new JogoEntity();
        ent.setId(domain.getId());
        ent.setTitulo(domain.getTitulo());
        // Removido: setPrecosPorPlataforma()
        return ent;
    }
}
