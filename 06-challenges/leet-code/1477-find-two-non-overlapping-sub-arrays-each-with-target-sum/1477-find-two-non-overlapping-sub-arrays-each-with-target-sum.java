// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

// Solution: Prefix Sum + Sliding Window — O(n) time, O(n) space
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, INF = Integer.MAX_VALUE / 2;
        int sum = 0, left = 0, best = INF, ans = INF;
        int[] minLeft = new int[n];
        Arrays.fill(minLeft, INF);
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) sum -= arr[left++];
            if (sum == target) {
                int len = right - left + 1;
                best = Math.min(best, len);
                if (left > 0 && minLeft[left-1] != INF) ans = Math.min(ans, minLeft[left-1] + len);
            }
            minLeft[right] = best;
        }
        return ans == INF ? -1 : ans;
    }
}
