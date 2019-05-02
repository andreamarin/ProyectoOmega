/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:LoginResource [login]<br>
 * USAGE:
 * <pre>
 *        RESTfulClient client = new RESTfulClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author andreamarin
 */
public class RESTfulClient {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/DataWebWizard/webresources";

    public RESTfulClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("login");
    }

    public <T> T login(Class<T> responseType) throws ClientErrorException {
        return webTarget.request().post(null, responseType);
    }

    public void close() {
        client.close();
    }
    
}
