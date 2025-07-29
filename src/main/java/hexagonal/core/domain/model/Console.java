package hexagonal.core.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Console {
    private Long id;
    private String nome;
    private BigDecimal precoPorHora;
    private List<Acessorio> acessorios = new ArrayList<>();
    private List<UtilizacaoConsole> utilizacoes = new ArrayList<>();

    public Console(Long id, String nome, BigDecimal precoPorHora, List<Acessorio> acessorios, List<UtilizacaoConsole> utilizacoes) {
        this.id = id;
        this.nome = nome;
        this.precoPorHora = precoPorHora;
        this.acessorios = acessorios;
        this.utilizacoes = utilizacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(BigDecimal precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public List<UtilizacaoConsole> getUtilizacoes() {
        return utilizacoes;
    }

    public void setUtilizacoes(List<UtilizacaoConsole> utilizacoes) {
        this.utilizacoes = utilizacoes;
    }
}
