package line_counter;

import parser.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Util {

  public static AntlrLineCounterParser createAntlrParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    AntlrLineCounterLexer scanner = new AntlrLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    AntlrLineCounterParser parser = new AntlrLineCounterParser(tokens);
    parser.file();
    return parser;
  }

  public static CopperLineCounterParser createCopperParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    CopperLineCounterLexer scanner = new CopperLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    CopperLineCounterParser parser = new CopperLineCounterParser(tokens);
    parser.file();
    return parser;
  }

  public static CUPLineCounterParser createCUPParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    CUPLineCounterLexer scanner = new CUPLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    CUPLineCounterParser parser = new CUPLineCounterParser(tokens);
    parser.file();
    return parser;
  }

  public static MetaLexerLineCounterParser createMetaLexerParser(File inputFile)
      throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    MetaLexerLineCounterLexer scanner = new MetaLexerLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    MetaLexerLineCounterParser parser = new MetaLexerLineCounterParser(tokens);
    parser.file();
    return parser;
  }

  public static JavaCCLineCounterParser createJavaCCParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    JavaCCLineCounterLexer scanner = new JavaCCLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    JavaCCLineCounterParser parser = new JavaCCLineCounterParser(tokens);
    parser.file();
    return parser;
  }

  public static JFlexLineCounterParser createJFlexParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    JFlexLineCounterLexer scanner = new JFlexLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    JFlexLineCounterParser parser = new JFlexLineCounterParser(tokens);
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

}
