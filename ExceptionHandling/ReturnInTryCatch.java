package ExceptionHandling;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Return in try catch.
 */
public class ReturnInTryCatch {

    /**
     * The constant log.
     */
    public static Logger log = Logger.getLogger("ExceptionHandling.ReturnInTryCatch");

    /**
     * Exception boolean.
     *
     * @return the boolean
     */
    public boolean exception() {
        try {
            throw new Exception("EXCEPTION");
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage());
        } finally {
            log.log(Level.INFO, "Finally block.");
        }
        return false;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ReturnInTryCatch exc = new ReturnInTryCatch();
        exc.exception();
    }
}
