package hexagonal.adapters.in.controller.request;

public class LocacaoAddJogoRequest {
    private Long jogoPlataformaId;
    private int dias;
    private int quantidade;

    public LocacaoAddJogoRequest() {}

    public Long getJogoPlataformaId() {
        return jogoPlataformaId;
    }
    public void setJogoPlataformaId(Long jogoPlataformaId) {
        this.jogoPlataformaId = jogoPlataformaId;
    }

    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
