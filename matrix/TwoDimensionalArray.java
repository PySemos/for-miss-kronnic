package matrix;
import java.util.ArrayList;

public class TwoDimensionalArray{
    private int[][] array;
    public int[] size = {0,0};
    public int length;

    TwoDimensionalArray(int [][] array_p){
        int lengthInside = 0;
        array = new int[array_p.length][array_p[0].length];
        for(int i = 0;i<array_p.length;i++){
            array[i] = new int[array_p[i].length];
            for(int j = 0;j<array_p[i].length;j++){
                array[i][j] = array_p[i][j];
                if (j == array_p[i].length - 1){
                    lengthInside = j+1;
                }
            }
            
        }
        size[0] = array_p.length;
        size[1] = lengthInside;
        length = lengthInside * size[0];
    }

    TwoDimensionalArray(int row,int columns){
        array = new int[row][columns];
        for (int i = 0 ; i<row;i++){
            //array[i] = new int[columns];
            for(int j = 0;j<columns;j++){
                array[i][j] = 0;
            }
        }
        size[0] = row;
        size[1] = columns;
        this.length = row * columns;
    }

    void print(){
        for (int i = 0 ;i<size[0];i++){
            for(int j = 0;j<size[1];j++){
                System.out.print( Integer.toString(array[i][j])+" ");
            }
            System.out.print("\n");
        }
    }

    int get(int row,int column){
        // The first element is 0 not 1
        return array[row][column];
    }

    void set(int row, int column, int value){
        array[row][column] = value;
    }

    void setRow(int row,int [] array_p){
        for(int i = 0; i<array_p.length;i++){
             array[row][i] = array_p[i];
        }
    }
    int[] getRow(int row){
        int [] arrayTemp = new int[size[1]];
        for (int i = 0;i<size[1];i++){
            arrayTemp[i] = array[row][i];
        }
        return arrayTemp;
    }

    int [] getColumn(int column){
        int [] arrayTemp = new int[size[0]];
        for (int i = 0;i<size[0];i++){
            arrayTemp[i] = array[i][column];
        }
        return arrayTemp;
    }
    protected int multiplyVectors(int[] vector1,int[] vector2){
        System.out.println(Integer.toString(vector1.length)  +" "+Integer.toString(vector2.length));
        if (vector1.length == vector2.length){
            int sum = 0;
            for (int i = 0; i<vector1.length;i++){
                sum+=vector1[i]*vector2[i];
            }
            return sum;
        }
        else{
            throw new ArithmeticException("error");
        }
        
    }

}