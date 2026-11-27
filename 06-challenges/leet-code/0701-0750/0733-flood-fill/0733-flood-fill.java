// https://leetcode.com/problems/flood-fill/

// Solution: DFS — O(m·n) time, O(m·n) space
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];
        if (origColor != color) {
            dfs(image, sr, sc, origColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int origColor, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != origColor) {
            return;
        }
        image[r][c] = color;
        dfs(image, r + 1, c, origColor, color);
        dfs(image, r - 1, c, origColor, color);
        dfs(image, r, c + 1, origColor, color);
        dfs(image, r, c - 1, origColor, color);
    }
}
