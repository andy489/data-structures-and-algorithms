// https://leetcode.com/problems/avoid-flood-in-the-city/

// Solution: Greedy + TreeSet — O(n log n) time, O(n) space
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) { dryDays.add(i); res[i] = 1; }
            else {
                int lake = rains[i];
                res[i] = -1;
                if (full.containsKey(lake)) {
                    Integer day = dryDays.ceiling(full.get(lake));
                    if (day == null) return new int[]{};
                    res[day] = lake;
                    dryDays.remove(day);
                }
                full.put(lake, i);
            }
        }
        return res;
    }
}
