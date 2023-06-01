import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] matrix = new int[rows][columns];
        int count = 1;
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++)
                matrix[i][j] = count++;
        }
        
        int curIdx = 0;
        for(int[] query : queries) {
            int min = rotateMatrix(matrix, query);
            answer[curIdx] = min;
            curIdx++;
            // printMatrix(matrix);
            // System.out.println();
        }
        
        return answer;
    }
    
    public void printMatrix(int[][] matrix) {
        for(int[] column : matrix) {
            System.out.println(Arrays.toString(column));
        }
    }
    
    public int rotateMatrix(int[][] matrix, int[] query) {
        int tempNum = matrix[query[0] - 1][query[1] - 1];
        int minNum = tempNum;
        
        for(int column = query[1] - 1 ; column < query[3] - 1 ; column++) {
            int temp = matrix[query[0] - 1][column + 1];
            matrix[query[0] - 1][column + 1] = tempNum;
            tempNum = temp;
            if(minNum > tempNum) minNum = tempNum;
        }
        
        for(int row = query[0] - 1 ; row < query[2] - 1 ; row++) {
            int temp = matrix[row + 1][query[3] - 1];
            matrix[row + 1][query[3] - 1] = tempNum;
            tempNum = temp;
            if(minNum > tempNum) minNum = tempNum;
        }
        
        
        for(int column = query[3] - 1 ; column > query[1] - 1 ; column--) {
            int temp = matrix[query[2] - 1][column - 1];
            matrix[query[2] - 1][column - 1] = tempNum;
            tempNum = temp;
            if(minNum > tempNum) minNum = tempNum;
        }
        
        for(int row = query[2] - 1 ; row > query[0] - 1 ; row--) {
            int temp = matrix[row - 1][query[1] - 1];
            matrix[row - 1][query[1] - 1] = tempNum;
            tempNum = temp;
            if(minNum > tempNum) minNum = tempNum;
        }

        return minNum;
    }
}

