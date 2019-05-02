/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returns;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andreamarin
 */
@XmlRootElement(name = "rest-response")
public class Response {
    private boolean res;
    
    public Response(boolean res){
        this.res = res;
    }
    
    public Response(){
        
    }

    @XmlElement(name = "result")
    public boolean getRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }
}
