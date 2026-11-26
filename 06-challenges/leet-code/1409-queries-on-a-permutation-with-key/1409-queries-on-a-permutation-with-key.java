// https://leetcode.com/problems/queries-on-a-permutation-with-key/

// Solution: Simulation — O(m * q) time, O(m) space
class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> perm = new ArrayList<>();
        for (int i = 1; i <= m; i++) perm.add(i);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int pos = perm.indexOf(queries[i]);
            res[i] = pos + 1;
            perm.remove(pos);
            perm.add(0, queries[i]);
        }
        return res;
    }
}
