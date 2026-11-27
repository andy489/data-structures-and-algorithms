// https://leetcode.com/problems/2-keys-keyboard/

// Solution: Prime Factorization — O(√n) time, O(1) space
class Solution {
    public int minSteps(int n) {
        int steps = 0;
        for (int factor = 2; factor * factor <= n; factor++) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
        }
        if (n > 1) {
            steps += n;
        }
        return steps;
    }
}
