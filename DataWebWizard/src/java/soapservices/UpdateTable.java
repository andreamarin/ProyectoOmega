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
@WebService(serviceName = "UpdateTable")
@Stateless()
public class UpdateTable {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insert")
    public boolean insert(@WebParam(name = "tableName") String tableName, @WebParam(name = "fields") String fields, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        int res = 0;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter("/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt",true));
        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n"+dateFormat.format(date));
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
            query_str = "INSERT INTO " + tableName + " VALUES(";
            
            String[] fields_str = fields.split(";");
            
            for (int i = 0; i < fields_str.length; i++) {
                String[] values = fields_str[i].split(",");
                
                query_str += (values[1].equals("1")) ? "'" + values[0] + "'" : values[0];
                
                if(i < fields_str.length-1)
                    query_str += ",";
            }
            
            query_str += ")";
            logger.println(query_str);
            
            query = con.createStatement();
            
            res = query.executeUpdate(query_str);
            logger.println("RESPUESTA: "+res);
            
            con.commit();
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
        return res != 0;
    }
    
    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "tableName") String tableName, @WebParam(name = "primarykey") String primarykey, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        int res = 0;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter("/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt",true));
        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n"+dateFormat.format(date));
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
            String[] values = primarykey.split(",");
            
            query_str = "DELETE FROM " + tableName + " WHERE "+values[0]+"=";
            query_str += (values[2].equals("1")) ? "'" + values[1] + "'" : values[1];
            logger.println(query_str);
            
            query = con.createStatement();
            
            res = query.executeUpdate(query_str);
            logger.println("RESPUESTA: "+res);
            
            con.commit();
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
        return res != 0;
    }
    
    @WebMethod(operationName = "update")
    public boolean update(@WebParam(name = "tableName") String tableName, @WebParam(name = "fields") String fields, @WebParam(name = "primarykey") String primarykey, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        int res = 0;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter("/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt",true));
        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n" + dateFormat.format(date));
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
            query_str = "UPDATE " + tableName + " SET ";
            
            String[] fields_str = fields.split(";");
            String[] pk = primarykey.split(",");
            
            for (int i = 0; i < fields_str.length; i++) {
                String[] values = fields_str[i].split(",");
                
                query_str += values[0] +" = ";
                query_str += (values[2].equals("1")) ? "'" + values[1] + "'" : values[1];
                
                if(i < fields_str.length-1)
                    query_str += ",";
            }
            
            query_str += " WHERE " + pk[0] + " = ";
            query_str += (pk[2].equals("1")) ? "'" + pk[1] + "'" : pk[1];
            
            logger.println(query_str);
            
            query = con.createStatement();
            
            res = query.executeUpdate(query_str);
            logger.println("RESPUESTA: "+res);
            
            con.commit();
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
        return res != 0;
    }
}
