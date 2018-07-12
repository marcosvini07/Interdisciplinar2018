
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
           p.setInt(2, ped.getId_produto());
           p.setInt(4, ped.getId_cliente());
        } catch (SQLException ex) {
            Logger.getLogger(pedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
