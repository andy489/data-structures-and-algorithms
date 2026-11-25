// https://leetcode.com/problems/card-flipping-game/

// Solution: Set of Same-Face Cards — O(n) time, O(n) space
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!same.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            if (!same.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
