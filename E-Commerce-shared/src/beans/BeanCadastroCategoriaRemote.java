/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import model.CategoriaDTO;

/**
 *
 * @author vini1
 */
public interface BeanCadastroCategoriaRemote {
    public boolean cadastroCategoria(CategoriaDTO cat);
}
