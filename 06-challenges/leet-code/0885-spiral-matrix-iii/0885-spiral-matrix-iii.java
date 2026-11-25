// https://leetcode.com/problems/spiral-matrix-iii/

// Solution: Simulation — O(max(r,c)^2) time, O(r*c) space
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] result = new int[rows * cols][2];
        int r = rStart, c = cStart, dir = 0, steps = 1, count = 0;
        while (count < rows * cols) {
            for (int rep = 0; rep < 2; rep++) {
                for (int s = 0; s < steps; s++) {
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[]{r, c};
                    }
                    r += dirs[dir][0];
                    c += dirs[dir][1];
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
        return result;
    }
}
