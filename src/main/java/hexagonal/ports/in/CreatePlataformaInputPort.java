package hexagonal.ports.in;

import hexagonal.core.domain.model.Plataforma;

public interface CreatePlataformaInputPort {
    Plataforma execute(String nome);
}
