// https://leetcode.com/problems/simplified-fractions/

// Solution: GCD Check — O(n^2 log n) time, O(1) space
class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int d = 2; d <= n; d++)
            for (int num = 1; num < d; num++)
                if (gcd(num, d) == 1) res.add(num + "/" + d);
        return res;
    }
    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a%b); }
}
