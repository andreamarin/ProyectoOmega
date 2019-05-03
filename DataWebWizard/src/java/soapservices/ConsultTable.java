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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author andreamarin
 */
@WebService(serviceName = "ConsultTable")
@Stateless()
public class ConsultTable {
    
    @WebMethod(operationName = "consult")
    public List<List<String>> consult(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        List<List<String>> res = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter("/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt",true));
        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.println("=================================================================================================");
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
            
            res = ResultSetToArray(rs, logger);
            logger.println(res.toString());
            logger.println("Éxito");
            
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
    
     @WebMethod(operationName = "getFields")
    public List<List<String>> getFields(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        List<List<String>> res = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter("/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt",true));
        } catch (IOException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.println("================================================================================================");
        logger.println("\n" + dateFormat.format(date) + "GET FIELDS");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection admin = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = admin.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query_str = "SELECT NAME, TYPE, LENGTH, PRIMARYKEY FROM FIELDS "
                    + "WHERE USERNAME = '" + username + "' AND TABLE_NAME = '" + tableName + "'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            res = ResultSetToArray(rs, logger);
            logger.println("Éxito");
            admin.close();
            
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
    
    private List<List<String>> ResultSetToArray(ResultSet rs, PrintWriter logger){
        List<List<String>> table = new ArrayList<>();
        String[] colNames;
        try{
            rs.last();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            int numRows = rs.getRow();
           
            colNames = new String[numCols];
           
            logger.println("Número de filas: " + numRows);
            logger.println("Número de columnas: " + numCols);
           
            if (numRows == 0){
               logger.print("Return null");
               return null;
            }
            
            List<String> header = new ArrayList<>();
            for (int i = 1; i <= numCols; i++) {
                logger.print(rsmd.getColumnName(i));
                 header.add(rsmd.getColumnName(i));
            }
            table.add(header);
            
            rs.beforeFirst();
            while(rs.next()){
                List<String> row = new ArrayList<>();   
               
                for (int i = 0; i < numCols; i++) {
                    row.add(rs.getObject(i+1).toString());
                }
                table.add(row);       
            }       
        }catch(Exception e){
            logger.println("ERROR: "+e);
            System.out.println(e);
        }
        
        return table;
    }

}
