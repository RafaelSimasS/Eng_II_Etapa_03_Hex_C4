package core.domain.model;

import java.time.LocalDateTime;

public class UtilizacaoConsole {
    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Cliente cliente;
    private Console console;

    public UtilizacaoConsole(Long id, LocalDateTime inicio, LocalDateTime fim, Cliente cliente, Console console) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.cliente = cliente;
        this.console = console;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}
