/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapservices;

/**
 *
 * @author andreamarin
 */
public class QueryResult{
    private Object[][] response;
    
    public QueryResult(){
        
    }
    
    public void setResponses(Object[][] response){
        this.response = response;
    }

    public Object[][] getResponse() {
        return response;
    }
    
}

