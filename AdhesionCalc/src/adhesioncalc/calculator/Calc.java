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
        if(measureWidth.equals("м"))
          width = (w * 100);
        else if(measureWidth.equals("см"))
            width = w;
        else // if(measureDepth.equals("мм"))
            width = (w / 10);
        
        // length
        if(measureLength.equals("м"))
          length = (l * 100);
        else if(measureLength.equals("см"))
            length = l;
        else // if(measureDepth.equals("мм"))
            length = (l / 10);
        
        // depth
        if(measureDepth.equals("м"))
          depth = (l * 100);
        else if(measureDepth.equals("см"))
            depth = l;
        else // if(measureDepth.equals("мм"))
            depth = (l / 10);
        
        //density 
        if(measureDensity.equals("г/см3"))
          density = den;
        else // if(measureDensity.equals("кг/см3"))
            density = (den * 1000);
        
        // caseVolume
        if(measureCase.equals("мл"))
            caseVolume = c;
        else if(measureCase.equals("л"))
            caseVolume = (c * 1000);
        else if(measureCase.equals("г"))
            caseVolume = (c / density);
        else //if(measureCase.equals("кг"))
            caseVolume = ( (c * 1000) / density );
    }
    
    public double totalWeight(){
        return (width*length*depth)*density;
    }
    
    public double totalNumberOf(){
        return (width*length*depth) / caseVolume;
    }
}
