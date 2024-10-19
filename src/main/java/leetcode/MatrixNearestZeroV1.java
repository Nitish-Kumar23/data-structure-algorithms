package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MatrixNearestZeroV1 {

    /** BFS from o to 1**/
    public int[][] updateMatrix(int[][] mat) {
        int[][] response = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    response[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(mat, visited, response, queue);

        return response;
    }

    private void bfs(int[][] mat, boolean[][] visited, int[][] response, Queue<int[]> queue) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int[] d : directions) {
                int newRow = arr[0] + d[0];
                int newCol = arr[1] + d[1];
                if (!validBoundaries(newRow, newCol, mat)) {
                    continue;
                }

                if (mat[newRow][newCol] == 0) {
                    continue;
                }

                if (response[arr[0]][arr[1]] + 1 < response[newRow][newCol]) {
                    response[newRow][newCol] = response[arr[0]][arr[1]] + 1;
                    if (!visited[newRow][newCol]) {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }

        }
    }

    private boolean validBoundaries(int row, int col, int[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }

    public int[][] updateMatrixV1(int[][] mat) {
        int[][] response = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    response[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        bfsV1(mat, response, queue);

        return response;
    }

    private void bfsV1(int[][] mat, int[][] response, Queue<int[]> queue) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int[] d : directions) {
                int newRow = arr[0] + d[0];
                int newCol = arr[1] + d[1];
                if (!validBoundaries(newRow, newCol, mat)) {
                    continue;
                }

                if (mat[newRow][newCol] == 0) {
                    continue;
                }

                if (response[arr[0]][arr[1]] + 1 < response[newRow][newCol]) {
                    response[newRow][newCol] = response[arr[0]][arr[1]] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }

        }
    }

}