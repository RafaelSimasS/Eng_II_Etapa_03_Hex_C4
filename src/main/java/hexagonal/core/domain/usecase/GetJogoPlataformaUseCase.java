package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.core.domain.service.JogoPlataformaService;
import hexagonal.ports.in.GetJogoPlataformaInputPort;

import java.util.Optional;

public class GetJogoPlataformaUseCase implements GetJogoPlataformaInputPort {
    private final JogoPlataformaService service;

    public GetJogoPlataformaUseCase(JogoPlataformaService service) {
        this.service = service;
    }

    @Override
    public Optional<JogoPlataforma> execute(Long id) {
        return service.get(id);
    }
}
