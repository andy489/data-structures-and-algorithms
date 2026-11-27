// https://leetcode.com/problems/make-sum-divisible-by-p/

// Solution: Prefix Sum + HashMap — O(n) time, O(n) space
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalMod = 0;
        for (int x : nums) {
            totalMod = (totalMod + x) % p;
        }
        if (totalMod == 0) return 0;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        lastSeen.put(0, -1);
        int prefMod = 0, minLen = n;
        for (int i = 0; i < n; i++) {
            prefMod = (prefMod + nums[i]) % p;
            int need = (prefMod - totalMod + p) % p;
            if (lastSeen.containsKey(need)) {
                minLen = Math.min(minLen, i - lastSeen.get(need));
            }
            lastSeen.put(prefMod, i);
        }
        return minLen == n ? -1 : minLen;
    }
}
