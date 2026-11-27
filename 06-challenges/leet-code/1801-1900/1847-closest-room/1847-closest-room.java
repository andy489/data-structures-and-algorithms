// https://leetcode.com/problems/closest-room/

// Solution: Offline Sort + TreeSet — O((n + k) log n) time, O(n + k) space
class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int k = queries.length;
        Integer[] qIdx = new Integer[k];
        for (int i = 0; i < k; i++) {
            qIdx[i] = i;
        }
        Arrays.sort(qIdx, (a, b) -> queries[b][1] - queries[a][1]);
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);

        TreeSet<Integer> ids = new TreeSet<>();
        int[] ans = new int[k];
        int ri = 0;

        for (int qi : qIdx) {
            int preferred = queries[qi][0], minSize = queries[qi][1];
            while (ri < rooms.length && rooms[ri][1] >= minSize) {
                ids.add(rooms[ri][0]);
                ri++;
            }
            Integer lo = ids.floor(preferred);
            Integer hi = ids.ceiling(preferred);
            if (lo == null && hi == null) {
                ans[qi] = -1;
            } else if (lo == null) {
                ans[qi] = hi;
            } else if (hi == null) {
                ans[qi] = lo;
            } else {
                ans[qi] = (hi - preferred <= preferred - lo) ? hi : lo;
            }
        }
        return ans;
    }
}
