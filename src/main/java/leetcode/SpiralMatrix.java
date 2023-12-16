package leetcode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix implements Serializable {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int sRow = 0, sCol = 0;
        int eRow = matrix.length - 1, eCol = matrix[0].length - 1;
        while (sRow <= eRow && sCol <= eCol) {
            if(sRow<=eRow) {
                for (int i = sCol; i <= eCol; i++) {
                    result.add(matrix[sRow][i]);
                }
                sRow++;
            }

            if(sCol<=eCol) {
                for (int i = sRow; i <= eRow; i++) {
                    result.add(matrix[i][eCol]);
                }
                eCol--;
            }

            if(sRow<=eRow ) {
                for (int i = eCol; i >= sCol; i--) {
                    result.add(matrix[eRow][i]);
                }
                eRow--;
            }

            if(sCol<=eCol) {
                for (int i = eRow; i >= sRow; i--) {
                    result.add(matrix[i][sCol]);
                }
                sCol++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {7},
                {9},
                {6}
        };
        System.out.println(spiralOrder(arr));
    }
}
