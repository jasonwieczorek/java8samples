package j.m.w.functionals;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;

/**
 * A simple consumer that can consume logs in a standardized way
 */
public class LogConsumer {

    private static final BiConsumer<String, String> loggerConsumer = (loggerName, message) ->  {
       Logger logger =  LogManager.getLogger(loggerName);
       logger.log(Level.INFO, message);
       return;
    };

    public static void log(String loggerName, String message) {
        loggerConsumer.accept(loggerName, message);
    }

    public static void log(String message) {
        loggerConsumer.accept("FileLogger", message);
    }
}
