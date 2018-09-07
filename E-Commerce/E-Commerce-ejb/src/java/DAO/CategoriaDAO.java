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
import model.CategoriaDTO;
import util.ConnectionUtil;


/**
 *
 * @author vini1
 */
public class CategoriaDAO {
    Connection con;
    
    public CategoriaDAO() throws Exception {
        con = ConnectionUtil.getConnection();
    } 
    
    public void save (CategoriaDTO ca) {
        String SQL = "INSERT INTO CATEGORIA (MARCA, COR, TIPO) VALUES (?, ?, ?)";
    
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, ca.getMarca());
            p.setString(2, ca.getCor());
            p.setString(3, ca.getTipo());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update (CategoriaDTO ca) {
        String SQL = "UPDATE CATEGORIA SET TIPO=? WHERE ID_CATEGORIA=?";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, ca.getTipo());
            p.setInt(2, ca.getId_categoria());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(CategoriaDTO ca){
        String SQL = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA=?";
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, ca.getId_categoria());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CategoriaDTO findById(int id){
        return new CategoriaDTO();
    }
    
    public List<CategoriaDTO> findAll() throws Exception {
        List<CategoriaDTO> list = new ArrayList<>();
        
        return list;
    }
   
}
