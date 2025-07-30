package hexagonal.adapters.in.controller.request;

import java.time.LocalDate;

public class LocacaoCreateRequest {
    private Long clienteId;
    private LocalDate dataLocacao;

    public LocacaoCreateRequest() {}

    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }
    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }
}
