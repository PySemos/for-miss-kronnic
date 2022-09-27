package matrix;

import matrix.TwoDimensionalArray;
import matrix.Matrix;

public class Test{
    public static void main(String []args){
        int[][] a = {
            {4,3,4},
            {2,6,7}};
        /*int[][] b = {
            {1,1,1},
            {1,1,1},
            {1,1,1},
        };*/
        Matrix m = new Matrix(a);
        /* Matrix n = new Matrix(b);
        m.sub(n).print(); *//* 
        System.out.println(m.size[0]);
        System.out.println(m.size[1]); */
        //System.out.println(m.determinant(m));
        //System.out.println(m.determinant(m));
        /* m.adyacent(0,3).print(); */
        /* m.scalarMult(2).print(); */
        m.transpose().print();

    }
}


