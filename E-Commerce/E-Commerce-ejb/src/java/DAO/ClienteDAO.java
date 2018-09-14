/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClienteDTO;
import util.ConnectionUtil;

/**
 *
 * @author vini1
 */
public class ClienteDAO {
    Connection con;
    
    public ClienteDAO() throws Exception {
        con = ConnectionUtil.getConnection();
    }
    
    public void save(ClienteDTO cli) {
        String SQL = "INSERT INTO CLIENTE (NOME, SOBRENOME, CPF, EMAIL) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, cli.getNome());
            p.setString(2, cli.getSobrenome());
            p.setInt(3, cli.getCpf());
            p.setString(4, cli.getEmail());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update (ClienteDTO cli) {
     String SQL="UPDATE CLIENTE SET NOME=?, SOBRENOME=?, CPF=?, EMAIL=? WHERE ID_CLIENTE=?";
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, cli.getNome());
            p.setString(2, cli.getSobrenome());
            p.setInt(3, cli.getCpf());
            p.setString(4, cli.getEmail());
            p.setInt(5, cli.getId_cliente());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void delet(ClienteDTO cli) {
     String SQL = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?"; 
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, cli.getId_cliente());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
     public ClienteDTO findById(int id) {
       return new ClienteDTO();
        
      }
      public List<ClienteDTO> findAll() throws Exception {
        List<ClienteDTO> list = new ArrayList<>();
        
        return list;
    }
    
}
