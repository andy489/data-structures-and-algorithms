// https://leetcode.com/problems/construct-uniform-parity-array-ii/

class Solution {
    public boolean constructArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int x : nums1) {
            if (x % 2 != 0) {
                minOdd = Math.min(minOdd, x);
            } else {
                minEven = Math.min(minEven, x);
            }
        }
        // all-even: no odd elements
        boolean allEven = (minOdd == Integer.MAX_VALUE);
        // all-odd: every even must have an odd smaller than it
        // => minOdd < minEven (since if minOdd < minEven, all evens > minOdd)
        boolean allOdd = (minEven == Integer.MAX_VALUE) || (minOdd != Integer.MAX_VALUE && minOdd < minEven);
        return allEven || allOdd;
    }
}
