/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservices;

import javax.ws.rs.POST;
import returns.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author andreamarin
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }
    
    
    /**
     * Retrieves representation of an instance of restservices.LoginResource
     * @return an instance of java.lang.String
     */
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Response login(@FormParam("username")String username, @FormParam("password")String password) {
        soapclients.Login_Service service = new soapclients.Login_Service();
        soapclients.Login port = service.getLoginPort();
        return new Response(port.login(username, password));
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public Response signup(@FormParam("username")String username, @FormParam("password")String password, @FormParam("dbName")String dbName, @FormParam("name")String name) {
        soapclients.Login_Service service = new soapclients.Login_Service();
        soapclients.Login port = service.getLoginPort();
        return new Response(port.signup(username, name, password, dbName));
    }

}
