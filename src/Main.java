import bayers.BayersMain;
import decisiontree.DecisionTreeMain;
import nn.NN;
public class Main {

    public static void main(String[] args) {
//        BayersMain bm = new BayersMain("./src/resources/wikipedia_70.arff");
//        bm.train();
//        bm.test();

//        DecisionTreeMain dtm = new DecisionTreeMain("./src/resources/FIFA_skill.arff");
//        dtm.train();
//        dtm.test();

        NN nn = new NN("./src/resources/matchmaker_fixed.arff");
        nn.train();
        nn.test();
    }
}
