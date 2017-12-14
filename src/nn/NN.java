package nn;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class NN {
    private String fileName;
    private Instances data;
    private Classifier cl;

    public NN(String fileName) {
        this.fileName = fileName;
        readData();
    }

    private void readData() {
        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource(this.fileName);
            data = source.getDataSet();
            data.setClassIndex(7);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void train() {
        try {
            cl = new MultilayerPerceptron();
            cl.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test() {
        try {
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(cl, data, 10, new java.util.Random(1));
            System.out.println(eval.toSummaryString());

            // Crashing if displaying matrix..
            // System.out.println(eval.toMatrixString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run() {
        train();
        test();
    }
}
