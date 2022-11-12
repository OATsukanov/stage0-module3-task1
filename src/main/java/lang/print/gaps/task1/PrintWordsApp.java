package lang.print.gaps.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintWordsApp {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(PrintWordsApp.class.getName());

        String message = "java\nis\nsmth\n";

        logger.log(Level.INFO, message);

    }
}
