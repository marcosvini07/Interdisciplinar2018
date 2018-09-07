/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.CategoriaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.CategoriaDTO;

/**
 *
 * @author vini1
 */
@Stateless
public class BeanCadastroCategoria implements BeanCadastroCategoriaLocal, BeanCadastroCategoriaRemote {
    public boolean cadastroCategoria(CategoriaDTO cat) {
        
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            
            if(cat.getMarca() == null || cat.getCor() == null || cat.getTipo() == null) {
                
                return false;
            } 
            if(cat.getMarca().trim().length() == 0 || 
                    cat.getCor().trim().length() == 0 ||
                    cat.getTipo().trim().length() == 0){
                
                return false;
            }
            
            categoriaDAO.save(cat);
        } catch (Exception ex) {
            Logger.getLogger(BeanCadastroCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        // corrigir
        return true;
    }
}
