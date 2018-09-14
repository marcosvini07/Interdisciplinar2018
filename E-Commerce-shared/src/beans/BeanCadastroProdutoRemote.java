/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;
import model.ProdutoDTO;

/**
 *
 * @author vini1
 */
@Remote
public interface BeanCadastroProdutoRemote {
    public boolean cadastroProduto(ProdutoDTO pro);
}
