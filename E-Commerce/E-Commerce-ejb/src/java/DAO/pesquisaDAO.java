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
import model.Pesquisa;
import util.ConnectionUtil;

/**
 *
 * @author vini1
 */
public class pesquisaDAO {
    Connection con;
    
    public pesquisaDAO() throws Exception {
     con = ConnectionUtil.getConnection();
    }
    
    public void salvaPes (Pesquisa pe){
        String SQL = "INSERT INTO PESQUISA (ID_PESQUISA, ID_PRODUTO) VALUES (?, ?)";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, pe.getId_pesquisa());
            p.setInt(2, pe.getId_produto().getId_produto());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(pesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void upd (Pesquisa pe){
        String SQL = "UPDATE PESQUISA WHERE ID_PESQUISA=?, ID_PRODUTO=?";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, pe.getId_pesquisa());
            p.setInt(2, pe.getId_produto().getId_produto());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(pesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Pesquisa pe) {
        String SQL = "DELETE FROM PESQUISA WHERE ID_PESQUISA=?";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, pe.getId_pesquisa());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(pesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Pesquisa findById(int id) {
       return new Pesquisa();
        
      }
      public List<Pesquisa> findAll() throws Exception {
        List<Pesquisa> list = new ArrayList<>();
        
        return list;
    }
    
    
}
