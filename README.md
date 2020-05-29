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

### How to use

Use the tool by:

    java -jar LineCounter.jar <file/dir>
    
For example, by using the tool on the test cases:

    java -jar LineCounter.jar src/test/resources
    
We get the following result:

    +----------+------------+---------------+-------------+
    | Language | Code Lines | Comment Lines | Blank Lines |
    +----------+------------+---------------+-------------+
    | MetaLexer|          8 |             9 |           8 |
    | JavaCC   |         16 |             8 |           6 |
    | JFlex    |         14 |             8 |          13 |
    | Antlr    |         49 |            13 |          24 |
    | Copper   |          9 |             5 |           7 |
    | CUP      |          6 |             6 |           6 |
    +----------+------------+---------------+-------------+
    | Sum      |        102 |            49 |          64 |
    +----------+------------+---------------+-------------+

### Dependencies

LineCounter uses Antlr4 for scanning and parsing the input file(s). 
See [Antlr4's license](licenses/antlr_license.txt).

### License

See [LICENSE](LICENSE.txt).

