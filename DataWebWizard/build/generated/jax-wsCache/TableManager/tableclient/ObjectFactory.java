
package tableclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tableclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Consult_QNAME = new QName("http://soapservices/", "consult");
    private final static QName _ConsultResponse_QNAME = new QName("http://soapservices/", "consultResponse");
    private final static QName _Create_QNAME = new QName("http://soapservices/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://soapservices/", "createResponse");
    private final static QName _Delete_QNAME = new QName("http://soapservices/", "delete");
    private final static QName _DeleteResponse_QNAME = new QName("http://soapservices/", "deleteResponse");
    private final static QName _GetFields_QNAME = new QName("http://soapservices/", "getFields");
    private final static QName _GetFieldsResponse_QNAME = new QName("http://soapservices/", "getFieldsResponse");
    private final static QName _GetTables_QNAME = new QName("http://soapservices/", "getTables");
    private final static QName _GetTablesResponse_QNAME = new QName("http://soapservices/", "getTablesResponse");
    private final static QName _Insert_QNAME = new QName("http://soapservices/", "insert");
    private final static QName _InsertResponse_QNAME = new QName("http://soapservices/", "insertResponse");
    private final static QName _Update_QNAME = new QName("http://soapservices/", "update");
    private final static QName _UpdateResponse_QNAME = new QName("http://soapservices/", "updateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tableclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Consult }
     * 
     */
    public Consult createConsult() {
        return new Consult();
    }

    /**
     * Create an instance of {@link ConsultResponse }
     * 
     */
    public ConsultResponse createConsultResponse() {
        return new ConsultResponse();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link GetFields }
     * 
     */
    public GetFields createGetFields() {
        return new GetFields();
    }

    /**
     * Create an instance of {@link GetFieldsResponse }
     * 
     */
    public GetFieldsResponse createGetFieldsResponse() {
        return new GetFieldsResponse();
    }

    /**
     * Create an instance of {@link GetTables }
     * 
     */
    public GetTables createGetTables() {
        return new GetTables();
    }

    /**
     * Create an instance of {@link GetTablesResponse }
     * 
     */
    public GetTablesResponse createGetTablesResponse() {
        return new GetTablesResponse();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "consult")
    public JAXBElement<Consult> createConsult(Consult value) {
        return new JAXBElement<Consult>(_Consult_QNAME, Consult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "consultResponse")
    public JAXBElement<ConsultResponse> createConsultResponse(ConsultResponse value) {
        return new JAXBElement<ConsultResponse>(_ConsultResponse_QNAME, ConsultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFields }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "getFields")
    public JAXBElement<GetFields> createGetFields(GetFields value) {
        return new JAXBElement<GetFields>(_GetFields_QNAME, GetFields.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFieldsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "getFieldsResponse")
    public JAXBElement<GetFieldsResponse> createGetFieldsResponse(GetFieldsResponse value) {
        return new JAXBElement<GetFieldsResponse>(_GetFieldsResponse_QNAME, GetFieldsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTables }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "getTables")
    public JAXBElement<GetTables> createGetTables(GetTables value) {
        return new JAXBElement<GetTables>(_GetTables_QNAME, GetTables.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTablesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "getTablesResponse")
    public JAXBElement<GetTablesResponse> createGetTablesResponse(GetTablesResponse value) {
        return new JAXBElement<GetTablesResponse>(_GetTablesResponse_QNAME, GetTablesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

}
