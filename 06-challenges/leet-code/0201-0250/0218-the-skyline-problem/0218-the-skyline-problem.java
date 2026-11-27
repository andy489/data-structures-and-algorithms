// https://leetcode.com/problems/the-skyline-problem/

// Solution: Sweep Line + TreeMap — O(n log n) time, O(n) space
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        TreeMap<Integer, Integer> active = new TreeMap<>();
        active.put(0, 1);
        int prevMax = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int[] e : events) {
            int x = e[0], h = e[1];
            if (h < 0) {
                active.merge(-h, 1, Integer::sum);
            } else {
                int cnt = active.get(h);
                if (cnt == 1) {
                    active.remove(h);
                } else {
                    active.put(h, cnt - 1);
                }
            }
            int currMax = active.lastKey();
            if (currMax != prevMax) {
                result.add(List.of(x, currMax));
                prevMax = currMax;
            }
        }
        return result;
    }
}
