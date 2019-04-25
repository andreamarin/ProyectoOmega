/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author andreamarin
 */
@WebService(serviceName = "Login")
@Stateless()
public class Login {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "username") String username,  @WebParam(name = "password") String password) {
        boolean res = false;
        int count = -1;
        Connection con = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = con.createStatement();
            String query_str = "SELECT COUNT (*) FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD =  '" + password + "'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                count = rs.getInt(1);
            }
            
            if (count > 0){
                res =  true;
            }
            
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return res;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "signup")
    public boolean signup(@WebParam(name = "username") String username, @WebParam(name = "name") String name, @WebParam(name = "password") String password) {
        boolean res = false;
        int count  = -1;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = con.createStatement();
            String query_str = "INSERT into USERS values('"
                        + username +"', '"
                        + name + "', '"
                        + password + "')";
            
            int rs = query.executeUpdate(query_str);
            
            if(rs != 0){
                res = true;
                String db = "jdbc:derby://localhost:1527/" + username + ";create=true";
                Connection new_db = DriverManager.getConnection(db,username,password);
                new_db.close();
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return res;
        }
    }
}
