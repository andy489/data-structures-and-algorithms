// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public long sumOfGCDPairs(int[] nums) {
        int n = nums.length;
        int[] pg = new int[n];
        int maxSoFar = nums[0];
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            pg[i] = gcd(nums[i], maxSoFar);
        }
        Arrays.sort(pg);
        long sum = 0;
        int l = 0, r = n - 1;
        if (n % 2 == 1) {
            r--;
        }
        // Actually pair smallest with largest: l=0, r=n-1 going inward
        l = 0;
        r = n - 1;
        while (l < r) {
            sum += gcd(pg[l], pg[r]);
            l++;
            r--;
        }
        return sum;
    }
}
