package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ProcFuncs extends Declaration{
    public Declaration procFunc1;
    public Declaration declaration;
    
    public ProcFuncs(Declaration d, Declaration pf1, SourcePosition thePosition) {
        super(thePosition);
        declaration = d;
        procFunc1 = pf1;
        
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitProcFuncs(this, o);
    }
    
}
