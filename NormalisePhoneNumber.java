package coolcutsPipeAndFilter;

public class NormalisePhoneNumber implements Filter<String>{
    @Override
    public String execute(String input) {
        input = input.replaceAll("\\+389","0");
        input = input.replaceAll("\\(","");
        input = input.replaceAll("\\)","");
        return input;
    }
}
