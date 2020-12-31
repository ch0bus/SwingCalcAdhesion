package adhesioncalc.calculator;

/**
 *
 * @author chobus
 */
public class Calc {
    double width;
    double length;
    double depth;
    double density;
    double caseVolume;
    double resultWeight;
    double resultTotal;
    public Calc(double w, double l, double dep, double den, double c){
        width = w;
        length = l;
        depth = dep;
        density = den;
        caseVolume = c;        
    }
    public double totalWeight(){
        return (width*length*depth)*density;
    }
    public double totalNumberOf(){
        return (width*length*depth) / caseVolume;
    }
}
