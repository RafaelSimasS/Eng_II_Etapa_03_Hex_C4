package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Plataforma;
import hexagonal.core.domain.service.PlataformaService;
import hexagonal.ports.in.CreatePlataformaInputPort;

public class CreatePlataformaUseCase implements CreatePlataformaInputPort {
    private final PlataformaService service;

    public CreatePlataformaUseCase(PlataformaService service) {
        this.service = service;
    }

    @Override
    public Plataforma execute(String nome) {
        return service.create(nome);
    }
}
