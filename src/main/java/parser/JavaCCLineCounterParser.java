// Generated from JavaCCLineCounterParser.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaCCLineCounterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NEW_LINE=2, COMMENT=3, CODE_TEXT=4, COMMENT_WS=5, COMMENT_END=6;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_finalLine = 2, RULE_code = 3, RULE_comment = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "line", "finalLine", "code", "comment"
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

	@Override
	public String getGrammarFileName() { return "JavaCCLineCounterParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	private boolean isCodeLine;
	private boolean isCommentLine;

	private int nonBlankLines = 0;
	private int codeLines = 0;
	private int originalLines = 0;

	private void setNewLine() {
	  isCodeLine = false;
	  isCommentLine = false;
	}

	private void incLines() {
	  originalLines++;
	  if (isCodeLine) {
	    codeLines++;
	    nonBlankLines++;
	  } else if (isCommentLine) {
	    nonBlankLines++;
	  }
	}

	public int getBlankLines() {
	  return originalLines - nonBlankLines;
	}

	public int getCommentLines() {
	  return nonBlankLines - codeLines;
	}

	public int getCodeLines() {
	  return codeLines;
	}


	public JavaCCLineCounterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public FinalLineContext finalLine() {
			return getRuleContext(FinalLineContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(10);
					line();
					}
					} 
				}
				setState(15);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(16);
			finalLine();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public TerminalNode NEW_LINE() { return getToken(JavaCCLineCounterParser.NEW_LINE, 0); }
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 setNewLine(); 
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT || _la==CODE_TEXT) {
				{
				setState(21);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CODE_TEXT:
					{
					setState(19);
					code();
					}
					break;
				case COMMENT:
					{
					setState(20);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			match(NEW_LINE);
			 incLines(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalLineContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JavaCCLineCounterParser.EOF, 0); }
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FinalLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalLine; }
	}

	public final FinalLineContext finalLine() throws RecognitionException {
		FinalLineContext _localctx = new FinalLineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_finalLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 setNewLine(); 
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT || _la==CODE_TEXT) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CODE_TEXT:
					{
					setState(30);
					code();
					}
					break;
				case COMMENT:
					{
					setState(31);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			 incLines(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode CODE_TEXT() { return getToken(JavaCCLineCounterParser.CODE_TEXT, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(CODE_TEXT);
			 isCodeLine = true; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(JavaCCLineCounterParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(COMMENT);
			 isCommentLine = true; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\7\3\30\n\3\f\3\16\3\33\13\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4#\n"+
		"\4\f\4\16\4&\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\2\2\7\2\4\6"+
		"\b\n\2\2\2\60\2\17\3\2\2\2\4\24\3\2\2\2\6\37\3\2\2\2\b*\3\2\2\2\n-\3\2"+
		"\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2"+
		"\20\22\3\2\2\2\21\17\3\2\2\2\22\23\5\6\4\2\23\3\3\2\2\2\24\31\b\3\1\2"+
		"\25\30\5\b\5\2\26\30\5\n\6\2\27\25\3\2\2\2\27\26\3\2\2\2\30\33\3\2\2\2"+
		"\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\7\4\2\2"+
		"\35\36\b\3\1\2\36\5\3\2\2\2\37$\b\4\1\2 #\5\b\5\2!#\5\n\6\2\" \3\2\2\2"+
		"\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\2"+
		"\2\3()\b\4\1\2)\7\3\2\2\2*+\7\6\2\2+,\b\5\1\2,\t\3\2\2\2-.\7\5\2\2./\b"+
		"\6\1\2/\13\3\2\2\2\7\17\27\31\"$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}