package core.domain.model;

import java.math.BigDecimal;

public class JogoPlataforma {
    private Jogo jogo;
    private Plataforma plataforma;
    private BigDecimal precoDiario;

    public JogoPlataforma(Jogo jogo, Plataforma plataforma, BigDecimal precoDiario) {
        this.jogo = jogo;
        this.plataforma = plataforma;
        this.precoDiario = precoDiario;
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
