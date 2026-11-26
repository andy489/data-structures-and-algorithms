// https://leetcode.com/problems/closest-divisors/

// Solution: Square root search — O(sqrt(n)) time, O(1) space
class Solution {
    public int[] closestDivisors(int num) {
        int[] best = {1, num+2};
        for (int target : new int[]{num+1, num+2}) {
            for (int a = (int)Math.sqrt(target); a >= 1; a--) {
                if (target % a == 0) {
                    int b = target / a;
                    if (b - a < best[1] - best[0]) { best[0] = a; best[1] = b; }
                    break;
                }
            }
        }
        return best;
    }
}
