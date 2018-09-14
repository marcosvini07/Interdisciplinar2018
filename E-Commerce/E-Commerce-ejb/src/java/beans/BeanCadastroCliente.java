/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.ClienteDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.ClienteDTO;

/**
 *
 * @author vini1
 */
@Stateless
public class BeanCadastroCliente implements BeanCadastroClienteRemote, BeanCadastroClienteLocal {
    public boolean cadastroCliente (ClienteDTO cli){
        
        try {
            ClienteDAO cliDAO = new ClienteDAO();
            
            if(cli.getNome() == null || cli.getSobrenome() == null ||
                    ""+cli.getCpf() == null || cli.getEmail() == null){
                return false;
            }
            if (cli.getNome().trim().length() == 0 ||
                    cli.getSobrenome().trim().length() == 0 ||
                    cli.getId_cliente() == 0 || 
                    cli.getEmail().trim().length() == 0){
                
                return false;
            }
            
            cliDAO.save(cli);
        } catch (Exception ex) {
            Logger.getLogger(BeanCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}
