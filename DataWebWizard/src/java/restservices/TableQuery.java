/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservices;

//import definitivesoap.QueryResult;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import deffffsoap.HashMap;
import deffffsoap.StringArray;
import javax.ws.rs.QueryParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author andreamarin
 */
@Path("query/{tableName}/{username}")
public class TableQuery {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TableQuery
     */
    public TableQuery() {
    }

    /**
     * Retrieves representation of an instance of restservices.TableQuery
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getTable(@PathParam("tableName")String tableName, @PathParam("username")String username) {
        deffffsoap.ConsultTable_Service service = new deffffsoap.ConsultTable_Service();
        deffffsoap.ConsultTable port = service.getConsultTablePort();
        List<HashMap> response = port.consult(tableName, username);
        
        List<StringArray> r = port.operation();
        r.get(0);
        for (StringArray r1 : r) {
            List<String> r2 = r1.getItem();
            for (String r21 : r2) {
                
            }
        }
        
        /*
        definitivesoap.ConsultTable_Service service = new definitivesoap.ConsultTable_Service();
        definitivesoap.ConsultTable port = service.getConsultTablePort();
        
        JSONObject jsonResponse = new JSONObject();
        JSONArray table = new JSONArray(); 
        JSONObject row;
        
        QueryResult res = port.consult(tableName, username);
        
        Object[][] array = res.getResponse();
        
        int m = array.length;
        int n = array[0].length;
        
        for (int i = 1; i < m; i++) {
            row = new JSONObject();
            
            for (int j = 0; j < n; j++) {
                row.put(array[0][j].toString(), array[i][j].toString());
            }
            
           table.add(row);
        }
        
        jsonResponse.put("table", table);
        
        */
        return "";//jsonResponse.toString();
        
    }
    
    

    /**
     * PUT method for updating or creating an instance of TableQuery
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    private static java.util.List<deffffsoap.HashMap> consult(java.lang.String tableName, java.lang.String username) {
        deffffsoap.ConsultTable_Service service = new deffffsoap.ConsultTable_Service();
        deffffsoap.ConsultTable port = service.getConsultTablePort();
        return port.consult(tableName, username);
    }
    
    private JSONArray toJson(List<HashMap> list){
        JSONArray res = new JSONArray();
        for (HashMap l : list) {
            JSONObject row = new JSONObject();
           
        }
        
        return res;
    }
    
    
}
