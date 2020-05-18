package ast;

%%

%public

%type java_cup.runtime.Symbol

%cup

%{
  /**
  * javadoc
  */
  public void method() {
    Systen.out.println("h");
  }
%}

WhiteSpace = [\ \t\f\n\r]

%%

/*
 why
multiline
 */


 // one-line comment
{WhiteSpace}   { }

"hello"        { return symbol; } // hello

