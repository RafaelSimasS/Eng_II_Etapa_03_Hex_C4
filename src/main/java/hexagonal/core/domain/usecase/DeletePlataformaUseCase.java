package hexagonal.core.domain.usecase;

import hexagonal.core.domain.service.PlataformaService;
import hexagonal.ports.in.DeletePlataformaInputPort;

public class DeletePlataformaUseCase implements DeletePlataformaInputPort {
    private final PlataformaService service;

    public DeletePlataformaUseCase(PlataformaService service) {
        this.service = service;
    }

    @Override
    public void execute(Long id) {
        service.delete(id);
    }
}
