# LineCounter

LineCounter is able to tell how many blank lines, code lines and comment lines
an input file contains.

### Functionality

The tool currently supports the following languages:

* Antlr     *(.g4)*
* Copper    *(.cpr)*
* CUP       *(.cup)*
* JavaCC    *(.jjt, .jj)*
* JFlex     *(.flex)*
* MetaLexer *(.mll, .mlc)*
* XML       *(.xml)*

### How to use

Use the tool by:

    java -jar LineCounter.jar <file/dir>
    
For example, by using the tool on the test cases:

    java -jar LineCounter.jar src/test/resources
    
We get the following result:

    +----------+------------+---------------+-------------+
    | Language | Code Lines | Comment Lines | Blank Lines |
    +----------+------------+---------------+-------------+
    | Antlr    |         72 |            52 |          48 |
    | Copper   |         16 |            12 |          14 |
    | CUP      |         12 |            12 |          12 |
    | JavaCC   |         23 |            25 |          12 |
    | JFlex    |         20 |            24 |          26 |
    | MetaLexer|         20 |            14 |          16 |
    | XML      |          9 |             8 |           2 |
    +----------+------------+---------------+-------------+
    | Sum      |        172 |           147 |         130 |
    +----------+------------+---------------+-------------+

### Dependencies

LineCounter uses Antlr4 for scanning and parsing the input file(s). 
See [Antlr4's license](licenses/antlr_license.txt).

### License

See [LICENSE](LICENSE.txt).

