// https://leetcode.com/problems/bulls-and-cows/

// Solution: Single Pass with Frequency Count — O(n) time, O(1) space
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (count[s] < 0) cows++;
                if (count[g] > 0) cows++;
                count[s]++;
                count[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
