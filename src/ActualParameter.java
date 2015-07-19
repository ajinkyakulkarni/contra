public class ActualParameter
{
    private Node value;

    public ActualParameter(Node value)
    {
        this.value = value;
    }

    public Object eval()
    {
        return value.eval();
    }

    public Object getValue()
    {
        return value.eval();
    }
}
