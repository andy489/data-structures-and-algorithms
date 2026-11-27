// https://leetcode.com/problems/most-beautiful-item-for-each-query/

// Solution: Sort + Offline — O((n+q) log n) time, O(n+q) space
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int q = queries.length;
        Integer[] qi = new Integer[q];
        for (int i = 0; i < q; i++) { qi[i] = i; }
        Arrays.sort(qi, (a, b) -> queries[a] - queries[b]);
        int[] res = new int[q];
        int j = 0, maxB = 0;
        for (int idx : qi) {
            while (j < items.length && items[j][0] <= queries[idx]) { maxB = Math.max(maxB, items[j][1]); j++; }
            res[idx] = maxB;
        }
        return res;
    }
}
