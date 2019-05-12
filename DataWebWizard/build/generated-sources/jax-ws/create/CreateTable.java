
package create;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CreateTable", targetNamespace = "http://soapservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CreateTable {


    /**
     * 
     * @param tableName
     * @param username
     * @param fieldsStr
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "create", targetNamespace = "http://soapservices/", className = "create.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://soapservices/", className = "create.CreateResponse")
    @Action(input = "http://soapservices/CreateTable/createRequest", output = "http://soapservices/CreateTable/createResponse")
    public boolean create(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "fields_str", targetNamespace = "")
        String fieldsStr);

}
