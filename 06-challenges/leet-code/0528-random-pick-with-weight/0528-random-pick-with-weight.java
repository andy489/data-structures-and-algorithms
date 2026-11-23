// https://leetcode.com/problems/random-pick-with-weight/

// Solution: Prefix Sum + Binary Search — O(n) build, O(log n) per pick
class Solution {
    private int[] prefixSums;
    private int totalWeight;
    private Random rand;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        prefixSums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + w[i];
        }
        totalWeight = prefixSums[w.length - 1];
        rand = new Random();
    }

    public int pickIndex() {
        int target = rand.nextInt(totalWeight) + 1;
        int lo = 0, hi = prefixSums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (prefixSums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
