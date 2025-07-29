package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.ItemLocacaoEntity;
import hexagonal.core.domain.model.ItemLocacao;
import hexagonal.core.domain.model.JogoPlataforma;
import ports.out.JogoPlataformaRepositoryPort;

public class ItemLocacaoMapper {
    private final JogoPlataformaRepositoryPort jogoPlatRepo;

    public ItemLocacaoMapper(JogoPlataformaRepositoryPort jogoPlatRepo) {
        this.jogoPlatRepo = jogoPlatRepo;
    }

    public ItemLocacao toDomain(ItemLocacaoEntity ent) {
        JogoPlataforma jp = jogoPlatRepo.findById(ent.getJogoPlataformaId())
                .orElseThrow(() -> new IllegalArgumentException("JogoPlataforma não encontrado: " + ent.getJogoPlataformaId()));
        return new ItemLocacao(jp, ent.getDias(), ent.getQuantidade());
    }

    public ItemLocacaoEntity toEntity(ItemLocacao domain) {
        ItemLocacaoEntity ent = new ItemLocacaoEntity();
        ent.setJogoPlataformaId(domain.getJogoPlataforma().getId());
        ent.setDias(domain.getDias());
        ent.setQuantidade(domain.getQuantidade());
        return ent;
    }
}
