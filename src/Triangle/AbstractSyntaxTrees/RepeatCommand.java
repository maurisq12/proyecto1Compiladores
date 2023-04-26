package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatCommand extends Command{
    public RepeatBody rb;
    public RepeatCommand(RepeatBody repeatBody, SourcePosition thePosition) {
        
        super(thePosition);
        rb = repeatBody;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatCommand(this, o);
    }

    
    
}