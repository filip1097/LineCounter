lexer grammar AntlrLineCounterLexer;

WS                  : [ \t\r]+ -> skip;

NEW_LINE            : '\n';

COMMENT             : '//' ~[\n]*;
MULTI_LINE_COMMENT  : '/*' ~[ \n\t\r]*  -> type(COMMENT), pushMode(COMMENT_MODE);
JAVADOC_COMMENT     : '/**' ~[ \n\t\r]* -> type(COMMENT), pushMode(COMMENT_MODE);

CODE_TEXT           : ~[ \n\t\r]+;

mode COMMENT_MODE;
COMMENT_WS          : [ \t\r]+ -> skip;

COMMENT_NEW_LINE    : '\n'      -> type(NEW_LINE);
COMMENT_END         : '*/'      -> type(COMMENT), popMode;
COMMENT_TEXT        : ~[ \n\t\r/]+  -> type(COMMENT);

