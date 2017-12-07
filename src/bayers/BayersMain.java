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

    public BayersMain(String fileName) {
        this.fileName = fileName;
        readData();
    }

    private void readData() {
        System.out.println(" > Starting to read data...");
        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource(fileName);
            Instances raw = source.getDataSet();


            StringToWordVector stw = new StringToWordVector(1000);
            stw.setLowerCaseTokens(true);
            stw.setInputFormat(raw);

            data = Filter.useFilter(raw, stw);
            data.setClassIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" > Reading complete..");
    }

    public void train() {
        System.out.println(" > Training started!");
        try {
            cl = new NaiveBayesMultinomial();
            cl.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Training completed.");
    }

    public void test() {
        try {
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(cl, data, 10, new java.util.Random(1));
            System.out.println(eval.toSummaryString());
            System.out.println(eval.toMatrixString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
