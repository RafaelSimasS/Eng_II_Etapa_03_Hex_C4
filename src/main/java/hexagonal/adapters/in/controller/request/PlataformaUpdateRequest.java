package hexagonal.adapters.in.controller.request;

public class PlataformaUpdateRequest {
    private String novoNome;

    public PlataformaUpdateRequest() {}

    public String getNovoNome() { return novoNome; }
    public void setNovoNome(String novoNome) { this.novoNome = novoNome; }
}
