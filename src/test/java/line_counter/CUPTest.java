package line_counter;

import parser.JavaCommentParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.createJavaCommentParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CUPTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/cup_tests");

  @Test public void SimpleCUPTest() {
    File inputFile = new File(TEST_DIRECTORY, "SimpleCUP.cup");
    try {
      JavaCommentParser parser = createJavaCommentParser(inputFile);
      assertEquals(6, parser.getBlankLines());
      assertEquals(6, parser.getCommentLines());
      assertEquals(6, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
