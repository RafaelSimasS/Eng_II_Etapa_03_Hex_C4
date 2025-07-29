package hexagonal.core.domain.model;

import java.math.BigDecimal;

public class ItemLocacao {
    private JogoPlataforma jogoPlataforma;
    private int dias;
    private int quantidade;

    public ItemLocacao(JogoPlataforma jogoPlataforma, int dias, int quantidade) {
        this.jogoPlataforma = jogoPlataforma;
        this.dias = dias;
        this.quantidade = quantidade;
    }
    public BigDecimal custo() {
        return jogoPlataforma.getPrecoDiario()
                .multiply(BigDecimal.valueOf(dias))
                .multiply(BigDecimal.valueOf(quantidade));
    }

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
