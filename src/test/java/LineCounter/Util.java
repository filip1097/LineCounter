package LineCounter;

import antlr.AntlrLineCounterLexer;
import antlr.AntlrLineCounterParser;
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

}
