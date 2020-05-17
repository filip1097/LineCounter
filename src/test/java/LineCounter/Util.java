package LineCounter;

import antlr.AntlrLineCounterLexer;
import antlr.LineCounterParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Util {

  public static LineCounterParser createAntlrParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    AntlrLineCounterLexer scanner = new AntlrLineCounterLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    LineCounterParser parser = new LineCounterParser(tokens);
    parser.file();
    return parser;
  }

}
