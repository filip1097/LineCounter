package LineCounter;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import antlr.LineCounterParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static LineCounter.Util.createAntlrParser;

public class AntlrTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/antlr");

  @Test public void AntlrLineCounterLexerTest() {
    File inputFile = new File(TEST_DIRECTORY, "AntlrLineCounterLexer.g4");
    try {
      LineCounterParser parser = createAntlrParser(inputFile);
      assertEquals(5, parser.getBlankLines());
      assertEquals(0, parser.getCommentLines());
      assertEquals(10, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }

  @Test public void LineCounterParserTest() {
    File inputFile = new File(TEST_DIRECTORY, "LineCounterParser.g4");
    try {
      LineCounterParser parser = createAntlrParser(inputFile);
      assertEquals(14, parser.getBlankLines());
      assertEquals(7, parser.getCommentLines());
      assertEquals(33, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
