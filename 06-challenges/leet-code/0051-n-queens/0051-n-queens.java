// https://leetcode.com/problems/n-queens/

// Solution 1: Backtracking with Sets — O(n!) time, O(n²) space
class Solution {
    private int n;
    private int[] queens;
    private Set<Integer> cols, diag1, diag2;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        cols = new HashSet<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();
        res = new ArrayList<>();
        backtrack(0);
        return res;
    }

    private void backtrack(int row) {
        if (row == n) {
            res.add(buildBoard());
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            queens[row] = col;
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            backtrack(row + 1);
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }

    private List<String> buildBoard() {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

// Solution 2: Backtracking with Bitmasks — O(n!) time, O(n²) space
class Solution2 {
    private int n, fullMask;
    private int[] queens;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.fullMask = (1 << n) - 1;
        queens = new int[n];
        res = new ArrayList<>();
        backtrack(0, 0, 0, 0);
        return res;
    }

    private void backtrack(int row, int cols, int diag1, int diag2) {
        if (row == n) {
            res.add(buildBoard());
            return;
        }
        int available = ~(cols | diag1 | diag2) & fullMask;
        while (available != 0) {
            int bit = available & -available;
            queens[row] = Integer.numberOfTrailingZeros(bit);
            backtrack(row + 1, cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1);
            available &= available - 1;
        }
    }

    private List<String> buildBoard() {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
