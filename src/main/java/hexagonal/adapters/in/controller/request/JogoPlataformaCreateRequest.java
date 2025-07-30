package hexagonal.adapters.in.controller.request;

import java.math.BigDecimal;

public class JogoPlataformaCreateRequest {
    private Long plataformaId;
    private String tituloJogo;
    private BigDecimal precoDiario;

    public JogoPlataformaCreateRequest() {}

    public Long getPlataformaId() { return plataformaId; }
    public void setPlataformaId(Long plataformaId) { this.plataformaId = plataformaId; }

    public String getTituloJogo() { return tituloJogo; }
    public void setTituloJogo(String tituloJogo) { this.tituloJogo = tituloJogo; }

    public BigDecimal getPrecoDiario() { return precoDiario; }
    public void setPrecoDiario(BigDecimal precoDiario) { this.precoDiario = precoDiario; }
}
