// https://leetcode.com/problems/reduce-array-size-to-the-half/

// Solution: Greedy + Sort — O(n log n) time, O(n) space
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : arr) freq.merge(v, 1, Integer::sum);
        int[] counts = freq.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(counts);
        int removed = 0, setSize = 0, half = arr.length / 2;
        for (int i = counts.length-1; i >= 0 && removed < half; i--) {
            removed += counts[i];
            setSize++;
        }
        return setSize;
    }
}
