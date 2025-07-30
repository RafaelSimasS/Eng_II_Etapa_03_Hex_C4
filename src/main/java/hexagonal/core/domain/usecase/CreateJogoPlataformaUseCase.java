package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.core.domain.service.JogoPlataformaService;
import hexagonal.ports.in.CreateJogoPlataformaInputPort;

import java.math.BigDecimal;

public class CreateJogoPlataformaUseCase implements CreateJogoPlataformaInputPort {
    private final JogoPlataformaService service;

    public CreateJogoPlataformaUseCase(JogoPlataformaService service) {
        this.service = service;
    }

    @Override
    public JogoPlataforma execute(Long plataformaId, String tituloJogo, BigDecimal precoDiario) {
        return service.create(plataformaId, tituloJogo, precoDiario);
    }

}
