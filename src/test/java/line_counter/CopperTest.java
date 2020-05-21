package line_counter;

import parser.CUPLineCounterParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.createCUPParser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CopperTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/copper_tests");

  @Test public void SimpleCUPTest() {
    File inputFile = new File(TEST_DIRECTORY, "Simple.cpr");
    try {
      CUPLineCounterParser parser = createCUPParser(inputFile);
      assertEquals(7, parser.getBlankLines());
      assertEquals(5, parser.getCommentLines());
      assertEquals(9, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
