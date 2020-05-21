package line_counter;

public class LineTotal {

  private int blankLines;
  private int codeLines;
  private int commentLines;

  public LineTotal(int blankLines, int codeLines, int commentLines) {
    this.blankLines = blankLines;
    this.codeLines = codeLines;
    this.commentLines = commentLines;
  }

  public void addLines(LineTotal x) {
    this.blankLines += x.blankLines;
    this.codeLines += x.codeLines;
    this.commentLines += x.commentLines;
  }

  public int getBlankLines() {
    return blankLines;
  }

  public int getCodeLines() {
    return codeLines;
  }

  public int getCommentLines() {
    return commentLines;
  }

}
