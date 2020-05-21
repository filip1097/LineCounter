package line_counter;

import java.util.HashMap;
import java.util.Map.Entry;

import static line_counter.Util.nDigits;

public class OutputBuilder {

  final static String[] COLUMN_TITLES = {"Language", "Code Lines", "Comment Lines", "Blank Lines"};

  private HashMap<String, LineTotal> linePerLanguage;
  private int[] columnWidth;

  public OutputBuilder() {
    linePerLanguage = new HashMap<>();
  }

  public void addNewLines(String lang, LineTotal lt) {
    if (linePerLanguage.containsKey(lang)) {
      linePerLanguage.get(lang).addLines(lt);
    } else {
      linePerLanguage.put(lang, lt);
    }
  }

  public void printTable() {
    calcColumnWidth();

    // print titles
    System.out.print("|");
    for (int i = 0; i < COLUMN_TITLES.length; i++) {
      System.out.print(" ");
      System.out.print(COLUMN_TITLES[i]);
      printExtraBlanks(columnWidth[i] - COLUMN_TITLES[i].length() - 1);
      System.out.print("|");
    }
    System.out.println();

    // print horizontal line
    System.out.print('+');
    for (int w : columnWidth) {
      for (int i = 0; i < w; i++) {
        System.out.print('-');
      }
      System.out.print('+');
    }
    System.out.println();

    // print lines
    for (Entry<String, LineTotal> e : linePerLanguage.entrySet()) {
      String langName = e.getKey();
      System.out.print("| ");
      System.out.print(langName);
      printExtraBlanks(columnWidth[0] - langName.length() - 1);

      LineTotal langLines = e.getValue();

      System.out.print("|");
      printExtraBlanks(columnWidth[1] - nDigits(langLines.getCodeLines()) - 1);
      System.out.print(langLines.getCodeLines());

      System.out.print(" |");
      printExtraBlanks(columnWidth[2] - nDigits(langLines.getCommentLines()) - 1);
      System.out.print(langLines.getCommentLines());

      System.out.print(" |");
      printExtraBlanks(columnWidth[3] - nDigits(langLines.getBlankLines()) - 1);
      System.out.print(langLines.getBlankLines());

      System.out.print(" |");
      System.out.println();
    }
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

    for (Entry<String, LineTotal> e : linePerLanguage.entrySet()) {
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
