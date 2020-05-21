package line_counter;

import parser.*;

import java.io.File;
import java.io.IOException;

import static line_counter.Util.*;

public class Main {

  public static void countLines(OutputBuilder out, File inputFile) {
    if (inputFile.isDirectory()) {
      for (File child : inputFile.listFiles()) {
        countLines(out, child);
      }
      return;
    }

    switch (fileExtension(inputFile.getPath())) {
      case "jjt": // JavaCC
        /* fall through */
      case "jj": // JavaCC
        try {
          JavaCCLineCounterParser p = createJavaCCParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines("JavaCC", lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "cup": // CUP
        try {
          CUPLineCounterParser p = createCUPParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines("CUP", lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "flex": // JFlex
        try {
          JFlexLineCounterParser p = createJFlexParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines("JFlex", lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "g4": // Antlr
        try {
          AntlrLineCounterParser p = createAntlrParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines("Antlr", lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "mll": // MetaLexer
        /* fall through */
      case "mlc": // MetaLexer
        try {
          MetaLexerLineCounterParser p = createMetaLexerParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines("MetaLexer", lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      case "cpr": // Copper
        try {
          CopperLineCounterParser p = createCopperParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines("Copper", lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      default:
        System.err.println("LineCounter does not support ."
            + fileExtension(inputFile.getPath()) + "-files");
    }
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new RuntimeException("No input file.");
    }

    OutputBuilder out = new OutputBuilder();

    for (String filePath : args) {
      File inputFile = new File(filePath);
      countLines(out, inputFile);
    }

    out.printTable();

  }

}
