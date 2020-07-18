// Generated from XMLCommentLexer.g4 by ANTLR 4.8
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
public class XMLCommentLexer extends Lexer {
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
			"WS", "NEW_LINE", "COMMENT", "JAVADOC_COMMENT", "CODE_TEXT", "COMMENT_WS", 
			"COMMENT_NEW_LINE", "COMMENT_END", "COMMENT_TEXT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<!--'", null, null, "'-->'"
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


	public XMLCommentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XMLCommentLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bQ\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2"+
		"\6\2\30\n\2\r\2\16\2\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\3\5\3\5\3\5\3\6\6\6\65\n\6"+
		"\r\6\16\6\66\3\7\6\7:\n\7\r\7\16\7;\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\6\nL\n\n\r\n\16\nM\3\n\3\n\2\2\13\4\3\6\4\b\5\n"+
		"\2\f\6\16\7\20\2\22\b\24\2\4\2\3\4\5\2\13\13\17\17\"\"\5\2\13\f\17\17"+
		"\"\"\2T\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\3"+
		"\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\4\27\3\2\2\2\6\35\3"+
		"\2\2\2\b\37\3\2\2\2\n&\3\2\2\2\f\64\3\2\2\2\169\3\2\2\2\20?\3\2\2\2\22"+
		"C\3\2\2\2\24K\3\2\2\2\26\30\t\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27"+
		"\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\34\b\2\2\2\34\5\3\2\2\2\35\36"+
		"\7\f\2\2\36\7\3\2\2\2\37 \7>\2\2 !\7#\2\2!\"\7/\2\2\"#\7/\2\2#$\3\2\2"+
		"\2$%\b\4\3\2%\t\3\2\2\2&\'\7\61\2\2\'(\7,\2\2()\7,\2\2)-\3\2\2\2*,\n\3"+
		"\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60"+
		"\61\b\5\4\2\61\62\b\5\3\2\62\13\3\2\2\2\63\65\n\3\2\2\64\63\3\2\2\2\65"+
		"\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\r\3\2\2\28:\t\2\2\298\3\2\2"+
		"\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\b\7\2\2>\17\3\2\2\2?@\7\f"+
		"\2\2@A\3\2\2\2AB\b\b\5\2B\21\3\2\2\2CD\7/\2\2DE\7/\2\2EF\7@\2\2FG\3\2"+
		"\2\2GH\b\t\4\2HI\b\t\6\2I\23\3\2\2\2JL\n\3\2\2KJ\3\2\2\2LM\3\2\2\2MK\3"+
		"\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\n\4\2P\25\3\2\2\2\t\2\3\31-\66;M\7\b\2"+
		"\2\7\3\2\t\5\2\t\4\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}