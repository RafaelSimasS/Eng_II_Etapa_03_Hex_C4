package hexagonal.ports.in;

public interface DeleteClienteInputPort {
    void execute(Long id);
}
