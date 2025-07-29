package ports.in;

import java.math.BigDecimal;

public interface CalcularCustoTotalLocacaoInputPort {
    BigDecimal execute(Long locacaoId);
}
