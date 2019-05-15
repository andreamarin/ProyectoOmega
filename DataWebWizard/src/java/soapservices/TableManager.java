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
import java.sql.DatabaseMetaData;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author andreamarin
 */
@WebService(serviceName = "TableManager")
@Stateless()
public class TableManager {
    private String filePath = "/Users/andreamarin/Desktop/ITAM/8semestre/ProyectosSD/ProyectoOmega/status.txt";
    
    /*-----------------------------------------------------------------------------------
    *
    *                               TABLE UPDATES
    *
    *------------------------------------------------------------------------------------*/
    
    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username, @WebParam(name = "fieldsStr") String fieldsStr) {
        String query_str = "";
        String db = "";
        String pswd = "";
        String status_code = ":)";
        Connection admin = null;
        Connection con = null;
        String[] fields = null;
        boolean res = false;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n"+dateFormat.format(date)+" CREATE TABLE");
        logger.println(fieldsStr);
        
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
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
            logger.println("Conexión exitosa");
            
            fields = fieldsStr.split(";");
            query_str = createQuery(fields, tableName);
            logger.println("Query: "+query_str);
            
            query = con.createStatement();
            query.executeUpdate(query_str);
            
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
            status_code = ex.getSQLState();
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
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
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(admin != null){
                try {
                    admin.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            logger.close();
        }
        
        
        
        return res;
    }
    
    @WebMethod(operationName = "insert")
    public boolean insert(@WebParam(name = "tableName") String tableName, @WebParam(name = "fields") String fields, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        int res = 0;
        
        Connection con = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n"+dateFormat.format(date)+" INSERT TABLE");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = con.createStatement();
            String query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
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
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return res != 0;
    }
    
    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "tableName") String tableName, @WebParam(name = "primarykey") String primarykey, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        int res = 0;
        
        Connection con = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n"+dateFormat.format(date)+ " DELETE FROM TABLE");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = con.createStatement();
            String query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
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
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return res != 0;
    }
    
    @WebMethod(operationName = "update")
    public boolean update(@WebParam(name = "tableName") String tableName, @WebParam(name = "fields") String fields, @WebParam(name = "primarykey") String primarykey, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        int res = 0;
        
        Connection con = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n" + dateFormat.format(date)+" UPDATE TABLE");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = con.createStatement();
            String query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
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
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return res != 0;
    }

    /*-----------------------------------------------------------------------------------
    *
    *                               TABLE QUERIES
    *
    *------------------------------------------------------------------------------------*/    
    
    @WebMethod(operationName = "consult")
    public String consult(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username){
        String db = "", pswd = "";
        String res = null;
        JSONObject json = new JSONObject();
        
        DateFormat dateFormat = new SimpleDateFormat("Fyyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        Connection con = null;
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            json.put("response", "error");
            res = json.toJSONString();
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n" + dateFormat.format(date) + " CONSULT TABLE");
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            Statement query = con.createStatement();
            String query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
            logger.println("Conexión exitosa a la bd: "+db);
            
            query = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            query_str = "SELECT * FROM " + tableName;
            
            rs = query.executeQuery(query_str);
            
            res = ResultSetToArray(rs, logger);
            
            logger.println(res.toString());
            logger.println("Éxito");
            
        } catch (ClassNotFoundException ex) {
            json.put("response", "error");
            res = json.toJSONString();
            
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            json.put("response", "error");
            res = json.toJSONString();
            
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    json.put("response", "error");
                    res = json.toJSONString();
            
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        return res;
    }
    
    @WebMethod(operationName = "getFields")
    public String getFields(@WebParam(name = "tableName") String tableName, @WebParam(name = "username") String username){
        String res = null;
        Connection con = null;
        
        JSONObject json = new JSONObject();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            json.put("response", "error");
            res = json.toJSONString();
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n" + dateFormat.format(date) + " GET FIELDS");
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            Statement query = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query_str = "SELECT NAME, TYPE, LENGTH, PRIMARYKEY FROM FIELDS "
                    + "WHERE USERNAME = '" + username + "' AND TABLE_NAME = '" + tableName + "'";
            
            logger.println(query_str);
            ResultSet rs = query.executeQuery(query_str);
            
            res = ResultSetToArray(rs, logger);
            logger.println("Éxito");
            con.close();
            
        } catch (ClassNotFoundException ex) {
            json.put("response", "error");
            res = json.toJSONString();
            
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        } catch (SQLException ex) {
            json.put("response", "error");
            res = json.toJSONString();
            
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    json.put("response", "error");
                    res = json.toJSONString();
                    
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return res;
    }
    
    @WebMethod(operationName = "getTables")
    public String getTables(@WebParam(name = "username") String username){
        String db = "", pswd = "";
        Connection con = null;
        
        JSONObject json = new JSONObject();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        PrintWriter logger = null;
        try {
            logger = new PrintWriter(new FileWriter(filePath,true));
        } catch (IOException ex) {
            json.put("response", "error");
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.println("\n" + dateFormat.format(date) + " GET TABLES");
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/admin","root","root");
            
            // get user's db name and password
            Statement query = con.createStatement();
            String query_str = "SELECT PASSWORD, DBNAME FROM USERS WHERE USERNAME = '"+username+"'";
            
            ResultSet rs = query.executeQuery(query_str);
            
            while(rs.next()){
                pswd = rs.getString("PASSWORD");
                db = username + "_" + rs.getString("DBNAME");
            }
            
            // Get table names
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db, username, pswd);
            logger.println("Conexión exitosa a la bd: "+db);
            
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});
            JSONArray tables = new JSONArray();
            while (res.next()) {
                tables.add(res.getString("TABLE_NAME"));
            }
            
            json.put("response", tables);
            
            logger.println("Éxito");
            
            res.close();
        } catch (SQLException ex) {
            json.put("response", "error");
            
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR SQLException "+ex);
            logger.println("ERROR CODE "+ex.getErrorCode());
            logger.println("ERROR STATE "+ex.getSQLState());
        } catch (ClassNotFoundException ex) {
            json.put("response", "error");
            
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
            logger.println("ERROR ClassNotFoundException "+ex);
        }finally{
            logger.close();
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    json.put("response", "error");
                    Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
                    logger.println("ERROR SQLException "+ex);
                    logger.println("ERROR CODE "+ex.getErrorCode());
                    logger.println("ERROR STATE "+ex.getSQLState());
                }
            }
        }
        return json.toJSONString();
    }
    
    /*-----------------------------------------------------------------------------------
    *
    *                               AUX FUNCTIONS
    *
    *------------------------------------------------------------------------------------*/
    
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
        tableName = tableName.toUpperCase();
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
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    private String ResultSetToArray(ResultSet rs, PrintWriter logger){
        JSONArray table = new JSONArray();
        String[] colNames;
        JSONObject response = new JSONObject();
        try{
            rs.last();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            int numRows = rs.getRow();
           
            colNames = new String[numCols];
           
            logger.println("Número de filas: " + numRows);
            logger.println("Número de columnas: " + numCols);
           
            if (numRows == 0){
               logger.println("Return null");
               response.put("response", "No tienes datos todavia.");
               return response.toJSONString();
            }
            
            for (int i = 1; i <= numCols; i++) {
                logger.println(rsmd.getColumnName(i)+ " " + i);
                colNames[i-1] = rsmd.getColumnName(i);
            }
            
            rs.beforeFirst();
            while(rs.next()){
                JSONObject row = new JSONObject();   
                for (int i = 0; i < numCols; i++) {
                    logger.println(colNames[i] + ": " + rs.getString(colNames[i]));
                    row.put(colNames[i],rs.getString(colNames[i]));
                }
                table.add(row);       
            }       
        }catch(Exception e){
            logger.println("ERROR: "+e);
            System.out.println(e);
            
            logger.close();
        }
        response.put("response", table);
        
        return response.toJSONString();
    }

}