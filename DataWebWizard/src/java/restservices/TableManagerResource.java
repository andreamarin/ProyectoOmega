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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import returns.Response;

/**
 * REST Web Service
 *
 * @author andreamarin
 */
@Path("tableManager")
public class TableManagerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TableManagerResource
     */
    public TableManagerResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response update(@QueryParam("tableName")String tableName, @QueryParam("username")String username, @QueryParam("primarykey")String primarykey, @QueryParam("fields")String fields){
        tableclient.TableManager port = getPort();
        return new Response(port.update(tableName, fields, primarykey, username));
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    public Response delete(@FormParam("tableName")String tableName, @FormParam("username")String username, @FormParam("primarykey")String primarykey){
        tableclient.TableManager port = getPort();
        return new Response(port.delete(tableName, primarykey, username));
    }
    
    @PUT
    @Produces("application/json")
    public String insert(@FormParam("tableName")String tableName,@FormParam("fields")String fields, @FormParam("username")String username){
        tableclient.TableManager port = getPort();
        
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("response", port.insert(tableName, fields, username));
        
        return jsonResponse.toJSONString();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Response create(@FormParam("tableName")String tableName, @FormParam("username")String username, @FormParam("fieldsStr")String fieldsStr){
        tableclient.TableManager port = getPort();
        return new Response(port.create(tableName, username, fieldsStr));
    }
    
    private static tableclient.TableManager getPort() {
        tableclient.TableManager_Service service = new tableclient.TableManager_Service();
        tableclient.TableManager port = service.getTableManagerPort();
        return port;
    }

}
