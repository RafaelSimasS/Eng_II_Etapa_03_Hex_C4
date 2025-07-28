package ports.in;

import core.domain.model.Locacao;

import java.time.LocalDate;

public interface CriarLocacaoInputPort {
    Locacao execute(Long clienteId, LocalDate dataLocacao);
}
