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
import model.Produto;
import util.ConnectionUtil;

/**
 *
 * @author vini1
 */
public class produtoDAO {
    Connection con;
    
    public produtoDAO() throws Exception {
        con = ConnectionUtil.getConnection();
    }
    
    public void salvaPr(Produto pro){
        String SQL = "INSERT INTO PRODUTO (DESCRICAO, VALOR, ID_CATEGORIA) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, pro.getDescricao());
            p.setDouble(2, pro.getValor());
            p.setInt(3, pro.getId_categoria().getId_categoria());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void upd(Produto pro) {
        String SQL = "UPDATE PRODUTO SET DESCRICAO=?, VALOR=?, ID_CATEGORIA WHERE ID_PRODUTO";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, pro.getDescricao());
            p.setDouble(2, pro.getValor());
            p.setInt(3, pro.getId_categoria().getId_categoria());
            p.setInt(4, pro.getId_produto());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Produto pro) {
        String SQL = "DELETE FROM PRODUTO WHERE ID_PRODUTO=?";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, pro.getId_produto());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
