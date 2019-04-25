/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapservices;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebService(serviceName = "ConsultTable")
@Stateless()
public class ConsultTable {
    
    @WebMethod(operationName = "consult")
    public Object[][] consult(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        Object[][] res = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter("/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt",true));
        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.println("======================================================================================================");
        logger.println("\n" + dateFormat.format(date) + "CONSULT TABLE");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection admin = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = admin.createStatement();
            String query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            Connection  con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
            logger.println("Conexión exitosa a la bd: "+db);
            
            query = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            query_str = "SELECT * FROM " + tableName;
            
            rs = query.executeQuery(query_str);
            
            res = ResultSetToArray(rs);
            
            admin.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateTable.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTable.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        }
        
        logger.close();
        return res;
    }
    
    private Object[][] ResultSetToArray(ResultSet rs){
        Object data[][]  = null;
        try{
           rs.last();
           ResultSetMetaData rsmd = rs.getMetaData();
           int numCols = rsmd.getColumnCount();
           int numRows = rs.getRow();
           data = new Object[numRows][numCols];
           
           int j = 0;
           rs.beforeFirst();
           while(rs.next()){
               for (int i = 0; i < numCols; i++) {
                   data[j][i] = rs.getObject(i+1);
               }
               j++;
           }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return data;
    }

}
