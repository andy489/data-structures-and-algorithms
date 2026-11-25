// https://leetcode.com/problems/array-of-doubled-pairs/

// Solution: Sort by Absolute Value + Frequency Map — O(n log n) time, O(n) space
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr) {
            count.merge(x, 1, Integer::sum);
        }
        List<Integer> keys = new ArrayList<>(count.keySet());
        keys.sort(Comparator.comparingInt(Math::abs));
        for (int k : keys) {
            int cnt = count.get(k);
            if (cnt == 0) { continue; }
            int need = count.getOrDefault(2 * k, 0);
            if (need < cnt) { return false; }
            count.put(2 * k, need - cnt);
        }
        return true;
    }
}
