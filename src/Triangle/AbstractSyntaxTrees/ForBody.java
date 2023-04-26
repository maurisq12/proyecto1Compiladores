package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForBody extends RepeatBody{
    public Identifier I;
    public Expression E1, E2, E3;
    public Command C;
    public ForBody(Identifier iAST, Expression eAST1, Expression eAST2, Expression eAST3, Command command,SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E1 = eAST1;
        E2 = eAST2;
        E3 = eAST3;
        C = command;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitForBody(this, o);
    }
    
}
