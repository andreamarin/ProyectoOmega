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
@WebService(serviceName = "CreateTable")
@Stateless()
public class CreateTable {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username, @WebParam(name = "fields_str") String fields_str) {
        String query_str = "";
        String db = "";
        String pswd = "";
        String status_code = ":)";
        Connection admin = null;
        String[] fields = null;
        boolean res = false;
        
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
            admin = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = admin.createStatement();
            query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            logger.println("Base de datos: "+db);
            
            Connection  con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
            logger.println("Conexión exitosa");
            
            fields = fields_str.split(";");
            query_str = createQuery(fields, tableName);
            logger.println("Query: "+query_str);
            
            query = con.createStatement();
            query.executeUpdate(query_str);
            
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
            status_code = ex.getSQLState();
        }
        
        logger.close();
        
        try{
            if(!status_code.equals("XOY32") && !status_code.equals("42X01")){
                String n = insertFields(fields, tableName, username, admin);
                logger.println("FIELDS QUERYS");
                logger.println(n);
                admin.close();
                res =  true;
            }else{
                admin.close();
                res =  false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    private String createQuery(String[] fields, String name){
        String query = "CREATE TABLE " + name + "(";
        String values[];
        int n = fields.length;
        for (int i = 0; i < n; i++) {
            values = fields[i].split(",");
            
            if (values[2].equals("null")){
                query +=  values[0] + " " + values[1];
            }else{
                query += values[0] + " " + values[1] + "(" + values[2] + ")";
            }
            
            if (values[3].equals("1")){
                query += " NOT NULL PRIMARY KEY";
            }
            
            if (i != n-1){
                query += ",";
            }
        }
        
        query += ")";
        
        return query;
    }
    
    private String insertFields(String[] fields, String tableName, String username, Connection con){
        String res = "";
        try {
            String query = "";
            Statement stmnt = con.createStatement();
            String values[];
            for (String field : fields) {
                query = "INSERT INTO FIELDS VALUES(";
                values = field.split(",");
                query += "'" + values[0] + "',"
                        + "'" + values[1] + "',"
                        + "'" + tableName + "',"
                        + "'" + username + "',"
                        + values[2] + ","
                        + values[3] +")";
                res += query + "\n";
                stmnt.executeUpdate(query);
            }     
            
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }

}
