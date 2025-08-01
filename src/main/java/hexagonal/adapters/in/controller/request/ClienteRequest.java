package hexagonal.adapters.in.controller.request;

public class ClienteRequest {
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public ClienteRequest() {}

    // getters & setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
