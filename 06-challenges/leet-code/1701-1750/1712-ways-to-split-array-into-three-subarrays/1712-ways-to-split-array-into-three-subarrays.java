// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/

// Solution: Prefix Sum + Binary Search — O(n log n) time, O(n) space
class Solution {
    private int[] pre;

    private int lowerBound(int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (pre[mid + 1] - pre[lo - 1 + 1] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        long result = 0;
        for (int i = 0; i < n - 2; i++) {
            int leftSum = pre[i + 1];
            if (leftSum * 3 > pre[n]) {
                break;
            }
            // Find min j: mid sum >= left sum
            // mid = nums[i+1..j], sum = pre[j+1] - pre[i+1] >= leftSum
            // => pre[j+1] >= leftSum + pre[i+1]
            int lo = i + 1, hi = n - 2;
            int minJ = n;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (pre[mid + 1] - pre[i + 1] >= leftSum) {
                    minJ = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (minJ == n) {
                break;
            }
            // Find max j: right sum >= mid sum
            // right = pre[n] - pre[j+1], mid = pre[j+1] - pre[i+1]
            // => 2*pre[j+1] <= pre[n] + pre[i+1]
            lo = minJ;
            hi = n - 2;
            int maxJ = minJ - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int midSum = pre[mid + 1] - pre[i + 1];
                int rightSum = pre[n] - pre[mid + 1];
                if (midSum <= rightSum) {
                    maxJ = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            result = (result + Math.max(0, maxJ - minJ + 1)) % MOD;
        }
        return (int) result;
    }
}
