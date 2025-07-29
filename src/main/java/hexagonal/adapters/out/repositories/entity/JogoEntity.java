package hexagonal.adapters.out.repositories.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogos")
public class JogoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToMany(mappedBy = "jogoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JogoPlataformaEntity> precosPorPlataforma = new ArrayList<>();

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public List<JogoPlataformaEntity> getPrecosPorPlataforma() { return precosPorPlataforma; }
    public void setPrecosPorPlataforma(List<JogoPlataformaEntity> precos) { this.precosPorPlataforma = precos; }
}
