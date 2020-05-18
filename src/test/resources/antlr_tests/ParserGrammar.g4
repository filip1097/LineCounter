parser grammar ParserGrammar;

@parser::members {

private boolean isCodeLine;
private boolean isCommentLine;

private int nonBlankLines = 0;
private int codeLines = 0;
private int originalLines = 0;

private void setNewLine() {
  isCodeLine = false;
  isCommentLine = false;
}

/** Javadoc domm
 * dfg
 */
private void incLines() {
  originalLines++;
  if (isCodeLine) {
    codeLines++;
    nonBlackLines++;
  } else if (isCommentLines) {
    nonBlankLines++;
  }
} // one comment

public int getBlankLines() {
  return originalLines - nonBlankLines;
}

public int getCommentLines() {
  return nonBlankLines - codeLines;
}

public int getCodeLines() {
  return codeLines;
}

}

// comment

file : { setNewLine(); } (code | comment)* (NEW_LINE | EOF) { incLines(); };

/* gfdgdf
sdf
*/
code : CODE_TEXT { isCodeLine = true; };

comment : COMMENT { isCommentLine = true; };
