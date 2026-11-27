// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

// Solution: Frequency Sort — O(n log n) time, O(n) space
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) freq.merge(n, 1, Integer::sum);
        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);
        int unique = counts.size();
        for (int cnt : counts) {
            if (k >= cnt) { k -= cnt; unique--; }
            else break;
        }
        return unique;
    }
}
