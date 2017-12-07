package bayers;

import weka.core.*;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.*;

public class BayersMain {
    private String fileName;
    private Instances data;
    private Classifier cl;

    public void init() {
        // TODO: Not sure if this is needed....
    }

    private void readData() {

    }

    public void train() {

    }

    public void test() {
        try {

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
