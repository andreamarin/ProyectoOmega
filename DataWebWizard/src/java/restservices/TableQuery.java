/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author andreamarin
 */
@Path("query/{username}/{tableName}")
public class TableQuery {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TableQuery
     */
    public TableQuery() {
    }
    
    @GET
    @Produces("application/json")
    public String getTable(@PathParam("tableName")String tableName, @PathParam("username")String username) {
        tableclient.TableManager port = getPort();
        
        String res = port.consult(tableName, username);
        
        return res;
    }
      
    @POST
    @Produces("application/json")
    public String getFields(@PathParam("tableName")String tableName, @PathParam("username")String username){
        tableclient.TableManager port = getPort();
         
        String res = port.getFields(tableName, username);
         
        return res;
    }
    
    @PUT
    @Produces("application/json")
    public String dbTables(@PathParam("username")String username){
        tableclient.TableManager port = getPort();
         
        String res = port.getTables(username);
         
        return res;
    }

    private static tableclient.TableManager getPort() {
        tableclient.TableManager_Service service = new tableclient.TableManager_Service();
        tableclient.TableManager port = service.getTableManagerPort();
        return port;
    }
    
}
