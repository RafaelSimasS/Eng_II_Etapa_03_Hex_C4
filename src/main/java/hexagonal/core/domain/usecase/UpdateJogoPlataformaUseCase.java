package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.core.domain.service.JogoPlataformaService;
import hexagonal.ports.in.UpdateJogoPlataformaInputPort;

import java.math.BigDecimal;

public class UpdateJogoPlataformaUseCase implements UpdateJogoPlataformaInputPort {
    private final JogoPlataformaService service;

    public UpdateJogoPlataformaUseCase(JogoPlataformaService service) {
        this.service = service;
    }

    @Override
    public JogoPlataforma execute(Long id, BigDecimal novoPreco) {
        return service.update(id, novoPreco);
    }
}
