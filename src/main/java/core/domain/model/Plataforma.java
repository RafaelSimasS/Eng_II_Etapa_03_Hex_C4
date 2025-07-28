package core.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private Long id;
    private String nome;
    private List<JogoPlataforma> precosDeJogos = new ArrayList<>();

    public Plataforma(Long id, String nome, List<JogoPlataforma> precosDeJogos) {
        this.id = id;
        this.nome = nome;
        this.precosDeJogos = precosDeJogos;
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

    public List<JogoPlataforma> getPrecosDeJogos() {
        return precosDeJogos;
    }

    public void setPrecosDeJogos(List<JogoPlataforma> precosDeJogos) {
        this.precosDeJogos = precosDeJogos;
    }
}
