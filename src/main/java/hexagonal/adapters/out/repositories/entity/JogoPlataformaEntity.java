package hexagonal.adapters.out.repositories.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "jogos_plataforma")
public class JogoPlataformaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogo_id")
    private JogoEntity jogoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plataforma_id")
    private PlataformaEntity plataformaEntity;

    private BigDecimal precoDiario;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public JogoEntity getJogoEntity() { return jogoEntity; }
    public void setJogoEntity(JogoEntity jogoEntity) { this.jogoEntity = jogoEntity; }

    public PlataformaEntity getPlataformaEntity() { return plataformaEntity; }
    public void setPlataformaEntity(PlataformaEntity plataformaEntity) { this.plataformaEntity = plataformaEntity; }

    public BigDecimal getPrecoDiario() { return precoDiario; }
    public void setPrecoDiario(BigDecimal precoDiario) { this.precoDiario = precoDiario; }
}
