package coolcutsPipeAndFilter;

public class RemoveLastCharFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        return input.substring(0,input.length()-1);
    }
}