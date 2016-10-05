package areo;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by gta on 02.10.16.
 */
public class MLTests extends TestCase {


    @Test
    public void test1MArffLarge(){

    }

    @Test
    @Ignore
    public void testBigArffFile() throws IOException {

        DataLoader loader = new DataLoader();
        Instances data = loader.loadFromArff("big.arff");

        assertNotNull(data);
    }

    @Test
    public void testLearn() throws Exception {

        DataLoader loader = new DataLoader();
        Instances data = loader.loadFromArff("ready1M.arff");


        Classifier classifier = new J48();
        classifier.buildClassifier(data);

        Instance testInstance = new DenseInstance(1.0, new double[] {1000.0, 2000.0, 1000.0});

        testInstance.setDataset(data);

        double[] distr = classifier.distributionForInstance(testInstance);

        final double cluster = classifier.classifyInstance(testInstance);

        assertEquals(1.0, cluster);


    }
}
