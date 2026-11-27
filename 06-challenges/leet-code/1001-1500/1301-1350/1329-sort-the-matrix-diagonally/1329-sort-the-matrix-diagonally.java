// https://leetcode.com/problems/sort-the-matrix-diagonally/

// Solution: Group by diagonal — O(m*n*log(min(m,n))) time, O(m*n) space
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> diags = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diags.computeIfAbsent(i-j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }
        for (List<Integer> d : diags.values()) Collections.sort(d);
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int pos = idx.getOrDefault(key, 0);
                mat[i][j] = diags.get(key).get(pos);
                idx.put(key, pos+1);
            }
        }
        return mat;
    }
}
