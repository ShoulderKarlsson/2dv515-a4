import bayers.BayersMain;
import decisiontree.DecisionTreeMain;
import libsvm.LibsvmMain;
import nn.NN;
public class Main {

    public static void main(String[] args) {
        BayersMain bm = new BayersMain("./src/resources/wikipedia_70.arff");
        bm.run();

        DecisionTreeMain dtm = new DecisionTreeMain("./src/resources/FIFA_skill.arff");
        dtm.run();

        LibsvmMain svm = new LibsvmMain("./src/resources/matchmaker_fixed.arff");
        svm.run();

        NN nn = new NN("./src/resources/matchmaker_fixed.arff");
        nn.run();
    }
}
