// https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/

// Solution: Frequency Count + Greedy — O(n) time, O(n) space
class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }

        int minFreq = Collections.min(freq.values());

        for (int k = minFreq; k >= 1; k--) {
            int boxes = 0;
            boolean valid = true;
            for (int f : freq.values()) {
                // Groups of size k or k+1; number of k+1 groups = f % (k+1) ... check
                // Actually: ceil(f / (k+1)) uses f/(k+1) groups of k+1 and f%(k+1) extra balls
                // which we put in groups of k — only valid if remainder * boxes fit
                int q = f / (k + 1);
                int r = f % (k + 1);
                // r balls left after q groups of (k+1); need r groups of size... but r < k+1
                // If r == 0: q groups of k+1 -> valid? No, groups are k or k+1 only
                // We need: f = a*k + b*(k+1) for non-negative a,b
                // b = f % (k+1) groups? Let b = f/(k+1), a = f - b*(k+1) groups of k needed
                // But a must be >= 0: f - b*(k+1) >= 0 always; a = f mod (k+1)
                // Wait: total boxes = ceil(f / k) if only k-sized, but here we want min boxes
                // with sizes k and k+1. min boxes = ceil(f/(k+1)).
                // ceil(f/(k+1)) = (f + k) / (k+1) groups
                // Check: f = q*(k+1) + r, need r extra balls in q+r/(k)...
                // Simpler: for group size k, check f % (k+1) is not such that it creates groups < k
                // The assignment is valid if r == 0 (all groups of size k+1) OR r >= 1 (r groups get -1 ball each from k+1 groups => size k).
                // We need f / k >= f / (k+1), which is always true.
                // Actually validity: each freq f must be splittable into groups of k and k+1 only.
                // f = a*k + b*(k+1) => f = a*k + b*k + b => f - b = (a+b)*k => b = f mod k if we let total groups = ceil(f/k) hmm
                // Proper: b = f % (k+1); if b == 0 or b >= 1 (and remaining f - r is divisible by k+1 or we adjust)...
                // Standard solution: ceil(f / (k+1)) groups, check that f % (k+1) == 0 or not
                // The key constraint: remainder r = f % (k+1); this r balls go into groups of size k.
                // Need r groups of size k: each uses k balls from the remaining r*k? No.
                // Correct check: f can be split iff f % (k+1) == 0 OR (f - (f/(k+1))*(k+1)) can be absorbed.
                // Simplest valid check: (f % (k+1)) <= f / (k+1) is NOT needed.
                // The real check: for group size k (min size), split f into groups of k or k+1.
                // This is always possible for any f >= k, via f = (f/k - r) * k + r * (k+1) where r = f%k...
                // but we need groups of size exactly k or k+1, i.e., diff <= 1.
                // So: valid if f >= k. Boxes = ceil(f/k) or we minimize:
                // No: we want MIN boxes with sizes in {k, k+1}. Min boxes = ceil(f/(k+1)).
                // Always feasible if f >= k (we can always do ceil(f/(k+1)) boxes).
                // But wait: if f = 1 and k = 2, we can't make groups of 2 or 3 from 1 ball.
                // So condition: f >= k.
                if (f < k) {
                    valid = false;
                    break;
                }
                boxes += (f + k) / (k + 1); // ceil(f / (k+1))
            }
            if (valid) {
                return boxes;
            }
        }
        return nums.length; // fallback: each ball in its own group
    }
}
