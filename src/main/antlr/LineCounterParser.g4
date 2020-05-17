parser grammar LineCounterParser;

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

}

// TODO: remove this line
options { tokenVocab=AntlrLineCounterLexer; }

file : line* finalLine;

line      : { setNewLine(); } (code | comment)* NEW_LINE { incLines(); };
finalLine : { setNewLine(); } (code | comment)* EOF { incLines(); };

code : CODE_TEXT { isCodeLine = true; };

comment : COMMENT { isCommentLine = true; };
