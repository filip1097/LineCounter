// Generated from JavaCommentLexer.g4 by ANTLR 4.8
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
public class JavaCommentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NEW_LINE=2, COMMENT=3, CODE_TEXT=4, COMMENT_WS=5;
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
			"WS", "NEW_LINE", "COMMENT", "MULTI_LINE_COMMENT", "WHOLE_MULTI_LINE_COMMENT", 
			"JAVADOC_COMMENT", "WHOLE_JAVADOC_COMMENT", "CODE_TEXT", "COMMENT_WS", 
			"COMMENT_NEW_LINE", "COMMENT_END", "COMMENT_TEXT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "NEW_LINE", "COMMENT", "CODE_TEXT", "COMMENT_WS"
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


	public JavaCommentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavaCommentLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u0087\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\3\2\6\2\36\n\2\r\2\16\2\37\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\3\5\3\5\7\5\63\n\5\f"+
		"\5\16\5\66\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7N\n\7\f\7\16\7Q\13\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\7\b[\n\b\f\b\16\b^\13\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\6\tf\n\t\r\t\16\tg\3\n\6\nk\n\n\r\n\16\nl\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\7\fv\n\f\f\f\16\fy\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\r\u0082"+
		"\n\r\r\r\16\r\u0083\3\r\3\r\2\2\16\4\3\6\4\b\5\n\2\f\2\16\2\20\2\22\6"+
		"\24\7\26\2\30\2\32\2\4\2\3\6\5\2\13\13\17\17\"\"\3\2\f\f\7\2\13\f\17\17"+
		"\"\",,\61\61\5\2\13\f\17\17\"\"\2\u008f\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3"+
		"\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2"+
		"\3\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\4\35\3\2\2\2\6#\3"+
		"\2\2\2\b%\3\2\2\2\n.\3\2\2\2\f:\3\2\2\2\16H\3\2\2\2\20U\3\2\2\2\22e\3"+
		"\2\2\2\24j\3\2\2\2\26p\3\2\2\2\30w\3\2\2\2\32\u0081\3\2\2\2\34\36\t\2"+
		"\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!"+
		"\"\b\2\2\2\"\5\3\2\2\2#$\7\f\2\2$\7\3\2\2\2%&\7\61\2\2&\'\7\61\2\2\'+"+
		"\3\2\2\2(*\n\3\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\t\3\2\2\2"+
		"-+\3\2\2\2./\7\61\2\2/\60\7,\2\2\60\64\3\2\2\2\61\63\n\4\2\2\62\61\3\2"+
		"\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2"+
		"\2\2\678\b\5\3\289\b\5\4\29\13\3\2\2\2:;\7\61\2\2;<\7,\2\2<@\3\2\2\2="+
		"?\n\5\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2"+
		"CD\7,\2\2DE\7\61\2\2EF\3\2\2\2FG\b\6\3\2G\r\3\2\2\2HI\7\61\2\2IJ\7,\2"+
		"\2JK\7,\2\2KO\3\2\2\2LN\n\4\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2"+
		"\2PR\3\2\2\2QO\3\2\2\2RS\b\7\3\2ST\b\7\4\2T\17\3\2\2\2UV\7\61\2\2VW\7"+
		",\2\2WX\7,\2\2X\\\3\2\2\2Y[\n\5\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]"+
		"\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7,\2\2`a\7\61\2\2ab\3\2\2\2bc\b\b\3\2"+
		"c\21\3\2\2\2df\n\5\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\23\3\2"+
		"\2\2ik\t\2\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\n"+
		"\2\2o\25\3\2\2\2pq\7\f\2\2qr\3\2\2\2rs\b\13\5\2s\27\3\2\2\2tv\n\5\2\2"+
		"ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7,\2\2"+
		"{|\7\61\2\2|}\3\2\2\2}~\b\f\3\2~\177\b\f\6\2\177\31\3\2\2\2\u0080\u0082"+
		"\n\5\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\r\3\2\u0086\33\3\2\2"+
		"\2\16\2\3\37+\64@O\\glw\u0083\7\b\2\2\t\5\2\7\3\2\t\4\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}