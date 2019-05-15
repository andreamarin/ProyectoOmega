/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:TableManagerResource
 * [tableManager]<br>
 * USAGE:
 * <pre>
 *        QueryAdmin client = new QueryAdmin();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author andreamarin
 */
public class QueryAdmin {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/DataWebWizard/webresources";

    public QueryAdmin() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("tableManager");
    }

    public <T> T update(Class<T> responseType, String fields, String tableName, String username, String primarykey) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (fields != null) {
            resource = resource.queryParam("fields", fields);
        }
        if (tableName != null) {
            resource = resource.queryParam("tableName", tableName);
        }
        if (username != null) {
            resource = resource.queryParam("username", username);
        }
        if (primarykey != null) {
            resource = resource.queryParam("primarykey", primarykey);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String insert() throws ClientErrorException {
        return webTarget.request().put(null, String.class);
    }

    public <T> T create(Class<T> responseType) throws ClientErrorException {
        return webTarget.request().post(null, responseType);
    }

    public <T> T delete(Class<T> responseType) throws ClientErrorException {
        return webTarget.request().delete(responseType);
    }

    public void close() {
        client.close();
    }
    
}
