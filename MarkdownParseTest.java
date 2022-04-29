import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    
    @Test
    public void test1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");

        assertEquals(expected, toReturn);
    }

    @Test
    public void test2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");

        assertEquals(expected, toReturn);
    }
}


