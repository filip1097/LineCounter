lexer grammar AntlrLineCounterLexer;

WS                  : [ \t\r]+ -> skip;

NEW_LINE            : '\n';

COMMENT             : '//' ~[\n]*;
MULTI_LINE_COMMENT  : '/*'  -> type(COMMENT), pushMode(COMMENT_MODE);
JAVADOC_COMMENT     : '/**' -> type(COMMENT), pushMode(COMMENT_MODE);

mode COMMENT_MODE;
COMMENT_NEW_LINE    : '\n'    -> type(NEW_LINE);
COMMENT_END         : '*/'    -> type(COMMENT), popMode;
COMMENT_TEXT        : ~[\n]+  -> type(COMMENT);
