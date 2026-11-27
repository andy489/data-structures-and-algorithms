// https://leetcode.com/problems/find-original-array-from-doubled-array/

// Solution: Sort and Greedy — O(n log n) time, O(n) space
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) { return new int[0]; }
        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : changed) { freq.merge(x, 1, Integer::sum); }
        int[] original = new int[changed.length / 2];
        int idx = 0;
        for (int x : changed) {
            if (freq.getOrDefault(x, 0) == 0) { continue; }
            freq.merge(x, -1, Integer::sum);
            if (freq.getOrDefault(2 * x, 0) == 0) { return new int[0]; }
            freq.merge(2 * x, -1, Integer::sum);
            original[idx++] = x;
        }
        return original;
    }
}
