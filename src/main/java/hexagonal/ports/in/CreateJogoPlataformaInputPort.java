package hexagonal.ports.in;

import hexagonal.core.domain.model.JogoPlataforma;

import java.math.BigDecimal;

public interface CreateJogoPlataformaInputPort {
    JogoPlataforma execute(Long plataformaId, String tituloJogo, BigDecimal precoDiario);
}
