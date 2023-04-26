package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;


public class WhileBody extends RepeatBody{
    public Expression E;
    public Command C;
    public WhileBody(Expression expression, Command command,  SourcePosition thePosition) {
        super(thePosition);
        E = expression;
        C = command;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitWhileBody(this, o); //To change body of generated methods, choose Tools | Templates.
    }
}
