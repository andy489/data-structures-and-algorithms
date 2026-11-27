// https://leetcode.com/problems/minimize-the-maximum-adjacent-element-difference/

// Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        // Base: max diff between adjacent non-(-1) elements
        int base = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != -1 && nums[i + 1] != -1) {
                base = Math.max(base, Math.abs(nums[i] - nums[i + 1]));
            }
        }

        // Check if all elements are -1 (no constraints from fixed neighbors)
        boolean allMissing = true;
        for (int x : nums) {
            if (x != -1) {
                allMissing = false;
                break;
            }
        }
        if (allMissing) {
            return 0;
        }

        int lo = base, hi = (int) 2e9;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(nums, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean feasible(int[] nums, int d) {
        int n = nums.length;
        // For each run of -1s flanked by real values a (left) and b (right):
        // We need x,y s.t. one covers [a-d,a+d] and one covers [b-d,b+d],
        // and |x-y| <= d. This is feasible iff |a-b| <= 2*d.
        // Additionally collect the tightest intersection of intervals that x must cover
        // when no second value is needed (gap has only one real neighbor).

        // Traverse and track interval constraints for x (the "primary" value).
        // For each gap: left boundary la=a, right boundary rb=b.
        // Constraint: either x in [a-d,a+d] and x in [b-d,b+d] (single value),
        // or x in [a-d,a+d] and y in [b-d,b+d] with y in [x-d,x+d].
        // Both collapse to: max(a,b)-d <= x <= min(a,b)+d OR |a-b|<=2d if using two values.

        // Collect all one-sided constraints (gaps with only one real neighbor).
        int xLo = 1, xHi = (int) 2e9;

        int i = 0;
        while (i < n) {
            if (nums[i] == -1) {
                i++;
                continue;
            }
            // Find next real value
            int j = i + 1;
            while (j < n && nums[j] == -1) {
                j++;
            }
            if (j < n) {
                int a = nums[i], b = nums[j];
                if (j - i == 1) {
                    // Adjacent real values already checked in base
                } else {
                    // Gap of (j-i-1) -1s between a and b
                    if (Math.abs(a - b) > 2 * d) {
                        return false;
                    }
                    // Tighten x to cover the intersection [max(a,b)-d, min(a,b)+d]
                    xLo = Math.max(xLo, Math.max(a, b) - d);
                    xHi = Math.min(xHi, Math.min(a, b) + d);
                }
            } else {
                // Trailing -1s after last real value: x just needs to be within d of nums[i]
                xLo = Math.max(xLo, nums[i] - d);
                xHi = Math.min(xHi, nums[i] + d);
            }
            i = j;
        }

        // Leading -1s before first real value
        int firstReal = -1;
        for (int k = 0; k < n; k++) {
            if (nums[k] != -1) {
                firstReal = k;
                break;
            }
        }
        if (firstReal > 0) {
            xLo = Math.max(xLo, nums[firstReal] - d);
            xHi = Math.min(xHi, nums[firstReal] + d);
        }

        return xLo <= xHi;
    }
}
