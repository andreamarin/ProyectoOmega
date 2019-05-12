
package soapclients;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapclients package. 
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

    private final static QName _Login_QNAME = new QName("http://soapservices/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://soapservices/", "loginResponse");
    private final static QName _Signup_QNAME = new QName("http://soapservices/", "signup");
    private final static QName _SignupResponse_QNAME = new QName("http://soapservices/", "signupResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapclients
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Login_Type }
     * 
     */
    public Login_Type createLogin_Type() {
        return new Login_Type();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Signup }
     * 
     */
    public Signup createSignup() {
        return new Signup();
    }

    /**
     * Create an instance of {@link SignupResponse }
     * 
     */
    public SignupResponse createSignupResponse() {
        return new SignupResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "login")
    public JAXBElement<Login_Type> createLogin(Login_Type value) {
        return new JAXBElement<Login_Type>(_Login_QNAME, Login_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Signup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "signup")
    public JAXBElement<Signup> createSignup(Signup value) {
        return new JAXBElement<Signup>(_Signup_QNAME, Signup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservices/", name = "signupResponse")
    public JAXBElement<SignupResponse> createSignupResponse(SignupResponse value) {
        return new JAXBElement<SignupResponse>(_SignupResponse_QNAME, SignupResponse.class, null, value);
    }

}
