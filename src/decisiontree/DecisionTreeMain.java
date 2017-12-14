package decisiontree;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class DecisionTreeMain {
    private String fileName;
    private Instances data;
    private Classifier cl;


    public DecisionTreeMain(String fileName) {
        this.fileName = fileName;
        readData();
    }

    private void readData() {
        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource(fileName);
            data = source.getDataSet();
            data.setClassIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void train() {
        try {
            cl = new J48();
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
            System.out.println(eval.toMatrixString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        train();
        test();
    }
}
