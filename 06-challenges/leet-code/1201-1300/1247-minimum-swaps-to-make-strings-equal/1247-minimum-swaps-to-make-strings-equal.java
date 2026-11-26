// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/

// Solution: Counting — O(n) time, O(1) space
// Solution: Counting — O(n) time, O(1) space
class Solution {
    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') xy++;
            else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') yx++;
        }
        if ((xy + yx) % 2 != 0) return -1;
        return xy / 2 + yx / 2 + (xy % 2) * 2;
    }
}
