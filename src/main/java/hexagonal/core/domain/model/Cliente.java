package hexagonal.core.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private List<Locacao> locacoes = new ArrayList<>();
    private List<UtilizacaoConsole> utilizacoes = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Cliente(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Cliente(Long id, String nome, String email, String telefone, String senha, List<Locacao> locacoes, List<UtilizacaoConsole> utilizacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.locacoes = locacoes;
        this.utilizacoes = utilizacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public List<UtilizacaoConsole> getUtilizacoes() {
        return utilizacoes;
    }

    public void setUtilizacoes(List<UtilizacaoConsole> utilizacoes) {
        this.utilizacoes = utilizacoes;
    }
}
