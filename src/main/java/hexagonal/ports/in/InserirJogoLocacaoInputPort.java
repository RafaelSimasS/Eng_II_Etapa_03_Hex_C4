package ports.in;

import hexagonal.core.domain.model.Locacao;

public interface InserirJogoLocacaoInputPort {
    Locacao execute(Long locacaoId, Long jogoPlataformaId, int dias, int quantidade);
}
