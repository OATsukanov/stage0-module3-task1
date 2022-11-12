package lang.print.gaps.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintSentenceApp {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(PrintSentenceApp.class.getName());

        String message = "This is my first Java program\n";

        logger.log(Level.INFO, message);

    }
}
