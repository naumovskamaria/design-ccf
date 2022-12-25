package coolcutsPipeAndFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoolCutsPipeAndFilter {

    public static void main(String[] args) throws FileNotFoundException {

        Pipe<String> pipe = new Pipe<>();

        ToUpperCaseFilter toUpperCaseFilter = new ToUpperCaseFilter();
        RemoveCity filterByCity = new RemoveCity();
        RemoveLastCharFilter removeLastCharFilter = new RemoveLastCharFilter();
        NormalisePhoneNumber normalisePhoneNumber = new NormalisePhoneNumber();

        Scanner scanner = new Scanner(new File("C:\\Users\\stoja\\Downloads\\CoolCutsPipeAndFilter\\PipeAndFilter\\src\\main\\resources\\CoolCutsCSV.csv"),"UTF-8");
        scanner.useDelimiter(",");

        pipe.addFilter(toUpperCaseFilter);
        pipe.addFilter(filterByCity);
        pipe.addFilter(removeLastCharFilter);
        pipe.addFilter(normalisePhoneNumber);

        while(scanner.hasNextLine())
        {
            System.out.println(pipe.runFilter(scanner.nextLine()));
        }
    }
}
