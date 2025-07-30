package hexagonal.core.domain.usecase;

import hexagonal.core.domain.service.JogoPlataformaService;
import hexagonal.ports.in.DeleteJogoPlataformaInputPort;

public class DeleteJogoPlataformaUseCase implements DeleteJogoPlataformaInputPort {
    private final JogoPlataformaService service;

    public DeleteJogoPlataformaUseCase(JogoPlataformaService service) {
        this.service = service;
    }

    @Override
    public void execute(Long id) {
        service.delete(id);
    }

}
