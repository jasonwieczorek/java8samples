package j.m.w.functionals;

import j.m.w.functionals.LogConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// refer to src/test/resources for the log42.xml file
public class LogConsumerTest {

    private final Path appenderFIle = Paths.get("C:\\Users\\wiecz\\IdeaProjects\\Java8\\target\\Application.log");

    @BeforeEach
    public void beforeEach() throws IOException {

        Files.deleteIfExists(appenderFIle);
    }

    @Test
    public void testDefaultLogConsumerAppendsToFile() throws IOException {

        LogConsumer.log( "testing things");
        List<String> lines = Files.readAllLines(appenderFIle);
        Assertions.assertEquals(1, lines.size());
        Assertions.assertTrue(lines.get(0).contains("testing things"));
    }
}
