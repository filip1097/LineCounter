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

    +-----------+------------+---------------+-------------+-------------+
    | Language  | Code Lines | Comment Lines | Blank Lines | Total Lines |
    +-----------+------------+---------------+-------------+-------------+
    | ANTLR     |         67 |            21 |          40 |         128 |
    | Copper    |          9 |             5 |           7 |          21 |
    | CUP       |          6 |             6 |           6 |          18 |
    | JavaCC    |         16 |             8 |           6 |          30 |
    | JFlex     |         14 |             8 |          13 |          35 |
    | MetaLexer |          8 |             9 |           8 |          25 |
    | XML       |          9 |             8 |           2 |          19 |
    +-----------+------------+---------------+-------------+-------------+
    | Sum       |        129 |            65 |          82 |         276 |
    +-----------+------------+---------------+-------------+-------------+ 



### Dependencies

LineCounter uses Antlr4 for scanning and parsing the input file(s). 
See [Antlr4's license](licenses/antlr_license.txt).

### License

See [LICENSE](LICENSE.txt).

