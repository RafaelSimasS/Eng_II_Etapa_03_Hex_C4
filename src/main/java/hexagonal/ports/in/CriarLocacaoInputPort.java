package hexagonal.ports.in;

import hexagonal.core.domain.model.Locacao;

import java.time.LocalDate;

public interface CriarLocacaoInputPort {
    Locacao execute(Long clienteId, LocalDate dataLocacao);
}
