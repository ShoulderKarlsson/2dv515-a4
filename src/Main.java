import bayers.BayersMain;

public class Main {

    public static void main(String[] args) {
        BayersMain bm = new BayersMain("./src/resources/wikipedia_70.arff");
        bm.train();
        bm.test();
    }
}
