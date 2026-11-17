// https://leetcode.com/problems/n-queens-ii/

// Solution 1: Backtracking with Bitmasks — O(n!) time, O(n) space
class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, (1 << n) - 1);
    }

    private int backtrack(int row, int cols, int diag1, int diag2, int fullMask) {
        if (cols == fullMask) return 1;
        int count = 0;
        int available = ~(cols | diag1 | diag2) & fullMask;
        while (available != 0) {
            int bit = available & -available;
            count += backtrack(row + 1, cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1, fullMask);
            available &= available - 1;
        }
        return count;
    }
}

// Solution 2: Backtracking with Sets — O(n!) time, O(n) space
class Solution2 {
    private int n, count;
    private Set<Integer> cols, diag1, diag2;

    public int totalNQueens(int n) {
        this.n = n;
        this.count = 0;
        cols = new HashSet<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();
        backtrack(0);
        return count;
    }

    private void backtrack(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            cols.add(col); diag1.add(row - col); diag2.add(row + col);
            backtrack(row + 1);
            cols.remove(col); diag1.remove(row - col); diag2.remove(row + col);
        }
    }
}
