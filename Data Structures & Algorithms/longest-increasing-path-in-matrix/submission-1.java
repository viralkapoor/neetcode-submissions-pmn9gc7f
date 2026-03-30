class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] indegree = new int[n][m];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        Queue<int[]> q = new LinkedList<>();

        // Build indegree
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                        matrix[ni][nj] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                }
            }
        }

        // start with local minima
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (indegree[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int path = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            path++;

            for (int s = 0; s < size; s++) {
                int[] cell = q.poll();
                int i = cell[0], j = cell[1];

                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                        matrix[ni][nj] > matrix[i][j]) {
                        indegree[ni][nj]--;

                        if (indegree[ni][nj] == 0) {
                            q.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
        }

        return path;
    }
}