package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;


public class UntilBody extends RepeatBody{
    public Expression E;
    public Command C;

    public UntilBody(Expression exprAST, Command commandAST, SourcePosition thePosition) {
        super(thePosition);
        E = exprAST;
        C = commandAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitUntilBody(this, o);
    }
    
}
