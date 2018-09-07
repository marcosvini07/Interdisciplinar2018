package model;

import java.io.Serializable;

public class PedidoDTO implements Serializable{
    private int id_pedido;
    private Produto id_produto;
    private ClienteDTO id_cliente;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    public ClienteDTO getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(ClienteDTO id_cliente) {
        this.id_cliente = id_cliente;
    }
}
