package tech.feily.matrix;

/*
 * @author Feily Zhang
 * @version 1.0
 */
public class Matrix {

    /*
     * Multiplication of two matrices.
     * 
     * The function of parameter row and col is to get a row of the first matrix 
     * and the corresponding column of the second matrix.
     * 
     * @param array1 The first matrix array.
     * @param array2 Second matrix arrays.
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.0
     */
    public static ReturnValue multiply(double[][] array1, double[][] array2) {
        
        ReturnValue returnValue = new ReturnValue();
        double[][] result = new double[array1.length][array2[0].length];
        
        if (array1[0].length == array2.length) {
            double[] row, col;
            for (int a = 0; a < array1.length; a++) {
                row = getRowValue(array1, a);   //The loop gets the value of a row.
                for (int j = 0; j < result.length; j++) {
                    col = getColValue(array2, j);   //The loop gets the value of a column.
                    for (int i = 0; i < row.length; i++) {
                        result[a][j] += row[i] * col[i];    //Traverses rows and columns and multiplies the results.
                    }
                }
            }
            returnValue.setCode(200);
        } else {
            returnValue.setCode(500);
        }
        returnValue.setResult(result);
        returnValue.setFormatResult(formatResult(result));
        return returnValue;
    }
    
    /*
     * The addition of two matrices.
     * 
     * @param array1 The first matrix array.
     * @param array2 Second matrix arrays.
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.0
     */
    public static ReturnValue add(double[][] array1, double[][] array2) {
        ReturnValue returnValue = new ReturnValue();
        if ((array1.length == array2.length) && (array1[0].length == array2[0].length)) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1[0].length; j++) {
                    array1[i][j] = array1[i][j] + array2[i][j];
                }
            }
            returnValue.setCode(200);
            returnValue.setResult(array1);
        } else {
            returnValue.setCode(500);
        }
        returnValue.setResult(array1);
        returnValue.setFormatResult(formatResult(array1));
        return returnValue;
    }
    
    /*
     * Two matrix subtraction.
     * 
     * @param array1 The first matrix array.
     * @param array2 Second matrix arrays.
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.0
     */
    public static ReturnValue sub(double[][] array1, double[][] array2) {
        ReturnValue returnValue = new ReturnValue();
        if ((array1.length == array2.length) && (array1[0].length == array2[0].length)) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1[0].length; j++) {
                    array1[i][j] = array1[i][j] - array2[i][j];
                }
            }
            returnValue.setCode(200);
        } else {
            returnValue.setCode(500);
        }
        returnValue.setResult(array1);
        returnValue.setFormatResult(formatResult(array1));
        return returnValue;
    }
    
    /*
     * A number multiplied by a matrix.
     * 
     * @param number
     * @param array2
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.0
     */
    public static ReturnValue numberMultiply(double number, double[][] array) {
        ReturnValue returnValue = new ReturnValue();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = number * array[i][j];
            }
        }
        returnValue.setCode(200);
        returnValue.setResult(array);
        returnValue.setFormatResult(formatResult(array));
        return returnValue;
    }
    
    /*
     * The row of the first matrix is obtained in matrix multiplication.
     * 
     * @param array The first matrix, needs to get the row of the matrix.
     * @param haveArray1RowIndex The index of a row and gets a row based on that index.
     * @return Return to the line.
     * @since 1.0.0
     */
    public static double[] getRowValue(double[][] array, int haveArray1RowIndex){
        double[] row = new double[array[0].length];
        for (int i = 0; i < row.length; i++) {
            if (haveArray1RowIndex < row.length) {
                row[i] = array[haveArray1RowIndex][i];
            } else {
                break;
            }
        }
        return row;
    }

    /*
     * The column of the second matrix is obtained in matrix multiplication.
     * 
     * @param array The second matrix, needs to get the column of the matrix.
     * @param haveArray2ColIndex The index of a col and gets a col based on that index.
     * @return Return to the column.
     * @since 1.0.0
     */
    public static double[] getColValue(double[][] array, int haveArray2ColIndex) {
        double[] col = new double[array.length];
        for (int i = 0; i < col.length; i++) {
            if (haveArray2ColIndex < col.length) {
                col[i] = array[i][haveArray2ColIndex];
            } else {
                break;
            }
        }
        return col;
    }
    
    /*
     * Formatting matrix.
     * 
     * @param array A matrix that needs to be formatted.
     * @return Returns the matrix after formatting.
     * @since 1.0.0
     */
    public static StringBuffer formatResult(double[][] array) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (j == array[0].length - 1){
                    stringBuffer.append(array[i][j] + "|" + "\n");
                } else if (j == 0) {
                    stringBuffer.append("|" + array[i][j] + " ");
                } else {
                    stringBuffer.append(array[i][j] + " ");
                }
            }
        }
        return stringBuffer;
    }
    
}
