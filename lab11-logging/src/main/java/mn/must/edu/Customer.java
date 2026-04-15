package mn.must.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer {
    private static final Logger logger = LogManager.getLogger(Customer.class);
    private String email;

    public Customer(String email) { 
        this.email = email; 
    }

    public String getDomain() {
        // Оролтын утгыг DEBUG түвшинд логлох
        logger.debug("getDomain called with email={}", email); 
        
        if (email == null) {
            logger.warn("Email утга null байна!");
            return "N/A";
        }
        
        // Email-ээс домайн нэрийг салгаж авах
        return email.substring(email.indexOf("@") + 1).toUpperCase();
    }

    public static void main(String[] args) {
        // Тэст хийх зорилгоор null утга дамжуулж байна
        Customer c1 = new Customer(null);
        try {
            String domain = c1.getDomain();
            System.out.println("Domain: " + domain);
        } catch (Exception e) {
            // Алдааг ERROR түвшинд логлох
            logger.error("Алдаа гарлаа: ", e);
        }
    }
}