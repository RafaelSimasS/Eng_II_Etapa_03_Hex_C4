package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Plataforma;
import hexagonal.core.domain.service.PlataformaService;
import hexagonal.ports.in.UpdatePlataformaInputPort;

import java.util.Optional;

public class UpdatePlataformaUseCase implements UpdatePlataformaInputPort {
    private final PlataformaService service;

    public UpdatePlataformaUseCase(PlataformaService service) {
        this.service = service;
    }

    @Override
    public Optional<Plataforma> execute(Long id, String novoNome) {
        return service.update(id, novoNome);
    }
}
