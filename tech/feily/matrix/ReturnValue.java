package tech.feily.matrix;

/*
 * @author Feily Zhang
 * @version 1.0
 */
public class ReturnValue {
    
    int code;
    double[][] result;
    StringBuffer formatResult;
    
    public void setCode(int code) {
        this.code = code;
    }
        
    public void setResult(double[][] result) {
        this.result = result;
    }
    
    public void setFormatResult(StringBuffer formatResult) {
        this.formatResult = formatResult;
    }
    
    public double[][] getResult() {
        return result;
    }
    
    public int getCode() {
        return code;
    }
    
    public StringBuffer getFormatResult() {
        return formatResult;
    }
    
}
