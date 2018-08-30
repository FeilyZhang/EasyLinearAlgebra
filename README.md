# EasyMatrix
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

# Version updating, adding transpose matrix and creating matrix function(August 2018 26)
### Creating matrix and matrix transposition
```
package tech.feily.matrix;

/*
 * @author Feily Zhang
 */
public class Example {

    public static void main(String[] args) {
        ReturnValue returnValue = Matrix.createRandomMatrix(5, 5, 10);
        System.out.println("Before transpose:\n" + returnValue.getFormatResult());
        ReturnValue returnValue1 = Matrix.transpose(returnValue.getResult());
        System.out.println("After transpose:\n" + returnValue1.getFormatResult());
    }

}
```
The result of operation is
```
Before transpose:
|4.256083321630733 7.237620037320878 1.428711859325268 5.181977122167233 3.985996025777523|
|8.845434718817764 3.1289377795729534 6.503690322532032 3.101300291009567 0.6198192696201366|
|0.8517771517847028 2.7399105853287207 0.4629279950131704 0.25754508017358013 3.9810023187252206|
|4.985777279137807 0.18102263209712977 7.629983876953203 5.080280072967823 5.218849247745672|
|6.821113629825613 1.1148783110294758 0.9371340943432904 0.33744537797002705 4.458796385590409|

After transpose:
|4.256083321630733 8.845434718817764 0.8517771517847028 4.985777279137807 6.821113629825613|
|7.237620037320878 3.1289377795729534 2.7399105853287207 0.18102263209712977 1.1148783110294758|
|1.428711859325268 6.503690322532032 0.4629279950131704 7.629983876953203 0.9371340943432904|
|5.181977122167233 3.101300291009567 0.25754508017358013 5.080280072967823 0.33744537797002705|
|3.985996025777523 0.6198192696201366 3.9810023187252206 5.218849247745672 4.458796385590409|
```

# Version updating, Reduced floating-point numbers(August 2018 30)
```
package tech.feily.matrix;

/*
 * @author Feily Zhang
 */
public class Example {

    public static void main(String[] args) {
        ReturnValue returnValue = Matrix.createRandomMatrix(5, 5, 10, 2);
        System.out.println("Before transpose:\n" + returnValue.getFormatResult());
        ReturnValue returnValue1 = Matrix.transpose(returnValue.getResult());
        System.out.println("After transpose:\n" + returnValue1.getFormatResult());
    }

}
```
The result of operation is
```
Before transpose:
|7.4 5.03 0.39 4.31 5.26|
|2.0 8.19 4.49 5.76 7.53|
|4.49 4.29 1.78 2.16 3.75|
|1.91 5.48 0.38 2.57 1.0|
|7.02 4.57 2.95 1.3 1.9|

After transpose:
|7.4 2.0 4.49 1.91 7.02|
|5.03 8.19 4.29 5.48 4.57|
|0.39 4.49 1.78 0.38 2.95|
|4.31 5.76 2.16 2.57 1.3|
|5.26 7.53 3.75 1.0 1.9|
```

to be continued......
