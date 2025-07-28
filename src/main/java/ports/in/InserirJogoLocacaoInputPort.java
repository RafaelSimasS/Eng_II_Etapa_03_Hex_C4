package ports.in;

import core.domain.model.Locacao;

public interface InserirJogoLocacaoInputPort {
    Locacao execute(Long locacaoId, Long jogoPlataformaId, int dias, int quantidade);
}
