// https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/

// Solution: Backtracking — O(m^n) time, O(n) space
class Solution {
    static int[][] ROOK_DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] BISHOP_DIRS = {{1,1},{1,-1},{-1,1},{-1,-1}};
    static int[][] QUEEN_DIRS = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;
        List<int[][]> allMoves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allMoves.add(getMoves(pieces[i], positions[i]));
        }
        return backtrack(positions, allMoves, new int[n][], 0);
    }

    private int backtrack(int[][] start, List<int[][]> allMoves, int[][] chosen, int idx) {
        int n = start.length;
        if (idx == n) { return valid(start, chosen) ? 1 : 0; }
        int res = 0;
        for (int[] move : allMoves.get(idx)) {
            chosen[idx] = move;
            res += backtrack(start, allMoves, chosen, idx + 1);
        }
        return res;
    }

    private boolean valid(int[][] start, int[][] targets) {
        int n = start.length;
        int[] r = new int[n], c = new int[n];
        int[] tr = new int[n], tc = new int[n];
        int[] dr = new int[n], dc = new int[n];
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            r[i] = start[i][0]; c[i] = start[i][1];
            tr[i] = targets[i][0]; tc[i] = targets[i][1];
            dr[i] = Integer.signum(tr[i] - r[i]);
            dc[i] = Integer.signum(tc[i] - c[i]);
        }
        for (int t = 0; t < 8; t++) {
            for (int i = 0; i < n; i++) {
                if (!done[i]) { r[i] += dr[i]; c[i] += dc[i]; if (r[i] == tr[i] && c[i] == tc[i]) { done[i] = true; } }
            }
            for (int i = 0; i < n; i++) { for (int j = i + 1; j < n; j++) { if (r[i] == r[j] && c[i] == c[j]) { return false; } } }
        }
        return true;
    }

    private int[][] getMoves(String piece, int[] pos) {
        int[][] dirs = piece.equals("rook") ? ROOK_DIRS : piece.equals("bishop") ? BISHOP_DIRS : QUEEN_DIRS;
        List<int[]> moves = new ArrayList<>();
        moves.add(new int[]{pos[0], pos[1]});
        for (int[] d : dirs) {
            for (int r = pos[0] + d[0], c = pos[1] + d[1]; r >= 1 && r <= 8 && c >= 1 && c <= 8; r += d[0], c += d[1]) {
                moves.add(new int[]{r, c});
            }
        }
        return moves.toArray(new int[0][]);
    }
}
