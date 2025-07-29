package hexagonal.adapters.out.repositories.mapper;

import hexagonal.adapters.out.repositories.entity.LocacaoEntity;
import hexagonal.core.domain.model.Cliente;
import hexagonal.core.domain.model.Locacao;
import ports.out.ClienteRepositoryPort;

import java.util.stream.Collectors;

public class LocacaoMapper {

    private final ClienteRepositoryPort clienteRepo;
    private final ItemLocacaoMapper itemMapper;

    public LocacaoMapper(ClienteRepositoryPort clienteRepo, ItemLocacaoMapper itemMapper) {
        this.clienteRepo = clienteRepo;
        this.itemMapper = itemMapper;
    }

    public Locacao toDomain(LocacaoEntity entity) {
        Cliente cliente = clienteRepo.findById(entity.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + entity.getClienteId()));

        Locacao loc = new Locacao(cliente, entity.getData());
        loc.setId(entity.getId());

        entity.getItens().forEach(itemEnt -> {
            loc.addItem(itemMapper.toDomain(itemEnt));
        });
        return loc;
    }

    public LocacaoEntity toEntity(Locacao domain) {
        LocacaoEntity ent = new LocacaoEntity();
        ent.setId(domain.getId());
        ent.setClienteId(domain.getCliente().getId());
        ent.setData(domain.getData());
        ent.setItens(domain.getItens().stream()
                .map(itemMapper::toEntity)
                .collect(Collectors.toList()));
        return ent;
    }
}
