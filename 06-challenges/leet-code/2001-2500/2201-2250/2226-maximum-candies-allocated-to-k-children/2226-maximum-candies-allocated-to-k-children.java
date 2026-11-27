// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo = 1, hi = 0;
        for (int c : candies) {
            hi = Math.max(hi, c);
        }
        int answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAllocate(candies, k, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return answer;
    }

    private boolean canAllocate(int[] candies, long k, int m) {
        long piles = 0;
        for (int c : candies) {
            piles += c / m;
        }
        return piles >= k;
    }
}
