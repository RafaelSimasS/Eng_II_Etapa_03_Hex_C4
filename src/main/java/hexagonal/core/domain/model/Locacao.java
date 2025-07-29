package hexagonal.core.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Locacao {
    private Long id;
    private LocalDate data;
    private Cliente cliente;
    private List<ItemLocacao> itens = new ArrayList<>();

    public Locacao(Cliente cliente, LocalDate data) {
        this.cliente = cliente;
        this.data = data;
    }

    public Locacao(Cliente cliente, LocalDate data, List<ItemLocacao> itens) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
    }
    public void addItem(ItemLocacao item) {
        // aqui você pode validar, por exemplo, se o mesmo jogo já existe…
        itens.add(item);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemLocacao> getItens() {
        return itens;
    }

    public void setItens(List<ItemLocacao> itens) {
        this.itens = itens;
    }
}
