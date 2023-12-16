package leetcode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku implements Serializable {

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char number = board[row][col];
                if (board[row][col] == '.') {
                    continue;
                }

                if (!set.add(number + " in row " + row) || !set.add(number + " in col " + col) || !set.add(number + " in row " + row / 3 + " in col " + col / 3)) {
                    return false;
                }
            }
        }
        return true;
    }

}
