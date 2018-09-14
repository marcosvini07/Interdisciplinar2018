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
import model.ProdutoDTO;
import util.ConnectionUtil;

/**
 *
 * @author vini1
 */
public class ProdutoDAO {
    Connection con;
    
    public ProdutoDAO() throws Exception {
        con = ConnectionUtil.getConnection();
    }
    
    public void save(ProdutoDTO pro){
        String SQL = "INSERT INTO CATEGORIA (DESCRICAO, VALOR, MARCA, COR, TIPO) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, pro.getDescricao());
            p.setDouble(2, pro.getValor());
            p.setString(3, pro.getMarca());
            p.setString(4, pro.getCor());
            p.setString(5, pro.getTipo());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(ProdutoDTO pro) {
        String SQL = "UPDATE PRODUTO SET DESCRICAO=?, VALOR=?,  WHERE ID_PRODUTO";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setString(1, pro.getDescricao());
            p.setDouble(2, pro.getValor());
            p.setInt(3, pro.getId_categoria().getId_categoria());
            p.setInt(4, pro.getId_produto());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(ProdutoDTO pro) {
        String SQL = "DELETE FROM PRODUTO WHERE ID_PRODUTO=?";
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, pro.getId_produto());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
