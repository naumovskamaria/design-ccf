package coolcutsPipeAndFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveCity implements Filter<String>{
    @Override
    public String execute(String input) {

        String[] fields = input.split(",");
        String[] cities = Arrays.copyOfRange(fields,1,fields.length);
        String res = "";
        for(String city : cities){
                res+= city+",";
        }
        return res;
    }
}
