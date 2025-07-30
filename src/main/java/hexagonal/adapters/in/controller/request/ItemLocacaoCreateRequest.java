package hexagonal.adapters.in.controller.request;

public class ItemLocacaoCreateRequest {
    private Long jogoPlataformaId;
    private int dias;

    public ItemLocacaoCreateRequest() {}

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
}
