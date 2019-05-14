/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:LoginResource [login]<br>
 * USAGE:
 * <pre>
 *        RestLogInClient client = new RestLogInClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Luis Landa
 */
public class RestLogInClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/DataWebWizard/webresources";

    public RestLogInClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("login");
    }

    public returns.Response login(String user, String pass) throws ClientErrorException {
        Form form = new Form();
        form.param("username", user);
        form.param("password", pass);
        Response resp = webTarget.request().post(Entity.form(form));
        returns.Response body = resp.readEntity(returns.Response.class);
        resp.close();
        return body;
    }
    
        public returns.Response signup(String user, String pass, String name, String dbName) throws ClientErrorException {
        Form form = new Form();
        form.param("username", user);
        form.param("password", pass);
        form.param("name", name);
        form.param("dbName", dbName);
        Response resp = webTarget.request().put(Entity.form(form));
        returns.Response body = resp.readEntity(returns.Response.class);
        resp.close();
        return body;
    }

    public void close() {
        client.close();
    }
    
}
