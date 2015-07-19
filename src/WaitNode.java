public class WaitNode extends Node
{
    public Node interval;
            
    public WaitNode() {}
    
    public WaitNode(Node interval)
    {
        this.interval = interval;
    }
    
    public Object eval()
    {
        Integer waitAmount = (Integer) interval.eval();
        try
        {
            Thread.sleep(waitAmount.intValue());
        }
        catch (Exception e)
        {
            Util.Writeln("Error in WaitNode.eval() method" + e);
        }
        return waitAmount;
    }        
}