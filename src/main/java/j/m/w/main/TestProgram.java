package j.m.w.main;

import j.m.w.functionals.LogConsumer;
import j.m.w.functionals.RandomGameSupplier;

import java.util.Arrays;

public class TestProgram {

    public static void main(String args[]) {

        LogConsumer.log( "im a message");
        LogConsumer.log( "im a message");
        LogConsumer.log( "im a message");
        LogConsumer.log( "im a message");

        LogConsumer.log("org.apache.logging.log4j.test2", "im a message");

    }
}
