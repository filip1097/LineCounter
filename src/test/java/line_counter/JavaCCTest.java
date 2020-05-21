package line_counter;

import parser.JavaCCLineCounterParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.createJavaCCParser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JavaCCTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/javacc_tests");

  @Test public void CommentTest() {
    File inputFile = new File(TEST_DIRECTORY, "Comment.jjt");
    try {
      JavaCCLineCounterParser parser = createJavaCCParser(inputFile);
      assertEquals(6, parser.getBlankLines());
      assertEquals(8, parser.getCommentLines());
      assertEquals(16, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
