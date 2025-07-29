package hexagonal.adapters.out.repositories.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_locacao")
public class ItemLocacaoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jogoPlataformaId;
    private int dias;
    private int quantidade;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJogoPlataformaId() {
        return jogoPlataformaId;
    }

    public void setJogoPlataformaId(Long jogoPlataformaId) {
        this.jogoPlataformaId = jogoPlataformaId;
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
