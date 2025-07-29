package hexagonal.core.domain.model;

import java.math.BigDecimal;

public class JogoPlataforma {
    private Long id;
    private Jogo jogo;
    private Plataforma plataforma;
    private BigDecimal precoDiario;

    public JogoPlataforma(Long id, Jogo jogo, Plataforma plataforma, BigDecimal precoDiario) {
        this.id = id;
        this.jogo = jogo;
        this.plataforma = plataforma;
        this.precoDiario = precoDiario;
    }

    public JogoPlataforma(Jogo jogo, Plataforma plataforma, BigDecimal precoDiario) {
        this.jogo = jogo;
        this.plataforma = plataforma;
        this.precoDiario = precoDiario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public BigDecimal getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(BigDecimal precoDiario) {
        this.precoDiario = precoDiario;
    }
}
