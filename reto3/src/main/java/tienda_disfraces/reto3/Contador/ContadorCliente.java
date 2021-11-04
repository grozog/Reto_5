package tienda_disfraces.reto3.Contador;



import tienda_disfraces.reto3.modelo.Cliente;

public class ContadorCliente {

    private Long total;
    private Cliente client;
    public ContadorCliente(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }




}
