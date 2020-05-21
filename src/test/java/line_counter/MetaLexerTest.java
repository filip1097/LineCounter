package line_counter;

import antlr.MetaLexerLineCounterParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.createMetaLexerParser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MetaLexerTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/metalexer_tests");

  @Test public void SimpleTest() {
    File inputFile = new File(TEST_DIRECTORY, "simple.mlc");
    try {
      MetaLexerLineCounterParser parser = createMetaLexerParser(inputFile);
      assertEquals(8, parser.getBlankLines());
      assertEquals(9, parser.getCommentLines());
      assertEquals(8, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
