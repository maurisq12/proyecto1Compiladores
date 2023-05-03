package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PrivateDeclaration extends Declaration{
    public Declaration D1, D2;
    public PrivateDeclaration(Declaration d1, Declaration d2,SourcePosition thePosition) {
        super(thePosition);
        D1 = d1;
        D2 = d2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitPrivateDeclaration(this, o);
    }
    
}