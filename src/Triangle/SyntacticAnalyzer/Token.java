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
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...-
    ARRAY		= 4,
    CONST		= 5, //se elimina begin
    DO			= 6,
    ELSE		= 7,
    END			= 8,
    FOR                 = 9,  //AGREGADA
    FROM                = 10, //AGREGADA
    FUNC		= 11,
    IF			= 12,
    IN			= 13,
    LET			= 14,
    OF			= 15,
    PACKAGE             = 16, //AGREGADA
    PRIVATE             = 17, //AGREGADA
    PROC		= 18,
    REC                 = 19, //AGREGADA
    RECORD		= 20,
    REPEAT              = 21, //AGREGADA
    SELECT              = 22, //AGREGADA
    SKIP                = 23, //AGREGADA
    THEN		= 24,
    TIMES               = 25, //AGREGADA
    TYPE		= 26,
    UNTIL               = 27, //AGREGADA
    VAR			= 28,
    WHEN                = 29, //AGREGADA
    WHILE		= 30,

    // punctuation...
    DOT			= 31,
    COLON		= 32,
    SEMICOLON	        = 33,
    COMMA		= 34,
    BECOMES		= 35,
    IS			= 36,
    PIPE                = 37, //AGREGADO
    DOLLAR              = 38, //AGREGADO
    DOTS                = 39, //AGREGADO

    // brackets...
    LPAREN		= 40,
    RPAREN		= 41,
    LBRACKET	        = 42,
    RBRACKET	        = 43,
    LCURLY		= 44,
    RCURLY		= 45,

    // special tokens...
    EOT			= 46,
    ERROR		= 47;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "const",
    "do",
    "else",
    "end", 
    "for", //AGREGADA
    "from", //10  //AGREGADA
    "func",
    "if",
    "in",
    "let",
    "of",
    "package", //AGREGADA
    "private", //AGREGADA
    "proc",
    "rec", //AGREGADA
    "record", //20
    "repeat", //AGREGADA
    "select", //AGREGADA
    "skip", //AGREGADA
    "then",
    "times", //AGREGADA
    "type",
    "until", //AGREGADA
    "var",
    "when", //AGREGADA
    "while", //30
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|", //AGREGADO
    "$", //AGREGADO
    "..", //AGREGADO
    "(", //40
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"  //47
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
