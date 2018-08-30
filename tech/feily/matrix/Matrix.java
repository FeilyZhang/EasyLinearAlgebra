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
     * Transpose the matrix.
     * 
     * @param array Matrix that needs to be transposed.
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.1
     */
    public static ReturnValue transpose(double[][] array) {
        int rowIndex, colIndex;
        double rowValue, colValue;
        int rowFlag = 0, colFlag = 0, index = -1;
        ReturnValue returnValue = new ReturnValue();
        if (array.length == array[0].length) {
            while(true) {
                if (index == array.length - 1) {
                    break;
                } else {
                    ++index;
                    ++rowFlag;
                    ++colFlag;
                    rowIndex = rowFlag;
                    colIndex = colFlag;
                    while(true) {    //每次循环交换index行列
                        if (rowIndex != array.length && colIndex != array.length) {
                            rowValue = array[index][rowIndex];    //获取行值
                            colValue = array[colIndex][index];    //获取列值
                            array[index][rowIndex] = colValue;
                            array[colIndex][index] = rowValue;    //交换行与列
                            ++rowIndex;
                            ++colIndex;
                        } else break;
                    }
                }
            }
            returnValue.setCode(200);
        } else {
            returnValue.setCode(500);
        }
        returnValue.setResult(array);
        returnValue.setFormatResult(formatResult(array));
        return returnValue;
    }
    
    /*
     * Create digital matrix.
     * 
     * @param number.
     * @param row
     * @param col
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.1
     */
    public static ReturnValue createNumMatrix(int number, int row, int col) {
        ReturnValue returnValue = new ReturnValue();
        double[][] result = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = number;
            }
        }
        returnValue.setCode(200);
        returnValue.setResult(result);
        returnValue.setFormatResult(formatResult(result));
        return returnValue;
    }
    
    /*
     * Create unit matrix.
     * 
     * @param steps
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.1
     */
    public static ReturnValue createUnitMatrix(int steps) {
        ReturnValue returnValue = new ReturnValue();
        double[][] result = new double[steps][steps];
        for (int i = 0; i < steps; i++) {
            result[i][i] = 1;
        }
        returnValue.setCode(200);
        returnValue.setResult(result);
        returnValue.setFormatResult(formatResult(result));
        return returnValue;
    }
    
    /*
     * Create random matrix.
     * 
     * @param row
     * @param col
     * @param bit
     * @param values
     * @return The return value is the JavaBean class that contains the final result array.
     * @since 1.0.1
     */
    public static ReturnValue createRandomMatrix(int row, int col, int bit, int bits, double... values) {
        ReturnValue returnValue = new ReturnValue();
        double[][] result = new double[row][col];
        double temp = 0;
        if (values.length == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result[i][j] = Math.random() * bit;
                }
            }
            returnValue.setCode(200);
        } else if (values.length == 2 && values[0] < values[1]) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    temp = Math.random() * bit;
                    while(true) {
                        if (values[0] < temp && temp < values[1]) {
                            result[i][j] = temp;
                            break;
                        } else {
                            temp = Math.random() * bit;
                        }
                    }
                }
            }
            returnValue.setCode(200);
        } else {
            returnValue.setCode(500);
        }
        result = format(result, bits);
        returnValue.setResult(result);
        returnValue.setFormatResult(formatResult(result));
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
            row[i] = array[haveArray1RowIndex][i];
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
            col[i] = array[i][haveArray2ColIndex];
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

    /*
     * Reduced floating-point numbers.
     * 
     * @param array Need to be streamlined floating-point array.
     * @param number
     * @return Returns the matrix after formatting.
     * @since 1.0.2
     */
    public static double[][] format(double[][] array, int number) {
        String first, second;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                first = String.valueOf(array[i][j]).split("\\.")[0];
                second = String.valueOf(array[i][j]).split("\\.")[1].substring(0, number);
                array[i][j] = Double.parseDouble(first + '.' + second);
            }
        }
        return array;
    }
    
}
