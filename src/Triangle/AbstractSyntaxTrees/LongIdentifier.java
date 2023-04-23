/*
 * @(#)LongIdentifier.java                       2023/19/04
 *
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LongIdentifier extends Terminal {

  public LongIdentifier (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
    type = null;
    decl = null;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLongIdentifier(this, o);
  }

  public TypeDenoter type;
  public AST decl; // Either a Declaration or a FieldTypeDenoter
}
