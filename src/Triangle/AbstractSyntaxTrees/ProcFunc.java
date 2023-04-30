package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ProcFunc extends Declaration{
    public Declaration D; 

    public ProcFunc(Declaration d, SourcePosition thePosition) {
        super(thePosition);
        D = d;
    }


    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitProcFunc(this, v);
    }
}