/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
