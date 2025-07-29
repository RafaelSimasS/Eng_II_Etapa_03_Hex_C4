package hexagonal.core.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private Long id;
    private String titulo;
    private List<JogoPlataforma> precosPorPlataforma = new ArrayList<>();

    public Jogo(Long id, String titulo, List<JogoPlataforma> precosPorPlataforma) {
        this.id = id;
        this.titulo = titulo;
        this.precosPorPlataforma = precosPorPlataforma;
    }

    public Jogo(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<JogoPlataforma> getPrecosPorPlataforma() {
        return precosPorPlataforma;
    }

    public void setPrecosPorPlataforma(List<JogoPlataforma> precosPorPlataforma) {
        this.precosPorPlataforma = precosPorPlataforma;
    }
}
