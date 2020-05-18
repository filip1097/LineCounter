package LineCounter;

import antlr.CUPLineCounterParser;
import antlr.JFlexLineCounterParser;
import antlr.JavaCCLineCounterParser;

import java.io.File;
import java.io.IOException;

import static LineCounter.Util.*;

public class Main {

  public static void countLines(String filePath) {
    File inputFile;
    switch (fileExtension(filePath)) {
      case "jjt": // JavaCC
        /* fall through */
      case "jj": // JavaCC
        inputFile = new File(filePath);
        try {
          JavaCCLineCounterParser p = createJavaCCParser(inputFile);
          outputResult(filePath, p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "cup": // CUP
        inputFile = new File(filePath);
        try {
          CUPLineCounterParser p = createCUPParser(inputFile);
          outputResult(filePath, p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "flex": // JFlex
        inputFile = new File(filePath);
        try {
          JFlexLineCounterParser p = createJFlexParser(inputFile);
          outputResult(filePath, p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      default:
        System.err.println("LineCounter does not support ." + fileExtension(filePath) + "-files");
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
