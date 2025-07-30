package hexagonal.core.domain.service;

import hexagonal.core.domain.model.Jogo;
import hexagonal.core.domain.model.JogoPlataforma;
import hexagonal.core.domain.model.Plataforma;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;
import hexagonal.ports.out.JogoRepositoryPort;
import hexagonal.ports.out.PlataformaRepositoryPort;

import java.util.Optional;

public class JogoPlataformaService {
    private final JogoRepositoryPort jogoRepo;
    private final PlataformaRepositoryPort plataformaRepo;
    private final JogoPlataformaRepositoryPort assocRepo;

    public JogoPlataformaService(JogoRepositoryPort jogoRepo,
                                 PlataformaRepositoryPort plataformaRepo,
                                 JogoPlataformaRepositoryPort assocRepo) {
        this.jogoRepo = jogoRepo;
        this.plataformaRepo = plataformaRepo;
        this.assocRepo = assocRepo;
    }

    public JogoPlataforma create(Long plataformaId, String tituloJogo, java.math.BigDecimal precoDiario) {
        Plataforma plt = plataformaRepo.findById(plataformaId)
                .orElseThrow(() -> new IllegalArgumentException("Plataforma não encontrada: " + plataformaId));

        // verifica se Jogo existe por título
        Optional<Jogo> maybe = jogoRepo.findByTitulo(tituloJogo);
        Jogo jogo = maybe.orElseGet(() -> jogoRepo.save(new Jogo(null, tituloJogo)));

        JogoPlataforma jp = new JogoPlataforma(jogo, plt, precoDiario);
        return assocRepo.save(jp);
    }

    public Optional<JogoPlataforma> get(Long id) {
        return assocRepo.findById(id);
    }

    public JogoPlataforma update(Long id, java.math.BigDecimal novoPreco) {
        JogoPlataforma jp = assocRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Associação não encontrada: " + id));
        jp.setPrecoDiario(novoPreco);
        return assocRepo.save(jp);
    }

    public void delete(Long id) {
        assocRepo.deleteById(id);
    }
}
