package model;


public class Pesquisa {
    private int id_pesquisa;
    private ProdutoDTO id_produto;

    public int getId_pesquisa() {
        return id_pesquisa;
    }

    public void setId_pesquisa(int id_pesquisa) {
        this.id_pesquisa = id_pesquisa;
    }

    public ProdutoDTO getId_produto() {
        return id_produto;
    }

    public void setId_produto(ProdutoDTO id_produto) {
        this.id_produto = id_produto;
    }
}
