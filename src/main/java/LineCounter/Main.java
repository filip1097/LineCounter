package LineCounter;

import antlr.JavaCCLineCounterParser;

import java.io.File;
import java.io.IOException;

import static LineCounter.Util.fileExtension;
import static LineCounter.Util.createJavaCCParser;

public class Main {

  public static void countLines(String filePath) {
    switch (fileExtension(filePath)) {
      case "jjt": // JavaCC
        /* fall through */
      case "jj": // JavaCC
        File inputFile = new File(filePath);
        try {
          JavaCCLineCounterParser p = createJavaCCParser(inputFile);
          outputResult(filePath, p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      default:
        /* non supported file format */
    }
  }

  public static void outputResult(String filePath, int blankLines, int codeLines,
                                  int commentLines) {
    System.out.println("Result for file: " + filePath);
    System.out.println("Blank lines: " + blankLines);
    System.out.println("Code lines: " + codeLines);
    System.out.println("Comment lines: " + commentLines);
    System.out.println("----------------------------");
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new RuntimeException("No input file.");
    }

    for (String filePath : args) {
      countLines(filePath);
    }

  }

}
