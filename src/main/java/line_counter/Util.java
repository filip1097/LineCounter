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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Util {

  public static JavaCommentParser createJavaCommentParser(File inputFile) throws IOException {
    Reader inputReader = new FileReader(inputFile);
    CharStream input = CharStreams.fromReader(inputReader);
    JavaCommentLexer scanner = new JavaCommentLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(scanner);
    JavaCommentParser parser = new JavaCommentParser(tokens);
    parser.file();
    return parser;
  }

  public static String fileExtension(String filePath) {
    String[] splitPath = filePath.split("[.]");
    if (splitPath.length != 2) {
      throw new RuntimeException("Input path not valid: " + filePath + " " + splitPath.length);
    }
    return splitPath[1];
  }

  /**
   * Calculates the number of digits of {@code num}.
   * @param num
   * @return
   */
  public static int nDigits(int num) {
    if (Math.abs(num) < 10) {
      return 1;
    } else {
      return 1 + nDigits(num / 10);
    }
  }

}
