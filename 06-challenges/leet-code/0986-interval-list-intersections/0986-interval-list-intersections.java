// https://leetcode.com/problems/interval-list-intersections/

// Solution: Two Pointers — O(m+n) time, O(1) space
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) { res.add(new int[]{lo, hi}); }
            if (firstList[i][1] < secondList[j][1]) { i++; }
            else { j++; }
        }
        return res.toArray(new int[0][]);
    }
}
