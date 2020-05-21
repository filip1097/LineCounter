// Generated from AntlrLineCounterLexer.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrLineCounterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NEW_LINE=2, COMMENT=3, CODE_TEXT=4, COMMENT_WS=5, COMMENT_END=6;
	public static final int
		COMMENT_MODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMENT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "NEW_LINE", "COMMENT", "MULTI_LINE_COMMENT", "JAVADOC_COMMENT", 
			"CODE_TEXT", "COMMENT_WS", "COMMENT_NEW_LINE", "COMMENT_END", "COMMENT_TEXT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'*/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "NEW_LINE", "COMMENT", "CODE_TEXT", "COMMENT_WS", "COMMENT_END"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public AntlrLineCounterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AntlrLineCounterLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b`\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\7\4&"+
		"\n\4\f\4\16\4)\13\4\3\5\3\5\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\6\3\6\3\6\3\7\6\7E"+
		"\n\7\r\7\16\7F\3\b\6\bJ\n\b\r\b\16\bK\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\6\13[\n\13\r\13\16\13\\\3\13\3\13\2\2\f\4\3\6\4"+
		"\b\5\n\2\f\2\16\6\20\7\22\2\24\b\26\2\4\2\3\6\5\2\13\13\17\17\"\"\3\2"+
		"\f\f\5\2\13\f\17\17\"\"\6\2\13\f\17\17\"\"\61\61\2e\2\4\3\2\2\2\2\6\3"+
		"\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\3\20\3\2\2\2\3"+
		"\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\4\31\3\2\2\2\6\37\3\2\2\2\b!\3\2"+
		"\2\2\n*\3\2\2\2\f\66\3\2\2\2\16D\3\2\2\2\20I\3\2\2\2\22O\3\2\2\2\24S\3"+
		"\2\2\2\26Z\3\2\2\2\30\32\t\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2"+
		"\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\b\2\2\2\36\5\3\2\2\2\37 \7\f\2"+
		"\2 \7\3\2\2\2!\"\7\61\2\2\"#\7\61\2\2#\'\3\2\2\2$&\n\3\2\2%$\3\2\2\2&"+
		")\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\t\3\2\2\2)\'\3\2\2\2*+\7\61\2\2+,\7,"+
		"\2\2,\60\3\2\2\2-/\n\4\2\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2"+
		"\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\b\5\3\2\64\65\b\5\4\2\65\13\3\2"+
		"\2\2\66\67\7\61\2\2\678\7,\2\289\7,\2\29=\3\2\2\2:<\n\4\2\2;:\3\2\2\2"+
		"<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\b\6\3\2AB\b\6\4\2"+
		"B\r\3\2\2\2CE\n\4\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\17\3\2"+
		"\2\2HJ\t\2\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\b\b"+
		"\2\2N\21\3\2\2\2OP\7\f\2\2PQ\3\2\2\2QR\b\t\5\2R\23\3\2\2\2ST\7,\2\2TU"+
		"\7\61\2\2UV\3\2\2\2VW\b\n\3\2WX\b\n\6\2X\25\3\2\2\2Y[\n\5\2\2ZY\3\2\2"+
		"\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\b\13\3\2_\27\3\2\2\2\13"+
		"\2\3\33\'\60=FK\\\7\b\2\2\t\5\2\7\3\2\t\4\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}