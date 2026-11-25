// https://leetcode.com/problems/reordered-power-of-2/

// Solution: Digit Frequency Comparison — O(log^2 n) time, O(log n) space
class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] nDigits = Integer.toString(n).toCharArray();
        Arrays.sort(nDigits);
        for (int i = 0; i < 30; i++) {
            char[] pDigits = Integer.toString(1 << i).toCharArray();
            Arrays.sort(pDigits);
            if (Arrays.equals(nDigits, pDigits)) {
                return true;
            }
        }
        return false;
    }
}
