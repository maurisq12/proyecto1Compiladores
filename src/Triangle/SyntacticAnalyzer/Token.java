/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    LONGIDENTIFIER=3,
    OPERATOR	= 4,

    // reserved words - must be in alphabetical order...-
    ARRAY		= 5,//se elimina begin
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    FOR                 = 10,
    FROM                = 11,
    FUNC		= 12,
    IF			= 13,
    IN			= 14,
    LET			= 15,
    OF			= 16,
    PACKAGE             = 17,
    PRIVATE             = 18,
    PROC		= 19,
    REC                 = 20,
    RECORD		= 21,
    REPEAT              = 22,
    SELECT              = 23,
    SKIP                = 24,
    THEN		= 25,
    TIMES               = 26,
    TYPE		= 27,
    UNTIL               = 28,
    VAR			= 29,
    WHEN                = 30,
    WHILE		= 31,

    // punctuation...
    DOT			= 32,
    COLON		= 33,
    SEMICOLON	        = 34,
    COMMA		= 35,
    BECOMES		= 36,
    IS			= 37,
    PIPE                = 38,
    DOLLAR              = 39,
    DOTS                = 40,

    // brackets...
    LPAREN		= 41,
    RPAREN		= 42,
    LBRACKET	        = 43,
    RBRACKET	        = 44,
    LCURLY		= 45,
    RCURLY		= 46,

    // special tokens...
    EOT			= 47,
    ERROR		= 48;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<long-identifier>",
    "<operator>",
    "array",
    "const",
    "do",
    "else",
    "end", 
    "for", //10
    "from",
    "func",
    "if",
    "in",
    "let",
    "of",
    "package",
    "private",
    "proc",
    "rec", //20
    "record",
    "repeat",
    "select",
    "skip",
    "then",
    "times",
    "type",
    "until",
    "var",
    "when",//30
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",
    "$",
    "..", //40
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"  //48
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
