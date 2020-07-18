package line_counter;

import org.junit.Test;
import parser.XMLCommentParser;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.createXMLCommentParser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class XMLTests {
  private static final File TEST_DIRECTORY = new File("src/test/resources/xml_tests");

  @Test public void XMLTest() {
    File inputFile = new File(TEST_DIRECTORY, "XMLTest.xml");
    try {
      XMLCommentParser parser = createXMLCommentParser(inputFile);
      assertEquals(2, parser.getBlankLines());
      assertEquals(8, parser.getCommentLines());
      assertEquals(9, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
