package LineCounter;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import antlr.AntlrLineCounterParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static LineCounter.Util.createAntlrParser;

public class AntlrTest {
  private static final File TEST_DIRECTORY = new File("src/test/resources/antlr_tests");

  @Test public void LexerGrammarTest() {
    File inputFile = new File(TEST_DIRECTORY, "LexerGrammar.g4");
    try {
      AntlrLineCounterParser parser = createAntlrParser(inputFile);
      assertEquals(5, parser.getBlankLines());
      assertEquals(0, parser.getCommentLines());
      assertEquals(10, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }

  @Test public void ParserGrammarTest() {
    File inputFile = new File(TEST_DIRECTORY, "ParserGrammar.g4");
    try {
      AntlrLineCounterParser parser = createAntlrParser(inputFile);
      assertEquals(14, parser.getBlankLines());
      assertEquals(7, parser.getCommentLines());
      assertEquals(33, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }

  @Test public void JavaDocComment() {
    File inputFile = new File(TEST_DIRECTORY, "JavaDocComment.g4");
    try {
      AntlrLineCounterParser parser = createAntlrParser(inputFile);
      assertEquals(3, parser.getBlankLines());
      assertEquals(3, parser.getCommentLines());
      assertEquals(3, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }

  @Test public void SpaceBeforeJavaDoc() {
    File inputFile = new File(TEST_DIRECTORY, "SpaceBeforeJavaDoc.g4");
    try {
      AntlrLineCounterParser parser = createAntlrParser(inputFile);
      assertEquals(2, parser.getBlankLines());
      assertEquals(3, parser.getCommentLines());
      assertEquals(3, parser.getCodeLines());
    } catch (IOException e) {
      fail("IOException when reading file: " + e.getMessage());
    }
  }
}
