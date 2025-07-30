package hexagonal.ports.in;

import hexagonal.core.domain.model.JogoPlataforma;

import java.math.BigDecimal;

public interface UpdateJogoPlataformaInputPort {
    JogoPlataforma execute(Long id, BigDecimal novoPreco);
}
