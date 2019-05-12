
package deffffsoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the deffffsoap package. 
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
    private final static QName _GetFields_QNAME = new QName("http://soapservices/", "getFields");
    private final static QName _GetFieldsResponse_QNAME = new QName("http://soapservices/", "getFieldsResponse");
    private final static QName _Operation_QNAME = new QName("http://soapservices/", "operation");
    private final static QName _OperationResponse_QNAME = new QName("http://soapservices/", "operationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: deffffsoap
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
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link HashMap }
     * 
     */
    public HashMap createHashMap() {
        return new HashMap();
    }

    /**
     * Create an instance of {@link StringArray }
     * 
     */
    public StringArray createStringArray() {
        return new StringArray();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "operationResponse")
    public JAXBElement<OperationResponse> createOperationResponse(OperationResponse value) {
        return new JAXBElement<OperationResponse>(_OperationResponse_QNAME, OperationResponse.class, null, value);
    }

}
