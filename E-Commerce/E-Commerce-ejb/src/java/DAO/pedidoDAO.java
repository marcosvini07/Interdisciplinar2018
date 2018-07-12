
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;
import util.ConnectionUtil;

public class pedidoDAO {
    Connection con;
    public pedidoDAO() throws Exception {
        con = ConnectionUtil.getConnection();
    } 
   
   public void salvaPed (Pedido ped) {
        String SQL = "INSERT INTO PEDIDO VALUES (?, ?)";
    
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            
           p.setInt(1, ped.getId_pedido());
           p.setInt(2, ped.getId_produto().getId_produto());
           p.setInt(3, ped.getId_cliente().getId_cliente());
           
           p.execute(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(pedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }        
   public void upd (Pedido ped) {
        String SQL = "UPDATE CATEGORIA SET TIPO=? WHERE ID_PEDIDO=?";   
        
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, ped.getId_pedido());
            p.setInt(2, ped.getId_produto().getId_produto());
            p.setInt(3, ped.getId_cliente().getId_cliente());
            
            p.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    public void delete (Pedido ped) {
        String SQL = "DELETE FROM PEDIDO WHERE ID_PEDIDO=?";  
        try {
            PreparedStatement p = con.prepareStatement(SQL);
            p.setInt(1, ped.getId_pedido());
            
            p.execute();
        } catch (SQLException ex) {
            Logger.getLogger(pedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    public Pedido findById(int id){
        return new Pedido();
    }
    
    public List<Pedido> findAll() throws Exception {
        List<Pedido> list = new ArrayList<>();
        
        return list;
    }
    
}
