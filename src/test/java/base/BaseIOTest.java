package base;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class BaseIOTest {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    protected final PrintStream originalOut = System.out;
    protected final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    protected void assertOutEquals(String expected) {
        assertEquals(expected, updateLineSpliterators(outContent.toString()));

    }

    protected String updateLineSpliterators (String initial) {
        return initial
                .replaceAll("(\n\r)|(\r\n)|(\r)", "\n");
    }

    protected void assertEqualsForLogger(Class loggerClass, String loggerInfo, String loggerName) {

        class TestAppender extends AppenderSkeleton {
            private final List<LoggingEvent> log = new ArrayList<>();

            @Override
            public boolean requiresLayout() {
                return false;
            }

            @Override
            protected void append(final LoggingEvent loggingEvent) {
                log.add(loggingEvent);
            }

            @Override
            public void close() {
            }

            public List<LoggingEvent> getLog() {
                return new ArrayList<>(log);
            }
        }

        final TestAppender appender = new TestAppender();
        final Logger logger = Logger.getRootLogger();
        logger.addAppender(appender);
        Logger.getLogger(loggerClass).info(loggerInfo);

        final List<LoggingEvent> log = appender.getLog();
        final LoggingEvent firstLogEntry = log.get(0);

        assertEquals(Level.INFO, firstLogEntry.getLevel());
        assertEquals(loggerInfo, firstLogEntry.getMessage());
        assertEquals(loggerName, firstLogEntry.getLoggerName());
    }
}
