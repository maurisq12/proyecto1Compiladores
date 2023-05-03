package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;


public class TimesBody extends RepeatBody{
    public Expression E;
    public Command C;
    public TimesBody(Expression expression, Command command,  SourcePosition thePosition) {
        super(thePosition);
        E = expression;
        C = command;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitTimesBody(this, o);
    }
}