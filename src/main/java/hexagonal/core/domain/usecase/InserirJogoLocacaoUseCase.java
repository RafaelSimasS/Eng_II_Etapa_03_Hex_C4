package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Locacao;
import hexagonal.core.domain.service.LocacaoService;
import ports.in.InserirJogoLocacaoInputPort;


public class InserirJogoLocacaoUseCase implements InserirJogoLocacaoInputPort {
    private final LocacaoService servico;

    public InserirJogoLocacaoUseCase(LocacaoService servico) {
        this.servico = servico;
    }

    @Override
    public Locacao execute(Long locacaoId,
                           Long jogoPlataformaId,
                           int dias,
                           int quantidade) {
        return servico.adicionarJogoALocacao(locacaoId, jogoPlataformaId, dias, quantidade);
    }
}
