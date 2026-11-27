// https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/

// Solution: LNDS on each stride — O(n log n) time, O(n) space
class Solution {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ops = 0;

        for (int r = 0; r < k; r++) {
            List<Integer> sub = new ArrayList<>();
            for (int i = r; i < n; i += k) {
                sub.add(arr[i]);
            }
            ops += sub.size() - longestNonDecreasing(sub);
        }

        return ops;
    }

    private int longestNonDecreasing(List<Integer> seq) {
        List<Integer> tails = new ArrayList<>();

        for (int x : seq) {
            // Find first tail strictly greater than x
            int lo = 0, hi = tails.size();
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (tails.get(mid) <= x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo == tails.size()) {
                tails.add(x);
            } else {
                tails.set(lo, x);
            }
        }

        return tails.size();
    }
}
