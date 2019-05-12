
package tableclient;

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
@WebService(name = "TableManager", targetNamespace = "http://soapservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TableManager {


    /**
     * 
     * @param fields
     * @param tableName
     * @param primarykey
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://soapservices/", className = "tableclient.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://soapservices/", className = "tableclient.UpdateResponse")
    @Action(input = "http://soapservices/TableManager/updateRequest", output = "http://soapservices/TableManager/updateResponse")
    public boolean update(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "fields", targetNamespace = "")
        String fields,
        @WebParam(name = "primarykey", targetNamespace = "")
        String primarykey,
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param tableName
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFields", targetNamespace = "http://soapservices/", className = "tableclient.GetFields")
    @ResponseWrapper(localName = "getFieldsResponse", targetNamespace = "http://soapservices/", className = "tableclient.GetFieldsResponse")
    @Action(input = "http://soapservices/TableManager/getFieldsRequest", output = "http://soapservices/TableManager/getFieldsResponse")
    public String getFields(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param tableName
     * @param primarykey
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delete", targetNamespace = "http://soapservices/", className = "tableclient.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://soapservices/", className = "tableclient.DeleteResponse")
    @Action(input = "http://soapservices/TableManager/deleteRequest", output = "http://soapservices/TableManager/deleteResponse")
    public boolean delete(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "primarykey", targetNamespace = "")
        String primarykey,
        @WebParam(name = "username", targetNamespace = "")
        String username);

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
    @RequestWrapper(localName = "create", targetNamespace = "http://soapservices/", className = "tableclient.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://soapservices/", className = "tableclient.CreateResponse")
    @Action(input = "http://soapservices/TableManager/createRequest", output = "http://soapservices/TableManager/createResponse")
    public boolean create(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "fields_str", targetNamespace = "")
        String fieldsStr);

    /**
     * 
     * @param fields
     * @param tableName
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insert", targetNamespace = "http://soapservices/", className = "tableclient.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://soapservices/", className = "tableclient.InsertResponse")
    @Action(input = "http://soapservices/TableManager/insertRequest", output = "http://soapservices/TableManager/insertResponse")
    public boolean insert(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "fields", targetNamespace = "")
        String fields,
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTables", targetNamespace = "http://soapservices/", className = "tableclient.GetTables")
    @ResponseWrapper(localName = "getTablesResponse", targetNamespace = "http://soapservices/", className = "tableclient.GetTablesResponse")
    @Action(input = "http://soapservices/TableManager/getTablesRequest", output = "http://soapservices/TableManager/getTablesResponse")
    public String getTables(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param tableName
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consult", targetNamespace = "http://soapservices/", className = "tableclient.Consult")
    @ResponseWrapper(localName = "consultResponse", targetNamespace = "http://soapservices/", className = "tableclient.ConsultResponse")
    @Action(input = "http://soapservices/TableManager/consultRequest", output = "http://soapservices/TableManager/consultResponse")
    public String consult(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "username", targetNamespace = "")
        String username);

}
