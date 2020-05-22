package line_counter;

import java.util.HashMap;
import java.util.Map.Entry;

import static line_counter.Util.nDigits;

public class OutputBuilder {

  final static String[] COLUMN_TITLES = {"Language", "Code Lines", "Comment Lines", "Blank Lines"};

  private HashMap<String, LineTotal> linesByLanguage;
  private int[] columnWidth;

  public OutputBuilder() {
    linesByLanguage = new HashMap<>();
  }

  public void addNewLines(String lang, LineTotal lt) {
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

    for (Entry<String, LineTotal> e : linesByLanguage.entrySet()) {
      int langColWidth = e.getKey().length() + 2;
      if (langColWidth > columnWidth[0]) {
        columnWidth[0] = langColWidth;
      }

      LineTotal lines = e.getValue();

      int codeColWidth = nDigits(lines.getCodeLines()) + 2;
      if (codeColWidth > columnWidth[1]) {
        columnWidth[1] = codeColWidth;
      }

      int commentColWidth = nDigits(lines.getCommentLines()) + 2;
      if (commentColWidth > columnWidth[2]) {
        columnWidth[2] = commentColWidth;
      }

      int blankColWidth = nDigits(lines.getBlankLines()) + 2;
      if (blankColWidth > columnWidth[3]) {
        columnWidth[3] = blankColWidth;
      }

    }
  }

}
