package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class VarInit extends Declaration{
    public Identifier I;
    public Expression E;
    public VarInit(Identifier id, Expression ex, SourcePosition thePosition) {
        super(thePosition);
        I = id;
        E = ex;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitVarInit(this, o);
    }
}
    
