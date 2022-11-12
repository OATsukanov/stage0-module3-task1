package lang.print.gaps.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BrokenApp {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(BrokenApp.class.getName());

        String message = "fixMe\n";

        logger.log(Level.INFO, message);

    }
}
