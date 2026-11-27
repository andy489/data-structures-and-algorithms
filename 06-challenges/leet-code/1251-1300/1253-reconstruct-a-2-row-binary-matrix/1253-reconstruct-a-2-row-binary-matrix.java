// https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

// Solution: Greedy — O(n) time, O(n) space
// Solution: Greedy — O(n) time, O(n) space
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[] row0 = new int[n], row1 = new int[n];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) { row0[i] = row1[i] = 1; upper--; lower--; }
            if (upper < 0 || lower < 0) return new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) { row0[i] = 1; upper--; }
                else { row1[i] = 1; lower--; }
            }
        }
        if (upper != 0 || lower != 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> r0 = new ArrayList<>(), r1 = new ArrayList<>();
        for (int x : row0) r0.add(x);
        for (int x : row1) r1.add(x);
        res.add(r0); res.add(r1);
        return res;
    }
}
