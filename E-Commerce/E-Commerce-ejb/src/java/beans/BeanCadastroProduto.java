/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.CategoriaDTO;
import model.ProdutoDTO;

/**
 *
 * @author vini1
 */
@Stateless
public class BeanCadastroProduto implements BeanCadastroProdutoLocal, BeanCadastroProdutoRemote {
    
    public boolean cadastroProduto(ProdutoDTO pro) {
        
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            
            if(pro.getMarca() == null || pro.getCor() == null || pro.getTipo() == null || pro.getDescricao() == null ||
                    ""+pro.getValor() == null) {
                
                return false;
            } 
            if(pro.getMarca().trim().length() == 0 || 
                    pro.getCor().trim().length() == 0 ||
                    pro.getTipo().trim().length() == 0 ||
                    pro.getDescricao().trim().length() == 0 ||
                    pro.getValor() == 0){
                
                return false;
            }
            
            produtoDAO.save(pro);
        } catch (Exception ex) {
            Logger.getLogger(BeanCadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        // corrigir
        return true;
    }
}