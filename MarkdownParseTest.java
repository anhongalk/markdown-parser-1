import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

        }

        return toReturn;
    }


    public static String LinksToString(String file) throws IOException {
        Path fileName = Path.of(file);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        return links.toString();
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    String expected = "[https://something.com, some-thing.html]";

    @Test
    public void getLinksTest1() throws IOException {
        assertEquals(expected, LinksToString("test-file.md"));
    }

    @Test
    public void getLinksTest2() throws IOException {
        assertEquals(expected, LinksToString("test-file3.md"));
    }


}


