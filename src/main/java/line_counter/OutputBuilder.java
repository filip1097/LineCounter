/*
 * Copyright 2020 Filip Johansson
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package line_counter;

import java.util.HashMap;
import java.util.Map.Entry;

import static line_counter.Util.nDigits;

public class OutputBuilder {

  final static String[] COLUMN_TITLES = {"Language", "Code Lines", "Comment Lines", "Blank Lines"};
  final static String SUM_TITLE = "Sum";

  private HashMap<String, LineTotal> linesByLanguage;
  private int[] columnWidth;
  private LineTotal sum;

  public OutputBuilder() {
    linesByLanguage = new HashMap<>();
    sum = new LineTotal(0, 0, 0);
  }

  public void addNewLines(String lang, LineTotal lt) {
    sum.addLines(lt);
    if (linesByLanguage.containsKey(lang)) {
      linesByLanguage.get(lang).addLines(lt);
    } else {
      linesByLanguage.put(lang, lt);
    }
  }

  public void printTable() {
    calcColumnWidth();

    printHorizontalLine();
    printRow(COLUMN_TITLES);
    printHorizontalLine();

    for (Entry<String, LineTotal> e : linesByLanguage.entrySet()) {
      String langName = e.getKey();
      LineTotal lines = e.getValue();
      printRow(langName, lines);
    }

    printHorizontalLine();
    printRow(SUM_TITLE, sum);
    printHorizontalLine();
  }

  private void printRow(String[] strs) {
    System.out.print("|");
    for (int i = 0; i < strs.length; i++) {
      printElem(strs[i], columnWidth[i]);
    }
    System.out.println();
  }

  private void printRow(String str, LineTotal lt) {
    System.out.print("|");
    printElem(str, columnWidth[0]);
    printElem(lt.getCodeLines(), columnWidth[1]);
    printElem(lt.getCommentLines(), columnWidth[2]);
    printElem(lt.getBlankLines(), columnWidth[3]);
    System.out.println();
  }

  private void printHorizontalLine() {
    System.out.print('+');
    for (int w : columnWidth) {
      for (int i = 0; i < w; i++) {
        System.out.print('-');
      }
      System.out.print('+');
    }
    System.out.println();
  }

  private void printElem(String str, int columnWidth) {
    System.out.print(" ");
    System.out.print(str);
    printExtraBlanks(columnWidth - str.length() - 1);
    System.out.print("|");
  }

  private void printElem(int lineNum, int columnWidth) {
    printExtraBlanks(columnWidth - nDigits(lineNum) - 1);
    System.out.print(lineNum);
    System.out.print(" |");
  }

  private void printExtraBlanks(int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(" ");
    }
  }

  private void calcColumnWidth() {
    columnWidth = new int[COLUMN_TITLES.length];
    for (int i = 0; i < COLUMN_TITLES.length; i++) {
      // +2 due to two extra blanks
      columnWidth[i] = COLUMN_TITLES[i].length() + 2;
    }

    // Compare with sum row
    int langColWidth = SUM_TITLE.length() + 2;
    if (langColWidth > columnWidth[0]) {
      columnWidth[0] = langColWidth;
    }
    int codeColWidth = nDigits(sum.getCodeLines()) + 2;
    if (codeColWidth > columnWidth[1]) {
      columnWidth[1] = codeColWidth;
    }
    int commentColWidth = nDigits(sum.getCommentLines()) + 2;
    if (commentColWidth > columnWidth[2]) {
      columnWidth[2] = commentColWidth;
    }
    int blankColWidth = nDigits(sum.getBlankLines()) + 2;
    if (blankColWidth > columnWidth[3]) {
      columnWidth[3] = blankColWidth;
    }

  }

}
