
/*
 * Copyright 2020 Filip Johansson
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided with
 * the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

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

file : line* finalLine;

line      : { setNewLine(); } (code | comment)* NEW_LINE { incLines(); };
finalLine : { setNewLine(); } (code | comment)* EOF { incLines(); };

code : CODE_TEXT { isCodeLine = true; };

comment : COMMENT { isCommentLine = true; };
