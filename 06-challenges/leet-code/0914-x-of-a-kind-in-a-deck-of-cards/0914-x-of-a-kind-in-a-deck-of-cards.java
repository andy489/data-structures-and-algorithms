// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

// Solution: GCD of Frequencies — O(n log n) time, O(n) space
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int card : deck) {
            count[card]++;
        }
        int g = 0;
        for (int c : count) {
            if (c > 0) {
                g = gcd(g, c);
            }
        }
        return g >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
