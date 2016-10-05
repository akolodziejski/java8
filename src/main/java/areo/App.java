package areo;

import weka.core.FastVector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArffGenerator generator  = new ArffGenerator();

        generator.generate(1000000, "big1M.arff");

    }

}
