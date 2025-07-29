package hexagonal.adapters.out.repositories.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plataformas")
public class PlataformaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "plataformaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JogoPlataformaEntity> precosDeJogos = new ArrayList<>();

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<JogoPlataformaEntity> getPrecosDeJogos() { return precosDeJogos; }
    public void setPrecosDeJogos(List<JogoPlataformaEntity> precos) { this.precosDeJogos = precos; }
}
