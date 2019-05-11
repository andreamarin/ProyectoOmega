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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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

    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Response create(@FormParam("tableName")String tableName, @FormParam("username")String username, @FormParam("fields")String fields){
        create.CreateTable_Service service = new create.CreateTable_Service();
        create.CreateTable port = service.getCreateTablePort();
        return new Response(port.create(tableName, username, fields));
    }
    
    @PUT
    @Produces("application/json")
    public String insert(@FormParam("tableName")String tableName, @FormParam("fields")String fields,  @FormParam("username")String username){
        soapupdate.UpdateTable port = getPort();
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("response", port.insert(tableName, fields, username));
        return jsonResponse.toString();
    }

    private static soapupdate.UpdateTable getPort() {
        soapupdate.UpdateTable_Service service = new soapupdate.UpdateTable_Service();
        soapupdate.UpdateTable port = service.getUpdateTablePort();
        return port;
    }
    

}
