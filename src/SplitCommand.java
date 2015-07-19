import java.util.Arrays;

public class SplitCommand extends Node
{
    public Parser parser;

    public SplitCommand()
    {
    }

    public SplitCommand(Parser parser)
    {
        this.parser = parser;
    }

    public Object eval()
    {
        String str = parser.getVariable("string").toString();
        String regex = parser.getVariable("regex").toString();
        String[] split = str.split(regex);
        return Arrays.asList(split);
    }
}