package model;

public class Produto {
    private int id_produto;
    private String descricao;
    private String tipo;
    private String marca;
    private String cor;
    private double valor;
    private CategoriaDTO id_categoria;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public CategoriaDTO getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaDTO id_categoria) {
        this.id_categoria = id_categoria;
    }
}
