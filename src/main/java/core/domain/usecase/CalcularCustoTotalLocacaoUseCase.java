package core.domain.usecase;

import core.domain.service.LocacaoService;
import ports.in.CalcularCustoTotalLocacaoInputPort;


import java.math.BigDecimal;

public class CalcularCustoTotalLocacaoUseCase implements CalcularCustoTotalLocacaoInputPort {
    private final LocacaoService servico;

    public CalcularCustoTotalLocacaoUseCase(LocacaoService servico) {
        this.servico = servico;
    }

    @Override
    public BigDecimal execute(Long locacaoId) {
        return servico.calcularCustoTotal(locacaoId);
    }
}
