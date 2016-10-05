package areo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gta on 01.10.16.
 */
public class ArffGenerator {


    public void generate(int howMany, String fileName){

        List<Case> cases = this.generateCases(howMany);

        try(  PrintWriter out = new PrintWriter( fileName )  ){

            cases.stream().forEach(out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Case> generateCases(int howMany){

        List<Case>  result= new ArrayList<>();

        Random random = new Random();
        do {
            result.add(nextCase(random));
        }while (howMany-- > 0);
        return result;
    }


    private Case nextCase(Random random){

        if (random.nextBoolean()){
            return smile(random);
        }
        return sad(random);
    }


    private Case smile(Random random){

        int one = random.nextInt(100);
        int two = random.nextInt(one + 1);
        int three = two + random.nextInt(100);

        return new Case(one, two, three, "smile");

    }


    private Case sad(Random random){

        int one = random.nextInt(100);
        int two = one + random.nextInt(100);
        int three = random.nextInt(two+1);

        return new Case(one, two, three, "sad");

    }

}

class Case {

    private int one;
    private int two;
    private int three;
    private String type;


    public Case(int one, int two , int three, String type){

        this.one = one;
        this.two = two;
        this.three = three;
        this.type = type;
    }


    @Override
    public String toString() {
        return "" + one + ','+ two + ',' + three +"," + type;
    }
}
