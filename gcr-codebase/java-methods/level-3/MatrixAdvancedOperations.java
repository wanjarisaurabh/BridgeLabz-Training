
public class MatrixAdvancedOperations {

    Method to create a random matrix

    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i rows;
        i++
            
        ) {
            for (int j = 0; j cols;
            j++
                
            ) {
                matrix[i][j] = (int) (Math.random()  9) + 1;  1
        
        
            –9
            }
        }
        return matrix;
    }

    Method to find transpose of a matrix

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] trans = new double[cols][rows];

        for (int i = 0; i rows;
        i++
            
        ) {
            for (int j = 0; j cols;
            j++
                
            ) {
                trans[j][i] = matrix[i][j];
            }
        }
        return trans;
    }

    Method to find determinant of 2x2 matrix

    public static double determinant2x2(double[][] m) {
        return (m[0][0]  m[1][1]) - (m[0][1]  m[1][0]
    
    );
    }

     Method to find determinant of 3x3 matrix

    public static double determinant3x3(double[][] m) {
        return m[0][0]  (m[1][1]  m[2][2] - m[1][2]  m[2][1])
             - m[0][1]  (m[1][0]  m[2][2] - m[1][2]  m[2][0])
             + m[0][2]  (m[1][0]  m[2][1] - m[1][1]  m[2][0]
    
    );
    }

     Method to find inverse of 2x2 matrix

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);

        if (det == 0) {
            return null;
        }

        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1]  det;
        inv[0][1] = -m[0][1]  det;
        inv[1][0] = -m[1][0]  det;
        inv[1][1] = m[0][0]  det;

        return inv;
    }

    Method to find inverse of 3x3 matrix

    public static double[][] inverse3x3(double[][] m) {

        double det = determinant3x3(m);
        if (det == 0) {
            return null;
        }

        double[][] inv = new double[3][3];

        inv[0][0] = (m[1][1]m[2][2] - m[1][2]m[2][1])  det;
        inv[0][1] = -(m[0][1]m[2][2] - m[0][2]m[2][1])  det;
        inv[0][2] = (m[0][1]m[1][2] - m[0][2]m[1][1])  det;

        inv[1][0] = -(m[1][0]m[2][2] - m[1][2]m[2][0])  det;
        inv[1][1] = (m[0][0]m[2][2] - m[0][2]m[2][0])  det;
        inv[1][2] = -(m[0][0]m[1][2] - m[0][2]m[1][0])  det;

        inv[2][0] = (m[1][0]m[2][1] - m[1][1]m[2][0])  det;
        inv[2][1] = -(m[0][0]m[2][1] - m[0][1]m[2][0])  det;
        inv[2][2] = (m[0][0]m[1][1] - m[0][1]m[1][0])  det;

        return inv;
    }

    Method to display a matrix

    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println(Inverse not possible (Determinant = 0
            ));
            return;
        }

        for (double[] row matrix) {
            for (double value row) {
                System.out.printf( % .2ft, value
            
            );
            }
            System.out.println();
        }
    }

    Main method

    public static void main(String[] args) {

        System.out.println(-- --2
        x2 Matrix ----);
        double[][] m2 = createRandomMatrix(2, 2);
        displayMatrix(m2);

        System.out.println(Determinant + determinant2x2(m2));
        System.out.println(Transpose);
        displayMatrix(transpose(m2));

        System.out.println(Inverse);
        displayMatrix(inverse2x2(m2));

        System.out.println(n---- 3x3 Matrix ----);
        double[][] m3 = createRandomMatrix(3, 3);
        displayMatrix(m3);

        System.out.println(Determinant + determinant3x3(m3));
        System.out.println(Transpose);
        displayMatrix(transpose(m3));

        System.out.println(Inverse);
        displayMatrix(inverse3x3(m3));
    }
}
