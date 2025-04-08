package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RottingOrangesV1 {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = -1;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = freshOrangeCount(grid);
        if (fresh == 0) {
            return 0;
        }

        while (true) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!visited[i][j] && grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            if (queue.isEmpty()) {
                break;
            }

            count = count + bfs(queue, grid, visited);
        }

        fresh = freshOrangeCount(grid);
        if (fresh != 0) {
            return -1;
        }
        return count;
    }

    private int freshOrangeCount(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private int bfs(Queue<int[]> queue, int[][] grid, boolean[][] visited) {
        int count = 0;
        while (!queue.isEmpty()) {
            int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            int[] current = queue.poll();
            for (int[] arr : directions) {
                int row = current[0] + arr[0];
                int col = current[1] + arr[1];
                if (performTraversal(row, col, visited, grid)) {
                    grid[row][col] = 2;
                }
            }
        }

        return ++count;
    }

    private boolean performTraversal(int row, int col, boolean[][] visited, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == 1;
    }

    public int orangesRottingV1(int[][] grid) {
        int minutes = 0;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize rotten oranges queue and populate fresh oranges count
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            boolean newRotten = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                for (int[] delta : directions) {
                    int nr = arr[0] + delta[0];
                    int nc = arr[1] + delta[1];
                    if (performTraversal(nr, nc, grid)) {
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        freshOranges--;
                        newRotten = true;
                    }
                }
            }

            if (newRotten) {
                minutes++;
            }
        }

        return freshOranges != 0 ? -1 : minutes;

    }

    private boolean performTraversal(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }
}