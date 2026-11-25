// https://leetcode.com/problems/convert-to-base-2/

// Solution: Repeated Division — O(log n) time, O(log n) space
class Solution {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int rem = n % (-2);
            n /= (-2);
            if (rem < 0) {
                rem += 2;
                n++;
            }
            sb.append(rem);
        }
        return sb.reverse().toString();
    }
}
