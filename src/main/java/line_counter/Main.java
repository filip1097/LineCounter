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

import parser.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static line_counter.Util.*;

public class Main {

  public static HashMap<String, String> langByExtension;

  public static HashMap<String, String> defineExtensions() {
    HashMap<String, String> langByExtension = new HashMap<>();
    // Antlr
    langByExtension.put("g4", "Antlr");
    // Copper
    langByExtension.put("cpr", "Copper");
    // CUP
    langByExtension.put("cup", "CUP");
    // JavaCC
    langByExtension.put("jjt", "JavaCC");
    langByExtension.put("jj", "JavaCC");
    // JFlex
    langByExtension.put("flex", "JFlex");
    // MetaLexer
    langByExtension.put("mlc", "MetaLexer");
    langByExtension.put("mll", "MetaLexer");
    return langByExtension;
  }

  public static void countLines(OutputBuilder out, File inputFile) {
    if (inputFile.isDirectory()) {
      for (File child : inputFile.listFiles()) {
        countLines(out, child);
      }
    }
    else  {
      String fileExt = fileExtension(inputFile.getPath());

      if (langByExtension.containsKey(fileExt)) {
        try {
          JavaCommentParser p = createJavaCommentParser(inputFile);
          LineTotal lines = new LineTotal(p.getBlankLines(), p.getCodeLines(), p.getCommentLines());
          out.addNewLines(langByExtension.get(fileExt), lines);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  public static void main(String[] args) {
    if (args.length == 0) {
      throw new RuntimeException("No input file.");
    }

    OutputBuilder out = new OutputBuilder();
    langByExtension = defineExtensions();

    for (String filePath : args) {
      File inputFile = new File(filePath);
      countLines(out, inputFile);
    }

    out.printTable();

  }

}
