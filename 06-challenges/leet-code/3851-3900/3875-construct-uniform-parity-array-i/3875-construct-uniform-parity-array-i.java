// https://leetcode.com/problems/construct-uniform-parity-array-i/

class Solution {
    public boolean constructArray(int[] nums1) {
        int odds = 0, evens = 0;
        for (int x : nums1) {
            if (x % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        // all-even: every odd needs another odd to subtract; possible if odds==0 or odds>=2
        boolean allEven = (odds == 0 || odds >= 2);
        // all-odd: every even needs an odd to subtract; possible if evens==0 or odds>=1
        boolean allOdd = (evens == 0 || odds >= 1);
        return allEven || allOdd;
    }
}
