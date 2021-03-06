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
 * Jersey REST client generated for REST resource:TableQuery [query]<br>
 * USAGE:
 * <pre>
 *        QueryClient client = new QueryClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author andreamarin
 */
public class QueryClient {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/DataWebWizard/webresources";

    public QueryClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("query");
    }

    public String getFields(String username, String tableName) throws ClientErrorException {
        Form form = new Form();
        form.param("tableName", tableName);
        form.param("username", username);
        Response resp = webTarget.request().post(Entity.form(form));
        String body = resp.readEntity(String.class);
        resp.close();
        return body;
    }

    public String getTable(String tableName, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (tableName != null) {
            resource = resource.queryParam("tableName", tableName);
        }
        if (username != null) {
            resource = resource.queryParam("username", username);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
