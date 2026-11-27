// https://leetcode.com/problems/minimum-bitwise-or-from-grid/

class Solution {
    public int minBitwiseOR(int[][] grid) {
        Set<Integer> reachable = new HashSet<>();
        reachable.add(0);
        for (int[] row : grid) {
            Set<Integer> next = new HashSet<>();
            for (int v : reachable) {
                for (int x : row) {
                    next.add(v | x);
                }
            }
            reachable = next;
        }
        int min = Integer.MAX_VALUE;
        for (int v : reachable) {
            min = Math.min(min, v);
        }
        return min;
    }
}
