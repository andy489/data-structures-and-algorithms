// https://leetcode.com/problems/guess-number-higher-or-lower/

// Solution: Binary Search — O(log n) time, O(1) space
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
