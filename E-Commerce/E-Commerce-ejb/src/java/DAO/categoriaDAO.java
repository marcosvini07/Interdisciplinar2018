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
import model.categoria;
import util.ConnectionUtil;


/**
 *
 * @author vini1
 */
public class categoriaDAO {
    Connection con;
    
    public categoriaDAO() throws Exception {
        con = ConnectionUtil.getConnection();
    } 
    
    public void salvaCat (categoria ca) {
        String SQL = "INSERT INTO CATRGORIA VALUES (?, ?)";
    
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, ca.getTipo());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void upd (categoria ca) {
        String SQL = "UPDATE CATEGORIA SET TIPO=? WHERE ID_CATEGORIA=?";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, ca.getTipo());
            p.setInt(2, ca.getId_categoria());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(categoria ca){
        String SQL = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA=?";
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, ca.getId_categoria());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public categoria findById(int id){
        return new categoria();
    }
    
    public List<categoria> findAll() throws Exception {
        List<categoria> list = new ArrayList<>();
        
        return list;
    }
   
}
