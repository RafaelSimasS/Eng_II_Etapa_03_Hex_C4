package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Plataforma;
import hexagonal.core.domain.service.PlataformaService;
import hexagonal.ports.in.GetPlataformaInputPort;

import java.util.Optional;

public class GetPlataformaUseCase implements GetPlataformaInputPort {
    private final PlataformaService service;

    public GetPlataformaUseCase(PlataformaService service) {
        this.service = service;
    }

    @Override
    public Optional<Plataforma> execute(Long id) {
        return service.get(id);
    }
}
