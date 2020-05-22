package line_counter;

import parser.JavaCommentParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.createJavaCommentParser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JFlexTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/jflex_tests");

  @Test public void SimpleScannerTest() {
    File inputFile = new File(TEST_DIRECTORY, "SimpleScanner.flex");
    try {
      JavaCommentParser parser = createJavaCommentParser(inputFile);
      assertEquals(13, parser.getBlankLines());
      assertEquals(8, parser.getCommentLines());
      assertEquals(14, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }

}
