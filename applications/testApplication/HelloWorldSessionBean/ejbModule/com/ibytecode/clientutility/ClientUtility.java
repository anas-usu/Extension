package com.ibytecode.clientutility;
 
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
public class ClientUtility {
 
    private static Context initialContext;
 
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
            properties.put("jboss.naming.client.ejb.context", true);
            properties.put(Context.PROVIDER_URL,"remote://127.0.0.1:4447");  
            properties.put(Context.SECURITY_PRINCIPAL, "ManagementRealm");
            properties.put(Context.SECURITY_CREDENTIALS, "godanas2005!");
 
            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }
}