/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javax.ws.rs.client.Client;
import returns.Response;

/**
 *
 * @author andreamarin
 */
public class TestWS {
    private static final String URL ="http://localhost:8080/DataWebWizart/webresources/login";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RESTfulClient client = new RESTfulClient();
        Response res = client.login(null);
        System.out.println(res.getRes());
    }
    
}
