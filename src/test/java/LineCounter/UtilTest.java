package LineCounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static LineCounter.Util.fileExtension;

public class UtilTest {

  @Test public void FileExtensionTest() {
    assertEquals("jjt", fileExtension("Comment.jjt"));
    assertEquals("g4", fileExtension("antlr.g4"));
  }

}
