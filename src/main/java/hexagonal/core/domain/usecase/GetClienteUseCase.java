package hexagonal.core.domain.usecase;

import hexagonal.core.domain.model.Cliente;
import hexagonal.core.domain.service.ClienteService;
import hexagonal.ports.in.GetClienteInputPort;


import java.util.Optional;

public class GetClienteUseCase implements GetClienteInputPort {
    private final ClienteService service;

    public GetClienteUseCase(ClienteService service) {
        this.service = service;
    }

    @Override
    public Optional<Cliente> execute(Long id) {
        return service.getById(id);
    }
}
