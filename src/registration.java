
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class registration {
    
    conn con = new conn();
     public int register(String Firstname,String Lastname,String username, String Password){
        int r = 0;
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);
             
              String sql = "insert into register  values(null,?,md5(?),?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            pstmt.setString(1, username);
             pstmt.setString(2, Password);
             pstmt.setString(3, Lastname);
              pstmt.setString(4, Firstname);
              
               r = pstmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    return r;
     }}
     

