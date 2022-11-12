package lang.print.gaps.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdatedApp {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(UpdatedApp.class.getName());

        String message = "I'm updated\ncan be compiled. And can write to console\n";

        logger.log(Level.INFO, message);
    }
}
