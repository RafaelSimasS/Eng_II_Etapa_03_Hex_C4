package hexagonal.core.domain.model;

import java.math.BigDecimal;

public class ItemLocacao {
    private Long id;
    private JogoPlataforma jogoPlataforma;
    private int dias;


    public ItemLocacao(JogoPlataforma jogoPlataforma, int dias) {
        this.jogoPlataforma = jogoPlataforma;
        this.dias = dias;
    }

    public ItemLocacao(Long id, JogoPlataforma jogoPlataforma, int dias) {
        this.id = id;
        this.jogoPlataforma = jogoPlataforma;
        this.dias = dias;

    }
    public BigDecimal custo() {
        return jogoPlataforma.getPrecoDiario()
                .multiply(BigDecimal.valueOf(dias));
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public JogoPlataforma getJogoPlataforma() {
        return jogoPlataforma;
    }

    public void setJogoPlataforma(JogoPlataforma jogoPlataforma) {
        this.jogoPlataforma = jogoPlataforma;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
