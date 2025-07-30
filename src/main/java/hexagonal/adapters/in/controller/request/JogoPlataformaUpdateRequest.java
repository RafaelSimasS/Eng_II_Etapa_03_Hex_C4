package hexagonal.adapters.in.controller.request;

import java.math.BigDecimal;

public class JogoPlataformaUpdateRequest {
    private java.math.BigDecimal novoPrecoDiario;

    public JogoPlataformaUpdateRequest() {}

    public BigDecimal getNovoPrecoDiario() { return novoPrecoDiario; }
    public void setNovoPrecoDiario(BigDecimal novoPrecoDiario) { this.novoPrecoDiario = novoPrecoDiario; }
}
