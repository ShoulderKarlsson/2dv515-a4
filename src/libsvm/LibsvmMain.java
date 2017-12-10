package libsvm;

import libsvm.*;
import weka.classifiers.Classifier;

public class LibsvmMain {
    private final String fileName;
    private Classifier cl;

    LibsvmMain(String fileName) {
        this.fileName = fileName;
    }

    private void readDate() {

    }




//    private double distance(double[] v1, double[] v2) {
//        double sumSq = 0;
//        for (int i = 0; i < v1.length; i++) {
//            sumSq += Math.pow(v1[i] - v2[i], 2);
//        }
//
//        return Math.sqrt(sumSq);
//    }
//
//    private double classify_Euclidian(Instance i) {
//        Centerpoint best = null;
//        double bestDist = Double.MAX_VALUE;
//        double[] point = new double[1];
//        for (Centerpoint cp : points) {
//            double[] avg = cp.toArray();
//            double cDist = distance(avg, point);
//
//            if (cDist < bestDist) {
//                bestDist = cDist;
//                best = cp;
//            }
//        }
//
//
//        return best.class_value;
//    }
//
//    private double dotProduct(double[] v1, double[] v2) {
//        double sum = 0;
//
//        for (int i = 0; i < v1.length; i++) {
//            sum += v1[i] * v2[i];
//        }
//
//        return sum;
//    }
//
//
//    private double classify_dp(Instance i) {
//        double[] M0 = points.get(0).toArray();
//        double[] M1 = points.get(1).toArray();
//
////        double[] X = i.getAttributeArrayNumerical();
//        // TODO: Should be with assignment above.
//        double[] X = new double[1];
//
//        double b = (dotProduct(M1, M1) - dotProduct(M0, M0)) / 2;
//        double y = dotProduct(X, M0) - dotProduct(X, M1) + b;
//
//        if (y > 0) return points.get(0).class_value;
//        else return points.get(1).class_value;
//    }
//    private class Centerpoint {
//     public double[] sums;
//     public int[] cnts;
//     public double class_value;
//     public int n;
//
//     public Centerpoint(double class_value, int n) {
//         this.n = n;
//         this.class_value = class_value;
//     }
//
//
//     public double getAvg(int attr) {
//         return sums[attr] / (double)cnts[attr];
//     }
//
//     public double[] toArray() {
//         double[] vals = new double[n];
//
//         for (int i = 0; i < vals.length; i++) {
//             vals[i] = getAvg(i);
//         }
//
//         return vals;
//     }
//
//    }






















}
