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
    String measureWidth;
    String measureLength;
    String measureDepth;
    String measureDensity;
    String measureCase;
    
    public Calc(
            String mWidth, String mLength, String mDepth, String mDensity, String mCase, 
            double w, double l, double dep, double den, double c
    ){
        measureWidth = mWidth;
        measureLength = mLength;
        measureDepth = mDepth;
        measureDensity = mDensity;
        measureCase = mCase;
        
        // width
        switch(measureWidth){
            case "м":
                width = (w * 100);
                break;
            case "см":
                width = w;
                break;
            case "мм":
                width = (w / 10);
                break;
        }
        
        // length
        switch(measureLength){
            case "м":
                length = (l * 100);
                break;
            case "см":
                length = l;
                break;
            case "мм":
                length = (l / 10);
                break;
        }
        
        // depth
        switch(measureDepth){
            case "м":
                depth = (dep * 100);
                break;
            case "см":
                depth = dep;
                break;
            case "мм":
                depth = (dep / 10);
                break;
        }
        
        //density 
        switch(measureDensity){
            case "г/см3":
                density = den;
                break;
            case "кг/см3":
                density = (den * 1000);
                break;                
        }
        
        // caseVolume
        switch(measureCase){
            case "мл":
                caseVolume = c;
                break;
            case "л":
                caseVolume = (c * 1000);
                break;
            case "г":
                caseVolume = (c / density);
                break;
            case "кг":
                caseVolume = ( (c * 1000) / density );
                break;
        }
        
    }
    
    public double totalWeight(){
        return ( (width*length*depth)*density ) / 1000;
    }
    
    public double totalNumberOf(){
        return (width*length*depth) / caseVolume;
    }
}
