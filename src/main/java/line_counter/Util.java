package line_counter;

import parser.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Util {

  public static JavaCommentParser createJavaCommentParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    JavaCommentLexer scanner = new JavaCommentLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    JavaCommentParser parser = new JavaCommentParser(tokens);
    parser.file();
    return parser;
  }

  public static String fileExtension(String filePath) {
    String[] splitPath = filePath.split("[.]");
    if (splitPath.length != 2) {
      throw new RuntimeException("Input path not valid: " + filePath + " " + splitPath.length);
    }
    return splitPath[1];
  }

  /**
   * Calculates the number of digits of {@code num}.
   * @param num
   * @return
   */
  public static int nDigits(int num) {
    if (Math.abs(num) < 10) {
      return 1;
    } else {
      return 1 + nDigits(num / 10);
    }
  }

}
