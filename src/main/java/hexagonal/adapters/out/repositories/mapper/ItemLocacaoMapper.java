package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.ItemLocacaoEntity;
import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;

public class ItemLocacaoMapper {

    private final JogoPlataformaRepositoryPort jpPort;

    public ItemLocacaoMapper(JogoPlataformaRepositoryPort jpPort) {
        this.jpPort = jpPort;
    }

    public ItemLocacao toDomain(ItemLocacaoEntity ent) {
        JogoPlataforma jp = jpPort.findById(ent.getJogoPlataformaId())
                .orElseThrow(() -> new IllegalArgumentException("JogoPlataforma não encontrado: " + ent.getJogoPlataformaId()));
        return new ItemLocacao(ent.getId(), jp, ent.getDias());
    }

    public ItemLocacaoEntity toEntity(ItemLocacao domain) {
        ItemLocacaoEntity ent = new ItemLocacaoEntity();
        ent.setId(domain.getId());
        ent.setJogoPlataformaId(domain.getJogoPlataforma().getId());
        ent.setDias(domain.getDias());
        return ent;
    }
}
