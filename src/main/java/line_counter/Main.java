package line_counter;

import parser.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static line_counter.Util.*;

public class Main {

  public static HashMap<String, String> langByExtension;

  public static HashMap<String, String> defineExtensions() {
    HashMap<String, String> langByExtension = new HashMap<>();
    // Antlr
    langByExtension.put("g4", "Antlr");
    // Copper
    langByExtension.put("cpr", "Copper");
    // CUP
    langByExtension.put("cup", "CUP");
    // JavaCC
    langByExtension.put("jjt", "JavaCC");
    langByExtension.put("jj", "JavaCC");
    // JFlex
    langByExtension.put("flex", "JFlex");
    // MetaLexer
    langByExtension.put("mlc", "MetaLexer");
    langByExtension.put("mll", "MetaLexer");
    return langByExtension;
  }

  public static void countLines(OutputBuilder out, File inputFile) {
    if (inputFile.isDirectory()) {
      for (File child : inputFile.listFiles()) {
        countLines(out, child);
      }
    }
    else  {
      String fileExt = fileExtension(inputFile.getPath());

      if (langByExtension.containsKey(fileExt)) {
        try {
          JavaCommentParser p = createJavaCommentParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines(langByExtension.get(fileExt), lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new RuntimeException("No input file.");
    }

    OutputBuilder out = new OutputBuilder();
    langByExtension = defineExtensions();

    for (String filePath : args) {
      File inputFile = new File(filePath);
      countLines(out, inputFile);
    }

    out.printTable();

  }

}
