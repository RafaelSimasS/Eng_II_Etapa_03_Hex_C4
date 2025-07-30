package hexagonal.core.domain.usecase;

import hexagonal.core.domain.service.ClienteService;
import hexagonal.ports.in.DeleteClienteInputPort;

public class DeleteClienteUseCase implements DeleteClienteInputPort {
    private final ClienteService service;

    public DeleteClienteUseCase(ClienteService service) {
        this.service = service;
    }

    @Override
    public void execute(Long id) {
        service.delete(id);
    }

}
