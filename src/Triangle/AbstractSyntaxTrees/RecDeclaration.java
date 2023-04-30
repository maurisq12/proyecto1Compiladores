package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RecDeclaration extends Declaration{
    public Declaration proc, procBody;
    
    public RecDeclaration(Declaration p1, SourcePosition thePosition) {
        super(thePosition);
        proc = p1;
    }
    public RecDeclaration(Declaration p1,Declaration p2, SourcePosition thePosition) {
        super(thePosition);
        proc = p1;
        procBody = p2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRecDeclaration(this, o);
    }
    
}
