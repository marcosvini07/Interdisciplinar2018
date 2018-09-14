/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;
import model.ClienteDTO;

/**
 *
 * @author vini1
 */
@Remote
public interface BeanCadastroClienteRemote {
    public boolean cadastroCliente (ClienteDTO cli);
}
