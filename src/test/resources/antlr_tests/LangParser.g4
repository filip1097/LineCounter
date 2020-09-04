parser grammar LangParser;

@header{


import ast.ASTNode;
import ast.Opt;

import astbuilder.ASTBuilder;

}

@parser::members {

private ASTBuilder ast = new ASTBuilder(this);

/**
* This method returns the AST built by the parser.
* @return the ast.
*/
public ASTNode getAST() {
  return ast.peek();
}

}

options { tokenVocab=LangScanner; }

/* Other */
attrList : (   'xmlns'    EQ ignoreString
             | 'xmlns:i'  EQ ignoreString
             | 'i:nil'    EQ ignoreString )*;

ignoreString : String;

/*--------CODE--------*/
codeBlock : stmtList;

/* stmt */
      // add more stmts

