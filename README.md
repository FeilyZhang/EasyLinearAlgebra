# EasyLinearAlgebra
Basic operation software package for linear algebra.

# Using method
### Matrix multiplication
```
package tech.feily.matrix;

/*
 * @author Feily Zhang
 * @version 1.0
 */
public class Example {

    public static void main(String[] args) {
        double[][] array1 = {{1, 2}, {4, 5}, {7, 8}};
        double[][] array2 = {{1, 2, 1}, {1, 1, 2}};
        ReturnValue returnValue = Matrix.multiply(array1, array2);
        System.out.println("code: " + returnValue.getCode() + "\n" + "Array elements are:");
        for (double[] out : returnValue.getResult()) {
            for (double in : out) {
                System.out.println(in);
            }
        }
        System.out.println("Formatted output" + returnValue.getFormatResult());
    }

}
```
The result of operation is
```
code: 200
Array elements are:
3.0
4.0
5.0
9.0
13.0
14.0
15.0
22.0
23.0
Formatted output:
|3.0 4.0 5.0|
|9.0 13.0 14.0|
|15.0 22.0 23.0|
```
to be continued......
