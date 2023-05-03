package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DoBody extends RepeatBody{
    public Command C;
    public Expression E;
    public DoBody(Command command, Expression expression, SourcePosition thePosition) {
        super(thePosition);
        C = command;
        E = expression;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitDoBody(this, o);
    }
    
}
