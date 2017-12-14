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
    public void run() {
        train();
        test();
    }

    private void readData() {
        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource(fileName);
            Instances raw = source.getDataSet();

            StringToWordVector stw = new StringToWordVector(10000);
            stw.setLowerCaseTokens(true);
            stw.setInputFormat(raw);

            data = Filter.useFilter(raw, stw);
            data.setClassIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void train() {
        try {
            cl = new NaiveBayesMultinomial();
            cl.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
        try {
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(cl, data, 9 + 1, new java.util.Random(1));
            System.out.println(eval.toSummaryString());
            System.out.println(eval.toMatrixString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
