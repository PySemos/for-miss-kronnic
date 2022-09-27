package matrix;

import matrix.TwoDimensionalArray;

public class Matrix extends TwoDimensionalArray{

    Matrix(int [][] array_p){
        super(array_p);
    }

    Matrix(int row, int columns){
        super(row,columns);
    }

    Matrix add(Matrix otherMatrix){
        if (size[0] == otherMatrix.size[0] && size[1] == otherMatrix.size[1]){
            Matrix temp = new Matrix(size[0],size[1]);
            for(int i = 0; i<size[0];i++){
                for (int j = 0; j<size[1];j++){
                    temp.set(i,j,get(i,j) + otherMatrix.get(i,j));
                }
            }
            return temp;
        }
        else{
            throw new ArithmeticException("You can't add two matrix with size "+"("+Integer.toString(size[0])+","+Integer.toString(size[1])+")" + " and size " +"("+Integer.toString(otherMatrix.size[0])+","+Integer.toString(otherMatrix.size[1])+")");
        }
    }
    
    Matrix mult(Matrix otherMatrix){
        if (size[0] == otherMatrix.size[1] && size[1] == otherMatrix.size[0]){
            Matrix temp = new Matrix(size[0],otherMatrix.size[1]);
            for (int i = 0;i<size[0];i++){
                for(int j = 0;j<otherMatrix.size[1];j++){
                    temp.set(i,j,multiplyVectors(getRow(i),otherMatrix.getColumn(j)));
                }
            }
            return temp;
        }
        else{
            throw new ArithmeticException("You can't multiply two matrix with size "+"("+Integer.toString(size[0])+","+Integer.toString(size[1])+")" + " and size " +"("+Integer.toString(otherMatrix.size[0])+","+Integer.toString(otherMatrix.size[1])+")");
        }
    }
    Matrix negative(){
        Matrix temp = new Matrix(size[0],size[1]);
        for(int i = 0;i<size[0];i++){
            for(int j = 0;j<size[1];j++){
                temp.set(i,j,-1*get(i,j));
            }
        }
        return temp;
    }
    Matrix sub(Matrix otherMatrix){
        return add(otherMatrix.negative());
    }

    Matrix adyacent(int row,int col){
        Matrix temp = new Matrix(size[0]-1,size[1]-1);
        int x = 0;
        int y = 0;
        for(int i = 0;i<size[0];i++){
            x = 0;
            if (i == row){
                continue;
            }
            for(int j = 0;j<size[0];j++){
                if(j == col){
                    if (j == size[0]-1){
                        y++;
                    }
                    continue;
                }
                else{
                    temp.set(y,x,get(i,j));
                    x++;
                }
                if (j == size[0]-1){
                    y++;
                }
            }
        }
        return temp;
    }
    float determinant(Matrix otherMatrix){
        if (otherMatrix.size[0] == otherMatrix.size[1]){
            if (otherMatrix.size[0] == 1){
                 throw new ArithmeticException("The size must be greater or equal than 2");
            }
            if (otherMatrix.size[0] == 2){
                return otherMatrix.get(0,0)*otherMatrix.get(1,1)-otherMatrix.get(0,1) * otherMatrix.get(1,0);
            }
            else{
                int sum = 0;
                int [] firstRow = otherMatrix.getRow(0);
                for(int i = 0;i< firstRow.length;i++){
                    sum+=(Math.pow(-1,1+(i+1)) * firstRow[i] * otherMatrix.determinant(otherMatrix.adyacent(0,i)));
                }
                return sum;
            }
        }
        else{
            throw new ArithmeticException("It's not a square matrix");
        }
        
    }

    Matrix scalarMult(float scalar){
        Matrix temp = new Matrix(size[0],size[1]);
        for(int i = 0;i<size[0];i++){
            for(int j = 0;j<size[1];j++){
                temp.set(i,j,(int)scalar * get(i,j));
            }
        }
        return temp;
    }

    Matrix transpose(){
        Matrix temp = new Matrix(size[1],size[0]);
        for(int j = 0;j<size[1];j++){
            temp.setRow(j,getColumn(j));
        }
        return temp;
    }
    }




